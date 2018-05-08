/*
Navicat MySQL Data Transfer

Source Server         : 192.168.23.212
Source Server Version : 50714
Source Host           : 192.168.23.212:3306
Source Database       : catcode

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-12-08 15:08:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ds_column`
-- ----------------------------
DROP TABLE IF EXISTS `ds_column`;
CREATE TABLE `ds_column` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `OGID` varchar(40) DEFAULT NULL COMMENT '对象全局编号',
  `OVER` varchar(25) DEFAULT NULL COMMENT '版本',
  `IS_VALID` char(1) NOT NULL DEFAULT 'Y' COMMENT '有效性(Y有效, N无效)',
  `CODE` varchar(40) NOT NULL COMMENT '代码',
  `NAME` varchar(40) DEFAULT NULL COMMENT '英文名称',
  `LABEL` varchar(1000) DEFAULT NULL COMMENT '中文名称',
  `DATASOURCE_ID` bigint(11) NOT NULL COMMENT '数据源ID',
  `TABLE_ID` bigint(11) NOT NULL COMMENT '表编号',
  `DATA_TYPE` varchar(20) DEFAULT NULL COMMENT '数据类型',
  `DATA_LENGTH` varchar(4) DEFAULT NULL COMMENT '数据长度',
  `DEFAULT_VALUE` varchar(40) DEFAULT NULL COMMENT '默认值',
  `IS_NULL` char(1) DEFAULT 'Y' COMMENT '是否为空(Y为空, N不为空)',
  `SORT_NUM` int(2) DEFAULT NULL COMMENT '排序号',
  `IS_PK` char(1) DEFAULT NULL COMMENT '是否主键(Y是,N否)',
  `FOREIGN_KEY` varchar(40) DEFAULT NULL COMMENT '外键',
  `TYPE_CD` char(1) DEFAULT NULL COMMENT '类型(V虚,R真)',
  `CREATE_USER_ID` bigint(11) DEFAULT NULL COMMENT '创建用户编号',
  `CREATE_DATE` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER_ID` bigint(11) DEFAULT NULL COMMENT '更新用户编号',
  `UPDATE_DATE` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `NOTE` varchar(2000) DEFAULT NULL COMMENT '备注',
  `IS_UNIQUE` char(1) DEFAULT NULL COMMENT '是否唯一Y唯一，N不唯一',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of ds_column
-- ----------------------------
INSERT INTO `ds_column` VALUES ('1', '074de9a1-47a2-4256-82db-534d47734071', null, 'Y', 'ID', 'id', '主键2', '1', '1', 'int', null, null, 'N', '1', 'Y', null, 'R', '1', '2016-09-04 09:47:34', '1', '2016-09-04 09:49:51', null, 'Y');
INSERT INTO `ds_column` VALUES ('2', '33109e7b-3b35-41e1-b23e-97c447cd1af2', null, 'Y', ' ID', 'id', 'PK', '2', '2', 'int', '14', null, 'N', null, 'Y', null, 'R', '1', '2016-09-09 10:22:46', null, '2016-09-09 10:22:46', null, 'Y');
INSERT INTO `ds_column` VALUES ('3', '590e7240-35e2-4826-8630-927be21d7e4d', null, 'Y', 'ACTIVITY_NAME', 'activity_name', '活动名称', '2', '2', 'varchar', '30', null, 'N', null, 'N', null, 'R', '1', '2016-09-09 10:23:27', null, '2016-09-09 10:23:27', null, 'N');
INSERT INTO `ds_column` VALUES ('4', '0062a902-ea14-4b5a-a7b8-5e48c703e2cb', null, 'Y', 'ACTIVITY_CODE', 'activity_code', '活动编码', '2', '2', 'varchar', '30', null, 'Y', null, 'N', null, 'R', '1', '2016-09-09 10:23:52', null, '2016-09-09 10:23:52', '活动编码', 'N');
INSERT INTO `ds_column` VALUES ('5', '204a9de9-a40a-464e-83ac-69488ebb1a1a', null, 'Y', 'TOTAL_MONEY', 'total_money', '总金额', '2', '2', 'double', '2,9', null, 'Y', null, 'N', null, 'R', '1', '2016-09-09 14:42:11', null, '2016-09-09 14:42:11', null, 'N');
INSERT INTO `ds_column` VALUES ('6', '06686f4a-b2f0-4b10-a3d5-8eb56c3a3133', null, 'Y', 'BALANCE_MONEY', 'balance_money', '剩下金额', '2', '2', 'double', '2,9', null, 'Y', null, 'N', null, 'R', '1', '2016-09-09 14:42:42', null, '2016-09-09 14:42:42', null, 'N');
INSERT INTO `ds_column` VALUES ('7', '02fe8244-805f-4571-a26c-3897a6fc4425', null, 'Y', 'TOTAL_USER', 'total_user', '抽奖总人数', '2', '2', 'int', '14', null, 'Y', null, 'N', null, 'R', '1', '2016-09-09 14:43:11', null, '2016-09-09 14:43:11', null, 'N');
INSERT INTO `ds_column` VALUES ('8', 'fa07cbc7-e3b3-4ff9-9dca-6c906c938e50', null, 'Y', 'TOTAL_WIN_USER', 'total_win_user', '中奖人数', '2', '2', 'int', '14', null, 'Y', null, 'N', null, 'R', '1', '2016-09-09 14:43:35', null, '2016-09-09 14:43:35', null, 'N');
INSERT INTO `ds_column` VALUES ('9', '3a658688-0ee1-4da9-865b-4adec0a0d5b9', null, 'Y', 'CREATE_TIME', 'create_time', '创建时间', '2', '2', 'timestamp', null, null, 'Y', null, 'N', null, 'R', '1', '2016-09-09 14:43:58', null, '2016-09-09 14:43:58', null, 'N');
INSERT INTO `ds_column` VALUES ('10', '531214c6-93b6-4602-ad70-964cc8215f83', null, 'Y', 'UPDATE_TIME', 'update_time', '修改时间', '2', '2', 'timestamp', null, null, 'Y', null, 'N', null, 'R', '1', '2016-09-09 14:44:48', null, '2016-09-09 14:44:48', null, 'N');
INSERT INTO `ds_column` VALUES ('11', '790bdd37-9012-4aa3-a82d-c5de19e6a65b', null, 'Y', 'START_TIME', 'start_time', '活动开始时间', '2', '2', 'timestamp', null, null, 'Y', null, 'N', null, 'R', '1', '2016-09-09 14:45:50', null, '2016-09-09 14:45:50', null, 'N');
INSERT INTO `ds_column` VALUES ('12', '8636d795-2f71-4203-af17-061604b47f54', null, 'Y', 'END_TIME', 'end_time', '结束时间', '2', '2', 'timestamp', null, null, 'Y', null, 'N', null, 'R', '1', '2016-09-09 14:46:15', null, '2016-09-09 14:46:15', null, 'N');
INSERT INTO `ds_column` VALUES ('13', '6b96350f-01b5-4cd3-9636-1d6afca1825f', null, 'Y', 'ID', 'id', 'PK', '2', '3', 'int', '14', null, 'N', '1', 'Y', null, 'R', '1', '2016-09-09 16:45:17', null, '2016-09-09 16:45:17', null, 'N');
INSERT INTO `ds_column` VALUES ('14', '7766be43-1269-42e6-a8bf-7c329bdf9bf2', null, 'Y', 'ACT_ID', 'act_id', 'act_id', '2', '3', 'int', '14', null, 'Y', '2', 'N', null, 'R', '1', '2016-09-09 16:45:47', null, '2016-09-09 16:45:47', null, 'N');
INSERT INTO `ds_column` VALUES ('15', '4105d47d-050f-4ced-b616-ddd053876850', null, 'Y', 'RULE_NAME', 'rule_name', '规则名称', '2', '3', 'varchar', '100', null, 'Y', '3', 'N', null, 'R', '1', '2016-09-09 16:46:18', null, '2016-09-09 16:46:18', null, 'N');
INSERT INTO `ds_column` VALUES ('16', '769bbef2-96f4-4a92-88ea-66624b0bc4b9', null, 'Y', 'MONEY', 'money', '红包金额', '2', '3', 'int', '14', null, 'Y', '4', 'N', null, 'R', '1', '2016-09-09 17:00:12', null, '2016-09-09 17:00:12', null, 'N');
INSERT INTO `ds_column` VALUES ('17', '20fb0942-a6c6-4588-9828-e437007bd8a3', null, 'Y', 'INTERVAL', 'interval', '红包间隔人数', '2', '3', 'int', '14', null, 'Y', '5', 'N', null, 'R', '1', '2016-09-09 17:00:46', null, '2016-09-09 17:00:46', null, 'N');
INSERT INTO `ds_column` VALUES ('18', '1201bb89-e0d7-4f95-ad87-c0f80e5f8bba', null, 'Y', 'CREATE_TIME', 'create_time', '创建时间', '2', '3', 'timestamp', null, null, 'Y', '6', 'N', null, 'R', '1', '2016-09-09 17:01:22', null, '2016-09-09 17:01:22', null, 'N');
INSERT INTO `ds_column` VALUES ('19', 'dbc2e0d4-b0b6-42e8-aa84-831793522ae4', null, 'Y', 'UPDATE_TIME', 'update_time', '修改时间', '2', '3', 'timestamp', null, null, 'Y', '6', 'N', null, 'R', '1', '2016-09-09 17:01:44', null, '2016-09-09 17:01:44', null, 'N');
INSERT INTO `ds_column` VALUES ('20', '7ea46d62-5f4d-4511-ac81-a2a180747076', null, 'Y', 'STATUS', 'status', '状态', '2', '3', 'varchar', '10', null, 'Y', '7', 'N', null, 'R', '1', '2016-09-09 17:02:50', null, '2016-09-09 17:02:50', '启用 on  不启用 off', 'N');
INSERT INTO `ds_column` VALUES ('21', 'f739e50f-f807-46cf-b986-7bb57a8a72af', null, 'Y', 'ID', 'ID', '主键', '2', '4', 'int', '14', null, 'N', '0', 'Y', null, 'R', '1', '2016-11-10 13:44:15', '1', '2016-11-10 14:10:36', null, 'N');
INSERT INTO `ds_column` VALUES ('22', '3b147b98-c819-4e96-a1b1-e01db5bb1b4e', null, 'Y', 'ACTIVITYCODE', 'activityCode', '活动号', '2', '4', 'varchar', '10', null, 'Y', null, 'N', null, 'R', '1', '2016-11-10 13:46:52', null, '2016-11-10 13:46:52', null, 'N');
INSERT INTO `ds_column` VALUES ('23', '58217b80-fb6b-4d94-8574-74e2c0fad539', null, 'Y', 'CHANNELID', 'channelId', '渠道号', '2', '4', 'varchar', '10', null, 'Y', null, 'N', null, 'R', '1', '2016-11-10 13:47:22', null, '2016-11-10 13:47:22', null, 'N');
INSERT INTO `ds_column` VALUES ('24', '7aa6e993-c1e6-41b1-8b3a-e772c4c38580', null, 'Y', 'CREATETIME', 'createTime', '创建时间', '2', '4', 'varchar', '16', null, 'Y', null, 'N', null, 'R', '1', '2016-11-10 13:53:03', null, '2016-11-10 13:53:03', null, 'N');
INSERT INTO `ds_column` VALUES ('25', 'f02cb0c7-0b3a-41af-92d0-083df5e4b925', null, 'Y', 'USERNAME', 'userName', '用户名', '2', '4', 'varchar', '20', null, 'Y', null, 'N', null, 'R', '1', '2016-11-10 13:54:14', null, '2016-11-10 13:54:14', null, 'N');
INSERT INTO `ds_column` VALUES ('26', 'd4559301-c434-4ecd-9b3c-f7aa82e748db', null, 'Y', 'ID', 'id', 'id', '2', '5', 'int', '14', null, 'N', null, 'Y', null, 'R', '1', '2016-11-14 10:28:33', null, '2016-11-14 10:28:33', null, 'Y');
INSERT INTO `ds_column` VALUES ('27', '770ea7fd-24b1-49e9-8a1e-eb9f6a86909b', null, 'Y', 'ACTIVITYCODE', 'activitycode', '活动id', '2', '5', 'varchar', '10', null, 'Y', null, 'N', null, 'R', '1', '2016-11-14 10:29:19', null, '2016-11-14 10:29:19', null, 'Y');
INSERT INTO `ds_column` VALUES ('28', '374645e0-c6c7-4cd8-ab97-418a14731ef5', null, 'Y', 'ACTIVITYNAME', 'activityname', '活动名', '2', '5', 'varchar', '50', null, 'Y', null, 'N', null, 'R', '1', '2016-11-14 10:29:45', null, '2016-11-14 10:29:45', null, 'N');
INSERT INTO `ds_column` VALUES ('29', 'a84c4fb5-0572-4927-a84e-0740a272f844', null, 'Y', 'ACTIVITYURL', 'activityurl', '多动链接', '2', '5', 'varchar', '200', null, 'Y', null, 'N', null, 'R', '1', '2016-11-14 10:30:28', null, '2016-11-14 10:30:28', null, 'N');
INSERT INTO `ds_column` VALUES ('30', 'c22fe18a-dde8-49bd-b99f-4270050c902d', null, 'Y', 'STATUS', 'status', '状态', '2', '5', 'varchar', '10', null, 'Y', null, 'N', null, 'R', '1', '2016-11-14 10:30:54', null, '2016-11-14 10:30:54', null, 'N');
INSERT INTO `ds_column` VALUES ('31', '3fcc8925-0d3e-4ea9-935a-72bded0a8b98', null, 'Y', 'UPDATETIME', 'updatetime', '修改时间', '2', '5', 'varchar', '20', null, 'Y', null, 'N', null, 'R', '1', '2016-11-14 10:31:25', null, '2016-11-14 10:31:25', null, 'N');
INSERT INTO `ds_column` VALUES ('32', '3bd48982-ce28-4715-920a-56a6e78b5ee7', null, 'Y', 'CREATETIME', 'createtime', '创建时间', '2', '5', 'varchar', '20', null, 'Y', null, 'N', null, 'R', '1', '2016-11-14 10:31:52', null, '2016-11-14 10:31:52', null, 'N');
INSERT INTO `ds_column` VALUES ('33', 'bcea0d05-c061-4295-83c1-1fb7a064bc6d', null, 'Y', 'ID', 'id', 'id', '2', '6', 'int', '14', null, 'N', null, 'Y', null, 'R', '1', '2016-11-14 10:33:59', null, '2016-11-14 10:33:59', null, 'Y');
INSERT INTO `ds_column` VALUES ('34', 'a6898db1-b1ad-4f62-b73b-eb600e124abf', null, 'Y', 'ACTIVITYCODE', 'activitycode', '活动id', '2', '6', 'varchar', '10', null, 'N', null, 'N', null, 'R', '1', '2016-11-14 10:34:52', null, '2016-11-14 10:34:52', null, 'N');
INSERT INTO `ds_column` VALUES ('35', '72570973-669e-482d-b991-d51ee7d422b1', null, 'Y', 'CHANNELID', 'channelid', '渠道号', '2', '6', 'varchar', '20', null, 'N', null, 'N', null, 'R', '1', '2016-11-14 10:35:55', null, '2016-11-14 10:35:55', null, 'N');
INSERT INTO `ds_column` VALUES ('36', 'ebcba270-1e33-4a9d-bb5c-b9f7852e779f', null, 'Y', 'CHANNELNAME', 'channelname', '渠道名', '2', '6', 'varchar', '50', null, 'Y', null, 'N', null, 'R', '1', '2016-11-14 10:36:24', null, '2016-11-14 10:36:24', null, 'N');
INSERT INTO `ds_column` VALUES ('37', '6112277c-b401-449f-b67e-0d87cba6e723', null, 'Y', 'CHANNELURL', 'channelurl', '渠道链接', '2', '6', 'varchar', '200', null, 'N', null, 'N', null, 'R', '1', '2016-11-14 10:37:10', null, '2016-11-14 10:37:10', null, 'N');
INSERT INTO `ds_column` VALUES ('38', 'dc04c203-cb77-4aaa-bae2-711e0445cce1', null, 'Y', 'CREATETIME', 'createtime', '创建时间', '2', '6', 'varchar', '20', null, 'Y', null, 'N', null, 'R', '1', '2016-11-14 10:37:56', null, '2016-11-14 10:37:56', null, 'N');
INSERT INTO `ds_column` VALUES ('39', '735292ce-53af-412e-a0ee-f97d2b2aac7d', null, 'Y', 'UPDATETIME', 'updatetime', '修改时间', '2', '6', 'varchar', '20', null, 'Y', null, 'N', null, 'R', '1', '2016-11-14 10:38:10', null, '2016-11-14 10:38:10', null, 'N');
INSERT INTO `ds_column` VALUES ('40', '78a8311f-42c3-489e-92ba-4fb87ec4ecae', null, 'Y', 'STATUS', 'status', '状态', '2', '6', 'varchar', '10', null, 'Y', null, 'N', null, 'R', '1', '2016-11-15 09:59:10', null, '2016-11-15 09:59:10', null, 'N');
INSERT INTO `ds_column` VALUES ('41', '0c275e55-0017-42ed-bc86-e2d33d47fed6', null, 'Y', 'ID', 'id', '主键', '2', '8', 'int', '10', null, 'N', '0', 'Y', null, 'R', '1', '2016-11-24 15:31:04', '1', '2016-11-24 16:03:12', null, 'N');
INSERT INTO `ds_column` VALUES ('42', '7e0a0ddc-4321-4b19-8117-c340ea134a64', null, 'Y', 'ACTIVITYCODE', 'activitycode', '活动号', '2', '8', 'varchar', '20', null, 'Y', null, 'N', null, 'R', '1', '2016-11-24 15:31:40', null, '2016-11-24 15:31:40', null, 'N');
INSERT INTO `ds_column` VALUES ('43', '9736c266-f533-4b21-952f-a777869001b8', null, 'Y', 'USERNAME', 'username', '用户名', '2', '8', 'varchar', '30', null, 'Y', null, 'N', null, 'R', '1', '2016-11-24 15:32:03', null, '2016-11-24 15:32:03', null, 'N');
INSERT INTO `ds_column` VALUES ('44', 'f09310cb-03d1-4cfc-b04f-bcaa712b73ea', null, 'Y', 'PRIZEID', 'prizeid', '奖品id', '2', '8', 'integer', '20', null, 'Y', null, 'N', null, 'R', '1', '2016-11-24 15:32:38', null, '2016-11-24 15:32:38', null, 'N');
INSERT INTO `ds_column` VALUES ('45', 'f994c6f3-6c42-41c7-af19-72cc42121be6', null, 'Y', 'STATUS', 'status', '中奖状态', '2', '8', 'varchar', '10', null, 'Y', null, 'N', null, 'R', '1', '2016-11-24 15:40:11', null, '2016-11-24 15:40:11', null, 'N');
INSERT INTO `ds_column` VALUES ('46', 'bd961efd-e712-42ed-9fd3-4617034502e1', null, 'Y', 'CREATETIME', 'createtime', '创建时间', '2', '8', 'varchar', '30', null, 'Y', null, 'N', null, 'R', '1', '2016-11-24 15:40:33', null, '2016-11-24 15:40:33', null, 'N');
INSERT INTO `ds_column` VALUES ('47', '57bf8389-fe07-4e23-8bf5-91c3a76dd90d', null, 'Y', 'UPDATETIME', 'updatetime', '修改时间', '2', '8', 'varchar', '30', null, 'Y', null, 'N', null, 'R', '1', '2016-11-24 15:40:48', null, '2016-11-24 15:40:48', null, 'N');
INSERT INTO `ds_column` VALUES ('48', 'af817614-0405-48c1-8cfd-b8d3002a012f', null, 'Y', 'ID', 'id', '主键', '2', '9', 'int', '10', null, 'Y', '1', 'Y', null, 'R', '1', '2016-11-24 15:46:14', '1', '2016-11-24 16:02:34', null, 'N');
INSERT INTO `ds_column` VALUES ('49', '1a23acbb-f973-48cc-89e4-c40c93d463f8', null, 'Y', 'ACTIVITYCODE', 'activitycode', '活动号', '2', '9', 'varchar', '20', null, 'Y', null, 'N', null, 'R', '1', '2016-11-24 15:46:31', null, '2016-11-24 15:46:31', null, 'N');
INSERT INTO `ds_column` VALUES ('50', '8ea33d55-6475-479f-98fd-99c1a05584ff', null, 'Y', 'PRIZENAME', 'prizename', '奖品名称', '2', '9', 'varchar', '50', null, 'Y', null, 'N', null, 'R', '1', '2016-11-24 15:47:38', null, '2016-11-24 15:47:38', null, 'N');
INSERT INTO `ds_column` VALUES ('51', '919118f3-c336-4657-9e1b-b8d2780cdc27', null, 'Y', 'PRIZENUM', 'prizenum', '奖品数量', '2', '9', 'integer', '10', null, 'Y', null, 'N', null, 'R', '1', '2016-11-24 15:48:09', null, '2016-11-24 15:48:09', null, 'N');
INSERT INTO `ds_column` VALUES ('52', '35a1959c-b45f-4a0c-9ab1-a3f655903a20', null, 'Y', 'PR', 'pr', '中奖概率', '2', '9', 'varchar', '10', null, 'Y', null, 'N', null, 'R', '1', '2016-11-24 15:49:03', null, '2016-11-24 15:49:03', null, 'N');
INSERT INTO `ds_column` VALUES ('53', 'c819e741-fa85-436c-a747-65c39fc0053e', null, 'Y', 'STATUS', 'status', '奖品状态', '2', '9', 'varchar', '10', null, 'Y', null, 'N', null, 'R', '1', '2016-11-24 15:49:29', null, '2016-11-24 15:49:29', null, 'N');
INSERT INTO `ds_column` VALUES ('54', '73c84910-a445-4ef1-a56e-c5ee10c928b6', null, 'Y', 'CREATETIME', 'createtime', '创建时间', '2', '9', 'varchar', '30', null, 'Y', null, 'N', null, 'R', '1', '2016-11-24 15:49:45', null, '2016-11-24 15:49:45', null, 'N');
INSERT INTO `ds_column` VALUES ('55', '4f705b11-1491-4bd9-a182-2246139e6ba4', null, 'Y', 'UPDATETIME', 'updatetime', '更新时间', '2', '9', 'varchar', '30', null, 'Y', null, 'N', null, 'R', '1', '2016-11-24 15:50:01', null, '2016-11-24 15:50:01', null, 'N');
INSERT INTO `ds_column` VALUES ('56', 'cb1312b9-1fdc-40dd-a3c8-2f572551ba06', null, 'Y', 'ORDERNUM', 'ordernum', '排序', '2', '8', 'integer', '10', '0', 'Y', null, 'N', null, 'R', '1', '2016-11-24 15:52:02', null, '2016-11-24 15:52:02', null, 'N');
INSERT INTO `ds_column` VALUES ('57', 'fe75c273-0ac3-4a7f-9168-8335dd07ff27', null, 'Y', 'ID', 'id', 'id', '2', '10', 'int', null, null, 'N', null, 'Y', null, 'R', '1', '2016-12-01 13:43:54', null, '2016-12-01 13:43:54', null, 'N');
INSERT INTO `ds_column` VALUES ('58', '8b90dbe0-fd04-44b6-8352-446860a8dfb8', null, 'Y', 'TYPE', 'type', '类型', '2', '10', 'varchar', '10', '0', 'Y', '0', 'N', null, 'R', '1', '2016-12-01 13:45:16', '1', '2016-12-01 13:47:20', null, 'N');
INSERT INTO `ds_column` VALUES ('59', '5eb7d461-1293-43b6-a223-3d963de37b33', null, 'Y', 'PID', 'pid', '父id', '2', '10', 'int', null, null, 'N', null, 'N', null, 'R', '1', '2016-12-01 13:46:41', null, '2016-12-01 13:46:41', null, 'N');
INSERT INTO `ds_column` VALUES ('60', '72f3a6d6-9008-41d4-ae7c-f77a0135ce23', null, 'Y', 'CODE', 'code', '代码key', '2', '10', 'varchar', '20', null, 'N', null, 'N', null, 'R', '1', '2016-12-01 13:49:03', null, '2016-12-01 13:49:03', null, 'N');
INSERT INTO `ds_column` VALUES ('61', 'a89e1b53-52b6-4a68-b513-2f0584ca3cbb', null, 'Y', 'CODE_NAME', 'code_name', '名称', '2', '10', 'varchar', '20', null, 'N', null, 'N', null, 'R', '1', '2016-12-01 13:50:50', null, '2016-12-01 13:50:50', null, 'N');
INSERT INTO `ds_column` VALUES ('62', '0601b3b6-6227-4cfa-887d-dfae69ba1778', null, 'Y', 'SORT_NUM', 'sort_num', '排序', '2', '10', 'int', null, '0', 'N', null, 'N', null, 'R', '1', '2016-12-01 13:51:38', null, '2016-12-01 13:51:38', null, 'N');
INSERT INTO `ds_column` VALUES ('63', 'c55f18c0-81a4-4d48-97df-818faa7cee1a', null, 'Y', 'CREATETIME', 'createtime', '创建时间', '2', '10', 'varchar', '30', null, 'Y', null, 'N', null, 'R', '1', '2016-12-01 13:52:00', null, '2016-12-01 13:52:00', null, 'N');
INSERT INTO `ds_column` VALUES ('64', '66ca1bd7-f6d1-45de-ade9-442c3fa0b814', null, 'Y', 'UPDATETIME', 'updatetime', '修改时间', '2', '10', 'varchar', '30', null, 'Y', null, 'N', null, 'R', '1', '2016-12-01 13:52:20', null, '2016-12-01 13:52:20', null, 'N');

-- ----------------------------
-- Table structure for `ds_datasource`
-- ----------------------------
DROP TABLE IF EXISTS `ds_datasource`;
CREATE TABLE `ds_datasource` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `OGID` varchar(40) DEFAULT NULL COMMENT '对象全局编号',
  `OVER` varchar(25) DEFAULT NULL COMMENT '版本',
  `IS_VALID` char(1) NOT NULL DEFAULT 'Y' COMMENT '有效性(Y有效, N无效)',
  `TYPE_CD` varchar(10) NOT NULL COMMENT '类型',
  `CODE` varchar(40) NOT NULL COMMENT '代码(数据源名)',
  `NAME` varchar(40) DEFAULT NULL COMMENT '英文名称',
  `LABEL` varchar(80) NOT NULL COMMENT '中文名称',
  `DRIVER_CLASS` varchar(40) DEFAULT NULL COMMENT '驱动类',
  `JDBC_URL` varchar(200) DEFAULT NULL COMMENT '数据库连接地址',
  `USER_NAME` varchar(40) DEFAULT NULL COMMENT '用户名',
  `USER_PASSWORD` varchar(40) DEFAULT NULL COMMENT '密码',
  `PROJECT_ID` bigint(11) NOT NULL COMMENT '开发项目编号',
  `CREATE_USER_ID` bigint(11) DEFAULT NULL COMMENT '创建用户编号',
  `CREATE_DATE` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER_ID` bigint(11) DEFAULT NULL COMMENT '更新用户编号',
  `UPDATE_DATE` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `NOTE` varchar(2000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of ds_datasource
-- ----------------------------
INSERT INTO `ds_datasource` VALUES ('2', '81937cac-c6f7-45b0-9925-2dfea1af0088', null, 'Y', 'mysql', 'abin', 'abin', '阿宾', null, null, null, null, '1', '1', '2016-09-04 09:08:39', '1', '2016-09-09 10:19:18', null);
INSERT INTO `ds_datasource` VALUES ('3', 'd09106ef-4db3-4155-8a31-89ad2dcee3d6', null, 'Y', 'oracle', 'activity', 'activity', 'activity', null, null, null, null, '2', '1', '2016-09-09 10:19:52', null, '2016-09-09 10:19:52', null);

-- ----------------------------
-- Table structure for `ds_table`
-- ----------------------------
DROP TABLE IF EXISTS `ds_table`;
CREATE TABLE `ds_table` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `OGID` varchar(40) DEFAULT NULL COMMENT '对象全局编号',
  `OVER` varchar(25) DEFAULT NULL COMMENT '版本',
  `IS_VALID` char(1) NOT NULL DEFAULT 'Y' COMMENT '有效性(Y有效, N无效)',
  `TYPE_CD` varchar(2) DEFAULT NULL COMMENT '表类型(W工作表,N虚拟表,S单例表)',
  `CODE` varchar(40) NOT NULL COMMENT '代码',
  `NAME` varchar(40) DEFAULT NULL COMMENT '英文名称',
  `LABEL` varchar(400) DEFAULT NULL COMMENT '中文名称',
  `TABLESPACE_NAME` varchar(40) DEFAULT NULL COMMENT '空间名称',
  `SEQUENCE_NAME` varchar(30) DEFAULT NULL COMMENT '序列名称',
  `DATASOURCE_ID` bigint(11) DEFAULT NULL COMMENT '数据源编号',
  `CREATE_USER_ID` bigint(11) DEFAULT NULL COMMENT '创建用户编号',
  `CREATE_DATE` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER_ID` bigint(11) DEFAULT NULL COMMENT '更新用户编号',
  `UPDATE_DATE` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `NOTE` varchar(2000) DEFAULT NULL COMMENT '备注',
  `LINK_UNIQUE` varchar(80) DEFAULT NULL COMMENT '联合唯一',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `uk_link_ds_table` (`DATASOURCE_ID`,`CODE`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of ds_table
-- ----------------------------
INSERT INTO `ds_table` VALUES ('1', '7a84ebd8-f9d2-4435-9660-d6387d6ae4c8', null, 'Y', 'S', 'bs_user', 'bs_user', '用户表111', null, null, '1', '1', '2016-09-04 09:33:15', '1', '2016-09-04 09:37:38', null, null);
INSERT INTO `ds_table` VALUES ('2', '32078519-be00-47da-b426-b0da45962a27', null, 'Y', 'S', 'act_bd_activity', 'act_bd_activity', '补登红包活动', null, null, '2', '1', '2016-09-09 10:22:06', null, '2016-09-09 10:22:06', null, null);
INSERT INTO `ds_table` VALUES ('3', 'cbcd9fa2-8bc5-46c1-91fe-2afc5f18dee3', null, 'Y', 'S', 'act_bd_activity_rule', 'act_bd_activity_rule', '活动红包规则', null, null, '2', '1', '2016-09-09 16:44:40', null, '2016-09-09 16:44:40', null, null);
INSERT INTO `ds_table` VALUES ('4', '937c9c34-4bcc-4055-ad84-70a0f1e56b4b', null, 'Y', 'S', 'act_tg_register', 'act_bd_register', '推广注册记录表', null, null, '2', '1', '2016-11-10 13:41:16', '1', '2016-11-10 13:56:18', null, null);
INSERT INTO `ds_table` VALUES ('5', '71a2ee60-4085-4b96-848f-ebfa3518ee1d', null, 'Y', 'S', 'act_tg_activity', 'act_tg_activity', '推广活动表', null, null, '2', '1', '2016-11-14 10:27:46', null, '2016-11-14 10:27:46', null, null);
INSERT INTO `ds_table` VALUES ('6', '5b0bdb10-8c34-4d89-afc4-a1863a7ce450', null, 'Y', 'S', 'act_tg_activity_channel', 'act_tg_activity_channel', '活动渠道表', null, null, '2', '1', '2016-11-14 10:33:12', '1', '2016-11-14 11:14:30', null, null);
INSERT INTO `ds_table` VALUES ('7', 'ad3107b1-4138-4b67-831e-db3f073edf30', null, 'Y', 'S', 'tbl_users', 'TBL_USERS', 'TBL_USERS', null, null, '1', '1', '2016-11-22 10:34:36', null, '2016-11-22 10:34:36', null, null);
INSERT INTO `ds_table` VALUES ('8', 'e57a5adf-3fc5-4a24-a474-180e128fab7b', null, 'Y', 'S', 'act_tg_activity_user_prize', 'act_tg_activity_user_prize', '用户中奖情况表', null, null, '2', '1', '2016-11-24 15:30:29', '1', '2016-11-24 15:45:18', null, null);
INSERT INTO `ds_table` VALUES ('9', 'd20edc29-4e7b-4fca-9b96-a51adc3e5121', null, 'Y', 'S', 'act_tg_activity_prizes', 'act_tg_activity_prizes', '活动奖品管理表', null, null, '2', '1', '2016-11-24 15:45:43', '1', '2016-11-24 16:05:03', null, null);
INSERT INTO `ds_table` VALUES ('10', '0132f1fa-9b24-4aee-926a-1c2ec2babeee', null, 'Y', 'S', 'act_dict', 'act_dict', '活动数据字典', null, null, '2', '1', '2016-12-01 13:43:18', '1', '2016-12-01 13:43:26', null, null);

-- ----------------------------
-- Table structure for `sy_catalog_node`
-- ----------------------------
DROP TABLE IF EXISTS `sy_catalog_node`;
CREATE TABLE `sy_catalog_node` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(100) DEFAULT NULL COMMENT 'uuid`',
  `catalog_id` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `is_valid` varchar(10) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `label` varchar(200) DEFAULT NULL,
  `has_child` varchar(10) DEFAULT NULL,
  `type_name` varchar(100) DEFAULT NULL,
  `icon_name` varchar(100) DEFAULT NULL,
  `disp_order` int(11) DEFAULT NULL,
  `link_catalog` varchar(200) DEFAULT NULL,
  `outer_catalog` varchar(2000) DEFAULT NULL,
  `do_redirect` varchar(200) DEFAULT NULL,
  `do_invoke` varchar(200) DEFAULT NULL,
  `do_introduce` varchar(200) DEFAULT NULL,
  `note` varchar(2000) DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_catalog_node
-- ----------------------------
INSERT INTO `sy_catalog_node` VALUES ('1', null, null, '0', 'Y', 'sy_menu', 'sy_menu', '系统管理', 'Y', 'MENU', 'form-config', '2', 'root', null, null, 'sy/main/center.do', 'sy/main/goIntroduce.do', null, '1', '2016-09-03 15:28:53');
INSERT INTO `sy_catalog_node` VALUES ('2', null, null, '1', 'Y', 'user_menu', 'user_menu', '用户管理', 'Y', 'MENU', null, '1', '', null, null, null, null, null, '1', '2016-09-02 14:57:01');
INSERT INTO `sy_catalog_node` VALUES ('3', null, null, '2', 'Y', 'sy_user_list', 'sy_user_list', '用户列表', 'N', 'MENU', null, '1', '', null, null, 'sy/user/goMain.do', null, null, '1', '2016-09-02 14:57:01');
INSERT INTO `sy_catalog_node` VALUES ('4', null, null, '2', 'Y', 'sy_role_list', 'sy_role_list', '角色列表', 'N', 'MENU', null, '2', '', null, null, 'sy/role/goMain.do', null, null, '1', '2016-09-02 14:57:01');
INSERT INTO `sy_catalog_node` VALUES ('5', null, null, '2', 'Y', 'role_power', 'role_power', '角色权限', 'N', 'MENU', null, '3', '', null, null, 'sy/CatalogRole/goRoleForm.do', null, null, '1', '2016-09-02 14:57:01');
INSERT INTO `sy_catalog_node` VALUES ('6', null, null, '2', 'Y', 'menu_list', 'menu_list', '菜单目录', 'N', 'MENU', null, '4', '', null, null, 'sy/catalogNode/goSyCatalogTree.do', null, null, '1', '2016-09-02 14:57:01');
INSERT INTO `sy_catalog_node` VALUES ('7', '85198b26-6c44-47ea-a0a7-c8e512e0d99c', null, '0', 'Y', 'code_menu', 'code_menu', '数据源', 'Y', 'MENU', 'db-dbgroup', '1', null, null, null, 'sy/main/center.do', 'sy/main/goIntroduce.do', null, '1', '2016-09-03 15:29:07');
INSERT INTO `sy_catalog_node` VALUES ('8', '722ba244-e37b-4db3-ae63-8f7a4d85c521', null, '7', 'Y', 'data_db_manger', 'data_db_manger', '数据表', 'Y', 'MENU', 'ds-ds', '2', null, null, null, null, null, null, '1', '2016-09-03 15:18:58');
INSERT INTO `sy_catalog_node` VALUES ('9', '67f5bbb7-e721-43d2-809a-dc73f5154ce2', null, '7', 'Y', 'code_Projetc', 'code_Projetc', '数据源', 'Y', 'MENU', null, '2', null, null, null, null, null, null, '1', '2016-09-03 14:44:09');
INSERT INTO `sy_catalog_node` VALUES ('10', 'cfbebdf5-d2c3-4e05-b344-e3af3b9749a5', null, '9', 'Y', 'data_source_list', 'data_source_list', '数据源列表', 'N', 'MENU', null, '1', null, null, null, 'code/ds/datasource/goMain.do', null, null, '1', '2016-09-03 15:29:41');
INSERT INTO `sy_catalog_node` VALUES ('11', '0f30a1d0-1677-4ebc-aea0-133c75762ffe', null, '8', 'Y', 'table_abin', 'table_abin', 'Abin ', 'N', 'MENU', 'form-list', '2', null, null, null, 'code/ds/table/goMain.do?datasourceId=1&projectId=1207', null, null, '1', '2016-11-10 11:51:46');
INSERT INTO `sy_catalog_node` VALUES ('12', 'fe3b2829-c341-4f93-9292-894ac6b64d1e', null, '8', 'Y', 'data_source_list_act', 'data_source_list_act', '活动平台', 'N', 'MENU', 'form-list', '1', null, null, null, 'code/ds/table/goMain.do?datasourceId=2&projectId=1207', null, null, '1', '2016-11-10 11:51:37');

-- ----------------------------
-- Table structure for `sy_catalog_role`
-- ----------------------------
DROP TABLE IF EXISTS `sy_catalog_role`;
CREATE TABLE `sy_catalog_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `is_valid` varchar(10) DEFAULT NULL,
  `node_ids` varchar(2000) DEFAULT NULL,
  `power_node_ids` varchar(2000) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_catalog_role
-- ----------------------------
INSERT INTO `sy_catalog_role` VALUES ('1', 'Y', '7,8,11,12,9,10,1,2,3,4,5,6', ',7,8,11,12,9,10,1,2,3,4,5,6', '1', '1', '2016-09-09 10:21:07');

-- ----------------------------
-- Table structure for `sy_role`
-- ----------------------------
DROP TABLE IF EXISTS `sy_role`;
CREATE TABLE `sy_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(100) DEFAULT NULL COMMENT 'uuid`',
  `is_valid` varchar(10) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `label` varchar(200) DEFAULT NULL,
  `icon_name` varchar(100) DEFAULT NULL,
  `note` varchar(2000) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_role
-- ----------------------------
INSERT INTO `sy_role` VALUES ('1', 'a315cc8e-6b1e-4384-9f3e-3ba4a29a09cf', 'Y', 'admin', null, 'admin', 'admin', ' 管理员', 'admin', '2016-09-02 14:49:38');

-- ----------------------------
-- Table structure for `sy_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `sy_role_user`;
CREATE TABLE `sy_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `status` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `note` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sy_role_user
-- ----------------------------
INSERT INTO `sy_role_user` VALUES ('1', 'b43037b3-d175-4e08-866b-7eddb1b91017\r\n', '1', '1', '1', null, null, '2016-09-02 14:53:16');

-- ----------------------------
-- Table structure for `sy_user`
-- ----------------------------
DROP TABLE IF EXISTS `sy_user`;
CREATE TABLE `sy_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` varchar(2) DEFAULT NULL COMMENT '状态',
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `mobile` varchar(30) DEFAULT NULL,
  `id_number` varchar(20) DEFAULT NULL,
  `sex_cd` varchar(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user_id` int(11) DEFAULT NULL,
  `note` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_user
-- ----------------------------
INSERT INTO `sy_user` VALUES ('1', '1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'luoyang', '15990096417', null, 'M', '1991-03-10', '2016-09-02 14:25:34', '1', null);
