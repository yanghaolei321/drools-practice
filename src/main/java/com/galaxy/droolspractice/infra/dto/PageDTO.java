package com.galaxy.droolspractice.infra.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * 分页 DTO
 *
 * @author wangzukun
 * @Date 2018/11/12 下午4:26
 */
@Data
@ApiModel(value = "PageDTO", description = "分页 DTO")
public class PageDTO extends BaseDTO {

    @ApiModelProperty(value = "页码", example = "1")
    @Min(value = 1, message = "页码不能小于1")
    private Long current;

    @ApiModelProperty(value = "分页大小", example = "20")
    @Min(value = 1, message = "分页大小不能小于1")
    private Long size;
}