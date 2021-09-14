package com.galaxy.droolspractice.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 规则引擎-规则变量表 Entity
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */
@ApiModel(value = "RuleField", description = "规则引擎-规则变量表 Entity")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("rule_field")
public class RuleField extends Model<RuleField> {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", example = "")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "MODEL ID", example = "")
    @TableField(value = "rule_id")
    private Long ruleId;

    @ApiModelProperty(value = "变量名称", example = "")
    @TableField(value = "filed_name")
    private String filedName;

    @ApiModelProperty(value = "变量描述", example = "")
    @TableField(value = "field_desc")
    private String fieldDesc;

    @ApiModelProperty(value = "变量类型", example = "")
    @TableField(value = "filed_type")
    private Integer filedType;

    @ApiModelProperty(value = "变量编码", example = "")
    @TableField(value = "field_code")
    private String fieldCode;

    @ApiModelProperty(value = "数据源描述", example = "")
    @TableField(value = "ds_desc")
    private String dsDesc;

    @ApiModelProperty(value = "记录创建人", example = "")
    @TableField(value = "create_audit")
    private String createAudit;

    @ApiModelProperty(value = "记录更新人", example = "")
    @TableField(value = "update_audit")
    private String updateAudit;

    @ApiModelProperty(value = "创建时间", example = "")
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间", example = "")
    @TableField(value = "modify_time")
    private LocalDateTime modifyTime;

}
