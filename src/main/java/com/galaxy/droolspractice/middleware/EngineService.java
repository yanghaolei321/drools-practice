package com.galaxy.droolspractice.middleware;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.galaxy.droolspractice.api.entity.Rule;
import com.galaxy.droolspractice.api.entity.RuleField;
import com.galaxy.droolspractice.api.model.engine.BeanProxy;
import com.galaxy.droolspractice.api.model.engine.EngineDataUploadDTO;
import com.galaxy.droolspractice.enums.RuleFieldTypeEnum;
import com.galaxy.droolspractice.infra.exception.BusinessException;
import com.galaxy.droolspractice.infra.exception.errorCode.ErrorCode;
import com.galaxy.droolspractice.service.IRuleFieldService;
import com.galaxy.droolspractice.service.IRuleService;
import com.galaxy.droolspractice.utils.compile.JavaStringCompiler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
    public String uploadData(EngineDataUploadDTO engineDataUploadDTO) throws IOException, ClassNotFoundException {

        // 1 根据规则集的GUID获取到规则集的id
        Rule rule = ruleService.getByGuid(engineDataUploadDTO.getGuid());
        Long ruleId = rule.getId();

        // 2  根据规则集获取该规则集对应的所有字段
        List<RuleField> fieldList = ruleFieldService.listByRuleId(ruleId);


        // 7
        return StrUtil.EMPTY;

    }



    /**
     * 解析前端数据变成Fact对象
     *
     * @param fieldList fieldList
     * @param engineDataUploadDTO dto
     * @return fact对象
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private BeanProxy parseData(List<RuleField> fieldList, EngineDataUploadDTO engineDataUploadDTO) throws IOException, ClassNotFoundException {

        // 1 把数据库中取出的字段拼接成字符串
        String ret = transString(fieldList);

        // 2 把字符串编译成动态对象
        Map<String, byte[]> results = compiler.compile("DataDTO.java", ret);
        Class<?> clazz = compiler.loadClass("com.galaxy.droolspractice.DataDTO", results);

        // 3 json解析成Fact对象
        BeanProxy bean = (BeanProxy) JSON.toJavaObject(engineDataUploadDTO.getJsonInfo(), clazz);
        return bean;
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
            "import com.galaxy.droolspractice.api.model.engine.BeanProxy; \n" +
            "public class DataDTO implements BeanProxy{ " + "\n";

        final String postfix = "}";

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(prefix);

        fieldList.forEach(ruleField -> {

            // 3.1 修饰
            String s = "public ";

            // 3.2 获取字段类型
            RuleFieldTypeEnum fieldTypeEnum = RuleFieldTypeEnum.getByValue(ruleField.getFiledType());
            if (ObjectUtil.isNull(fieldTypeEnum)) {
                throw new BusinessException(ErrorCode.PARAM_ERROR);
            }
            s += fieldTypeEnum.getValue() + " ";

            // 3.3 获取变量名
            s += ruleField.getFiledName() + "; " + "\n";

            // 4 拼接
            stringBuffer.append(s);

        });
        stringBuffer.append(postfix);
        return stringBuffer.toString();
    }

}
