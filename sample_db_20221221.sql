-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: sample_db
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book_description_image`
--

DROP TABLE IF EXISTS `book_description_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_description_image` (
  `bdi_seq` int NOT NULL AUTO_INCREMENT,
  `bdi_bi_seq` int NOT NULL,
  `bdi_filename` varchar(255) NOT NULL,
  PRIMARY KEY (`bdi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_description_image`
--

LOCK TABLES `book_description_image` WRITE;
/*!40000 ALTER TABLE `book_description_image` DISABLE KEYS */;
INSERT INTO `book_description_image` VALUES (1,4,'desc_1671594620740.jpg'),(2,4,'desc_1671594620740.jpg'),(3,4,'desc_1671594620741.jpg'),(4,4,'desc_1671594620742.jpg'),(5,4,'desc_1671594620743.jpg'),(6,4,'desc_1671594620743.jpg'),(7,5,'GKCYFTWIguyajxgp1671596144610.jpg'),(8,5,'REKINAXJpqeluvxb1671596144611.jpg'),(9,5,'GULOXTPEbkdcspzd1671596144612.jpg'),(10,5,'OFYKCJDYfojhhpac1671596144612.jpg'),(11,5,'KPVOEBXOhfcnfvpr1671596144613.jpg'),(12,5,'XZWFQZBRxcwyrznf1671596144613.jpg');
/*!40000 ALTER TABLE `book_description_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_image`
--

DROP TABLE IF EXISTS `book_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_image` (
  `bimg_seq` int NOT NULL AUTO_INCREMENT,
  `bimg_bi_seq` int NOT NULL,
  `bimg_filename` varchar(255) NOT NULL,
  `bimg_thumbnail` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`bimg_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_image`
--

LOCK TABLES `book_image` WRITE;
/*!40000 ALTER TABLE `book_image` DISABLE KEYS */;
INSERT INTO `book_image` VALUES (1,4,'book_1671594620734.jpg',1),(2,5,'AKIHXJSCqinancvk1671596144601.jpg',1);
/*!40000 ALTER TABLE `book_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_info`
--

DROP TABLE IF EXISTS `book_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_info` (
  `bi_seq` int NOT NULL AUTO_INCREMENT,
  `bi_title` varchar(255) NOT NULL,
  `bi_sub` varchar(255) NOT NULL,
  `bi_reg_dt` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`bi_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_info`
--

LOCK TABLES `book_info` WRITE;
/*!40000 ALTER TABLE `book_info` DISABLE KEYS */;
INSERT INTO `book_info` VALUES (4,'만일 내가 인생을 다시 산다면(10만 부 기념 스페셜 에디션)','벌써 마흔이 된 당신에게 해 주고 싶은 말들 42','2022-12-21 00:00:00'),(5,'만일 내가 인생을 다시 산다면(10만 부 기념 스페셜 에디션)','벌써 마흔이 된 당신에게 해 주고 싶은 말들 42','2022-12-21 00:00:00');
/*!40000 ALTER TABLE `book_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sample_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-21 14:23:42
