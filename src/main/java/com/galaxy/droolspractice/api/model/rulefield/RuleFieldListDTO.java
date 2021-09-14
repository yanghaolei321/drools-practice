package com.galaxy.droolspractice.api.model.rulefield;

import com.galaxy.droolspractice.infra.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 规则引擎-规则变量表列表 DTO
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */
@ApiModel(value = "RuleFieldListDTO", description = "规则引擎-规则变量表列表 DTO")
@Data
@Accessors(chain = true)
public class RuleFieldListDTO extends BaseDTO {

    @ApiModelProperty(value = "rule ID", example = "规则集")
    private Long ruleId;
}