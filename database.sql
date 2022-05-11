-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: prince_tailors
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` decimal(18,2) NOT NULL DEFAULT '0.00',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `phone_number` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,'Kunal','kunal@email.com',2799.97,'2022-01-26 15:11:10','9988125467','2022-01-26 15:38:13'),(3,'Jay','jay@email.com',7599.91,'2022-01-26 15:33:09','9988125457','2022-01-26 17:49:10'),(4,'Franklin','franklin@email.com',9199.93,'2022-01-26 17:44:58','8811232134','2022-01-26 17:49:10'),(5,'Michael','michael@email.com',1599.98,'2022-01-26 17:44:58','8898232734','2022-01-26 17:49:10'),(6,'Trevor','trevor@email.com',3899.97,'2022-01-26 17:44:58','8824234204','2022-01-26 17:49:10'),(7,'Arthur','arthur@email.com',3199.98,'2022-01-26 17:44:58','8091672134','2022-01-26 17:49:10');
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `bill_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`product_id`,`bill_id`),
  KEY `bill_id` (`bill_id`),
  CONSTRAINT `bill_id` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`),
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,1,1),(3,1,4),(4,1,1),(1,2,2),(5,2,1),(3,3,2),(4,3,4),(6,3,3),(3,4,3),(5,4,1),(4,5,2),(7,5,2);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(45) NOT NULL,
  `customer_number` bigint NOT NULL,
  `email_id` varchar(40) NOT NULL,
  `product1` varchar(45) NOT NULL DEFAULT '0',
  `price1` int NOT NULL DEFAULT '0',
  `product2` varchar(45) NOT NULL DEFAULT '0',
  `price2` int NOT NULL DEFAULT '0',
  `product3` varchar(45) NOT NULL DEFAULT '0',
  `price3` int NOT NULL DEFAULT '0',
  `product4` varchar(45) NOT NULL DEFAULT '0',
  `price4` int NOT NULL DEFAULT '0',
  `product5` varchar(45) NOT NULL DEFAULT '0',
  `price5` int NOT NULL DEFAULT '0',
  `product6` varchar(45) NOT NULL DEFAULT '0',
  `price6` int NOT NULL DEFAULT '0',
  `product7` varchar(45) NOT NULL DEFAULT '0',
  `price7` int NOT NULL DEFAULT '0',
  `product8` varchar(45) NOT NULL DEFAULT '0',
  `price8` int NOT NULL DEFAULT '0',
  `total` int NOT NULL,
  `paid` int NOT NULL,
  `balance` int NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_id_UNIQUE` (`order_id`),
  UNIQUE KEY `customer_name_UNIQUE` (`customer_name`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (47,'Jay',9082150672,'pateljay5430@gmail.com',' Shirts',8000,' Pants',4225,' denims',7895,' jackets',7599,'0',0,'0',0,'0',0,'0',0,27719,899,26820),(48,'Patel',9082150672,'pateljay5431@gmail.com',' Shirts',8000,' Pants',7888,'0',0,'0',0,'0',0,'0',0,'0',0,'0',0,15888,0,15888),(49,'Abc',9082150672,'pateljay5431@gmail.com',' vbfkjbkj',78983,' kjnrk',8798,' jnk',342,'0',0,'0',0,'0',0,'0',0,'0',0,88123,0,88123);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-11 21:32:49
