-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: bubbleup
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `company` (
  `id` varchar(255) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `town` varchar(45) DEFAULT NULL,
  `village` varchar(45) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `assignedTo` varchar(255) DEFAULT NULL,
  `createdBy` varchar(45) DEFAULT NULL,
  `createdOn` varchar(45) DEFAULT NULL,
  `serviceType` varchar(45) DEFAULT NULL,
  `paymentStatus` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES ('01687b20-08c8-4af7-a1d1-d8a56c0765a8','Service type test','IN','NA','NA','NA','NA','sankhu@gmail.com','5013f26e-3e05-4dd3-8cf7-9312a4915755','15-09-2018','Car Wash','PAID','ACTIVE'),('27f02fa6-6d08-4b31-80cd-5df8b942fa6e','Manitech teszt','India','Karnatka','Bangaluru','NA','HSR Layout','[sankhu@gmail.com]','5013f26e-3e05-4dd3-8cf7-9312a4915755','15-09-2018','Car Wash','PAID','INACTIVE'),('8733947e-a8a1-4640-82d9-67120424dcb0','Test for testing','Apna India','Not','City of joy','Apna Ghar','Khandala','[admin]','5013f26e-3e05-4dd3-8cf7-9312a4915755','15-09-2018','Tested Service','PAID','ACTIVE'),('f235548b-50cc-4d1d-8d6c-ad7e5f79a51e','Part2','India','Maharastra','Mumbai','NA','Koperkhairane','[765man@gmail.com]','5013f26e-3e05-4dd3-8cf7-9312a4915755','15-09-2018','Wash','PAID','INACTIVE');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
INSERT INTO `role` VALUES ('618ff242-aff9-11e7-9c54-c0d962399766','COMPANY ADMIN','ROLE_COMPANY_ADMIN'),('9318c4f6-ffda-2222-8b94-062a8f2c183b','SERVER ADMIN','ROLE_SERVER_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `services` (
  `id` varchar(100) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  `status` varchar(45) DEFAULT 'ACTIVE',
  `createdBy` varchar(100) DEFAULT NULL,
  `createdOn` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES ('4d5fb7c5-47a9-43b0-8f7d-af2421b900ec','Wash','Complete Wash','INACTIVE','5013f26e-3e05-4dd3-8cf7-9312a4915755','21-07-2018'),('591df259-55ef-4e7d-b196-0cfdedd82a82','Test','Tested','ACTIVE','1887e5ed-ada9-4b29-86fa-f80076cf5b7c','10-09-2018'),('b2bda589-b883-45cd-b6c0-d31da97d915a','Test','Testing','ACTIVE','5013f26e-3e05-4dd3-8cf7-9312a4915755','21-07-2018'),('cb5ee6e3-75e7-46f9-85c8-24e756ff2a6d','Car Wash','Car Washing','ACTIVE','5013f26e-3e05-4dd3-8cf7-9312a4915755','21-07-2018'),('f1146a04-cd4e-4162-818a-e33cf111587c','Tested Service','Tested Service Description','ACTIVE','5013f26e-3e05-4dd3-8cf7-9312a4915755','15-09-2018');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upload_file`
--

DROP TABLE IF EXISTS `upload_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` varchar(255) DEFAULT '1',
  `createdBy` varchar(255) NOT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `createdDate` varchar(255) NOT NULL,
  `updatedDate` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `registrationId` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `userType` varchar(45) NOT NULL DEFAULT 'USER',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('0256c086-64d1-41ef-b601-34c00c8d6fd7','huhu@gmail.com','989898989','3338ac79-9c41-3839-9b56-62269f7bf245','$2a$10$22SDKm88jMtyjH0v9uuECu8PTKSKHSaEXenJXoibCEZF0GAW8ctZ2','','1887e5ed-ada9-4b29-86fa-f80076cf5b7c',NULL,'17-09-2018',NULL,'','huhu','',NULL,NULL,'WORKER'),('12a6bd40-56c9-488c-8cf9-cfa2ded0f762','hoja@hoja.com','2323232323','cc24bebf-fd86-397f-90d3-e9bbc5108933','$2a$10$2Gr9bZuE4C3254lf3x62wOCdUvmlJBjEX92mMA20ryX2j6VDYRVR6','','1887e5ed-ada9-4b29-86fa-f80076cf5b7c',NULL,'17-09-2018',NULL,'','naihogakya','',NULL,NULL,'WORKER'),('132f8985-3617-499d-bdca-4e92623e48f1','pirse@gmail.com','1212121212','8b49655c-bc98-329d-be7d-4783bbd6c784','$2a$10$MrCNYDZZV5dS2NPFZ8FXoO8AYZ/BJikmByS0me3kZ3gruqP2zBYD2','','1887e5ed-ada9-4b29-86fa-f80076cf5b7c',NULL,'17-09-2018',NULL,'','pirsetest','',NULL,NULL,'WORKER'),('1887e5ed-ada9-4b29-86fa-f80076cf5b7c','765mann@gmail.com','9167762740','9653e067-2544-364d-8ab0-7ffe1951fb10','$2a$10$ZGmgLiXF81Kh.bZWY4dcUOTQAzdjdVQe6LYjotufYsIudVLWr0Lrq','1','5013f26e-3e05-4dd3-8cf7-9312a4915755',NULL,'21-07-2018',NULL,'ACTIVE','Manish','Kumar',NULL,NULL,'USER'),('24954614-5600-4598-9add-fdfd9a09eb7f','sankhu@gmail.com','','1d90d0a6-c299-3836-aab1-2afd276a8168','$2a$10$xtQuny.asA1Pv3fHaON9z.z6LUl0RNlC.XE0uptSWGRpg9hlBHtYe','1','5013f26e-3e05-4dd3-8cf7-9312a4915755',NULL,'15-09-2018',NULL,'ACTIVE','Shankhu','Das',NULL,NULL,'USER'),('28d5201b-775a-41c7-a163-7aca8313dbc7','last@gmail.com','8488484884','7c2f1f04-b2e3-3764-a1c9-3b5ac0185dc9','$2a$10$eOr2NWY5RZNZCW48ZIGMvuvCPheeRnkqdFYAkae.MRf2QwVJWWlzq','','1887e5ed-ada9-4b29-86fa-f80076cf5b7c',NULL,'17-09-2018',NULL,'','lastattempt','',NULL,NULL,'WORKER'),('5013f26e-3e05-4dd3-8cf7-9312a4915755','admin','7903159302','','$2a$10$cYLM.qoXpeAzcZhJ3oXRLu9Slkb61LHyWW5qJ4QKvHEMhaxZ5qCPi','1','','','2016-12-27 06:09:22','2017-04-10 16:43:56','ACTIVE','Bubbleup','Admin','',NULL,'USER'),('655c2beb-13a0-4dc2-ae5a-e44213571fd4','mani@worker.com','1231231233','16fb9024-8879-33af-849b-e055c45ee920','$2a$10$NgJuypA2guzty84ALbHnre5kfF1p1140swEOYeZ60cZmnI.al2CWO','','1887e5ed-ada9-4b29-86fa-f80076cf5b7c',NULL,'17-09-2018',NULL,'','worker test','',NULL,NULL,'WORKER'),('72bd9ab7-c833-40b5-82d7-2fb7c22a589d','aub@aub.com','1212121222','3b696094-a719-3aad-a6e4-bc045ecc098a','$2a$10$5CZVCcXwy.2E0Ds4oekPw.rm2vuQFra.ToyMjwikCpcsEwQN1Jsxy','','1887e5ed-ada9-4b29-86fa-f80076cf5b7c',NULL,'17-09-2018',NULL,'','Yaar Aub ho ja','',NULL,NULL,'WORKER'),('7bcf6e20-c252-4799-9026-c47a5123586c','765man@gmail.com','9167762740','fa521266-3a02-3e2a-95ed-28a29c517f3b','$2a$10$brAwIrjTJYTK5rVyORkH.u3KUsfSQV9Gleaoa9eNWuO0EeG8r4TiS','0','5013f26e-3e05-4dd3-8cf7-9312a4915755',NULL,'14-09-2018',NULL,'ACTIVE','Manish','Kumar',NULL,NULL,'USER'),('8f723315-89bc-4422-9277-2f419acc917a','snku@gmail.com','9167762740','535bc375-e884-36df-9425-fd2b05f8ab81','$2a$10$ooQ3N1mqiWR9S5SIJLlOa.lZz8b/fV/L5HfAWY0aUFk8xc/FBN0kW','','1887e5ed-ada9-4b29-86fa-f80076cf5b7c',NULL,'15-09-2018',NULL,'','Sankhu@work','',NULL,NULL,'WORKER'),('a3ed4a56-4746-4b76-8ad7-eee4e3261072','last@last.com','8787890998','f3f8a361-5a85-3578-83b4-74878b7c93ae','$2a$10$NLIsOA7o3HfwgVs8qkiLOuShD6.QibjIV6Dw.utKpMMwF3lhg9WCW','','1887e5ed-ada9-4b29-86fa-f80076cf5b7c',NULL,'17-09-2018',NULL,'','lastoflast','',NULL,NULL,'WORKER'),('acc22927-b36d-4259-b8c1-2ceae443eca2','aubhoja@gmail.com','45345445454','029e6641-b202-3b7f-99e3-abd65d0e3c1d','$2a$10$N5lUVCE3WidLMKO5nniDbOjZb30HJlZusKSBfqoV/z/H0DAZCTnwG','','1887e5ed-ada9-4b29-86fa-f80076cf5b7c',NULL,'17-09-2018',NULL,'','naihoraha','',NULL,NULL,'WORKER'),('c330aaee-dc2d-49d6-80b1-2f2ba6d6c5f3','test@gmail.com','9167762740','52a3a681-cebb-3f23-a2e9-575edbf94878','$2a$10$WIdoLeN25xa5Lp1np5gxaek.WS1DDkOAkl5JctHGiTbFgHIA/djxu','1','5013f26e-3e05-4dd3-8cf7-9312a4915755',NULL,'14-09-2018',NULL,'ACTIVE','Vijay','Shukla',NULL,NULL,'USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `role_id` varchar(45) NOT NULL,
  `user_id` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('9318c4f6-ffda-2222-8b94-062a8f2c183b','5013f26e-3e05-4dd3-8cf7-9312a4915755'),('618ff242-aff9-11e7-9c54-c0d962399766','1887e5ed-ada9-4b29-86fa-f80076cf5b7c'),('618ff242-aff9-11e7-9c54-c0d962399766','c330aaee-dc2d-49d6-80b1-2f2ba6d6c5f3'),('9318c4f6-ffda-2222-8b94-062a8f2c183b','7bcf6e20-c252-4799-9026-c47a5123586c'),('618ff242-aff9-11e7-9c54-c0d962399766','24954614-5600-4598-9add-fdfd9a09eb7f');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermasterrole`
--

DROP TABLE IF EXISTS `usermasterrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usermasterrole` (
  `userMasterRoleId` varchar(255) NOT NULL,
  `userId` varchar(255) DEFAULT NULL,
  `masterRoleId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userMasterRoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermasterrole`
--

LOCK TABLES `usermasterrole` WRITE;
/*!40000 ALTER TABLE `usermasterrole` DISABLE KEYS */;
INSERT INTO `usermasterrole` VALUES ('465a67fe-b54b-11e7-8cb9-c6596e1a37c5','1c3b551c-15e7-443d-8d1a-2cd08f3d8d90','9318c4f6-ffda-11e6-8b94-062a8f2c000b'),('9a31870c-b4f8-11e7-8cb9-c6596e1a37c5','9ff0e108-11a1-48f6-a4b3-3a3ffc018a9f','9318c4f6-ffda-11e6-8b94-062a8f2c111b'),('a229dcac-8d0e-11e8-b743-4439c45b4ecf','1887e5ed-ada9-4b29-86fa-f80076cf5b7c','9318c4f6-ffda-11e6-8b94-062a8f2c111b'),('a34fdfea-b549-11e7-8cb9-c6596e1a37c5','2da8a06e-84db-4692-bf10-ff9ee3366c84','9318c4f6-ffda-11e6-8b94-062a8f2c000b'),('e6ee7c80-b548-11e7-8cb9-c6596e1a37c5','f660c970-4d61-43bc-9b3a-b98aa44aeed9','9318c4f6-ffda-11e6-8b94-062a8f2c111b'),('f368d672-9666-4cd1-b0c6-62694bd4da31','5013f26e-3e05-4dd3-8cf7-9312a4915755','9318c4f6-ffda-11e6-8b94-062a8f2c000b'),('f408f1e6-b4fa-11e7-8cb9-c6596e1a37c5','2da27889-b437-40f6-808b-54926b935053','9318c4f6-ffda-11e6-8b94-062a8f2c111b');
/*!40000 ALTER TABLE `usermasterrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vehicle` (
  `id` varchar(100) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `charges` double DEFAULT NULL,
  `createdBy` varchar(45) DEFAULT NULL,
  `createdOn` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES ('5edaa403-d352-41a6-bfd5-75f2263749cb','asdf',77,'5013f26e-3e05-4dd3-8cf7-9312a4915755','21-07-2018','ACTIVE'),('6cc6983c-2a3b-4f98-9880-5785e7459d44','Yamaha',123456,'5013f26e-3e05-4dd3-8cf7-9312a4915755','21-07-2018','ACTIVE'),('7aa915da-048a-4421-93da-1ece97137240','TestVehicle',123,'5013f26e-3e05-4dd3-8cf7-9312a4915755','21-07-2018','ACTIVE'),('b3961217-3ea7-45af-af51-1c60a652fbfe','Honda',987,'5013f26e-3e05-4dd3-8cf7-9312a4915755','21-07-2018','INACTIVE'),('bc851d29-ee09-491b-a42b-183d3d0d67f3','car',99,'5013f26e-3e05-4dd3-8cf7-9312a4915755','21-07-2018','INACTIVE'),('edefd9fb-fdaa-478d-b4df-224450afa65f','Vehicle@Mine',87,'5013f26e-3e05-4dd3-8cf7-9312a4915755','21-07-2018','ACTIVE');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-17 21:54:31
