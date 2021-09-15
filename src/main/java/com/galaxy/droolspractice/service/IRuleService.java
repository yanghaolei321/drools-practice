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
     * 根据guid获取Rule
     *
     * @return
     * @date 2021/09/14 下午5:03
     */
    Rule getByGuid(String guid);


}
