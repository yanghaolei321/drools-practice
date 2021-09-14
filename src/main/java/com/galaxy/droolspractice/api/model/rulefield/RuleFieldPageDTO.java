package com.galaxy.droolspractice.api.model.rulefield;

import com.galaxy.droolspractice.infra.dto.PageDTO;
import com.galaxy.droolspractice.infra.enums.OrderTypeEnum;
import com.galaxy.droolspractice.infra.validation.EnumValidAnnotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 规则引擎-规则变量表分页 DTO
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */
@ApiModel(value = "RuleFieldPageDTO", description = "规则引擎-规则变量表分页 DTO")
@Data
@Accessors(chain = true)
public class RuleFieldPageDTO extends PageDTO {

    @ApiModelProperty(value = "搜索keyword")
    private String keyword;

    @ApiModelProperty(value = "排序的字段", example = "create_time")
    private String orderField;

    @ApiModelProperty(value = "排序类型：1-顺序;2-倒序", example = "1")
    @EnumValidAnnotation(message = "排序类型值错误", target = OrderTypeEnum.class)
    private Integer orderType;

}