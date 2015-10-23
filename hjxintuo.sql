/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : hjxintuo

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2015-10-23 11:02:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('19');

-- ----------------------------
-- Table structure for `tb_account`
-- ----------------------------
DROP TABLE IF EXISTS `tb_account`;
CREATE TABLE `tb_account` (
  `id` int(11) NOT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `version` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000',
  `userId` int(11) NOT NULL,
  `balance` float unsigned zerofill NOT NULL DEFAULT '000000000000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_account
-- ----------------------------
INSERT INTO `tb_account` VALUES ('1', '2015-10-08 10:43:23', '00000000001', '11', '000000020000');
INSERT INTO `tb_account` VALUES ('18', '2015-10-12 11:26:10', '00000000000', '17', '000000000000');

-- ----------------------------
-- Table structure for `tb_invest_record`
-- ----------------------------
DROP TABLE IF EXISTS `tb_invest_record`;
CREATE TABLE `tb_invest_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `version` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000',
  `userId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `investNum` float NOT NULL,
  `status` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FKd2845rugbkoi8uwj615sns0p2` (`userId`),
  KEY `FK8pe60bl6730svpw384d5h4yx5` (`productId`),
  CONSTRAINT `FK8pe60bl6730svpw384d5h4yx5` FOREIGN KEY (`productId`) REFERENCES `tb_product` (`id`),
  CONSTRAINT `FKd2845rugbkoi8uwj615sns0p2` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_invest_record
-- ----------------------------
INSERT INTO `tb_invest_record` VALUES ('1', '2015-10-06 14:04:30', '00000000001', '11', '2', '2000', '0');
INSERT INTO `tb_invest_record` VALUES ('2', '2015-10-13 10:07:53', '00000000001', '11', '1', '3000', '0');
INSERT INTO `tb_invest_record` VALUES ('3', '2015-10-07 09:38:08', '00000000000', '11', '2', '2000', '0');
INSERT INTO `tb_invest_record` VALUES ('4', '2015-10-10 09:40:18', '00000000000', '11', '2', '2000', '0');
INSERT INTO `tb_invest_record` VALUES ('5', '2015-10-10 09:56:08', '00000000000', '11', '0', '1000', '0');
INSERT INTO `tb_invest_record` VALUES ('6', '2015-10-10 09:56:32', '00000000000', '11', '4', '3000', '0');

-- ----------------------------
-- Table structure for `tb_product`
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `id` int(11) NOT NULL,
  `version` int(11) unsigned zerofill NOT NULL,
  `dateCreated` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `title` varchar(255) NOT NULL,
  `category` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `rateOfReturn` float NOT NULL,
  `minBuy` float NOT NULL,
  `alreadyBuyNum` float NOT NULL,
  `buyPeopleNum` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_product
-- ----------------------------
INSERT INTO `tb_product` VALUES ('0', '00000000000', '2015-09-30 09:50:13', '投360众筹基金', '3', '2015-09-29', '2016-08-15', '7.8', '1000', '2156000', '103', '0');
INSERT INTO `tb_product` VALUES ('1', '00000000000', '2015-09-30 09:50:13', '新手专享0069期', '0', '2015-09-20', '2015-12-20', '10', '100', '4216500', '5901', '0');
INSERT INTO `tb_product` VALUES ('2', '00000000000', '2015-09-30 09:50:13', '存得乐03期', '1', '2015-08-11', '2016-03-20', '9.5', '2000', '342610', '1005', '0');
INSERT INTO `tb_product` VALUES ('3', '00000000000', '2015-09-30 09:50:13', '信聚金0266期', '2', '2015-07-01', '2016-07-21', '8.5', '1000', '1045600', '2133', '0');
INSERT INTO `tb_product` VALUES ('4', '00000000000', '2015-09-30 09:50:13', '西天取经0012期', '0', '2015-10-01', '2017-01-01', '8', '1000', '56000', '560', '0');
INSERT INTO `tb_product` VALUES ('5', '00000000000', '2015-10-14 16:54:39', '西天取经0013期', '1', '2015-10-14', '2016-01-22', '9', '1000', '56700', '470', '0');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) unsigned NOT NULL DEFAULT '0',
  `dateCreated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userName` varchar(16) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('11', '0', '2015-10-08 18:47:29', '15818603685', '96e79218965eb72c92a549dd5a330112');
INSERT INTO `tb_user` VALUES ('17', '0', null, '15818603686', '96e79218965eb72c92a549dd5a330112');
