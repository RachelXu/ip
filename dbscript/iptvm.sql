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
  CONSTRAINT `FK_acc_pro_1` FOREIGN KEY (`AccountID`) REFERENCES `account` (`AccountID`) ON DELETE CASCADE ON UPDATE CASCADE,
  KEY `FK_acc_pro_2` (`ProductID`),
  CONSTRAINT `FK_acc_pro_2` FOREIGN KEY (`ProductID`) REFERENCES `productset` (`ProductID`) ON DELETE CASCADE ON UPDATE CASCADE
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
  CONSTRAINT `FK_channelset_1` FOREIGN KEY (`ProductID`) REFERENCES `productset` (`ProductID`)  ON DELETE SET NULL ON UPDATE SET NULL,  
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
-- Table structure for directory
-- ----------------------------
DROP TABLE IF EXISTS `directory`;
CREATE TABLE `directory` (
  `DirectoryID` varchar(20) NOT NULL,
  `ParentID` varchar(20) NOT NULL,
  `DirectoryName` varchar(20) NOT NULL,  
  `Order1` int(3) NOT NULL,
  PRIMARY KEY (`DirectoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of directory
-- ----------------------------
INSERT INTO `directory` VALUES ('DIR0001', 'DIR0000', 'MiddleEastVIP',1);
INSERT INTO `directory` VALUES ('DIR0002', 'DIR0000', 'EgyptVIP',1);
INSERT INTO `directory` VALUES ('DIR0003', 'DIR0000', 'PalestineVIP',2);
INSERT INTO `directory` VALUES ('DIR0004', 'DIR0000', 'IsraelVIP',3);
INSERT INTO `directory` VALUES ('DIR0005', 'DIR0000', 'TurkeyVIP',4);
INSERT INTO `directory` VALUES ('DIR0006', 'DIR0000', 'IranVIP',5);
INSERT INTO `directory` VALUES ('DIR0007', 'DIR0000', 'AmericaLive',6);
INSERT INTO `directory` VALUES ('DIR0008', 'DIR0000', 'BrazilLive',7);
INSERT INTO `directory` VALUES ('DIR0009', 'DIR0000', 'EuropeLive',8);
INSERT INTO `directory` VALUES ('DIR0010', 'DIR0000', 'CanadaLive',9);
INSERT INTO `directory` VALUES ('DIR1001', 'DIR0001', 'Arabic',10);
INSERT INTO `directory` VALUES ('DIR1002', 'DIR0001', 'Tunisia',11);
INSERT INTO `directory` VALUES ('DIR1003', 'DIR0001', 'PreMium',12);
INSERT INTO `directory` VALUES ('DIR1004', 'DIR0001', 'Sports',13);
INSERT INTO `directory` VALUES ('DIR1005', 'DIR0001', 'Europe',14);
INSERT INTO `directory` VALUES ('DIR1006', 'DIR0001', 'French',15);
INSERT INTO `directory` VALUES ('DIR1007', 'DIR0001', 'Movies',16);
INSERT INTO `directory` VALUES ('DIR1008', 'DIR0001', 'KIDS',17);


-- ----------------------------
-- Table structure for channel_directory
-- ----------------------------
DROP TABLE IF EXISTS `channel_directory`;
CREATE TABLE `channel_directory` (
  `DirectoryID` varchar(20) NOT NULL,
  `ChannelID` varchar(20) NOT NULL,
  PRIMARY KEY (`DirectoryID`,`ChannelID`),
  KEY `FK_channel_directory2` (`ChannelID`)
  CONSTRAINT `FK_channel_directory2` FOREIGN KEY (`ChannelID`) REFERENCES `channelset` (`ChannelID`) ON DELETE CASCADE ON UPDATE CASCADE,
  KEY `FK_channel_directory1` (`DirectoryID`),
  CONSTRAINT `FK_channel_directory1` FOREIGN KEY (`DirectoryID`) REFERENCES `directory` (`DirectoryID`) ON DELETE CASCADE ON UPDATE CASCADE
  
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
INSERT INTO `area` VALUES ('1', '��½');
INSERT INTO `area` VALUES ('2', '����');
INSERT INTO `area` VALUES ('3', '�ձ�');
INSERT INTO `area` VALUES ('4', '����');
INSERT INTO `area` VALUES ('5', 'Ӣ��');
INSERT INTO `area` VALUES ('6', '���');
INSERT INTO `area` VALUES ('7', '̨��');
INSERT INTO `area` VALUES ('8', 'ӡ��');
INSERT INTO `area` VALUES ('9', '����');
INSERT INTO `area` VALUES ('10', '���ô�');
INSERT INTO `area` VALUES ('11', '������');
INSERT INTO `area` VALUES ('12', '�¼���');
INSERT INTO `area` VALUES ('13', '̩��');
INSERT INTO `area` VALUES ('14', '�����');
INSERT INTO `area` VALUES ('15', '�¹�');
INSERT INTO `area` VALUES ('16', '����˹');
INSERT INTO `area` VALUES ('17', 'Խ��');
INSERT INTO `area` VALUES ('18', '�Ĵ�����');

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
INSERT INTO `catalog` VALUES ('1', '��Ӱ', 'dianying', null, '9');
INSERT INTO `catalog` VALUES ('2', '���Ӿ�', 'dianshijv', null, '5');
INSERT INTO `catalog` VALUES ('3', '����', 'zongyi', null, '4');
INSERT INTO `catalog` VALUES ('4', '����', 'dongman', null, '3');
INSERT INTO `catalog` VALUES ('5', '��¼Ƭ', 'jilupian', null, '2');
INSERT INTO `catalog` VALUES ('6', '����', 'jiaoyu', null, '1');
INSERT INTO `catalog` VALUES ('7', '����', 'huayu', '1', '1');
INSERT INTO `catalog` VALUES ('8', '����', 'meiguo', '1', '2');
INSERT INTO `catalog` VALUES ('9', 'ŷ��', 'ouzhou', '1', '3');
INSERT INTO `catalog` VALUES ('10', '�ձ�', 'riben', '1', '4');
INSERT INTO `catalog` VALUES ('11', '����', 'hanguo', '1', '5');
INSERT INTO `catalog` VALUES ('12', '����', 'zuixin', '1', '6');
INSERT INTO `catalog` VALUES ('13', '����', 'aiqing', '7', '1');
INSERT INTO `catalog` VALUES ('14', '����', 'dongzuo', '7', '2');
INSERT INTO `catalog` VALUES ('15', 'ϲ��', 'xijv', '7', '3');
INSERT INTO `catalog` VALUES ('16', '�ƻ�', 'kehuan', '7', '4');
INSERT INTO `catalog` VALUES ('17', '����', 'fengyue', '7', '5');
INSERT INTO `catalog` VALUES ('18', '����', 'jvqing', '7', '6');
INSERT INTO `catalog` VALUES ('19', '����', 'jingfei', '7', '7');
INSERT INTO `catalog` VALUES ('20', '����', 'wuxia', '7', '8');
INSERT INTO `catalog` VALUES ('21', '����', 'aiqing', '8', '1');
INSERT INTO `catalog` VALUES ('22', '����', 'dongzuo', '8', '2');
INSERT INTO `catalog` VALUES ('23', 'ϲ��', 'xijv', '8', '3');
INSERT INTO `catalog` VALUES ('24', '�ƻ�', 'kehuan', '8', '4');
INSERT INTO `catalog` VALUES ('25', '�ֲ�', 'kongbu', '8', '5');
INSERT INTO `catalog` VALUES ('26', '����', 'jvqing', '8', '6');
INSERT INTO `catalog` VALUES ('27', '����', 'gewu', '8', '7');
INSERT INTO `catalog` VALUES ('28', 'ս��', 'zhanzheng', '8', '8');
INSERT INTO `catalog` VALUES ('29', '����', 'aiqing', '9', '1');
INSERT INTO `catalog` VALUES ('30', '����', 'dongzuo', '9', '2');
INSERT INTO `catalog` VALUES ('31', 'ϲ��', 'xijv', '9', '3');
INSERT INTO `catalog` VALUES ('32', '���', 'jingsong', '9', '4');
INSERT INTO `catalog` VALUES ('33', '����', 'jvqing', '9', '5');
INSERT INTO `catalog` VALUES ('34', '����', 'xuanyi', '9', '6');
INSERT INTO `catalog` VALUES ('35', '����', 'donghua', '9', '7');
INSERT INTO `catalog` VALUES ('36', '����', 'aiqing', '10', '1');
INSERT INTO `catalog` VALUES ('37', '����', 'dongzuo', '10', '2');
INSERT INTO `catalog` VALUES ('38', 'ϲ��', 'xijv', '10', '3');
INSERT INTO `catalog` VALUES ('39', '�ƻ�', 'kehuan', '10', '4');
INSERT INTO `catalog` VALUES ('40', '����', 'jvqing', '10', '5');
INSERT INTO `catalog` VALUES ('41', '����', 'xuanyi', '10', '6');
INSERT INTO `catalog` VALUES ('42', '����', 'donghua', '10', '7');
INSERT INTO `catalog` VALUES ('43', '����', 'aiqing', '11', '1');
INSERT INTO `catalog` VALUES ('44', '����', 'dongzuo', '11', '2');
INSERT INTO `catalog` VALUES ('45', 'ϲ��', 'xijv', '11', '3');
INSERT INTO `catalog` VALUES ('46', '�ƻ�', 'kehuan', '11', '4');
INSERT INTO `catalog` VALUES ('47', '����', 'jvqing', '11', '5');
INSERT INTO `catalog` VALUES ('48', '����', 'xuanyi', '11', '6');
INSERT INTO `catalog` VALUES ('49', '����', 'donghua', '11', '7');
INSERT INTO `catalog` VALUES ('50', '��������', 'guochandong', '4', '1');
INSERT INTO `catalog` VALUES ('51', '�ձ�����', 'ridonghua', '4', '2');
INSERT INTO `catalog` VALUES ('52', 'ŷ������', 'oudonghua', '4', '3');
INSERT INTO `catalog` VALUES ('53', 'У԰', 'xiaoyuan', '50', '1');
INSERT INTO `catalog` VALUES ('54', '��Ѫ', 'rexue', '50', '2');
INSERT INTO `catalog` VALUES ('55', 'ð��', 'maoxian', '50', '3');
INSERT INTO `catalog` VALUES ('56', '��ʷ', 'lishi', '50', '4');
INSERT INTO `catalog` VALUES ('57', '��Ц', 'gaoxiao', '50', '5');
INSERT INTO `catalog` VALUES ('58', '��ս', 'jizhan', '50', '6');
INSERT INTO `catalog` VALUES ('59', 'У԰', 'xiaoyuan', '51', '1');
INSERT INTO `catalog` VALUES ('60', '��Ѫ', 'rexue', '51', '2');
INSERT INTO `catalog` VALUES ('61', 'ð��', 'maoxian', '51', '3');
INSERT INTO `catalog` VALUES ('62', '��ʷ', 'lishi', '51', '4');
INSERT INTO `catalog` VALUES ('63', '��Ц', 'gaoxiao', '51', '5');
INSERT INTO `catalog` VALUES ('64', '��ս', 'jizhan', '51', '6');
INSERT INTO `catalog` VALUES ('65', 'У԰', 'xiaoyuan', '52', '1');
INSERT INTO `catalog` VALUES ('66', '��Ѫ', 'rexue', '52', '2');
INSERT INTO `catalog` VALUES ('67', 'ð��', 'maoxian', '52', '3');
INSERT INTO `catalog` VALUES ('68', '��ʷ', 'lishi', '52', '4');
INSERT INTO `catalog` VALUES ('69', '��Ц', 'gaoxiao', '52', '5');
INSERT INTO `catalog` VALUES ('70', '��ս', 'jizhan', '52', '6');
INSERT INTO `catalog` VALUES ('71', '����ѧ', 'xinlixue', '6', '1');
INSERT INTO `catalog` VALUES ('72', '���ѧ', 'shehuixue', '6', '2');
INSERT INTO `catalog` VALUES ('73', '�����', 'jisuanji', '6', '3');
INSERT INTO `catalog` VALUES ('74', '����', 'jinrong', '6', '4');
INSERT INTO `catalog` VALUES ('75', 'ֱ��', 'zhibo', null, '1');
INSERT INTO `catalog` VALUES ('76', '����̨', 'zhongyangtai', '75', '1');
INSERT INTO `catalog` VALUES ('77', '�ط�̨', 'difangtai', '75', '2');
INSERT INTO `catalog` VALUES ('78', '����Ƶ��', 'bendipindao', '75', '3');
INSERT INTO `catalog` VALUES ('79', '����Ƶ��', 'qitapindao', '75', '4');
INSERT INTO `catalog` VALUES ('80', '����', 'meijv', '2', '9');
INSERT INTO `catalog` VALUES ('81', '����', 'hanjv', '2', '8');
INSERT INTO `catalog` VALUES ('82', '�վ�', 'rijv', '2', '7');
INSERT INTO `catalog` VALUES ('83', '�۾�', 'gangjv', '2', '6');

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
INSERT INTO `iptvsoftware` VALUES ('1', '�޸������������Ӱ������˿ռ���ֹ��ͬʱ����������', '20121212', '1', '20150202', '1_iptv.zip');
INSERT INTO `iptvsoftware` VALUES ('2', '������ý���ļ����ͷ�����ʾ', '20140202', '2', '20150212', '2_iptv.zip');

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
INSERT INTO `language` VALUES ('1', '����');
INSERT INTO `language` VALUES ('2', 'Ӣ��');
INSERT INTO `language` VALUES ('3', '����');
INSERT INTO `language` VALUES ('4', '����');
INSERT INTO `language` VALUES ('5', '����');
INSERT INTO `language` VALUES ('6', 'ӡ����');
INSERT INTO `language` VALUES ('7', '����');
INSERT INTO `language` VALUES ('8', '��������');
INSERT INTO `language` VALUES ('9', '����');
INSERT INTO `language` VALUES ('10', '�������');
INSERT INTO `language` VALUES ('11', '����');

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
INSERT INTO `media_catalog` VALUES ('4', '��Ƥ2', 'huapi2', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('5', '�ǳ����� 1-2 �ϼ�', 'feichengwurao', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('7', '˫�Ǽ��м�', 'shuangzhongji', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('8', '��������', 'zhimingtishen', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('9', '�Ĵ�����', 'sidamingbu', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('10', '��ά��������', 'lastchancehavy', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('11', '˫��ŮЫ��', 'pointofreturn', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('12', '�����Ϸ', 'zuieyouxi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('14', '�ң�������˹̹', 'wofulanke', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('15', '���ν��', 'transformers', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('16', '��ѩ��Ե', 'bingxueqingyuan', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('17', '�����ĺ�', 'mingyangsihai', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('18', 'ңԶ����', 'yaoyuandeqiao', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('19', '�Ͷٽ���', 'baodunjiangjun', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('20', '��;��֮ս', 'zhongtudao', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('21', '���õ�ӰԺ', 'tiantangdianyingyuan', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('22', '�������������˵', 'xixilimeilichuanshuo', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('23', '�ﰺ�ڰ�', 'liangheibang', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('24', '������', 'banyuxing', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('25', '������˹��ս�ո�����', 'fangtuomasi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('26', '������˹�ϼ�', 'fangtuomasiheji', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('27', 'ʳ����', 'shirenlian', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('28', '��ɺ�����', 'qikehelita', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('29', '����', 'fushen', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('30', 'Ұ������', 'yemanruqin', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('31', '���������', 'chuanzhanghualuoke', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('32', '����', 'zhenzi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('33', '100�ο���', 'yibaicikuqi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('34', 'ʮ���̿�', 'shisancike', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('35', '���ݺ�ƽ', 'duanzanheping', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('36', '��Ѫ�ഺ', 'rexueqingchun', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('37', '����', 'dashu', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('38', '��������', 'hulang', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('39', 'С����ϼ����ռ�', 'xiaoqqlixianji', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('40', '��������', 'hanjiangguaiwu', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('41', '��������', 'sanguoyanyi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('42', '��«��', 'huluwa', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('43', 'ϲ�������̫��', 'xiyangyang', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('44', '������ʿ����', 'kaijiayongshi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('45', 'С�������ռ�', 'xiaoliyulixianji', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('46', '�ڽ�', 'heijiao', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('47', 'ȫ������', 'quanjinshu', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('48', '��ħ����', 'qvmoshaonian', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('49', 'һ�ﵱǧ', 'yiqidangqian', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('50', 'è������', 'maohelaoshu', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('51', 'а������', 'xieeliliang', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('52', '�Ϸ���԰', 'nanfangongyuan', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('53', 'TED�ݽ���', 'ted', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('54', '˹̹����ѧ���ſγ�: ��̷���', 'sitanfubiaocheng', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('55', 'Ү³�����Σ���ѧ������', 'zhexueyurenxing', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('56', 'Ү³��ѧ���ſγ̣���������', 'jinronglilun', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('57', 'Ү³��ѧ���ſγ̣������г�', 'jinrongshichang', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('58', '��ʡ��ѧԺ���ſγ̣��㷨����', 'suanfadaolun', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('59', '˹̹����ѧ���ſγ�: ��̷�ʽ', 'bianchengfanshi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('60', 'Ү³��ѧ���ſγ̣��ʱ����壺�ɹ���Σ����ĸ�', 'zibenzhuyi', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('61', 'CCTV-1', 'CCTV-1', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('62', 'CCTV-2', 'CCTV-2', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('63', 'CCTV-3', 'CCTV-3', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('64', 'CCTV-4', 'CCTV-4', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('65', 'CCTV-5', 'CCTV-5', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('66', 'CCTV-6', 'CCTV-6', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('67', '��������', 'HNTV', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('68', '��������', 'JSTV', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('69', '�㽭����', 'ZSTV', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('70', '��������', 'DFTV', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('71', '���Ӱ��', 'TJYS', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('72', '�����', 'TJDS', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('73', '�������', 'TJTY', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('74', '�������', 'FHTV', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('75', '�������', 'HKTV', '2014-03-22', 'http://sfdasfasf');
INSERT INTO `media_catalog` VALUES ('76', '������', 'lalala', null, null);
INSERT INTO `media_catalog` VALUES ('80', '������', '', null, null);
INSERT INTO `media_catalog` VALUES ('81', '����', 'Thor ', null, null);

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
INSERT INTO `media_desc` VALUES ('4', '��Ƥ2', '4', '1', '1', '20120808', '�ڶ���', '���� / ���ܷ� / ����', '����С Ψ����Ѹ �Σ������Υ��������򣬱��ⶳ�ں��������жȹ�������꣬ʹ�಻������������ǰ��������ߵ�СΨֻ������ѡ��Ҫô�����������ı���ץ��ȥ��Ҫô���һ �š��������ס��������������ˡ�СΨ�Ĵ�Ѱ��Ŀ�ֱ꣬��ż���ӻ鲢��һ�����ⱻ���ݵľ���������ޱ �Σ���СΨ�ܿ췢�֣�������һ�����ڲ�ͬ���ģ����ѱ���˵�����ȫ�������ڹ������ϡ�', '80', 'bcc91714.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('5', '�ǳ����� 1-2 �ϼ�', '5', '1', '1', '20120505', '��С��', '���� / ��� / ������ / ���� / �����u / ��ΰ ', '�����طܣ����� �Σ�����ŷ����������ն˻������ܹ�ƽ��ƽ�ؽ��������磬����Ͷ����200��Ӣ���߼����ߡ��ط�Ҳ��ʼ̤�����������·;��һ·Ц�����ϣ��������� Gay�ѣ��������������ͣ��ط����е��Ļ����䣬������������Ů����ЦЦ����� �Σ�ʱ�㿪�ż�ɽ����Է�˵�����⡣��θ�Ϊ���֣�ЦЦ�����и�֮�����ڿ����в�ͣ��������δ������Ӽ����˰��Ųų������طܼ���һ�档���ٴ����ټ��� ���˾���ط����������������ص����ܡ�', '85', 'bcc91715.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('7', '˫�Ǽ��м�', '7', '1', '1', '20120204', '�˰���', '�̺� / ���п� / ����� / �ڸ��', '�ڶĳ��ڡ�ɢ������С��ǧ������Ƿ�ºڵ��ϴ���Х��һֻ�֣�Ϊ�˱�ס��ֻ�֣������䲻���ѽ�һ����·�ԹԷ��ϡ���������Х���ҵ��ٰ�̽��������ƭ�ġ�ǧ��������Լ����ڼ�������������ġ�����ʯ����λ������ƭ��', '35', 'bcc91717.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('8', '��������', '8', '1', '1', '20121116', '����', '���� / κ���� / ��ʫ��', '��ƯŮ��Ӧ�ѣ����� �Σ����ŵ����ǵ����룬�����������￿�ܾ�����Ѱ����Ϸ�Ļ��ᡣ�����û�нӵ�Ϸ�������ڽӵ�ĳ������Ϸ֪ͨ�󣬸��渱��һͬ����ǰ���������������������Ϸ����Ϸ��������������׼����ȥ��ʱ�򣬳���ȴ������˹��ϡ�����֮�£�Ӧ��ֻ���ڽ�������һ����ҹ����ج�ξ��ѵ�Ӧ�ѷ� ���Լ���˯���б����һ����ָ�����ⲻ���Ǹ���ʼ��������ʧ���ٴα������������ɭ�ֲ��ķ���������������ͨ�����ҵİ��š����������ڲ���һ����Ӧ�ѳ��ú����Ůʬ��Ӧ���������⾫����ƵĻ��Ա���ȴ�����ֻ��������ֻ���ԾȲ������档һ�����Ķ��ǵ����������ɴ�չ��', '50', 'bcc91718.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('9', '�Ĵ�����', '9', '1', '1', '20120712', '�¼���', '֣�л� / ����� / �˳�', '���Ĵ��������ǹ���Ӱҵ�������ļƻ�����˾�ܹ��ʳ¼�������ִ����Ƭ�������Ĵ���������ԱҲ�Ѿ�ȷ������Ѫ�����顢���֡�׷�����˵İ����߷ֱ��ǵ˳�������ơ���������֣�л���', '60', 'bcc91719.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('10', '��ά��������', '10', '2', '2', '20080819', '�Ƕ������ս�˹', '������ˡ������� / ����������ɶ� ', '��ά�����뱾����һ����ɫ�ľ�ʿ�ָ��ټң�����ʵȴ������ŦԼһ�����ֹ��������������ı����ˣ��ϰ�����Ĺ����ܲ����⣬����н�����Ĵ��㣬ֻ�����������������ϣ��Ÿ����˵�����Ĺ�ά��һ�λ��ᣬǰ���ǲ����ٳ��κβ����ά����ȥ�׶زμӸ�����Զ��Ů���Ļ�������������ǰ�޸����е��������Ѷ�����˷��������ǿ���ЪϢ�������������˹�ά��', '80', 'bcc91720.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('11', '˫��ŮЫ��', '11', '2', '2', '19930202', '����������', '���ݡ�����޷���', '������ǹɱ������������̡�������ע���������壬��������ȥ������ʱ������֪�Լ���ʵ����Ѿ������������Ҫ�����������ͱ��뵣��������ɱ�֡�����һ����̥���ǵ�ѵ�����������µ����������ᣬ������������������塣��ͬʱ����Ҳ�����˰����������Ƶ��뷨��һ������Ѹ��չ��', '72', 'bcc91721.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('12', '�����Ϸ', '12', '2', '2', '20140218', 'Josh Stolb', 'Ross Natha / Ben Begley ', '���ǵ��ڡ������ɷ��е���4λ�����ѵܵ�ÿһ��ʧ�ص����ɶ��𣿻��ǿ���˿�ڡ��|����Ϸ���������ܱȵ��ǻ����������Լ�˧ը�˵�������˹�֣��������� Ӱ�����Ʊز����������ŶΣ��ǡ���4λ�����˵Ĵ��ɷ�������Ϳ�زμӲп���|����Ϸʱ���ֻ����ʲô���أ����������Ϸ���ݸ���ҿ���', '60', 'bcc91722.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('14', '�ң�������˹̹', '14', '2', '2', '20140114', '˹ͼ���ء��ȵ�', '���ס����˹��� / �����ȡ�˹��������˹', '���ң�������˹̹���롶��ʿ�����ˡ���League Of Extraordinary Gentlemen�����ƣ�Ҳ�ǰ�һȺ���������ڲ�ͬ������Ʒ��ľ������Ｏ�е���һ�����������ͬ���ǣ����ң�������˹̹���Ｏ�ϵ�ȫ���ǹ��', '73', 'bcc91724.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('15', '���ν��ϵ��', '15', '2', '2', '20070823', '���˶�����', 'ϣ�ǡ������� / ÷��������˹', '����������̹�������죨Megatron������ʼ����������Ϊ���һؿ���Ϊһ������������ע�����������ġ�����Դ����Allspark�����Գư����棬ֻ�������˵��򡣿�����ȴ�������뱱���󣬱�����ס��1897�꣬�������¡�ά��ά�洬����Archibald Witwicky���������Ĵ�Ա���뱱���󣬲���׹����������������졣', '99', 'bcc91725.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('16', '��ѩ��Ե', '16', '2', '2', '20131117', '����˹���Ϳ� / ղ�ݸ�����', '����˹͡������ / ����ɭ�����޷�', '���½���һ���϶�����������������ѩ�����ø��ǣ��ֹ���η�İ��ȣ�����˹͡���������������Ȱ�ð�յ�ɽ�����˹�з�����ɭ�����޷��������Լ�����ѱ¹���ӳ�����չ��һ��ħ���������ó̷��·ת�Ĵ�ð�գ���Ѱ�Ұ��ȵĽ�㡪����ѩ�ʺ�ɯ�������ȡ���������������ƽ����ı���ħ�䡣һ·������������Ц������ѩ�ˡ���ʽ��þ��顢���벻����ħ�����󣬸���ѩ�������в������ġ������������ܷ�����������', '90', 'bcc91726.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('17', '�����ĺ�', '17', '2', '2', '20091223', '���ġ��Ʋ��޶�', '�������ȱ��� / ��ͼ��Ͷ�', '��ŦԼ��������������ۼ���һȺ�ڳ��衢�赸�ͱ����ϼ����츳������ѧ��������Ҫ���������4���ѧϰ���ڱ�ҵ֮�����Ǿ�ҪΪ�Լ���������ܶ������Ǳ���̽����һ�ٳ��������ǲμ�ѡ���Ŀժ��ͷ��������֮��ÿ���˶����Լ��ķܶ�Ŀ�ꡢÿ���˶����Լ����ռ����롣', '95', 'bcc91727.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('18', 'ңԶ����', '18', '2', '2', '19770615', '���¡���������', 'ղķ˹������ / ���˶�������', 'ŷսβ�����˾��������������ֹ۵�������Ϊ����ǰ����ս���������˾�������ΪֻҪһ���͹����������ֱ�����ֽ���ս�����������ʵؽ�����ɡ����Ͷ�ڵ¾�Ӫ�ر���ȥ��ռ����ķ�������������ӵĴ��š����������¾�����ǿ�ֿ����˾��������������صĴ��ۡ��ⳡ���ƶ�ս�����Ϸ���Ե�ս�ۣ������˾��Ĳ�ʹʧ�ܶ����ա�', '98', 'bcc91728.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('19', '�Ͷٽ���', '19', '2', '2', '19770718', '�������֡�ɳ����', '���Ρ�C��˹���� / ������Ī���� ', '1943��3�£��Ͷ��������ڷ���Ħ����½����Σ���������������ڱ��ǵĵڶ����ų����Ը�ǿ�ơ�����ŵ��Ļ�������սʷ�������ת���İͶٺܿ�����Ѫ����Ťת�˱��ǲ��ӵ�ɢ�����������ս�����ɸ�����ͳ�ʵ�Ӣ����������ɳĮ֮����¡�����ϳ��˱��ǡ�', '97', 'bcc91729.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('20', '��;��֮ս', '20', '2', '2', '19760618', '�ܿˡ�˹����', '����ǡ���˹�� / ���ס����� ', '��ʮ�����Ʒ�Ĵ���ս��Ƭ֮һ���������������ձ��������ݵ���;��ս�ۡ��ڵ����һ��ͬ���Ӱ֮�У���Ƭ������ͻ��֮�������ݽܿˣ�˹���صĴ����ַ���ԱȽ�ƽӹ����������������ȴ���������Ĺ����ض���һ�����Ƿ�ɣ�����ս�ĳ���Ҳʵ���ĵñ��棬ʹ��Ƭ��ά�����൱��Ȥζ�ԡ�', '98', 'bcc91730.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('21', '���õ�ӰԺ', '21', '14', '10', '19881118', '�����塤���ɶ���', '��������������ŷ / ��������������', '������ϲ�С�򣬹��龫�ֵ�С�к�����ڽ�Ƭ���ҵ���ͯ���������Ȥ��', '99', 'bcc91731.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('22', '�������������˵', '22', '14', '10', '20001027', '�����塤���ɶ���', 'Ī�ݿ�����³�� / �����塤�ն�����', '1941�꣬�������綼�������ڶ�ս������֮�У��������ﵺ����һƬ���ͣ����������к������еļ��硣��������13��ĺ���һ�������桢���֡������֣�������������롣������һ����������Զ�ı��������Ů�ˡ���÷���ȡ�', '99', 'bcc91732.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('23', '�ﰺ�ڰ�', '23', '9', '7', '20140114', '����ά�������Ķ�', '�л������� / ������������', '�ɳ���ƶ��ļ�����Ӫ�صİ����ɡ�ά���������Ħ�ţ�������һ�ݶԼ�ͥ�����θУ������ҳ��뽾���������ǣ�������͵�Զ�������ɪ�桤���ض���Ȼ������ ���ꡣ�����޿ɱ���ľ��뵽������֯������ʮ������˰����е���ٶ�����׿��������׳��ķ˰���70������ڵ��Զ��ơ�', '80', 'bcc91733.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('24', '������', '24', '9', '7', '20130527', '��Ӣ��', '��ʲ��������', '��ɼ����������ڰ참�в������裬�ﷸ��Ѫ������ϲ��֫����ˡ��������������ˣ��Խ��һ��������ĵ�������Ӱ�����ȸ�ְ��3���һλ�й�����ί�п������æѰ��ʧ �ٶ���ʦ�Σ�ľ������ Takuya Kimura �Σ�����������ۣ��Ӵ������Ǻ������ӣ������� Shawn Yue �Σ����������Ǿ��졣', '76', 'bcc91734.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('25', '������˹��ս�ո�����', '25', '9', '7', '19700316', '��������ᱴ��', '·�ס��¡�����˹ / �á����� / �����ȡ����ɼ���', '�����������Ĵ��������˹�ٰ����ʦ������л���ʿ�ң���������еĸ���Ҫ������ͱ����������Ȩ��˰�����������Լ������С�������������������л���ʿ��ȻҪ�׵���壬ֻҪ���Ͻ�Ǯ������������Ȼ��Ч�¡�������˹�뿪ǰ�޶��˽�Ǯ�����ڣ���л���ʿֻ���򾯷�Ѱ�������', '68', 'bcc91735.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('26', '������˹�ϼ�', '26', '9', '7', '19641107', '��������ᱴ��', '·�ס��¡�����˹ / �á����� / �����ȡ����ɼ���', '�����������Ĵ��������˹�ٰ����ʦ������л���ʿ�ң���������еĸ���Ҫ������ͱ����������Ȩ��˰�����������Լ������С�������������������л���ʿ��ȻҪ�׵���壬ֻҪ���Ͻ�Ǯ������������Ȼ��Ч�¡�������˹�뿪ǰ�޶��˽�Ǯ�����ڣ���л���ʿֻ���򾯷�Ѱ�������', '70', 'bcc91736.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('27', 'ʳ����', '27', '11', '8', '20131113', '��Ŧ������������', '������¡�����������', '��Ӫ�÷��Ŀ���˹�������ţ���������������һ���������ʵ�С��ÿ��ֻ�ǲü��������ʳ������·�������ȫ��Ե�����죬����˹���ڵĹ�Ԣ����һλ��������ɺ���� ��Olimpia Melinte �Σ��Ľ�����Ů�ӡ�', '76', 'bcc91737.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('28', '��ɺ�����', '28', '11', '8', '20101119', 'Tono Errando ', 'Limara Meneses', '���·�����1948��ĹŰͣ�һ��żȻ�У�����ʦ��ɽ�ʶ����������������Ů�ӣ���������ĸ�����������ɵ�ע�⣬������ϧ����������ײ���˰���Ļ𻨡�', '65', 'bcc91738.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('29', '����', '29', '10', '2', '20130527', '��ɭ����������', '���ȸǶ�������˹�� / ������������', 'ӰƬ��Ҫ�����ɰ��ȼ���������˹�����ݵ�Ů����ɯ���ǲ����ػ�1985���ĳ�죬ͬʱ����������һϵ�о���¼�Ҳ�ƶ���������ȥ�⿪������š���Ϊʲô�Լ�ѭ�������ػص������ֵ�����', '85', 'bcc91739.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('30', 'Ұ������', '30', '10', '2', '20101013', '����˹��������', '���ס�������', '�븸����ͬİ·������˹�ٰ���Ȼ�ӵ�ĸ��·��˿�ĵ绰���Ǹ��������Ե���ʷ���ڸ��������������ҽԺ��������ӡ�����˹�ٰ���һ����ԥ֮��ϻ������������㸸���߹����һ��ʱ �⡣����ĸ�Ĥ�Լ����ʽ�Ĳ�������Ը��Ӵ�һ��ʼ�ͳ��˸��췭�ظ���������˹�ٰ������뾡�취�ø���ƽ���������������ӡ�', '74', 'bcc91740.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('31', '���������', '31', '3', '3', '20131113', '������־', 'С��Ѯ / ���ִ���', '�����ɱ���ʿԭ�����������溣����������ˡ��ı� ���������Ѹߴ�3000����Ԫ���ձ�CG����Ƭ����������ˡ���2013��9���ձ���ӳ��������С��Ѯ�����ִ����Ծ��ŵȵ�����', '85', 'bcc91741.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('32', '����', '32', '3', '3', '20130525', 'Ӣ��', '����֯ / ������ʷ', '����ǰ�����ص�������Ƶ�������ģ�������������Թ����������¼���ɧ�����ڴ�֮���Ӵ��磨ʯԭ���� �Σ��밲��Т��������ʷ �Σ���Ϊ�򸾣������¿ɰ���Ů���M��ƽ���·· �Σ����ɱ��������ڲ��Ӻ󲻾���ȥ��Т�����ǽ�Ů���и����Ͷ��ٴ�����ѧ�����÷��ӣ�����֯ �Σ��������M�Ը��Ագ���Ը���κ��˽���������Ϊ���ĸз��գ�ȴ����Ŭ����СֶŮ��ͨ����������һ�����������ʧȥĸ�׵ĄM�������顣', '45', 'bcc91742.jpg', '1', null, null, null);
INSERT INTO `media_desc` VALUES ('33', '100�ο���', '33', '3', '3', '20100215', '��ľ¡һ', '������� / ͩ������ ', '��Ϊ����ǰ��Ħ�г��¹ʣ��پ���������壩�����������Խ�����ʧȥ�˳���ǰһ��ļ��䣬����������ʱ��Ů���Ѽ�����ͩ�����ᣩ�Ĵ��ڡ�', '87', 'bcc91743.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('34', 'ʮ���̿�', '34', '3', '3', '20100925', '���س�ʷ', '������˾ / ɽ��Т֮', '���ǽ���ʱ�����ڣ�ʱ����ʯ������֮���ϼ乬ͼ�飨��Ұ�}� �Σ���Ļ������������ͷ��ƽ�ֶ��� �Σ���լǰ��ɱ���˾�����Ұ�𶯡�һ�н�����ʯ�������ѣ��Rԫ���� �Σ���������ϵ���ν�������ĸ�ܵܣ�������Ѫ��������Ű�޳�������͢��������˵ȵĲ�����Ȼ�������ڶ���Ϊ�������С�Ϊ���������ݱ�����������⵺�� �������ţ�������˾ �Σ������ѻط�;�����Դ�ɱ��', '90', 'bcc91744.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('35', '���ݺ�ƽ', '35', '3', '3', '20131210', '���ѿ���', '���ɳ֯', '�����ݺ�ƽ�����ĸ���Ƭ���ɣ�������໥�������ڡ��ձ�����������£�����ʷ����ͳ�Ļ������Ļ���δ���Ȳ�ͬά�����������¡�', '99', 'bcc91745.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('36', '��Ѫ�ഺ', '36', '4', '4', '20140122', '������', '����˶ / �ӱ�Ӣ / ��Ӣ��', '����Ѫ�ഺ��������ʮ����������Ϻ��һ���ǳ�������Ů����졢��˵�Ļ������ӡ��������ϴ��׶�����תѧ�����ഺ��Ů����Ѫ����������¡�', '70', 'bcc91746.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('37', '����', '37', '4', '4', '20140805', '������', 'Ԫ�� / ������ / ����Ԫ', '���Ӳ���ȥ����ǰ����ҪԱ̩����Ԫ���Σ�����Ӫ��������Ϊ��������������ί�е���Ŀ��˺�ס�ڸ��ڵ�СŮ��С�ף��������Σ��������������������˽��������������в����˻����������������ķ����ߣ�������Щ��į���塣', '85', 'bcc91747.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('38', '��������', '38', '4', '4', '20130716', '�ᾼ��', '������ / ����Т / ������', '��˵�е�����Ůɱ�ַ�����������ǰ�ӵ�һ��лĻ���񡪡������ֽ񶥼���ǡ������С����͡�Ϊ�ˣ���Ǳ�������齵ľƵ꣬���ɹ����Ŀ������ڷ�����������֮�£������Դ�Ĵ��Ͳ��ò�����͵���������ѳ��Լ���ʵ��ɽկ���ִ��ܣ������Ա���', '71', 'bcc91748.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('39', 'С����ϼ����ռ�', '39', '4', '4', '20120222', '����M / ������', '���ӻ�', '�ڸ�ĸ����Ϣֹ�İ��£�С�ʵ����Pengi��Sommi�ӵ��������ѹ�����Pengi�ǳ����죬��ֱ�����ϼ�����С����һ�����෴���ɰ���Sommi ���ľ��ö࣬��ϲ�����ڰְֵĻ�����������ͳ�Ϊ�˺����ѡ���һ�죬Sommi�İְֵ�����ȥ��ʳ����Ϊ���촢����ʳ��һȥ��û�л������µ��� Sommi������Ժ���ͼ�����Pengiƴ�����뱣�����ѣ������ɹ����ѡ����Pengi��Sommi�ܷ��ų����ѳ�Ϊ�ֽ����������ĳ���ʵ���죿', '84', 'bcc91749.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('40', '��������', '40', '4', '4', '20060711', '��', '�ο�� / �Ӻ��� / �ᶷ��', '�������ο���Σ���һ��ƽ������Щ��Ϳ���������ˣ�������Ů�����棨���ų��Σ������һ������ں����߾�ӪС�꣬���Ű�����͵���������������壨�� �����Σ���һ���Ͱ����ˣ��ܵ����գ��Ӻ����Σ��Ǽ���Ψһ�Ĵ�ѧ����ȴʧҵû�й�������ʱ����ɧ����ƣ�����ʵ�������������飨�ᶷ���Σ��Ǹ�����˶� Ա��ȴ���ڹؼ�ʱ�̵����ӡ�', '90', 'bcc91750.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('41', '��������', '41', '1', '1', '20091210', '����', '���� / ���� / ������', '����ʱ��������ǿ�����������ܲ١���Ȩ������֮����۸��Ӷ����������Ķ����������������Ǹ�ʱ���������Ľܳ�����Լ����ǵ�Ӣ����Ϊ�͸�ǿս�ԡ�', '95', 'bcc91751.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('42', '��«��', '42', '1', '1', '19860212', '������', 'Ҧ����', 'һλ��үү��ɽ�ϲ�ҩ�������н�����һ��ɽ�����ڶ���������һֻ��ɽ�ס���ɽ�׸�����үү�Լ���С�Ĵ��ƺ�«ɽ����������Ы��������ɽ�װ�����үүȡ�����ܽ�����ħ�ı���«�ѡ�', '99', 'bcc91752.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('43', 'ϲ�������̫��', '43', '1', '1', '20050601', '��ΰ��', '������ / ����', '��ϲ�������̫�ǡ��������������Ⱥ����Ȥ����������Ϊ���ߣ����������ڶг�����ڱ�Ц���԰���Ĭ��', '98', 'bcc91753.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('44', '������ʿ����', '44', '1', '1', '20131106', '֣��ΰ', '������', '������а������ܣ���Ц���������ͼ�������´�Ⱦ��������������׬����Ǯ��δ����һ�����������н�δ����Ĳ�����ɢ�ڳ�����˽׶εĲ�����ѡ���з�����������Ϊ��������������������Ϊ��������-ŷ��ɪ��', '85', 'bcc91754.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('45', 'С�������ռ�', '45', '1', '1', '20131106', '����ȫ', '��ﴺ', '�������̨����3600��Ԫ����Ĵ��Ͷ������������硶С�������ռǡ��Ǽ�����ǰ����߸���桷֮�������Ƴ�����һ������������С�������ռǡ�ȫ�繲52�����ܳ�1000����ӣ�ȡ�����й����ϵ���䴫˵��С���������š��������ھ������Ѿ�����Ŀȫ�ǡ����ݲ���ǰ�ڹ������й���Ա͸¶�þ������������г�ֿ����˵����ӵ������ص���ϲ�ã����۴Ӿ�����ơ�������Ч�������Զ԰��϶����ܺ����ǻ�ӭ��', '96', 'bcc91755.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('46', '�ڽ�', '46', '3', '3', '20060408', 'Ƭ�m��ֱ', '�˴���', '���µĵص�����һ���鹹��̩���������С����ް���������Roanapur���������Ǻڰ�͹�Ӷ�������á��ڽ��̻�Ĺ�����Ϊ�ۼ����ް��������ĸ���ڰ��� ����Ҳ����һЩ��ʱ���ֵ�ɢ�͡�����һ�����ں������͸��ָ����ġ����������������·���ڽ��̻���Ҫ�����乤����һ�Ҿ������׿�ͧ��������ֻ�ڵ�һ���� ����������Ǹ��໹��ϰ����ʹ����ǹ����ǹ����������ֵ��һ������ںڽ�����ֵĸ������������乤�ߴ������ʵ�д��ڣ����������鹹�ġ�', '99', 'bcc91756.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('47', 'ȫ������', '47', '3', '3', '19980408', '�ض��ж�', '����һ', '��ȫ�����񳱡���̨�롶����Σ��������һ������趨Ϊ90���������Ϊ��ս�ļܿ����磬��Ļ�������Ϊ���������������������������������ά�����Ӵ�ľ� �ӣ����Է�ֲ�˱�������Լ�ͻ�ɳ��Լ������֯�������緶Χ�ڽ��н����ͷ������Ӳ����潻��Ķ�����������������е�����͸�Լ������������������ִ����� �����޻���ǧ���ڵ����ǣ��ֲ�ս��ʱ�з�����', '99', 'bcc91757.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('48', '��ħ����', '48', '3', '3', '20061003', '������', 'С��ɳ��', '�ںܾúܾ���ǰǧ�겮���������ռ���򣬵������������������ǧ�겮��������ָ���ƽ����Ԥ��˵��ǧ�겮�����ٶ����١���', '99', 'bcc91758.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('49', 'һ�ﵱǧ', '49', '3', '3', '20061003', '�ɲ���־', 'ǳҰ���', 'һ�ﵱǧ���ձ��Ĵ���ACGϵ�У�����������������һ��������һֱ�������顣ϵ�к����������������Ϸ���ܱ߲�Ʒ�ȶ������ԭ��Ϊ���������� �۶���ͬ��������2000�꿪ʼ��������־��COMIC GUM�����������񣬶�����TV�����ļ��͸ı���Ϸ3����', '61', 'bcc91759.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('50', 'è������', '50', '2', '2', '19400101', 'Լɪ���ͱ���', '��ķ / ����', 'è�����󡷲�����è�����ԭ�ͣ��������Χ��һֻ�����ļ�è��ķ������ͬ��һ��ȴ����ץס���������չ��', '78', 'bcc91760.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('51', 'а������', '51', '2', '2', '20081226', '����֮', 'ղɭ������˹ / �ֵ¡��������', '��а�������������롶��ħ�ˡ�������룩��������Ȼ��������̨���룩����������CW����̨�����Ľ������쳬��Ȼ����ĵ��Ӿ硣�ڼ��ô����㡣�þ���Ҫ���ڽ������ֵ�ɽķ���³�˹�غ͵϶����³�˹�ؿ���1967��ĺ�ɫѩ���������� �����������������鳬��Ȼ�򲻿�˼����¼�����֮ս���Ĺ��£����´�������������Ķ��д�˵����䴫˵��', '69', 'bcc91761.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('52', '�Ϸ���԰', '52', '2', '2', '19990310', '�ޡ�����', '���ס�����', '���Ϸ���԰���������뷨������˥����԰�����۰淭�룩���Ϸ��ļ��͡���������ϲ�����ģ�Comedy Central��������һ����ֽ���Ķ����缯����Matt Stone��Trey Parker������', '75', 'bcc91762.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('53', 'TED�ݽ���', '53', '2', '2', '20060627', '', '', '��2006����TED�ݽ�����Ƶ���ϴ������ϡ�����2010��4�£�TED�ٷ���վ����¼��TED�ݽ���Ƶ�Ѵ�650����������ǧ�������ۿ���TED�ݽ�����Ƶ�����е�TED�ݽ�����Ƶ�����Դ���CC�ķ�ʽ������Ȩ�ġ�', '86', 'bcc91763.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('54', '˹̹����ѧ���ſγ�: ��̷���', '54', '2', '2', '20050305', '', '', '���γ������ı�����ſγ̣�Ҳ��˹̹����ѧ��Ҫ�γ�֮һ�������˵���������ƻ���˼�룺�������ģ�黯����װ����������ԡ�', '85', 'bcc91764.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('55', 'Ү³�����Σ���ѧ������', '55', '2', '2', '20120407', '', '', '���γ���Ү³��������ѧ�����ԡ�', '85', 'bcc91765.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('56', 'Ү³��ѧ���ſγ̣���������', '56', '2', '2', '20110311', '', '', '���ſγ���Ҫ�����ڽ��ͽ���ϵͳ��ȫ�򾭼õı����������ݵĽ�ɫ������Ҫ�ԡ� Լ��.���ɿ�����˹���ڲ�û�аѽ�������;�������ֽ⿪������������ƽ����Ϊ����ƽ���һ�ֲ��������ڡ����ſγ̻���ͨ���Գ�������ṩһ��˼��������ĽǶȡ�', '90', 'bcc91766.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('57', 'Ү³��ѧ���ſγ̣������г�', '57', '2', '2', '20120602', '', '', '���ڻ���������������Ҫ֧��������ΪͶ�ʻ�ṩ֧�ּ����չ������������ҪԤ����ڻ�����̬�������������Ϣʱ���еķ�չ̬�ƣ����Ǳ������ҵ���� ���˽⡣���γ̽��漰�������У�����ѧ���ۡ�����ҵ�ķ�չ���̡����ڻ������������С����չ�˾��֤ȯ��˾���ڻ���˾�����������г�����������ȱ���Լ���Щ ������δ����չǰ����', '89', 'bcc91767.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('58', '��ʡ��ѧԺ���ſγ̣��㷨����', '58', '2', '2', '20131012', '', '', '����һ�¿���¼�������ڿε���λMIT����ʦ����һλ����������������ģ��Ǳ���ĵڶ�����Charles E. Leiserson�����߼����ܣ���Ȥ��Ĭ��MIT���ڶ�λ�����Ž��ɫ���������Ӻ���β���Ŀ����Erik Demaine��21�꼴ȡ��MIT�����ʸ����ţ�1981�����������25�꣬ҵ�మ���Ƕ���˹���顢��Ϸ����������ֽ����ˣ��ħ���ͽ�����Ϸ��', '74', 'bcc91768.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('59', '˹̹����ѧ���ſγ�: ��̷�ʽ', '59', '2', '2', '20060224', '', '', 'c��c++�߼��ڴ�������������ʽ���������ʽ�Ĳ�𡣺�����ʽ--ʹ��LISP�Ͳ������--ʹ��c��c++���򵥽���һЩ�������е����ԣ���Python��Objective-C��C#��', '96', 'bcc91769.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('60', 'Ү³��ѧ���ſγ̣��ʱ�����', '60', '2', '2', '20060224', '', '', '���ν���Դ�������ݻ���˼·����ڹ���ʱ�����', '99', 'bcc91770.jpg', '2', '20150317', '20160302', '1');
INSERT INTO `media_desc` VALUES ('61', 'CCTV-1', '61', '1', '1', '20131012', null, null, null, null, null, '3', '20160314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('62', 'CCTV-2', '62', '1', '1', null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('63', 'CCTV-3', '63', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('64', 'CCTV-4', '64', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('65', 'CCTV-5', '65', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('66', 'CCTV-6', '66', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('67', '��������', '67', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('68', '��������', '68', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('69', '�㽭����', '69', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('70', '��������', '70', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('71', '���Ӱ��', '71', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('72', '�����', '72', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('73', '�������', '73', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('74', '�������', '74', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('75', '�������', '75', null, null, null, null, null, null, null, null, '3', '20150314', '20170225', '1');
INSERT INTO `media_desc` VALUES ('76', '����', '81', '1', '1', '20141202', '���Ǽ�', '������', '�����ϴ���', '1', null, '1', null, null, null);

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
INSERT INTO `serviec_type` VALUES ('1', '�������', '1');
INSERT INTO `serviec_type` VALUES ('2', '����15', '15');
INSERT INTO `serviec_type` VALUES ('3', '����', '30');
INSERT INTO `serviec_type` VALUES ('4', '����', '365');

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
INSERT INTO `user` VALUES ('1', '֣��', '1', '18', '13682076219', '������Ͽ���ѧ����', '1', '1', '2', null, '22', null);
INSERT INTO `user` VALUES ('2', '�Ķ�', '2', '101', '13682076219', '������Ͽ���������', '1', '1', '2', '��ֵҵ��Ǳ�ڿͻ�', '22', null);
INSERT INTO `user` VALUES ('3', '����', '3', '102', '13682076219', '������Ͽ����㿪����·', '1', '1', '1', null, '22', null);
INSERT INTO `user` VALUES ('4', '����', '4', '103', '13682076219', '������Ͽ�������·', '1', '1', '1', '��ֵҵ��Ǳ�ڿͻ�', '22', null);
INSERT INTO `user` VALUES ('5', 'Ѧΰ', '5', '104', '13682076219', '������Ͽ���������·', '1', '2', '1', null, '22', null);
INSERT INTO `user` VALUES ('6', '�����', '6', '105', '13682076219', '������Ͽ���������', '1', '1', '1', null, '22', null);
INSERT INTO `user` VALUES ('7', '³��Ӣ', '7', '106', '13682076219', '������Ͽ�����԰��', '1', '2', '1', '��ֵҵ��Ǳ�ڿͻ�', '22', null);
INSERT INTO `user` VALUES ('8', 'ţ̴', '8', '107', '13682076219', '������Ͽ����ӳ���', '1', '1', '1', null, '22', null);
INSERT INTO `user` VALUES ('9', '�±���', '9', '108', '13682076219', '������Ͽ���������', '1', '1', '1', '��ֵҵ��Ǳ�ڿͻ�', '22', null);
INSERT INTO `user` VALUES ('10', '�˱�', '10', '109', '13682076219', '������Ͽ����ƺӵ�', '1', '2', '1', null, '22', null);
INSERT INTO `user` VALUES ('11', '������', '11', '110', '13682076219', '����к�������ţ�ǵ�', '1', '2', '1', null, '22', null);
INSERT INTO `user` VALUES ('12', '������', '12', '111', '13682076219', '����к������齭��', '1', '2', '1', '��ֵҵ��Ǳ�ڿͻ�', '22', null);
INSERT INTO `user` VALUES ('13', '������', '13', '112', '13682076219', '����к�������ˮ��', '1', '2', '1', null, '22', null);
INSERT INTO `user` VALUES ('14', '����ƽ', '14', '113', '13682076219', '����������ͥ·', '1', '2', '1', null, '22', null);
INSERT INTO `user` VALUES ('15', '����', '15', '114', '13682076219', '����к�ƽ���Ͼ�·', '1', '2', '1', '��ֵҵ��Ǳ�ڿͻ�', '22', null);
INSERT INTO `user` VALUES ('16', '����', '16', '115', '13682076219', '����ƽ���������', '1', '1', '1', null, '22', null);
INSERT INTO `user` VALUES ('17', '��ٻ', '17', '116', '13682076219', '����к������ڼ��', '1', '1', '1', null, '22', null);
INSERT INTO `user` VALUES ('18', '����', '18', '117', '13682076219', '����к���������·', '1', '1', '1', '��ֵҵ��Ǳ�ڿͻ�', '22', null);
INSERT INTO `user` VALUES ('19', '������', '19', '118', '13682076219', '����к��������ű�·', '1', '2', '1', null, '22', null);
INSERT INTO `user` VALUES ('20', '�Թ���', '20', '119', '13682076219', '����к��������ٱ�·', '1', '1', '2', null, '22', null);
INSERT INTO `user` VALUES ('21', '������', '21', '120', '13682076219', '����к������齭��', '2', '2', '2', null, '23', null);
INSERT INTO `user` VALUES ('22', '����', 'tj123', '32', '1382076215', '������Ͽ���', '1', '1', '6', '��������', '22', null);
INSERT INTO `user` VALUES ('23', 'Ԫ��', 'tj123', '35', '1362086325', '����к�ƽ��', '2', '1', '6', '��������', '23', null);
INSERT INTO `user` VALUES ('24', '����', 'tj123', '36', '1395085254', '����к�����', '1', '2', '6', '��������', '22', null);
INSERT INTO `user` VALUES ('25', '����', 'tj123', '32', '1382076215', '������Ͽ���', '1', '1', '6', '��������', '22', null);
INSERT INTO `user` VALUES ('26', 'Ԫ��', 'tj123', '35', '1362086325', '����к�ƽ��', '2', '1', '6', '��������', '23', null);
INSERT INTO `user` VALUES ('27', '����', 'tj123', '36', '1395085254', '����к�����', '1', '2', '6', '��������', '22', null);
INSERT INTO `user` VALUES ('28', '����', 'tj123', '32', '1382076215', '������Ͽ���', '1', '1', '6', '��������', '99', null);
INSERT INTO `user` VALUES ('29', 'Ԫ��', 'tj123', '35', '1362086325', '����к�ƽ��', '2', '1', '6', '��������', '120', null);
INSERT INTO `user` VALUES ('30', '����', 'tj123', '36', '1395085254', '����к�����', '1', '2', '6', '��������', '149', null);
INSERT INTO `user` VALUES ('31', '����', 'tj123', '32', '1382076215', '������Ͽ���', '1', '1', '6', '��������', '99', null);
INSERT INTO `user` VALUES ('32', 'Ԫ��', 'tj123', '35', '1362086325', '����к�ƽ��', '2', '1', '6', '��������', '120', null);
INSERT INTO `user` VALUES ('33', '����', 'tj123', '36', '1395085254', '����к�����', '1', '2', '6', '��������', '149', null);
INSERT INTO `user` VALUES ('34', '����', 'tj123', '32', '1382076215', '������Ͽ���', '1', '1', '6', '��������', '99', null);
INSERT INTO `user` VALUES ('35', 'Ԫ��', 'tj123', '35', '1362086325', '����к�ƽ��', '2', '1', '6', '��������', '120', null);
INSERT INTO `user` VALUES ('36', '����', 'tj123', '36', '1395085254', '����к�����', '1', '2', '6', '��������', '149', null);

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