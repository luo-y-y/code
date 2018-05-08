/*
Navicat MySQL Data Transfer

Source Server         : 192.168.23.212
Source Server Version : 50714
Source Host           : 192.168.23.212:3306
Source Database       : catcode

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-09-02 17:00:59
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_catalog_node
-- ----------------------------
INSERT INTO `sy_catalog_node` VALUES ('1', null, null, '0', 'Y', 'sy_menu', 'sy_menu', '系统管理', 'Y', 'MENU', null, '2', 'root', null, null, 'sy/main/center.do', 'sy/main/goIntroduce.do', null, '1', '2016-09-02 15:22:14');
INSERT INTO `sy_catalog_node` VALUES ('2', null, null, '1', 'Y', 'user_menu', 'user_menu', '用户管理', 'Y', 'MENU', null, '1', '', null, null, null, null, null, '1', '2016-09-02 14:57:01');
INSERT INTO `sy_catalog_node` VALUES ('3', null, null, '2', 'Y', 'sy_user_list', 'sy_user_list', '用户列表', 'N', 'MENU', null, '1', '', null, null, 'sy/user/goMain.do', null, null, '1', '2016-09-02 14:57:01');
INSERT INTO `sy_catalog_node` VALUES ('4', null, null, '2', 'Y', 'sy_role_list', 'sy_role_list', '角色列表', 'N', 'MENU', null, '2', '', null, null, 'sy/role/goMain.do', null, null, '1', '2016-09-02 14:57:01');
INSERT INTO `sy_catalog_node` VALUES ('5', null, null, '2', 'Y', 'role_power', 'role_power', '角色权限', 'N', 'MENU', null, '3', '', null, null, 'sy/CatalogRole/goRoleForm.do', null, null, '1', '2016-09-02 14:57:01');
INSERT INTO `sy_catalog_node` VALUES ('6', null, null, '2', 'Y', 'menu_list', 'menu_list', '菜单目录', 'N', 'MENU', null, '4', '', null, null, 'sy/catalogNode/goSyCatalogTree.do', null, null, '1', '2016-09-02 14:57:01');

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
INSERT INTO `sy_catalog_role` VALUES ('1', 'Y', '1,2,3,4,5,6', ',1,2,3,4,5,6', '1', '1', '2016-09-02 16:06:41');

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
