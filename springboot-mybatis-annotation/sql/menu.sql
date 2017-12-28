/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : lin

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 12/22/2017 15:38:49 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `parentid` int(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `num` int(11) DEFAULT NULL,
  `levels` int(11) DEFAULT NULL,
  `tips` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `menu`
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES ('1', null, '0', '用户管理', 'fa-columns', '/userpage', null, '1', null), ('2', null, '1', '部门管理', 'fa-clone', '/deptpage', null, '1', null), ('3', '', '1', '角色管理', 'fa-tags', '/rolepage', null, '1', ''), ('4', '', '1', '我的便签', 'fa-sticky-note', '/memopage', null, '1', ''), ('5', null, '2', '发送通知', 'fa-share', '/noticepage', null, '1', null), ('6', null, '2', '登陆日志', 'fa-tags', '/loginlogpage', null, '2', null), ('8', null, '2', '操作日志', 'fa-tags', '/operationlogpage', null, '2', null), ('9', null, null, '请假', 'fa-calendar-plus-o', '/leavepage', null, '1', ''), ('10', null, null, '请假审核', 'fa-calendar-plus-o', '/operationleavepage', null, '1', null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
