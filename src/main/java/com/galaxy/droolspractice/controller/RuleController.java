/*
 * [责任人][状态]
 * 状态 包括：
 * 文档已确认
 * 接口已提测
 * 接口已上线
 */
package com.galaxy.droolspractice.controller;

import com.galaxy.droolspractice.infra.bean.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.galaxy.droolspractice.api.model.rule.*;
import com.galaxy.droolspractice.infra.dto.IdDTO;
import com.galaxy.droolspractice.service.IRuleService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

import javax.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;


/**
 * 规则引擎-规则 Controller
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */
@Api(value = "/rule", tags = "规则引擎-规则 Controller")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/rule")
public class RuleController {

    private final IRuleService ruleService;

    @ApiOperation(value = "分页查询规则引擎-规则[LinChe][文档已经设计]", notes = "")
    @PostMapping("/page")
    public R<IPage<RuleVO>> page(@Valid @RequestBody RulePageDTO param) {
        return null;
    }

    @ApiOperation(value = "列表查询规则引擎-规则[LinChe][文档已经设计]", notes = "")
    @PostMapping("/list")
    public R<List<RuleVO>> list(@Valid @RequestBody RuleListDTO param) {
        return null;
    }

    @ApiOperation(value = "通过id查询规则引擎-规则[LinChe][文档已经设计]", notes = "")
    @PostMapping("/get")
    public R get(@Valid @RequestBody IdDTO param) {
        return null;
    }

    @ApiOperation(value = "新增规则引擎-规则[LinChe][文档已经设计]", notes = "")
    @PostMapping("/save")
    public R save(@Valid @RequestBody RuleSaveDTO param) {
        return null;
    }

    @ApiOperation(value = "修改规则引擎-规则[LinChe][文档已经设计]", notes = "")
    @PostMapping("/update")
    public R update(@RequestBody RuleUpdateDTO param) {
        return null;
    }

    @ApiOperation(value = "通过id删除规则引擎-规则[LinChe][文档已经设计]", notes = "")
    @PostMapping("/delete")
    public R delete(@Valid @RequestBody IdDTO param) {
        return null;
    }

}
