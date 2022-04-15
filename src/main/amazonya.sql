-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: amazonya
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
                        `product_id` bigint NOT NULL,
                        `user_id` int NOT NULL,
                        `quantity` int NOT NULL,
                        PRIMARY KEY (`product_id`,`user_id`),
                        KEY `FKl70asp4l4w0jmbm1tqyofho4o` (`user_id`),
                        CONSTRAINT `FKl70asp4l4w0jmbm1tqyofho4o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
                        CONSTRAINT `FKpu4bcbluhsxagirmbdn7dilm5` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
                            `categoryId` int NOT NULL,
                            `categoryImage` varchar(255) DEFAULT NULL,
                            `categoryName` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'assets/images/demos/demo-4/cats/1.png','Computer & Laptop'),(2,'assets/images/demos/demo-4/cats/6.png','Smart Watches'),(3,'assets/images/demos/demo-4/cats/3.png','Smart Phones');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (4);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_details` (
                                 `order_id` int NOT NULL,
                                 `product_id` bigint NOT NULL,
                                 `user_id` int NOT NULL,
                                 `price` decimal(19,2) DEFAULT NULL,
                                 `quantity` int NOT NULL,
                                 PRIMARY KEY (`order_id`,`product_id`,`user_id`),
                                 KEY `FK4q98utpd73imf4yhttm3w0eax` (`product_id`),
                                 KEY `FKosrffjv6k8mr7ipsmmq7o7u1e` (`user_id`),
                                 CONSTRAINT `FK4q98utpd73imf4yhttm3w0eax` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
                                 CONSTRAINT `FKjyu2qbqt8gnvno9oe9j2s2ldk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
                                 CONSTRAINT `FKosrffjv6k8mr7ipsmmq7o7u1e` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `address` varchar(255) DEFAULT NULL,
                          `dateTime` datetime(6) DEFAULT NULL,
                          `email` varchar(255) DEFAULT NULL,
                          `phoneNumber` varchar(255) DEFAULT NULL,
                          `state` varchar(255) DEFAULT NULL,
                          `totalPrice` decimal(19,2) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_images`
--

DROP TABLE IF EXISTS `product_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_images` (
                                  `product_id` bigint NOT NULL,
                                  `images` varchar(255) DEFAULT NULL,
                                  KEY `FKqnq71xsohugpqwf3c9gxmsuy` (`product_id`),
                                  CONSTRAINT `FKqnq71xsohugpqwf3c9gxmsuy` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_images`
--

LOCK TABLES `product_images` WRITE;
/*!40000 ALTER TABLE `product_images` DISABLE KEYS */;
INSERT INTO `product_images` VALUES (1,'https://amazonya.s3.eu-central-1.amazonaws.com/2e46685f-fb92-4102-86d4-e3874ea9e581dell-vos-3510-i5-4gb_1t-15.6-3.jpg'),(1,'https://amazonya.s3.eu-central-1.amazonaws.com/8f9062b8-df58-4576-b83a-b39d7d902969dell-vos-3510-i5-4gb_1t-15.6-2.jpg'),(2,'https://amazonya.s3.eu-central-1.amazonaws.com/d19d6170-0bc3-47cb-b08a-a518696e05adlenovo-labtop-to-ideapad-5-15itl05-i7--2_3.jpg'),(2,'https://amazonya.s3.eu-central-1.amazonaws.com/ba29333f-f835-4298-b115-d8fe99134e11lenovo-labtop-to-ideapad-5-15itl05-i7--4_3.jpg'),(3,'https://amazonya.s3.eu-central-1.amazonaws.com/24bb3db5-98b9-4775-8802-c743ad24ab10huawei_labtop_matebook_14_inch_2020_8gb_ram_256gb_ssd-2.jpg'),(3,'https://amazonya.s3.eu-central-1.amazonaws.com/60644e86-12cf-464d-a803-90f240599df0huawei_labtop_matebook_14_inch_2020_8gb_ram_256gb_ssd-5.jpg'),(3,'https://amazonya.s3.eu-central-1.amazonaws.com/7b683ec3-a143-4acf-8a20-d4b137f9d853huawei_labtop_matebook_14_inch_2020_8gb_ram_256gb_ssd-3.jpg'),(4,'https://amazonya.s3.eu-central-1.amazonaws.com/35984ba0-8f31-413c-943c-34b9e38de05dapple-iphone-13-512g-starlight-3.jpg'),(4,'https://amazonya.s3.eu-central-1.amazonaws.com/830613f8-9d94-4290-a83d-56707f672fd0apple-iphone-13-512g-starlight-2.jpg');
/*!40000 ALTER TABLE `product_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `creationDate` datetime(6) DEFAULT NULL,
                            `description` varchar(255) DEFAULT NULL,
                            `mainImage` varchar(255) DEFAULT NULL,
                            `name` varchar(255) NOT NULL,
                            `price` decimal(19,2) NOT NULL,
                            `quantity` int NOT NULL,
                            `rating` double NOT NULL,
                            `salePercentage` double NOT NULL,
                            `state` varchar(255) DEFAULT NULL,
                            `totalPurchasesNumber` int NOT NULL,
                            `category_categoryId` int DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `FKdxwn3lf5fgvapvxdyyuf2mtuu` (`category_categoryId`),
                            CONSTRAINT `FKdxwn3lf5fgvapvxdyyuf2mtuu` FOREIGN KEY (`category_categoryId`) REFERENCES `category` (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'2022-04-11 19:34:55.204271','Brand: Dell\r\nDisplay: 15.6 inch\r\nProcessor: Intel core I5-1135G7\r\nRam: 4 GB\r\nHard drive: 1TB\r\nVideo Graphics: Nvidia MX350 2GB\r\nWeight: 1.69 kg\r\nColor: Carbon Black','https://amazonya.s3.eu-central-1.amazonaws.com/27c7814e-96bf-4b34-8a8a-f9d7ae3712eddell-vos-3510-i5-4gb_1t-15.6-1.jpg','Dell Vostro 3510 ',11950.00,3,0,0,'NEW',0,1),(2,'2022-04-11 19:38:12.061168','Brand: Lenovo\r\nDisplay: 15.6 FHD\r\nProcessor: Intel Celeron N4020 2.8GHz 4MB\r\nGraphics: Integrated Intel UHD Graphics 600\r\nMemory: 4GB DDR4\r\nStorage: 1TB HDD\r\nCamera: 0.3MP with Privacy Shutter','https://amazonya.s3.eu-central-1.amazonaws.com/101b0d2f-e19c-45ad-a1a4-4e03a6f3632alenovo-labtop-to-ideapad-5-15itl05-i7--1_2.jpg','Lenovo Laptop Celeron',6050.00,10,0,0,'NEW',0,1),(3,'2022-04-11 19:39:57.581417','Brand: HUAWEI\r\nOperating System: Windows 10 Home\r\nMaterial:Aluminum alloy\r\nDisplay:14 inches - IPS\r\nResolution:2160x1440, 185 PPI\r\nMaximum brightness: 300 nits (Typ','https://amazonya.s3.eu-central-1.amazonaws.com/fb996a3e-06b7-4708-84cb-68d80bb5ccf8huawei_labtop_matebook_14_inch_2020_8gb_ram_256gb_ssd.jpg','HUAWEI Labtop MateBook 14',21117.00,5,0,0,'NEW',0,1),(4,'2022-04-11 19:42:08.508386','Display Size In Inches: 6.1 inches\r\nProcessor CPU: Hexa-core\r\nInternal Memory Capacity In GB: 512 GB\r\nRear Camera: 12 MP + 12 MP\r\nFront Camera: 12 MP +SL 3D\r\nBattery: 3240 mAh','https://amazonya.s3.eu-central-1.amazonaws.com/8b999792-4df9-4708-9434-7179b1bac425apple-iphone-13-512g-starlight-1.jpg','Apple IPhone 13 512GB',26600.00,2,0,0,'NEW',0,3);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `address` varchar(255) NOT NULL,
                        `creditLimit` decimal(19,2) NOT NULL,
                        `dateOfBirth` date DEFAULT NULL,
                        `email` varchar(255) NOT NULL,
                        `pass` varchar(255) NOT NULL,
                        `role` varchar(255) NOT NULL,
                        `userName` varchar(255) NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-11 19:46:30
