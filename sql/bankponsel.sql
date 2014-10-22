-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.36 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table bankponsel.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_id` int(11) DEFAULT '0',
  `code` varchar(50) DEFAULT '0',
  `name` varchar(50) DEFAULT '0',
  `price` decimal(15,2) DEFAULT '0.00',
  `selling_price` decimal(15,2) DEFAULT '0.00',
  `share_percentage` decimal(15,2) DEFAULT '0.00',
  PRIMARY KEY (`id`),
  KEY `FK_product_supplier` (`supplier_id`),
  CONSTRAINT `FK_product_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bankponsel.product: ~0 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


-- Dumping structure for table bankponsel.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT '0',
  `address` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bankponsel.supplier: ~0 rows (approximately)
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;


-- Dumping structure for table bankponsel.transaction_log
CREATE TABLE IF NOT EXISTS `transaction_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_date` timestamp NULL DEFAULT NULL,
  `account_no` varchar(15) DEFAULT NULL,
  `amount` decimal(15,2) DEFAULT NULL,
  `db_cr` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bankponsel.transaction_log: ~0 rows (approximately)
/*!40000 ALTER TABLE `transaction_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_log` ENABLE KEYS */;


-- Dumping structure for table bankponsel.user_profile
CREATE TABLE IF NOT EXISTS `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL DEFAULT '',
  `mobile_no` varchar(50) NOT NULL DEFAULT '',
  `user_type` char(1) NOT NULL DEFAULT '',
  `password` varchar(50) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `address_street` varchar(50) DEFAULT NULL,
  `address_city` varchar(50) DEFAULT NULL,
  `address_postal_code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bankponsel.user_profile: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;


-- Dumping structure for table bankponsel.virtual_account
CREATE TABLE IF NOT EXISTS `virtual_account` (
  `account_no` varchar(15) NOT NULL,
  `balance` decimal(15,2) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`account_no`),
  KEY `FK_virtual_account_user_profile` (`user_id`),
  CONSTRAINT `FK_virtual_account_user_profile` FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bankponsel.virtual_account: ~0 rows (approximately)
/*!40000 ALTER TABLE `virtual_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `virtual_account` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
