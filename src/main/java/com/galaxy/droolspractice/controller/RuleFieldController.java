/*
 * [责任人][状态]
 * 状态 包括：
 * 文档已确认
 * 接口已提测
 * 接口已上线
 */
package com.galaxy.droolspractice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.galaxy.droolspractice.api.model.rulefield.*;
import com.galaxy.droolspractice.infra.bean.R;
import com.galaxy.droolspractice.infra.dto.IdDTO;
import com.galaxy.droolspractice.service.IRuleFieldService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 规则引擎-规则变量表 Controller
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */
@Api(value = "/ruleField", tags = "规则引擎-规则变量表 Controller")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/ruleField")
public class RuleFieldController {

    private final IRuleFieldService ruleFieldService;

    @ApiOperation(value = "分页查询规则引擎-规则变量表[LinChe][文档已经设计]", notes = "", position = 1)
    @PostMapping("/page")
    public R<IPage<RuleFieldVO>> page(@Valid @RequestBody RuleFieldPageDTO param) {
        return null;
    }

    @ApiOperation(value = "列表查询规则引擎-规则变量表[LinChe][文档已经设计]", notes = "", position = 2)
    @PostMapping("/list")
    public R<List<RuleFieldVO>> list(@Valid @RequestBody RuleFieldListDTO param) {
        return null;
    }

    @ApiOperation(value = "通过id查询规则引擎-规则变量表[LinChe][文档已经设计]", notes = "", position = 3)
    @PostMapping("/get")
    public R get(@Valid @RequestBody IdDTO param) {
        return null;
    }

    @ApiOperation(value = "新增规则引擎-规则变量表[LinChe][文档已经设计]", notes = "", position = 4)
    @PostMapping("/save")
    public R save(@Valid @RequestBody RuleFieldSaveDTO param) {
        return null;
    }

    @ApiOperation(value = "修改规则引擎-规则变量表[LinChe][文档已经设计]", notes = "", position = 5)
    @PostMapping("/update")
    public R update(@RequestBody RuleFieldUpdateDTO param) {
        return null;
    }

    @ApiOperation(value = "通过id删除规则引擎-规则变量表[LinChe][文档已经设计]", notes = "", position = 6)
    @PostMapping("/delete")
    public R delete(@Valid @RequestBody IdDTO param) {
        return null;
    }

}
