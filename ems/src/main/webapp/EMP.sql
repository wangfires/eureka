/*
Navicat MySQL Data Transfer

Source Server         : 193.112.30.203
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ems

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-04-22 21:14:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `ID` varchar(40) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `PRICE` double DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
