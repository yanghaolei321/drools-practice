package com.galaxy.droolspractice.api.model.rule;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 规则引擎-规则保存 DTO
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */
@ApiModel(value = "RuleSaveDTO", description = "规则引擎-规则保存 DTO")
@Data
@Accessors(chain = true)
public class RuleSaveDTO {

    @ApiModelProperty(value = "", example = "")
    private String guid;

    @ApiModelProperty(value = "规则名称", example = "")
    private String ruleName;

    @ApiModelProperty(value = "规则描述", example = "")
    private String ruleDesc;

    @ApiModelProperty(value = "规则表达式", example = "")
    private String ruleEval;

    @ApiModelProperty(value = "状态", example = "")
    private Integer status;

    @ApiModelProperty(value = "记录创建人", example = "")
    private String createAudit;

    @ApiModelProperty(value = "记录更新人", example = "")
    private String updateAudit;

    @ApiModelProperty(value = "更新时间", example = "")
    private LocalDateTime modifyTime;

}