/*
Navicat MySQL Data Transfer

Source Server         : 193.112.30.203
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ems

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-04-22 21:14:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` varchar(40) NOT NULL,
  `NICKNAME` varchar(20) DEFAULT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `PHONE` varchar(10) DEFAULT NULL,
  `SEX` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
