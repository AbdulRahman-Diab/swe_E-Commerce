-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.25 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for my_db
CREATE DATABASE IF NOT EXISTS `my_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `my_db`;

-- Dumping structure for table my_db.customers
CREATE TABLE IF NOT EXISTS `customers` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  `city` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table my_db.customers: ~6 rows (approximately)
DELETE FROM `customers`;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` (`ID`, `name`, `email`, `phone`, `city`, `address`) VALUES
	(1, 'Hashim', 'h@gmail.com', '010010', 'cairo', '22-b abc st'),
	(2, 'MOhamed', 'moham@gmail.com', '010012210', 'cairo', 'lls, kks'),
	(4, 'Ahmed mohamed', 'ahmed.moh@gmail.com', '01015525665', 'cairo', '123 simsim st'),
	(5, 'Ahmed', 'ADN556', '02250225', 'Caer', 'asd 123 st'),
	(6, 'Ahmed', 'andsm@gmail.com', '011025552', 'cairo', '123 st'),
	(7, 'Ahmed', 'andsm@gmail.com', '011025552', 'cairo', '123 st');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;

-- Dumping structure for table my_db.order
CREATE TABLE IF NOT EXISTS `order` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `customer_ID` int NOT NULL,
  `product_ID` int NOT NULL,
  `order_Date` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `order_customer` (`customer_ID`) USING BTREE,
  KEY `order__product` (`product_ID`) USING BTREE,
  CONSTRAINT `order__product` FOREIGN KEY (`product_ID`) REFERENCES `product` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_customer` FOREIGN KEY (`customer_ID`) REFERENCES `customers` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table my_db.order: ~0 rows (approximately)
DELETE FROM `order`;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;

-- Dumping structure for table my_db.product
CREATE TABLE IF NOT EXISTS `product` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `description` text NOT NULL,
  `price` decimal(6,2) NOT NULL,
  `in_stock` int NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table my_db.product: ~0 rows (approximately)
DELETE FROM `product`;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping structure for table my_db.shipment
CREATE TABLE IF NOT EXISTS `shipment` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `order_ID` int NOT NULL DEFAULT '0',
  `shipment_comp_ID` int NOT NULL DEFAULT '0',
  `order_date` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `shipment__customer` (`shipment_comp_ID`) USING BTREE,
  KEY `shipment_order` (`order_ID`) USING BTREE,
  CONSTRAINT `FK_shipment_shipment_company` FOREIGN KEY (`shipment_comp_ID`) REFERENCES `shipment_company` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `shipment_order` FOREIGN KEY (`order_ID`) REFERENCES `order` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table my_db.shipment: ~0 rows (approximately)
DELETE FROM `shipment`;
/*!40000 ALTER TABLE `shipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment` ENABLE KEYS */;

-- Dumping structure for table my_db.shipment_company
CREATE TABLE IF NOT EXISTS `shipment_company` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `description` text NOT NULL,
  `address` varchar(50) NOT NULL DEFAULT '0',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table my_db.shipment_company: ~0 rows (approximately)
DELETE FROM `shipment_company`;
/*!40000 ALTER TABLE `shipment_company` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_company` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
