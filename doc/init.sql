/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : radar

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-09-11 18:24:16
*/


-- ----------------------------
-- Table structure for rule_field
-- ----------------------------
DROP TABLE IF EXISTS `rule_field`;
CREATE TABLE `rule_field`
(
    `id`           bigint(20)                           NOT NULL AUTO_INCREMENT COMMENT '主键',
    `rule_id`      bigint(20)                           NOT NULL DEFAULT 0 COMMENT 'MODEL ID',
    `filed_name`   varchar(32) COLLATE utf8_unicode_ci  NOT NULL DEFAULT '' COMMENT '变量名称',
    `field_desc`   varchar(512) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '变量描述',
    `filed_type`   tinyint(4) COLLATE utf8_unicode_ci   NOT NULL DEFAULT 0 COMMENT '变量类型',
    `field_code`   varchar(512) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '变量编码',
    `ds_desc`      varchar(512) COLLATE utf8_unicode_ci NOT NULL COMMENT '数据源描述',
    `create_audit` varchar(512)                         NOT NULL DEFAULT '' COMMENT '记录创建人',
    `update_audit` varchar(512)                         NOT NULL DEFAULT '' COMMENT '记录更新人',
    `create_time`  datetime                             NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time`  datetime                             NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci COMMENT ='规则引擎-规则变量表';

-- ----------------------------
-- Records of rule_field
-- ----------------------------
INSERT INTO `rule_field`
VALUES ('1', '1', 'loginTime', '登录时间', 'LONG', '', '', 'linche', 'linche', '2016-11-17 11:06:17', '2016-11-17 11:06:17',
        0);
INSERT INTO `rule_field`
VALUES ('2', '1', 'userId', '用户ID', 'STRING', '', '', 'linche', 'linche', '2016-11-17 11:06:17', '2016-11-17 11:06:17',
        0);
INSERT INTO `rule_field`
VALUES ('3', '1', 'amount', '交易金额', 'DOUBLE', '', '', 'linche', 'linche', '2016-11-17 11:06:17', '2016-11-17 11:06:17',
        0);

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule`
(
    `id`           bigint(20)                           NOT NULL AUTO_INCREMENT COMMENT '主键',
    `guid`         varchar(64) COLLATE utf8_unicode_ci  NOT NULL,
    `rule_name`    varchar(32) COLLATE utf8_unicode_ci  NOT NULL DEFAULT '' COMMENT '规则名称',
    `rule_desc`    varchar(512) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '规则描述',
    `rule_eval`    varchar(512) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '规则表达式',
    `status`       int(11)                              NOT NULL DEFAULT 0 COMMENT '状态',
    `create_audit` varchar(512)                         NOT NULL DEFAULT '' COMMENT '记录创建人',
    `update_audit` varchar(512)                         NOT NULL DEFAULT '' COMMENT '记录更新人',
    `create_time`  datetime                             NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time`  datetime                             NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

-- ----------------------------
-- Records of engine_model
-- ----------------------------
INSERT INTO `rule`
VALUES ('1', '345CB10BDD8A', 'login_template', '登录行为', '', 1, 'linche', 'linche',
        '2016-11-17 10:59:43', '2016-11-18 18:02:15');


