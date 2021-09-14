package com.galaxy.droolspractice.api.model.rule;

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
@ApiModel(value = "RuleUpdateDTO", description = "规则引擎-规则更新 DTO")
@Data
@Accessors(chain = true)
public class RuleUpdateDTO extends RuleSaveDTO {

    @ApiModelProperty(value = "主键", example = "")
    private Long id;

}