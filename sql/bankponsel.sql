-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.33-community - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for bankponsel
CREATE DATABASE IF NOT EXISTS `bankponsel` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bankponsel`;


-- Dumping structure for table bankponsel.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_id` int(11) DEFAULT '0',
  `name` varchar(50) DEFAULT '0',
  `price` decimal(15,2) DEFAULT '0.00',
  `margin` decimal(15,2) DEFAULT '0.00',
  `share_percentage` decimal(15,2) DEFAULT '0.00',
  `code` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_product_supplier` (`supplier_id`),
  CONSTRAINT `FK_product_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Dumping data for table bankponsel.product: ~12 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `supplier_id`, `name`, `price`, `margin`, `share_percentage`, `code`) VALUES
	(1, 1, 'AS 5000', 4000.00, 1000.00, 0.40, 'Tsel5000As'),
	(2, 1, 'AS 10000', 8000.00, 1500.00, 0.40, 'Tsel10000As'),
	(3, 1, 'AS 25000', 23000.00, 2000.00, 0.40, 'Tsel25000As'),
	(4, 1, 'AS 50000', 45000.00, 2500.00, 0.40, 'Tsel50000As'),
	(5, 1, 'SIMPATI 5000', 4000.00, 1000.00, 0.40, 'Tsel5000SM'),
	(6, 1, 'SIMPATI 10000', 8500.00, 1000.00, 0.40, 'Tsel10000SM'),
	(7, 1, 'SIMPATI 25000', 22000.00, 2500.00, 0.40, 'Tsel25000SM'),
	(8, 1, 'SIMPATI 50000', 46000.00, 3000.00, 0.40, 'Tsel50000SM'),
	(9, 2, 'M3 5000', 4000.00, 500.00, 0.40, 'Inds5000M3'),
	(10, 2, 'M3 10000', 7500.00, 2000.00, 0.40, 'Inds10000M3'),
	(11, 2, 'M3 50000', 46000.00, 3000.00, 0.40, 'Inds50000M3'),
	(12, 2, 'Mentari 5000', 4000.00, 1000.00, 0.40, 'Inds5000MN');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


-- Dumping structure for table bankponsel.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT '0',
  `address` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table bankponsel.supplier: ~2 rows (approximately)
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` (`id`, `name`, `address`) VALUES
	(1, 'TELKOMSEL', 'JAKARTA'),
	(2, 'INDOSAT', 'JAKARTA');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;


-- Dumping structure for table bankponsel.transaction_log
CREATE TABLE IF NOT EXISTS `transaction_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_date` timestamp NULL DEFAULT NULL,
  `account_no` varchar(15) DEFAULT NULL,
  `amount` decimal(15,2) DEFAULT NULL,
  `db_cr` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_transaction_log_virtual_account` (`account_no`),
  CONSTRAINT `FK_transaction_log_virtual_account` FOREIGN KEY (`account_no`) REFERENCES `virtual_account` (`account_no`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;

-- Dumping data for table bankponsel.transaction_log: ~78 rows (approximately)
/*!40000 ALTER TABLE `transaction_log` DISABLE KEYS */;
INSERT INTO `transaction_log` (`id`, `transaction_date`, `account_no`, `amount`, `db_cr`) VALUES
	(3, '2014-10-24 00:53:24', '087725755268', 50000.00, 'D'),
	(4, '2014-10-24 01:25:39', '087725755268', 50000.00, 'C'),
	(5, '2014-10-24 01:28:52', '087725755268', 50000.00, 'C'),
	(6, '2014-10-24 02:16:53', '087725755268', 100000.00, 'D'),
	(7, '2014-10-24 02:19:13', '087725755268', 25000.00, 'C'),
	(8, '2014-10-24 02:19:13', '081321765898', 25000.00, 'D'),
	(9, '2014-10-24 02:21:02', '087725755268', 100000.00, 'D'),
	(10, '2014-10-24 02:22:41', '087725755268', 15000.00, 'C'),
	(11, '2014-10-24 02:22:41', '081321765898', 15000.00, 'D'),
	(12, '2014-10-24 02:24:32', '081321765898', 5000.00, 'C'),
	(13, '2014-10-24 02:24:32', '087725755268', 5000.00, 'D'),
	(14, '2014-10-24 02:27:47', '087725755268', 10000.00, 'C'),
	(15, '2014-10-24 02:27:47', '081321765898', 10000.00, 'D'),
	(16, '2014-10-24 02:30:10', '081321765898', 10000.00, 'C'),
	(17, '2014-10-24 02:30:10', '087725755268', 10000.00, 'D'),
	(18, '2014-10-24 09:21:19', '098789878', 100000.00, 'D'),
	(19, '2014-10-24 09:22:51', '098789878', 50000.00, 'C'),
	(20, '2014-10-24 09:30:24', '098789878', 10000.00, 'C'),
	(21, '2014-10-24 09:35:56', '098789878', 10000.00, 'C'),
	(22, '2014-10-24 09:35:56', '087725755268', 10000.00, 'D'),
	(23, '2014-10-24 09:48:14', '098789878', 5000.00, 'C'),
	(24, '2014-10-24 09:48:15', '087725755268', 5000.00, 'D'),
	(25, '2014-10-24 10:30:56', '098789878', 5000.00, 'D'),
	(26, '2014-10-24 10:32:27', '098789878', 5000.00, 'D'),
	(27, '2014-10-24 10:34:52', '098789878', 5000.00, 'D'),
	(28, '2014-10-24 10:37:50', '098789878', 100.00, 'D'),
	(29, '2014-10-24 10:47:28', '098789878', 120.00, 'D'),
	(30, '2014-10-24 11:09:53', '098789878', 50.00, 'D'),
	(31, '2014-10-24 11:15:20', '098789878', 100.00, 'D'),
	(32, '2014-10-24 14:32:49', '087725755268', 5000.00, 'C'),
	(33, '2014-10-24 14:34:29', '081321765898', 4000.00, 'C'),
	(34, '2014-10-24 14:42:08', '081321765898', 4000.00, 'C'),
	(35, '2014-10-24 14:50:50', '081321765898', 4000.00, 'C'),
	(36, '2014-10-24 15:01:40', '081321765898', 4400.00, 'C'),
	(37, '2014-10-24 15:04:20', '081321765898', 4000.00, 'C'),
	(38, '2014-10-24 15:20:38', '081321765898', 0.00, 'C'),
	(39, '2014-10-24 15:22:29', '081321765898', 0.00, 'C'),
	(41, '2014-10-24 15:29:08', '081321765898', 4000.00, 'C'),
	(42, '2014-10-24 15:34:14', '081321765898', 4000.00, 'C'),
	(43, '2014-10-24 15:35:57', '081321765898', 4000.00, 'C'),
	(44, '2014-10-24 15:38:18', '081321765898', 4000.00, 'C'),
	(45, '2014-10-24 15:39:32', '081321765898', 4000.00, 'C'),
	(46, '2014-10-24 15:42:26', '081321765898', 4000.00, 'C'),
	(47, '2014-10-24 15:43:27', '081321765898', 4000.00, 'C'),
	(48, '2014-10-24 15:46:20', '098789878', 4500.00, 'C'),
	(49, '2014-10-24 15:46:42', '098789878', 4500.00, 'C'),
	(50, '2014-10-24 15:47:46', '081321765898', 4000.00, 'C'),
	(51, '2014-10-24 15:48:49', '081321765898', 4000.00, 'C'),
	(52, '2014-10-24 15:50:37', '081321765898', 4000.00, 'C'),
	(53, '2014-10-24 15:53:47', '081321765898', 0.00, 'C'),
	(54, '2014-10-24 16:00:25', '081321765898', 4000.00, 'C'),
	(55, '2014-10-24 16:03:59', '081321765898', 4000.00, 'C'),
	(56, '2014-10-24 16:09:23', '081321765898', 4000.00, 'C'),
	(57, '2014-10-24 16:28:34', '081321765898', 4000.00, 'C'),
	(58, '2014-10-27 09:55:33', '081321765898', 84000.00, 'C'),
	(59, '2014-10-27 09:57:48', '081321765898', 84000.00, 'C'),
	(60, '2014-10-27 10:53:36', '098789878', 1000.00, 'C'),
	(61, '2014-10-27 11:03:59', '098789878', 370.00, 'C'),
	(62, '2014-10-27 11:09:39', '098789878', 10000.00, 'C'),
	(63, '2014-10-27 11:55:04', '081321765898', 8000.00, 'C'),
	(64, '2014-10-27 11:56:58', '081321765898', 8000.00, 'C'),
	(65, '2014-10-27 13:38:05', '087725755268', 15000.00, 'D'),
	(66, '2014-10-27 13:47:35', '081321765898', 200000.00, 'C'),
	(67, '2014-10-27 13:48:00', '081321765898', 0.00, 'C'),
	(68, '2014-10-27 15:23:28', '098789878', 10000.00, 'D'),
	(69, '2014-10-27 15:26:35', '081321765898', 10000.00, 'C'),
	(70, '2014-10-27 15:51:39', '081321765898', 10000.00, 'C'),
	(71, '2014-10-27 16:01:04', '087725755268', 100000.00, 'D'),
	(72, '2014-10-27 18:11:50', '081321765898', 8900.00, 'C'),
	(73, '2014-10-28 14:22:51', '098789878', 10000.00, 'C'),
	(74, '2014-10-28 14:22:51', '087725755268', 10000.00, 'D'),
	(75, '2014-10-28 14:26:20', '098789878', 100.00, 'C'),
	(76, '2014-10-28 14:26:20', '087725755268', 100.00, 'D'),
	(77, '2014-10-28 16:13:45', '098789878', 5000.00, 'C'),
	(78, '2014-10-28 16:14:51', '098789878', 5000.00, 'C'),
	(79, '2014-10-28 16:15:58', '098789878', 5000.00, 'C'),
	(80, '2014-10-28 16:28:11', '098789878', 5000.00, 'C'),
	(81, '2014-10-28 16:31:33', '098789878', 5000.00, 'C');
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Dumping data for table bankponsel.user_profile: ~4 rows (approximately)
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` (`id`, `email`, `mobile_no`, `user_type`, `password`, `first_name`, `last_name`, `birth_date`, `address_street`, `address_city`, `address_postal_code`) VALUES
	(1, 'dani@ymail.com', '087821898698', 'A', '12389', 'Dani', 'Rosyana', '1993-11-09', 'Cimaragas', 'Ciamis', '0265'),
	(17, 'budi@rocketmail.com', '098789878', 'C', '67845', 'Budiman', '', '1991-10-01', 'Bekasi', 'Bekasi', '09876'),
	(18, 'tois10@gmail.com', '087725755268', 'C', '78945', 'Tois', 'Andreas', '1991-10-01', 'Bekasi', 'Bekasi', '09876'),
	(19, 'candra2@yahoo.com', '081321765898', 'M', '005', 'Candra', 'Aja', '1991-10-01', 'Bogor', 'Bogor', '0667');
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

-- Dumping data for table bankponsel.virtual_account: ~3 rows (approximately)
/*!40000 ALTER TABLE `virtual_account` DISABLE KEYS */;
INSERT INTO `virtual_account` (`account_no`, `balance`, `user_id`) VALUES
	('081321765898', 571100.00, 19),
	('087725755268', 140100.00, 18),
	('098789878', 990000.00, 17);
/*!40000 ALTER TABLE `virtual_account` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
