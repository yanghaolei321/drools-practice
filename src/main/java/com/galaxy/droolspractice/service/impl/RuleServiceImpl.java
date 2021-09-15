package com.galaxy.droolspractice.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.galaxy.droolspractice.api.entity.Rule;
import com.galaxy.droolspractice.infra.exception.BusinessException;
import com.galaxy.droolspractice.infra.exception.errorCode.ErrorCode;
import com.galaxy.droolspractice.mapper.RuleMapper;
import com.galaxy.droolspractice.service.IRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * 规则引擎-规则 ServiceImpl
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */
@Slf4j
@Service
public class RuleServiceImpl extends ServiceImpl<RuleMapper, Rule> implements IRuleService {


    @Override
    public Rule getByGuid(String guid) {
        Rule rule = this.getOne(
            new LambdaQueryWrapper<Rule>()
                .eq(Rule::getGuid, guid));

        if (ObjectUtil.isNull(rule)) {
            log.error("--- DTO :{} ---", guid);
            throw new BusinessException(ErrorCode.DATA_NOT_FOUND);
        }
        return rule;
    }
}
