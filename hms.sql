CREATE DATABASE  IF NOT EXISTS `hospital` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `hospital`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: hospital
-- ------------------------------------------------------
-- Server version	5.6.44-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('beauty','beauty');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `did` varchar(20) NOT NULL,
  `pid` varchar(15) NOT NULL,
  `status` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,'d1001','p1001',1,'2019-07-10'),(2,'d1001','p1001',1,'2019-07-09'),(3,'d1001','p1002',0,NULL),(4,'d1002','p1002',0,'2020-01-06'),(5,'44','45',0,'2019-01-01'),(6,'hii','hello',0,'2020-08-10'),(7,'d1001','p1001',0,'2019-07-13'),(8,'d1001','p1001',0,'2019-07-07'),(9,'d1001','p1001',0,'2019-01-01'),(10,'d1001','p1002',0,'2019-07-10');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `date` date NOT NULL,
  `id` varchar(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `age` int(5) NOT NULL,
  `gender` varchar(8) NOT NULL,
  `blood` varchar(4) NOT NULL,
  `dept` varchar(20) NOT NULL,
  `phone` double NOT NULL,
  `email` varchar(30) NOT NULL,
  `maritial` varchar(15) NOT NULL,
  `address` varchar(20) NOT NULL,
  `room` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES ('2019-07-05','d1001','beauty',60,'Male','o','Dental',9097527033,'hgcud@gmail.com','Married','vhgfhdu',2,'d1001','doctor1','0'),('2019-07-09','d1002','dfgf23',30,'Male','df2','Neurology',43523,'fdgf123','Married','4323sd',342,'d1002','123','0'),('2019-07-10','d1003','3456',3455,'Male','4566','Physician',5465565655,'uygj','Single','iyuk',567,'d1003','123','0'),('2019-07-10','d1004','dfs',34,'Male','o+','Physician',9876543210,'abv@123.vuh','Single','fghjk',4,'d1004','123','0');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `date` date NOT NULL,
  `id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `age` int(5) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` varchar(20) NOT NULL,
  `phone` double NOT NULL,
  `status` varchar(10) NOT NULL,
  `disease` varchar(20) NOT NULL,
  `room` int(11) NOT NULL,
  `maritial` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES ('2019-07-08','p1001','jkhjkh',12,'Male','jhhjk',3456,'0','jhhjk',22,'Single'),('2019-07-08','p1002','dfds',23,'Male','sfgdf',4567,'0','dsa3',34,'Single'),('2019-07-08','p1003','fdssd',232,'Male','fdd3',9876534,'0','fdd2',22,'Single'),('2019-07-10','p1004','errt',34,'Male','dfs',1234567890,'0','dsf',2,'Single'),('2019-07-10','p1005','egh',34,'Male','fs',9876543210,'0','34',2,'Single');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prescription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` varchar(20) DEFAULT NULL,
  `did` varchar(10) DEFAULT NULL,
  `medicine` varchar(50) DEFAULT NULL,
  `dose` int(11) DEFAULT NULL,
  `course` int(11) DEFAULT NULL,
  `dop` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` VALUES (1,'p1001','d1001','kuch bhi ',1,4,'2019-07-08'),(2,'p1001','d1001','23df',3,34,'2019-07-10'),(3,'p1001','d1001','tik',2,12,'2019-07-10'),(4,'p1001','d1001','hi',23,32,'2019-07-10'),(5,'p1002','d1001','dflk',23,23,'2019-07-10'),(6,'p1002','d1002','df',4,3,'2019-07-10');
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receptionist`
--

DROP TABLE IF EXISTS `receptionist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receptionist` (
  `date` date NOT NULL,
  `id` varchar(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `age` int(5) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `blood` varchar(4) NOT NULL,
  `email` varchar(40) NOT NULL,
  `phone` double NOT NULL,
  `maritial` varchar(15) NOT NULL,
  `address` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receptionist`
--

LOCK TABLES `receptionist` WRITE;
/*!40000 ALTER TABLE `receptionist` DISABLE KEYS */;
INSERT INTO `receptionist` VALUES ('2019-07-10','r1001','a',32,'Male','a','a@123.com',234,'Single','sadf','r1001','r1002','0'),('2019-07-09','r1002','asd',12,'Male','a','3454fd',345,'Single','dfs343','r1002','123','0');
/*!40000 ALTER TABLE `receptionist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-10 21:19:08
