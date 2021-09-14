package com.galaxy.droolspractice.api.model.rulefield;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 规则引擎-规则变量表更新 DTO
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */
@ApiModel(value = "RuleFieldUpdateDTO", description = "规则引擎-规则变量表更新 DTO")
@Data
@Accessors(chain = true)
public class RuleFieldUpdateDTO extends RuleFieldSaveDTO {

    @ApiModelProperty(value = "主键", example = "")
    private Long id;

}