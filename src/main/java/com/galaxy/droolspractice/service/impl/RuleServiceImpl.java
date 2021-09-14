package com.galaxy.droolspractice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.galaxy.droolspractice.api.entity.Rule;
import com.galaxy.droolspractice.api.model.rule.*;
import com.galaxy.droolspractice.infra.dto.IdDTO;
import com.galaxy.droolspractice.mapper.RuleMapper;
import com.galaxy.droolspractice.service.IRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;



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
    public IPage<RuleVO> page(RulePageDTO rulePageDTO) {
        return null;
    }

    @Override
    public List<RuleVO> list(RuleListDTO ruleListDTO) {
        return null;
    }

    @Override
    public RuleVO get(IdDTO idDTO) {
        return null;
    }

    @Override
    public Long save(RuleSaveDTO ruleSaveDTO) {
        return null;
    }

    @Override
    public Boolean update(RuleUpdateDTO ruleUpdateDTO) {
        return null;
    }

    @Override
    public Boolean delete(IdDTO idDTO) {
        return null;
    }
}
