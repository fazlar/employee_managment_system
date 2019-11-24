CREATE DATABASE  IF NOT EXISTS `ems` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ems`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: ems
-- ------------------------------------------------------
-- Server version	5.7.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `applyleave`
--

DROP TABLE IF EXISTS `applyleave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `applyleave` (
  `id` int(11) NOT NULL,
  `descripation` varchar(255) DEFAULT NULL,
  `empName` varchar(255) DEFAULT NULL,
  `fromdate` datetime DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `todate` datetime DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applyleave`
--

LOCK TABLES `applyleave` WRITE;
/*!40000 ALTER TABLE `applyleave` DISABLE KEYS */;
INSERT INTO `applyleave` VALUES (151,'i am very sick due to fever','Md.raju Ahamed','2019-11-07 00:00:00','due to fever','Approve','2019-11-06 00:00:00','raju');
/*!40000 ALTER TABLE `applyleave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignproject`
--

DROP TABLE IF EXISTS `assignproject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assignproject` (
  `id` int(11) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `empName` varchar(255) DEFAULT NULL,
  `projectName` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignproject`
--

LOCK TABLES `assignproject` WRITE;
/*!40000 ALTER TABLE `assignproject` DISABLE KEYS */;
INSERT INTO `assignproject` VALUES (124,'2019-11-07 00:00:00.0','Md.Enamul Islam','School managment system','enamul','complete'),(125,'2019-11-07 00:00:00.0','Md.Enamul Islam','Employee management System','enamul','inComplete'),(127,'2019-11-07 00:00:00.0','md.abdulla al-asif','School managment system','asif','inComplete'),(128,'2019-11-07 00:00:00.0','md.abdulla al-asif','Loan Manegment System','asif','inComplete'),(129,'2019-11-07 00:00:00.0','Md.Hemanta Kar','School managment system','hematha','complete'),(130,'2019-11-08 00:00:00.0','Md.Hemanta Kar','Employee management System','hematha','inComplete'),(131,'2019-11-07 00:00:00.0','Md.Hemanta Kar','Loan Manegment System','hematha','inComplete'),(132,'2019-11-07 00:00:00.0','MD. SALAUDDIN','School managment system','salauddin','complete'),(133,'2019-11-07 00:00:00.0','MD. SALAUDDIN','Loan Manegment System','salauddin','inComplete'),(153,'2019-11-07 00:00:00.0','MD. SALAUDDIN','Loan Manegment System','hematha','inComplete'),(161,'2019-11-06 00:00:00.0','Liton Dev','Employee management System','liton ','inComplete'),(162,'2019-11-06 00:00:00.0','Liton Dev','Loan Manegment System','liton ','inComplete');
/*!40000 ALTER TABLE `assignproject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `attendance` (
  `id` int(11) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `empName` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `time` time DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (95,'ontime','2019-11-05','','present','04:19:56',NULL),(163,'to-late','2019-11-07','Liton Dev','present','14:19:13','liton '),(164,'to-late','2019-11-07','Liton Dev','present','14:22:05','liton '),(167,'to-late','2019-11-08','MD. SALAUDDIN','present','16:51:33','salauddin'),(168,'to-late','2019-11-08','MD. SALAUDDIN','present','16:52:26','salauddin'),(176,'to-late','2019-11-08','Md.Farid Ahamed','present','18:52:36','W3farid');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creatproject`
--

DROP TABLE IF EXISTS `creatproject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `creatproject` (
  `id` int(11) NOT NULL,
  `ProjectManager` varchar(255) DEFAULT NULL,
  `clientName` varchar(255) DEFAULT NULL,
  `databaseTech` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `desCripation` varchar(255) DEFAULT NULL,
  `forntTech` varchar(255) DEFAULT NULL,
  `projectName` varchar(255) DEFAULT NULL,
  `projectType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creatproject`
--

LOCK TABLES `creatproject` WRITE;
/*!40000 ALTER TABLE `creatproject` DISABLE KEYS */;
INSERT INTO `creatproject` VALUES (121,'Md.Jahidul Islam','Amena Begum Govt. Primary School','Mysql','2019-09-06 00:00:00.0','Requirment:\r\n1.create admin panel 2.Security','Html,css,js,jsp','School managment system','New project'),(122,'Md.Jahidul Islam','Mgi Ltd.,dhaka','Mysql','2019-11-24 00:00:00.0','Requirment:\r\n 1.create admin panel 2.Security','Html,css,js,jsp','Employee management System','New project'),(123,'Md.Jahidul Islam','Mgi Ltd.,dhaka','Mysql','2019-11-07 00:00:00.0','Requirment:\r\n 1.create admin panel 2.Security','Html,css,js,jsp','Loan Manegment System','New project');
/*!40000 ALTER TABLE `creatproject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `depatrment`
--

DROP TABLE IF EXISTS `depatrment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `depatrment` (
  `id` bigint(20) NOT NULL,
  `depName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `depatrment`
--

LOCK TABLES `depatrment` WRITE;
/*!40000 ALTER TABLE `depatrment` DISABLE KEYS */;
INSERT INTO `depatrment` VALUES (5,'WEB DEVELOPMENT'),(6,'NET WORKING'),(7,'DATABASE DESIGNE'),(8,'ADMINISTRATION'),(9,'FINANCE'),(69,'UX/UI DESINER'),(104,'HR DEPARTMENT');
/*!40000 ALTER TABLE `depatrment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(45) DEFAULT NULL,
  `jobtype` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `mobileno` varchar(45) DEFAULT NULL,
  `dateofbirth` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `postCode` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `empImage` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (98,'Md.Farid Ahamed','CEO','ADMINISTRATION','01724486878','2019-11-06 00:00:00.0','Male','Bangladesh',NULL,'Dhaka',NULL,'5643654364','Dhaka','W3farid@gmail.com','farid_ahmed.30968feb.jpg','70000'),(99,'Md.Jahidul Islam','Project Manager','WEB DEVELOPMENT','01758945639','2019-11-06 00:00:00.0','Male','Bangladesh',NULL,'Dhaka',NULL,'3500','Dhaka','jhaidul@gmail.com','jihad.aee89f2d.jpg','65002'),(100,'md.abdulla al-asif','Jr java programmer','WEB DEVELOPMENT','01517051440','2019-11-06 00:00:00.0','Male',NULL,NULL,'Dhaka',NULL,'3500','Dhaka','asif@gmail.com','asif_developer.b8196dc1.jpg','30000'),(102,'Md.Hemanta Kar','WEB DESINER','WEB DEVELOPMENT','01235458','2019-11-06 00:00:00.0','Male','Bangladesh',NULL,'Dhaka',NULL,'','Dhaka','hemanta@gmail.com','hamanta_frontend_developer.ca992234.jpg','35000'),(106,'MD. SALAUDDIN','Data Scientist','DATABASE DESIGNE','01542323232','2019-11-06 00:00:00.0','Male','Bangladesh',NULL,'Dhaka',NULL,'5643654364','dhaka','sashaker2010@gmail.com','salauddin_developer.1f0c0635.jpg','50000'),(110,'Md.Ashraful Islame ','Project Manager','NET WORKING','','2019-11-07 00:00:00.0','Male','Bangladesh',NULL,'Dhaka',NULL,'3500','Dhaka','','ashraful_developer.cb2600e5.jpg','50000'),(111,'Hitesh Choudhary','java Developer','DATABASE DESIGNE','0163058381','2019-11-06 00:00:00.0','Male','Pakistan',NULL,NULL,NULL,'','Dhili','hitesh@hiteshchoudhary.com','hitesh-choudhary.png','45000'),(112,'Hey YK','Programmer','DATABASE DESIGNE','01756893255','2019-11-06 00:00:00.0','Male','Pakistan',NULL,'Dhaka',NULL,'3500','Dhaka','heyYK@gmail.com','22528229_130327197625497_3292855756764932542_n.jpg','50000'),(115,'Md.Enamul Islam','Q/A','WEB DEVELOPMENT','017625896','2019-11-06 00:00:00.0','Male','Bangladesh',NULL,NULL,NULL,'3500','Dhaka','enamul1991@gmail.com','enamul_qa.e99128ff.jpg','50000'),(116,'Md.Abdul Alim','Programmer','DATABASE DESIGNE','01762589665','2019-11-06 00:00:00.0','Male','Bangladesh',NULL,'Dhaka',NULL,'3500','Dhaka','adoralim121@gmail.com','alim_developer.3cdc4bdd.jpg','50000'),(117,'Liton Dev','UX/UI DESINER','WEB DEVELOPMENT','017602867187','2019-11-06 00:00:00.0','Male','Bangladesh',NULL,'Dhaka',NULL,'3500','Dhaka','litondev@gmail.com','liton_dev_designer.5b64120b.jpg','40000'),(118,'Md.Rubayet Islam','Support Engineer','NET WORKING','017602867187','2019-11-06 00:00:00.0','Male','Bangladesh',NULL,'Dhaka',NULL,'3500','Dhaka','sashaker2010@gmail.com','rubyet_developer.7b92bc3e.jpg','40000'),(119,'Md.Omar faruk','Support Engineer','NET WORKING','017602867187','2019-11-06 00:00:00.0','Male','Bangladesh',NULL,'Dhaka',NULL,'3500','Dhaka','faruk2010@gmail.com','faruk.jpg','40000'),(150,'Md. Raju Ahamed','java Developer','DATABASE DESIGNE','01517168053',NULL,'Male','Bangladesh',NULL,'Dhaka',NULL,'3500','Dhaka','rajudc013@gmail.com','raju_developer.6d874c37.jpg','50000');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeeaccount`
--

DROP TABLE IF EXISTS `employeeaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employeeaccount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeeaccount`
--

LOCK TABLES `employeeaccount` WRITE;
/*!40000 ALTER TABLE `employeeaccount` DISABLE KEYS */;
/*!40000 ALTER TABLE `employeeaccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (185);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `joptype`
--

DROP TABLE IF EXISTS `joptype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `joptype` (
  `id` bigint(20) NOT NULL,
  `jobType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `joptype`
--

LOCK TABLES `joptype` WRITE;
/*!40000 ALTER TABLE `joptype` DISABLE KEYS */;
INSERT INTO `joptype` VALUES (13,'java Developer'),(14,'Jr java programmer'),(15,'Data Scientist'),(17,'CEO'),(18,'Head of HR'),(19,'Head of Finance'),(25,'Project Manager'),(62,'secation Officer'),(63,'Account oficer'),(68,'WEB DESINER'),(70,'UX/UI DESINER'),(109,'Programmer'),(113,'Support Engineer'),(114,'Q/A');
/*!40000 ALTER TABLE `joptype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `salary` (
  `id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `empName` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (174,70000,'Md.Farid Ahamed','January','W3farid','2019'),(175,70000,'Md.Farid Ahamed','February','W3farid','2019'),(177,40000,'Md.Hemanta Kar','January','hematha','2019'),(178,40000,'Md.Hemanta Kar','February','hematha','2019'),(179,40000,'Md.Hemanta Kar','Mearch','hematha','2019'),(180,40000,'Md.Hemanta Kar','April','hematha','2019'),(181,40000,'MD. SALAUDDIN','January','salauddin','2019'),(182,40000,'MD. SALAUDDIN','February','salauddin','2019'),(183,40000,'MD. SALAUDDIN','Mearch','salauddin','2019'),(184,40000,'MD. SALAUDDIN','April','salauddin','2019');
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedul`
--

DROP TABLE IF EXISTS `schedul`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `schedul` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clientName` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `descripation` varchar(255) DEFAULT NULL,
  `empName` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedul`
--

LOCK TABLES `schedul` WRITE;
/*!40000 ALTER TABLE `schedul` DISABLE KEYS */;
INSERT INTO `schedul` VALUES (165,'Amena Begum Govt. Primary School','2019-11-10','discuss system ux/ui  desigen and on time','Liton Dev','meet it officer Amena Begum Govt. Primary School','liton ','Incomplete'),(166,'Amena Begum Govt. Primary School','2019-11-07','discuss system fornt end designe','Md.Hemanta Kar','meet it officer Amena Begum Govt. Primary School','hematha','Incomplete');
/*!40000 ALTER TABLE `schedul` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timesheet`
--

DROP TABLE IF EXISTS `timesheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `timesheet` (
  `id` int(11) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `empName` varchar(255) DEFAULT NULL,
  `projectName` varchar(255) DEFAULT NULL,
  `totalHour` varchar(255) DEFAULT NULL,
  `workDescription` varchar(255) DEFAULT NULL,
  `workingTitle` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timesheet`
--

LOCK TABLES `timesheet` WRITE;
/*!40000 ALTER TABLE `timesheet` DISABLE KEYS */;
INSERT INTO `timesheet` VALUES (152,'2019-11-07 00:00:00.0','MD. SALAUDDIN','School managment system','20','create database ER Diagram','Desigen database','salauddin','complete'),(156,'2019-11-07 00:00:00.0','MD. SALAUDDIN','Loan Manegment System','20','Create Database ER Diagram','Desigen database','salauddin','complete'),(157,'2019-11-07 00:00:00.0','Md.Hemanta Kar','School managment system','15','create Dashboard all fornt end','complete front end','hematha','complete'),(158,'2019-11-07 00:00:00.0','Md.Hemanta Kar','Employee management System','12','create admin panel fornt end work','complete front end','hematha','complete'),(159,'2019-11-07 00:00:00.0','Liton Dev','School managment system','20','create admin panale UI/UX designe','Desigen application UI/UX','liton ','complete');
/*!40000 ALTER TABLE `timesheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userinfo` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdDate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `username` varchar(12) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `uemage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,NULL,NULL,_binary '\0',NULL,NULL,'$2a$10$bNAreFxhDk8f.IGm131MauGrdJV7ocSt4Zyr3tjbmiHXBc/ryQ98m','admin',NULL,'rabbi',NULL,'FB_IMG_1570135143751.jpg'),(12,NULL,'W3farid@gmail.com',_binary '\0',NULL,NULL,'$2a$10$NAGI2AjYZTkwfTO8rhXCNOkZJAUuIUVkYXH/NipcKc6nTfjlsjFUC','user',NULL,'W3farid','Md.Farid Ahamed','farid_ahmed.30968feb.jpg'),(13,NULL,'jhaidul@gmail.com',_binary '\0',NULL,NULL,'$2a$10$xWKau6EVfo7STWArtoG1WOkR3Wka11aj1sUsEYNhAb1nKeTgpf4Va','user',NULL,'jahid','Md.Jahidul Islam','jihad.aee89f2d.jpg'),(14,NULL,'asif@gmail.com',_binary '\0',NULL,NULL,'$2a$10$USkNP93Nocpu8YNM/foQsuwcp7veS7PsauXDXgMW0ywqGLRCs9Ygq','user',NULL,'asif','md.abdulla al-asif','asif_developer.b8196dc1.jpg'),(15,NULL,'hemanta@gmail.com',_binary '\0',NULL,NULL,'$2a$10$0XFQYtEO2Qfm3FNIsGxG0.F8jC8oVROYzyq5JnitRW9EXnvXiVp5y','user',NULL,'hematha','Md.Hemanta Kar','hamanta_frontend_developer.ca992234.jpg'),(17,NULL,'sashaker2010@gmail.com',_binary '\0',NULL,NULL,'$2a$10$jQhilvrKUt.Q9HJYIuT5VO7.sEwfQeYecD78YYJyp/EZ.3aKE6yAy','user',NULL,'salauddin','MD. SALAUDDIN','salauddin_developer.1f0c0635.jpg'),(21,NULL,'hitesh@hiteshchoudhary.com',_binary '\0',NULL,NULL,'$2a$10$0WW2Lx027KnQaEBb2.ch6uBBBVIXxmuPAWHpxZyI2v4sFKPfTQkq6','user',NULL,'hitesh','Hitesh Choudhary','hitesh-choudhary.png'),(22,NULL,'heyYK@gmail.com',_binary '\0',NULL,NULL,'$2a$10$FdXJD8yaGrwG8SMPofUizuVtb.CsmGmNAtU.abEH1mVIpzhzmMQVS','user',NULL,'heyyk','Hey YK','22528229_130327197625497_3292855756764932542_n.jpg'),(24,NULL,'adoralim121@gmail.com',_binary '\0',NULL,NULL,'$2a$10$zeEvt4Sfg66eSYOuc0NOc.mopiZgmpFwxnWqrMUVYRi4JNpeHnv5.','user',NULL,'alim','Md.Abdul Alim','alim_developer.3cdc4bdd.jpg'),(25,NULL,'litondev@gmail.com',_binary '\0',NULL,NULL,'$2a$10$1jHzPnnVG8FcGTrBtSeZxuPLQC7Ky2VXuG334yMwWS1T61ECtyg02','user',NULL,'liton ','Liton Dev','liton_dev_designer.5b64120b.jpg'),(26,NULL,'sashaker2010@gmail.com',_binary '\0',NULL,NULL,'$2a$10$ZLN9kKc4/cmjzxSsFlRKRuVwcd1IUvJf65ikPj5naKtxNfyXhMMjO','user',NULL,'rubayet ','Md.Rubayet Islam','rubyet_developer.7b92bc3e.jpg'),(27,NULL,'faruk2010@gmail.com',_binary '\0',NULL,NULL,'$2a$10$GxV4MiAdFP4eP/9skNRc6uBrSLQLuBvH4mbaWOkcGAi5rXHa9.V8K','user',NULL,'faruk','Md.Omar faruk','faruk.jpg'),(28,NULL,'rajudc013@gmail.com',_binary '\0',NULL,NULL,'$2a$10$x/QFjAf.vW9jdToSd0euZuVUz5Ov.C8dmuJiQeNrx9PU6IwdhtWI6','user',NULL,'raju','Md. Raju Ahamed','raju_developer.6d874c37.jpg');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ems'
--

--
-- Dumping routines for database 'ems'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-24 20:20:17
