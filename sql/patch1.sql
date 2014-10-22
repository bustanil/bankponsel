ALTER TABLE `product`
	CHANGE COLUMN `selling_price` `margin` DECIMAL(15,2) NULL DEFAULT '0.00' AFTER `price`;