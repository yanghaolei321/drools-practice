package com.galaxy.droolspractice.middleware;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.galaxy.droolspractice.api.entity.Rule;
import com.galaxy.droolspractice.api.entity.RuleField;
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


    private final String prefix = "package com.galaxy.droolspractice;" + "\n" +
                                  "public class DataDTO{ " + "\n";
    private final String postfix = "}";

    public String uploadData(EngineDataUploadDTO engineDataUploadDTO) throws IOException,ClassNotFoundException {

        // 1 根据规则集的GUID获取到规则集的id
        Rule rule = ruleService.getOne(
            new LambdaQueryWrapper<Rule>()
                .eq(Rule::getGuid, engineDataUploadDTO.getGuid()));

        if (ObjectUtil.isNull(rule)) {
            log.error("--- EngineDataUploadDTO :{} ---", engineDataUploadDTO);
            throw new BusinessException(ErrorCode.DATA_NOT_FOUND);
        }
        Long ruleId = rule.getId();

        // 2  根据规则集获取该规则集对应的所有字段
        List<RuleField> fieldVOList = ruleFieldService.list(
            new LambdaQueryWrapper<RuleField>().in(RuleField::getRuleId, ruleId));

        if (CollectionUtil.isEmpty(fieldVOList)) {
            log.error("--- EngineDataUploadDTO :{} ---", engineDataUploadDTO);
            throw new BusinessException(ErrorCode.DATA_NOT_FOUND);
        }

        // 3 合并规则
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(prefix);

        fieldVOList.forEach(ruleField -> {

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

            log.info("Cur RuleField Id:{} Name:{}", ruleField.getId(), ruleField.getFiledName());
            log.info("Str:{}", s);

            // 4 拼接
            stringBuffer.append(s);

        });
        stringBuffer.append(postfix);
        String ret = stringBuffer.toString();
        log.info(ret);


        // 5 编译成对象
        Map<String, byte[]> results = compiler.compile("DataDTO.java", ret);
        Class<?> clazz = compiler.loadClass("com.galaxy.droolspractice.DataDTO", results);

        return StrUtil.EMPTY;

    }

}
