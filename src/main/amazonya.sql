-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: localhost    Database: amazonya
-- ------------------------------------------------------
-- Server version	8.0.28

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
  `phoneNumber` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `totalPrice` decimal(19,2) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
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
INSERT INTO `product_images` VALUES (1,'https://amazonya.s3.eu-central-1.amazonaws.com/85af5262-a2dc-4493-9bb5-bdb17fc173ae3-Dell_Vostro_3510.5_lc8n-30.png_8bfa-tx_Easy-Resize.com_h1jx-00.jpg'),(1,'https://amazonya.s3.eu-central-1.amazonaws.com/1887c6a5-85a2-4de1-8486-56bf3770adfd1-Dell_Vostro_3510_Easy-Resize.com_4hkc-zl.jpg_0hhp-m4_Easy-Resize.com__2__w5lb-sh.jpg'),(1,'https://amazonya.s3.eu-central-1.amazonaws.com/ffbda54c-7418-41ec-88dd-68c0d8c93d742-dell-notebook-vostro-156-intel-core-i7-1165g7-8-gb-ram-1tb-black-vostro-15-3510-i7.jpg'),(2,'https://amazonya.s3.eu-central-1.amazonaws.com/218ebc21-1b95-4be9-8e1e-f55c0a9743272-hpzh939-4_1.jpg'),(2,'https://amazonya.s3.eu-central-1.amazonaws.com/13940c6a-8378-495e-b77e-685f8648f2641-hp250-g8-01-500x500.jpg'),(3,'https://amazonya.s3.eu-central-1.amazonaws.com/60887f0d-0148-4ac2-9700-a60ffa573b7e2-xiaomi41F7qu-NKdL._AC_SY741_.jpg'),(3,'https://amazonya.s3.eu-central-1.amazonaws.com/de586cea-6cc6-4706-9464-a6aeedbf8bea1-xiaomi41F7qu-NKdL._AC_SY741_.jpg'),(4,'https://amazonya.s3.eu-central-1.amazonaws.com/e3b39964-7493-4ea2-ab01-a45ccdae10831-apple61i8Vjb17SL._AC_SX679_.jpg'),(4,'https://amazonya.s3.eu-central-1.amazonaws.com/2c9c144c-651e-480b-9d4d-724759d46af12-apple61i8Vjb17SL._AC_SX679_.jpg'),(4,'https://amazonya.s3.eu-central-1.amazonaws.com/cca48227-4e75-4760-b056-7228aeef50663-apple61i8Vjb17SL._AC_SX679_.jpg'),(5,'https://amazonya.s3.eu-central-1.amazonaws.com/1fce2ed0-649c-4fda-98b8-90fb7901c4374_357_1.jpg'),(5,'https://amazonya.s3.eu-central-1.amazonaws.com/23e75623-e4a8-43a9-a04d-3ef861fcc1c22_463_1.jpg'),(5,'https://amazonya.s3.eu-central-1.amazonaws.com/03b11288-a99c-4f86-999e-ac47393245cdamazfit_watch_gts_2_-_midnight_black.jpg'),(6,'https://amazonya.s3.eu-central-1.amazonaws.com/73c112ea-24b5-4ded-aff0-028a2fa1044dsamsung-z-fold3--5g-sm-f926bds-_12_256_-phantom-green-3.jpg'),(6,'https://amazonya.s3.eu-central-1.amazonaws.com/883cb1ad-38b8-4573-ae70-661ea8ef1d1asamsung-z-fold3--5g-sm-f926bds-_12_256_-phantom-green-4.jpg'),(6,'https://amazonya.s3.eu-central-1.amazonaws.com/0761145a-9d80-4133-a463-d92c371bc85esamsung-z-fold3--5g-sm-f926bds-_12_256_-phantom-green-6.jpg'),(6,'https://amazonya.s3.eu-central-1.amazonaws.com/5a6270a3-ed19-4813-a0e2-1ef03f97e3f2samsung-z-fold3--5g-sm-f926bds-_12_256_-phantom-green-2.jpg'),(7,'https://amazonya.s3.eu-central-1.amazonaws.com/4ec41dd5-4e95-4d4f-8bf0-c39965d46fd36_165.jpg'),(7,'https://amazonya.s3.eu-central-1.amazonaws.com/aef03bab-90ea-42dd-a705-927fffc581611_405.jpg'),(8,'https://amazonya.s3.eu-central-1.amazonaws.com/f4de05f1-d03f-474a-acda-5d32528c164d6NW5N_4_Supersize.jpg.png'),(8,'https://amazonya.s3.eu-central-1.amazonaws.com/7a6ecd8c-0b19-4317-9d61-682aa380594en6503vn3501emea01_2105-2.jpg.png'),(8,'https://amazonya.s3.eu-central-1.amazonaws.com/f68f3334-e704-4fb5-99e5-c106cac6cf15LAPTOP_DELL_3501_EGYPTLAPTOP_317u-fs.jpg.png'),(9,'https://amazonya.s3.eu-central-1.amazonaws.com/3704eacd-1ba5-41c1-9d91-c103fb2fddc2lenovo-v155-15api-81v5-notebook-en_4_zyf5-0j.jpg.png'),(9,'https://amazonya.s3.eu-central-1.amazonaws.com/b24e7e84-545a-4b8d-ad0a-5647e8b81f8alenovo-v155-15api-81v5-notebook-en.jpg.png'),(16,'https://amazonya.s3.eu-central-1.amazonaws.com/c37867be-b5ea-4622-a1e6-8a6e15c38c73macbook_air_2020_m1.jpeg'),(16,'https://amazonya.s3.eu-central-1.amazonaws.com/863e8ee1-7eb3-4f7e-aad3-ed2071b893e4images.jpeg'),(16,'https://amazonya.s3.eu-central-1.amazonaws.com/b93e387b-e88f-4136-8151-e3184c681c6dmacbook-air-space-gray-select-201810.jpeg'),(17,'https://amazonya.s3.eu-central-1.amazonaws.com/95138fb5-659b-4f24-bb25-6eb0e4c6d598download.jpeg'),(17,'https://amazonya.s3.eu-central-1.amazonaws.com/2e13e50a-5583-4102-9fdd-ab0af26e8bd8og__eecvr2clk3cm_specs.png'),(17,'https://amazonya.s3.eu-central-1.amazonaws.com/61ce939a-26fb-44ed-bd5c-6075b563d789Apple-iPhone-11.jpeg'),(18,'https://amazonya.s3.eu-central-1.amazonaws.com/861f9564-2af0-4fde-ada5-52c3fbe7be86iPhone-13-2.jpeg'),(18,'https://amazonya.s3.eu-central-1.amazonaws.com/9761a97c-4e69-4d6a-a269-78a1e14585c8download.jpeg'),(19,'https://amazonya.s3.eu-central-1.amazonaws.com/9c04e434-95c2-446e-ae3f-9cf2b6bbc5ddipad-air-2020-features.jpeg'),(20,'https://amazonya.s3.eu-central-1.amazonaws.com/99c5df28-d748-4247-8432-1afa2d4809dcimages.jpeg'),(20,'https://amazonya.s3.eu-central-1.amazonaws.com/aba5683d-6ed9-405b-91de-e595ce6c706aimages.png'),(20,'https://amazonya.s3.eu-central-1.amazonaws.com/9b84f79d-df82-4448-96ac-74c6d2067371image_1024.jpeg'),(21,'https://amazonya.s3.eu-central-1.amazonaws.com/e312e741-7662-426c-9265-27c305791e4d71vCuRn4CkL._AC_SX342_.jpg'),(21,'https://amazonya.s3.eu-central-1.amazonaws.com/8093e603-0bec-4d1a-b843-1308288ab1ae51VUr+lzveL._AC_SX522_.jpg');
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
  `creationDate` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'2022-04-04','','Dell Vostro 3510',15400.00,12,0,0,'NEW',0,1),(2,'2022-04-04','Intel Core i3-1005G1 4GB 1TB HDD INTEL GRAPHICS 15.6\" HD DOS Black','HP 250 G8',8249.00,3,0,0,'NEW',0,1),(3,'2022-04-04','9A Dual SIM Mobile Phone, 13 MP Camera, 6.53 Inch Touch Screen, 2 GB RAM, 32 GB, 4G LTE - Granite Grey','Xiaomi Redmi',2275.00,5,0,0,'NEW',0,3),(4,'2022-04-04','6.7-inch Super Retina XDR display with ProMotion for a faster, more responsive feel','Apple iPhone 13 Pro Max 256GB Blue',25399.00,6,0,0,'NEW',0,3),(5,'2022-04-04','Brand: Amazfit\r\nModel Name: Watch GTS 2\r\nScreen: 1.65 inches AMOLED, 348 x 442\r\nBody: Aluminum alloy\r\nWaterproofing Grade:5 ATM\r\nBattery Capacity:246 mAh (typical value)\r\nCharging Time: About 2 hours','Amazfit Watch GTS 2 - Midnight Black',3199.00,2,0,0,'NEW',0,2),(6,'2022-04-04','Display Size In Inches: 7.6 inches\r\nProcessor CPU: Octa-core\r\nInternal Memory Capacity In GB: 256\r\nMemory RAM In GB: 12\r\nRear Camera:12 MP + 12 MP + 12 MP\r\nFront Camera: 4 MP + 10 MP\r\nBattery: 4400\r\n','Samsung Galaxy Z Fold3',32500.00,5,0,0,'NEW',0,3),(7,'2022-04-04','Display Size In Inches: 6.9 inches\r\nProcessor CPU: Octa-core\r\nInternal Memory Capacity In GB: 256 GB\r\nMemory RAM In GB: 8 GB\r\nRear Camera: 108 MP + 12 MP + 12 MP\r\nFront Camera: 10 MP\r\nBattery: 4500','Samsung Galaxy Note20 Ultra',19200.00,2,0,0,'NEW',0,3),(8,'2022-04-04','Amplified display: A brilliant FHD panel (optionally up to 220 nits) offers more brightness and vivid color for an enhanced front-of-screen experience, and a 2-sided narrow border ','DELL Vostro 3501',9000.00,12,0,0,'NEW',0,1),(9,'2022-04-04','LAPTOP LENOVO V155 AMD R3-3200U RAM 4GB HDD 1TB Integrated AMD Radeon GREY','LAPTOP LENOVO V155',9600.00,4,0,0,'NEW',0,1),(16,'2022-04-04','Chip   Apple M1 chip 8-core CPU with 4 perform­ance cores and 4 efficiency cores 7-core GPU, 8-core GPU 16-core Neural Engine Battery and Power1  Up to 15 hours ','Macbook Air M1 (2020)',22000.00,7,0,0,'NEW',0,1),(17,'2022-04-04','Liquid Retina HD display 6.1‑inch (diagonal) all-screen LCD Multi-Touch display with IPS technology 1792‑by‑828‑pixel resolution at 326 ppi 1400:1 contrast ratio (typical) True Tone display Wide color','Apple iPhone 11 ',12000.00,4,0,0,'NEW',0,3),(18,'2022-04-04','HDR display True Tone Wide color (P3) Haptic Touch 2,000,000:1 contrast ratio (typical) 800 nits max brightness (typical); 1200 nits max brightness (HDR) Fingerprint-resistant oleophobic coating','Apple iPhone 13',19000.00,10,0,0,'NEW',0,3),(19,'2022-04-04','Liquid Retina display 10.9-inch (diagonal) LED‑backlit Multi‑Touch display with IPS technology 2360-by-1640-pixel resolution at 264 pixels per inch (ppi) Wide color display (P3) True Tone display.','iPad Air',20000.00,4,0,0,'NEW',0,3),(20,'2022-04-04','Big screen. Huge impact. The challenge was to create a bigger display while barely expanding the dimensions of the watch itself. To do so, the display was completely re‑engineered reducing the borders','Apple Watch Series 7',9000.00,7,0,0,'NEW',0,2),(21,'2022-04-04','Glass front (Sapphire crystal), ceramic/sapphire crystal back, stainless steel frame 50m water resistant, Retina OLED, 1000 nits (peak), Natural language commands and dictation (talking mode)','Apple Watch Series 3',4000.00,20,0,0,'NEW',0,2);
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

-- Dump completed on 2022-04-04 20:33:29
