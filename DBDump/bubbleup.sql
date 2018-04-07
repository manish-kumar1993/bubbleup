-- MySQL dump 10.13  Distrib 5.5.55, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: bubbleup
-- ------------------------------------------------------
-- Server version	5.6.33-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` varchar(255) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `town` varchar(45) DEFAULT NULL,
  `village` varchar(45) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `assignedTo` varchar(45) DEFAULT NULL,
  `createdBy` varchar(45) DEFAULT NULL,
  `createdOn` varchar(45) DEFAULT NULL,
  `serviceType` varchar(45) DEFAULT NULL,
  `paymentStatus` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES ('27f02fa6-6d08-4b31-80cd-5df8b942fa6e','Manitech','India','Karnatka','Bangaluru','NA','HSR Layout',NULL,'5013f26e-3e05-4dd3-8cf7-9312a4915755','31-03-2018',NULL,NULL),('9975a2be-65c8-4a4b-9b4a-ba2e19a70ddc','Company','country','state','town','village','address',NULL,'5013f26e-3e05-4dd3-8cf7-9312a4915755','31-03-2018','ACTIVE','UNPAID'),('f235548b-50cc-4d1d-8d6c-ad7e5f79a51e','Part2','India','Maharastra','Mumbai','NA','Koperkhairane',NULL,'5013f26e-3e05-4dd3-8cf7-9312a4915755','31-03-2018',NULL,'UNPAID');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masterRole`
--

DROP TABLE IF EXISTS `masterRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masterRole` (
  `masterRoleId` varchar(255) NOT NULL,
  `masterRoleName` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`masterRoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masterRole`
--

LOCK TABLES `masterRole` WRITE;
/*!40000 ALTER TABLE `masterRole` DISABLE KEYS */;
INSERT INTO `masterRole` VALUES ('9318c4f6-ffda-11e6-8b94-062a8f2c000b','ADMIN','ACTIVE'),('9318c4f6-ffda-11e6-8b94-062a8f2c111b','REPORT','ACTIVE');
/*!40000 ALTER TABLE `masterRole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masterRoleAccess`
--

DROP TABLE IF EXISTS `masterRoleAccess`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masterRoleAccess` (
  `masterRoleAccessId` varchar(255) NOT NULL,
  `masterRoleId` varchar(255) DEFAULT NULL,
  `roleId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`masterRoleAccessId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masterRoleAccess`
--

LOCK TABLES `masterRoleAccess` WRITE;
/*!40000 ALTER TABLE `masterRoleAccess` DISABLE KEYS */;
INSERT INTO `masterRoleAccess` VALUES ('1f23f7b6-afe8-11e7-8db7-00224da04f14','9318c4f6-ffda-11e6-8b94-062a8f2c000b','9318c4f6-ffda-2222-8b94-062a8f2c183b'),('1f3189b7-afe8-11e7-8db7-00224da04f14','9318c4f6-ffda-11e6-8b94-062a8f2c000b','9318c4f6-ffda-5555-8b94-062a8f2c183b'),('1f355c4b-afe8-11e7-8db7-00224da04f14','9318c4f6-ffda-11e6-8b94-062a8f2c000b','9318c4f6-ffda-6666-8b94-062a8f2c183b'),('7043d9f0-b425-11e7-8cb9-c6596e1a37c5','9318c4f6-ffda-11e6-8b94-062a8f2c111b','618ff242-aff9-11e7-9c54-c0d962399766'),('912e3fbe-ae70-11e7-aa12-083e8e8efeere','9318c4f6-ffda-11e6-8b94-062a8f2c000b','618ff242-aff9-11e7-9c54-c0d962399766');
/*!40000 ALTER TABLE `masterRoleAccess` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleId` varchar(225) NOT NULL DEFAULT '',
  `roleDescription` varchar(225) DEFAULT NULL,
  `roleName` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('618ff242-aff9-11e7-9c54-c0d962399766','REPORT','ROLE_REPORT'),('9318c4f6-ffda-2222-8b94-062a8f2c183b','UPLOAD','ROLE_UPLOAD'),('9318c4f6-ffda-5555-8b94-062a8f2c183b','User Role','ROLE_USER_ROLE'),('9318c4f6-ffda-6666-8b94-062a8f2c183b','Users','ROLE_USERS');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upload_file`
--

DROP TABLE IF EXISTS `upload_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upload_file` (
  `id` varchar(255) NOT NULL,
  `uploadedOn` varchar(255) DEFAULT NULL,
  `principal` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `validationResult` longtext,
  `noOfRecords` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upload_file`
--

LOCK TABLES `upload_file` WRITE;
/*!40000 ALTER TABLE `upload_file` DISABLE KEYS */;
INSERT INTO `upload_file` VALUES ('1508673808410','2017-10-22 05:33:28','pertekerler','2016','apr','Pertek Erler Commission Report April 2016.xlsx','SYSTEM UPLOAD','UPLOADED','Processed','93');
/*!40000 ALTER TABLE `upload_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` varchar(255) DEFAULT '1',
  `createdBy` varchar(255) NOT NULL,
  `updatedBy` varchar(255) NOT NULL,
  `createdDate` varchar(255) NOT NULL,
  `updatedDate` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `registrationId` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1c3b551c-15e7-443d-8d1a-2cd08f3d8d90','s@trisysit.com','987778789987898','eff2b051-8f55-3fc9-9a39-f72816e02056','$2a$10$uMq00ybBdNiMaMG54GX2UuKcG0VAXmvvUjwcZz2jN3q1YXnW12uFe','1','5013f26e-3e05-4dd3-8cf7-9312a4915755','','20-10-2017','','ACTIVE','s','s',NULL,NULL),('2da27889-b437-40f6-808b-54926b935053','d@d.com','412333111131331','6e9d5b8b-eab0-3295-844c-b95bbe973c66','$2a$10$DAK67ET9nGEYOOmsP7SW6OfNI8IC918gdkIieA7yoaFQwgD7Ln50u','1','5013f26e-3e05-4dd3-8cf7-9312a4915755','','19-10-2017','','ACTIVE','F','G',NULL,NULL),('2da8a06e-84db-4692-bf10-ff9ee3366c84','s@s.com','87887879879898','0df5a2fe-05bc-341b-99f1-285e608d8055','$2a$10$/ZnxB8mqUhuXV9nd/oqhEuW0b9THNWb.tiVSjg6.Ku/HZf8mivcJq','0','5013f26e-3e05-4dd3-8cf7-9312a4915755','','20-10-2017','','ACTIVE','s','s',NULL,NULL),('5013f26e-3e05-4dd3-8cf7-9312a4915755','admin','','','$2a$10$sosCBiv.vVJN6WT0qL/E7e6jS.eWNvxjx3mM..Vf/nvciKfvNkyq2','1','','','2016-12-27 06:09:22','2017-04-10 16:43:56','ACTIVE','MacKellar','Admin','',NULL),('9ff0e108-11a1-48f6-a4b3-3a3ffc018a9f','r@r.com','888888888888888','e9393115-e87a-3fa9-801e-c1b8744b093a','$2a$10$1ikpUIZRyKD4iCfuuYft/uc8ov3Uck3GYFTzSFgm7znqfRXpdoLk.','1','5013f26e-3e05-4dd3-8cf7-9312a4915755','5013f26e-3e05-4dd3-8cf7-9312a4915755','19-10-2017','19-10-2017','ACTIVE','reggie','ried',NULL,NULL),('ca55efc0-346b-3f3c-8fce-dcbcdb8e56ba','report','','','$2a$10$ZCm6gxQl9Kab0nIkCseQpe4KMfphemXTWIeH/KrlSI/.XOSJn5zaC','1','','','2016-12-27 06:09:22','2017-04-10 16:43:56','ACTIVE','Report','',NULL,NULL),('f660c970-4d61-43bc-9b3a-b98aa44aeed9','sumit@t.com','988897897989878','a1b67dd2-c036-31ff-b86e-4350ff659826','$2a$10$chemfHAa73Wmpfq54.VhZerEk4J7Qrj4XqyZfj1bt3hqMRYvXs6sK','1','5013f26e-3e05-4dd3-8cf7-9312a4915755','','20-10-2017','','ACTIVE','sumit','dey',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userMasterRole`
--

DROP TABLE IF EXISTS `userMasterRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userMasterRole` (
  `userMasterRoleId` varchar(255) NOT NULL,
  `userId` varchar(255) DEFAULT NULL,
  `masterRoleId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userMasterRoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userMasterRole`
--

LOCK TABLES `userMasterRole` WRITE;
/*!40000 ALTER TABLE `userMasterRole` DISABLE KEYS */;
INSERT INTO `userMasterRole` VALUES ('465a67fe-b54b-11e7-8cb9-c6596e1a37c5','1c3b551c-15e7-443d-8d1a-2cd08f3d8d90','9318c4f6-ffda-11e6-8b94-062a8f2c000b'),('9a31870c-b4f8-11e7-8cb9-c6596e1a37c5','9ff0e108-11a1-48f6-a4b3-3a3ffc018a9f','9318c4f6-ffda-11e6-8b94-062a8f2c111b'),('a34fdfea-b549-11e7-8cb9-c6596e1a37c5','2da8a06e-84db-4692-bf10-ff9ee3366c84','9318c4f6-ffda-11e6-8b94-062a8f2c000b'),('e6ee7c80-b548-11e7-8cb9-c6596e1a37c5','f660c970-4d61-43bc-9b3a-b98aa44aeed9','9318c4f6-ffda-11e6-8b94-062a8f2c111b'),('f368d672-9666-4cd1-b0c6-62694bd4da31','5013f26e-3e05-4dd3-8cf7-9312a4915755','9318c4f6-ffda-11e6-8b94-062a8f2c000b'),('f408f1e6-b4fa-11e7-8cb9-c6596e1a37c5','2da27889-b437-40f6-808b-54926b935053','9318c4f6-ffda-11e6-8b94-062a8f2c111b');
/*!40000 ALTER TABLE `userMasterRole` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-07 12:52:07
