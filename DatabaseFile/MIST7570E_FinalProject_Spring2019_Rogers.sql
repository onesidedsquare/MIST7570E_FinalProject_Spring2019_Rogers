DROP DATABASE  `MIST7570E_FinalProject_Spring2019_Rogers`;
CREATE DATABASE  IF NOT EXISTS `MIST7570E_FinalProject_Spring2019_Rogers`;
USE `MIST7570E_FinalProject_Spring2019_Rogers`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userID_UNIQUE` (`userID`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `users` VALUES 
	(1,'ShopUser','10/w7o2juYBrGMh32/KbveULW9jk2tejpyUAD+uC6PE='),
    (3,'guest','10/w7o2juYBrGMh32/KbveULW9jk2tejpyUAD+uC6PE=');

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
    `productID` VARCHAR(3) NOT NULL,
    `productName` VARCHAR(20),
    `price` DOUBLE(6 , 2 ),
    `quantity` INT(4),
    `inventory` INT(4),
    PRIMARY KEY (`productID`),
    UNIQUE KEY `productID_UNIQUE` (`productID`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `product` VALUES 
	('GR','Green Lime','20', '29','110'),
	('YE','Yellow Lime','25', '22','130'),
	('GP','Grape Lime','31', '18','150'),
	('OR','Orange Lime','28', '21','170');

DROP TABLE IF EXISTS `orders`;
CREATE  TABLE IF NOT EXISTS `orders` (
  `orderID` INT NOT NULL AUTO_INCREMENT,
  `userID` INT NULL,
  `green_amount` INT,
  `yellow_amount` INT,
  `grape_amount` INT, 
  `orange_amount` INT,
  `purchased` boolean,
  PRIMARY KEY (`orderID`),
   UNIQUE KEY `orderID_UNIQUE` (`orderID`),
  INDEX `fk_Order_1_idx` (`userID` ASC) ,
  CONSTRAINT `fk_Order_1`
    FOREIGN KEY (`userID`)
    REFERENCES `users` (`userID` ))
    ENGINE=InnoDB DEFAULT CHARSET=latin1;
    
INSERT INTO `orders` VALUES 
	('100', '1','2','3','4','5', false);



    
