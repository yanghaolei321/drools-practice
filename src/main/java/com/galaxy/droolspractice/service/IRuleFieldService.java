package com.galaxy.droolspractice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.galaxy.droolspractice.api.entity.RuleField;
import com.galaxy.droolspractice.api.model.rulefield.*;
import com.galaxy.droolspractice.infra.dto.IdDTO;

import java.util.List;


/**
 * 规则引擎-规则变量表 Service
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */
public interface IRuleFieldService extends IService<RuleField> {


    /**
     * 通过规则集id查询RuleField
     *
     * @return
     * @date 2021/09/14 下午5:03
     */
    List<RuleField> listByRuleId(Long ruleId);


}
