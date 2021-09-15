package com.galaxy.droolspractice.api.model.engine;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 规则引擎-规则更新 DTO
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */
@ApiModel(value = "EngineDataUploadDTO", description = "规则引擎-数据提交 DTO")
@Data
@Accessors(chain = true)
public class EngineDataUploadDTO {

    @ApiModelProperty(value = "规则集中的guid", example = "345CB10BDD8A")
    private String guid;

    @ApiModelProperty(value = "json信息", example = "{\n" +
        " \"userId\":\"18516249909\",\n" +
        " \"loginTime\":1605339018000, \n" +
        " \"amount\":500.0\n" +
        " }   ")
    private JSONObject jsonInfo;

}