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
     * 分页查询
     *
     * @return
     * @date 2021/09/14 下午5:03
     */
    IPage<RuleFieldVO> page(RuleFieldPageDTO ruleFieldPageDTO);

    /**
     * 查询RuleField
     *
     * @return
     * @date 2021/09/14 下午5:03
     */
    List<RuleFieldVO> list(RuleFieldListDTO ruleFieldListDTO);

    /**
     * 根据id获取RuleField
     *
     * @return
     * @date 2021/09/14 下午5:03
     */
    RuleFieldVO get(IdDTO idDTO);

    /**
     * 保存RuleField
     *
     * @return
     * @date 2021/09/14 下午5:03
     */
    Long save(RuleFieldSaveDTO ruleFieldSaveDTO);

    /**
     * 更改RuleField
     *
     * @return
     * @date 2021/09/14 下午5:03
     */
    Boolean update(RuleFieldUpdateDTO ruleFieldUpdateDTO);

    /**
     * 通过id删除RuleField
     *
     * @return
     * @date 2021/09/14 下午5:03
     */
    Boolean delete(IdDTO idDTO);
}
