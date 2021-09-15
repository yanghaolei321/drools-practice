package com.galaxy.droolspractice.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.galaxy.droolspractice.api.entity.RuleField;
import com.galaxy.droolspractice.infra.exception.BusinessException;
import com.galaxy.droolspractice.infra.exception.errorCode.ErrorCode;
import com.galaxy.droolspractice.mapper.RuleFieldMapper;
import com.galaxy.droolspractice.service.IRuleFieldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 规则引擎-规则变量表 ServiceImpl
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */
@Slf4j
@Service
public class RuleFieldServiceImpl extends ServiceImpl<RuleFieldMapper, RuleField> implements IRuleFieldService {


    @Override
    public List<RuleField> listByRuleId(Long ruleId) {
        List<RuleField> fieldVOList = this.list(
            new LambdaQueryWrapper<RuleField>()
                .in(RuleField::getRuleId, ruleId));

        if (CollectionUtil.isEmpty(fieldVOList)) {
            log.error("--- EngineDataUploadDTO :{} ---", ruleId);
            throw new BusinessException(ErrorCode.DATA_NOT_FOUND);
        }


        return fieldVOList;
    }


}
