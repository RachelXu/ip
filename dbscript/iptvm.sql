/*
Navicat MySQL Data Transfer

Source Server         : RealServer
Source Server Version : 50173
Source Host           : 188.138.89.40:3306
Source Database       : iptvm

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-08-20 16:38:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `AccountID` varchar(20) NOT NULL,
  `State` int(11) NOT NULL,
  PRIMARY KEY (`AccountID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('00110568C712', '1001');
INSERT INTO `account` VALUES ('11820002DE1D', '1001');
INSERT INTO `account` VALUES ('11820005B2D3', '1003');
INSERT INTO `account` VALUES ('1182000612C5', '1003');
INSERT INTO `account` VALUES ('FC4BBC05179F', '1003');
INSERT INTO `account` VALUES ('FC4BBC2A374D', '1003');
INSERT INTO `account` VALUES ('FC4BBC2A3917', '1001');
INSERT INTO `account` VALUES ('FC4BBC2B1AAE', '1001');
INSERT INTO `account` VALUES ('FC4BBC2B7C4A', '1002');
INSERT INTO `account` VALUES ('FC4BBC2B903A', '1002');
INSERT INTO `account` VALUES ('FC4BBC2B9910', '1002');
INSERT INTO `account` VALUES ('FC4BBC2B9CA1', '1003');
INSERT INTO `account` VALUES ('FC4BBC2C928C', '1004');
INSERT INTO `account` VALUES ('FC4BBC2C9519', '1002');
INSERT INTO `account` VALUES ('FC4BBC2C98E4', '1002');
INSERT INTO `account` VALUES ('FC4BBC2C9B58', '1002');
INSERT INTO `account` VALUES ('FC4BBC2CABB2', '1002');
INSERT INTO `account` VALUES ('FC4BBC2CC6FD', '1002');
INSERT INTO `account` VALUES ('FC4BBC2CC899', '1002');
INSERT INTO `account` VALUES ('FC4BBC2CD2ED', '1004');

-- ----------------------------
-- Table structure for productset
-- ----------------------------
DROP TABLE IF EXISTS `productset`;
CREATE TABLE `productset` (
  `ProductID` varchar(20) NOT NULL,
  `ProductName` varchar(20) NOT NULL,
  PRIMARY KEY (`ProductID`),
  UNIQUE KEY `ProductName` (`ProductName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of productset
-- ----------------------------
INSERT INTO `productset` VALUES ('PRD0001', 'MiddleEastVIP');
INSERT INTO `productset` VALUES ('PRD0002', 'EgyptVIP');
INSERT INTO `productset` VALUES ('PRD0003', 'PalestineVIP');
INSERT INTO `productset` VALUES ('PRD0004', 'IsraelVIP');
INSERT INTO `productset` VALUES ('PRD0005', 'TurkeyVIP');
INSERT INTO `productset` VALUES ('PRD0006', 'IranVIP');
INSERT INTO `productset` VALUES ('PRD0007', 'AmericaLive');
INSERT INTO `productset` VALUES ('PRD0008', 'BrazilLive');
INSERT INTO `productset` VALUES ('PRD0009', 'EuropeLive');
INSERT INTO `productset` VALUES ('PRD0010', 'CanadaLive');

-- ----------------------------
-- Table structure for account_product
-- ----------------------------
DROP TABLE IF EXISTS `account_product`;
CREATE TABLE `account_product` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AccountID` varchar(20) NOT NULL,
  `ProductID` varchar(20) NOT NULL,
  `EndDate` date NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `acc_prod` (`AccountID`,`ProductID`),
  KEY `FK_acc_pro_1` (`AccountID`),
  CONSTRAINT `FK_acc_pro_1` FOREIGN KEY (`AccountID`) REFERENCES `account` (`AccountID`),
  KEY `FK_acc_pro_2` (`ProductID`),
  CONSTRAINT `FK_acc_pro_2` FOREIGN KEY (`ProductID`) REFERENCES `productset` (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of account_product
-- ----------------------------
INSERT INTO `account_product` VALUES (1,'00110568C712', 'PRD0001', '2017-05-23');
INSERT INTO `account_product` VALUES (2,'00110568C712', 'PRD0002', '2017-05-23');
INSERT INTO `account_product` VALUES (3,'00110568C712', 'PRD0003', '2017-05-23');
INSERT INTO `account_product` VALUES (4,'00110568C712', 'PRD0004', '2017-05-23');
INSERT INTO `account_product` VALUES (5,'00110568C712', 'PRD0005', '2017-05-23');
INSERT INTO `account_product` VALUES (6,'00110568C712', 'PRD0006', '2017-05-23');
INSERT INTO `account_product` VALUES (7,'00110568C712', 'PRD0007', '2017-05-23');
INSERT INTO `account_product` VALUES (8,'11820002DE1D', 'PRD0001', '2018-05-26');
INSERT INTO `account_product` VALUES (9,'11820002DE1D', 'PRD0005', '2018-05-26');
INSERT INTO `account_product` VALUES (10,'11820002DE1D', 'PRD0009', '2018-05-26');
INSERT INTO `account_product` VALUES (11,'FC4BBC05179F', 'PRD0001', '2017-02-15');
INSERT INTO `account_product` VALUES (12,'FC4BBC05179F', 'PRD0007', '2017-05-30');
INSERT INTO `account_product` VALUES (13,'FC4BBC05179F', 'PRD0008', '2016-09-15');
INSERT INTO `account_product` VALUES (14,'FC4BBC05179F', 'PRD0010', '2016-09-15');
INSERT INTO `account_product` VALUES (15,'FC4BBC2A374D', 'PRD0001', '2017-06-29');
INSERT INTO `account_product` VALUES (16,'FC4BBC2A3917', 'PRD0001', '2017-07-03');
INSERT INTO `account_product` VALUES (17,'FC4BBC2B1AAE', 'PRD0001', '2017-07-04');
INSERT INTO `account_product` VALUES (18,'FC4BBC2B1AAE', 'PRD0002', '2017-01-03');
INSERT INTO `account_product` VALUES (19,'FC4BBC2B1AAE', 'PRD0004', '2017-01-03');
INSERT INTO `account_product` VALUES (20,'FC4BBC2B1AAE', 'PRD0006', '2017-01-03');
INSERT INTO `account_product` VALUES (21,'FC4BBC2B9CA1', 'PRD0001', '2016-09-12');
INSERT INTO `account_product` VALUES (22,'FC4BBC2B9CA1', 'PRD0002', '2017-05-04');
INSERT INTO `account_product` VALUES (23,'FC4BBC2B9CA1', 'PRD0003', '2017-04-02');
INSERT INTO `account_product` VALUES (24,'FC4BBC2B9CA1', 'PRD0008', '2017-01-24');
INSERT INTO `account_product` VALUES (25,'FC4BBC2B9CA1', 'PRD0009', '2016-10-17');
INSERT INTO `account_product` VALUES (26,'FC4BBC2C928C', 'PRD0001', '2017-06-18');
INSERT INTO `account_product` VALUES (27,'FC4BBC2C928C', 'PRD0005', '2017-06-18');
INSERT INTO `account_product` VALUES (28,'FC4BBC2C928C', 'PRD0008', '2017-06-18');
INSERT INTO `account_product` VALUES (29,'FC4BBC2C928C', 'PRD0009', '2017-06-18');
INSERT INTO `account_product` VALUES (30,'FC4BBC2CD2ED', 'PRD0001', '2016-08-24');
INSERT INTO `account_product` VALUES (31,'FC4BBC2CD2ED', 'PRD0006', '2016-08-24');
INSERT INTO `account_product` VALUES (32,'FC4BBC2CD2ED', 'PRD0007', '2016-08-24');

-- ----------------------------
-- Table structure for channelset
-- ----------------------------
DROP TABLE IF EXISTS `channelset`;
CREATE TABLE `channelset` (
  `ChannelID` varchar(20) NOT NULL,
  `ChannelName` varchar(20) NOT NULL,
  `ChannelIP` varchar(30) NOT NULL,
  `ChannelPic` varchar(50) NOT NULL,
  `ChannelUrl` varchar(50) NOT NULL,
  `UrlType` varchar(20) NOT NULL,
  `ChannelType` varchar(10) NOT NULL,
  `LanguageID` varchar(20) NOT NULL,
  `ProductID` varchar(20),
  PRIMARY KEY (`ChannelID`),
  UNIQUE KEY `ChannelName` (`ChannelName`),
  KEY `FK_channelset_1` (`ProductID`),
  CONSTRAINT `FK_channelset_1` FOREIGN KEY (`ProductID`) REFERENCES `productset` (`ProductID`),  
  KEY `FK_Relationship_3` (`LanguageID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of channelset
-- ----------------------------
INSERT INTO `channelset` VALUES ('Chan0001', 'bein1', '188.138.89.40', '/images/bein1.jpg', 'http://188.138.89.40/IPTV_Files/bein1/bein1.m3u8', 'entire', 'Live', 'Lang0001', 'PRD0004');
INSERT INTO `channelset` VALUES ('Chan0002', 'bein2', '188.138.89.40', '/images/bein2.jpg', 'http://188.138.89.40/IPTV_Files/bein2/bein2.m3u8', 'entire', 'Live', 'Lang0001', 'PRD0004');
INSERT INTO `channelset` VALUES ('Chan0003', 'bein3', '188.138.89.40', '/images/bein3.jpg', 'http://188.138.89.40/IPTV_Files/bein3/bein3.m3u8', 'entire', 'Live', 'Lang0001', 'PRD0004');
INSERT INTO `channelset` VALUES ('Chan0004', 'bein4', '188.138.89.40', '/images/bein4.jpg', 'http://188.138.89.40/IPTV_Files/bein4/bein4.m3u8', 'entire', 'Live', 'Lang0001', 'PRD0004');
INSERT INTO `channelset` VALUES ('Chan0005', 'bein5', '188.138.89.40', '/images/bein5.jpg', 'http://188.138.89.40/IPTV_Files/bein5/bein5.m3u8', 'entire', 'Live', 'Lang0005', 'PRD0004');
INSERT INTO `channelset` VALUES ('Chan0006', 'bein6', '188.138.89.40', '/images/bein6.jpg', 'http://188.138.89.40/IPTV_Files/bein6/bein6.m3u8', 'entire', 'Live', 'Lang0005', 'PRD0004');
INSERT INTO `channelset` VALUES ('Chan0007', 'bein7', '188.138.89.40', '/images/bein7.jpg', 'http://188.138.89.40/IPTV_Files/bein7/bein7.m3u8', 'entire', 'Live', 'Lang0008', 'PRD0004');
INSERT INTO `channelset` VALUES ('Chan0008', 'bein8', '188.138.89.40', '/images/bein8.jpg', 'http://188.138.89.40/IPTV_Files/bein8/bein8.m3u8', 'entire', 'Live', 'Lang0009', 'PRD0004');
INSERT INTO `channelset` VALUES ('Chan0009', 'bein9', '188.138.89.40', '/images/bein9.jpg', 'http://188.138.89.40/IPTV_Files/bein9/bein9.m3u8', 'entire', 'Live', 'Lang0010', 'PRD0004');
INSERT INTO `channelset` VALUES ('Chan0010', 'nile1', '188.138.89.40', '/images/nile1.jpg', '/IPTV_Files/nile1/nile1.m3u8', 'sep', 'Live', 'Lang0001', 'PRD0001');
INSERT INTO `channelset` VALUES ('Chan0011', 'nile2', '188.138.89.40', '/images/nile2.jpg', '/IPTV_Files/nile2/nile2.m3u8', 'sep', 'Live', 'Lang0002', 'PRD0001');
INSERT INTO `channelset` VALUES ('Chan0012', 'nile3', '188.138.89.40', '/images/nile3.jpg', '/IPTV_Files/nile3/nile3.m3u8', 'sep', 'Live', 'Lang0003', 'PRD0001');
INSERT INTO `channelset` VALUES ('Chan0013', 'nile4', '188.138.89.40', '/images/nile4.jpg', '/IPTV_Files/nile4/nile4.m3u8', 'sep', 'Live', 'Lang0004', 'PRD0001');
INSERT INTO `channelset` VALUES ('Chan0014', 'nile5', '188.138.89.40', '/images/nile5.jpg', '/IPTV_Files/nile5/nile5.m3u8', 'sep', 'Live', 'Lang0005', 'PRD0001');
INSERT INTO `channelset` VALUES ('Chan0015', 'nile6', '188.138.89.40', '/images/nile6.jpg', '/IPTV_Files/nile6/nile6.m3u8', 'sep', 'Live', 'Lang0006', 'PRD0001');
INSERT INTO `channelset` VALUES ('Chan0016', 'nile7', '188.138.89.40', '/images/nile7.jpg', '/IPTV_Files/nile7/nile7.m3u8', 'sep', 'Live', 'Lang0007', 'PRD0001');
INSERT INTO `channelset` VALUES ('Chan0017', 'mbc1', '188.138.89.40', '/images/mbc1.jpg', '/IPTV_Files/mbc1/mbc1.m3u8', 'sep', 'Live', 'Lang0001', 'PRD0002');
INSERT INTO `channelset` VALUES ('Chan0018', 'mbc2', '188.138.89.40', '/images/mbc2.jpg', '/IPTV_Files/mbc2/mbc2.m3u8', 'sep', 'Live', 'Lang0002', 'PRD0002');
INSERT INTO `channelset` VALUES ('Chan0019', 'mbc3', '188.138.89.40', '/images/mbc3.jpg', '/IPTV_Files/mbc3/mbc3.m3u8', 'sep', 'Live', 'Lang0003', 'PRD0002');
INSERT INTO `channelset` VALUES ('Chan0020', 'baraem1', '188.138.89.40', '/images/baraem1.jpg', '/IPTV_Files/baraem1/baraem1.m3u8', 'sep', 'Live', 'Lang0001', 'PRD0003');
INSERT INTO `channelset` VALUES ('Chan0021', 'baraem2', '188.138.89.40', '/images/baraem2.jpg', '/IPTV_Files/baraem2/baraem2.m3u8', 'sep', 'Live', 'Lang0002', 'PRD0003');
INSERT INTO `channelset` VALUES ('Chan0022', 'baraem3', '188.138.89.40', '/images/baraem3.jpg', '/IPTV_Files/baraem3/baraem3.m3u8', 'sep', 'Live', 'Lang0005', 'PRD0003');
INSERT INTO `channelset` VALUES ('Chan0023', 'baraem4', '188.138.89.40', '/images/baraem4.jpg', '/IPTV_Files/baraem4/baraem4.m3u8', 'sep', 'Live', 'Lang0006', 'PRD0003');
INSERT INTO `channelset` VALUES ('Chan0024', 'dream1', '188.138.89.40', '/images/dram1.jpg', 'http://188.138.89.40/IPTV_Files/dream1/dream1.m3u8', 'entire', 'Live', 'Lang0005', 'PRD0005');
INSERT INTO `channelset` VALUES ('Chan0025', 'dream2', '188.138.89.40', '/images/dream2.jpg', 'http://188.138.89.40/IPTV_Files/dream2/deram2.m3u8', 'entire', 'Live', 'Lang0003', 'PRD0005');
INSERT INTO `channelset` VALUES ('Chan0026', 'dream3', '188.138.89.40', '/images/dream3.jpg', 'http://188.138.89.40/IPTV_Files/deram3/dream3.m3u8', 'entire', 'Live', 'Lang0007', 'PRD0005');
INSERT INTO `channelset` VALUES ('Chan0027', 'cbc1', '188.138.89.40', '/images/cbc1.jpg', 'http://188.138.89.40/IPTV_Files/cbc1/cbc1.m3u8', 'entire', 'Live', 'Lang0006', 'PRD0006');
INSERT INTO `channelset` VALUES ('Chan0028', 'cbc2', '188.138.89.40', '/images/cbc2.jpg', 'http://188.138.89.40/IPTV_Files/cbc2/cbc2.m3u8', 'entire', 'Live', 'Lang0002', 'PRD0006');
INSERT INTO `channelset` VALUES ('Chan0029', 'cbc3', '188.138.89.40', '/images/cbc3.jpg', 'http://188.138.89.40/IPTV_Files/cbc3/cbc3.m3u8', 'entire', 'Live', 'Lang0003', 'PRD0006');
INSERT INTO `channelset` VALUES ('Chan0030', 'sky1', '188.138.89.40', '/images/sky1.jpg', 'http://188.138.89.40/IPTV_Files/sky1/sky1.m3u8', 'entire', 'Live', 'Lang0005', 'PRD0007');
INSERT INTO `channelset` VALUES ('Chan0031', 'sky2', '188.138.89.40', '/images/sky2.jpg', 'http://188.138.89.40/IPTV_Files/sky2/sky2.m3u8', 'entire', 'Live', 'Lang0004', 'PRD0007');
INSERT INTO `channelset` VALUES ('Chan0032', 'sky3', '188.138.89.40', '/images/sky3.jpg', 'http://188.138.89.40/IPTV_Files/sky3/sky3.m3u8', 'entire', 'Live', 'Lang0002', 'PRD0007');
INSERT INTO `channelset` VALUES ('Chan0033', 'sky4', '188.138.89.40', '/images/sky4.jpg', 'http://188.138.89.40/IPTV_Files/sky4/sky4.m3u8', 'entire', 'Live', 'Lang0003', 'PRD0007');
INSERT INTO `channelset` VALUES ('Chan0034', 'rai1', '188.138.89.40', '/images/rai1.jpg', 'http://188.138.89.40/IPTV_Files/rai1/rai1.m3u8', 'entire', 'Live', 'Lang0009', 'PRD0008');
INSERT INTO `channelset` VALUES ('Chan0035', 'rai2', '188.138.89.40', '/images/rai2.jpg', 'http://188.138.89.40/IPTV_Files/rai2/rai2.m3u8', 'entire', 'Live', 'Lang0006', 'PRD0008');
INSERT INTO `channelset` VALUES ('Chan0036', 'rai3', '188.138.89.40', '/images/rai3.jpg', 'http://188.138.89.40/IPTV_Files/rai3/rai3.m3u8', 'entire', 'Live', 'Lang0004', 'PRD0008');
INSERT INTO `channelset` VALUES ('Chan0037', 'rai4', '188.138.89.40', '/images/rai4.jpg', 'http://188.138.89.40/IPTV_Files/rai4/rai4.m3u8', 'entire', 'Live', 'Lang0003', 'PRD0008');
INSERT INTO `channelset` VALUES ('Chan0038', 'rai5', '188.138.89.40', '/images/rai5.jpg', 'http://188.138.89.40/IPTV_Files/rai5/rai5.m3u8', 'entire', 'Live', 'Lang0001', 'PRD0008');
INSERT INTO `channelset` VALUES ('Chan0039', 'canal1', '188.138.89.40', '/images/canal1.jpg', '/IPTV_Files/canal1/canal1.m3u8', 'sep', 'Live', 'Lang0007', 'PRD0009');
INSERT INTO `channelset` VALUES ('Chan0040', 'canal2', '188.138.89.40', '/images/canal2.jpg', '/IPTV_Files/canal2/canal2.m3u8', 'sep', 'Live', 'Lang0005', 'PRD0009');
INSERT INTO `channelset` VALUES ('Chan0041', 'canal3', '188.138.89.40', '/images/canal3.jpg', '/IPTV_Files/canal3/canal3.m3u8', 'sep', 'Live', 'Lang0003', 'PRD0009');
INSERT INTO `channelset` VALUES ('Chan0042', 'dzair1', '188.138.89.40', '/images/dzair1.jpg', '/IPTV_Files/dzair1/dzair1.m3u8', 'sep', 'Live', 'Lang0005', 'PRD0010');
INSERT INTO `channelset` VALUES ('Chan0043', 'dzair2', '188.138.89.40', '/images/dzair2.jpg', '/IPTV_Files/dzair2/dzair2.m3u8', 'sep', 'Live', 'Lang0006', 'PRD0010');
INSERT INTO `channelset` VALUES ('Chan0044', 'dzair3', '188.138.89.40', '/images/dzair3.jpg', '/IPTV_Files/dzair3/dzair3.m3u8', 'sep', 'Live', 'Lang0009', 'PRD0010');
INSERT INTO `channelset` VALUES ('Chan0045', 'dzair4', '188.138.89.40', '/images/dzair4.jpg', '/IPTV_Files/dzair4/dzair4.m3u8', 'sep', 'Live', 'Lang0001', 'PRD0010');


-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `ADMIN_ID` int(5) NOT NULL AUTO_INCREMENT,
  `ADMIN_NAME` varchar(20) NOT NULL,
  `PWD` varchar(32) NOT NULL,
  `LEVEL` varchar(1) NOT NULL,
  PRIMARY KEY (`ADMIN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '0192023a7bbd73250516f069df18b500', '1');

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `AREA_ID` int(5) NOT NULL,
  `AREA_NAME` varchar(20) NOT NULL,
  PRIMARY KEY (`AREA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES ('1', '大陆');
INSERT INTO `area` VALUES ('2', '美国');
INSERT INTO `area` VALUES ('3', '日本');
INSERT INTO `area` VALUES ('4', '韩国');
INSERT INTO `area` VALUES ('5', '英国');
INSERT INTO `area` VALUES ('6', '香港');
INSERT INTO `area` VALUES ('7', '台湾');
INSERT INTO `area` VALUES ('8', '印度');
INSERT INTO `area` VALUES ('9', '法国');
INSERT INTO `area` VALUES ('10', '加拿大');
INSERT INTO `area` VALUES ('11', '西班牙');
INSERT INTO `area` VALUES ('12', '新加坡');
INSERT INTO `area` VALUES ('13', '泰国');
INSERT INTO `area` VALUES ('14', '意大利');
INSERT INTO `area` VALUES ('15', '德国');
INSERT INTO `area` VALUES ('16', '俄罗斯');
INSERT INTO `area` VALUES ('17', '越南');
INSERT INTO `area` VALUES ('18', '澳大利亚');

-- ----------------------------
-- Table structure for batch
-- ----------------------------
DROP TABLE IF EXISTS `batch`;
CREATE TABLE `batch` (
  `BATCH_ID` int(5) NOT NULL,
  `BATCH_STATE` varchar(1) NOT NULL,
  `BATCH_DATE` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`BATCH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of batch
-- ----------------------------

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `pwd` varchar(20) NOT NULL,
  `state` int(1) DEFAULT NULL,
  `day` int(10) DEFAULT NULL,
  `enddate` varchar(10) DEFAULT NULL,
  `chargedate` varchar(10) DEFAULT NULL,
  `userid` int(5) DEFAULT NULL,
  `batch_id` int(5) DEFAULT NULL,
  `service_id` int(5) DEFAULT NULL,
  `batch_no` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `card_pk` (`userid`),
  KEY `batch_pk` (`batch_id`),
  KEY `serice_pk` (`service_id`),
  CONSTRAINT `batch_pk` FOREIGN KEY (`batch_id`) REFERENCES `batch` (`BATCH_ID`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `card_pk` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `serice_pk` FOREIGN KEY (`service_id`) REFERENCES `serviec_type` (`SERVICE_ID`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('1', '123', '3', '200', '20160401', '20150505', null, null, null, '1');
INSERT INTO `card` VALUES ('2', '32', '2', '100', '20160401', '20120212', '1', null, null, '2');
INSERT INTO `card` VALUES ('3', '33', '3', '100', '20110301', '', '2', null, null, '3');
INSERT INTO `card` VALUES ('4', '34', '2', '101', '20160401', '20150317', null, null, null, null);
INSERT INTO `card` VALUES ('5', '35', '3', '102', '20160401', null, null, null, null, null);
INSERT INTO `card` VALUES ('6', '36', '3', '103', '20160401', null, null, null, null, null);
INSERT INTO `card` VALUES ('7', '37', '3', '104', '20160401', null, null, null, null, null);
INSERT INTO `card` VALUES ('8', '38', '3', '105', '20160401', null, null, null, null, null);
INSERT INTO `card` VALUES ('9', '39', '3', '106', '20160401', null, null, null, null, null);
INSERT INTO `card` VALUES ('10', '40', '3', '107', '20160401', null, null, null, null, null);
INSERT INTO `card` VALUES ('11', '41', '3', '108', '20110301', null, null, null, null, null);
INSERT INTO `card` VALUES ('12', '42', '3', '109', '20110301', null, null, null, null, null);
INSERT INTO `card` VALUES ('13', '43', '3', '110', '20110301', null, null, null, null, null);
INSERT INTO `card` VALUES ('14', '44', '3', '111', '20110301', null, null, null, null, null);
INSERT INTO `card` VALUES ('15', '32', '3', '100', '20110301', null, null, null, null, null);
INSERT INTO `card` VALUES ('16', '33', '1', '100', '20170301', null, null, null, null, null);
INSERT INTO `card` VALUES ('17', '34', '1', '101', '20170301', null, null, null, null, null);
INSERT INTO `card` VALUES ('18', '35', '1', '102', '20170301', null, null, null, null, null);
INSERT INTO `card` VALUES ('19', '36', '1', '103', '20170301', null, null, null, null, null);
INSERT INTO `card` VALUES ('20', '37', '1', '104', '20170301', null, null, null, null, null);
INSERT INTO `card` VALUES ('21', '38', '3', '105', '20160401', null, null, null, null, null);
INSERT INTO `card` VALUES ('22', '39', '3', '106', '20160401', null, null, null, null, null);
INSERT INTO `card` VALUES ('23', '40', '3', '107', '20160401', null, null, null, null, null);
INSERT INTO `card` VALUES ('24', '41', '3', '108', '20160401', null, null, null, null, null);
INSERT INTO `card` VALUES ('25', '42', '3', '109', '20160401', null, null, null, null, null);
INSERT INTO `card` VALUES ('26', '43', '3', '110', '20160401', null, null, null, null, null);
INSERT INTO `card` VALUES ('27', '44', '3', '111', '20160401', null, null, null, null, null);
INSERT INTO `card` VALUES ('28', '45', '3', '112', '20160401', null, null, null, null, null);
INSERT INTO `card` VALUES ('29', '12', '3', '130', '20160401', null, null, null, null, null);
INSERT INTO `card` VALUES ('30', 'QO9X8C', '3', '30', '20160301', null, null, null, null, '4');
INSERT INTO `card` VALUES ('31', 'YNTVZ1', '3', '30', '20160301', null, null, null, null, '4');
INSERT INTO `card` VALUES ('32', '7Q5GS2', '3', '30', '20160301', null, null, null, null, '4');
INSERT INTO `card` VALUES ('33', 'SQIVL1', '3', '30', '20160301', null, null, null, null, '4');
INSERT INTO `card` VALUES ('34', 'MSFLJ7', '3', '30', '20160301', null, null, null, null, '4');
INSERT INTO `card` VALUES ('35', 'Y9EUOG', '3', '30', '20160301', null, null, null, null, '4');
INSERT INTO `card` VALUES ('36', '33TZW8', '3', '30', '20160301', null, null, null, null, '4');
INSERT INTO `card` VALUES ('37', 'G00P3C', '3', '30', '20160301', null, null, null, null, '4');
INSERT INTO `card` VALUES ('38', 'RIM4LS', '3', '30', '20160301', null, null, null, null, '4');
INSERT INTO `card` VALUES ('39', '5G9WS7', '3', '30', '20160301', null, null, null, null, '4');

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `CATALOG_ID` int(5) NOT NULL AUTO_INCREMENT,
  `CATALOG_ZH_NAME` varchar(20) NOT NULL,
  `CATALOG_EN_NAME` varchar(20) NOT NULL,
  `SUPER_CATALOG_ID` int(5) DEFAULT NULL,
  `ORDER1` int(3) NOT NULL,
  PRIMARY KEY (`CATALOG_ID`),
  KEY `CATALOG_ID` (`CATALOG_ID`),
  KEY `pk_catalog` (`SUPER_CATALOG_ID`),
  CONSTRAINT `pk_catalog` FOREIGN KEY (`SUPER_CATALOG_ID`) REFERENCES `catalog` (`CATALOG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of catalog
-- ----------------------------
INSERT INTO `catalog` VALUES ('1', '电影', 'dianying', null, '9');
INSERT INTO `catalog` VALUES ('2', '电视剧', 'dianshijv', null, '5');
INSERT INTO `catalog` VALUES ('3', '综艺', 'zongyi', null, '4');
INSERT INTO `catalog` VALUES ('4', '动漫', 'dongman', null, '3');
INSERT INTO `catalog` VALUES ('5', '纪录片', 'jilupian', null, '2');
INSERT INTO `catalog` VALUES ('6', '教育', 'jiaoyu', null, '1');
INSERT INTO `catalog` VALUES ('7', '华语', 'huayu', '1', '1');
INSERT INTO `catalog` VALUES ('8', '美国', 'meiguo', '1', '2');
INSERT INTO `catalog` VALUES ('9', '欧洲', 'ouzhou', '1', '3');
INSERT INTO `catalog` VALUES ('10', '日本', 'riben', '1', '4');
INSERT INTO `catalog` VALUES ('11', '韩国', 'hanguo', '1', '5');
INSERT INTO `catalog` VALUES ('12', '最新', 'zuixin', '1', '6');
INSERT INTO `catalog` VALUES ('13', '爱情', 'aiqing', '7', '1');
INSERT INTO `catalog` VALUES ('14', '动作', 'dongzuo', '7', '2');
INSERT INTO `catalog` VALUES ('15', '喜剧', 'xijv', '7', '3');
INSERT INTO `catalog` VALUES ('16', '科幻', 'kehuan', '7', '4');
INSERT INTO `catalog` VALUES ('17', '风月', 'fengyue', '7', '5');
INSERT INTO `catalog` VALUES ('18', '剧情', 'jvqing', '7', '6');
INSERT INTO `catalog` VALUES ('19', '警匪', 'jingfei', '7', '7');
INSERT INTO `catalog` VALUES ('20', '武侠', 'wuxia', '7', '8');
INSERT INTO `catalog` VALUES ('21', '爱情', 'aiqing', '8', '1');
INSERT INTO `catalog` VALUES ('22', '动作', 'dongzuo', '8', '2');
INSERT INTO `catalog` VALUES ('23', '喜剧', 'xijv', '8', '3');
INSERT INTO `catalog` VALUES ('24', '科幻', 'kehuan', '8', '4');
INSERT INTO `catalog` VALUES ('25', '恐怖', 'kongbu', '8', '5');
INSERT INTO `catalog` VALUES ('26', '剧情', 'jvqing', '8', '6');
INSERT INTO `catalog` VALUES ('27', '歌舞', 'gewu', '8', '7');
INSERT INTO `catalog` VALUES ('28', '战争', 'zhanzheng', '8', '8');
INSERT INTO `catalog` VALUES ('29', '爱情', 'aiqing', '9', '1');
INSERT INTO `catalog` VALUES ('30', '动作', 'dongzuo', '9', '2');
INSERT INTO `catalog` VALUES ('31', '喜剧', 'xijv', '9', '3');
INSERT INTO `catalog` VALUES ('32', '惊悚', 'jingsong', '9', '4');
INSERT INTO `catalog` VALUES ('33', '剧情', 'jvqing', '9', '5');
INSERT INTO `catalog` VALUES ('34', '悬疑', 'xuanyi', '9', '6');
INSERT INTO `catalog` VALUES ('35', '动画', 'donghua', '9', '7');
INSERT INTO `catalog` VALUES ('36', '爱情', 'aiqing', '10', '1');
INSERT INTO `catalog` VALUES ('37', '动作', 'dongzuo', '10', '2');
INSERT INTO `catalog` VALUES ('38', '喜剧', 'xijv', '10', '3');
INSERT INTO `catalog` VALUES ('39', '科幻', 'kehuan', '10', '4');
INSERT INTO `catalog` VALUES ('40', '剧情', 'jvqing', '10', '5');
INSERT INTO `catalog` VALUES ('41', '悬疑', 'xuanyi', '10', '6');
INSERT INTO `catalog` VALUES ('42', '动画', 'donghua', '10', '7');
INSERT INTO `catalog` VALUES ('43', '爱情', 'aiqing', '11', '1');
INSERT INTO `catalog` VALUES ('44', '动作', 'dongzuo', '11', '2');
INSERT INTO `catalog` VALUES ('45', '喜剧', 'xijv', '11', '3');
INSERT INTO `catalog` VALUES ('46', '科幻', 'kehuan', '11', '4');
INSERT INTO `catalog` VALUES ('47', '剧情', 'jvqing', '11', '5');
INSERT INTO `catalog` VALUES ('48', '悬疑', 'xuanyi', '11', '6');
INSERT INTO `catalog` VALUES ('49', '动画', 'donghua', '11', '7');
INSERT INTO `catalog` VALUES ('50', '国产动画', 'guochandong', '4', '1');
INSERT INTO `catalog` VALUES ('51', '日本动画', 'ridonghua', '4', '2');
INSERT INTO `catalog` VALUES ('52', '欧美动画', 'oudonghua', '4', '3');
INSERT INTO `catalog` VALUES ('53', '校园', 'xiaoyuan', '50', '1');
INSERT INTO `catalog` VALUES ('54', '热血', 'rexue', '50', '2');
INSERT INTO `catalog` VALUES ('55', '冒险', 'maoxian', '50', '3');
INSERT INTO `catalog` VALUES ('56', '历史', 'lishi', '50', '4');
INSERT INTO `catalog` VALUES ('57', '搞笑', 'gaoxiao', '50', '5');
INSERT INTO `catalog` VALUES ('58', '机战', 'jizhan', '50', '6');
INSERT INTO `catalog` VALUES ('59', '校园', 'xiaoyuan', '51', '1');
INSERT INTO `catalog` VALUES ('60', '热血', 'rexue', '51', '2');
INSERT INTO `catalog` VALUES ('61', '冒险', 'maoxian', '51', '3');
INSERT INTO `catalog` VALUES ('62', '历史', 'lishi', '51', '4');
INSERT INTO `catalog` VALUES ('63', '搞笑', 'gaoxiao', '51', '5');
INSERT INTO `catalog` VALUES ('64', '机战', 'jizhan', '51', '6');
INSERT INTO `catalog` VALUES ('65', '校园', 'xiaoyuan', '52', '1');
INSERT INTO `catalog` VALUES ('66', '热血', 'rexue', '52', '2');
INSERT INTO `catalog` VALUES ('67', '冒险', 'maoxian', '52', '3');
INSERT INTO `catalog` VALUES ('68', '历史', 'lishi', '52', '4');
INSERT INTO `catalog` VALUES ('69', '搞笑', 'gaoxiao', '52', '5');
INSERT INTO `catalog` VALUES ('70', '机战', 'jizhan', '52', '6');
INSERT INTO `catalog` VALUES ('71', '心理学', 'xinlixue', '6', '1');
INSERT INTO `catalog` VALUES ('72', '社会学', 'shehuixue', '6', '2');
INSERT INTO `catalog` VALUES ('73', '计算机', 'jisuanji', '6', '3');
INSERT INTO `catalog` VALUES ('74', '金融', 'jinrong', '6', '4');
INSERT INTO `catalog` VALUES ('75', '直播', 'zhibo', null, '1');
INSERT INTO `catalog` VALUES ('76', '中央台', 'zhongyangtai', '75', '1');
INSERT INTO `catalog` VALUES ('77', '地方台', 'difangtai', '75', '2');
INSERT INTO `catalog` VALUES ('78', '本地频道', 'bendipindao', '75', '3');
INSERT INTO `catalog` VALUES ('79', '其他频道', 'qitapindao', '75', '4');
INSERT INTO `catalog` VALUES ('80', '美剧', 'meijv', '2', '9');
INSERT INTO `catalog` VALUES ('81', '韩剧', 'hanjv', '2', '8');
INSERT INTO `catalog` VALUES ('82', '日剧', 'rijv', '2', '7');
INSERT INTO `catalog` VALUES ('83', '港剧', 'gangjv', '2', '6');

-- ----------------------------
-- Table structure for catalog_media_relation
-- ----------------------------
DROP TABLE IF EXISTS `catalog_media_relation`;
CREATE TABLE `catalog_media_relation` (
  `CATALOG_ID` int(5) NOT NULL,
  `MEDIA_CATALOG_ID` int(5) NOT NULL,
  PRIMARY KEY (`CATALOG_ID`,`MEDIA_CATALOG_ID`),
  KEY `pk_relation2` (`MEDIA_CATALOG_ID`),
  CONSTRAINT `pk_relation1` FOREIGN KEY (`CATALOG_ID`) REFERENCES `catalog` (`CATALOG_ID`),
  CONSTRAINT `pk_relation2` FOREIGN KEY (`MEDIA_CATALOG_ID`) REFERENCES `media_catalog` (`MEDIA_CATALOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of catalog_media_relation
-- ----------------------------
INSERT INTO `catalog_media_relation` VALUES ('12', '4');
INSERT INTO `catalog_media_relation` VALUES ('13', '4');
INSERT INTO `catalog_media_relation` VALUES ('20', '4');
INSERT INTO `catalog_media_relation` VALUES ('13', '5');
INSERT INTO `catalog_media_relation` VALUES ('15', '5');
INSERT INTO `catalog_media_relation` VALUES ('18', '7');
INSERT INTO `catalog_media_relation` VALUES ('19', '7');
INSERT INTO `catalog_media_relation` VALUES ('17', '8');
INSERT INTO `catalog_media_relation` VALUES ('14', '9');
INSERT INTO `catalog_media_relation` VALUES ('20', '9');
INSERT INTO `catalog_media_relation` VALUES ('21', '10');
INSERT INTO `catalog_media_relation` VALUES ('26', '10');
INSERT INTO `catalog_media_relation` VALUES ('21', '11');
INSERT INTO `catalog_media_relation` VALUES ('22', '11');
INSERT INTO `catalog_media_relation` VALUES ('26', '11');
INSERT INTO `catalog_media_relation` VALUES ('23', '12');
INSERT INTO `catalog_media_relation` VALUES ('12', '14');
INSERT INTO `catalog_media_relation` VALUES ('22', '14');
INSERT INTO `catalog_media_relation` VALUES ('24', '14');
INSERT INTO `catalog_media_relation` VALUES ('25', '14');
INSERT INTO `catalog_media_relation` VALUES ('24', '15');
INSERT INTO `catalog_media_relation` VALUES ('12', '16');
INSERT INTO `catalog_media_relation` VALUES ('27', '16');
INSERT INTO `catalog_media_relation` VALUES ('27', '17');
INSERT INTO `catalog_media_relation` VALUES ('28', '18');
INSERT INTO `catalog_media_relation` VALUES ('28', '19');
INSERT INTO `catalog_media_relation` VALUES ('28', '20');
INSERT INTO `catalog_media_relation` VALUES ('29', '21');
INSERT INTO `catalog_media_relation` VALUES ('33', '21');
INSERT INTO `catalog_media_relation` VALUES ('29', '22');
INSERT INTO `catalog_media_relation` VALUES ('33', '22');
INSERT INTO `catalog_media_relation` VALUES ('30', '23');
INSERT INTO `catalog_media_relation` VALUES ('34', '23');
INSERT INTO `catalog_media_relation` VALUES ('32', '24');
INSERT INTO `catalog_media_relation` VALUES ('34', '24');
INSERT INTO `catalog_media_relation` VALUES ('31', '25');
INSERT INTO `catalog_media_relation` VALUES ('31', '26');
INSERT INTO `catalog_media_relation` VALUES ('32', '27');
INSERT INTO `catalog_media_relation` VALUES ('33', '28');
INSERT INTO `catalog_media_relation` VALUES ('35', '28');
INSERT INTO `catalog_media_relation` VALUES ('32', '29');
INSERT INTO `catalog_media_relation` VALUES ('33', '29');
INSERT INTO `catalog_media_relation` VALUES ('34', '29');
INSERT INTO `catalog_media_relation` VALUES ('31', '30');
INSERT INTO `catalog_media_relation` VALUES ('35', '30');
INSERT INTO `catalog_media_relation` VALUES ('12', '31');
INSERT INTO `catalog_media_relation` VALUES ('37', '31');
INSERT INTO `catalog_media_relation` VALUES ('39', '31');
INSERT INTO `catalog_media_relation` VALUES ('42', '31');
INSERT INTO `catalog_media_relation` VALUES ('41', '32');
INSERT INTO `catalog_media_relation` VALUES ('36', '33');
INSERT INTO `catalog_media_relation` VALUES ('40', '33');
INSERT INTO `catalog_media_relation` VALUES ('37', '34');
INSERT INTO `catalog_media_relation` VALUES ('40', '34');
INSERT INTO `catalog_media_relation` VALUES ('37', '35');
INSERT INTO `catalog_media_relation` VALUES ('39', '35');
INSERT INTO `catalog_media_relation` VALUES ('42', '35');
INSERT INTO `catalog_media_relation` VALUES ('43', '36');
INSERT INTO `catalog_media_relation` VALUES ('44', '36');
INSERT INTO `catalog_media_relation` VALUES ('44', '37');
INSERT INTO `catalog_media_relation` VALUES ('47', '37');
INSERT INTO `catalog_media_relation` VALUES ('48', '37');
INSERT INTO `catalog_media_relation` VALUES ('43', '38');
INSERT INTO `catalog_media_relation` VALUES ('45', '38');
INSERT INTO `catalog_media_relation` VALUES ('45', '39');
INSERT INTO `catalog_media_relation` VALUES ('49', '39');
INSERT INTO `catalog_media_relation` VALUES ('46', '40');
INSERT INTO `catalog_media_relation` VALUES ('48', '40');
INSERT INTO `catalog_media_relation` VALUES ('56', '41');
INSERT INTO `catalog_media_relation` VALUES ('54', '42');
INSERT INTO `catalog_media_relation` VALUES ('55', '42');
INSERT INTO `catalog_media_relation` VALUES ('57', '43');
INSERT INTO `catalog_media_relation` VALUES ('53', '44');
INSERT INTO `catalog_media_relation` VALUES ('55', '44');
INSERT INTO `catalog_media_relation` VALUES ('58', '44');
INSERT INTO `catalog_media_relation` VALUES ('55', '45');
INSERT INTO `catalog_media_relation` VALUES ('57', '45');
INSERT INTO `catalog_media_relation` VALUES ('60', '46');
INSERT INTO `catalog_media_relation` VALUES ('61', '46');
INSERT INTO `catalog_media_relation` VALUES ('59', '47');
INSERT INTO `catalog_media_relation` VALUES ('64', '47');
INSERT INTO `catalog_media_relation` VALUES ('60', '48');
INSERT INTO `catalog_media_relation` VALUES ('62', '49');
INSERT INTO `catalog_media_relation` VALUES ('63', '49');
INSERT INTO `catalog_media_relation` VALUES ('69', '50');
INSERT INTO `catalog_media_relation` VALUES ('66', '51');
INSERT INTO `catalog_media_relation` VALUES ('67', '51');
INSERT INTO `catalog_media_relation` VALUES ('69', '52');
INSERT INTO `catalog_media_relation` VALUES ('71', '53');
INSERT INTO `catalog_media_relation` VALUES ('72', '53');
INSERT INTO `catalog_media_relation` VALUES ('73', '54');
INSERT INTO `catalog_media_relation` VALUES ('72', '55');
INSERT INTO `catalog_media_relation` VALUES ('74', '56');
INSERT INTO `catalog_media_relation` VALUES ('74', '57');
INSERT INTO `catalog_media_relation` VALUES ('73', '58');
INSERT INTO `catalog_media_relation` VALUES ('73', '59');
INSERT INTO `catalog_media_relation` VALUES ('74', '60');
INSERT INTO `catalog_media_relation` VALUES ('76', '61');
INSERT INTO `catalog_media_relation` VALUES ('76', '62');
INSERT INTO `catalog_media_relation` VALUES ('76', '63');
INSERT INTO `catalog_media_relation` VALUES ('76', '64');
INSERT INTO `catalog_media_relation` VALUES ('76', '65');
INSERT INTO `catalog_media_relation` VALUES ('76', '66');
INSERT INTO `catalog_media_relation` VALUES ('77', '67');
INSERT INTO `catalog_media_relation` VALUES ('77', '68');
INSERT INTO `catalog_media_relation` VALUES ('77', '69');
INSERT INTO `catalog_media_relation` VALUES ('77', '70');
INSERT INTO `catalog_media_relation` VALUES ('78', '71');
INSERT INTO `catalog_media_relation` VALUES ('78', '72');
INSERT INTO `catalog_media_relation` VALUES ('78', '73');
INSERT INTO `catalog_media_relation` VALUES ('79', '74');
INSERT INTO `catalog_media_relation` VALUES ('79', '75');
INSERT INTO `catalog_media_relation` VALUES ('49', '76');
INSERT INTO `catalog_media_relation` VALUES ('49', '80');
INSERT INTO `catalog_media_relation` VALUES ('1', '81');

-- ----------------------------
-- Table structure for channel_directory
-- ----------------------------
DROP TABLE IF EXISTS `channel_directory`;
CREATE TABLE `channel_directory` (
  `DirectoryID` varchar(20) NOT NULL,
  `ChannelID` varchar(20) NOT NULL,
  PRIMARY KEY (`DirectoryID`,`ChannelID`),
  KEY `FK_channel_directory2` (`ChannelID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of channel_directory
-- ----------------------------
INSERT INTO `channel_directory` VALUES ('DIR1001', 'Chan0001');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0001');
INSERT INTO `channel_directory` VALUES ('DIR1005', 'Chan0002');
INSERT INTO `channel_directory` VALUES ('DIR1006', 'Chan0002');
INSERT INTO `channel_directory` VALUES ('DIR1007', 'Chan0002');
INSERT INTO `channel_directory` VALUES ('DIR1002', 'Chan0003');
INSERT INTO `channel_directory` VALUES ('DIR1005', 'Chan0003');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0004');
INSERT INTO `channel_directory` VALUES ('DIR1005', 'Chan0005');
INSERT INTO `channel_directory` VALUES ('DIR1008', 'Chan0006');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0007');
INSERT INTO `channel_directory` VALUES ('DIR1001', 'Chan0008');
INSERT INTO `channel_directory` VALUES ('DIR1005', 'Chan0008');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0009');
INSERT INTO `channel_directory` VALUES ('DIR1001', 'Chan0010');
INSERT INTO `channel_directory` VALUES ('DIR1006', 'Chan0010');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0011');
INSERT INTO `channel_directory` VALUES ('DIR1002', 'Chan0012');
INSERT INTO `channel_directory` VALUES ('DIR1004', 'Chan0012');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0013');
INSERT INTO `channel_directory` VALUES ('DIR1001', 'Chan0014');
INSERT INTO `channel_directory` VALUES ('DIR1006', 'Chan0015');
INSERT INTO `channel_directory` VALUES ('DIR1002', 'Chan0016');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0016');
INSERT INTO `channel_directory` VALUES ('DIR1004', 'Chan0017');
INSERT INTO `channel_directory` VALUES ('DIR1007', 'Chan0017');
INSERT INTO `channel_directory` VALUES ('DIR1008', 'Chan0017');
INSERT INTO `channel_directory` VALUES ('DIR1007', 'Chan0018');
INSERT INTO `channel_directory` VALUES ('DIR1008', 'Chan0018');
INSERT INTO `channel_directory` VALUES ('DIR1001', 'Chan0019');
INSERT INTO `channel_directory` VALUES ('DIR1001', 'Chan0020');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0021');
INSERT INTO `channel_directory` VALUES ('DIR1001', 'Chan0022');
INSERT INTO `channel_directory` VALUES ('DIR1008', 'Chan0022');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0023');
INSERT INTO `channel_directory` VALUES ('DIR1001', 'Chan0024');
INSERT INTO `channel_directory` VALUES ('DIR1005', 'Chan0025');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0026');
INSERT INTO `channel_directory` VALUES ('DIR1004', 'Chan0027');
INSERT INTO `channel_directory` VALUES ('DIR1006', 'Chan0028');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0029');
INSERT INTO `channel_directory` VALUES ('DIR1007', 'Chan0030');
INSERT INTO `channel_directory` VALUES ('DIR1005', 'Chan0031');
INSERT INTO `channel_directory` VALUES ('DIR1006', 'Chan0031');
INSERT INTO `channel_directory` VALUES ('DIR1002', 'Chan0032');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0032');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0033');
INSERT INTO `channel_directory` VALUES ('DIR1001', 'Chan0034');
INSERT INTO `channel_directory` VALUES ('DIR1006', 'Chan0035');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0036');
INSERT INTO `channel_directory` VALUES ('DIR1007', 'Chan0036');
INSERT INTO `channel_directory` VALUES ('DIR1001', 'Chan0037');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0038');
INSERT INTO `channel_directory` VALUES ('DIR1002', 'Chan0039');
INSERT INTO `channel_directory` VALUES ('DIR1004', 'Chan0040');
INSERT INTO `channel_directory` VALUES ('DIR1008', 'Chan0040');
INSERT INTO `channel_directory` VALUES ('DIR1002', 'Chan0041');
INSERT INTO `channel_directory` VALUES ('DIR1005', 'Chan0041');
INSERT INTO `channel_directory` VALUES ('DIR1007', 'Chan0041');
INSERT INTO `channel_directory` VALUES ('DIR1001', 'Chan0042');
INSERT INTO `channel_directory` VALUES ('DIR1004', 'Chan0043');
INSERT INTO `channel_directory` VALUES ('DIR1006', 'Chan0044');
INSERT INTO `channel_directory` VALUES ('DIR1007', 'Chan0044');
INSERT INTO `channel_directory` VALUES ('DIR1002', 'Chan0045');
INSERT INTO `channel_directory` VALUES ('DIR1003', 'Chan0045');
INSERT INTO `channel_directory` VALUES ('DIR1004', 'Chan0045');


-- ----------------------------
-- Table structure for directory
-- ----------------------------
DROP TABLE IF EXISTS `directory`;
CREATE TABLE `directory` (
  `DirectoryID` varchar(20) NOT NULL,
  `ParentID` varchar(20) NOT NULL,
  `DirectoryName` varchar(20) NOT NULL,
  PRIMARY KEY (`DirectoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of directory
-- ----------------------------
INSERT INTO `directory` VALUES ('DIR0001', 'DIR0000', 'MiddleEastVIP');
INSERT INTO `directory` VALUES ('DIR0002', 'DIR0000', 'EgyptVIP');
INSERT INTO `directory` VALUES ('DIR0003', 'DIR0000', 'PalestineVIP');
INSERT INTO `directory` VALUES ('DIR0004', 'DIR0000', 'IsraelVIP');
INSERT INTO `directory` VALUES ('DIR0005', 'DIR0000', 'TurkeyVIP');
INSERT INTO `directory` VALUES ('DIR0006', 'DIR0000', 'IranVIP');
INSERT INTO `directory` VALUES ('DIR0007', 'DIR0000', 'AmericaLive');
INSERT INTO `directory` VALUES ('DIR0008', 'DIR0000', 'BrazilLive');
INSERT INTO `directory` VALUES ('DIR0009', 'DIR0000', 'EuropeLive');
INSERT INTO `directory` VALUES ('DIR0010', 'DIR0000', 'CanadaLive');
INSERT INTO `directory` VALUES ('DIR1001', 'DIR0001', 'Arabic');
INSERT INTO `directory` VALUES ('DIR1002', 'DIR0001', 'Tunisia');
INSERT INTO `directory` VALUES ('DIR1003', 'DIR0001', 'PreMium');
INSERT INTO `directory` VALUES ('DIR1004', 'DIR0001', 'Sports');
INSERT INTO `directory` VALUES ('DIR1005', 'DIR0001', 'Europe');
INSERT INTO `directory` VALUES ('DIR1006', 'DIR0001', 'French');
INSERT INTO `directory` VALUES ('DIR1007', 'DIR0001', 'Movies');
INSERT INTO `directory` VALUES ('DIR1008', 'DIR0001', 'KIDS');

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `comment` varchar(45) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group
-- ----------------------------

-- ----------------------------
-- Table structure for ids
-- ----------------------------
DROP TABLE IF EXISTS `ids`;
CREATE TABLE `ids` (
  `ID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `LanguageID` int(11) NOT NULL,
  `ChannelID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ids
-- ----------------------------
INSERT INTO `ids` VALUES ('1', '10', '10', '45');

-- ----------------------------
-- Table structure for iptvsoftware
-- ----------------------------
DROP TABLE IF EXISTS `iptvsoftware`;
CREATE TABLE `iptvsoftware` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `content` varchar(100) DEFAULT NULL,
  `up_date` varchar(10) DEFAULT NULL,
  `version` varchar(20) NOT NULL,
  `usedate` varchar(10) DEFAULT NULL,
  `filename` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of iptvsoftware
-- ----------------------------
INSERT INTO `iptvsoftware` VALUES ('1', '修复交替进退在线影视与个人空间出现光标同时高亮的问题', '20121212', '1', '20150202', '1_iptv.zip');
INSERT INTO `iptvsoftware` VALUES ('2', '新增以媒体文件类型分类显示', '20140202', '2', '20150212', '2_iptv.zip');

-- ----------------------------
-- Table structure for language
-- ----------------------------
DROP TABLE IF EXISTS `language`;
CREATE TABLE `language` (
  `LANGUAGE_ID` int(5) NOT NULL,
  `LANGUAGE_NAME` varchar(20) NOT NULL,
  PRIMARY KEY (`LANGUAGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of language
-- ----------------------------
INSERT INTO `language` VALUES ('1', '国语');
INSERT INTO `language` VALUES ('2', '英语');
INSERT INTO `language` VALUES ('3', '日语');
INSERT INTO `language` VALUES ('4', '韩语');
INSERT INTO `language` VALUES ('5', '粤语');
INSERT INTO `language` VALUES ('6', '印度语');
INSERT INTO `language` VALUES ('7', '法语');
INSERT INTO `language` VALUES ('8', '西班牙语');
INSERT INTO `language` VALUES ('9', '俄语');
INSERT INTO `language` VALUES ('10', '意大利语');
INSERT INTO `language` VALUES ('11', '德语');

-- ----------------------------
-- Table structure for languageset
-- ----------------------------
DROP TABLE IF EXISTS `languageset`;
CREATE TABLE `languageset` (
  `LanguageID` varchar(20) NOT NULL,
  `LanguageName` varchar(20) NOT NULL,
  PRIMARY KEY (`LanguageID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of languageset
-- ----------------------------
INSERT INTO `languageset` VALUES ('Lang0001', 'Arabic');
INSERT INTO `languageset` VALUES ('Lang0002', 'Greek');
INSERT INTO `languageset` VALUES ('Lang0003', 'Turkish');
INSERT INTO `languageset` VALUES ('Lang0004', 'Farsi');
INSERT INTO `languageset` VALUES ('Lang0005', 'Assyrian');
INSERT INTO `languageset` VALUES ('Lang0006', 'Kurdish');
INSERT INTO `languageset` VALUES ('Lang0007', 'Hebrew');
INSERT INTO `languageset` VALUES ('Lang0008', 'French');
INSERT INTO `languageset` VALUES ('Lang0009', 'German');
INSERT INTO `languageset` VALUES ('Lang0010', 'English');

-- ----------------------------
-- Table structure for livesource
-- ----------------------------
DROP TABLE IF EXISTS `livesource`;
CREATE TABLE `livesource` (
  `channelId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `channelName` varchar(45) NOT NULL,
  `app` varchar(45) NOT NULL,
  `filename` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `language` varchar(20) NOT NULL,
  `pic` varchar(45) NOT NULL,
  PRIMARY KEY (`channelId`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of livesource
-- ----------------------------
INSERT INTO `livesource` VALUES ('1', 'Bein Sport 1HD', 'live', 'bein1', 'Live', 'Arabic', '/img/live/jsc1HD.jpg');
INSERT INTO `livesource` VALUES ('103', 'Bein Sport 1HD', 'live', 'bein1', 'Live', 'Arabic', '/img/live/jsc1HD.jpg');
INSERT INTO `livesource` VALUES ('104', 'Bein Sport 2HD', 'live', 'bein2', 'Live', 'Arabic', '/img/live/jsc2HD.jpg');
INSERT INTO `livesource` VALUES ('105', 'Bein Sport 3HD', 'live', 'bein3', 'Live', 'Arabic', '/img/live/jsc3HD.jpg');
INSERT INTO `livesource` VALUES ('106', 'Bein Sport 4HD', 'live', 'bein4', 'Live', 'Arabic', '/img/live/jsc4HD.jpg');
INSERT INTO `livesource` VALUES ('107', 'Bein Sport 5HD', 'live', 'bein5', 'Live', 'Arabic', '/img/live/jsc5HD.jpg');
INSERT INTO `livesource` VALUES ('108', 'Bein Sport 6HD', 'live', 'bein6', 'Live', 'Arabic', '/img/live/jsc6HD.jpg');
INSERT INTO `livesource` VALUES ('109', 'Bein Sport 7HD', 'live', 'bein7', 'Live', 'Arabic', '/img/live/jsc7HD.jpg');
INSERT INTO `livesource` VALUES ('110', 'Bein Sport 8HD', 'live', 'bein8', 'Live', 'Arabic', '/img/live/jsc8HD.jpg');
INSERT INTO `livesource` VALUES ('111', 'Bein Sport 9HD', 'live', 'bein9', 'Live', 'Arabic', '/img/live/jsc9HD.jpg');
INSERT INTO `livesource` VALUES ('112', 'Bein Sport 10HD', 'live', 'bein10', 'Live', 'Arabic', '/img/live/jsc10HD.jpg');
INSERT INTO `livesource` VALUES ('113', 'Bein Sport 11HD', 'live', 'bein11', 'Live', 'Arabic', '/img/live/jsc11HD.jpg');
INSERT INTO `livesource` VALUES ('114', 'Bein Sport 12HD', 'live', 'bein12', 'Live', 'Arabic', '/img/live/jsc12HD.jpg');
INSERT INTO `livesource` VALUES ('115', 'Bein Sport 13HD', 'live', 'bein13', 'Live', 'Arabic', '/img/live/jsc13HD.jpg');
INSERT INTO `livesource` VALUES ('116', 'Sky Sport 1 IT', 'live', 'sky_sport1_it', 'Live', 'Italian', '/img/live/sky_sports1.jpg');
INSERT INTO `livesource` VALUES ('117', 'Sky Sport Moto GP HD', 'live', 'sky_sport_motoGP', 'Live', 'Italian', '/img/live/sky_sports_motogp.jpg');
INSERT INTO `livesource` VALUES ('118', 'Sky Sport F1', 'live', 'sky_sport_f1', 'Live', 'Italian', '/img/live/sky_sport_f1.jpg');
INSERT INTO `livesource` VALUES ('119', 'Sky Sport 3 HD', 'live', 'sky_sport3_hd', 'Live', 'Italian', '/img/live/sky_sport3_hd.jpg');
INSERT INTO `livesource` VALUES ('120', 'Sky Sport 24', 'live', 'sky_sport24_hd', 'Live', 'Italian', '/img/live/sky_sport24_hd.jpg');
INSERT INTO `livesource` VALUES ('121', 'Sky Cinema Mx', 'live', 'sky_cinema_max', 'Live', 'Italian', '/img/live/sky_cinema_max.jpg');
INSERT INTO `livesource` VALUES ('122', 'Sky Cinema Classics', 'live', 'sky_cinema_classics', 'Live', 'Italian', '/img/live/sky_cinema_classics.jpg');
INSERT INTO `livesource` VALUES ('123', 'Sky Cinema 1 HD', 'live', 'sky_cinema1_hd', 'Live', 'Italian', '/img/live/sky_cinema1_hd.jpg');
INSERT INTO `livesource` VALUES ('124', 'AD Sport 1', 'live', 'ad_sport1', 'Live', 'Arabic', '/img/live/adsport.jpg');
INSERT INTO `livesource` VALUES ('125', 'TV4 Sport HD', 'live', 'tv4_sport_hd', 'Live', 'Swedish', '/img/live/tv4_sport_hd.jpg');
INSERT INTO `livesource` VALUES ('126', 'TV2 Sport', 'live', 'tv2_sport', 'Live', 'Norwegian', '/img/live/tv2_sport.jpg');
INSERT INTO `livesource` VALUES ('127', 'TV3 Sport', 'live', 'tv3_sport', 'Live', 'Danish', '/img/live/tv3_sport.jpg');
INSERT INTO `livesource` VALUES ('128', 'Nile Sport', 'live', 'nile_spo', 'Live', 'Arabic', '/img/live/nilesport.jpg');
INSERT INTO `livesource` VALUES ('129', 'Rotana Clip', 'live', 'rotana_clip', 'Live', 'Arabic', '/img/live/rotanaclip.jpg');
INSERT INTO `livesource` VALUES ('130', 'Rotana Classic', 'live', 'rotana_cla', 'Live', 'Arabic', '/img/live/rotanaclassic.jpg');
INSERT INTO `livesource` VALUES ('131', 'Rotana Cinema', 'live', 'rotana_cin', 'Live', 'Arabic', '/img/live/rotanacinema.jpg');
INSERT INTO `livesource` VALUES ('132', 'Zee Aflam', 'live', 'zee_aflam', 'Live', 'Arabic', '/img/live/zee_aflam.jpg');
INSERT INTO `livesource` VALUES ('133', 'Zee Alwan', 'live', 'zeealwan', 'Live', 'Arabic', '/img/live/zeealwan.jpg');
INSERT INTO `livesource` VALUES ('134', 'Nile Drama', 'live', 'nile_drama', 'Live', 'Arabic', '/img/live/niledrama.jpg');
INSERT INTO `livesource` VALUES ('135', 'Canal 5', 'live', 'canal5', 'Live', 'Italian', '/img/live/canal5.jpg');
INSERT INTO `livesource` VALUES ('136', 'CBC', 'live', 'cbc', 'Live', 'Arabic', '/img/live/cbc.jpg');
INSERT INTO `livesource` VALUES ('137', 'CBC Drama', 'live', 'cbc_dra', 'Live', 'Arabic', '/img/live/cbc_drama.jpg');
INSERT INTO `livesource` VALUES ('138', 'Nile TV', 'live', 'nile_tv', 'Live', 'Arabic', '/img/live/niletv.jpg');
INSERT INTO `livesource` VALUES ('139', 'Nile Cinema', 'live', 'nile_cine', 'Live', 'Arabic', '/img/live/nilecinema.jpg');
INSERT INTO `livesource` VALUES ('140', 'BBC arabic', 'live', 'bbcarabic', 'Live', 'Arabic', '/img/live/bbc_arabic.jpg');
INSERT INTO `livesource` VALUES ('141', 'Dream 2', 'live', 'dream2', 'Live', 'Arabic', '/img/live/dream.jpg');
INSERT INTO `livesource` VALUES ('142', 'Mody kids', 'live', 'mody_kids', 'Live', 'Arabic', '/img/live/modykids.jpg');
INSERT INTO `livesource` VALUES ('143', 'Rotana Music', 'live', 'rotana_music', 'Live', 'Arabic', '/img/live/rotana_music.jpg');
INSERT INTO `livesource` VALUES ('144', 'AL Aoula', 'live', 'al_aoula', 'Live', 'Arabic', '/img/live/al_aoula.jpg');
INSERT INTO `livesource` VALUES ('145', 'Rai 1 HD', 'live', 'rai1_hd', 'Live', 'Italian', '/img/live/rai1_hd.jpg');
INSERT INTO `livesource` VALUES ('146', 'Rai 3 HD', 'live', 'rai3', 'Live', 'Italian', '/img/live/rai3.jpg');
INSERT INTO `livesource` VALUES ('147', 'MBC1', 'live', 'mbc1', 'Live', 'Arabic', '/img/live/mbc1.jpg');
INSERT INTO `livesource` VALUES ('148', 'MBC2', 'live', 'mbc2', 'Live', 'Arabic', '/img/live/mbc2.jpg');
INSERT INTO `livesource` VALUES ('149', 'MBC3', 'live', 'mbc3', 'Live', 'Arabic', '/img/live/mbc3.jpg');
INSERT INTO `livesource` VALUES ('150', 'MBC4', 'live', 'mbc4', 'Live', 'Arabic', '/img/live/mbc4.jpg');
INSERT INTO `livesource` VALUES ('151', 'MBC MAX', 'live', 'mbcmax', 'Live', 'Arabic', '/img/live/mbcmax.jpg');
INSERT INTO `livesource` VALUES ('152', 'MBC Bollywood', 'live', 'mbcbollywood', 'Live', 'Arabic', '/img/live/mbc_bollywood.jpg');
INSERT INTO `livesource` VALUES ('153', 'MBC Drama', 'live', 'mbcdrama', 'Live', 'Arabic', '/img/live/mbc_drama.jpg');
INSERT INTO `livesource` VALUES ('154', 'MBC Masr', 'live', 'mbc_masr', 'Live', 'Arabic', '/img/live/mbcmasr.jpg');
INSERT INTO `livesource` VALUES ('155', 'Hekayat1', 'live', 'hekayat1', 'Live', 'Arabic', '/img/live/hekayat.jpg');
INSERT INTO `livesource` VALUES ('156', 'Cinema AR', 'live', 'cinema_ar', 'Live', 'Arabic', '/img/live/cinema_ar.jpg');
INSERT INTO `livesource` VALUES ('157', 'Cima AR', 'live', 'cima_ar', 'Live', 'Arabic', '/img/live/cima_ar.jpg');
INSERT INTO `livesource` VALUES ('158', 'Alhayat 1', 'live', 'alhayat1', 'Live', 'Arabic', '/img/live/alhayat.jpg');
INSERT INTO `livesource` VALUES ('159', 'Alhayat 2', 'live', 'alhayat2', 'Live', 'Arabic', '/img/live/alhayat2.jpg');
INSERT INTO `livesource` VALUES ('160', 'Eurosport 1', 'live', 'eurosport1', 'Live', 'British', '/img/live/eurosport.jpg');
INSERT INTO `livesource` VALUES ('161', 'Eurosport 2', 'live', 'eurosport2', 'Live', 'British', '/img/live/eurosport.jpg');
INSERT INTO `livesource` VALUES ('162', 'Nile Family', 'live', 'nile_family', 'Live', 'Arabic', '/img/live/nile_family.jpg');
INSERT INTO `livesource` VALUES ('163', 'Nile Comedy', 'live', 'nile_comedy', 'Live', 'Arabic', '/img/live/nile_comedy.jpg');
INSERT INTO `livesource` VALUES ('164', 'Mtv Sport 2', 'live', 'mtv_sport2', 'Live', 'Finnish', '/img/live/mtv_sport2.jpg');
INSERT INTO `livesource` VALUES ('165', 'Rai 2 HD', 'live', 'rai2', 'Live', 'Italian', '/img/live/rai2.jpg');
INSERT INTO `livesource` VALUES ('166', 'AlRasheed', 'live', 'alrasheed', 'Live', 'Arabic', '/img/live/alrasheed.jpg');
INSERT INTO `livesource` VALUES ('167', 'Toyor-Janah', 'live', 'toyor_janah', 'Live', 'Arabic', '/img/live/toyor_janah.jpg');
INSERT INTO `livesource` VALUES ('168', 'Syria Drama', 'live', 'syria_drm', 'Live', 'Arabic', '/img/live/syria_drm.jpg');
INSERT INTO `livesource` VALUES ('169', 'Cinema Pro', 'live', 'cinema_pro', 'Live', 'Arabic', '/img/live/cinema_pro.jpg');
INSERT INTO `livesource` VALUES ('170', 'Sat7 Kids', 'live', 'sat7kids', 'Live', 'Arabic', '/img/live/sat7kids.jpg');
INSERT INTO `livesource` VALUES ('171', 'Sat 7', 'live', 'sat7', 'Live', 'Arabic', '/img/live/sat7.jpg');
INSERT INTO `livesource` VALUES ('172', 'Panorama Drama', 'live', 'panorama_drama', 'Live', 'Arabic', '/img/live/panorama_drama.jpg');
INSERT INTO `livesource` VALUES ('173', 'Panorama Drama 2', 'live', 'panorama_drama2', 'Live', 'Arabic', '/img/live/panorama_drama2.jpg');
INSERT INTO `livesource` VALUES ('174', 'Panorama Comedy', 'live', 'panorama_comedy', 'Live', 'Arabic', '/img/live/panorama_comedy.jpg');
INSERT INTO `livesource` VALUES ('175', 'Tv Tchad', 'live', 'tv_tchad', 'Live', 'Arabic', '/img/live/tv_tchad.jpg');
INSERT INTO `livesource` VALUES ('176', 'Al Jannah', 'live', 'al_jannah', 'Live', 'Arabic', '/img/live/al_jannah.jpg');
INSERT INTO `livesource` VALUES ('177', 'Toktok Cine', 'live', 'toktok_cine', 'Live', 'Arabic', '/img/live/toktok_cine.jpg');
INSERT INTO `livesource` VALUES ('178', 'Samira Tv', 'live', 'samira_tv', 'Live', 'Arabic', '/img/live/samira_tv.jpg');
INSERT INTO `livesource` VALUES ('179', 'Rotana Khalijia', 'live', 'rotana_kahalijia', 'Live', 'Arabic', '/img/live/rotana_khalijia.jpg');
INSERT INTO `livesource` VALUES ('180', 'Panorama Action', 'live', 'panorama_action', 'Live', 'Arabic', '/img/live/panorama_action.jpg');
INSERT INTO `livesource` VALUES ('181', 'Panorama Food', 'live', 'panorama_food', 'Live', 'Arabic', '/img/live/panorama_food.jpg');
INSERT INTO `livesource` VALUES ('182', 'Canal Sport', 'live', 'canal_sport', 'Live', 'Arabic', '/img/live/canal_sport.jpg');
INSERT INTO `livesource` VALUES ('183', 'Canal Series', 'live', 'canal_series', 'Live', 'French', '/img/live/canal_series.jpg');
INSERT INTO `livesource` VALUES ('184', 'Canal Decale', 'live', 'canal_decale', 'Live', 'French', '/img/live/canal_decale.jpg');
INSERT INTO `livesource` VALUES ('185', 'Canal Cinema', 'live', 'canal_cinema', 'Live', 'French', '/img/live/canal_cinema.jpg');
INSERT INTO `livesource` VALUES ('186', 'NBN', 'live', 'nbn', 'Live', 'Arabic', '/img/live/nbn.jpg');
INSERT INTO `livesource` VALUES ('187', 'Melody Classic', 'live', 'melody_classic', 'Live', 'Arabic', '/img/live/melody_classic.jpg');
INSERT INTO `livesource` VALUES ('188', 'Majestic', 'live', 'majestic', 'Live', 'Arabic', '/img/live/majestic.jpg');
INSERT INTO `livesource` VALUES ('189', 'LBC', 'live', 'lbc', 'Live', 'Arabic', '/img/live/lbc.jpg');
INSERT INTO `livesource` VALUES ('190', 'Karameech', 'live', 'karameech', 'Live', 'Arabic', '/img/live/karameech.jpg');
INSERT INTO `livesource` VALUES ('191', 'Iqraa', 'live', 'iqraa', 'Live', 'Arabic', '/img/live/iqraa.jpg');
INSERT INTO `livesource` VALUES ('192', 'Dzari 25', 'live', 'dzair25', 'Live', 'Arabic', '/img/live/dzair.jpg');
INSERT INTO `livesource` VALUES ('193', 'Dzair 21', 'live', 'dzair21', 'Live', 'Arabic', '/img/live/dzair.jpg');
INSERT INTO `livesource` VALUES ('194', 'Beur Tv', 'live', 'beur_tv', 'Live', 'Arabic', '/img/live/beur_tv.jpg');
INSERT INTO `livesource` VALUES ('195', 'Baraem', 'live', 'baraem', 'Live', 'Arabic', '/img/live/baraem.jpg');
INSERT INTO `livesource` VALUES ('196', 'Assadissa', 'live', 'assadissa', 'Live', 'Arabic', '/img/live/assadissa.jpg');
INSERT INTO `livesource` VALUES ('197', 'Arriadia', 'live', 'alriadhia', 'Live', 'Arabic', '/img/live/alriadhia.jpg');
INSERT INTO `livesource` VALUES ('198', 'Al Quds', 'live', 'alqods', 'Live', 'Arabic', '/img/live/alqods.jpg');
INSERT INTO `livesource` VALUES ('199', 'VOYAGE', 'live', 'voyage', 'Live', 'French', '/img/live/voyage.jpg');
INSERT INTO `livesource` VALUES ('200', 'TV5 Monde', 'live', 'tv5_monde', 'Live', 'French', '/img/live/tv5_monde.jpg');
INSERT INTO `livesource` VALUES ('201', 'Tv Breizh', 'live', 'tv_breizh', 'Live', 'French', '/img/live/tv_breizh.jpg');
INSERT INTO `livesource` VALUES ('202', 'Cine Frisson', 'live', 'cine_frisson', 'Live', 'French', '/img/live/cine_frisson.jpg');
INSERT INTO `livesource` VALUES ('203', 'Cine Classic', 'live', 'cine_classic', 'Live', 'French', '/img/live/cine_classic.jpg');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AccountID` varchar(20) NOT NULL,
  `ExecTime` datetime NOT NULL,
  `Operation` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('8', 'FC4BBC2A3917', '2016-07-03 19:47:58', 'active the stb');
INSERT INTO `log` VALUES ('9', 'FC4BBC2B1AAE', '2016-07-04 10:08:24', 'active the stb');
INSERT INTO `log` VALUES ('10', 'FC4BBC2B1AAE', '2016-07-04 10:13:08', 'purchase a new product PRD0001with card 0909201220130002');

-- ----------------------------
-- Table structure for media_catalog
-- ----------------------------
DROP TABLE IF EXISTS `media_catalog`;
CREATE TABLE `media_catalog` (
  `MEDIA_CATALOG_ID` int(5) NOT NULL,
  `MEDIA_CATALOG_NAME` varchar(30) NOT NULL,
  `CATALOG_EN_NAME` varchar(30) NOT NULL,
  `UPDATE_TSTAMP` date DEFAULT NULL,
  `PIC` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`MEDIA_CATALOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of media_catalog
-- ----------------------------
INSERT INTO `media_catalog` VALUES ('4', '画皮2', 'huapi2', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('5', '非诚勿扰 1-2 合辑', 'feichengwurao', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('7', '双城计中计', 'shuangzhongji', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('8', '致命替身', 'zhimingtishen', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('9', '四大名捕', 'sidamingbu', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('10', '哈维的最后机会', 'lastchancehavy', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('11', '双面女蝎星', 'pointofreturn', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('12', '醉饿游戏', 'zuieyouxi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('14', '我，弗兰肯斯坦', 'wofulanke', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('15', '变形金刚', 'transformers', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('16', '冰雪奇缘', 'bingxueqingyuan', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('17', '名扬四海', 'mingyangsihai', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('18', '遥远的桥', 'yaoyuandeqiao', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('19', '巴顿将军', 'baodunjiangjun', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('20', '中途岛之战', 'zhongtudao', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('21', '天堂电影院', 'tiantangdianyingyuan', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('22', '西西里的美丽传说', 'xixilimeilichuanshuo', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('23', '里昂黑帮', 'liangheibang', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('24', '伴雨行', 'banyuxing', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('25', '方托马斯大战苏格兰场', 'fangtuomasi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('26', '方托马斯合辑', 'fangtuomasiheji', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('27', '食人恋', 'shirenlian', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('28', '奇可和丽塔', 'qikehelita', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('29', '附身', 'fushen', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('30', '野蛮入侵', 'yemanruqin', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('31', '船长哈洛克', 'chuanzhanghualuoke', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('32', '贞子', 'zhenzi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('33', '100次哭泣', 'yibaicikuqi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('34', '十三刺客', 'shisancike', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('35', '短暂和平', 'duanzanheping', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('36', '热血青春', 'rexueqingchun', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('37', '大叔', 'dashu', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('38', '胡狼来了', 'hulang', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('39', '小企鹅南极历险记', 'xiaoqqlixianji', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('40', '汉江怪物', 'hanjiangguaiwu', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('41', '三国演义', 'sanguoyanyi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('42', '葫芦娃', 'huluwa', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('43', '喜羊羊与灰太狼', 'xiyangyang', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('44', '铠甲勇士拿瓦', 'kaijiayongshi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('45', '小鲤鱼历险记', 'xiaoliyulixianji', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('46', '黑礁', 'heijiao', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('47', '全金属狂潮', 'quanjinshu', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('48', '驱魔少年', 'qvmoshaonian', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('49', '一骑当千', 'yiqidangqian', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('50', '猫和老鼠', 'maohelaoshu', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('51', '邪恶力量', 'xieeliliang', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('52', '南方公园', 'nanfangongyuan', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('53', 'TED演讲集', 'ted', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('54', '斯坦福大学开放课程: 编程方法', 'sitanfubiaocheng', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('55', '耶鲁公开课：哲学与人性', 'zhexueyurenxing', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('56', '耶鲁大学开放课程：金融理论', 'jinronglilun', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('57', '耶鲁大学开放课程：金融市场', 'jinrongshichang', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('58', '麻省理工学院开放课程：算法导论', 'suanfadaolun', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('59', '斯坦福大学开放课程: 编程范式', 'bianchengfanshi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('60', '耶鲁大学开放课程：资本主义：成功、危机与改革', 'zibenzhuyi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('61', 'CCTV-1', 'CCTV-1', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('62', 'CCTV-2', 'CCTV-2', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('63', 'CCTV-3', 'CCTV-3', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('64', 'CCTV-4', 'CCTV-4', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('65', 'CCTV-5', 'CCTV-5', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('66', 'CCTV-6', 'CCTV-6', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('67', '湖南卫视', 'HNTV', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('68', '江苏卫视', 'JSTV', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('69', '浙江卫视', 'ZSTV', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('70', '东方卫视', 'DFTV', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('71', '天津影视', 'TJYS', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('72', '天津都市', 'TJDS', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('73', '天津体育', 'TJTY', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('74', '凤凰卫视', 'FHTV', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('75', '香港卫视', 'HKTV', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('76', '啦啦啦', 'lalala', null, null);
INSERT INTO `media_catalog` VALUES ('80', '啦啦啦', '', null, null);
INSERT INTO `media_catalog` VALUES ('81', '雷神', 'Thor ', null, null);

-- ----------------------------
-- Table structure for media_desc
-- ----------------------------
DROP TABLE IF EXISTS `media_desc`;
CREATE TABLE `media_desc` (
  `MEDIA_ID` int(5) NOT NULL,
  `MEDIA_NAME` varchar(30) NOT NULL,
  `MEDIA_CATALOG_ID` int(5) NOT NULL,
  `AREA_ID` int(5) DEFAULT NULL,
  `LANGUAGE_ID` int(5) DEFAULT NULL,
  `YEAR` varchar(30) DEFAULT NULL,
  `DIRECTOR` varchar(30) DEFAULT NULL,
  `ACTOR` varchar(30) DEFAULT NULL,
  `INTRODUCTION` varchar(300) DEFAULT NULL,
  `GRADE` int(2) DEFAULT NULL,
  `PIC` varchar(30) DEFAULT NULL,
  `CHECK_TYPE` varchar(1) NOT NULL DEFAULT '1',
  `CHECK_DATE` varchar(10) DEFAULT NULL,
  `END_DATE` varchar(10) DEFAULT NULL,
  `VIP_STATE` varchar(1) DEFAULT '',
  PRIMARY KEY (`MEDIA_ID`),
  KEY `pk_area` (`AREA_ID`),
  KEY `pk_lang` (`LANGUAGE_ID`),
  KEY `pk_desc` (`MEDIA_CATALOG_ID`),
  CONSTRAINT `pk_area` FOREIGN KEY (`AREA_ID`) REFERENCES `area` (`AREA_ID`),
  CONSTRAINT `pk_desc` FOREIGN KEY (`MEDIA_CATALOG_ID`) REFERENCES `media_catalog` (`MEDIA_CATALOG_ID`),
  CONSTRAINT `pk_lang` FOREIGN KEY (`LANGUAGE_ID`) REFERENCES `language` (`LANGUAGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of media_desc
-- ----------------------------
INSERT INTO `media_desc` VALUES ('4', '画皮2', '4', '1', '1', '20120808', '乌尔善', '费翔 / 冯绍峰 / 杨幂', '妖狐小 唯（周迅 饰）因救人违反妖界规则，被封冻在寒冰地狱中度过了五百年，痛苦不堪。在命运面前，逃离冰窟的小唯只有两个选择：要么被寒冰地狱的冰舌抓回去，要么获得一 颗“主动奉献”的人心真正成人。小唯四处寻找目标，直到偶遇逃婚并因一次意外被毁容的靖公主（赵薇 饰）。小唯很快发现，公主有一颗与众不同的心，她把变成人的理想全部寄托在公主身上。', '80', 'bcc91714.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('5', '非诚勿扰 1-2 合辑', '5', '1', '1', '20120505', '冯小刚', '葛优 / 舒淇 / 方中信 / 胡可 / 徐若瑄 / 范伟 ', '海归秦奋（葛优 饰）的天才发明“分歧终端机”因能公平和平地解决人类分歧，被风投者以200万英镑高价买走。秦奋也开始踏上网上征婚的路途，一路笑话不断，不是重遇 Gay友，就是遇到推销客，秦奋颇有点心灰意冷，以致遇到清冷女子梁笑笑（舒淇 饰）时便开门见山请求对方说明来意。这次更为棘手，笑笑爱上有妇之夫，陷于苦恋中不停挣扎，这次纯属听从家里人安排才出来与秦奋见上一面。不再打算再见的 二人尽情地分享了生命中最隐秘的秘密。', '85', 'bcc91715.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('7', '双城计中计', '7', '1', '1', '20120204', '潘安子', '翁虹 / 刘承俊 / 熊乃瑾 / 腾格尔', '在赌场内“散步”的小老千陈少卿欠下黑道老大林啸东一只手，为了保住这只手，陈少卿不得已将一条财路乖乖奉上。并带着林啸东找到假扮探长肥唐行骗的“千面鬼脸”以及躲在监狱中颐养天年的“不动石佛”两位江湖巨骗。', '35', 'bcc91717.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('8', '致命替身', '8', '1', '1', '20121116', '过华', '刘青 / 魏建云 / 王诗乔', '北漂女孩应佳（刘青 饰）怀着当明星的梦想，在这座城市里靠跑剧组来寻找演戏的机会。半个月没有接到戏的她，在接到某剧组试戏通知后，跟随副导一同驱车前往郊外的艺术顾问那里试戏。试戏结束，就在他们准备回去的时候，车子却意外出了故障。无奈之下，应佳只能在郊外暂宿一晚。半夜，被噩梦惊醒的应佳发 现自己在睡梦中被剁掉一根手指。而这不过是个开始，她逃跑失败再次被囚禁在这个阴森恐怖的房间里，无意间她发现通往密室的暗门。在这密室内藏了一具与应佳长得很像的女尸。应佳明白在这精心设计的谎言背后等待她的只有死亡，只有自救才能生存。一场惊心动魄的密室逃生由此展开', '50', 'bcc91718.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('9', '四大名捕', '9', '1', '1', '20120712', '陈嘉上', '郑中基 / 刘亦菲 / 邓超', '《四大名捕》是光线影业酝酿多年的计划，公司总顾问陈嘉上亲自执导该片，饰演四大名捕的演员也已经确定，冷血、无情、铁手、追命四人的扮演者分别是邓超、刘亦菲、邹兆龙和郑中基。', '60', 'bcc91719.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('10', '哈维的最后机会', '10', '2', '2', '20080819', '乔尔·霍普金斯', '帕特里克·巴拉迪 / 丹尼尔·莱派恩 ', '哈维的梦想本是做一名出色的爵士乐钢琴家，而现实却是他在纽约一家音乐工作室做广告歌曲的编曲人，老板对他的工作很不满意，早就有解雇他的打算，只不过看在往日情面上，才给了人到中年的哈维再一次机会，前提是不能再出任何差错。哈维打算去伦敦参加感情疏远的女儿的婚礼，在那里他的前妻给所有的亲戚朋友都租好了房子让他们可以歇息，但独独忘记了哈维。', '80', 'bcc91720.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('11', '双面女蝎星', '11', '2', '2', '19930202', '哈威·凯尔', '安妮·班克罗夫特', '麦琪因枪杀警察而被判死刑。当毒剂注入她的身体，她渐渐昏去。醒来时，她得知自己真实身份已经死亡，如果想要继续活命，就必须担当政府的杀手。经过一番脱胎换骨的训练，麦琪以新的身份重入社会，重新领略了生活的意义。而同时，她也产生了摆脱政府控制的想法。一场对立迅速展开', '72', 'bcc91721.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('12', '醉饿游戏', '12', '2', '2', '20140218', 'Josh Stolb', 'Ross Natha / Ben Begley ', '还记得在《醉后大丈夫》中的那4位难兄难弟的每一个失控单身派对吗？或是凯妮丝在《飢饿游戏》里无人能比的智慧与勇气（以及帅炸了的连恩汉斯沃）？看过电 影的人势必不会错过经典桥段，那　当4位喝醉了的大丈夫煳里煳涂地参加残酷的飢饿游戏时，又会擦出什么火花呢？就让醉饿游戏来演给大家看！', '60', 'bcc91722.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('14', '我，弗兰肯斯坦', '14', '2', '2', '20140114', '斯图尔特·比蒂', '艾伦·艾克哈特 / 伊冯娜·斯特拉霍夫斯', '《我，弗兰肯斯坦》与《绅士大联盟》（League Of Extraordinary Gentlemen）类似，也是把一群本来生活在不同文艺作品里的经典人物集中到了一个故事里，所不同的是，《我，弗兰肯斯坦》里集合的全都是怪物。', '73', 'bcc91724.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('15', '变形金刚系列', '15', '2', '2', '20070823', '迈克尔·贝', '希亚·拉博夫 / 梅根·福克斯', '故事由赛伯坦被威震天（Megatron）毁灭开始讲起，威震天为了找回可以为一切无生命物体注入生命能量的“火种源”（Allspark）用以称霸宇宙，只身来到了地球。可是他却不慎掉入北冰洋，被冰冻住。1897年，亚奇帕德·维特维奇船长（Archibald Witwicky）带领他的船员进入北冰洋，不慎坠入深洞，发现了威震天。', '99', 'bcc91725.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('16', '冰雪奇缘', '16', '2', '2', '20131117', '克里斯·巴克 / 詹妮弗·李', '克里斯汀·贝尔 / 乔纳森·格罗夫', '故事讲述一个严冬咒语令王国被冰天雪地永久覆盖，乐观无畏的安娜（克里斯汀·贝尔配音）和热爱冒险的山民克里斯托夫（乔纳森·格罗夫配音）以及他的驯鹿搭档组队出发，展开一段魔法层出不穷、旅程峰回路转的大冒险，以寻找安娜的姐姐——冰雪皇后艾莎（伊迪娜·门泽尔配音），破解她的冰封魔咒。一路上他们遇到搞笑的神奇雪人、各式奇幻精灵、意想不到的魔法迷阵，更在雪崩冰裂中步步惊心……他们最终能否拯救王国？', '90', 'bcc91726.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('17', '名扬四海', '17', '2', '2', '20091223', '凯文·唐查罗恩', '凯·帕娜贝克 / 娜图里·劳顿', '在纽约表演艺术高中里，聚集着一群在唱歌、舞蹈和表演上极有天赋的年轻学生。他们要在这里接受4年的学习。在毕业之后，他们就要为自己的理想而奋斗。或是被星探发现一举成名，或是参加选秀节目摘得头名……总之，每个人都有自己的奋斗目标、每个人都有自己的终极梦想。', '95', 'bcc91727.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('18', '遥远的桥', '18', '2', '2', '19770615', '理查德·阿滕伯勒', '詹姆斯·凯恩 / 迈克尔·凯恩', '欧战尾声，盟军上下逐渐弥漫着乐观的情绪。为了提前结束战争，各地盟军将领认为只要一番猛攻，便可提早直捣柏林结束战争。于是轻率地将大批伞兵空投在德军营地背后，去攻占阿纳姆的那座横跨莱茵河的大桥。不料遭遇德军的顽强抵抗，盟军付出了伤亡惨重的代价。这场堪称二战中最具戏剧性的战役，终以盟军的惨痛失败而告终。', '98', 'bcc91728.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('19', '巴顿将军', '19', '2', '2', '19770718', '富兰克林·沙夫纳', '乔治·C·斯科特 / 卡尔·莫尔登 ', '1943年3月，巴顿率美军在法属摩洛哥登陆后临危受命，担任美军在北非的第二军团长，性格强势、钟情古典文化又熟稔战史相信灵魂转世的巴顿很快用铁血律令扭转了北非部队的散漫风格，连番激战后与蒙哥马利统率的英军合力将“沙漠之狐”隆美尔赶出了北非。', '97', 'bcc91729.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('20', '中途岛之战', '20', '2', '2', '19760618', '杰克·斯米特', '查尔登·海斯顿 / 格伦·福特 ', '七十年代出品的大型战争片之一，焦点是美国与日本海军对垒的中途岛战役。在当年的一批同类电影之中，本片不算是突出之作，导演杰克．斯米特的处理手法相对比较平庸，但超级明星阵容却可以令今天的观众重睹上一代巨星风采，而海战的场面也实在拍得逼真，使本片仍维持了相当的趣味性。', '98', 'bcc91730.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('21', '天堂电影院', '21', '14', '10', '19881118', '朱塞佩·托纳多雷', '萨瓦特利·卡西欧 / 恩佐·卡拉瓦勒', '意大利南部小镇，古灵精怪的小男孩多多在胶片中找到了童年生活的乐趣。', '99', 'bcc91731.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('22', '西西里的美丽传说', '22', '14', '10', '20001027', '朱塞佩·托纳多雷', '莫妮卡·贝鲁奇 / 圭塞佩·苏尔法罗', '1941年，整个世界都被笼罩在二战的硝烟之中，但西西里岛仍是一片宁和，这里正是男孩雷纳托的家乡。他和所有13岁的孩子一样，天真、快乐、不安分，对生活充满幻想。终于有一天遇到了永远改变他生活的女人——梅琳娜。', '99', 'bcc91732.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('23', '里昂黑帮', '23', '9', '7', '20140114', '奥利维埃·马夏尔', '切基·卡尤 / 热拉尔·朗万', '成长在贫穷的吉普赛营地的埃德蒙·维达尔，又名摩门，保有着一份对家庭的责任感，无限忠诚与骄傲。尤其是，他和因偷窃而入狱的瑟奇·舒特尔依然保存着 友谊。两人无可避免的卷入到犯罪组织，六七十年代昂匪帮因持械抢劫而臭名卓著。不断壮大的匪帮在70年代中期得以遏制。', '80', 'bcc91733.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('24', '伴雨行', '24', '9', '7', '20130527', '陈英雄', '乔什·哈奈特', '洛杉矶警察克莱因在办案中惨遭羞辱，罪犯嗜血如命，喜欢肢解活人。克莱因身受重伤，仍侥幸活命，但心底留下阴影，被迫革职。3年后，一位中国富商委托克莱因帮忙寻找失 踪儿子师涛（木村拓哉 Takuya Kimura 饰），他来到香港，接待他的是好友孟子（余文乐 Shawn Yue 饰），后者亦是警察。', '76', 'bcc91734.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('25', '方托马斯大战苏格兰场', '25', '9', '7', '19700316', '安德里·胡尼贝勒', '路易·德·菲耐斯 / 让·马莱 / 麦琳娜·德蒙吉奥', '善于易容术的大盗方托马斯假扮成律师来到拉谢里爵士家，他提出所有的富人要想活命就必须缴纳生存权力税，否则将死在自己的手中。身价排名世界第三的拉谢里爵士当然要首当其冲，只要他肯交钱，其他富豪自然会效仿。方托马斯离开前限定了交钱的日期，拉谢里爵士只得向警方寻求帮助。', '68', 'bcc91735.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('26', '方托马斯合辑', '26', '9', '7', '19641107', '安德里·胡尼贝勒', '路易·德·菲耐斯 / 让·马莱 / 麦琳娜·德蒙吉奥', '善于易容术的大盗方托马斯假扮成律师来到拉谢里爵士家，他提出所有的富人要想活命就必须缴纳生存权力税，否则将死在自己的手中。身价排名世界第三的拉谢里爵士当然要首当其冲，只要他肯交钱，其他富豪自然会效仿。方托马斯离开前限定了交钱的日期，拉谢里爵士只得向警方寻求帮助。', '70', 'bcc91736.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('27', '食人恋', '27', '11', '8', '20131113', '曼纽尔·马丁·昆卡', '安东尼奥·德拉·托雷', '经营裁缝店的卡洛斯安静优雅，他生活在西班牙一座静谧舒适的小镇，每天只是裁剪和烹饪美食，爱情仿佛与他完全绝缘。那天，卡洛斯所在的公寓搬来一位名叫亚历珊德拉 （Olimpia Melinte 饰）的金发美丽女子。', '76', 'bcc91737.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('28', '奇可和丽塔', '28', '11', '8', '20101119', 'Tono Errando ', 'Limara Meneses', '故事发生在1948年的古巴，一次偶然中，钢琴师奇可结识了名叫丽塔的年轻女子，丽塔美妙的歌声吸引了奇可的注意，心心相惜的两颗心碰撞出了爱情的火花。', '65', 'bcc91738.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('29', '附身', '29', '10', '2', '20130527', '文森佐·纳塔利', '阿比盖尔·布蕾斯琳 / 大卫·休莱特', '影片主要讲了由阿比吉尔·布莱斯林饰演的女孩莉莎总是不断重回1985年的某天，同时，她遭遇的一系列惊悚事件也推动着她必须去解开这个谜团——为什么自己循环往复地回到这个奇怪的炼狱', '85', 'bcc91739.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('30', '野蛮入侵', '30', '10', '2', '20101013', '丹尼斯·阿康特', '雷米·吉拉德', '与父亲形同陌路的塞巴斯蒂安忽然接到母亲路易丝的电话，那个风流成性的历史教授父亲莱米如今躺在医院里，命不久矣。塞巴斯蒂安在一番犹豫之后赶回蒙特利尔，陪父亲走过最后一段时 光。多年的隔膜以及生活方式的差异让这对父子从一开始就吵了个天翻地覆，但塞巴斯蒂安还是想尽办法让父亲平静的走完最后的日子。', '74', 'bcc91740.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('31', '船长哈洛克', '31', '3', '3', '20131113', '荒牧伸志', '小栗旬 / 三浦春马', '根据松本零士原作漫画《宇宙海盗船长哈洛克》改编 。总制作费高达3000万美元的日本CG动画片《船长哈洛克》于2013年9月日本上映。声优由小栗旬，三浦春马，苍井优等担当。', '85', 'bcc91741.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('32', '贞子', '32', '3', '3', '20130525', '英勉', '泷本美织 / 濑户康史', '五年前，神秘的诅咒视频大肆泛滥，造成了令人难以估量的死亡事件和骚动。在此之后，鲇川茜（石原里美 饰）与安藤孝则（濑户康史 饰）结为夫妇，并生下可爱的女儿凪（平泽宏路路 饰）。可悲的是茜在产子后不久死去，孝则于是将女儿托付给就读临床心理学的妹妹枫子（泷本美织 饰）抚养。凪性格自闭，不愿与任何人交流，枫子为此颇感烦恼，却依旧努力和小侄女沟通，坚信总有一天可以令自幼失去母亲的凪敞开心扉。', '45', 'bcc91742.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('33', '100次哭泣', '33', '3', '3', '20100215', '广木隆一', '大仓忠义 / 桐谷美玲 ', '因为四年前的摩托车事故，藤井（大仓忠义）患上了逆行性健忘，失去了车祸前一年的记忆，忘记了他当时的女朋友佳美（桐谷美玲）的存在。', '87', 'bcc91743.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('34', '十三刺客', '34', '3', '3', '20100925', '三池崇史', '役所广司 / 山田孝之', '已是江户时代后期，时有明石藩江户之家老间宫图书（内野聖陽 饰）在幕府老中土井大炊头（平幹二朗 饰）的宅前自杀，此举引起朝野震动。一切皆由明石藩主齐昭（稲垣吾郎 饰）而起。齐昭系现任将军的异母弟弟，其人嗜血如命、暴虐无常，引起朝廷上下诸多人等的不满，然齐昭已内定成为下任老中。为免苍生遭其荼毒，土井授意岛田 新作卫门（役所広司 饰）在齐昭回藩途中予以刺杀。', '90', 'bcc91744.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('35', '短暂和平', '35', '3', '3', '20131210', '大友克洋', '早见沙织', '《短暂和平》由四个短片构成，情节上相互独立，在“日本”这个主题下，从历史、传统文化、亚文化、未来等不同维度来讲述故事。', '99', 'bcc91745.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('36', '热血青春', '36', '4', '4', '20140122', '李莲雨', '李钟硕 / 朴宝英 / 金英光', '《热血青春》讲述八十年代曾在忠南洪城一带非常有名的女生混混、传说的花花公子、火凤凰派老大，首尔来的转学生等青春男女的热血浪漫爱情故事。', '70', 'bcc91746.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('37', '大叔', '37', '4', '4', '20140805', '李政范', '元斌 / 金赛纶 / 金熙元', '妻子不幸去世后，前特殊要员泰锡（元彬饰）靠经营当铺生意为生，除了来店里委托当物的客人和住在隔壁的小女孩小米（金赛纶饰），他几乎不会主动与人交往和外出，因此有不少人怀疑他是隐姓埋名的犯罪者，生活有些寂寞冷清。', '85', 'bcc91747.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('38', '胡狼来了', '38', '4', '4', '20130716', '裴炯俊', '金在中 / 宋智孝 / 韩相镇', '传说中的冷艳女杀手奉敏静在隐退前接到一个谢幕任务——除掉现今顶尖红星“花美男”崔贤。为此，她潜入崔贤下榻的酒店，并成功绑架目标人物。在奉敏静的淫威之下，傲慢自大的崔贤不得不忍辱偷生，甚至谎称自己其实是山寨歌手崔宪，以求自保。', '71', 'bcc91748.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('39', '小企鹅南极历险记', '39', '4', '4', '20120222', '金晋滿 / 金在容', '宋钟基', '在父母永不息止的爱下，小皇帝企鹅Pengi和Sommi从蛋壳中苏醒过来。Pengi非常馋嘴，简直就是南极捣蛋小企鹅第一名；相反，可爱的Sommi 就文静得多，最喜欢躲在爸爸的怀里，它们慢慢就成为了好朋友。有一天，Sommi的爸爸到海边去觅食，好为冬天储备粮食，一去就没有回来。孤单的 Sommi独自面对寒冷和饥饿，Pengi拼命的想保护好友，助它渡过困难。最后，Pengi和Sommi能否排除万难成为又健康又美丽的成年皇帝企鹅？', '84', 'bcc91749.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('40', '汉江怪物', '40', '4', '4', '20060711', '奉俊昊', '宋康昊 / 朴海日 / 裴斗娜', '康斗（宋康昊饰）是一个平凡又有些糊涂的中年男人，他带着女儿玄舒（高雅成饰）与家人一起生活，在汉江边经营小店，过着安静祥和的生活。康斗父亲熙峰（边 熙峰饰）是一个和蔼老人，弟弟南日（朴海日饰）是家里唯一的大学生，却失业没有工作。他时常牢骚并酗酒，对现实不满。妹妹南珠（裴斗娜饰）是个射箭运动 员，却常在关键时刻掉链子。', '90', 'bcc91750.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('41', '三国演义', '41', '1', '1', '20091210', '朱敏', '徐涛 / 张震 / 李立宏', '三国时期三股最强的政治势力曹操、孙权、刘备之间错综复杂而充满张力的斗争，集中体现了那个时代层出不穷的杰出人物，以及他们的英勇行为和高强战略。', '95', 'bcc91751.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('42', '葫芦娃', '42', '1', '1', '19860212', '胡进庆', '姚忠礼', '一位老爷爷在山上采药，无意中进入了一个山洞，在洞中他救下一只穿山甲。穿山甲告诉老爷爷自己不小心穿破葫芦山，放走了蛇蝎二妖。穿山甲帮助老爷爷取出了能降妖服魔的宝葫芦籽。', '99', 'bcc91752.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('43', '喜羊羊与灰太狼', '43', '1', '1', '20050601', '黄伟明', '祖丽晴 / 张琳', '《喜羊羊与灰太狼》以羊和狼两大族群间妙趣横生的争斗为主线，剧情的轻松诙谐风格，情节爆笑，对白幽默。', '98', 'bcc91753.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('44', '铠甲勇士拿瓦', '44', '1', '1', '20131106', '郑国伟', '曹曦月', '马天与邪恶的李总（李笑愁）合作，企图发明可怕传染病毒和疫苗来大赚黑心钱，未料在一次运输意外中将未成熟的病毒扩散在城市里，此阶段的病毒会选择有犯罪基因的人做为宿主，并变异人类基因成为暴恶兽人-欧克瑟。', '85', 'bcc91754.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('45', '小鲤鱼历险记', '45', '1', '1', '20131106', '张族全', '伍凤春', '中央电视台耗资3600万元打造的大型动画电视连续剧《小鲤鱼历险记》是继四年前《哪吒传奇》之后央视推出的又一动画巨作。《小鲤鱼历险记》全剧共52集，总长1000多分钟，取材于中国古老的民间传说“小鲤鱼跳龙门”，不过在剧情上已经“面目全非”，据参与前期工作的有关人员透露该剧在制作过程中充分考虑了当今孩子的心理特点与喜好，无论从剧情设计、动画特效还是语言对白上都深受孩子们欢迎。', '96', 'bcc91755.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('46', '黑礁', '46', '3', '3', '20060408', '片渕须直', '浪川大辅', '故事的地点设在一个虚构的泰国海滨城市——罗阿那普拉（Roanapur），那里是黑帮和雇佣兵的天堂。黑礁商会的雇主多为聚集在罗阿那普拉的各大黑帮势 力，也包括一些临时出现的散客。任务一般是在海上运送各种各样的“货物”，包括带人跑路。黑礁商会主要的运输工具是一艘军用鱼雷快艇，但鱼雷只在第一话中 发射过，他们更多还是习惯于使用手枪、机枪等轻武器。值得一提的是在黑礁里出现的各种武器和运输工具大多在现实中存在，并非作者虚构的。', '99', 'bcc91756.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('47', '全金属狂潮', '47', '3', '3', '19980408', '贺东招二', '关智一', '《全金属狂潮》（台译《惊爆危机》）是一个年代设定为90年代，背景为冷战的架空世界，铁幕将世界分为东方和西方，美国和苏联两个超级大国维持着庞大的军 队，各自扶植了北大西洋公约和华沙条约两个组织，在世界范围内进行进攻和防御。从不正面交锋的东方和西方向各个敏感地区渗透自己的势力，无论是密林丛生的 中美洲还是千里戈壁的中亚，局部战争时有发生。', '99', 'bcc91757.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('48', '驱魔少年', '48', '3', '3', '20061003', '锅岛修', '小林沙苗', '在很久很久以前千年伯爵曾经想霸占地球，但有人用神的力量消灭千年伯爵后世界恢复和平，但预言说：千年伯爵会再度来临……', '99', 'bcc91758.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('49', '一骑当千', '49', '3', '3', '20061003', '渡部高志', '浅野真澄', '一骑当千是日本的大热ACG系列，由于内容与三国有一定关联，一直备受争议。系列横跨漫画、动画、游戏、周边产品等多个领域，原作为漫画家盐崎 雄二的同名漫画，2000年开始于漫画杂志《COMIC GUM》上连载至今，而后有TV动画四季和改编游戏3作。', '61', 'bcc91759.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('50', '猫和老鼠', '50', '2', '2', '19400101', '约瑟·巴贝拉', '汤姆 / 杰利', '猫和老鼠》采用了猫与鼠的原型，故事情节围绕一只常见的家猫汤姆和与它同居一室却难以抓住的老鼠杰瑞展开', '78', 'bcc91760.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('51', '邪恶力量', '51', '2', '2', '20081226', '宫繁之', '詹森·阿克斯 / 贾德·帕达里克', '《邪恶力量》，又译《狙魔人》（香港译）、《超自然档案》（台湾译），是由美国CW电视台播出的讲述灵异超自然现象的电视剧。在加拿大拍摄。该剧主要是在讲述两兄弟山姆·温彻斯特和迪恩·温彻斯特开着1967年的黑色雪佛兰“羚羊” 穿梭在美国各处调查超自然或不可思议的事件并与之战斗的故事，故事大多来自于美国的都市传说和民间传说。', '69', 'bcc91761.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('52', '南方公园', '52', '2', '2', '19990310', '崔·帕克', '特雷·帕克', '《南方公园》，其他译法包括《衰仔乐园》（港版翻译）或《南方四贱客》，是美国喜剧中心（Comedy Central）制作的一部剪纸摆拍动画剧集，由Matt Stone和Trey Parker创作。', '75', 'bcc91762.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('53', 'TED演讲集', '53', '2', '2', '20060627', '', '', '从2006年起，TED演讲的视频被上传到网上。截至2010年4月，TED官方网站上收录的TED演讲视频已达650个，有逾五千万的网民观看了TED演讲的视频。所有的TED演讲的视频都是以创用CC的方式予以授权的。', '86', 'bcc91763.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('54', '斯坦福大学开放课程: 编程方法', '54', '2', '2', '20050305', '', '', '本课程是最大的编程入门课程，也是斯坦福大学主要课程之一。介绍了当代程序设计基本思想：面向对象，模块化，封装，抽象化与测试。', '85', 'bcc91764.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('55', '耶鲁公开课：哲学与人性', '55', '2', '2', '20120407', '', '', '本课程是耶鲁公开课哲学与人性。', '85', 'bcc91765.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('56', '耶鲁大学开放课程：金融理论', '56', '2', '2', '20110311', '', '', '这门课程主要致力于解释金融系统在全球经济的背景下所扮演的角色及其重要性。 约翰.扬纳科普洛斯教授并没有把金融世界和经济世界分解开来，他将金融平衡作为经济平衡的一种补充来讲授。这门课程还将通过对冲基金来提供一种思考与分析的角度。', '90', 'bcc91766.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('57', '耶鲁大学开放课程：金融市场', '57', '2', '2', '20120602', '', '', '金融机构是文明社会的重要支柱。它们为投资活动提供支持及风险管理。如果我们想要预测金融机构动态及他们在这个信息时代中的发展态势，我们必须对其业务有 所了解。本课程将涉及的内容有：金融学理论、金融业的发展历程、金融机构（例如银行、保险公司、证券公司、期货公司及其他衍生市场）的优势与缺陷以及这些 机构的未来发展前景。', '89', 'bcc91767.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('58', '麻省理工学院开放课程：算法导论', '58', '2', '2', '20131012', '', '', '介绍一下课堂录像里面授课的两位MIT的老师，第一位，外表“绝顶聪明”的，是本书的第二作者Charles E. Leiserson，以逻辑严密，风趣幽默享MIT。第二位，留着金黄色的络腮胡子和马尾发的酷哥是Erik Demaine，21岁即取得MIT教授资格的天才，1981出生，今年才25岁，业余爱好是俄罗斯方块、演戏、琉璃、折纸、杂耍、魔术和结绳游戏。', '74', 'bcc91768.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('59', '斯坦福大学开放课程: 编程范式', '59', '2', '2', '20060224', '', '', 'c和c++高级内存管理特征。命令范式和面向对象范式的差别。函数范式--使用LISP和并发编程--使用c和c++。简单介绍一些其他流行的语言，如Python、Objective-C和C#。', '96', 'bcc91769.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('60', '耶鲁大学开放课程：资本主义', '60', '2', '2', '20060224', '', '', '本课将用源自生物演化的思路，来诠释资本主义', '99', 'bcc91770.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('61', 'CCTV-1', '61', '1', '1', '20131012', null, null, null, null, null, '3', '20160314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('62', 'CCTV-2', '62', '1', '1', null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('63', 'CCTV-3', '63', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('64', 'CCTV-4', '64', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('65', 'CCTV-5', '65', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('66', 'CCTV-6', '66', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('67', '湖南卫视', '67', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('68', '江苏卫视', '68', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('69', '浙江卫视', '69', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('70', '东方卫视', '70', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('71', '天津影视', '71', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('72', '天津都市', '72', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('73', '天津体育', '73', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('74', '凤凰卫视', '74', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('75', '香港卫视', '75', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('76', '雷神', '81', '1', '1', '20141202', '刘亚吉', '刘亚凶', '批量上传的', '1', null, '1', null, null, null);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `comment` varchar(45) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for product_media
-- ----------------------------
DROP TABLE IF EXISTS `product_media`;
CREATE TABLE `product_media` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `prod_id` int(10) unsigned NOT NULL,
  `media_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_media
-- ----------------------------

-- ----------------------------
-- Table structure for productcard
-- ----------------------------
DROP TABLE IF EXISTS `productcard`;
CREATE TABLE `productcard` (
  `CardNumber` varchar(50) NOT NULL,
  `CardValue` int(11) NOT NULL,
  `ProductID` varchar(20) NOT NULL,
  `CardState` int(11) NOT NULL,
  `UseDate` date NOT NULL,
  `AccountID` varchar(20) NOT NULL,
  PRIMARY KEY (`CardNumber`),
  KEY `FK_Relationship_7` (`ProductID`),
  KEY `FK_Relationship_8` (`AccountID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of productcard
-- ----------------------------
INSERT INTO `productcard` VALUES ('0909201220130001', '365', 'PRD0001', '1', '2016-06-29', 'FC4BBC2A374D');
INSERT INTO `productcard` VALUES ('0909201220130002', '365', 'PRD0001', '1', '2016-07-04', 'FC4BBC2B1AAE');
INSERT INTO `productcard` VALUES ('0909201220130003', '365', 'PRD0001', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130004', '183', 'PRD0001', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130005', '183', 'PRD0001', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130006', '183', 'PRD0001', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130007', '365', 'PRD0002', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130008', '365', 'PRD0002', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130009', '365', 'PRD0002', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130010', '183', 'PRD0002', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130011', '183', 'PRD0002', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130012', '183', 'PRD0002', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130013', '365', 'PRD0003', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130014', '365', 'PRD0003', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130015', '365', 'PRD0003', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130016', '183', 'PRD0003', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130017', '183', 'PRD0003', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130018', '183', 'PRD0003', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130019', '365', 'PRD0004', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130020', '365', 'PRD0004', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130021', '365', 'PRD0004', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130022', '183', 'PRD0004', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130023', '183', 'PRD0004', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130024', '183', 'PRD0004', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130025', '365', 'PRD0005', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130026', '365', 'PRD0005', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130027', '365', 'PRD0005', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130028', '183', 'PRD0005', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130029', '183', 'PRD0005', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130030', '183', 'PRD0005', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130031', '365', 'PRD0006', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130032', '365', 'PRD0006', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130033', '365', 'PRD0006', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130034', '183', 'PRD0006', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130035', '183', 'PRD0006', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130036', '183', 'PRD0006', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130037', '365', 'PRD0007', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130038', '365', 'PRD0007', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130039', '365', 'PRD0007', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130040', '183', 'PRD0007', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130041', '183', 'PRD0007', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130042', '183', 'PRD0007', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130043', '365', 'PRD0008', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130044', '365', 'PRD0008', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130045', '365', 'PRD0008', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130046', '183', 'PRD0008', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130047', '183', 'PRD0008', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130048', '183', 'PRD0008', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130049', '365', 'PRD0009', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130050', '365', 'PRD0009', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130051', '365', 'PRD0009', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130052', '183', 'PRD0009', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130053', '183', 'PRD0009', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130054', '183', 'PRD0009', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130055', '365', 'PRD0010', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130056', '365', 'PRD0010', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130057', '365', 'PRD0010', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130058', '183', 'PRD0010', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130059', '183', 'PRD0010', '0', '3000-01-01', '');
INSERT INTO `productcard` VALUES ('0909201220130060', '183', 'PRD0010', '0', '3000-01-01', '');



-- ----------------------------
-- Table structure for serviec_type
-- ----------------------------
DROP TABLE IF EXISTS `serviec_type`;
CREATE TABLE `serviec_type` (
  `SERVICE_ID` int(2) NOT NULL,
  `SERVICE_NAME` varchar(30) NOT NULL,
  `SERVICE_DAY` int(10) NOT NULL,
  PRIMARY KEY (`SERVICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of serviec_type
-- ----------------------------
INSERT INTO `serviec_type` VALUES ('1', '免费试用', '1');
INSERT INTO `serviec_type` VALUES ('2', '快乐15', '15');
INSERT INTO `serviec_type` VALUES ('3', '包月', '30');
INSERT INTO `serviec_type` VALUES ('4', '包年', '365');

-- ----------------------------
-- Table structure for stb
-- ----------------------------
DROP TABLE IF EXISTS `stb`;
CREATE TABLE `stb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sn` varchar(45) NOT NULL,
  `enddate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stb
-- ----------------------------
INSERT INTO `stb` VALUES ('1', '11820002DE1D', '2016-06-25 00:00:00');
INSERT INTO `stb` VALUES ('2', 'FC4BBC2B9CA1', '2017-06-28 00:00:00');
INSERT INTO `stb` VALUES ('3', 'FC4BBC2A374D', '2016-07-01 00:00:00');
INSERT INTO `stb` VALUES ('4', 'FC4BBC2B7C4A', '2016-03-07 00:00:00');
INSERT INTO `stb` VALUES ('5', '1234', '2016-07-01 00:00:00');

-- ----------------------------
-- Table structure for stbbind
-- ----------------------------
DROP TABLE IF EXISTS `stbbind`;
CREATE TABLE `stbbind` (
  `ProductID` varchar(20) NOT NULL,
  `AccountID` varchar(20) NOT NULL,
  `BindDay` int(11) NOT NULL,
  `IsActive` int(11) NOT NULL,
  `ActiveDate` date NOT NULL,
  PRIMARY KEY (`ProductID`,`AccountID`),
  KEY `FK_stbbind2` (`AccountID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of stbbind
-- ----------------------------
INSERT INTO `stbbind` VALUES ('PRD0001', 'FC4BBC2A3917', '365', '1', '2016-07-03');
INSERT INTO `stbbind` VALUES ('PRD0001', 'FC4BBC2B7C4A', '365', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0001', 'FC4BBC2C9B58', '183', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0001', 'FC4BBC2CABB2', '365', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0001', 'FC4BBC2CC6FD', '365', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0001', 'FC4BBC2CC899', '365', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0002', 'FC4BBC2B1AAE', '183', '1', '2016-07-04');
INSERT INTO `stbbind` VALUES ('PRD0002', 'FC4BBC2C98E4', '183', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0003', 'FC4BBC2B7C4A', '365', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0003', 'FC4BBC2B9910', '365', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0003', 'FC4BBC2CC6FD', '365', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0004', 'FC4BBC2B1AAE', '183', '1', '2016-07-04');
INSERT INTO `stbbind` VALUES ('PRD0005', 'FC4BBC2B7C4A', '365', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0005', 'FC4BBC2B903A', '183', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0005', 'FC4BBC2C98E4', '183', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0006', 'FC4BBC2B1AAE', '183', '1', '2016-07-04');
INSERT INTO `stbbind` VALUES ('PRD0006', 'FC4BBC2B9910', '365', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0006', 'FC4BBC2C9519', '365', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0006', 'FC4BBC2C9B58', '183', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0007', 'FC4BBC2B9910', '365', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0008', 'FC4BBC2C9519', '365', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0009', 'FC4BBC2B903A', '183', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0009', 'FC4BBC2C98E4', '183', '0', '3000-01-01');
INSERT INTO `stbbind` VALUES ('PRD0010', 'FC4BBC2B903A', '183', '0', '3000-01-01');

-- ----------------------------
-- Table structure for sub_media_source
-- ----------------------------
DROP TABLE IF EXISTS `sub_media_source`;
CREATE TABLE `sub_media_source` (
  `MEDIA_ID` int(5) NOT NULL,
  `MEDIA_URL` varchar(255) NOT NULL,
  `ORDER1` int(3) NOT NULL,
  PRIMARY KEY (`MEDIA_ID`,`MEDIA_URL`),
  CONSTRAINT `pk_source` FOREIGN KEY (`MEDIA_ID`) REFERENCES `media_desc` (`MEDIA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of sub_media_source
-- ----------------------------
INSERT INTO `sub_media_source` VALUES ('4', 'tv.sohu.com/20180956.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('5', 'tv.sohu.com/20180957.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('5', 'tv.sohu.com/20180958.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('7', 'tv.sohu.com/20180960.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('8', 'tv.sohu.com/20180961.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('9', 'tv.sohu.com/20180962.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('10', 'tv.sohu.com/20180963.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('11', 'tv.sohu.com/20180964.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('12', 'tv.sohu.com/20180965.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('14', 'tv.sohu.com/20180969.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('15', 'tv.sohu.com/20180970.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('15', 'tv.sohu.com/20180971.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('15', 'tv.sohu.com/20180972.shtml', '3');
INSERT INTO `sub_media_source` VALUES ('16', 'tv.sohu.com/20180973.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('17', 'tv.sohu.com/20180974.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('18', 'tv.sohu.com/20180975.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('19', 'tv.sohu.com/20180976.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('20', 'tv.sohu.com/20180977.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('21', 'tv.sohu.com/20180978.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('22', 'tv.sohu.com/20180979.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('23', 'tv.sohu.com/20180980.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('24', 'tv.sohu.com/20180981.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('25', 'tv.sohu.com/20180982.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('26', 'tv.sohu.com/20180983.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('26', 'tv.sohu.com/20180984.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('26', 'tv.sohu.com/20180985.shtml', '3');
INSERT INTO `sub_media_source` VALUES ('27', 'tv.sohu.com/20180986.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('28', 'tv.sohu.com/20180987.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('29', 'tv.sohu.com/20180988.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('30', 'tv.sohu.com/20180989.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('31', 'tv.sohu.com/20180990.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('32', 'tv.sohu.com/20180991.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('33', 'tv.sohu.com/20180992.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('34', 'tv.sohu.com/20180993.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('35', 'tv.sohu.com/20180994.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('36', 'tv.sohu.com/20180995.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('37', 'tv.sohu.com/20180996.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('38', 'tv.sohu.com/20180997.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('39', 'tv.sohu.com/20180998.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('40', 'tv.sohu.com/20180999.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('41', 'tv.sohu.com/20181000.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('41', 'tv.sohu.com/20181001.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('41', 'tv.sohu.com/20181002.shtml', '3');
INSERT INTO `sub_media_source` VALUES ('41', 'tv.sohu.com/20181003.shtml', '4');
INSERT INTO `sub_media_source` VALUES ('41', 'tv.sohu.com/20181004.shtml', '5');
INSERT INTO `sub_media_source` VALUES ('41', 'tv.sohu.com/20181005.shtml', '6');
INSERT INTO `sub_media_source` VALUES ('41', 'tv.sohu.com/20181006.shtml', '7');
INSERT INTO `sub_media_source` VALUES ('41', 'tv.sohu.com/20181007.shtml', '8');
INSERT INTO `sub_media_source` VALUES ('41', 'tv.sohu.com/20181008.shtml', '9');
INSERT INTO `sub_media_source` VALUES ('41', 'tv.sohu.com/20181009.shtml', '10');
INSERT INTO `sub_media_source` VALUES ('42', 'tv.sohu.com/20181010.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('42', 'tv.sohu.com/20181011.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('42', 'tv.sohu.com/20181012.shtml', '3');
INSERT INTO `sub_media_source` VALUES ('42', 'tv.sohu.com/20181013.shtml', '4');
INSERT INTO `sub_media_source` VALUES ('42', 'tv.sohu.com/20181014.shtml', '5');
INSERT INTO `sub_media_source` VALUES ('42', 'tv.sohu.com/20181015.shtml', '6');
INSERT INTO `sub_media_source` VALUES ('42', 'tv.sohu.com/20181016.shtml', '7');
INSERT INTO `sub_media_source` VALUES ('42', 'tv.sohu.com/20181017.shtml', '8');
INSERT INTO `sub_media_source` VALUES ('42', 'tv.sohu.com/20181018.shtml', '9');
INSERT INTO `sub_media_source` VALUES ('42', 'tv.sohu.com/20181019.shtml', '10');
INSERT INTO `sub_media_source` VALUES ('43', 'tv.sohu.com/20181020.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('43', 'tv.sohu.com/20181021.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('43', 'tv.sohu.com/20181022.shtml', '3');
INSERT INTO `sub_media_source` VALUES ('43', 'tv.sohu.com/20181023.shtml', '4');
INSERT INTO `sub_media_source` VALUES ('43', 'tv.sohu.com/20181024.shtml', '5');
INSERT INTO `sub_media_source` VALUES ('44', 'tv.sohu.com/20181025.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('44', 'tv.sohu.com/20181026.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('44', 'tv.sohu.com/20181027.shtml', '3');
INSERT INTO `sub_media_source` VALUES ('44', 'tv.sohu.com/20181028.shtml', '4');
INSERT INTO `sub_media_source` VALUES ('44', 'tv.sohu.com/20181029.shtml', '5');
INSERT INTO `sub_media_source` VALUES ('45', 'tv.sohu.com/20181030.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('45', 'tv.sohu.com/20181031.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('45', 'tv.sohu.com/20181032.shtml', '3');
INSERT INTO `sub_media_source` VALUES ('45', 'tv.sohu.com/20181033.shtml', '4');
INSERT INTO `sub_media_source` VALUES ('45', 'tv.sohu.com/20181034.shtml', '5');
INSERT INTO `sub_media_source` VALUES ('46', 'tv.sohu.com/20181035.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('46', 'tv.sohu.com/20181036.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('46', 'tv.sohu.com/20181037.shtml', '3');
INSERT INTO `sub_media_source` VALUES ('46', 'tv.sohu.com/20181038.shtml', '4');
INSERT INTO `sub_media_source` VALUES ('46', 'tv.sohu.com/20181039.shtml', '5');
INSERT INTO `sub_media_source` VALUES ('47', 'tv.sohu.com/20181040.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('47', 'tv.sohu.com/20181041.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('47', 'tv.sohu.com/20181042.shtml', '3');
INSERT INTO `sub_media_source` VALUES ('47', 'tv.sohu.com/20181043.shtml', '4');
INSERT INTO `sub_media_source` VALUES ('47', 'tv.sohu.com/20181044.shtml', '5');
INSERT INTO `sub_media_source` VALUES ('48', 'tv.sohu.com/20181045.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('48', 'tv.sohu.com/20181046.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('48', 'tv.sohu.com/20181047.shtml', '3');
INSERT INTO `sub_media_source` VALUES ('48', 'tv.sohu.com/20181048.shtml', '4');
INSERT INTO `sub_media_source` VALUES ('48', 'tv.sohu.com/20181049.shtml', '5');
INSERT INTO `sub_media_source` VALUES ('49', 'tv.sohu.com/20181050.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('49', 'tv.sohu.com/20181051.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('49', 'tv.sohu.com/20181052.shtml', '3');
INSERT INTO `sub_media_source` VALUES ('49', 'tv.sohu.com/20181053.shtml', '4');
INSERT INTO `sub_media_source` VALUES ('49', 'tv.sohu.com/20181054.shtml', '5');
INSERT INTO `sub_media_source` VALUES ('50', 'tv.sohu.com/20181055.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('50', 'tv.sohu.com/20181056.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('50', 'tv.sohu.com/20181057.shtml', '3');
INSERT INTO `sub_media_source` VALUES ('50', 'tv.sohu.com/20181058.shtml', '4');
INSERT INTO `sub_media_source` VALUES ('50', 'tv.sohu.com/20181059.shtml', '5');
INSERT INTO `sub_media_source` VALUES ('51', 'tv.sohu.com/20181060.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('51', 'tv.sohu.com/20181061.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('51', 'tv.sohu.com/20181062.shtml', '3');
INSERT INTO `sub_media_source` VALUES ('51', 'tv.sohu.com/20181063.shtml', '4');
INSERT INTO `sub_media_source` VALUES ('51', 'tv.sohu.com/20181064.shtml', '5');
INSERT INTO `sub_media_source` VALUES ('52', 'tv.sohu.com/20181065.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('52', 'tv.sohu.com/20181066.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('52', 'tv.sohu.com/20181067.shtml', '3');
INSERT INTO `sub_media_source` VALUES ('52', 'tv.sohu.com/20181068.shtml', '4');
INSERT INTO `sub_media_source` VALUES ('52', 'tv.sohu.com/20181069.shtml', '5');
INSERT INTO `sub_media_source` VALUES ('53', 'tv.sohu.com/20181070.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('53', 'tv.sohu.com/20181071.shtml', '2');
INSERT INTO `sub_media_source` VALUES ('53', 'tv.sohu.com/20181072.shtml', '3');
INSERT INTO `sub_media_source` VALUES ('53', 'tv.sohu.com/20181073.shtml', '4');
INSERT INTO `sub_media_source` VALUES ('53', 'tv.sohu.com/20181074.shtml', '5');
INSERT INTO `sub_media_source` VALUES ('54', 'tv.sohu.com/20181075.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('55', 'tv.sohu.com/20181076.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('56', 'tv.sohu.com/20181077.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('57', 'tv.sohu.com/20181078.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('58', 'tv.sohu.com/20181079.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('59', 'tv.sohu.com/20181080.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('60', 'tv.sohu.com/20181081.shtml', '1');
INSERT INTO `sub_media_source` VALUES ('61', 'http://120.205.13.203:5000/nn_live.m3u8?id=cctv1h', '5');
INSERT INTO `sub_media_source` VALUES ('61', 'http://183.207.255.185/live/cctv1hd/workflow5/mnf.m3u8', '7');
INSERT INTO `sub_media_source` VALUES ('61', 'http://a.91kds.net/do/128.php?id=live591', '3');
INSERT INTO `sub_media_source` VALUES ('61', 'http://jxlive01.jx.ysten.com:8080/ysten-businessmobile/live/hdcctv01/1237322.m3u8', '6');
INSERT INTO `sub_media_source` VALUES ('61', 'http://m.cztv.com/api/hls/livev6.m3u8.php?id=ingstr-10-1&rate=a?key=tziM6zoAkhQ=&data=QC8L', '2');
INSERT INTO `sub_media_source` VALUES ('61', 'http://myott.sinaapp.com/TV_Proxy/letvprogram.php?VideoId=cctv1', '4');
INSERT INTO `sub_media_source` VALUES ('61', 'http://myott.sinaapp.com/TV_Proxy/taobao.php?VideoId=1ctv1', '1');
INSERT INTO `sub_media_source` VALUES ('62', 'http://218.24.47.46/CCTV2.m3u8', '2');
INSERT INTO `sub_media_source` VALUES ('62', 'http://vapptime.cntv.wscdns.com/cache/204_/seg0/index.m3u8', '3');
INSERT INTO `sub_media_source` VALUES ('62', 'http://vtime.cntv.wscdns.com/cache/204_/seg0/index.m3u8', '1');
INSERT INTO `sub_media_source` VALUES ('63', 'http://his.cdn.brtn.cn/approve/live?channel=CCTV3&type=iptv', '2');
INSERT INTO `sub_media_source` VALUES ('63', 'http://myott.sinaapp.com/TV_Proxy/letvprogram.php?VideoId=cctv3', '3');
INSERT INTO `sub_media_source` VALUES ('63', 'http://vtime.cntv.wscdns.com/cache/209_/seg0/index.m3u8', '1');
INSERT INTO `sub_media_source` VALUES ('64', 'http://myott.sinaapp.com/TV_Proxy/letvprogram.php?VideoId=cctv4', '2');
INSERT INTO `sub_media_source` VALUES ('64', 'http://his.cdn.brtn.cn/approve/live?channel=CCTV4&type=iptv', '1');
INSERT INTO `sub_media_source` VALUES ('65', 'http://his.cdn.brtn.cn/approve/live?channel=CCTV4&type=iptv', '1');
INSERT INTO `sub_media_source` VALUES ('65', 'http://myott.sinaapp.com/TV_Proxy/letvprogram.php?VideoId=cctv5_1800', '2');
INSERT INTO `sub_media_source` VALUES ('66', 'http://his.cdn.brtn.cn/approve/live?channel=CCTV6&type=iptv', '1');
INSERT INTO `sub_media_source` VALUES ('66', 'http://myott.sinaapp.com/TV_Proxy/letvprogram.php?VideoId=cctv6', '2');
INSERT INTO `sub_media_source` VALUES ('67', 'http://api.digomate.com/index.php/tv/source?key=Jr3J6azYVihQ', '1');
INSERT INTO `sub_media_source` VALUES ('67', 'http://myott.sinaapp.com/TV_Proxy/taobao.php?VideoId=1hnws', '2');
INSERT INTO `sub_media_source` VALUES ('68', 'http://hls.yy.com/live/46645489_2196889728.m3u8', '1');
INSERT INTO `sub_media_source` VALUES ('68', 'http://m.cztv.com/api/hls/livev6.m3u8.php?id=ingstr-9-1&rate=a?key=CLpy1IvLD7U=&data=kvx90hBl', '2');
INSERT INTO `sub_media_source` VALUES ('69', 'http://m.cztv.com/api/hls/livev6.m3u8.php?id=ingstr-9-1&rate=a?key=CLpy1IvLD7U=&data=kvx90hBl', '1');
INSERT INTO `sub_media_source` VALUES ('69', 'http://r1.cztv.com/channels/101/500.flv/live', '2');
INSERT INTO `sub_media_source` VALUES ('70', 'http://live-cdn1.smgbb.tv/channels/bbtv/dfws/flv:sd/live.flv', '2');
INSERT INTO `sub_media_source` VALUES ('70', 'http://r1.cztv.com/channels/101/500.flv/live', '1');
INSERT INTO `sub_media_source` VALUES ('71', 'http://124.70.0.102/ldp/tianjin3.isml/QualityLevels(264000)/manifest(format=m3u8-aapl).m3u8', '1');
INSERT INTO `sub_media_source` VALUES ('72', 'http://124.70.0.102/ldp/tianjin4.isml/QualityLevels(264000)/manifest(format=m3u8-aapl).m3u8', '1');
INSERT INTO `sub_media_source` VALUES ('73', 'http://124.70.0.102/ldp/tianjin5.isml/QualityLevels(264000)/manifest(format=m3u8-aapl).m3u8', '1');
INSERT INTO `sub_media_source` VALUES ('74', 'http://ts.3gv.ifeng.com/live/iphone/zwt/index_multi.m3u8', '1');
INSERT INTO `sub_media_source` VALUES ('75', 'rtmp://live.hkstv.hk.lxdns.com/live/hks', '1');
INSERT INTO `sub_media_source` VALUES ('76', 'http://localhost:8080/IPTVM/premediabatchupload.action', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `pwd` varchar(32) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `batch` int(5) DEFAULT NULL,
  `comment` varchar(50) DEFAULT NULL,
  `rest_day` int(5) DEFAULT NULL,
  `group_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '郑悦', '1', '18', '13682076219', '天津市南开区学府街', '1', '1', '2', null, '22', null);
INSERT INTO `user` VALUES ('2', '夏冬', '2', '101', '13682076219', '天津市南开区临潼道', '1', '1', '2', '增值业务潜在客户', '22', null);
INSERT INTO `user` VALUES ('3', '春秋', '3', '102', '13682076219', '天津市南开区广开三马路', '1', '1', '1', null, '22', null);
INSERT INTO `user` VALUES ('4', '李艳', '4', '103', '13682076219', '天津市南开区咸阳路', '1', '1', '1', '增值业务潜在客户', '22', null);
INSERT INTO `user` VALUES ('5', '薛伟', '5', '104', '13682076219', '天津市南开区南泥湾路', '1', '2', '1', null, '22', null);
INSERT INTO `user` VALUES ('6', '李国宾', '6', '105', '13682076219', '天津市南开区汉中里', '1', '1', '1', null, '22', null);
INSERT INTO `user` VALUES ('7', '鲁瑞英', '7', '106', '13682076219', '天津市南开区碧园里', '1', '2', '1', '增值业务潜在客户', '22', null);
INSERT INTO `user` VALUES ('8', '牛檀', '8', '107', '13682076219', '天津市南开区延长里', '1', '1', '1', null, '22', null);
INSERT INTO `user` VALUES ('9', '陈宝庆', '9', '108', '13682076219', '天津市南开区长江道', '1', '1', '1', '增值业务潜在客户', '22', null);
INSERT INTO `user` VALUES ('10', '潘宝', '10', '109', '13682076219', '天津市南开区黄河道', '1', '2', '1', null, '22', null);
INSERT INTO `user` VALUES ('11', '华瑞林', '11', '110', '13682076219', '天津市河西区黑牛城道', '1', '2', '1', null, '22', null);
INSERT INTO `user` VALUES ('12', '柳国治', '12', '111', '13682076219', '天津市河西区珠江道', '1', '2', '1', '增值业务潜在客户', '22', null);
INSERT INTO `user` VALUES ('13', '李亚琼', '13', '112', '13682076219', '天津市河西区三水道', '1', '2', '1', null, '22', null);
INSERT INTO `user` VALUES ('14', '罗治平', '14', '113', '13682076219', '天津河西区洞庭路', '1', '2', '1', null, '22', null);
INSERT INTO `user` VALUES ('15', '刘燕', '15', '114', '13682076219', '天津市和平区南京路', '1', '2', '1', '增值业务潜在客户', '22', null);
INSERT INTO `user` VALUES ('16', '姜静', '16', '115', '13682076219', '天津和平区福安大街', '1', '1', '1', null, '22', null);
INSERT INTO `user` VALUES ('17', '王倩', '17', '116', '13682076219', '天津市红桥区勤俭道', '1', '1', '1', null, '22', null);
INSERT INTO `user` VALUES ('18', '方浩', '18', '117', '13682076219', '天津市红桥区复兴路', '1', '1', '1', '增值业务潜在客户', '22', null);
INSERT INTO `user` VALUES ('19', '刘开来', '19', '118', '13682076219', '天津市红桥区虹桥北路', '1', '2', '1', null, '22', null);
INSERT INTO `user` VALUES ('20', '赵国增', '20', '119', '13682076219', '天津市红桥区光荣北路', '1', '1', '2', null, '22', null);
INSERT INTO `user` VALUES ('21', '金易增', '21', '120', '13682076219', '天津市河西区珠江道', '2', '2', '2', null, '23', null);
INSERT INTO `user` VALUES ('22', '韩立', 'tj123', '32', '1382076215', '天津市南开区', '1', '1', '6', '批量办理', '22', null);
INSERT INTO `user` VALUES ('23', '元瑶', 'tj123', '35', '1362086325', '天津市和平区', '2', '1', '6', '批量办理', '23', null);
INSERT INTO `user` VALUES ('24', '重龙', 'tj123', '36', '1395085254', '天津市河西区', '1', '2', '6', '批量办理', '22', null);
INSERT INTO `user` VALUES ('25', '韩立', 'tj123', '32', '1382076215', '天津市南开区', '1', '1', '6', '批量办理', '22', null);
INSERT INTO `user` VALUES ('26', '元瑶', 'tj123', '35', '1362086325', '天津市和平区', '2', '1', '6', '批量办理', '23', null);
INSERT INTO `user` VALUES ('27', '重龙', 'tj123', '36', '1395085254', '天津市河西区', '1', '2', '6', '批量办理', '22', null);
INSERT INTO `user` VALUES ('28', '韩立', 'tj123', '32', '1382076215', '天津市南开区', '1', '1', '6', '批量办理', '99', null);
INSERT INTO `user` VALUES ('29', '元瑶', 'tj123', '35', '1362086325', '天津市和平区', '2', '1', '6', '批量办理', '120', null);
INSERT INTO `user` VALUES ('30', '重龙', 'tj123', '36', '1395085254', '天津市河西区', '1', '2', '6', '批量办理', '149', null);
INSERT INTO `user` VALUES ('31', '韩立', 'tj123', '32', '1382076215', '天津市南开区', '1', '1', '6', '批量办理', '99', null);
INSERT INTO `user` VALUES ('32', '元瑶', 'tj123', '35', '1362086325', '天津市和平区', '2', '1', '6', '批量办理', '120', null);
INSERT INTO `user` VALUES ('33', '重龙', 'tj123', '36', '1395085254', '天津市河西区', '1', '2', '6', '批量办理', '149', null);
INSERT INTO `user` VALUES ('34', '韩立', 'tj123', '32', '1382076215', '天津市南开区', '1', '1', '6', '批量办理', '99', null);
INSERT INTO `user` VALUES ('35', '元瑶', 'tj123', '35', '1362086325', '天津市和平区', '2', '1', '6', '批量办理', '120', null);
INSERT INTO `user` VALUES ('36', '重龙', 'tj123', '36', '1395085254', '天津市河西区', '1', '2', '6', '批量办理', '149', null);

-- ----------------------------
-- Table structure for user_product
-- ----------------------------
DROP TABLE IF EXISTS `user_product`;
CREATE TABLE `user_product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `prod_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_product
-- ----------------------------

-- ----------------------------
-- Procedure structure for delete_expired_product
-- ----------------------------
DROP PROCEDURE IF EXISTS `delete_expired_product`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_expired_product`()
BEGIN
	#Routine body goes here...
	DELETE FROM account_product WHERE EndDate=CURDATE();
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insert_channel
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_channel`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_channel`(IN `ChannelName` varchar(20),IN `ChannelIP` varchar(30),IN `ChannelPic` varchar(50),IN `ChannelUrl` varchar(50),IN `UrlType` varchar(20),IN `ChannelType` varchar(10),IN `LanguageID` varchar(20),IN `ProductID` varchar(20))
BEGIN
	#Routine body goes here...
	SELECT @cid:=ChannelID FROM ids WHERE ID=1;
	SET @cid=@cid+1;
	SET @ChannelID='Chan';
	SET @ChannelID=CONCAT(@ChannelID,FLOOR(@cid/1000));
	SELECT @ChannelID;
	SET @cid=@cid%1000;
	SET @ChannelID=CONCAT(@ChannelID,FLOOR(@cid/100));
	SELECT @ChannelID;
	SET @cid=@cid%100;
	SET @ChannelID=CONCAT(@ChannelID,FLOOR(@cid/10));
	SELECT @ChannelID;
	SET @cid=@cid%10;
	SET @ChannelID=CONCAT(@ChannelID,FLOOR(@cid/1));
	SELECT @ChannelID;
	INSERT INTO channelset VALUES (@ChannelID,ChannelName,ChannelIP,ChannelPic,ChannelUrl,UrlType,ChannelType,LanguageID,ProductID);
	IF (ROW_COUNT()>0) THEN
		UPDATE ids SET ChannelID=ChannelID+1 WHERE ID=1;
	END IF;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insert_language
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_language`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_language`(IN `LanguageName` varchar(20))
BEGIN
	#Routine body goes here...
	SELECT @lid:=LanguageID FROM ids WHERE ID=1;
	SET @lid=@lid+1;
	SET @LanguageID='Lang';
	SET @LanguageID=CONCAT(@LanguageID,FLOOR(@lid/1000));
	SELECT @LanguageID;
	SET @lid=@lid%1000;
	SET @LanguageID=CONCAT(@LanguageID,FLOOR(@lid/100));
	SELECT @LanguageID;
	SET @lid=@lid%100;
	SET @LanguageID=CONCAT(@LanguageID,FLOOR(@lid/10));
	SELECT @LanguageID;
	SET @lid=@lid%10;
	SET @LanguageID=CONCAT(@LanguageID,FLOOR(@lid/1));
	SELECT @LanguageID;
	INSERT INTO languageset VALUES (@LanguageID,LanguageName);
	IF (ROW_COUNT()>0) THEN
		UPDATE ids SET LanguageID=LanguageID+1 WHERE ID=1;
	END IF;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insert_product
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_product`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_product`(IN `ProductName` varchar(20))
BEGIN
	#Routine body goes here...
	SELECT @pid:=ProductID FROM ids WHERE ID=1;
	SET @pid=@pid+1;
	SET @ProductID='PRD';
	SET @ProductID=CONCAT(@ProductID,FLOOR(@pid/1000));
	SELECT @ProductID;
	SET @pid=@pid%1000;
	SET @ProductID=CONCAT(@ProductID,FLOOR(@pid/100));
	SELECT @ProductID;
	SET @pid=@pid%100;
	SET @ProductID=CONCAT(@ProductID,FLOOR(@pid/10));
	SELECT @ProductID;
	SET @pid=@pid%10;
	SET @ProductID=CONCAT(@ProductID,FLOOR(@pid/1));
	SELECT @ProductID;
	INSERT INTO productset VALUES (@ProductID,ProductName);
	IF (ROW_COUNT()>0) THEN
		UPDATE ids SET ProductID=ProductID+1 WHERE ID=1;
	END IF;
END
;;
DELIMITER ;

-- ----------------------------
-- Event structure for delete_expired_product
-- ----------------------------
DROP EVENT IF EXISTS `delete_expired_product`;
DELIMITER ;;
CREATE EVENT `delete_expired_product` ON SCHEDULE EVERY 1 DAY STARTS '2016-06-29 23:00:00' ON COMPLETION NOT PRESERVE ENABLE DO CALL delete_expired_product()
;;
DELIMITER ;