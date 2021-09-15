/*
 * [责任人][状态]
 * 状态 包括：
 * 文档已确认
 * 接口已提测
 * 接口已上线
 */
package com.galaxy.droolspractice.controller;

import com.galaxy.droolspractice.api.model.engine.EngineDataUploadDTO;
import com.galaxy.droolspractice.infra.bean.R;
import com.galaxy.droolspractice.infra.dto.IdDTO;
import com.galaxy.droolspractice.middleware.EngineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;


/**
 * 规则引擎-匹配 Controller
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */
@Api(value = "/engine", tags = "规则引擎-匹配 Controller")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/engine")
public class EngineController {

    private final EngineService engineService;

    @ApiOperation(value = "修改规则引擎-数据提交-[LinChe][文档已经设计]", notes = "")
    @PostMapping("/updateData")
    public R updateData(@RequestBody EngineDataUploadDTO param) throws IOException {
        return R.data(engineService.uploadData(param));
    }

    @ApiOperation(value = "通过id删除规则引擎-规则-[LinChe][文档已经设计]", notes = "")
    @PostMapping("/delete")
    public R delete(@Valid @RequestBody IdDTO param) {
        return null;
    }

}
