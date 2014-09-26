CREATE TABLE `Customers` (
  `customer_id` BIGINT(20) NOT NULL,
  `gender` VARCHAR(6) NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `email_address` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `phone_number` CHAR(10) NOT NULL,
  `address_line_1` VARCHAR(200) NOT NULL,
  `address_line_2` VARCHAR(200) NOT NULL,
  `city` VARCHAR(50) NOT NULL,
  `country` VARCHAR(50) NOT NULL,
  `zip_code` CHAR(5) NOT NULL,
   PRIMARY KEY (`customer_id`)
)
                
