-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: garitsdb
-- ------------------------------------------------------
-- Server version	8.0.15

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
-- Table structure for table `account_holder`
--

DROP TABLE IF EXISTS `account_holder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account_holder` (
  `customer_id` int(10) NOT NULL,
  `discount_plan` varchar(255) NOT NULL,
  `pay_later` tinyint(4) NOT NULL,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `account_holder_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_holder`
--

LOCK TABLES `account_holder` WRITE;
/*!40000 ALTER TABLE `account_holder` DISABLE KEYS */;
INSERT INTO `account_holder` VALUES (9,'Fixed Discount',0);
/*!40000 ALTER TABLE `account_holder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `automated_report`
--

DROP TABLE IF EXISTS `automated_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `automated_report` (
  `report_id` int(11) NOT NULL AUTO_INCREMENT,
  `report_name` varchar(255) DEFAULT NULL,
  `report_date` date DEFAULT NULL,
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `automated_report`
--

LOCK TABLES `automated_report` WRITE;
/*!40000 ALTER TABLE `automated_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `automated_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `customer_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) NOT NULL,
  `customer_address` varchar(255) NOT NULL,
  `customer_postcode` varchar(8) NOT NULL,
  `customer_tel` varchar(45) NOT NULL,
  `customer_email` varchar(255) NOT NULL,
  `customer_account_holder` tinyint(4) DEFAULT '0',
  `customer_contact` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `customer_id_UNIQUE` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (7,'Transco Gas Supplies','Methane Buildings, Sulphur Lane, Stenchville, Bucks','HP19 2MT','01494683725','None',0,'Jack Varta'),(8,'John Dohert','Miscellaneous House, Unknown Street, Whichville, Nowhereshire','MT1 2UP','07070070707','Miscellaneous House, Unknown Street, Whichville, Nowhereshire',0,NULL),(9,'William Gate','World Domination House, Enormous Street, Richville','NW10 4AT','02074773333','World Domination House, Enormous Street, Richville',1,NULL),(10,'Jean-Claude Laprie','10 Green Bottles, Brokenglassshire','NW9 NO8','07999333444','None',0,'');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `discount` (
  `discount_id` int(11) NOT NULL AUTO_INCREMENT,
  `discount_type` varchar(45) NOT NULL,
  `customer_id` int(10) NOT NULL,
  PRIMARY KEY (`discount_id`),
  KEY `discount_tbl_fk_1_idx` (`customer_id`),
  CONSTRAINT `discount_tbl_fk_1` FOREIGN KEY (`customer_id`) REFERENCES `account_holder` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (4,'Fixed Discount',9);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fixed_discount`
--

DROP TABLE IF EXISTS `fixed_discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fixed_discount` (
  `discount_id` int(11) NOT NULL,
  `discount_type` varchar(45) NOT NULL,
  `discount_percentage` float NOT NULL,
  `customer_id` int(10) NOT NULL,
  PRIMARY KEY (`discount_id`),
  KEY `fixed_discount_tbl_fk_2_idx` (`customer_id`),
  CONSTRAINT `fixed_discount_tbl_fk_1` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`discount_id`),
  CONSTRAINT `fixed_discount_tbl_fk_2` FOREIGN KEY (`customer_id`) REFERENCES `discount` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fixed_discount`
--

LOCK TABLES `fixed_discount` WRITE;
/*!40000 ALTER TABLE `fixed_discount` DISABLE KEYS */;
INSERT INTO `fixed_discount` VALUES (4,'Fixed Discount',0,9);
/*!40000 ALTER TABLE `fixed_discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flexible_discount`
--

DROP TABLE IF EXISTS `flexible_discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `flexible_discount` (
  `discount_id` int(11) NOT NULL,
  `discount_type` varchar(45) NOT NULL,
  `discount_value` float NOT NULL,
  `start_price` float NOT NULL,
  `end_price` float NOT NULL,
  `current_month` date NOT NULL,
  `customer_id` int(10) NOT NULL,
  PRIMARY KEY (`discount_id`),
  KEY `flexible_discount_tbl_fk_2_idx` (`customer_id`),
  CONSTRAINT `flexible_discount_tbl_fk_1` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`discount_id`),
  CONSTRAINT `flexible_discount_tbl_fk_2` FOREIGN KEY (`customer_id`) REFERENCES `discount` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flexible_discount`
--

LOCK TABLES `flexible_discount` WRITE;
/*!40000 ALTER TABLE `flexible_discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `flexible_discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foreperson`
--

DROP TABLE IF EXISTS `foreperson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `foreperson` (
  `user_id` int(10) NOT NULL,
  `hourly_rate` float NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foreperson`
--

LOCK TABLES `foreperson` WRITE;
/*!40000 ALTER TABLE `foreperson` DISABLE KEYS */;
/*!40000 ALTER TABLE `foreperson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `invoice` (
  `invoice_id` int(11) NOT NULL AUTO_INCREMENT,
  `job_id` int(10) NOT NULL,
  `invoice_date` date NOT NULL,
  `payment_due_date` date NOT NULL,
  `invoice_total` float NOT NULL,
  `invoice_paid` tinyint(4) NOT NULL DEFAULT '0',
  `invoice_reminder` int(11) DEFAULT '1',
  `fixed_cost` float DEFAULT '0',
  PRIMARY KEY (`invoice_id`),
  KEY `job_id_idx` (`job_id`),
  CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (22,26,'2019-04-03','2019-05-03',56.16,0,1,0),(23,26,'2019-04-03','2019-05-03',56.16,0,1,0),(24,29,'2018-12-20','2019-03-20',312,0,3,0),(25,29,'2019-04-03','2019-05-03',312,0,1,0);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT,
  `job_date` date NOT NULL,
  `reg_no` varchar(8) NOT NULL,
  `customer_id` int(10) NOT NULL,
  `mechanic_assigned` int(10) NOT NULL,
  `job_duration` int(11) NOT NULL,
  `job_status` varchar(255) NOT NULL,
  `job_type` varchar(45) NOT NULL,
  PRIMARY KEY (`job_id`),
  KEY `mechanic_assigned_idx` (`mechanic_assigned`),
  KEY `customer_id_idx` (`customer_id`) /*!80000 INVISIBLE */,
  CONSTRAINT `Job_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `mechanic_assigned` FOREIGN KEY (`mechanic_assigned`) REFERENCES `mechanic` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (26,'2019-04-03','BB64 TRU',10,7,2,'Done','MOT'),(27,'2019-04-03','GG11 PUB',8,7,2,'Pending','MOT'),(28,'2019-04-03','CT67 DWR',7,7,3,'Pending','MOT'),(29,'2018-12-20','GG11 PUB',8,8,2,'Done','Repair');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_tasks`
--

DROP TABLE IF EXISTS `job_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `job_tasks` (
  `task_id` int(10) NOT NULL AUTO_INCREMENT,
  `task_content` varchar(255) DEFAULT NULL,
  `task_completed` tinyint(4) DEFAULT '0',
  `job_id` int(11) NOT NULL,
  PRIMARY KEY (`task_id`),
  KEY `job_id_idx` (`job_id`),
  CONSTRAINT `fk_job` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_tasks`
--

LOCK TABLES `job_tasks` WRITE;
/*!40000 ALTER TABLE `job_tasks` DISABLE KEYS */;
INSERT INTO `job_tasks` VALUES (15,'replacement of the exhaust system',1,26),(16,'new set of sparkplug leads',1,26),(17,'new distributor cap',0,26),(18,'Task',0,27),(19,'5 litres of motor oil',0,28),(20,'a new oil filter',0,28),(21,'a new air filter',0,28),(23,'complete box',1,29);
/*!40000 ALTER TABLE `job_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mechanic`
--

DROP TABLE IF EXISTS `mechanic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mechanic` (
  `user_id` int(10) NOT NULL,
  `hourly_rate` float NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `mechanic_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mechanic`
--

LOCK TABLES `mechanic` WRITE;
/*!40000 ALTER TABLE `mechanic` DISABLE KEYS */;
INSERT INTO `mechanic` VALUES (7,105),(8,105);
/*!40000 ALTER TABLE `mechanic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part_used`
--

DROP TABLE IF EXISTS `part_used`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `part_used` (
  `part_used_id` int(11) NOT NULL AUTO_INCREMENT,
  `part_id` int(10) NOT NULL,
  `job_id` int(10) NOT NULL,
  `quantity_used` int(10) NOT NULL,
  PRIMARY KEY (`part_used_id`),
  KEY `part_id_idx` (`part_id`),
  KEY `job_id_idx` (`job_id`),
  CONSTRAINT `job_id` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`),
  CONSTRAINT `part_id` FOREIGN KEY (`part_id`) REFERENCES `parts` (`part_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part_used`
--

LOCK TABLES `part_used` WRITE;
/*!40000 ALTER TABLE `part_used` DISABLE KEYS */;
INSERT INTO `part_used` VALUES (18,3,26,2),(19,4,26,4),(20,9,28,5),(21,10,28,1),(22,11,28,1),(23,2,29,1);
/*!40000 ALTER TABLE `part_used` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parts`
--

DROP TABLE IF EXISTS `parts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parts` (
  `part_id` int(11) NOT NULL AUTO_INCREMENT,
  `part_name` varchar(255) NOT NULL,
  `part_manufacturer` varchar(255) NOT NULL,
  `part_supplier_id` int(10) NOT NULL,
  `vehicle_type` varchar(255) NOT NULL,
  `year` int(10) NOT NULL,
  `part_quantity` int(10) NOT NULL,
  `part_price` float NOT NULL,
  `part_threshold` int(10) DEFAULT '10',
  PRIMARY KEY (`part_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parts`
--

LOCK TABLES `parts` WRITE;
/*!40000 ALTER TABLE `parts` DISABLE KEYS */;
INSERT INTO `parts` VALUES (1,'Tyre, heavy tread','Fjord',1,'Fjord Transit Van',0,8,45,6),(2,'Exhaust, complete box','Fjord',1,'Fjord Estate',0,3,200,2),(3,'Engine Mounts, set','',2,'All Makes',0,6,15,4),(4,'Spark Plugs, each','',2,'All Makes',0,23,1.5,20),(5,'Spark Leads, set','',2,'All Makes',0,16,12.5,10),(6,'Distributor Cap','Fjord',1,'Fjord Vehicles',0,10,35,5),(7,'Paint, Arrogant Red','Slap-it-on Paints',2,'All Makes',0,3,60,2),(8,'Interior Bulb','Switch-it-on',2,'Rolls Royce',0,2,118,1),(9,'Motor Oil','',2,'All Makes',0,30,25,25),(10,'Oil Filter','',2,'All Makes',0,16,10,15),(11,'Air Filter','',2,'All Makes',0,15,15,10);
/*!40000 ALTER TABLE `parts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `supplier` (
  `part_supplier_id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(255) NOT NULL,
  `supplier_address` varchar(255) NOT NULL,
  `supplier_tel` int(11) NOT NULL,
  `supplier_email` varchar(255) NOT NULL,
  PRIMARY KEY (`part_supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'Fjord Supplies','10 Largeunits, Trade Estate, Reading, RG10 4PT',1895453857,''),(2,'Halfords','1 Enormous Office, Trading Park, Harlesdon, London, NW10 4UP',2083335555,''),(5,'Test Supplier','Test Address, N1 0AA',1334563212,'test@email.com'),(6,'Another Test Supplier','Address',1225441236,'testsupplier@outlook.com');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_role` varchar(45) NOT NULL,
  `user_pay` float DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'Penelope Carr','$2a$10$qVgL2I5MqMvp6Fuzi/.FK.H8DD6R7Vk5uvUgOb09IHlDcz64wELEK','Receptionist',NULL,'Penelope'),(3,'Sunny Evans','$2a$10$xektJgi7RD4weGOL2vUkJ.8mNILm2M/YUg1tisvZldSLKyrHC6IaK','Foreperson',125,'Sunny'),(5,'Administrator Role','$2a$10$16NCQAXIpcfvO8A44QgqCO36chRXKfHw40bzHsTebz8tU3HOu1qS.','Administrator',NULL,'SYSDBA'),(7,'Gavin Ross','$2a$10$.f12mM.mpiFvLbQfRvIpn.26TdQUqxiUO7Jg9wljgXM1bt/p.IDi.','Mechanic',105,'Gavin'),(8,'Anthony Wild','$2a$10$bJhVFtxQWbxA0HZtrYrWceWIYIjgOGGnElz3POj9t/woDjdU9zj.i','Mechanic',105,'Anthony'),(9,'Glynne Lancaster','$2a$10$fzLn8xsL6qD1KP6GUQRtEuaka9664E3TY7Ifi7V/LkR7hlYyldwQ.','Franchisee',NULL,'Glynne');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `variable_discount`
--

DROP TABLE IF EXISTS `variable_discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `variable_discount` (
  `discount_id` int(11) NOT NULL,
  `discount_type` varchar(45) DEFAULT NULL,
  `business_type` varchar(45) DEFAULT NULL,
  `discoun t_percentage` float DEFAULT NULL,
  `customer_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`discount_id`),
  KEY `variable_discount_tbl_fk_2_idx` (`customer_id`),
  CONSTRAINT `variable_discount_tbl_fk_1` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`discount_id`),
  CONSTRAINT `variable_discount_tbl_fk_2` FOREIGN KEY (`customer_id`) REFERENCES `discount` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `variable_discount`
--

LOCK TABLES `variable_discount` WRITE;
/*!40000 ALTER TABLE `variable_discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `variable_discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vehicle` (
  `reg_no` varchar(8) NOT NULL,
  `car_make` varchar(255) NOT NULL,
  `car_model` varchar(255) NOT NULL,
  `engine_serial` varchar(255) NOT NULL,
  `chassis_no` varchar(255) NOT NULL,
  `colour` varchar(255) NOT NULL,
  `customer_id` int(10) NOT NULL,
  `purchase_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`reg_no`),
  KEY `customer_id_idx` (`customer_id`),
  CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES ('AA66 CPG','Fjord','Transit Van','0','0','White',7,'2016-12-05'),('BB16 OLE','Rolls Royce','Silver Shadow','0','0','Red',9,'2016-08-08'),('BB64 TRU','Fjord','Ficus Estate','0','0','Brown',10,'2014-01-01'),('CT67 DWR','Fjord','Transit Van','0','0','White',7,'2017-12-12'),('FF18 GHT','Fjord','Transit Van','0','0','White',7,'2018-02-03'),('GG11 PUB','Fjord','Estate MK8','0','0','Green',8,'2011-1-1'),('VV68 BHN','Fjord','Transit Van','0','0','White',7,'2018-11-19');
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

-- Dump completed on 2019-04-04  8:42:43
