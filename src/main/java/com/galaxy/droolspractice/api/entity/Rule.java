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
 * 规则引擎-规则 Entity
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */
@ApiModel(value = "Rule", description = "规则引擎-规则 Entity")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("rule")
public class Rule extends Model<Rule> {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", example = "")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "", example = "")
    @TableField(value = "guid")
    private String guid;

    @ApiModelProperty(value = "规则名称", example = "")
    @TableField(value = "rule_name")
    private String ruleName;

    @ApiModelProperty(value = "规则描述", example = "")
    @TableField(value = "rule_desc")
    private String ruleDesc;

    @ApiModelProperty(value = "规则表达式", example = "")
    @TableField(value = "rule_eval")
    private String ruleEval;

    @ApiModelProperty(value = "状态", example = "")
    @TableField(value = "status")
    private Integer status;

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
