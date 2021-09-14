package com.galaxy.droolspractice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.galaxy.droolspractice.api.entity.Rule;
import com.galaxy.droolspractice.api.model.rule.*;
import com.galaxy.droolspractice.infra.dto.IdDTO;
import java.util.List;
/**
 * 规则引擎-规则 Service
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */
public interface IRuleService extends IService<Rule> {

    /**
     * 分页查询
     *
     * @return
     * @date 2021/09/14 下午5:03
     */
    IPage<RuleVO> page(RulePageDTO rulePageDTO);

    /**
     * 查询Rule
     *
     * @return
     * @date 2021/09/14 下午5:03
     */
    List<RuleVO> list(RuleListDTO ruleListDTO);

    /**
     * 根据id获取Rule
     *
     * @return
     * @date 2021/09/14 下午5:03
     */
    RuleVO get(IdDTO idDTO);

    /**
     * 保存Rule
     *
     * @return
     * @date 2021/09/14 下午5:03
     */
    Long save(RuleSaveDTO ruleSaveDTO);

    /**
     * 更改Rule
     *
     * @return
     * @date 2021/09/14 下午5:03
     */
    Boolean update(RuleUpdateDTO ruleUpdateDTO);

    /**
     * 通过id删除Rule
     *
     * @return
     * @date 2021/09/14 下午5:03
     */
    Boolean delete(IdDTO idDTO);
}
