/*
Navicat MySQL Data Transfer

Source Server         : COCO
Source Server Version : 60011
Source Host           : 127.0.0.1:3306
Source Database       : st

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001 

Date: 2016-10-13 15:22:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adminloginrecord
-- ----------------------------
DROP TABLE IF EXISTS `adminloginrecord`;
CREATE TABLE `adminloginrecord` (
  `loginRecordId` varchar(36) NOT NULL,
  `adminId` varchar(36) NOT NULL,
  `loginTime` datetime NOT NULL,
  `logoffTime` datetime NOT NULL,
  `loginAddress` varchar(255) NOT NULL,
  `loginIP` varchar(255) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`loginRecordId`),
  KEY `aid` (`adminId`),
  KEY `adminId` (`adminId`),
  CONSTRAINT `adminloginrecord_ibfk_1` FOREIGN KEY (`adminId`) REFERENCES `admins` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminloginrecord
-- ----------------------------
INSERT INTO `adminloginrecord` VALUES ('39ed9e5e-7521-48fd-8bab-db3e629219c9', '1138829222', '2016-09-15 13:23:54', '2016-09-15 13:23:54', '本机', '0:0:0:0:0:0:0:1', '0');
INSERT INTO `adminloginrecord` VALUES ('5e1422bf-8cab-4ca8-9d77-8609ed04dec9', '123456', '2016-09-15 13:24:52', '2016-09-15 13:24:52', '本机', '0:0:0:0:0:0:0:1', '0');

-- ----------------------------
-- Table structure for adminpower
-- ----------------------------
DROP TABLE IF EXISTS `adminpower`;
CREATE TABLE `adminpower` (
  `id` varchar(36) NOT NULL,
  `powerId` varchar(36) NOT NULL,
  `adminId` varchar(36) NOT NULL,
  `status` int(1) NOT NULL COMMENT '0代表么有拥有该权限，1代表拥有该权限',
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `forkey_power_admin_powerId` (`powerId`),
  KEY `forkey_power_admin_adminId` (`adminId`),
  CONSTRAINT `adminpower_ibfk_1` FOREIGN KEY (`adminId`) REFERENCES `admins` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `adminpower_ibfk_2` FOREIGN KEY (`powerId`) REFERENCES `powers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminpower
-- ----------------------------
INSERT INTO `adminpower` VALUES ('03dcf441-3471-48ed-ad0c-5367967cd12a', '403', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('0ad10634-8fc2-4029-a4d4-4183a06922ca', '502', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('0d204c4b-372a-4611-87cf-f742e1a891a6', '1003', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('0e57509a-a3d7-4f9a-a0cd-4104b135da93', '702', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('10ae961b-309b-46e3-81f8-1447c952b10d', '704', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('1231314154asd', '504', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('12891289', '401', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('13123', '204', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('18326b10-4652-4cd0-bb4c-cfaf90876aad', '802', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('19469df5-d6eb-48b7-8288-27b070ecf675', '802', '123456', '1', '0');
INSERT INTO `adminpower` VALUES ('213156a4f6s', '1001', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('21345646ads', '404', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('23423', '204', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('27dbeeee-0bc6-4580-b4ea-15b405e73644', '902', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('2a42b243-548a-42e7-9504-54da09163a74', '501', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('2a8c95e2-ad60-4f40-9155-deb8dd1b4ed6', '204', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('2b73a289-c8a9-43c3-b194-a344335fe0e4', '1003', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('2d482139-197b-488d-afa3-606d8bd63281', '701', '123456', '1', '0');
INSERT INTO `adminpower` VALUES ('311513a7-46d3-442a-ae98-b4bf5889d22b', '1004', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('3503de7e-48ae-4c04-a726-7946d86db111', '1003', '123456', '1', '0');
INSERT INTO `adminpower` VALUES ('37b42161-d9e0-4a20-ad4e-73082b4ddf84', '603', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('39d4d9df-f7d3-4c57-8fcd-cfa528990497', '901', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('3f3419ed-9c4c-45bc-a3c7-8999b51d8466', '503', '123456', '1', '0');
INSERT INTO `adminpower` VALUES ('3fb41094-72bd-48d5-8f4d-dd453bada2f3', '502', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('41d0c0a0-8fd1-4db1-bdde-0188240964b7', '302', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('456asd456asd', '701', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('456dasd56456', '602', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('476d08fa-1f94-4c8f-b2bc-72f0943a65f8', '602', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('4800bd60-0443-46dc-9ea5-f9348aa028bd', '702', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('4a56sd4a56', '502', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('4a65rf4w', '901', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('4a89w4q1huiui', '904', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('52332190-5a36-4ab2-8868-a91b29a05d11', '904', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('542af535-e0a4-4a6e-a337-e125a0dd3503', '703', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('564456', '202', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('56465qwe', '501', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('56a3fd00-da6f-4a45-bdd0-3fef0f5a24f3', '402', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('56a4w64q6w1wge', '903', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('56qw74q6', '402', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('57de66df-a171-44ba-9268-f5dcff8ea461', '501', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('587626de-177d-4c84-a70f-b57a5203d021', '801', '123456', '1', '0');
INSERT INTO `adminpower` VALUES ('591f98ae-d7ba-4cd2-8be4-d43b56f12024', '404', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('5as456asd456', '604', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('5be859b7-a05d-4bd1-9cb6-e5ab48e7abd4', '204', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('68564513', '203', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('68c81266-e5de-4c0d-8a49-605898f81770', '301', '123456', '1', '0');
INSERT INTO `adminpower` VALUES ('6cc1888b-e3fe-4638-b4ec-8efb60b391f9', '201', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('6cdd2f22-1388-425d-9a16-f86b5ce01a2d', '604', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('705c549c-20f1-4371-ab9b-5d1e3cbfef0e', '1002', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('72b0a5a3-f3e6-4304-9091-8d7be8590bfe', '202', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('7821fdd4-8a22-4071-b803-6434b33a87c1', '504', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('7c77c4dd-6c4a-4333-bbe1-e355a22f1739', '1002', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('846dc790-fb56-419f-9c4a-99125a55a042', '601', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('870d688f-b822-434b-9f96-c6ade6bbaee4', '802', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('87a90796-ca66-4c60-a68e-4aeae9baa7e9', '202', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('87d1296a-48b2-40ab-b617-1316d29527ee', '301', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('89789789', '201', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('90172a50-93ec-499d-b4b8-0abb161dc025', '1001', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('903f1bb5-4e4b-457a-993c-21e8b34cb286', '602', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('9128ced7-6f08-4407-b820-a7914a6a2f54', '203', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('94277865-9fef-43eb-9c47-f1d64229f2c4', '503', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('9a7430cb-58d0-4146-abab-21b8f45e1658', '301', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('9c1cf621-e4fe-472c-aac7-3a032e190045', '201', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('9dc264cb-4e89-4a5a-80a5-5c1b0e6ef4e7', '1001', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('a4737a2c-5c4c-4feb-a3e0-9a618bb8ccbc', '601', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('a4b7e91d-3f8d-4357-ae62-4171ca28c266', '303', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('a4f6w4q61sz', '902', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('a4sd564a564da564', '703', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('a564d56', '304', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('a564df6', '403', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('a564ew89q4c1z1c', '704', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('a6d4a6', '303', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('a87r1j6kl.1jk', '804', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('a98df74qw1c6qw', '1003', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('a9d1e2a3-33be-41c3-88e0-5d7db546bad6', '803', '123456', '1', '0');
INSERT INTO `adminpower` VALUES ('aasdasdasd526456456', '601', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('acaa8800-cc2c-47ad-83c0-26e2b52acb93', '203', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('ad', '302', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('ad42abd1-bcdc-4766-93e4-3e98952355aa', '804', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('ad7q965daw', '1002', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('as4d56a465', '702', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('as56f4da6', '301', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('asdfladfkopadfkop', '603', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('asdkplq', '1004', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('b1b17f15-2117-44a5-8113-bc8765766e28', '903', '123456', '1', '0');
INSERT INTO `adminpower` VALUES ('b1e275b6-06e8-4a82-b0fc-60d486459443', '304', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('c0e93b4f-0312-4196-9a29-c751161666b4', '604', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('c1471380-aba2-4f36-a46f-57b0f8dcc14e', '603', '123456', '1', '0');
INSERT INTO `adminpower` VALUES ('c4ba4698-f3fd-4eb0-ae05-ce92e2112a12', '803', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('cbfb5590-8a81-43ca-ab79-6e34c177b95f', '703', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('ce79cfda-01ed-44d3-9fc2-d3db65c08c93', '801', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('d1061ca6-ec4a-4b52-9ad7-bea5e3069b68', '504', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('d1c46b12-b331-45a0-b507-78cdcc158114', '603', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('d3603ec8-65b6-48d6-a4f8-2e427ca26fb8', '701', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('d3ca3563-0b5f-4f37-8350-e83148a4b2d8', '701', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('da26b8d5-7c1e-49a8-8032-716f41c2289f', '401', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('dc27a321-ae71-4d3e-a2ee-b57786c03bc4', '1004', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('e04dcb50-b6e1-4f66-a6ce-f40975c0a0d7', '804', '123456', '1', '0');
INSERT INTO `adminpower` VALUES ('e9f02c9e-856b-47fd-8182-cd956c55de21', '503', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('eb5992f8-0631-40de-8a93-b116b6b7e831', '203', '123456', '1', '0');
INSERT INTO `adminpower` VALUES ('ebe73753-67f6-42a2-9bb2-ba2f1504a999', '303', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('ede4789e-fb33-4a5e-8be8-76847bfdff57', '903', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('f1182508-4d84-4c80-9b4a-4ab553f3dbea', '302', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('f2564ed7-f957-4eea-8aa9-07f308c6318a', '804', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('f5f445ea-a2a7-4097-886c-404ea6d8f919', '801', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('f773c5d8-890c-4381-8c0d-ec20513c7f27', '304', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('f9d54a70-4bd2-42a9-ae3e-090c99ec0483', '803', '1234567', '1', '0');
INSERT INTO `adminpower` VALUES ('fc7c6368-ab46-40d4-bced-963cfbea381f', '704', '987654', '1', '0');
INSERT INTO `adminpower` VALUES ('q7w481c561we6g', '802', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('q89wr7451s56cv1we', '801', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('t4yu5646', '503', '1138829222', '1', '0');
INSERT INTO `adminpower` VALUES ('w897q641n564yug', '803', '1138829222', '1', '0');

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(36) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0',
  `isSuperAdmin` int(1) NOT NULL DEFAULT '0',
  `theme` varchar(255) NOT NULL DEFAULT 'bootstrap',
  `createTime` datetime NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  `introduction` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES ('1138829222', null, '00475e1c169583ae78c80d2ed7701e14', '1', '1', 'bootstrap', '2016-06-28 15:10:37', '0', '');
INSERT INTO `admins` VALUES ('123456', null, 'e10adc3949ba59abbe56e057f20f883e', '1', '0', 'bootstrap', '2016-07-12 22:40:47', '0', '第一测试用户');
INSERT INTO `admins` VALUES ('1234567', null, '1234567', '1', '0', 'bootstrap', '2016-07-13 11:28:48', '1', '第三测试账户');
INSERT INTO `admins` VALUES ('654321', null, '654321', '1', '0', 'bootstrap', '2016-07-12 12:40:17', '1', '654321');
INSERT INTO `admins` VALUES ('987654', null, 'e10adc3949ba59abbe56e057f20f883e', '1', '0', 'default', '2016-07-12 12:40:39', '0', '第二测试账户');

-- ----------------------------
-- Table structure for adminupdaterecord
-- ----------------------------
DROP TABLE IF EXISTS `adminupdaterecord`;
CREATE TABLE `adminupdaterecord` (
  `updateRecordId` varchar(36) NOT NULL,
  `doAdminId` varchar(36) NOT NULL COMMENT '进行操作的adminId',
  `doneAdminId` varchar(36) NOT NULL COMMENT '被操作的adminId',
  `item` varchar(255) NOT NULL,
  `updateTime` datetime NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`updateRecordId`),
  KEY `doneAId` (`doneAdminId`),
  KEY `doAId` (`doAdminId`),
  CONSTRAINT `adminupdaterecord_ibfk_1` FOREIGN KEY (`doAdminId`) REFERENCES `admins` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `adminupdaterecord_ibfk_2` FOREIGN KEY (`doneAdminId`) REFERENCES `admins` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminupdaterecord
-- ----------------------------
INSERT INTO `adminupdaterecord` VALUES ('27bf12c7-bc74-45b4-b6a0-d9d4b761cff4', '1138829222', '123456', '编辑密码', '2016-09-15 13:24:17', '0');
INSERT INTO `adminupdaterecord` VALUES ('6a4f6e70-6622-45a5-b044-16816fde59a9', '1138829222', '123456', '编辑', '2016-09-15 13:24:49', '0');
INSERT INTO `adminupdaterecord` VALUES ('dc2082fe-4ebd-4367-9c8a-48b56c27dd54', '1138829222', '123456', '编辑', '2016-09-15 13:24:38', '0');

-- ----------------------------
-- Table structure for imgs
-- ----------------------------
DROP TABLE IF EXISTS `imgs`;
CREATE TABLE `imgs` (
  `id` varchar(36) NOT NULL,
  `imgName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of imgs
-- ----------------------------
INSERT INTO `imgs` VALUES ('175a84b9-d657-450c-aa97-bad9e13ab379', '175a84b9-d657-450c-aa97-bad9e13ab379.jpeg');
INSERT INTO `imgs` VALUES ('29607af4-298b-4451-8caf-c44c365e1361', '29607af4-298b-4451-8caf-c44c365e1361.png');
INSERT INTO `imgs` VALUES ('2d6d8fd0-63de-4873-9b92-13461976b66a', '2d6d8fd0-63de-4873-9b92-13461976b66a.jpeg');
INSERT INTO `imgs` VALUES ('3e19fd03-373d-4910-bedd-962289cf81aa', '3e19fd03-373d-4910-bedd-962289cf81aa.gif');
INSERT INTO `imgs` VALUES ('41b57f58-1507-499d-a562-4738cd61da66', '41b57f58-1507-499d-a562-4738cd61da66.jpeg');
INSERT INTO `imgs` VALUES ('447be51a-b4ff-4d4d-abfb-87085932ca30', '447be51a-b4ff-4d4d-abfb-87085932ca30.jpeg');
INSERT INTO `imgs` VALUES ('4ae17fee-e65e-4aec-a285-37f44a027ae2', '4ae17fee-e65e-4aec-a285-37f44a027ae2.jpeg');
INSERT INTO `imgs` VALUES ('58490a64-486e-40ab-ab90-f7fcc451fc91', '58490a64-486e-40ab-ab90-f7fcc451fc91.jpeg');
INSERT INTO `imgs` VALUES ('5ae37478-0e09-4725-9cec-d566dd4c3b70', '5ae37478-0e09-4725-9cec-d566dd4c3b70.jpeg');
INSERT INTO `imgs` VALUES ('6e42c068-d8c1-4a9b-867b-399ccb3596d0', '6e42c068-d8c1-4a9b-867b-399ccb3596d0.jpeg');
INSERT INTO `imgs` VALUES ('76dfcc96-1cab-4148-867c-919538f189f6', '76dfcc96-1cab-4148-867c-919538f189f6.jpeg');
INSERT INTO `imgs` VALUES ('8d606e41-0213-409f-89b7-13cc01d9fdb3', '8d606e41-0213-409f-89b7-13cc01d9fdb3.jpeg');
INSERT INTO `imgs` VALUES ('a8193b52-bfaa-49a7-b93e-1d3b23eb1483', 'a8193b52-bfaa-49a7-b93e-1d3b23eb1483.jpeg');
INSERT INTO `imgs` VALUES ('aad478b0-afbe-4f84-a557-ba96ff9d0d61', 'aad478b0-afbe-4f84-a557-ba96ff9d0d61.jpeg');
INSERT INTO `imgs` VALUES ('aaebf50d-0dd8-4fb4-9e1b-5f73a0a91bc5', 'aaebf50d-0dd8-4fb4-9e1b-5f73a0a91bc5.jpeg');
INSERT INTO `imgs` VALUES ('d24e093a-eeea-4e70-821d-65c0c5b43f1c', 'd24e093a-eeea-4e70-821d-65c0c5b43f1c.png');
INSERT INTO `imgs` VALUES ('ff5d94a4-5b63-4c2e-bba3-f2adb2029dd3', 'ff5d94a4-5b63-4c2e-bba3-f2adb2029dd3.jpeg');

-- ----------------------------
-- Table structure for imgs_and_info
-- ----------------------------
DROP TABLE IF EXISTS `imgs_and_info`;
CREATE TABLE `imgs_and_info` (
  `id` varchar(36) NOT NULL COMMENT '这是一个关联图片表和一个信息表的“关联表”，关联的方式为：id关联（即将两张表的id放置在同一张表中）；',
  `status` int(1) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `deleteTime` datetime DEFAULT NULL,
  `imgId` varchar(36) NOT NULL COMMENT '表一中的主键的id',
  `infoId` varchar(36) NOT NULL COMMENT '表二中的主键的id',
  `main` tinyint(1) NOT NULL COMMENT '标识是否为主要的图片（用于展示）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of imgs_and_info
-- ----------------------------
INSERT INTO `imgs_and_info` VALUES ('175a84b9-d657-450c-aa97-bad9e13ab379', '1', '0', '2016-08-30 12:58:23', '2016-08-30 12:58:23', null, '175a84b9-d657-450c-aa97-bad9e13ab379', 'cbf9590f-f398-46eb-aab7-5b40430e0d20', '0');
INSERT INTO `imgs_and_info` VALUES ('222f0d9b-5729-43d3-ada8-694426a1b822', '1', '1', '2016-08-29 22:06:58', '2016-08-29 22:06:58', '2016-08-30 12:46:49', '222f0d9b-5729-43d3-ada8-694426a1b822', 'dfe7a442-3839-47b3-939d-6df3ecb7a7e9', '0');
INSERT INTO `imgs_and_info` VALUES ('248be108-1d9e-4689-88fa-0f12092f90b1', '1', '1', '2016-08-29 21:39:02', '2016-08-29 21:39:02', '2016-08-29 22:01:04', '248be108-1d9e-4689-88fa-0f12092f90b1', 'dfe7a442-3839-47b3-939d-6df3ecb7a7e9', '0');
INSERT INTO `imgs_and_info` VALUES ('27f13bbb-6e46-42a3-8b7a-bc9cb0563ad9', '1', '1', '2016-08-29 21:35:58', '2016-08-29 21:35:58', '2016-08-30 12:49:00', '27f13bbb-6e46-42a3-8b7a-bc9cb0563ad9', '83987ac6-791a-4cd3-b750-9fe528a5b43a', '0');
INSERT INTO `imgs_and_info` VALUES ('29607af4-298b-4451-8caf-c44c365e1361', '1', '0', '2016-08-31 14:49:47', '2016-08-31 14:49:47', null, '29607af4-298b-4451-8caf-c44c365e1361', 'ff2e7b90-a561-4eb7-81ec-de5d15e8ce06', '0');
INSERT INTO `imgs_and_info` VALUES ('29b233fd-251d-46fa-af8b-c20a4ede0a01', '1', '1', '2016-08-29 21:05:47', '2016-08-29 21:05:47', '2016-08-29 22:17:31', '29b233fd-251d-46fa-af8b-c20a4ede0a01', '4564', '0');
INSERT INTO `imgs_and_info` VALUES ('2d6d8fd0-63de-4873-9b92-13461976b66a', '1', '0', '2016-08-31 14:49:55', '2016-08-31 14:49:55', null, '2d6d8fd0-63de-4873-9b92-13461976b66a', 'ff2e7b90-a561-4eb7-81ec-de5d15e8ce06', '1');
INSERT INTO `imgs_and_info` VALUES ('3d3d41da-8771-43b5-9cf1-f92abcbc739d', '1', '1', '2016-08-29 21:01:50', '2016-08-29 21:01:50', '2016-08-29 21:02:34', '3d3d41da-8771-43b5-9cf1-f92abcbc739d', '4564', '0');
INSERT INTO `imgs_and_info` VALUES ('3e19fd03-373d-4910-bedd-962289cf81aa', '1', '0', '2016-08-30 12:54:53', '2016-08-30 12:54:53', null, '3e19fd03-373d-4910-bedd-962289cf81aa', '4564', '1');
INSERT INTO `imgs_and_info` VALUES ('41b57f58-1507-499d-a562-4738cd61da66', '1', '0', '2016-08-29 23:14:35', '2016-08-29 23:14:35', null, '41b57f58-1507-499d-a562-4738cd61da66', 'cbf9590f-f398-46eb-aab7-5b40430e0d20', '0');
INSERT INTO `imgs_and_info` VALUES ('447be51a-b4ff-4d4d-abfb-87085932ca30', '1', '0', '2016-08-31 19:58:20', '2016-08-31 19:58:20', null, '447be51a-b4ff-4d4d-abfb-87085932ca30', '730a1cb7-6df6-454e-ac43-201ecfa95b67', '1');
INSERT INTO `imgs_and_info` VALUES ('4ae17fee-e65e-4aec-a285-37f44a027ae2', '1', '0', '2016-08-30 19:51:13', '2016-08-30 19:51:13', null, '4ae17fee-e65e-4aec-a285-37f44a027ae2', 'f6ad6fa4-8370-48fe-bc63-365e41f1627a', '1');
INSERT INTO `imgs_and_info` VALUES ('54416', '1', '1', null, null, '2016-08-29 21:02:29', '999', '4564', '0');
INSERT INTO `imgs_and_info` VALUES ('544161', '1', '1', '2016-08-29 19:31:35', '2016-08-29 19:31:43', '2016-08-29 19:58:03', '888', '4564', '0');
INSERT INTO `imgs_and_info` VALUES ('58490a64-486e-40ab-ab90-f7fcc451fc91', '1', '0', '2016-08-30 12:49:37', '2016-08-30 12:49:37', null, '58490a64-486e-40ab-ab90-f7fcc451fc91', '83987ac6-791a-4cd3-b750-9fe528a5b43a', '1');
INSERT INTO `imgs_and_info` VALUES ('5ae37478-0e09-4725-9cec-d566dd4c3b70', '1', '0', '2016-08-31 19:57:57', '2016-08-31 19:57:57', null, '5ae37478-0e09-4725-9cec-d566dd4c3b70', '730a1cb7-6df6-454e-ac43-201ecfa95b67', '0');
INSERT INTO `imgs_and_info` VALUES ('6e42c068-d8c1-4a9b-867b-399ccb3596d0', '1', '0', '2016-09-08 23:11:37', '2016-09-08 23:11:37', null, '6e42c068-d8c1-4a9b-867b-399ccb3596d0', 'b4034f39-c7f5-4afa-9bfc-955d381b7d10', '1');
INSERT INTO `imgs_and_info` VALUES ('70637941-e7bf-4273-8612-bd3deffe39ac', '1', '1', '2016-08-29 21:02:48', '2016-08-29 21:02:48', '2016-08-29 22:17:34', '70637941-e7bf-4273-8612-bd3deffe39ac', '4564', '0');
INSERT INTO `imgs_and_info` VALUES ('71479f15-f353-4e79-a6f2-be104e4e5330', '1', '1', '2016-08-29 22:07:03', '2016-08-29 22:07:03', '2016-08-30 12:46:43', '71479f15-f353-4e79-a6f2-be104e4e5330', 'dfe7a442-3839-47b3-939d-6df3ecb7a7e9', '0');
INSERT INTO `imgs_and_info` VALUES ('734baa41-bdec-4c26-b8d5-38627423f529', '1', '1', '2016-08-29 21:07:03', '2016-08-29 21:07:03', '2016-08-30 12:53:01', '734baa41-bdec-4c26-b8d5-38627423f529', '4564', '0');
INSERT INTO `imgs_and_info` VALUES ('7674ba31-c50a-400b-8309-a3e21783eb76', '1', '1', '2016-08-29 21:39:14', '2016-08-29 21:39:14', '2016-08-29 22:01:01', '7674ba31-c50a-400b-8309-a3e21783eb76', 'dfe7a442-3839-47b3-939d-6df3ecb7a7e9', '0');
INSERT INTO `imgs_and_info` VALUES ('76dfcc96-1cab-4148-867c-919538f189f6', '1', '0', '2016-08-30 12:58:32', '2016-08-30 12:58:32', null, '76dfcc96-1cab-4148-867c-919538f189f6', 'cbf9590f-f398-46eb-aab7-5b40430e0d20', '1');
INSERT INTO `imgs_and_info` VALUES ('815b8625-4914-4bb8-9838-538473536421', '1', '1', '2016-08-29 23:05:32', '2016-08-29 23:05:32', '2016-08-29 23:05:45', '815b8625-4914-4bb8-9838-538473536421', 'cbf9590f-f398-46eb-aab7-5b40430e0d20', '0');
INSERT INTO `imgs_and_info` VALUES ('8d606e41-0213-409f-89b7-13cc01d9fdb3', '1', '0', '2016-08-31 19:58:07', '2016-08-31 19:58:07', null, '8d606e41-0213-409f-89b7-13cc01d9fdb3', '730a1cb7-6df6-454e-ac43-201ecfa95b67', '0');
INSERT INTO `imgs_and_info` VALUES ('8e9a7091-6b64-487b-a6df-1962ae54b89d', '1', '1', '2016-08-29 22:42:40', '2016-08-29 22:42:40', '2016-08-29 23:05:43', '8e9a7091-6b64-487b-a6df-1962ae54b89d', 'cbf9590f-f398-46eb-aab7-5b40430e0d20', '0');
INSERT INTO `imgs_and_info` VALUES ('917631a9-a76c-44a7-9563-7115db665b11', '1', '1', '2016-08-30 12:57:59', '2016-08-30 12:57:59', '2016-08-30 13:31:34', '917631a9-a76c-44a7-9563-7115db665b11', '982abff7-ffd0-45d7-af86-61701348ce5e', '0');
INSERT INTO `imgs_and_info` VALUES ('a0193c5d-f7d4-44ae-8288-39493aa694af', '1', '1', '2016-08-29 23:14:23', '2016-08-29 23:14:23', '2016-08-30 13:36:32', 'a0193c5d-f7d4-44ae-8288-39493aa694af', '4f71ac83-9125-4846-ae49-a101abc7bad4', '0');
INSERT INTO `imgs_and_info` VALUES ('a07baac7-26d6-4882-8482-294779203c08', '1', '1', '2016-08-31 22:44:00', '2016-08-31 22:44:00', '2016-08-31 22:44:29', 'a07baac7-26d6-4882-8482-294779203c08', '730a1cb7-6df6-454e-ac43-201ecfa95b67', '0');
INSERT INTO `imgs_and_info` VALUES ('a7218360-9304-495a-b511-5d6668130acd', '1', '1', '2016-08-29 21:03:19', '2016-08-29 21:03:19', '2016-08-29 22:01:25', 'a7218360-9304-495a-b511-5d6668130acd', '4564', '0');
INSERT INTO `imgs_and_info` VALUES ('a8193b52-bfaa-49a7-b93e-1d3b23eb1483', '1', '0', '2016-08-30 14:27:03', '2016-08-30 14:27:03', null, 'a8193b52-bfaa-49a7-b93e-1d3b23eb1483', '982abff7-ffd0-45d7-af86-61701348ce5e', '1');
INSERT INTO `imgs_and_info` VALUES ('a990616a-5a1a-4a22-acbf-5b18cbd0679c', '1', '1', '2016-08-29 23:05:52', '2016-08-29 23:05:52', '2016-08-30 12:58:17', 'a990616a-5a1a-4a22-acbf-5b18cbd0679c', 'cbf9590f-f398-46eb-aab7-5b40430e0d20', '0');
INSERT INTO `imgs_and_info` VALUES ('aad478b0-afbe-4f84-a557-ba96ff9d0d61', '1', '0', '2016-08-30 13:36:43', '2016-08-30 13:36:43', null, 'aad478b0-afbe-4f84-a557-ba96ff9d0d61', '4f71ac83-9125-4846-ae49-a101abc7bad4', '1');
INSERT INTO `imgs_and_info` VALUES ('aaebf50d-0dd8-4fb4-9e1b-5f73a0a91bc5', '1', '0', '2016-08-30 12:46:54', '2016-08-30 12:46:54', null, 'aaebf50d-0dd8-4fb4-9e1b-5f73a0a91bc5', 'dfe7a442-3839-47b3-939d-6df3ecb7a7e9', '0');
INSERT INTO `imgs_and_info` VALUES ('bb9d362e-122d-4d77-adc0-7811a395339e', '1', '1', '2016-08-29 23:14:44', '2016-08-29 23:14:44', '2016-08-30 13:36:30', 'bb9d362e-122d-4d77-adc0-7811a395339e', '4f71ac83-9125-4846-ae49-a101abc7bad4', '0');
INSERT INTO `imgs_and_info` VALUES ('c3ebf119-e832-4805-afff-0def0e592559', '1', '1', '2016-08-29 22:17:39', '2016-08-29 22:17:39', '2016-08-30 12:52:58', 'c3ebf119-e832-4805-afff-0def0e592559', '4564', '0');
INSERT INTO `imgs_and_info` VALUES ('cf575330-320b-4e78-a2cb-d0b62b10b7cf', '1', '1', '2016-08-29 21:00:27', '2016-08-29 21:00:27', '2016-08-29 21:02:32', 'cf575330-320b-4e78-a2cb-d0b62b10b7cf', '4564', '0');
INSERT INTO `imgs_and_info` VALUES ('d24e093a-eeea-4e70-821d-65c0c5b43f1c', '1', '0', '2016-08-31 14:49:32', '2016-08-31 14:49:32', null, 'd24e093a-eeea-4e70-821d-65c0c5b43f1c', 'ff2e7b90-a561-4eb7-81ec-de5d15e8ce06', '0');
INSERT INTO `imgs_and_info` VALUES ('d48cbe5b-5fb5-4521-8024-ec7835ae8871', '1', '1', '2016-08-29 22:54:17', '2016-08-29 22:54:17', '2016-08-29 23:05:41', 'd48cbe5b-5fb5-4521-8024-ec7835ae8871', 'cbf9590f-f398-46eb-aab7-5b40430e0d20', '0');
INSERT INTO `imgs_and_info` VALUES ('ea5864de-7c89-4999-93db-27fc77f453e6', '1', '1', '2016-08-29 22:01:07', '2016-08-29 22:01:07', '2016-08-29 22:06:53', 'ea5864de-7c89-4999-93db-27fc77f453e6', 'dfe7a442-3839-47b3-939d-6df3ecb7a7e9', '0');
INSERT INTO `imgs_and_info` VALUES ('f19e47aa-1ae2-4303-a16b-3ba53cf8acad', '1', '1', '2016-08-29 23:18:02', '2016-08-29 23:18:02', '2016-08-29 23:18:04', 'f19e47aa-1ae2-4303-a16b-3ba53cf8acad', '982abff7-ffd0-45d7-af86-61701348ce5e', '0');
INSERT INTO `imgs_and_info` VALUES ('f7e105d7-f900-4250-9b5a-ec13ad240fd7', '1', '1', '2016-08-29 22:01:13', '2016-08-29 22:01:13', '2016-08-29 22:06:51', 'f7e105d7-f900-4250-9b5a-ec13ad240fd7', 'dfe7a442-3839-47b3-939d-6df3ecb7a7e9', '0');
INSERT INTO `imgs_and_info` VALUES ('fdbf27fb-850e-4f2d-8483-0731a7a0e2bb', '1', '1', '2016-08-29 23:00:22', '2016-08-29 23:00:22', '2016-08-29 23:05:39', 'fdbf27fb-850e-4f2d-8483-0731a7a0e2bb', 'cbf9590f-f398-46eb-aab7-5b40430e0d20', '0');
INSERT INTO `imgs_and_info` VALUES ('ff1349cc-c7f0-4897-a965-63ba4c881438', '1', '1', '2016-08-30 13:31:58', '2016-08-30 13:31:58', '2016-08-30 14:25:50', 'ff1349cc-c7f0-4897-a965-63ba4c881438', '982abff7-ffd0-45d7-af86-61701348ce5e', '0');
INSERT INTO `imgs_and_info` VALUES ('ff5d94a4-5b63-4c2e-bba3-f2adb2029dd3', '1', '0', '2016-08-30 12:47:02', '2016-08-30 12:47:02', null, 'ff5d94a4-5b63-4c2e-bba3-f2adb2029dd3', 'dfe7a442-3839-47b3-939d-6df3ecb7a7e9', '1');
INSERT INTO `imgs_and_info` VALUES ('fffcc214-9871-4fc4-bab9-c5bfbe092f0d', '1', '1', '2016-08-30 13:31:47', '2016-08-30 13:31:47', '2016-08-30 13:31:52', 'fffcc214-9871-4fc4-bab9-c5bfbe092f0d', '982abff7-ffd0-45d7-af86-61701348ce5e', '0');

-- ----------------------------
-- Table structure for menutree
-- ----------------------------
DROP TABLE IF EXISTS `menutree`;
CREATE TABLE `menutree` (
  `id` varchar(36) NOT NULL,
  `iconCls` varchar(50) DEFAULT NULL,
  `text` varchar(100) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parentId` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKDC11C17D9E7AE967` (`parentId`),
  CONSTRAINT `menutree_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `menutree` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menutree
-- ----------------------------
INSERT INTO `menutree` VALUES ('gggl', null, '公告管理', '/back/sys/jsps/gggl.jsp', 'qt');
INSERT INTO `menutree` VALUES ('glydlrz', null, '管理员登录日志', '/back/adm/jsps/glydlrz.jsp', 'rzgl');
INSERT INTO `menutree` VALUES ('gwcygl', null, '官网成员管理', '/back/officialwebsite/jsps/members.jsp', 'gwywgl');
INSERT INTO `menutree` VALUES ('gwlbgl', null, '官网轮播管理', '/back/officialwebsite/jsps/aboutUs.jsp', 'gwywgl');
INSERT INTO `menutree` VALUES ('gwlxwmgl', null, '官网用户意见管理', '/back/officialwebsite/jsps/contactUs.jsp', 'gwywgl');
INSERT INTO `menutree` VALUES ('gwxwgl', null, '官网新闻管理', '/back/officialwebsite/jsps/news.jsp', 'gwywgl');
INSERT INTO `menutree` VALUES ('gwywgkgl', null, '官网业务管理', '/back/officialwebsite/jsps/service.jsp', 'gwywgl');
INSERT INTO `menutree` VALUES ('gwywgl', '', '官网业务管理', '', 'root');
INSERT INTO `menutree` VALUES ('qt', null, '其他', null, 'root');
INSERT INTO `menutree` VALUES ('qxgl', null, '权限管理', '/back/adm/jsps/qxgl.jsp', 'xtgl');
INSERT INTO `menutree` VALUES ('qxglrz', null, '权限管理日志', '/back/adm/jsps/qxglrz.jsp', 'rzgl');
INSERT INTO `menutree` VALUES ('root', null, '首页', null, null);
INSERT INTO `menutree` VALUES ('rzgl', null, '日志管理', null, 'root');
INSERT INTO `menutree` VALUES ('xtgl', null, '系统管理', null, 'root');

-- ----------------------------
-- Table structure for notices
-- ----------------------------
DROP TABLE IF EXISTS `notices`;
CREATE TABLE `notices` (
  `id` varchar(36) NOT NULL,
  `creatAdminId` varchar(36) NOT NULL,
  `title` varchar(255) NOT NULL,
  `text` text NOT NULL,
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  `status` int(10) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `forkey_amdinId` (`creatAdminId`),
  CONSTRAINT `notices_ibfk_1` FOREIGN KEY (`creatAdminId`) REFERENCES `admins` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notices
-- ----------------------------
INSERT INTO `notices` VALUES ('016e1f81-e064-4634-b6aa-7eb73b99e453', '1138829222', '“持续刷新公告测试”公告一', '“持续刷新公告测试”公告一', '2016-07-24 19:59:43', '2016-07-24 19:59:43', '1', '1');
INSERT INTO `notices` VALUES ('0534297a-11e7-43b8-8a4c-cbc2be17955a', '1138829222', '123', '123', '2016-07-09 21:03:34', '2016-07-09 21:03:34', '1', '1');
INSERT INTO `notices` VALUES ('12313', '1138829222', '正式公告', '好无聊，就是想发一条公告。。。。', '2016-07-07 14:28:59', '2016-08-03 15:51:28', '1', '0');
INSERT INTO `notices` VALUES ('1886bd18-52a1-4fdc-a957-83fc3682ebb9', '1138829222', ' aa', 'aa', '2016-07-24 20:00:12', '2016-07-24 20:00:12', '1', '1');
INSERT INTO `notices` VALUES ('1accd965-4fa1-4fc9-a6e7-1996baf53260', '1138829222', '1231', '123', '2016-07-09 21:04:56', '2016-07-09 21:04:56', '0', '1');
INSERT INTO `notices` VALUES ('443f4069-73fd-442a-81e9-6ee8a74b07a1', '1138829222', '关于“官网后台管理模块”的制作阶段报告一', '开始制作“官网后台管理模块”', '2016-07-24 19:47:42', '2016-07-24 19:47:42', '1', '0');
INSERT INTO `notices` VALUES ('704b1696-5278-4a6b-88aa-a56b0654ee2e', '1138829222', '学车公告', '寡人去学车了', '2016-07-19 11:42:40', '2016-07-19 11:43:01', '1', '0');
INSERT INTO `notices` VALUES ('7488f650-ed03-4805-8306-9e623c641ca6', '1138829222', '系统管理模块进度公告', '系统管理模块基本完成，目前尚有“首页推荐模块”等待开发。', '2016-07-08 14:23:40', '2016-07-08 14:23:40', '1', '0');
INSERT INTO `notices` VALUES ('7cf77f83-f987-45a6-bf1d-2d251a8f68e7', '1138829222', '', '', '2016-09-07 14:19:29', '2016-09-07 14:19:29', '1', '1');
INSERT INTO `notices` VALUES ('7e37e24a-81c2-4b98-b605-87c9c0e87216', '1138829222', '关于公告管理模块进度的公告', '公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，公告模块做完啦，', '2016-07-07 16:52:52', '2016-07-07 16:52:52', '1', '0');
INSERT INTO `notices` VALUES ('83001ba5-94ab-49c8-aaff-486b8667a2dc', '1138829222', 'sad', 'asdad', '2016-07-24 22:47:41', '2016-07-24 22:47:41', '1', '1');
INSERT INTO `notices` VALUES ('839cd166-10a6-4637-a1c8-5e0630fd4b62', '1138829222', '对“汽车费用”模块的报告', '“汽车费用”模块已经完成。', '2016-07-11 00:26:43', '2016-07-11 00:29:02', '1', '0');
INSERT INTO `notices` VALUES ('99e9dbc8-b042-4bcd-b060-38781defe12f', '1138829222', '对“主页汽车推荐模块”进度的报告', '开始制作“主页汽车推荐模块”', '2016-07-09 15:29:50', '2016-07-09 15:29:50', '1', '0');
INSERT INTO `notices` VALUES ('9e6c7469-27b7-448e-a9e1-449e006c9d7b', '1138829222', 'st测试公告系统', '测试内容：添加公告\r\n', '2016-09-07 14:07:21', '2016-09-08 23:10:36', '1', '0');
INSERT INTO `notices` VALUES ('a58eed5a-bf37-4fba-9856-211d21ca841c', '1138829222', '“持续刷新公告测试”公告一', '测试中。。。。', '2016-07-24 19:58:57', '2016-07-24 19:58:57', '1', '1');
INSERT INTO `notices` VALUES ('afd352e2-49dd-44c4-a2b0-6c22b09f1fa6', '1138829222', 'jk', 'jkl', '2016-07-24 20:01:31', '2016-07-24 20:01:31', '1', '1');
INSERT INTO `notices` VALUES ('c175261c-1f2b-4ec8-93d1-fd3b266954be', '987654', '测试管理员的公告', '测试管理员的公告', '2016-07-12 13:45:24', '2016-09-07 14:06:53', '1', '0');
INSERT INTO `notices` VALUES ('d7bf0986-1494-4b8a-bc77-a76dbb94e6a1', '1138829222', '关于系统管理模块中“首页推荐模块”的进度', '“首页推荐模块”的进度开始制作。', '2016-07-08 14:24:52', '2016-07-08 14:24:52', '1', '0');
INSERT INTO `notices` VALUES ('dde64156-d5f1-4515-b303-37c49624dbe7', '1138829222', '有关公告模块功能的公告', '母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀母鸡呀', '2016-07-07 15:54:18', '2016-07-07 15:54:18', '1', '0');
INSERT INTO `notices` VALUES ('e1a83355-34c8-49bb-8459-0eee1d1962ca', '1138829222', '关于汽车业务管理模块中“首页汽车推荐模块”的进度报告', '“首页汽车推荐模块“已经实现。', '2016-07-09 21:02:58', '2016-07-09 21:02:58', '1', '0');

-- ----------------------------
-- Table structure for officialwebsite_about_us
-- ----------------------------
DROP TABLE IF EXISTS `officialwebsite_about_us`;
CREATE TABLE `officialwebsite_about_us` (
  `id` varchar(36) NOT NULL,
  `status` int(1) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  `deleteTime` datetime DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `imgName` varchar(255) NOT NULL COMMENT '轮播图片文件的name;eg:20144206232.png',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of officialwebsite_about_us
-- ----------------------------
INSERT INTO `officialwebsite_about_us` VALUES ('111', '1', '0', '2016-08-18 10:05:52', '2016-08-22 18:44:00', '2016-08-18 10:12:30', 'Look!Our house!', '111.jpeg');
INSERT INTO `officialwebsite_about_us` VALUES ('12', '1', '0', '2016-08-18 10:05:52', '2016-08-22 18:43:37', null, 'This is a town.', '12.jpeg');
INSERT INTO `officialwebsite_about_us` VALUES ('15bc21a7-8886-4cc5-bf11-06886fb12f6f', '1', '1', '2016-08-18 14:34:12', '2016-08-18 14:34:12', null, '', '15bc21a7-8886-4cc5-bf11-06886fb12f6f.vnd.openxmlformats-officedocument.wordprocessingml.document');
INSERT INTO `officialwebsite_about_us` VALUES ('3fa78479-32ea-4ecc-8398-6351e219a47b', '1', '1', '2016-08-18 14:26:18', '2016-08-18 14:26:18', null, '', '3fa78479-32ea-4ecc-8398-6351e219a47b.vnd.openxmlformats-officedocument.wordprocessingml.document');
INSERT INTO `officialwebsite_about_us` VALUES ('41175b29-7246-45a5-8cbe-72fae6eb9b93', '1', '1', '2016-08-18 14:38:20', '2016-08-18 14:46:00', null, '', '41175b29-7246-45a5-8cbe-72fae6eb9b93.vnd.openxmlformats-officedocument.wordprocessingml.document');
INSERT INTO `officialwebsite_about_us` VALUES ('51c41228-1828-413a-bbc4-a3bb3b02718f', '1', '1', '2016-08-18 19:50:27', '2016-08-18 19:50:27', null, '', '51c41228-1828-413a-bbc4-a3bb3b02718f.vnd.openxmlformats-officedocument.wordprocessingml.document');
INSERT INTO `officialwebsite_about_us` VALUES ('6f86f4d9-7c3a-4104-8d02-097622dbd7ea', '1', '1', '2016-08-18 14:37:21', '2016-08-18 14:37:21', null, '', '6f86f4d9-7c3a-4104-8d02-097622dbd7ea.vnd.openxmlformats-officedocument.wordprocessingml.document');
INSERT INTO `officialwebsite_about_us` VALUES ('838b0093-4506-4b72-acc9-3aebed4835a9', '1', '1', '2016-08-18 14:22:21', '2016-08-18 14:22:21', null, '', '838b0093-4506-4b72-acc9-3aebed4835a9.vnd.openxmlformats-officedocument.wordprocessingml.document');
INSERT INTO `officialwebsite_about_us` VALUES ('b7e70c1f-592a-4d64-9086-d71c124c9bb3', '1', '0', '2016-08-29 20:24:24', '2016-08-29 20:24:24', null, '456', 'b7e70c1f-592a-4d64-9086-d71c124c9bb3.jpeg');
INSERT INTO `officialwebsite_about_us` VALUES ('c12f51b1-16a2-4848-b507-9e227342917c', '1', '1', '2016-08-18 20:17:15', '2016-08-18 20:17:15', null, '', 'c12f51b1-16a2-4848-b507-9e227342917c.vnd.openxmlformats-officedocument.wordprocessingml.document');
INSERT INTO `officialwebsite_about_us` VALUES ('e82fb548-a4af-4697-a150-a25cc3d0c394', '1', '0', '2016-08-18 14:21:36', '2016-08-22 18:44:07', null, 'This is red feild.', 'e82fb548-a4af-4697-a150-a25cc3d0c394.jpeg');

-- ----------------------------
-- Table structure for officialwebsite_contact_us
-- ----------------------------
DROP TABLE IF EXISTS `officialwebsite_contact_us`;
CREATE TABLE `officialwebsite_contact_us` (
  `id` varchar(36) NOT NULL,
  `status` int(1) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  `deleteTime` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `orgName` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phoneNumber` varchar(25) NOT NULL,
  `msg` varchar(255) NOT NULL,
  `adminNote` text COMMENT '管理员的备注',
  `dealAdminId` varchar(36) DEFAULT NULL COMMENT '处理该意见的管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of officialwebsite_contact_us
-- ----------------------------
INSERT INTO `officialwebsite_contact_us` VALUES ('0ac37d38-aa9c-44e8-baea-f9cc1ba1351c', '2', '0', '2016-08-29 13:09:36', '2016-08-29 13:09:36', null, 'zk', '156456', '1138829222@qq.com', '13890357807', '你是猪吗', 'ok', '123456');
INSERT INTO `officialwebsite_contact_us` VALUES ('2497d591-ebeb-4b3c-b3b2-93fe805f4a0d', '0', '0', '2016-08-24 20:58:42', '2016-08-24 20:58:42', null, 'ZHANG', 'JISHOUDAXUE', '1138829222@QQ.COM', '13890357807', '不给你了', null, null);
INSERT INTO `officialwebsite_contact_us` VALUES ('3a0eb042-cb7f-478a-bf11-16f8e5ef1471', '0', '0', '2016-08-30 22:35:58', '2016-08-30 22:35:58', null, '张乐', '韩国', '1138829222@qq.com', '13890357807', '在？', null, null);
INSERT INTO `officialwebsite_contact_us` VALUES ('46a674ab-2116-4f82-b78c-3c9bf13a6e2d', '0', '0', '2016-08-30 20:31:11', '2016-08-30 20:31:11', null, '张可', '吉首大学', '1138829222@qq.com', '18874490135', '你好呀', null, null);
INSERT INTO `officialwebsite_contact_us` VALUES ('52f608fe-1a50-446c-bc9d-197f47a3d950', '0', '0', '2016-09-07 21:19:47', '2016-09-07 21:19:47', null, 'zk', 'js', '1138829222@qq.com', '18874490135', '啊啊啊啊啊', null, null);
INSERT INTO `officialwebsite_contact_us` VALUES ('d573acab-b115-489d-94c6-43f579e0b8a7', '2', '0', '2016-08-24 21:00:18', '2016-08-24 21:00:18', null, '张大可', '吉首大学', '1138829222@qq.com', '13890357807', '只是一条留言而已！', '6666', '1138829222');
INSERT INTO `officialwebsite_contact_us` VALUES ('dd6a910c-f562-41f7-be75-49437ceacfb6', '0', '0', '2016-08-24 20:38:50', '2016-08-24 20:38:50', null, '张可', '吉首大学', '1138829222@qq.com', '13890357807', ' /* 防止被选中 */\r  -moz-user-select: none;\r  -webkit-user-select: none;\r  -ms-user-select: none;\r  -khtml-user-select: none;\r  user-select: none;\r  /* 去除点击后的虚线边框 */\r  outline: none;', null, null);
INSERT INTO `officialwebsite_contact_us` VALUES ('f0da685e-f583-451b-8de6-f8c0fd044c8f', '2', '0', '2016-08-24 21:15:28', '2016-08-24 21:15:28', null, 'ZHANGKE4 ', '46', '11388292222@qq.com', '13890357807', '154654', '', '1138829222');

-- ----------------------------
-- Table structure for officialwebsite_members
-- ----------------------------
DROP TABLE IF EXISTS `officialwebsite_members`;
CREATE TABLE `officialwebsite_members` (
  `id` varchar(36) NOT NULL,
  `status` int(1) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  `deleteTime` datetime DEFAULT NULL,
  `head` varchar(255) NOT NULL COMMENT '头像',
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL COMMENT '该字段的约束存在于systemddl中',
  `position` varchar(255) NOT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `birthday` date NOT NULL,
  `nation` varchar(255) DEFAULT NULL COMMENT '该字段的约束存在于systemddl中',
  `province` varchar(255) DEFAULT NULL,
  `faith` varchar(255) DEFAULT NULL COMMENT '该字段的约束存在于systemddl中',
  `language` varchar(255) DEFAULT NULL COMMENT '该字段的约束存在于systemddl中',
  `qq` varchar(15) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `joinTime` date NOT NULL,
  `outTime` date DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `lastGraduateSchool` varchar(255) DEFAULT NULL COMMENT '最后就读毕业的学校',
  `membersStatus` varchar(255) NOT NULL COMMENT '在职，离职，休假等',
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of officialwebsite_members
-- ----------------------------
INSERT INTO `officialwebsite_members` VALUES ('45646', '1', '0', '2016-08-18 20:27:46', '2016-08-28 22:55:55', null, '45646.jpeg', '张可', '男', '在校学生', '我是良民，我是良民，我是良民。重要的事说三遍！', '21', '1995-12-17', '中国', '四川', '无神论', '中文', '1138829222', '1138829222@qq.com', '18874490135', '2016-08-22', '2016-08-22', '大学', '彭山二中', '在职', '');
INSERT INTO `officialwebsite_members` VALUES ('61fe7f0e-1ac6-442f-88ba-dbcb01618e1a', '1', '0', '2016-08-18 21:27:22', '2016-08-22 11:51:26', null, '61fe7f0e-1ac6-442f-88ba-dbcb01618e1a.jpeg', '可可西里', '', 'NICAI 我不会告诉你飞得', '我不会告诉你飞哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧', '1', '2016-08-17', '', null, '', '', '', '', '', '2016-08-30', null, '', '', '', '');
INSERT INTO `officialwebsite_members` VALUES ('6ded79d7-5b67-4b36-bbe6-49dc20f234fb', '1', '0', '2016-08-19 15:52:34', '2016-08-25 13:24:33', null, '6ded79d7-5b67-4b36-bbe6-49dc20f234fb.jpeg', '程序员甲', '', '教练', '你才哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧', '99', '2016-08-19', '', null, '', '', '', '', '', '2016-08-01', '2016-08-23', '', '', '', '');
INSERT INTO `officialwebsite_members` VALUES ('c9f8ee6c-568b-414e-ab28-2534c825b302', '1', '1', '2016-08-22 10:43:11', '2016-09-07 21:16:44', null, 'c9f8ee6c-568b-414e-ab28-2534c825b302.jpeg', '789', '男', '5453', '5346', '7', '2016-08-24', '大不列颠及北爱尔兰联合王国', null, '无神论', '英文', '1138829222', '阿斯达', '56546', '2016-08-23', '2016-08-23', '小学', '45', '在职', '阿斯达');
INSERT INTO `officialwebsite_members` VALUES ('d344badf-e8d0-44c0-b906-67adb91b04db', '1', '0', '2016-08-21 14:57:40', '2016-09-07 18:58:39', null, 'd344badf-e8d0-44c0-b906-67adb91b04db.jpeg', '苏轼', '男', '宋朝首席文学家', '苏轼（1037年1月8日—1101年8月24日），字子瞻，又字和仲，号东坡居士，世称苏东坡、苏仙。汉族，北宋眉州眉山（今属四川省眉山市）人，祖籍河北栾城，北宋著名文学家、书法家、画家。嘉祐二年（1057年），苏轼进士及第。', '58', '2016-08-09', '大不列颠及北爱尔兰联合王国', null, '佛教', '中文', '1138829222', '1138829222@qq.com', '18874490135', '2016-08-03', '2016-08-22', '小学', '四川大学', '在职', '很好');
INSERT INTO `officialwebsite_members` VALUES ('d5469668-46be-4d10-9fa3-139c897732d6', '1', '0', '2016-08-18 21:30:24', '2016-08-22 11:51:12', null, 'd5469668-46be-4d10-9fa3-139c897732d6.jpeg', '老习', '', '主席', '你猜猜看哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧', '99', '2016-08-17', '', null, '', '', '', '', '', '2016-08-03', null, '', '', '', '');
INSERT INTO `officialwebsite_members` VALUES ('e0a5b138-6fee-4eeb-94be-5b416c441bfe', '1', '0', '2016-08-21 12:00:59', '2016-08-22 11:49:47', null, 'e0a5b138-6fee-4eeb-94be-5b416c441bfe.png', '123', '', '12', '哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧', '45', '2016-08-18', '', null, '', '', '', '', '', '2016-08-18', '2016-08-31', '', '', '', '');
INSERT INTO `officialwebsite_members` VALUES ('ee2741b9-c8f8-4485-8f09-bde0f27ff990', '1', '0', '2016-08-21 12:07:38', '2016-09-08 23:08:25', null, 'ee2741b9-c8f8-4485-8f09-bde0f27ff990.jpeg', '库克', '男', 'CEO', '哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧哈哈，猜不到吧', '17', '2016-08-15', '大不列颠及北爱尔兰联合王国', null, '佛教', '英文', '1138829222', '1138829222@qq.com', '13890357807', '2016-08-09', '2016-09-08', '小学', '北京大学', '在职', '北京大学毕业生');

-- ----------------------------
-- Table structure for officialwebsite_news
-- ----------------------------
DROP TABLE IF EXISTS `officialwebsite_news`;
CREATE TABLE `officialwebsite_news` (
  `id` varchar(36) NOT NULL,
  `status` int(1) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  `deleteTime` datetime DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `text` text NOT NULL,
  `authour` varchar(255) NOT NULL,
  `releaseTime` datetime NOT NULL,
  `clazz` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of officialwebsite_news
-- ----------------------------
INSERT INTO `officialwebsite_news` VALUES ('0bb70bb8-78de-4b17-bcba-17bf5ec0d3ab', '1', '0', '2016-08-30 13:55:50', '2016-08-30 13:55:50', null, '媒关注大陆“千人计划”：最顶尖人才没回国', ' 原标题：媒体关注“千人计划”：取得一定成功 最顶尖人才没回国\r \r 　　参考消息网8月29日报道台媒称，大陆近年来力推的“千人计划”，是否能终结人才外流？美媒报道称，“千人计划”确实令人心动，有人一回国就拿到150万美元的科研经费，“在美国根本不可能，因为美国经费是跟着项目而不是跟着人走”；但也有论者认为，千人计划吸引的人才虽然比土博士好，最顶尖的却还没回国。\r \r 　　据台湾《旺报》网站8月23日援引美联社报道称，美国密歇根大学年轻生物科研学者陈晓伟，原以为会在密歇根州的美丽小镇心满意足终老，但北京大学的慷慨邀请令他盛情难却。北京大学承诺的科研启动资金，让他可以研究自己最感兴趣的课题，这在美国简直无法想像。2014年他带着妻儿回到北京。\r \r 　　陈晓伟是大陆“千人计划”回国的海归之一。如今海外的中国留学生数量剧增，仅2014至2015学年度，就有30多万名中国留学生赴美，其中最抢手的高学历、经验丰富的理工科留学生流失严重。一项调查显示，2006年在美国大学取得理工科博士学位的4121名中国留学生，有85%毕业后5年仍选择留在美国。\r \r 　　报道称，为了终结人才外流，2008年大陆启动“千人计划”。与在中国本土接受教育的科研人员收入相比，“千人计划”提供的薪资高出好几倍，还提供子女教育津贴及科研启动资金，单是签约奖金就高达15万美元。至今“千人计划”已成功吸引6000余名尖端人才回国，类似的省市级人才引进计划也如雨后春笋般不断涌现。\r \r 　　目前回国的高端海归包括：美国普渡大学神经学家、北京大学生命科学学院副院长李沉简，他在北大开设一门《批判性思维》课程，并改革大学录取模式，取代分数定终身的高考制度。诺奖得主屠呦呦的“伯乐”、美国西北大学神经生物学家饶毅回国后，任职于北京大学。当年早已功成名就的普林斯顿大学分子生物学教授施一公，现在则是北京清华大学副校长。\r \r 　　报道称，也有人质疑“千人计划”人才并非最优秀。香港科技大学中国跨国关系研究中心主任David Zweig研究中国高端人才引进策略已有25年，他给美联社的一封邮件里提到：“我认为千人计划取得了一定的成功，从海外招募而来的全职人员普遍优于本土人才，不过最优秀的人才尚未回到中国。”', '责任编辑：肖武岗 UN845', '2016-08-30 13:55:50', '公告');
INSERT INTO `officialwebsite_news` VALUES ('445cd7c5-ee30-4229-b339-555768a593cc', '1', '0', '2016-08-30 13:56:04', '2016-08-30 13:56:04', null, '日本承诺将援非300亿美元 被指花钱买“入常”', '　8月28日，肯尼亚内罗毕，日本首相安倍晋三与肯尼亚总统肯雅塔在第六届非洲发展东京国际会议最后一天举行联合新闻发布会。图/视觉中国\r \r 　　当地时间28日，出席第六届非洲发展东京国际会议的日本首相安倍晋三承诺，从今年起至2018年，日本将向非洲各国提供300亿美元的援助，重点支持非洲的基础设施建设。\r \r 　　这并非日本首次承诺援助非洲上百亿美元的资金。外界普遍认为，日本这几年深耕非洲，此次又加大对非洲的援助力度，旨在拉拢数量众多的非洲国家，支持其完成“入常”梦。承诺\r \r 　　安倍承诺3年援助300亿美元\r \r 　　上周末，日本首相安倍晋三给自己加了个班，出席在肯尼亚内罗毕举行的第六届非洲发展东京国际会议（以下简称“日非峰会”）。安倍在会上送出“大礼包”。他表示，日本将在今后三年内向非洲提供300亿美元的援助，其中东京方面承诺投资100亿美元用于非洲的基础设施项目。如果加上私人领域的投资，预计资金总额将达到300亿美元。\r \r 　　日非峰会由日本主导，1993年在日本东京举办首届会议以来，逐渐成为日本的对非外交支柱。今年是日非峰会首次在非洲举办，会期也打破了此前每5年举行一次的惯例，今年起改为每3年举行一次，足见日本对非洲热情升温。\r \r 　　长期以来，日本一直试图加强与非洲联系，拓展获得非洲自然资源渠道。上世纪60年代，日本开始向非洲国家提供援助。石油危机爆发后，日本愈加重视石油资源丰富的非洲，逐渐增加对非洲国家的援助。上世纪90年代初，日本一度成为仅次于法国的非洲第二大援助国。\r \r 　　“日本对于非洲的追逐可以大概分为两个阶段”，外交学院日本问题专家周永生告诉新京报记者，日本初入非洲时曾遭遇水土不服，讲究纪律性的日本人发现在非洲投资建厂很困难，非洲人甚至无法每天按时上下班，造成企业效率低下，日本曾想放弃非洲。\r \r 　　不过在进入新世纪后，日本想“入常”，才重新认识非洲的价值。周永生表示，非洲有54个联合国成员，是联合国一国一票政治中不可忽视的“票仓”，日本政府对此非常重视，安倍此行是为日本赢得非洲支持挤进安理会常任理事国做长远打算。\r \r 　　援助\r \r 　　技术支持和官方开发援助并行\r \r 　　《纽约时报》2014年在题为“安倍承诺慷慨援助与中国竞争非洲”的文章中指出，中国自2000年以来为非洲提供数百亿美元的发展援助资金，无法达到中国的援助水平的日本希望通过其他方式缩小差距。其一便是援助训练非洲的工程师和技术人员，以便将日本支援举措与中国项目区分开来。\r \r 　　“中国非洲政策有声有色，因此日本外交政策就是瞄准中国，中国在哪里推进，日本就会紧随其后，与中国竞争，或给中国搅局，尽可能联合一些当地国家，抑制中国政策，在非洲正是如此。”周永生说。\r \r 　　为达到这个目的，日本煞费苦心。据日本贸易振兴机构等介绍，约有400家日企由此进驻非洲，多是在2011年以后进入的。以往日本与非洲各国的关系主要是进口原油等资源，如今日本更加注重发掘非洲市场。\r \r 　　虽然在资金规模上与中国有差距，但日本在非洲的一些项目确实引人关注。周永生举例说，日本二手汽车很多，在国内卖不值钱，因此直接送给非洲，这是一种策略，非洲人很喜欢这种二手车，因此会一直使用日本汽车零件，日本厂商又可以从中获利。日本将这一策略“发扬光大”，应用在很多其他地区的不发达国家上。\r \r 　　另外一个成功模式就是ODA（官方开发援助）。周永生指出，客观来讲，日本对非洲进行ODA援助，确实赢得了一些国家的支持，比如走“基层路线”，给部落建水井和下水道等基础设施，工作做得很细致，很容易和当地民众拉近感情，赢得了当地民众的好评。\r \r 　　与此同时，日本还许诺加大对非洲的资金投入。早在2013年的第五届日非峰会上，日本就已承诺在5年内向非洲提供320亿美元，安倍表示这些资金中的67%已被用于多个项目。\r \r 　　专家\r \r 　　日本通过援助难实现“入常”梦\r \r 　　日本为啥要不惜一切代价援助非洲呢？答案在于两个字：入常。\r \r 　　在2005年的联合国大会上，当时由日本、德国、巴西和印度组成的四国集团（G4）提出，增加六个常任理事国、其中两个从非洲联盟（AU）成员国中选出。但围绕否决权与AU产生分歧，该方案最终遭到废止。\r \r 　　但日本并未就此放弃梦寐以求的“入常”目标。正如安倍在本次会议上鼓吹，联合国安理会改革是日本与非洲的共同目标。\r \r 　　日本是否能最终如愿以偿成功“入常”？\r \r 　　周永生对此指出，日本对非策略确实取得一定成效，通过多年与非洲拉关系，已经建立起人脉，日本外交官和企业家特别有社会活动能力，在非洲社会各阶层都拉到很多关系。\r \r 　　“但即便非洲国家全票同意其‘入常’，只要中国不同意，日本也无法如愿。因为如果日本达成‘入常’目标，必须要修改联合国宪章，而常任理事国对此有一票否决权。这是日本过不去的一道坎。”周永生说。\r \r 　　即便如此，日本为何仍要继续在非洲大把“撒钱”？周永生指出，日本这么做主要是为了造势，因为日本方面有观点认为，如果大部分国家都支持日本入常，中国会因为国际压力不再反对。\r \r 　　此外，因为日本国力有限，通过援助换支持的前景有限。周永生强调，日本政府现在很缺钱，公共债务负担已经达到GDP的240%。安倍此次许诺300亿美元很大一部分需要依靠企业投资，但日企不会听政府安排，企业要追求盈利，没有盈利的话是不会投资的。\r \r 　　背景\r \r 　　前五次日非峰会都谈了啥？\r \r 　　1993年10月\r \r 　　●日本东京\r \r 　　日本承诺增加对非洲的援助，大会通过了“非洲发展东京宣言”，承诺在非洲实施政治和经济改革，推动私营部门发展，加强地区合作和一体化。\r \r 　　1998年10月\r \r 　　●日本东京\r \r 　　大会通过了“东京行动议程”，为非洲和其发展伙伴确立了合作框架，日本重申对非洲的援助，非洲则承诺减少贫困并融入到全球经济中。\r \r 　　2003年9月\r \r 　　●日本东京\r \r 　　会议通过了“非洲发展东京国际会议10周年宣言”，明确支持非盟制定的“非洲发展伙伴关系计划”，日本也再次重申了对非洲发展的支持。\r \r 　　2008年5月\r \r 　　●日本横滨\r \r 　　时任日本首相福田康夫宣布，日本将在2012年前实现对非洲国家的政府开发援助（ODA）翻番，无偿资金合作和技术合作增加1倍。\r \r 　　2013年6月\r \r 　　●日本横滨\r \r 　　安倍在开幕式上宣布，日本政府将在今后5年向非洲提供1.4万亿日元的官方开发援助资金，加上民间的投资资金，总额将达到3.2万亿日元。', '本版采写/新京报记者 王晓枫', '2016-08-30 13:56:04', '公告');
INSERT INTO `officialwebsite_news` VALUES ('4564', '1', '0', '2016-08-25 13:42:01', '2016-08-25 13:42:04', null, '女学生“被骗死” 谁帮骗子精准行骗？', '总有一些中国故事讲起来特别让人伤感。近日，临沂市18岁的女学生徐玉玉接到骗子电话，骗子编造了入学银行卡需要验证的骗局，导致徐玉玉被骗9900元学费。在与父亲去派出所报案返回的路上，背负伤心与自责心理的姑娘心脏与呼吸骤停，经抢救无效辞世。\r  \r  　　这个事情让人倍感愤怒，却又似乎无处发泄愤恨。因为它太日常化了，中国人的电话上哪个没有骗子信息？与骗子、骗术共存，也是国人生活中必须靠自保才能获得一点安全感的现状，谁能改变？骗子导致家破人亡的每天都有，这次则因受害女孩显得尤其残忍。\r  \r  　　我们无法去责怪徐玉玉，如果她明白这个世道上骗子横行的道理，也许不会上当。我们同样无法责备的是，如果她不是出身在收入艰难的平民家庭，一万元不是一笔天文数字，她也许不用急火攻心。所有的假设都没用，徐玉玉不是第一个也不会是最后一个骗子的猎物。\r  \r  　　徐玉玉之所以轻信骗子电话，是因为之前接到过教育部门的真电话，她的全部心思放在被南京邮电大学录取的喜事上。她一个18岁的未经世事的姑娘，万万没想到，从录取的那个时候起，她的个人信息就可能被出卖，在整个录取环节，有一万个漏洞让她暴露在骗子视野中。\r  \r  　　这也是老生常谈到令人发中指却无可奈何的事情。在这个国家里，包括个人通信在内的个人信息隐私始终处于“待出售”状态，骗子团伙几乎可以轻易地获取任何特定人群的信息，而后制订相应的骗术。相较于骗子的先进性，个人信息能寄望的政府保护几乎不设防。\r  \r  　　这不是无谓的埋怨。相较于国家秘密、甚至是保密级别低得多的行政信息，都受到了非常严苛的管理，外人几乎无法获取，哪怕是以合法、正当的理由。但是在民众个人信息方面，它们一直处于被随意攫取、任意买卖、无法追责问罪的状态，反差刺目。\r  \r  　　哪怕是几大电信企业巨头，对诈骗信息的防范也是远远落后于国民期待。早就说好的实名制，在徐玉玉一案中并没有被发现，这不仅令追查有难度，也让人感觉电信运营商的首鼠两端：长于逐利，短于德行。起码，运营商应该为徐玉玉之死负上道义责任。\r  \r  　　这样看来，徐玉玉的死，面目模糊的骗子当然是直接的凶手，但在围绕她个人信息周边的那些觊觎者当中，理当担负凶手骂名的还有很多。你很难一一点名，但是你又知道这些似乎是无意中的帮凶始终存在。我们无法靠谴责结束这些乱象，正像无法保护徐玉玉那样。\r  \r  　　在徐玉玉的日记中，她说自己和姐姐从来不会为母亲身有残疾而“羞耻”，但在这姑娘如此悲惨地落入骗子的陷阱中可见，理应感到羞耻的还有很多人，以及很多大言不惭的部门，比如那种将实名制引作保护个人信息安全的托辞。而我们深知，无耻大概是骗子猖獗的结构性问题。\r  \r  　　我们也知道，单靠提倡耻感文化，是无法构建一个可信赖的个人信息保护网的。现实恰恰说明，中国那些足以致人死命的骗子其存活的土壤，早已是以无耻作为前提条件。但是在个人信息流动的行政及政府环节，问责治罪远比树立羞耻感来的重要而紧迫。', '文/蒲欣（搜狐特约评论员）', '2016-08-25 13:42:25', '公告');
INSERT INTO `officialwebsite_news` VALUES ('730a1cb7-6df6-454e-ac43-201ecfa95b67', '1', '0', '2016-08-31 19:53:52', '2016-08-31 19:53:52', null, '腾讯程武：泛娱乐探索不变的三原则', '互联网时代快速的科技革新，前所未有地促进了人类情感和想象力的释放，推动了全球文化创意产业的蓬勃发展。这导致在过去一两年里，整个资本市场开始从用户流量入口的争夺，大量转战对内容和版权的争夺。”3月25日，腾讯集团副总裁兼腾讯影业首席执行官程武在UP2016腾讯互动娱乐年度发布会开场演讲中表示。腾讯互娱在五年前就提出了“泛娱乐”概念，即基于互联网和移动互联网的多领域共生，来打造明星IP的粉丝经济，并在游戏业务的基础上相继推出动漫、文学、影视等新业务，致力构筑一个全新的泛娱乐生态。目前腾讯互娱旗下除游戏继续保持业界领先地位外，腾讯动漫也已成为中国旗舰动漫平台，阅文集团更是占据了绝对主导的产业地位，去年新成立的腾讯影业，也开始以IP为轴心，探索票房之外的更大价值。\r  \r  程武表示，在腾讯公司“连接”思维和“开放”战略下，泛娱乐也逐步成为腾讯在“互联网+文创产业”领域的发展思路。与此同时，越来越多的行业伙伴也加入到泛娱乐布局中，这使得开放、协同、共融共生的泛娱乐生态构建真正成为可能。基于此，他提出了泛娱乐时代腾讯互娱对于IP探索的三个不变原则：\r  \r  1、知名度不等于IP，IP是被市场验证的用户情感载体。优质的作品只是IP的起点，它需要经历多领域的共生，才能真正形成超越具体平台和形式的IP价值，才能有无限延展的生命力。\r  \r  2、IP价值来自共建而非交易，“先纵后横”推动IP增值。IP真正的价值在于它背后的情感，在于粉丝对于这个形象、个性与故事的热爱程度，在于它始终如粉丝所期待的样子。因此，只有在“共创、共享、共赢”的机制下，各展所长，才能共建IP的价值。\r  \r  3、活跃的IP源头是根本动力，每个人都有不可被辜负的天分。IP源于人的想象力与情感，想象力与情感不分高低贵贱，没有门第出身，只有对生活的感触与天分的流露。在泛娱乐时代里，任何普通人都可能实现梦想，都能成为IP的源头。\r  \r  以下为程武在UP2016腾讯互动娱乐年度发布会上演讲全文：\r  \r  感谢大家参加今天的发布会！\r  \r  刚才有个影视圈的朋友问我，开始做电影了，目前最大的挑战在哪里，我想了想说，最大的挑战是我这腰。前一段时间，因为腰椎病，我不得不在家躺了两周。一会儿估计还得稍坐一下，还请大家见谅。在这里也希望各位新老朋友，多注意自己的身体健康。\r  \r  在家卧床那段时间，除了看书，看漫画，看电影，就是在看Alphago和李世石的围棋大战。虽然围棋被视为人类最后的智慧堡垒，但在李世石落败后，我们真的感到恐慌吗？我发现并没有。因为我们知道，就算人工智能在逻辑与计算上超越了人类，也取代不了两样东西，那就是我们的情感与想象力。\r  \r  事实上，互联网时代快速的科技革新，不仅在催生像Alphago、自动驾驶汽车这样的人工智能，而且前所未有地促进了人类情感和想象力的释放，推动了全球文化创意产业的蓬勃发展。\r  \r  近期联合国教科文组织发布的一份报告显示，文化创意产业发展迅速，目前已经成为全球经济的支柱产业，无论是发达国家，还是新兴经济体，都将文化创意产业作为战略性资产。\r  \r  其中，以电影、游戏为代表的数字文创产业，发展更是迅猛，成为全球流行文化的重要载体。今年世界知识产权日的主题，就被定为“数字创意 重塑文化”，数字技术如何改变全球市场的文化创建、发行和消费，正受到越来越多的关注。\r  \r  具体到中国，这个全球最大的移动互联网市场，数字文创产业的发展尤为快速，2015年，我们的游戏总收入已跃居全球第一，超过1400亿。电影总票房也在今年2月达到68.7亿，首次超越北美，成为全球第一。\r  \r  再看我们的网络文学，前几天我的同事特别困扰，说网络文学几乎是中国独有，怎么都找不到全球的数据。我安慰他说，没事，找不到就对了，这本身比数据还有说服力，说明中国在这个领域有了自己的优势和创新。与此类似，中国网络动漫也正在快速崛起，背后庞大的二次元消费市场更是有目共睹。\r  \r  在这些核心产业的驱动下，中国数字文创正在形成全新的产业格局。这导致在过去一两年里，整个资本市场开始从用户流量入口的争夺，大量转战对内容和版权的争夺。这不仅推动了各垂直内容领域在体量上的增长，同时也带来了思维上的改变。所以，我们此前提出的IP概念，甚至泛娱乐的战略思路，都快速引发了行业的强烈共鸣。\r  \r  所以，回顾过往，我们感到非常庆幸，在五年之前就开始思考，如何基于互联网和移动互联网的多领域共生，来打造明星IP的粉丝经济。我记得，当时也是在这样的场合，谈我们的泛娱乐战略，然后动漫、文学、影视业务陆续上马，基本每年的年度发布会，我们的业务矩阵都在不断完善。\r  \r  在腾讯公司的“连接”思维和“开放”战略下，泛娱乐逐步成为腾讯在“互联网+文创产业”领域进行探索的基础思维，推动了业务的成长。除了游戏业务继续保持着业界领先的地位，腾讯动漫也已成为中国旗舰动漫平台，阅文集团更是占据了非常主导的产业地位，我们去年9月新成立的腾讯影业，也开始以IP为轴心，寻找电影除票房之外的更大价值。\r  \r  同时，我们也正在以作品和IP为核心，大力推动业务之间的共生共融，以及和全球范围内的广泛合作与连接，希望能逐步构建一个活跃的内容生态。\r  \r  在这个过程中，我们不仅仅收获了数据与商业上的成长，更重要的是，我们看到这种实践，正在让越来越多有天分的普通人，获得展现想象力的机会。\r  大概有十万网文创作者，在阅文旗下网站领取了人生第一笔稿费，其中不乏像唐家三少、猫腻、乱这样年入过千万的白金级作家；也有约五万漫画创作者，在腾讯动漫上创作，就像网文作者一样，他们也身份各异，有老师、学生、医生和公司高管，也有司机、保安和厨师。\r  \r  而且不知道为什么，我总感觉厨师的比例还相当高。漫画家米二，我听说原来就当过大厨，现在已经位列漫画作家富豪榜top10。再比如起点的白金作者“苍天白鹤”，原先也是一位厨师，他嫌人家的作品更新太慢，就自己动手开写，结果写成了网文圈大神级人物。所以很多朋友在调侃，想成功，应该先去当厨师。\r  \r  实际上，由互联网构建的新价值体系，正在赋予所有人更加多元、更加公平的表达空间，我想，这是泛娱乐生态背后最根本的动力。\r  \r  另一种重要的动力则来自伙伴，我一直都很感谢，有像南派三叔、像素软件这样的伙伴，跟我们一起，从零开始打造《勇者大冒险》这个IP，也很高兴，有郭敬明这样的伙伴，毫无保留地与我们一起探索《爵迹》的全平台合作。这些已经很有成就的伙伴，基于深度的产业共识，与我们走在了一起，从而让多种专业力量，能够注入到同一个IP，同一个梦想当中。\r  \r  更让人欣慰的是，我们对于IP构建的理解，正在成为行业的共识。越来越多的行业同仁也在做泛娱乐的布局与投入，共同推动数字文创产业的发展，使泛娱乐生态的构建真正成为可能。\r  \r  当然，这还仅仅是开始。最近我刚看了《疯狂动物城》，这部作品给我留下了非常深刻的印象。相比之下，中国的创意产业在作品品质的打磨上，在产业协作机制的完善等方面，还有很多不足与差距。未来的泛娱乐探索，整个行业都需要更高的自觉和更多的共识。对腾讯互娱而言，我们依然会坚持几个不变的基础原则：\r  \r  首先，泛娱乐的核心是IP，所以一定要认清楚IP到底是什么。我们认为，IP不仅仅是单一平台上高知名度的作品，而是经过市场验证的、能够凝聚用户情感的载体。优质的作品只是IP的起点，它需要经历多领域的共生，才能真正形成超越具体平台和形式的IP价值，才能有无限延展的生命力。\r  \r  其次，我们认为，IP的价值不等于交易的价格。在过去的一两年里，IP非常的热，各种交易与争夺，各种颂扬与批判。其实，IP真正的价值在于它背后的情感，在于粉丝对于这个形象、个性与故事的热爱程度，在于它始终如粉丝所期待的那个样子。一锤子买卖，只能获得短期的收益。即使高价征得了IP授权，如果没有优秀的创作能力，没有共建的意识与机制，也很难助力IP继续成长，反而会伤害IP价值。近年来，这种案例并不少见。\r  \r  只有在“共创、共享、共赢”的机制下，各展所长，才能共建IP的价值。因此，腾讯互娱会怀着最开放的态度，与伙伴共同培育IP，先在各个垂直领域纵向打造繁荣的小生态，不断输出好的作品，然后再横向联动多个内容平台，打造繁荣的大生态，通过“先纵后横”产业机制，构建具备大影响力的明星IP。\r  \r  第三个原则，是重视每个人的天分。IP源于人的想象力与情感，想象力与情感不分高低贵贱，没有门第出身，只有对生活的感触与天分的流露。所以我们看到，当年还在宿舍打游戏的大学生乱，写出了现实与网络交织的电竞故事，结果一书成名；前面提到的厨师米二，画了四五十部漫画依然无人问津的佟遥，也都因为个性化的漫画作品，成为漫画圈里的传奇人物……像这样的案例非常多。因此，我们坚信，每个人身上都有另一个梦想，每个人都有不可被辜负的天分，在泛娱乐时代里，任何普通人都可能实现梦想，都能成为IP的源头。\r  \r  我所期待的，就是在泛娱乐生态里，每个人都能释放情感，体验新奇的内容，也能尽情绽放自己的想象，缔造有趣的作品，然后，基于多领域共生，实现更大价值的释放。\r  \r  这不仅仅是一种想法和愿望。我相信，无论是动漫、文学，还是影业与游戏，大家一定能在接下来的发布中，直接感受到那些被释放的天分，和这些天分所绽放的价值。同时也能看到，越来越多有共识的伙伴，开始与我们走在一起，探索泛娱乐新的可能性。\r  \r  最后，再次感谢大家的莅临，期待与大家继续并肩同行，一起UP2016！\r  \r  \r  关于腾讯互动娱乐：\r  \r  腾讯互动娱乐，全球领先的综合互动娱乐服务品牌，旗下涵盖腾讯游戏、阅文集团（腾讯文学）、腾讯动漫、腾讯影业四个泛娱乐业务平台，为用户提供包括游戏、文学、动漫、影视等在内的多元化、高品质的互动娱乐内容体验。\r  \r  作为“泛娱乐”的提出者与有力推动者，腾讯互娱致力基于互联网与移动互联网的多领域共生，打造明星IP（知识产权，Intellectual Property）的粉丝经济，与全球伙伴一起共同构建开放、协同、共融共生的内容新生态。泛娱乐生态，让想象绽放！', 'ST工作室', '2016-08-31 19:53:52', '公告');
INSERT INTO `officialwebsite_news` VALUES ('7ba47890-520a-4fc6-9424-b0cbb4cec1af', '1', '1', '2016-09-07 21:28:56', '2016-09-07 21:28:56', null, '阿达', '请输入内容阿斯达', '阿斯达', '2016-09-07 21:28:56', '公告');
INSERT INTO `officialwebsite_news` VALUES ('83987ac6-791a-4cd3-b750-9fe528a5b43a', '1', '0', '2016-08-29 13:37:55', '2016-08-29 13:37:55', null, '担任G20轮值主席国对中国有什么好处', '虽然G20峰会9月4-5日才召开，但是杭州人民已经早早感受了峰会即将来临的气息。中国作为此次G20峰会的东道国，早已准备好迎接四方宾朋，作为目前涵盖绝大部分发达国家以及新兴经济体的国际对话机制，二十国集团对世界经济和政治都有重要的影响。作为轮值主席国，举办此次峰会到底意味着什么，有什么好处？而众多国家元首或政府首脑以及国际组织负责人来到杭州真的只是参加一次几十人参与的大会吗？\r  \r  　　作为轮值主席国，中国有哪些特权？\r  \r  　　在土耳其安塔利亚举行的第十次G20峰会上，习近平主席宣布中国杭州将举办2016年底十一次G20峰会。2016年中国开始接替土耳其担任G20轮值主席国。表面上看，轮值主席国就是在本国找个地方给各国领导人以及其他专项周边会议安排开会的，所以轮值主席国最大的工作是会务组织的工作。\r  \r  　　世界绝大部分国际组织或者对话机制都采取轮值主席机制，这一来可以体现国家平等，也可以避免一国长期负责会议组织工作而形成财政负担。如此来看的话，轮值主席国只是一种后勤工作，为什么有那么多国家要申请担任轮值主席国呢？担任轮值主席到底有什么好处？\r  \r  　　显而易见的好处是国家的国际形象和国际影响的提升，如果国际组织的轮值主席，任职期间将会处于整个组织的决策中心，负责沟通组织内部各国或地区的意见。拉脱维亚担任2015年欧盟轮值主席国，拉总理斯特劳尤马称担任轮值主席，无疑将提升国家的知名度和影响力，尤其是潜在投资人对拉的认知度。一些高端人物来访也可以让拉充分展示，拉是一个适合投资和发展的国家。\r  \r  　　而另外一个好处则是直接的——设置议题。国际组织的轮值主席有就某一项国际议题召集会议的权利，对于涉及本国利益的国际问题，这项特权显得尤为重要。2013年2月12日，朝鲜进行了第三次核试验，韩国立即以安理会轮值主席国的身份召集紧急会议，并在会后发表了强烈谴责朝鲜核试验的媒体声明。当然也有一些国家会利用这项特权搞一些小动作，夹带私货，比如日本在今年7月开始担任安理会轮值主席国，日本常驻联合国代表别所浩郎7月1日召开记者会称，若有国家提出请求，会把南海问题列为安理会讨论议题。\r  \r  　　而像G20这样影响力大的多边对话机制，其涉及的议题都是关系国际政治和国际经济发展的重大关切事务。担任轮值主席国，也就是中国所讲的“主场外交”，既可以体现本国当前对一些国际问题的立场和意见，也可以通过议题设置通过对自己有利的会议声明。比如此次G20峰会，中国就对日益抬头的贸易保护主义表示的关切。\r  \r  　　大会很重要，小会更重要\r  \r  　　二十几个国家以及国际组织的领导人大老远飞到杭州是不是就开一次峰会呢？当然不是，相较于形式大于实质的峰会，有关国家私底下召开的小会更加重要。峰会在召开之初，轮值主席国的外交人员已经就会议的相关议题以及声明性文件与各国进行过多次的磋商。领导人聚在一起也只是进行最后的收尾签字工作。当然如果分歧巨大，未能形成协议也是可能的。\r  \r  　　多边峰会所讨论更多的是原则性的议题，但是对于一些急迫的国际问题或者国际局势，相关国家之间的小会效率会更高，所以很多国家都会利用多边峰会的场合就相互关系的国际问题举行双边或多边会谈。比如美俄，叙利亚危机爆发之后，已经多次在国际大型峰会场合举行过双边会谈，成功解决了叙利亚化武危机的分歧。另外中俄两国领导人几乎每逢多边场合都会举行双边会晤，习近平和普京两人曾经有过一年内见五次的纪录。而在今年杭州G20峰会上，俄法德三国领导人也将会就乌克兰问题举行三边会谈。俄罗斯提到如果中国愿意举办，乐意参与，这也说明了东道国的另一项优势。\r  \r  　　为什么这些国家的领导人需要在多边场合举行这些会谈呢？直接原因是国际问题原来越多，也越来越复杂，但是相关国家，特别是几个大的国家和国际组织领导人之间日常会面的机会很少，利用多边场合可以方便地与相关国家领导人面谈，省去了很多领导人行程安排的麻烦。而很多的小范围会议也有相关国家弥合分歧，统一立场的作用，比如联合国气候峰会上，发展中国家就会举行小范围会议，统一立场维护发展中国家的利益。\r  \r  　　利用多边场合见平时难见的人\r  \r  　　有些领导人利用多边场合会晤是因为时间不多，而有些领导人则是因为机会不多。多边场合聚集了一大批全世界重要国家的领导人，很难在找到类似的场合能够实现外交上的突破和私人关系的加强。目前全世界有将近200多个国家和地区，很多国家和地区的领导人之间整个任期内可能都没有机会实现互访，而多边场合就提供一个很好的机会让双方可能进行外交上接触，甚至于没有外交关系的两个国家也可以利用这一场合。\r  \r  　　2015年美洲峰会期间，美国总统奥巴马与古巴总统劳尔·卡斯特罗互致问候并握手，此时的美古外交关系尚未解冻，但正朝着正常化的方向努力。而早在2013年，曼德拉葬礼上，奥巴马就历史性地与古巴领导人劳尔·卡斯特罗相遇并握手。虽然这并非一次正式的多边场合，但依然是云集了许多国家的领导人的重大事件，这并不是一次偶遇，而是刻意的安排。很多偶遇的安排造成了领导人之间各种各样的会谈形式，如走廊会谈，站着会谈，甚至日本前首相麻生太郎曾在厕所门口堵过时任中国总理温家宝。\r  \r  　　自从日本所谓“国有化”钓鱼岛之后，中日关系跌入冰点，安倍上台执政之后，两国关系不仅未见好转还更加恶化。日本国内经济团体给予安倍很多改善对华关系的压力。2013年圣彼得堡G20峰会上，安倍利用在贵宾室的等候时间与习近平偶遇，举行简短交谈。但之后的中日关系依旧无解，2014年北京APEC领导人非正式会议上，安倍想故技重施，但最终还是未能实现中日关系的解冻。\r  \r  　　对于一些即将离任的领导人，多边会议场合是个很好地与其他国家领导人告别的地方，但对于刚刚上任的领导人而言则是一个很好地亮相以及表达自己外交想法的平台。比如说奥巴马就希望利用本次G20峰会最后一次会见自己的“老朋友”印度总理莫迪，而刚刚担任应该首相的特蕾莎·梅则希望能与普京会面，改善陷入低潮的英俄关系。\r  \r  　　还有一些国家的领导人会利用多边场合“告状”，2013年G20圣彼得堡峰会上，墨西哥总统恩里克·培尼亚·涅托因为电子邮件被美国监视要找奥巴马算账。与培尼亚会面后，奥巴马承诺，将调查有关美国监视巴西和墨西哥总统的报道。\r  \r  　　9月4-5日将举行的G20杭州峰会是中国首次担任G20轮值主席国，这次峰会会形成那些对世界有重大影响的决议，还会有那些有趣的外交花絮，值得期待。', '罗布斯比尔', '2016-08-29 13:37:55', '公告');
INSERT INTO `officialwebsite_news` VALUES ('dfe7a442-3839-47b3-939d-6df3ecb7a7e9', '1', '0', '2016-08-29 13:48:36', '2016-08-29 13:48:36', null, '习近平视察战略支援部队机关', '中共中央总书记、国家主席、中央军委主席习近平今天上午视察战略支援部队机关，代表党中央和中央军委，对战略支援部队第一次党代表大会的召开表示热烈的祝贺，向战略支援部队全体指战员致以诚挚的问候。\r  \r  　　他强调，要以党在新形势下的强军目标为引领，贯彻新形势下军事战略方针，坚持政治建军、改革强军、依法治军，把握部队建设特点和规律，担负历史重任，瞄准世界一流，勇于创新超越，努力建设一支强大的现代化战略支援部队。\r  \r  　　战略支援部队是去年底按照党中央和中央军委关于深化国防和军队改革的决策部署成立的，习近平亲自向战略支援部队授予军旗并致训词。对战略支援部队，习近平高度重视、寄予厚望。上午9时30分许，习近平来到战略支援部队机关，亲切接见战略支援部队第一次党代会全体代表和机关师以上领导干部，高兴地同大家合影留念。\r  \r  　　合影结束后，习近平视察了战略支援部队某部作战指挥中心，察看作战值班情况。看到部队指挥员和值班人员训练有素、精神饱满，习近平很欣慰，勉励大家锤炼过硬指挥素质，提高作战指挥效能。\r  \r  　　随后，习近平听取了战略支援部队工作汇报，并发表重要讲话。他指出，战略支援部队是维护国家安全的新型作战力量，是我军联合作战体系的重要支撑。战略支援部队要以时不我待的精神，勇敢担负起历史重任。\r  \r  　　习近平强调，要加快战略支援部队创新发展。战略支援部队建设，最需要的是创新，根本出路在创新。要在把握规律的基础上，勇于创新思路、创新模式、创新发展，贯彻更加注重聚焦实战、更加注重创新驱动、更加注重体系建设、更加注重集约高效、更加注重军民融合的战略指导，高标准高起点推进各项建设，努力走出一条中国特色新型作战力量建设的路子。要扭住备战打仗不放松，以作战需求为牵引，制定战略支援部队发展战略和建设规划计划，加快构建新型训练体系，全面提高威慑和实战能力。要扭住深化改革不放松，确立新型作战力量建设和联合作战要求相适应的思想观念，建立科学高效的运行机制，优化部队规模结构和编成，提高各项工作科学化、规范化水平。要扭住创新驱动不放松，加快推进军事理论创新，抓住科技创新这个牛鼻子发展先进技术和装备，抓好新型作战力量和高层次科技创新人才培养，健全管理体系，提高部队建设精准度和效费比。要扭住军民融合不放松，善于在社会主义市场经济条件下发挥举国体制优势，统筹各方面力量资源，不断拓展融合深度和广度，构建一体化的国家战略能力。\r  \r  　　习近平指出，要扎实打牢战略支援部队建设的思想政治基础。做好立根固本、筑魂育人工作，教育引导广大官兵把我军政治灵魂融入血脉，强化政治意识、大局意识、核心意识、看齐意识，牢牢坚持党对军队的绝对领导，坚定不移听党的话、跟党走。要研究把握新形势下政治工作的特点和规律，创新政治工作理念、方法、手段，增强政治工作时代感和实效性，发挥政治工作强大威力。要坚持用光荣传统教育官兵、用崇高精神塑造官兵、用神圣事业感召官兵，大力培养“四有”新一代革命军人。要严肃党内政治生活，贯彻民主集中制，大兴学习之风，提高战略素养、军事素养、科技素养、创新素养，不断增强党委领导部队建设本领。要抓好“两学一做”学习教育，把全面从严治党落实到每个支部、每名党员，增强各级党组织创造力、凝聚力、战斗力。要加强纪律建设，培育新风正气，把内部风气搞得很纯正，把政治生态搞得很纯洁，凝聚推进部队建设的强大正能量。\r  \r  　　中共中央政治局委员、中央军委副主席范长龙，中共政治局委员、中央军委副主席许其亮，中央军委委员常万全、房峰辉、张阳、赵克石、张又侠、吴胜利、马晓天、魏凤和参加活动。（本文图片 李刚 拍摄）', '拿破仑波拿巴', '2016-08-29 13:48:36', '公告');
INSERT INTO `officialwebsite_news` VALUES ('f6ad6fa4-8370-48fe-bc63-365e41f1627a', '1', '0', '2016-08-30 19:49:26', '2016-08-30 19:49:26', null, '招收成员', '有意者联系：18874490xxx，期待您的加入！', 'ST工作室', '2016-08-30 19:49:26', '招募');
INSERT INTO `officialwebsite_news` VALUES ('ff2e7b90-a561-4eb7-81ec-de5d15e8ce06', '1', '0', '2016-08-31 14:48:32', '2016-08-31 14:48:32', null, '3200万中锋很高兴离开利物浦:不适应克洛普战术', '新浪体育讯　　比利时中锋本特克从利物浦转会水晶宫，3200万英镑的转会费创造了水晶宫俱乐部历史纪录。他承认，自己在红军主帅克洛普的手下不太可能打上主力，他并不适合德国人的战术体系，因此转会水晶宫、能迈出生涯新的一步令他感到高兴。\r \r 　　“加盟水晶宫对我来说是很好的一步，”本特克说，“这支队的雄心壮志也许不如利物浦那么高远，但在这里我可以发挥很好，每周都可以展示自己。这个赛季，我已经准备好了。”\r 　“水晶宫不是我唯一可选的，在别处我可以挣得更多，但我才25岁，处在关键年龄，能打比赛并提升信心对我很重要。”\r \r 　　利物浦前主帅罗杰斯将本特克从阿斯顿维拉买到红军，转会费3200万英镑，此次克洛普把他卖给水晶宫，金额恰好相同。本特克称，自己在利物浦的经历不算失败（29场9球、每168分钟1球），只是不适应教练克洛普的战术而已。\r 在国家队，与比利时队新助教亨利在一起\r \r 　　“我不认为我在利物浦的时光是一次失败经历，买我的是另一个教练（罗杰斯），如果他一直在，情况可能就不同了。”\r \r 　　“我并不适合新教练的战术体系，但我不是找借口，在有限的出场时间里，我的表现本可以更好，我的表现未达预期。教练有自己的战术系统，我并不适合，因此我需要找到一个解决办法，职业生涯中这样的事情总会发生，我并不后悔。”', '向风', '2016-08-31 14:48:32', '娱乐');

-- ----------------------------
-- Table structure for officialwebsite_service
-- ----------------------------
DROP TABLE IF EXISTS `officialwebsite_service`;
CREATE TABLE `officialwebsite_service` (
  `id` varchar(36) NOT NULL,
  `status` int(1) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  `deleteTime` datetime DEFAULT NULL,
  `releaseTime` datetime NOT NULL,
  `title` varchar(255) NOT NULL,
  `introduction` text NOT NULL,
  `clazz` varchar(255) NOT NULL COMMENT '可以是业务d额介绍，可以是j具体的每个项目公告；该字段的约束存在于systemddl中',
  `developers` varchar(255) DEFAULT NULL COMMENT '业务的主导者',
  `investor` varchar(255) DEFAULT NULL COMMENT '投资者',
  `rateOfProgress` varchar(255) DEFAULT NULL COMMENT '业务进度：0%,100%；',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of officialwebsite_service
-- ----------------------------
INSERT INTO `officialwebsite_service` VALUES ('4f71ac83-9125-4846-ae49-a101abc7bad4', '1', '0', '2016-08-29 23:11:55', '2016-08-30 13:41:31', null, '2016-08-29 23:11:55', '本工作室业务介绍', '本工作室业务有xxxxx', '业务报告', 'ST工作室', 'ST工作室', '其他');
INSERT INTO `officialwebsite_service` VALUES ('7303c72d-8820-4a3b-b23a-056fda4c45e7', '1', '1', '2016-09-07 21:34:15', '2016-09-07 21:34:32', null, '2016-09-07 21:34:15', '阿斯达', '请输入内容昂首', '项目介绍', '阿斯达', '阿斯达', '筹备');
INSERT INTO `officialwebsite_service` VALUES ('982abff7-ffd0-45d7-af86-61701348ce5e', '1', '0', '2016-08-29 23:17:53', '2016-08-31 14:52:58', null, '2016-08-29 23:17:53', '\"ST官网\"项目进度报告-0', '官网制作已经接近尾声；待完成工作：后台和前台部分美化；排除bug；等待测试。', '项目报告', '张可', 'ST工作室', '后期');
INSERT INTO `officialwebsite_service` VALUES ('b4034f39-c7f5-4afa-9bfc-955d381b7d10', '1', '0', '2016-08-31 14:52:08', '2016-09-08 23:19:32', null, '2016-08-31 14:52:08', '“ST”工作室官网项目进度报告-1', '基本实现网站语言中英文国际化，未国际化部分是：条件筛选！', '项目报告', '张可', 'ST工作室', '后期');
INSERT INTO `officialwebsite_service` VALUES ('cbf9590f-f398-46eb-aab7-5b40430e0d20', '1', '0', '2016-08-29 22:42:30', '2016-08-30 13:42:50', null, '2016-08-29 22:42:30', '“ST”工作室官网项目', '“ST”工作室官网项目正在进行，敬请期待~！', '项目介绍', '张可', 'st工作室', '其他');

-- ----------------------------
-- Table structure for powers
-- ----------------------------
DROP TABLE IF EXISTS `powers`;
CREATE TABLE `powers` (
  `id` varchar(36) NOT NULL,
  `parentId` varchar(36) DEFAULT NULL,
  `text` varchar(255) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `iconCls` varchar(255) DEFAULT NULL,
  `createTime` datetime NOT NULL,
  `status` int(1) NOT NULL COMMENT '1代表是权限，非1代表非权限（树节点）',
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `forkey_p_i_d` (`parentId`),
  CONSTRAINT `powers_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `powers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of powers
-- ----------------------------
INSERT INTO `powers` VALUES ('1000', '999', '字典管理权限', null, null, '2016-07-12 10:55:15', '0', '0');
INSERT INTO `powers` VALUES ('1001', '1000', '增加字典', null, null, '2016-07-12 10:55:33', '1', '0');
INSERT INTO `powers` VALUES ('1002', '1000', '删除字典', null, null, '2016-07-12 10:56:03', '1', '0');
INSERT INTO `powers` VALUES ('1003', '1000', '查看字典', null, null, '2016-07-12 10:56:36', '1', '0');
INSERT INTO `powers` VALUES ('1004', '1000', '修改字典', null, null, '2016-07-12 10:56:47', '1', '0');
INSERT INTO `powers` VALUES ('200', '999', '管理员权限', null, null, '2016-07-11 15:14:50', '0', '0');
INSERT INTO `powers` VALUES ('201', '200', '删除管理员', null, null, '2016-07-11 15:15:23', '1', '0');
INSERT INTO `powers` VALUES ('202', '200', '增加管理员', null, null, '2016-07-11 15:15:07', '1', '0');
INSERT INTO `powers` VALUES ('203', '200', '查看管理员', null, null, '2016-07-11 15:15:38', '1', '0');
INSERT INTO `powers` VALUES ('204', '200', '修改管理员', null, null, '2016-07-11 15:15:53', '1', '0');
INSERT INTO `powers` VALUES ('300', '999', '官网业务管理权限', null, null, '2016-07-11 15:16:57', '0', '0');
INSERT INTO `powers` VALUES ('301', '300', '查看官网业务', null, null, '2016-07-11 15:17:14', '1', '0');
INSERT INTO `powers` VALUES ('302', '300', '删除官网业务', null, null, '2016-07-11 15:17:37', '1', '0');
INSERT INTO `powers` VALUES ('303', '300', '增加官网业务', null, null, '2016-07-11 15:17:51', '1', '0');
INSERT INTO `powers` VALUES ('304', '300', '修改官网业务', null, null, '2016-07-11 15:18:03', '1', '0');
INSERT INTO `powers` VALUES ('400', '999', '公告管理权限', null, null, '2016-07-11 15:20:15', '0', '0');
INSERT INTO `powers` VALUES ('401', '400', '增加公告', null, null, '2016-07-11 15:24:03', '1', '0');
INSERT INTO `powers` VALUES ('402', '400', '删除公告', null, null, '2016-07-11 15:24:17', '1', '0');
INSERT INTO `powers` VALUES ('403', '400', '修改公告', null, null, '2016-07-11 15:24:32', '1', '0');
INSERT INTO `powers` VALUES ('404', '400', '查看公告', null, null, '2016-07-11 15:23:40', '1', '0');
INSERT INTO `powers` VALUES ('500', '999', '官网成员管理权限', null, null, '2016-07-11 15:27:03', '0', '0');
INSERT INTO `powers` VALUES ('501', '500', '增加成员', null, null, '2016-07-11 15:27:21', '1', '0');
INSERT INTO `powers` VALUES ('502', '500', '删除成员', null, null, '2016-07-11 15:27:39', '1', '0');
INSERT INTO `powers` VALUES ('503', '500', '查看成员', null, null, '2016-07-11 15:28:01', '1', '0');
INSERT INTO `powers` VALUES ('504', '500', '修改成员', null, null, '2016-07-11 15:28:29', '1', '0');
INSERT INTO `powers` VALUES ('600', '999', '官网轮播权限', null, null, '2016-07-11 15:29:23', '0', '0');
INSERT INTO `powers` VALUES ('601', '600', '增加轮播', null, null, '2016-07-11 15:29:47', '1', '0');
INSERT INTO `powers` VALUES ('602', '600', '删除轮播', null, null, '2016-07-11 15:30:03', '1', '0');
INSERT INTO `powers` VALUES ('603', '600', '查看轮播', null, null, '2016-07-11 15:30:19', '1', '0');
INSERT INTO `powers` VALUES ('604', '600', '修改轮播', null, null, '2016-07-11 15:30:43', '1', '0');
INSERT INTO `powers` VALUES ('700', '999', '官网用户意见管理权限', null, null, '2016-07-11 15:33:32', '0', '0');
INSERT INTO `powers` VALUES ('701', '700', '查看用户意见', null, null, '2016-07-11 15:33:54', '1', '0');
INSERT INTO `powers` VALUES ('702', '700', '删除用户意见', null, null, '2016-07-11 15:34:09', '1', '0');
INSERT INTO `powers` VALUES ('703', '700', '修改用户意见', null, null, '2016-07-11 15:34:23', '1', '0');
INSERT INTO `powers` VALUES ('704', '700', '增加用户意见', null, null, '2016-07-11 15:34:42', '1', '0');
INSERT INTO `powers` VALUES ('800', '999', '日志管理权限', null, null, '2016-07-11 15:35:41', '0', '0');
INSERT INTO `powers` VALUES ('801', '800', '查看管理员登陆日志', null, null, '2016-07-11 15:36:28', '1', '0');
INSERT INTO `powers` VALUES ('802', '800', '查看管理员更新日志', null, null, '2016-07-11 15:36:59', '1', '0');
INSERT INTO `powers` VALUES ('803', '800', '查看用户登录日志', null, null, '2016-07-11 15:37:32', '1', '0');
INSERT INTO `powers` VALUES ('804', '800', '查看用户更新日志', null, null, '2016-07-11 15:37:52', '1', '0');
INSERT INTO `powers` VALUES ('900', '999', '官网新闻管理权限', null, null, '2016-08-27 12:40:30', '0', '0');
INSERT INTO `powers` VALUES ('901', '900', '增加官网新闻', null, null, '2016-07-11 12:42:28', '1', '0');
INSERT INTO `powers` VALUES ('902', '900', '删除官网新闻', null, null, '2016-07-11 12:41:46', '1', '0');
INSERT INTO `powers` VALUES ('903', '900', '查看官网新闻', null, null, '2016-07-11 12:29:08', '1', '0');
INSERT INTO `powers` VALUES ('904', '900', '修改官网新闻', null, null, '2016-07-11 12:40:54', '1', '0');
INSERT INTO `powers` VALUES ('999', null, '全部权限', null, null, '2016-07-11 12:45:34', '0', '0');

-- ----------------------------
-- Table structure for systemddl
-- ----------------------------
DROP TABLE IF EXISTS `systemddl`;
CREATE TABLE `systemddl` (
  `id` varchar(36) NOT NULL,
  `iconCls` varchar(50) DEFAULT NULL,
  `text` varchar(100) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parentId` varchar(36) DEFAULT NULL,
  `currtHigh` int(255) NOT NULL COMMENT '当前的节点深度，以根结点为参考，根节点为0，=-1代表为不能改变的节点',
  `high` int(255) NOT NULL COMMENT '从根节点开始的深度，根节点为0，子节点不断累加，=-1代表为不能改变的节点',
  `tb` varchar(255) DEFAULT NULL COMMENT '注明currtHigh为1的字段所属表',
  `field` varchar(255) DEFAULT NULL COMMENT '注明currtHigh为1的字段所属表的字段',
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `forkey_P_id` (`parentId`),
  CONSTRAINT `forkey_P_id` FOREIGN KEY (`parentId`) REFERENCES `systemddl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemddl
-- ----------------------------
INSERT INTO `systemddl` VALUES ('0', '', '官网模块', '', 'root', '-1', '-1', null, null, null);
INSERT INTO `systemddl` VALUES ('001', null, '性别', null, '01', '1', '2', '', 'sex', '0');
INSERT INTO `systemddl` VALUES ('002', null, '国家', null, '01', '1', '2', '', 'nation', '3');
INSERT INTO `systemddl` VALUES ('003', null, '信仰', null, '01', '1', '2', '', 'faith', '5');
INSERT INTO `systemddl` VALUES ('004', null, '语言', null, '01', '1', '2', '', 'language', '4');
INSERT INTO `systemddl` VALUES ('005', null, '学历', null, '01', '1', '2', '', 'degree', '1');
INSERT INTO `systemddl` VALUES ('006', null, '状态', null, '01', '1', '2', '', 'membersStatus', '6');
INSERT INTO `systemddl` VALUES ('007', null, '省份', null, '01', '1', '2', null, 'province', '2');
INSERT INTO `systemddl` VALUES ('01', null, '成员的添加和筛选条件', null, '0', '-1', '-1', 'officialwebsite_members', null, null);
INSERT INTO `systemddl` VALUES ('02', null, '业务的添加和筛选条件', null, '0', '-1', '-1', 'officialwebsite_service', null, null);
INSERT INTO `systemddl` VALUES ('021', null, '类型', null, '02', '1', '2', '', 'clazz', null);
INSERT INTO `systemddl` VALUES ('022', null, '进程', null, '02', '1', '2', '', 'rateOfProgress', null);
INSERT INTO `systemddl` VALUES ('03', null, '新闻的添加和筛选条件', null, '0', '-1', '-1', 'officialwebsite_news', null, null);
INSERT INTO `systemddl` VALUES ('031', null, '类型', null, '03', '1', '2', '', 'clazz', null);
INSERT INTO `systemddl` VALUES ('09025d9d-0600-4467-9bb6-7143a41fa106', null, '湖南', null, '007', '2', '2', null, null, '1');
INSERT INTO `systemddl` VALUES ('108f2461-7cdc-43a4-bc12-643725555454', null, '其他', null, '002', '2', '2', null, null, '1');
INSERT INTO `systemddl` VALUES ('145bf791-e0af-40bf-abee-e6002bceb66f', null, '业务报告', null, '021', '2', '2', null, null, '3');
INSERT INTO `systemddl` VALUES ('149935d2-c002-4692-964e-66d11401ac50', null, '女', null, '001', '2', '2', null, null, '1');
INSERT INTO `systemddl` VALUES ('1b1190ca-9d62-4831-8227-3e8e59dc7050', null, '博士', null, '005', '2', '2', null, null, '5');
INSERT INTO `systemddl` VALUES ('1bd1fa47-733d-43e6-8203-33564732b349', null, '业务介绍', null, '021', '2', '2', null, null, '2');
INSERT INTO `systemddl` VALUES ('20f1f9f9-41e8-439b-9201-2dab49b5c6c0', null, '其他', null, '005', '2', '2', null, null, '6');
INSERT INTO `systemddl` VALUES ('27635663-d124-4d40-aa14-401eae919f41', null, '其他', null, '022', '2', '2', null, null, '5');
INSERT INTO `systemddl` VALUES ('2cdc1e18-e4bf-4b17-ab64-30319c058a9b', null, '公告', null, '031', '2', '2', null, null, '0');
INSERT INTO `systemddl` VALUES ('2def116a-2ad2-4daf-ad10-584cf78811fa', null, '天主教', null, '003', '2', '2', null, null, '2');
INSERT INTO `systemddl` VALUES ('2f763509-a772-4c40-908f-745e0cf72304', null, '浙江', null, '007', '2', '2', null, null, '3');
INSERT INTO `systemddl` VALUES ('32ad1024-ff0e-43db-b317-378d8a38094f', null, '四川', null, '007', '2', '2', null, null, '0');
INSERT INTO `systemddl` VALUES ('32c426b1-9cea-4056-8ff0-de48a590a66c', null, '男', null, '001', '2', '2', null, null, '0');
INSERT INTO `systemddl` VALUES ('42ffa3f8-a202-4fde-82f6-67e4af5feaf1', null, '中文', null, '004', '2', '2', null, null, '0');
INSERT INTO `systemddl` VALUES ('4582058f-d51e-46f3-9ef3-018364f76c86', null, '其他', null, '004', '2', '2', null, null, '2');
INSERT INTO `systemddl` VALUES ('45a44aa2-1b23-4661-ac85-678fc72c6c5f', null, '项目报告', null, '021', '2', '2', null, null, '1');
INSERT INTO `systemddl` VALUES ('4c2d8057-7e26-4470-8721-f9eeab8dd297', null, '小学', null, '005', '2', '2', null, null, '0');
INSERT INTO `systemddl` VALUES ('5169cba4-ef8a-4f99-a731-8b28d462f6b6', null, '项目介绍', null, '021', '2', '2', null, null, '0');
INSERT INTO `systemddl` VALUES ('5c4fb517-1006-4574-93b3-b02acf1c7778', null, '其他', null, '006', '2', '2', null, null, '2');
INSERT INTO `systemddl` VALUES ('5e4da8dd-2631-4b02-824f-b98cd7487223', null, '江西', null, '007', '2', '2', null, null, '5');
INSERT INTO `systemddl` VALUES ('64fef429-acdf-4f5e-9c64-d6c4e5a35085', null, '其他', null, '021', '2', '2', null, null, '4');
INSERT INTO `systemddl` VALUES ('676c8ce0-e67f-4770-93bb-0268cf177c14', null, '中期', null, '022', '2', '2', null, null, '2');
INSERT INTO `systemddl` VALUES ('6e0d4c24-2e42-4d4d-ac1b-b8d9e2bc3f0c', null, '其他', null, '001', '2', '2', null, null, '2');
INSERT INTO `systemddl` VALUES ('858e355b-e709-41ff-bc46-a6766964b810', null, '其他', null, '031', '2', '2', null, null, '4');
INSERT INTO `systemddl` VALUES ('85eb1bb7-4935-420a-b706-717cfc59d476', null, '无神论', null, '003', '2', '2', null, null, '0');
INSERT INTO `systemddl` VALUES ('8b086340-8a58-4de1-8d82-2688b27fd56d', null, '大专', null, '005', '2', '2', null, null, '2');
INSERT INTO `systemddl` VALUES ('8d35df8d-bdca-42b2-8f72-e474d9041244', null, '中学', null, '005', '2', '2', null, null, '1');
INSERT INTO `systemddl` VALUES ('90d85d7f-8d5c-4ef9-9cc8-a310c0ffa4fa', null, '大不列颠及北爱尔兰联合王国', null, '002', '2', '2', null, null, '0');
INSERT INTO `systemddl` VALUES ('99cf064b-699c-4160-9f2c-021a9150a2ea', null, '后期', null, '022', '2', '2', null, null, '3');
INSERT INTO `systemddl` VALUES ('a14a4896-fe91-467f-ac77-4e80dfa93281', null, '安徽', null, '007', '2', '2', null, null, '2');
INSERT INTO `systemddl` VALUES ('a203f44c-df9f-48fc-a9fa-7aee02b9788b', null, '大学', null, '005', '2', '2', null, null, '3');
INSERT INTO `systemddl` VALUES ('a86a600f-1254-4e40-8dc3-5fd83d6ba162', null, '筹备', null, '022', '2', '2', null, null, '0');
INSERT INTO `systemddl` VALUES ('afa60002-ea1b-4dd5-be4a-7a05155c062a', null, '前期', null, '022', '2', '2', null, null, '1');
INSERT INTO `systemddl` VALUES ('ba1b666d-25e5-40f9-8923-d8095e23faa4', null, '活动', null, '031', '2', '2', null, null, '3');
INSERT INTO `systemddl` VALUES ('ba8cd150-27b8-4fd0-9efe-3f3fb81c4d83', null, '娱乐', null, '031', '2', '2', null, null, '2');
INSERT INTO `systemddl` VALUES ('c06b4838-2b7a-4ab7-93c8-cee80c4b13dd', null, '基督教', null, '003', '2', '2', null, null, '4');
INSERT INTO `systemddl` VALUES ('c1c85214-d987-4a74-89aa-6ce8fe227e82', null, '伊斯兰教', null, '003', '2', '2', null, null, '3');
INSERT INTO `systemddl` VALUES ('c87b5528-a611-4f17-bbd1-b3a8c09c4787', null, '佛教', null, '003', '2', '2', null, null, '1');
INSERT INTO `systemddl` VALUES ('c8c3f6f7-c1bc-42ae-b01d-30f110d7b468', null, '招募', null, '031', '2', '2', null, null, '1');
INSERT INTO `systemddl` VALUES ('cb2224ec-2f50-49f8-8dac-bddcb2bbf714', null, '中国', null, '002', '2', '2', null, null, '2');
INSERT INTO `systemddl` VALUES ('cbb3c3ce-af1e-4585-99ee-a8a459064962', null, '犹太教', null, '003', '2', '2', null, null, '5');
INSERT INTO `systemddl` VALUES ('da773455-b11d-4f0b-8530-08aadcceff79', null, '完成', null, '022', '2', '2', null, null, '4');
INSERT INTO `systemddl` VALUES ('db9b8b11-39d2-4b54-96c7-2ec7f5c167cb', null, '福建', null, '007', '2', '2', null, null, '4');
INSERT INTO `systemddl` VALUES ('e94bd1f3-d1c5-440b-b483-a753c7f30a02', null, '其他', null, '003', '2', '2', null, null, '6');
INSERT INTO `systemddl` VALUES ('ec615efb-9b5f-4ae2-9a57-c7c943d93f32', null, '离职', null, '006', '2', '2', null, null, '1');
INSERT INTO `systemddl` VALUES ('ed8487d9-a206-421f-9b0a-b70739d43fbb', null, '英文', null, '004', '2', '2', null, null, '1');
INSERT INTO `systemddl` VALUES ('f732a014-6184-41c7-8094-584e57741c6c', null, '研究生', null, '005', '2', '2', null, null, '4');
INSERT INTO `systemddl` VALUES ('f80426fa-21ca-439e-b148-abe0678be311', null, '在职', null, '006', '2', '2', null, null, '0');
INSERT INTO `systemddl` VALUES ('root', null, '字典', null, null, '-1', '-1', null, null, null);
