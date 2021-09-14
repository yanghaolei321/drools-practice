package com.galaxy.droolspractice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.galaxy.droolspractice.api.entity.RuleField;
import com.galaxy.droolspractice.api.model.rulefield.*;
import com.galaxy.droolspractice.infra.dto.IdDTO;
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
    public IPage<RuleFieldVO> page(RuleFieldPageDTO ruleFieldPageDTO) {
        return null;
    }

    @Override
    public List<RuleFieldVO> list(RuleFieldListDTO ruleFieldListDTO) {
        return null;
    }

    @Override
    public RuleFieldVO get(IdDTO idDTO) {
        return null;
    }

    @Override
    public Long save(RuleFieldSaveDTO ruleFieldSaveDTO) {
        return null;
    }

    @Override
    public Boolean update(RuleFieldUpdateDTO ruleFieldUpdateDTO) {
        return null;
    }

    @Override
    public Boolean delete(IdDTO idDTO) {
        return null;
    }
}
