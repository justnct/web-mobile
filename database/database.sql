-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: giuaky
-- ------------------------------------------------------
-- Server version	8.0.13
use giuaky;
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
-- Table structure for table `brand_phone`
--

DROP TABLE IF EXISTS `brand_phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `brand_phone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `nameImg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand_phone`
--

LOCK TABLES `brand_phone` WRITE;
/*!40000 ALTER TABLE `brand_phone` DISABLE KEYS */;
INSERT INTO `brand_phone` VALUES (1,'All',NULL),(2,'Iphone',NULL),(3,'Samsung',NULL),(4,'Xiaomi',NULL),(5,'Nokia',NULL),(6,'Oppo',NULL);
/*!40000 ALTER TABLE `brand_phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cart` (
  `id_customer` bigint(20) NOT NULL AUTO_INCREMENT,
  `list_product` varchar(255) DEFAULT NULL,
  `name_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,'3','nct'),(2,'','asd'),(3,'','haha'),(4,'','pikachu'),(5,'','pikachu'),(6,'','xicala'),(7,'','socola');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mobile`
--

DROP TABLE IF EXISTS `mobile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mobile` (
  `id_product` bigint(20) NOT NULL AUTO_INCREMENT,
  `discount` int(11) DEFAULT NULL,
  `discountPrice` int(11) DEFAULT NULL,
  `link_big_picture` text,
  `link_img_picture` text,
  `isChoice` int(11) DEFAULT NULL,
  `name_product` varchar(255) DEFAULT NULL,
  `newest` int(11) DEFAULT NULL,
  `price_product` int(11) DEFAULT NULL,
  `salest` int(11) DEFAULT NULL,
  `descrip` text,
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mobile`
--

LOCK TABLES `mobile` WRITE;
/*!40000 ALTER TABLE `mobile` DISABLE KEYS */;
INSERT INTO `mobile` VALUES (2,0,0,'iphone-12-trang-600x600.jpg','iphone-12-pro-bac-new-600x600-200x200.jpg,iphone-12-pro-vang-dong-new-600x600-200x200.jpg',0,'iPhone 12 128GB',0,27500000,0,'Màn hình 6.1\", Chip Apple A13 Bionic \nRAM 4 GB, ROM 64 GB \nCamera sau: 2 camera 12 MP \nCamera trước: 12 MP \nPin 3110 mAh, Sạc 18 W'),(3,15,2500000,'iphone-12-xanh-la-new-600x600-600x600.jpg','iphone-12-do-new-600x600-200x200.jpg,iphone-12-den-new-600x600-200x200.jpg',0,'iPhone 12 256GB ',0,22000000,0,'Màn hình 6.7\", Chip Apple A14 Bionic \nRAM 6 GB, ROM 512 GB \nCamera sau: 3 camera 12 MP \nCamera trước: 12 MP \nPin 3687 mAh, Sạc 20 W'),(4,0,0,'iphone-12-pro-xanh-duong-new-600x600-600x600.jpg','iphone-11-den-600x600.jpg,iphone-11-xanhla-600x600.jpg',0,'iPhone 11 128GB',0,24000000,0,'Màn hình 6.1\", Chip Apple A14 Bionic \r\nRAM 4 GB, ROM 64 GB \r\nCamera sau: 2 camera 12 MP \r\nCamera trước: 12 MP \r\nPin 2815 mAh, Sạc 20 W'),(5,0,0,'iphone-12-pro-max-xanh-duong-new-600x600-600x600.jpg','iphone-xi-do-600x600.jpg,iphone-12-pro-max-vang-new-600x600-600x600.jpg',0,'iPhone 12 pro max 128GB',0,30000000,0,'Màn hình 6.1\", Chip Apple A14 Bionic \nRAM 4 GB, ROM 64 GB \nCamera sau: 2 camera 12 MP \nCamera trước: 12 MP \nPin 2815 mAh, Sạc 20 W'),(6,10,28000000,'iphone-12-pro-max-vang-new-600x600-1-600x600.jpg','iphone-12-pro-max-vang-new-600x600-1-600x600.jpg,iphone-12-pro-xam-new-600x600-600x600.jpg',0,'iPhone 12 512GB',0,25000000,0,'Màn hình 6.1\", Chip Apple A14 Bionic \nRAM 4 GB, ROM 64 GB \nCamera sau: 2 camera 12 MP \nCamera trước: 12 MP \nPin 2815 mAh, Sạc 20 W'),(7,0,0,'iphone-12-pro-xanh-duong-new-600x600-600x600.jpg','iphone-12-pro-bac-new-600x600-600x600.jpg,iphone-12-mini-mau-tim-3-600x600.jpg',0,'iPhone 12 128GB',0,24000000,0,'Màn hình 6.1\", Chip Apple A14 Bionic \nRAM 4 GB, ROM 64 GB \nCamera sau: 2 camera 12 MP \nCamera trước: 12 MP \nPin 2815 mAh, Sạc 20 W'),(8,0,0,'iphone-12-pro-max-vang-new-600x600-600x600.jpg','iphone-xi-do-600x600.jpg,iphone-12-pro-max-vang-new-600x600-600x600.jpg',0,'iPhone 12 pro max 128GB',0,20000000,0,'Màn hình 6.1\", Chip Apple A14 Bionic \nRAM 4 GB, ROM 64 GB \nCamera sau: 2 camera 12 MP \nCamera trước: 12 MP \nPin 2815 mAh, Sạc 20 W'),(9,0,0,'iphone-xi-do-600x600.jpg','iphone-12-do-new-600x600-200x200.jpg,iphone-12-den-new-600x600-200x200.jpg',1,'iPhone 12 128GB',0,21000000,1,'Màn hình 6.1\", Chip Apple A14 Bionic \nRAM 4 GB, ROM 64 GB \nCamera sau: 2 camera 12 MP \nCamera trước: 12 MP \nPin 2815 mAh, Sạc 20 W'),(10,0,0,'iphone-12-violet-1-600x600.jpg','iphone-12-pro-bac-new-600x600-200x200.jpg,iphone-12-pro-vang-dong-new-600x600-200x200.jpg',0,'iPhone 12 216GB',1,21500000,0,'Màn hình 6.1\", Chip Apple A14 Bionic \nRAM 4 GB, ROM 64 GB \nCamera sau: 2 camera 12 MP \nCamera trước: 12 MP \nPin 2815 mAh, Sạc 20 W'),(11,0,0,'samsung-galaxy-s21-tim-600x600.jpg','samsung-galaxy-s21-plus-den-600x600-600x600.jpg,samsung-galaxy-s21-plus-256gb-bac-600x600-600x600.jpg',0,'Samsung Galaxy S21 5G',0,14990000,0,'Màn hình 6.2\", Chip Exynos 2100 \nRAM 8 GB, ROM 128 GB \nCamera sau: Chính 12 MP & Phụ 64 MP, 12 MP \nCamera trước: 10 MP \nPin 4000 mAh, Sạc 25 W'),(12,20,2500000,'samsung-galaxy-a02-xanhduong-600x600-600x600.jpg','samsung-galaxy-a02-den-600x600-200x200.jpg,samsung-galaxy-a02-do-600x600-200x200.jpg',0,'Samsung Galaxy A02',0,1990000,0,'Màn hình 6.5\", Chip MediaTek MT6739W \nRAM 3 GB, ROM 32 GB \nCamera sau: Chính 13 MP & Phụ 2 MP \nCamera trước: 5 MP \nPin 5000 mAh, Sạc 7.8 W'),(13,0,0,'samsung-galaxy-m51-trang-new-600x600-600x600.jpg','samsung-galaxy-m51-trang-new-600x600-200x200.jpg,samsung-galaxy-m51-den-new-600x600-200x200.jpg',1,'Samsung Galaxy M51',0,8990000,0,'Màn hình 6.7\", Chip Snapdragon 730 \nRAM 8 GB, ROM 128 GB \nCamera sau: Chính 64 MP & Phụ 12 MP, 5 MP, 5 MP \nCamera trước: 32 MP \nPin 7000 mAh, Sạc 25 W'),(14,0,0,'samsung-galaxy-z-fold-2-vang-dong-600x600.jpg','samsung-galaxy-z-fold-2-den-200x200.jpg,samsung-galaxy-z-fold-2-vang-600x600-200x200.jpg',0,'Samsung Galaxy Z Fold2 5G',0,50000000,0,'Màn hình Chính 7.59\" & Phụ 6.23\", Chip Snapdragon 865+ \nRAM 12 GB, ROM 256 GB \nCamera sau: 3 camera 12 MP \nCamera trước: Trong 10 MP & Ngoài 10 MP \nPin 4500 mAh, Sạc 25 W'),(15,0,0,'samsung-galaxy-s21-ultra-256gb-den-600x600-1-600x600.jpg','samsung-galaxy-s21-ultra-bac-600x600-1-600x600.jpg,samsung-galaxy-s21-ultra-256gb-den-600x600-1-600x600.jpg',0,'Samsung Galaxy S21 Ultra 5G 256GB',0,25900000,0,'Màn hình 6.8\", Chip Exynos 2100 \nRAM 12 GB, ROM 256 GB \nCamera sau: Chính 108 MP & Phụ 12 MP, 10 MP, 10 MP \nCamera trước: 40 MP \nPin 5000 mAh, Sạc 25 W'),(16,10,6500000,'oppo-a93-den-14-600x600.jpg','oppo-a93-den-14-200x200.jpg,oppo-a93-trang-14-200x200.jpg',0,'OPPO A93',0,5990000,0,'Màn hình 6.43\", Chip MediaTek Helio P95 \nRAM 8 GB, ROM 128 GB \nCamera sau: Chính 48 MP & Phụ 8 MP, 2 MP, 2 MP \nCamera trước: Chính 16 MP & Phụ 2 MP \nPin 4000 mAh, Sạc 18 W'),(17,0,0,'oppo-reno5-trang-600x600-1-600x600.jpg','oppo-reno5-marvel-thumb-600x600-600x600.jpg,oppo-reno5-5g-thumb-600x600.jpg',1,'OPPO Reno5',0,8690000,0,'Màn hình 6.43\", Chip Snapdragon 720G \nRAM 8 GB, ROM 128 GB \nCamera sau: Chính 64 MP & Phụ 8 MP, 2 MP, 2 MP \nCamera trước: 44 MP \nPin 4310 mAh, Sạc 50 W'),(18,0,0,'oppo-find-x3-pro-black-001-1-600x600.jpg','oppo-find-x3-pro-blue-001-200x200.jpg,oppo-find-x3-pro-black-001-1-200x200.jpg',0,'OPPO Find X3 Pro 5G',0,26990000,0,'Màn hình 6.7\", Chip Snapdragon 888 \nRAM 12 GB, ROM 256 GB  Camera sau: Chính 50 MP & Phụ 50 MP, 13 MP, 3 MP \nCamera trước: 32 MP \nPin 4500 mAh, Sạc 65 W'),(19,0,0,'oppo-reno5-5g-thumb-600x600.jpg','oppo-reno5-5g-black-thumb-200x200.jpg,oppo-reno5-5g-black-thumb-200x200.jpg',0,'OPPO Reno5 5G',0,10990000,1,'Màn hình 6.7\", Chip Snapdragon 888 \nRAM 12 GB, ROM 256 GB  Camera sau: Chính 50 MP & Phụ 50 MP, 13 MP, 3 MP \nCamera trước: 32 MP \nPin 4500 mAh, Sạc 65 W'),(20,0,0,'oppo-reno4-pro-trang-600x600.jpg','oppo-reno4-den-600x600.jpg,oppo-reno4-pro-den-200x200.jpg',0,'OPPO Reno4 Pro',0,9990000,0,'Màn hình 6.43\", Chip Snapdragon 765G \nRAM 8 GB, ROM 128 GB \nCamera sau: Chính 64 MP & Phụ 8 MP, 2 MP, 2 MP \nCamera trước: 32 MP \nPin 4300 mAh, Sạc 65 W'),(21,0,0,'xiaomi-redmi-note-10-5g-xanh-bong-dem-1-600x600.jpg','xiaomi-redmi-note-10-pro-thumb-xam-600x600-600x600.jpg,xiaomi-redmi-note-10-thumb-green-600x600.jpg',0,'Xiaomi Redmi Note 10 5G 8GB',0,5990000,0,'Màn hình 6.5\", Chip MediaTek Dimensity 700 \nRAM 8 GB, ROM 128 GB \nCamera sau: Chính 48 MP & Phụ 2 MP, 2 MP \nCamera trước: 8 MP \nPin 5000 mAh, Sạc 18 W'),(22,0,0,'xiaomi-mi-11-xanhduong-600x600-600x600.jpg','xiaomi-mi-11-lite-4g-blue-600x600.jpg,xiaomi-redmi-9c-3gb-xam-600x600.jpg',0,'Xiaomi Mi 11 5G',1,18490000,0,'Màn hình 6.5\", Chip MediaTek MT6739W \nRAM 3 GB, ROM 32 GB \nCamera sau: Chính 13 MP & Phụ 2 MP \nCamera trước: 5 MP \nPin 5000 mAh, Sạc 7.8 W'),(23,0,0,'xiaomi-mi-10t-pro-den-600x600.jpg','xiaomi-redmi-note-10s-xanh-1-600x600.jpg,xiaomi-redmi-note-10s-thumb-xam-600x600-600x600.jpg',0,'Xiaomi Mi 10T Pro 5G',0,12490000,0,'Màn hình 6.67\", Chip Snapdragon 865 \nRAM 8 GB, ROM 256 GB \nCamera sau: Chính 108 MP & Phụ 13 MP, 5 MP \nCamera trước: 20 MP \nPin 5000 mAh, Sạc 33 W'),(24,0,0,'xiaomi-mi-11-lite-4g-blue-600x600.jpg','xiaomi-mi-11-lite-4g-pink-1-200x200.jpg,xiaomi-mi-11-lite-4g-black-1-200x200.jpg',0,'Xiaomi Mi 11 Lite',0,7590000,0,'Màn hình 6.67\", Chip Snapdragon 732G \nRAM 8 GB, ROM 128 GB \nCamera sau: Chính 108 MP & Phụ 8 MP, 5 MP, 2 MP \nCamera trước: 16 MP \nPin 5020 mAh, Sạc 33 W'),(25,0,0,'xiaomi-redmi-note-10-pro-thumb-xam-600x600-600x600.jpg','xiaomi-redmi-note-10-pro-thumb-xanh-600x600-1-200x200.jpg,xiaomi-redmi-note-10-pro-thumb-vang-dong-600x600-200x200.jpg',0,'Xiaomi Redmi Note 10 Pro (8GB/128GB)',0,7490000,0,'Màn hình 6.55\", Chip Snapdragon 732G \nRAM 8 GB, ROM 128 GB \nCamera sau: Chính 64 MP & Phụ 8 MP, 5 MP \nCamera trước: 16 MP \nPin 4250 mAh, Sạc 33 W'),(26,0,0,'nokia-54-xanh-600x600-600x600.jpg','nokia-54-xanh-600x600-200x200.jpg,nokia-54-tim-600x600-200x200.jpg',0,'Nokia 5.4',0,3490000,0,'Màn hình 6.39\", Chip Snapdragon 662 \nRAM 4 GB, ROM 128 GB \nCamera sau: Chính 48 MP & Phụ 5 MP, 2 MP, 2 MP \nCamera trước: 16 MP \nPin 10 W'),(27,25,3000000,'nokia-34-xam-600x600-600x600.jpg','nokia-34-xanh-200x200-org.png,nokia-34-tim-200x200-1-org.png',0,'Nokia 3.4',0,2590000,1,'Màn hình 6.39\", Chip Snapdragon 460 \nRAM 4 GB, ROM 64 GB \nCamera sau: Chính 13 MP & Phụ 5 MP, 2 MP \nCamera trước: 8 MP \nPin 4000 mAh, Sạc 10 W'),(28,0,0,'nokia-24-xam-600x600.jpg','nokia-24-xanh-200x200.jpg,nokia-24-tim-200x200.jpg',0,'Nokia 2.4',1,2390000,0,'Màn hình 6.5\", Chip MediaTek MT6762 (Helio P22) \nRAM 2 GB, ROM 32 GB \nCamera sau: Chính 13 MP & Phụ 2 MP \nCamera trước: 5 MP \nPin 4500 mAh, Sạc 5 W'),(29,0,0,'nokia-8000-den-new-600x600-600x600.jpg','nokia-8000-4g-den-1-org.jpg,nokia-8000-4g-den-7-org.jpg',0,'Nokia 8000 4G',0,1790000,0,'Màn hình 2.8\", 16 triệu màu \nCamera sau 2 MP \n2 Nano SIM, Hỗ trợ 4G \nThẻ nhớ MicroSD, hỗ trợ tối đa 32 GB \nPin 1500 mAh'),(30,0,0,'nokia-6300-xanh-ngoc-new-600x600-600x600.jpg','nokia-6300-xanh-ngoc-new-600x600-200x200.jpg,nokia-6300-xam-new-600x600-200x200.jpg',0,'Nokia 6300 4G',0,1290000,0,'Màn hình 2.8\", 65.536 màu \nCamera sau 2 MP \n2 SIM thường, Hỗ trợ 2G \nThẻ nhớ MicroSD, hỗ trợ tối đa 32 GB \nPin 1200 mAh');
/*!40000 ALTER TABLE `mobile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN','Quản trị'),(2,'USER','Nguời dùng'),(6,'USER','Người dùng'),(7,'USER','Người dùng'),(8,'USER','NgÆ°á»�i dÃ¹ng');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Nguyễn Chí Thiện','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'admin'),(2,'Nguyễn Chí Thiện','$2a$10$1UvJ4bmjn1OMAXSsjnPzoOyrMeuQ8vNdOe6W3DNIoMQvA2M7E4FTO',1,'nct'),(3,'asd','$2a$10$OE82H5.h4M9mkkaYCL94.evA8lbsX1dSsjtMWjLKwD0S8cfN1jPRW',1,'asd'),(4,'haha','$10$OE82H5.h4M9mkkaYCL94.evA8lbsX1dSsjtMWjLKwD0S8cfN1jPRW',1,'haha'),(10,'pikachu','$2a$10$gXECg7Wnup3legy11X.9NuXOaZXsEEuLDclZEgFp3rHcqujen3jn.',1,'pikachu'),(11,'asdasdsadsadasd','$2a$10$pUU.x6ZthDVRTvC/Vt4zvusmYwGiBU/xntKrbSfmvf0u/mjeo0Umi',1,'pikachu'),(12,'xicala','$2a$10$oCLEklXJ8FzSSdgFu9GN8eHodB6togPK3tFJcY6gXSR52PEbFTVeW',1,'xicala'),(13,'socola','$2a$10$dFsboFUwOJwSvgxY0thH0.QoJE0t6TXnA8lU2xWbRJDKD0uQGYGba',1,'socola');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `userid` bigint(20) NOT NULL,
  `roleid` bigint(20) NOT NULL,
  KEY `FK_jpkvqqgndeonhr2alguthv64e` (`roleid`),
  KEY `FK_jwv62hhuqojjk7pot7kaex3e1` (`userid`),
  CONSTRAINT `FK_jpkvqqgndeonhr2alguthv64e` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_jwv62hhuqojjk7pot7kaex3e1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,2),(3,2),(4,2),(10,2),(11,2),(12,2),(13,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-04 23:28:47
