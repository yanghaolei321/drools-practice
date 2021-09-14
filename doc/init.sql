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


-- ----------------------------
-- Table structure for engine_rule
-- ----------------------------
DROP TABLE IF EXISTS `engine_rule`;
CREATE TABLE `engine_rule`
(
    `ID`               bigint(20)                            NOT NULL AUTO_INCREMENT COMMENT '主键',
    `MODEL_ID`         bigint(20)                            NOT NULL COMMENT '模型ID',
    `ACTIVATION_ID`    bigint(20)                            NOT NULL COMMENT '激活ID',
    `NAME`             varchar(64) COLLATE utf8_unicode_ci   NOT NULL DEFAULT '',
    `LABEL`            varchar(64) COLLATE utf8_unicode_ci   NOT NULL DEFAULT '' COMMENT '规则名称',
    `SCRIPTS`          varchar(2048) COLLATE utf8_unicode_ci NOT NULL COMMENT '检验脚本',
    `INIT_SCORE`       int(11)                               NOT NULL DEFAULT '0' COMMENT '初始分数',
    `BASE_NUM`         int(11)                               NOT NULL DEFAULT '0' COMMENT '基数',
    `OPERATOR`         varchar(32) COLLATE utf8_unicode_ci   NOT NULL COMMENT '运算符',
    `ABSTRACTION_NAME` varchar(64) COLLATE utf8_unicode_ci   NOT NULL COMMENT '抽象名称',
    `RATE`             int(11)                               NOT NULL DEFAULT '100' COMMENT '比例',
    `STATUS`           int(11)                               NOT NULL COMMENT '状态',
    `RULE_DEFINITION`  varchar(2048) COLLATE utf8_unicode_ci          DEFAULT NULL,
    `CREATE_TIME`      datetime                              NOT NULL,
    `UPDATE_TIME`      datetime                              NOT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 388
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

-- ----------------------------
-- Records of engine_rule
-- ----------------------------
INSERT INTO `engine_rule`
VALUES ('85', '103', '37', 'rule_85', '1天内IP交易次数大于30',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.tran_ip_1_day_qty>=30)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'tran_ip_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.tran_ip_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"30\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 11:41:21', '2016-11-18 11:41:21');
INSERT INTO `engine_rule`
VALUES ('87', '103', '37', 'rule_87', '1小时内IP交易次数大于15',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.tran_ip_1_hour_qty>=15)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'tran_ip_1_hour_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.tran_ip_1_hour_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"15\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 11:43:14', '2016-11-18 11:43:14');
INSERT INTO `engine_rule`
VALUES ('89', '103', '37', 'rule_89', '1天内IP交易金额大于1000',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.tran_ip_1_day_amt>=1000)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'tran_ip_1_day_amt', '10', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.tran_ip_1_day_amt\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"1000\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 11:46:11', '2016-11-18 11:46:11');
INSERT INTO `engine_rule`
VALUES ('91', '103', '37', 'rule_91', '1天内设备交易次数大于30',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.tran_did_1_day_qty>=30)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'ADD', 'tran_did_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.tran_did_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"30\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 11:47:24', '2016-11-18 11:47:24');
INSERT INTO `engine_rule`
VALUES ('93', '103', '37', 'rule_93', '1天内IP关联设备数大于10',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.tran_did_ip_1_day_qty>=10)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'tran_did_ip_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.tran_did_ip_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"10\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 14:03:33', '2016-11-18 14:03:33');
INSERT INTO `engine_rule`
VALUES ('95', '103', '37', 'rule_95', '1天内IP关联用户数大于10',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.tran_uid_ip_1_day_qty>=10)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'tran_uid_ip_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.tran_uid_ip_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"10\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 14:04:40', '2016-11-18 14:04:40');
INSERT INTO `engine_rule`
VALUES ('97', '103', '37', 'rule_97', '手机归属地和IP归属地城市不一致',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if ((data.preItems.mobileLocationPre.city!=data.preItems.ipLocationPre.city))\n        return true;\n    else\n        return false;\n}}',
        '20', '0', 'NONE', '', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"preItems.mobileLocationPre.city\",\"type\":\"STRING\",\"class\":\"ENTATTR\"},{\"column\":\"preItems.ipLocationPre.city\",\"type\":\"STRING\",\"class\":\"ENTATTR\"}],\"enabled\":true,\"operator\":\"Field_Not_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 14:05:39', '2019-09-11 17:42:52');
INSERT INTO `engine_rule`
VALUES ('99', '103', '37', 'rule_99', 'IP归属地不在中国',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if ((data.preItems.ipLocationPre.country!=\'中国\'))\n        return true;\n    else\n        return false;\n}}',
        '20', '0', 'NONE', '', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"preItems.ipLocationPre.country\",\"type\":\"STRING\",\"class\":\"ENTATTR\"},{\"type\":\"STRING\",\"class\":\"CONST\",\"value\":\"中国\"}],\"enabled\":true,\"operator\":\"NotEqual\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 14:06:43', '2019-09-11 17:42:57');
INSERT INTO `engine_rule`
VALUES ('101', '99', '39', 'rule_101', '1天内IP关联用户数大于10',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.log_uid_ip_1_day_qty>=10)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'log_uid_ip_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.log_uid_ip_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"10\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 14:43:03', '2016-11-18 14:43:03');
INSERT INTO `engine_rule`
VALUES ('103', '99', '39', 'rule_103', '1天内IP关联设备数大于10',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.log_did_ip_1_hour_qty>=10)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'log_did_ip_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.log_did_ip_1_hour_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"10\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 14:45:57', '2016-11-18 14:45:57');
INSERT INTO `engine_rule`
VALUES ('105', '99', '39', 'rule_105', '10分钟内IP登录次数大于10',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.log_ip_10_min_qty>=10)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'log_ip_10_min_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.log_ip_10_min_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"10\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 14:47:12', '2016-11-18 14:47:12');
INSERT INTO `engine_rule`
VALUES ('107', '99', '39', 'rule_107', 'IP登录位置显示国外',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if ((data.preItems.ipLocationPre.country!=\'中国\'))\n        return true;\n    else\n        return false;\n}}',
        '20', '0', 'NONE', '', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"preItems.ipLocationPre.country\",\"type\":\"STRING\",\"class\":\"ENTATTR\"},{\"type\":\"STRING\",\"class\":\"CONST\",\"value\":\"中国\"}],\"enabled\":true,\"operator\":\"NotEqual\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 14:48:19', '2019-09-11 17:40:42');
INSERT INTO `engine_rule`
VALUES ('109', '101', '41', 'rule_109', '1天内IP关联注册数大于20',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.reg_ip_1_day_qty>=20)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'reg_ip_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.reg_ip_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"20\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 16:00:55', '2016-11-18 16:00:55');
INSERT INTO `engine_rule`
VALUES ('111', '101', '41', 'rule_111', '1天内设备关联注册数大于20',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.reg_did_1_day_qty>=20)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'reg_did_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.reg_did_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"20\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 16:01:44', '2016-11-18 16:01:44');
INSERT INTO `engine_rule`
VALUES ('113', '101', '41', 'rule_113', '10分钟内IP关联注册数大于15',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.reg_ip_10_min_qty>=15)\n        return true;\n    else\n        return false;\n}}',
        '30', '1', 'MUL', 'reg_ip_10_min_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.reg_ip_10_min_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"15\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 16:02:57', '2016-11-18 16:02:57');
INSERT INTO `engine_rule`
VALUES ('115', '101', '41', 'rule_115', '1天内设备关联用户数大于10',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.reg_uid_did_1_day_qty>=10)\n        return true;\n    else\n        return false;\n}}',
        '30', '1', 'MUL', 'reg_uid_did_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.reg_uid_did_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"10\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 16:04:13', '2016-11-18 16:04:13');
INSERT INTO `engine_rule`
VALUES ('117', '101', '41', 'rule_117', 'IP归属地城市与手机号码归属地城市不一致',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if ((data.preItems.ipLocationPre.city!=data.preItems.mobileLocationPre.city))\n        return true;\n    else\n        return false;\n}}',
        '20', '0', 'NONE', '', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"preItems.ipLocationPre.city\",\"type\":\"STRING\",\"class\":\"ENTATTR\"},{\"column\":\"preItems.mobileLocationPre.city\",\"type\":\"STRING\",\"class\":\"ENTATTR\"}],\"enabled\":true,\"operator\":\"Field_Not_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 16:05:29', '2019-09-11 17:41:16');
INSERT INTO `engine_rule`
VALUES ('119', '101', '41', 'rule_119', '注册IP来源于国外',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if ((data.preItems.ipLocationPre.country!=\'中国\'))\n        return true;\n    else\n        return false;\n}}',
        '30', '0', 'NONE', '', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"preItems.ipLocationPre.country\",\"type\":\"STRING\",\"class\":\"ENTATTR\"},{\"type\":\"STRING\",\"class\":\"CONST\",\"value\":\"中国\"}],\"enabled\":true,\"operator\":\"NotEqual\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 16:07:01', '2019-09-11 17:41:08');
INSERT INTO `engine_rule`
VALUES ('121', '99', '39', 'rule_121', '1天内用户登录次数大于30',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.log_uid_1_day_qty>=30)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'log_uid_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.log_uid_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"30\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-18 18:04:03', '2016-11-18 18:04:24');
INSERT INTO `engine_rule`
VALUES ('127', '103', '37', 'rule_127', '命中手机号码白名单',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (lists.mobile_white_list.containsKey(data.fields.mobile))\n        return true;\n    else\n        return false;\n}}',
        '-200', '0', 'NONE', '', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"fields.mobile\",\"type\":\"STRING\",\"class\":\"ENTATTR\"},{\"type\":\"LIST\",\"class\":\"CONST\",\"value\":\"mobile_white_list\"}],\"enabled\":true,\"operator\":\"InList\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2016-11-22 14:12:57', '2016-11-22 14:13:06');
INSERT INTO `engine_rule`
VALUES ('373', '222', '116', 'rule_109', '1天内IP关联注册数大于20',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.reg_ip_1_day_qty>=20)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'reg_ip_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.reg_ip_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"20\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2019-09-10 11:16:12', '2019-09-10 11:16:12');
INSERT INTO `engine_rule`
VALUES ('374', '222', '116', 'rule_111', '1天内设备关联注册数大于20',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.reg_did_1_day_qty>=20)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'reg_did_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.reg_did_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"20\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2019-09-10 11:16:12', '2019-09-10 11:16:12');
INSERT INTO `engine_rule`
VALUES ('375', '222', '116', 'rule_113', '10分钟内IP关联注册数大于15',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.reg_ip_10_min_qty>=15)\n        return true;\n    else\n        return false;\n}}',
        '30', '1', 'MUL', 'reg_ip_10_min_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.reg_ip_10_min_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"15\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2019-09-10 11:16:12', '2019-09-10 11:16:12');
INSERT INTO `engine_rule`
VALUES ('376', '222', '116', 'rule_115', '1天内设备关联用户数大于10',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.reg_uid_did_1_day_qty>=10)\n        return true;\n    else\n        return false;\n}}',
        '30', '1', 'MUL', 'reg_uid_did_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.reg_uid_did_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"10\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2019-09-10 11:16:12', '2019-09-10 11:16:12');
INSERT INTO `engine_rule`
VALUES ('377', '222', '116', 'rule_377', 'IP归属地城市与手机号码归属地城市不一致',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if ((data.preItems.ipLocationPre.city!=data.preItems.mobileLocationPre.city))\n        return true;\n    else\n        return false;\n}}',
        '20', '0', 'NONE', '', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"preItems.ipLocationPre.city\",\"type\":\"STRING\",\"class\":\"ENTATTR\"},{\"column\":\"preItems.mobileLocationPre.city\",\"type\":\"STRING\",\"class\":\"ENTATTR\"}],\"enabled\":true,\"operator\":\"Field_Not_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2019-09-10 11:16:12', '2019-09-11 17:27:20');
INSERT INTO `engine_rule`
VALUES ('378', '222', '116', 'rule_378', '注册IP来源于国外',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if ((data.preItems.ipLocationPre.country!=\'中国\'))\n        return true;\n    else\n        return false;\n}}',
        '30', '0', 'NONE', '', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"preItems.ipLocationPre.country\",\"type\":\"STRING\",\"class\":\"ENTATTR\"},{\"type\":\"STRING\",\"class\":\"CONST\",\"value\":\"中国\"}],\"enabled\":true,\"operator\":\"NotEqual\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2019-09-10 11:16:12', '2019-09-11 17:29:18');
INSERT INTO `engine_rule`
VALUES ('379', '224', '117', 'rule_85', '1天内IP交易次数大于30',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.tran_ip_1_day_qty>=30)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'tran_ip_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.tran_ip_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"30\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2019-09-11 18:05:35', '2019-09-11 18:05:35');
INSERT INTO `engine_rule`
VALUES ('380', '224', '117', 'rule_87', '1小时内IP交易次数大于15',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.tran_ip_1_hour_qty>=15)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'tran_ip_1_hour_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.tran_ip_1_hour_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"15\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2019-09-11 18:05:35', '2019-09-11 18:05:35');
INSERT INTO `engine_rule`
VALUES ('381', '224', '117', 'rule_89', '1天内IP交易金额大于1000',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.tran_ip_1_day_amt>=1000)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'tran_ip_1_day_amt', '10', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.tran_ip_1_day_amt\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"1000\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2019-09-11 18:05:35', '2019-09-11 18:05:35');
INSERT INTO `engine_rule`
VALUES ('382', '224', '117', 'rule_91', '1天内设备交易次数大于30',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.tran_did_1_day_qty>=30)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'ADD', 'tran_did_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.tran_did_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"30\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2019-09-11 18:05:35', '2019-09-11 18:05:35');
INSERT INTO `engine_rule`
VALUES ('383', '224', '117', 'rule_93', '1天内IP关联设备数大于10',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.tran_did_ip_1_day_qty>=10)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'tran_did_ip_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.tran_did_ip_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"10\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2019-09-11 18:05:35', '2019-09-11 18:05:35');
INSERT INTO `engine_rule`
VALUES ('384', '224', '117', 'rule_95', '1天内IP关联用户数大于10',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (data.abstractions.tran_uid_ip_1_day_qty>=10)\n        return true;\n    else\n        return false;\n}}',
        '20', '1', 'MUL', 'tran_uid_ip_1_day_qty', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"abstractions.tran_uid_ip_1_day_qty\",\"type\":\"DOUBLE\",\"class\":\"ENTATTR\"},{\"type\":\"DOUBLE\",\"class\":\"CONST\",\"value\":\"10\"}],\"enabled\":true,\"operator\":\"Greater_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2019-09-11 18:05:35', '2019-09-11 18:05:35');
INSERT INTO `engine_rule`
VALUES ('385', '224', '117', 'rule_97', '手机归属地和IP归属地城市不一致',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if ((data.preItems.mobileLocationPre.city!=data.preItems.ipLocationPre.city))\n        return true;\n    else\n        return false;\n}}',
        '20', '0', 'NONE', '', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"preItems.mobileLocationPre.city\",\"type\":\"STRING\",\"class\":\"ENTATTR\"},{\"column\":\"preItems.ipLocationPre.city\",\"type\":\"STRING\",\"class\":\"ENTATTR\"}],\"enabled\":true,\"operator\":\"Field_Not_Equal\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2019-09-11 18:05:35', '2019-09-11 18:05:35');
INSERT INTO `engine_rule`
VALUES ('386', '224', '117', 'rule_99', 'IP归属地不在中国',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if ((data.preItems.ipLocationPre.country!=\'中国\'))\n        return true;\n    else\n        return false;\n}}',
        '20', '0', 'NONE', '', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"preItems.ipLocationPre.country\",\"type\":\"STRING\",\"class\":\"ENTATTR\"},{\"type\":\"STRING\",\"class\":\"CONST\",\"value\":\"中国\"}],\"enabled\":true,\"operator\":\"NotEqual\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2019-09-11 18:05:35', '2019-09-11 18:05:35');
INSERT INTO `engine_rule`
VALUES ('387', '224', '117', 'rule_127', '命中手机号码白名单',
        'class ActivationCheckScript {\n  public boolean check(def data, def lists) {    if (lists.mobile_white_list.containsKey(data.fields.mobile))\n        return true;\n    else\n        return false;\n}}',
        '-200', '0', 'NONE', '', '100', '1',
        '{\"linking\":\"All\",\"conditions\":[{\"class\":\"SMPL\",\"expressions\":[{\"column\":\"fields.mobile\",\"type\":\"STRING\",\"class\":\"ENTATTR\"},{\"type\":\"LIST\",\"class\":\"CONST\",\"value\":\"mobile_white_list\"}],\"enabled\":true,\"operator\":\"InList\"}],\"class\":\"PDCT\",\"enabled\":true}',
        '2019-09-11 18:05:35', '2019-09-11 18:05:35');

-- ----------------------------
-- Table structure for engine_rule_history
-- ----------------------------
DROP TABLE IF EXISTS `engine_rule_history`;
CREATE TABLE `engine_rule_history`
(
    `ID`               bigint(20)                            NOT NULL AUTO_INCREMENT COMMENT '主键',
    `RULE_ID`          bigint(20)                            NOT NULL COMMENT '模型ID',
    `MERCHANT_CODE`    varchar(60) COLLATE utf8_unicode_ci   NOT NULL,
    `LABEL`            varchar(64) COLLATE utf8_unicode_ci   NOT NULL DEFAULT '' COMMENT '规则名称',
    `INIT_SCORE`       int(11)                               NOT NULL DEFAULT '0' COMMENT '初始分数',
    `BASE_NUM`         int(11)                               NOT NULL DEFAULT '0' COMMENT '基数',
    `OPERATOR`         varchar(32) COLLATE utf8_unicode_ci   NOT NULL COMMENT '运算符',
    `ABSTRACTION_NAME` varchar(64) COLLATE utf8_unicode_ci   NOT NULL COMMENT '抽象名称',
    `RATE`             int(11)                               NOT NULL DEFAULT '100' COMMENT '比例',
    `RULE_DEFINITION`  varchar(2048) COLLATE utf8_unicode_ci NOT NULL,
    `UPDATE_TIME`      datetime                              NOT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

-- ----------------------------
-- Records of engine_rule_history
-- ----------------------------
INSERT INTO `engine_rule_history`
VALUES ('1', '377', 'admin', 'IP归属地城市与手机号码归属地城市不一致', '20', '0', 'NONE', '', '100', '', '2019-09-11 17:27:20');
INSERT INTO `engine_rule_history`
VALUES ('2', '378', 'admin', '注册IP来源于国外', '30', '0', 'NONE', '', '100', '', '2019-09-11 17:29:18');
INSERT INTO `engine_rule_history`
VALUES ('3', '107', 'admin', 'IP登录位置显示国外', '20', '0', 'NONE', '', '100', '', '2019-09-11 17:40:42');
INSERT INTO `engine_rule_history`
VALUES ('4', '119', 'admin', '注册IP来源于国外', '30', '0', 'NONE', '', '100', '', '2019-09-11 17:41:08');
INSERT INTO `engine_rule_history`
VALUES ('5', '117', 'admin', 'IP归属地城市与手机号码归属地城市不一致', '20', '0', 'NONE', '', '100', '', '2019-09-11 17:41:16');
INSERT INTO `engine_rule_history`
VALUES ('6', '97', 'admin', '手机归属地和IP归属地城市不一致', '20', '0', 'NONE', '', '100', '', '2019-09-11 17:42:52');
INSERT INTO `engine_rule_history`
VALUES ('7', '99', 'admin', 'IP归属地不在中国', '20', '0', 'NONE', '', '100', '', '2019-09-11 17:42:57');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `ID`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `USER_NAME`   varchar(32) DEFAULT NULL,
    `PASSWD`      varchar(64) DEFAULT NULL,
    `CODE`        varchar(64) DEFAULT NULL,
    `STATUS`      varchar(2)  DEFAULT NULL,
    `CREATE_TIME` datetime    DEFAULT NULL,
    `UPDATE_TIME` datetime    DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users`
VALUES ('1', 'admin', '223CE7B851123353479D85757FBBF4E320D1E251', 'pgmmer.top', '1', '2019-07-24 18:10:11',
        '2019-07-24 18:10:14');
INSERT INTO `users`
VALUES ('2', 'test', 'B2478239CD7E68E8052398D8EB87D385BF962085', 'ting.pgmmer.top', '1', '2019-07-24 18:15:30',
        '2019-07-24 18:15:33');
