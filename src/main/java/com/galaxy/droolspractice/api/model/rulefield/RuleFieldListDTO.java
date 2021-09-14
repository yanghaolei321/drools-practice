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

    @ApiModelProperty(value = "MODEL ID", example = "")
    private Long ruleId;

    @ApiModelProperty(value = "变量名称", example = "")
    private String filedName;

    @ApiModelProperty(value = "变量描述", example = "")
    private String fieldDesc;

    @ApiModelProperty(value = "变量类型", example = "")
    private Integer filedType;

    @ApiModelProperty(value = "变量编码", example = "")
    private String fieldCode;

    @ApiModelProperty(value = "数据源描述", example = "")
    private String dsDesc;

    @ApiModelProperty(value = "记录创建人", example = "")
    private String createAudit;

    @ApiModelProperty(value = "记录更新人", example = "")
    private String updateAudit;

    @ApiModelProperty(value = "创建时间", example = "")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间", example = "")
    private LocalDateTime modifyTime;

}