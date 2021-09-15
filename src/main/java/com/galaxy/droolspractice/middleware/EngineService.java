package com.galaxy.droolspractice.middleware;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.galaxy.droolspractice.api.entity.Rule;
import com.galaxy.droolspractice.api.entity.RuleField;
import com.galaxy.droolspractice.api.model.engine.EngineDataUploadDTO;
import com.galaxy.droolspractice.api.model.engine.FactBean;
import com.galaxy.droolspractice.api.model.engine.RuleExecutorResult;
import com.galaxy.droolspractice.enums.RuleFieldTypeEnum;
import com.galaxy.droolspractice.infra.exception.BusinessException;
import com.galaxy.droolspractice.infra.exception.errorCode.ErrorCode;
import com.galaxy.droolspractice.middleware.executor.RuleExecutor;
import com.galaxy.droolspractice.service.IRuleFieldService;
import com.galaxy.droolspractice.service.IRuleService;
import com.galaxy.droolspractice.utils.common.DateUtil;
import com.galaxy.droolspractice.utils.compile.JavaStringCompiler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * 引擎层-Service
 *
 * @author yanghaolei
 * @date 9/14/21 7:33 PM
 */

@Slf4j
@Service
@AllArgsConstructor
public class EngineService {


    private final IRuleService ruleService;
    private final IRuleFieldService ruleFieldService;
    private final JavaStringCompiler compiler;

    /**
     * 规则匹配-将上传数据解析 并进行匹配
     *
     * @param engineDataUploadDTO
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Boolean uploadData(EngineDataUploadDTO engineDataUploadDTO) throws IOException, ClassNotFoundException {

        // 1 根据规则集的GUID获取到规则集的id
        Rule rule = ruleService.getByGuid(engineDataUploadDTO.getGuid());
        Long ruleId = rule.getId();

        // 2  根据规则集获取该规则集对应的所有字段
        List<RuleField> fieldList = ruleFieldService.listByRuleId(ruleId);

        // 3 动态生成Fact对象 解析前端数据
        FactBean bean = parseData(fieldList, engineDataUploadDTO);
        log.info("FactBean:{}", JSON.toJSON(bean));

        // 4 动态生成Drt文件并加载到内存中
        generateRule(rule);

        // 5 引擎执行
        RuleExecutorResult ruleExecutorResult = RuleExecutor.execute(bean);
        log.info("ruleExecutorResult:{}", ruleExecutorResult);

        return Boolean.TRUE;

    }


    /**
     * 解析rule对象
     * 并渲染模版生成规则文件drt
     *
     * @param rule 规则对象
     * @return
     */
    private void generateRule(Rule rule) {
        // 1 处理数据 把数据库rule对象值解析到模版中并生成字符串
        Map<String, Object> data = new HashMap<>();
        data.put("ruleName", rule.getRuleName());
        data.put("beginTime", DateUtil.localDateTimeToStringFormat(rule.getCreateTime(), "dd-MMM-yyyy"));
        // exist
        data.put("eventType", rule.getRuleDesc());
        data.put("eval", rule.getRuleEval());

        // 2 生成字符串
        ObjectDataCompiler objectDataCompiler = new ObjectDataCompiler();
        String ruleStr = objectDataCompiler.compile(Arrays.asList(data), Thread.currentThread().getContextClassLoader().getResourceAsStream("rule-template.drt"));
        log.info(ruleStr);

        // 3 生成动态drt文件
        createOrRefreshDrlInMemory(ruleStr);
    }

    /**
     * 解析前端数据变成Fact对象
     *
     * @param fieldList           fieldList
     * @param engineDataUploadDTO dto
     * @return fact对象
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private FactBean parseData(List<RuleField> fieldList, EngineDataUploadDTO engineDataUploadDTO) throws IOException, ClassNotFoundException {

        // 1 把数据库中取出的字段拼接成字符串
        String ret = transString(fieldList);

        // 2 把字符串编译成动态对象
        Map<String, byte[]> results = compiler.compile("DataDTO.java", ret);
        Class<?> clazz = compiler.loadClass("com.galaxy.droolspractice.DataDTO", results);

        // 3 json解析成Fact对象
        FactBean bean = (FactBean) JSON.toJavaObject(engineDataUploadDTO.getJsonInfo(), clazz);
        return bean;
    }


    /**
     * 根据String格式的Drl生成Maven结构的规则
     *
     * @param ruleStr
     */
    private void createOrRefreshDrlInMemory(String ruleStr) {
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.generateAndWritePomXML(RuleExecutor.getReleaseId());
        kieFileSystem.write("src/main/resources/" + UUID.randomUUID() + ".drl", ruleStr);
        log.info("str={}", ruleStr);
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem).buildAll();
        Results results = kb.getResults();
        log.info("RuleExecutor|Results={}", JSON.toJSON(results));
        if (results.hasMessages(Message.Level.ERROR)) {
            log.error("create rule in kieFileSystem Error", kb.getResults());
            throw new IllegalArgumentException("生成规则文件失败");
        }
        doAfterGenerate(kieServices);
    }

    /**
     * 生成完毕后的清理工作，目前主要用于debug模式测试完毕后，从内存中清理掉规则文件。
     */
    private void doAfterGenerate(KieServices kieServices) {

    }


    /**
     * 把数据库中取出的字段拼接成字符串
     * 便于生成动态对象
     *
     * @param fieldList 字段
     * @return
     */
    private String transString(List<RuleField> fieldList) {

        final String prefix = "package com.galaxy.droolspractice;" + "\n" +
            "import com.galaxy.droolspractice.api.model.engine.FactBean; \n" +
            "public class DataDTO implements FactBean{ " + "\n";

        final String postfix = "}";

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(prefix);

        fieldList.forEach(ruleField -> {

            // 1 修饰
            String s = "public ";

            // 2 获取字段类型
            RuleFieldTypeEnum fieldTypeEnum = RuleFieldTypeEnum.getByValue(ruleField.getFiledType());
            if (ObjectUtil.isNull(fieldTypeEnum)) {
                throw new BusinessException(ErrorCode.PARAM_ERROR);
            }
            s += fieldTypeEnum.getValue() + " ";

            // 3 获取变量名
            s += ruleField.getFiledName() + "; " + "\n";

            // 4 拼接
            stringBuffer.append(s);

        });
        stringBuffer.append(postfix);
        return stringBuffer.toString();
    }

}
