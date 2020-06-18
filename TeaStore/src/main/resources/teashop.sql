/*
Navicat MySQL Data Transfer

Source Server         : aaa
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : teashop

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-04-11 15:23:14

数据库名: teashop  ，账号用户: root,   密码 :  空

*/


DROP DATABASE IF EXISTS teashop;
CREATE DATABASE teashop;
USE teashop;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `goodscode` varchar(255) DEFAULT NULL,
  `goodsname` varchar(255) DEFAULT NULL,
  `goodsbrand` varchar(255) DEFAULT NULL,
  `goodspicture` varchar(255) DEFAULT NULL,
  `goodspecs` varchar(255) DEFAULT NULL,
  `goodstype` varchar(255) DEFAULT NULL,
  `salePrice` double DEFAULT NULL,
  `count` int(255) DEFAULT NULL,
  `isonsale` char(255) DEFAULT NULL,
  `goodsDescribe` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '0001', '西湖龙井', 'Tea Design', 'static/img/productimgs01.jpg', '45克/罐', '龙井', '300', '2659', '1', '正宗味道普及款 绿茶');
INSERT INTO `goods` VALUES ('2', '002', '新茶 ', 'Tea Design', 'static/img/productimgs02.jpg', '45克/罐', '龙井', '500', '380', '1', '明前特级贡韵西湖龙井 鲜醇甘爽');
INSERT INTO `goods` VALUES ('3', '003', '明前特级黄山毛峰  ', 'Tea Design', 'static/img/productimgs03.jpg', '80克/罐', '黄山毛峰', '300', '235', '1', '鲜美醇爽 茶叶');
INSERT INTO `goods` VALUES ('4', '004', '新茶', 'Tea Design', 'static/img/productimgs04.jpg', '45克/罐', '安吉白茶', '600', '665', '1', '雨前一级安吉白茶 鲜爽浓厚');
INSERT INTO `goods` VALUES ('5', '005', '新茶', 'Tea Design', 'static/img/productimgs05.jpg', '45克/罐', '龙井', '650', '325', '1', '雨前西湖龙井 靠谱茶 醇厚回甘');
INSERT INTO `goods` VALUES ('6', '006', '菊博士胎菊王', 'Tea Design', 'static/img/productimgs06.jpg', '80克/罐', ' 菊花茶', '650', '655', '1', '桐乡杭白菊 菊花茶');
INSERT INTO `goods` VALUES ('7', '007', '桂花茶', 'Tea Design', 'static/img/productimgs07.jpg', '75克/罐', '花茶', '75', '750', '1', '回味清甘 杭州西子特产 花草茶');
INSERT INTO `goods` VALUES ('8', '008', '茉莉花茶', 'Tea Design', 'static/img/productimgs08.jpg', '45克/罐', '花茶', '85', '5222', '1', ' 清甜淡雅 广西横县产 花草茶');
INSERT INTO `goods` VALUES ('9', '009', '洋甘菊', 'Tea Design', 'static/img/productimgs09.jpg', '60克/罐', '花草茶', '200', '1222', '1', '甘醇适口 花草茶');
INSERT INTO `goods` VALUES ('10', '010', '金银花', 'Tea Design', 'static/img/productimgs10.jpg', '70克/罐', '花草茶', '300', '8846', '1', '河南封丘产 花草茶');
INSERT INTO `goods` VALUES ('11', '011', '红枸杞子', 'Tea Design', 'static/img/productimgs11.jpg', '70克/罐', '花草茶', '1200', '212', '1', '温润味甘 宁夏中宁产 花草茶');
INSERT INTO `goods` VALUES ('12', '012', '黑苦荞茶', 'Tea Design', 'static/img/productimgs12.jpg', '70克/罐', '荞麦茶', '800', '455', '1', '醇厚回甘 四川凉山产 荞麦茶');
INSERT INTO `goods` VALUES ('13', '4e3d88ea', '荆州龙井', 'Tea Design', 'static/img/none.jpg', '45克/罐', '龙井', '220', '9527', '1', '贼好喝又便宜');

-- ----------------------------
-- Table structure for orderdetails
-- ----------------------------
DROP TABLE IF EXISTS `orderdetails`;
CREATE TABLE `orderdetails` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `goodscode` varchar(60) DEFAULT NULL,
  `goodsname` varchar(30) DEFAULT NULL,
  `buyCount` int(10) DEFAULT NULL,
  `goodsPrice` double DEFAULT NULL,
  `orderId` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetails
-- ----------------------------
INSERT INTO `orderdetails` VALUES ('1', '0001', '西湖龙井', '3', '300', '001');
INSERT INTO `orderdetails` VALUES ('2', '005', '新茶', '4', '650', '001');
INSERT INTO `orderdetails` VALUES ('3', '010', '金银花', '1', '300', '002');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `orderId` varchar(20) NOT NULL,
  `userId` varchar(20) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `orderPrice` double DEFAULT NULL,
  `orderDate` varchar(100) DEFAULT NULL,
  `orderState` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '001', '002', 'lucy', '3500', '2020-04-11', '1');
INSERT INTO `orders` VALUES ('2', '002', '002', 'lucy', '300', '2020-04-11', '0');

-- ----------------------------
-- Table structure for shoppingcar
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcar`;
CREATE TABLE `shoppingcar` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `goodscode` varchar(60) DEFAULT NULL,
  `goodsname` varchar(30) DEFAULT NULL,
  `goodsPicture` varchar(100) DEFAULT NULL,
  `goodsPrice` double DEFAULT NULL,
  `buyCount` int(10) DEFAULT NULL,
  `goodsDescribe` varchar(100) DEFAULT NULL,
  `userId` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoppingcar
-- ----------------------------
INSERT INTO `shoppingcar` VALUES ('1', '0001', '西湖龙井', 'static/img/productimgs01.jpg', '300', '8', '正宗味道普及款 绿茶', '2');
INSERT INTO `shoppingcar` VALUES ('3', '002', '新茶', 'static/img/productimgs02.jpg', '500', '2', '明前特级贡韵西湖龙井 鲜醇甘爽', '2');
INSERT INTO `shoppingcar` VALUES ('7', '0001', '西湖龙井', 'static/img/productimgs01.jpg', '300', '1', '正宗味道普及款 绿茶', '2');
INSERT INTO `shoppingcar` VALUES ('10', '004', '新茶', 'static/img/productimgs04.jpg', '600', '5', '雨前一级安吉白茶 鲜爽浓厚', '2');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` varchar(20) DEFAULT NULL,
  `accountNumber` varchar(20) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `isadmin` int(1) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '001', 'abcd', '123', '0', 'Lucky', '武汉', '17684956651');
INSERT INTO `userinfo` VALUES ('2', '002', 'aaa', '111', '0', 'lucy', '荆州', '13746958424');
INSERT INTO `userinfo` VALUES ('3', '003', 'root', '000', '1', 'admin', '湖南', '15134658866');
INSERT INTO `userinfo` VALUES ('4', '12439aa5', 'Lucky', '123456', '0', '张一山', '北京', '13795621164');
INSERT INTO `userinfo` VALUES ('5', '0a27fdcc', 'alice', '666', '0', '爱丽丝', '美国', '98654255');
INSERT INTO `userinfo` VALUES ('6', 'f14e4997', 'queen', '233', '0', '程安', '广东', '17767774777');
