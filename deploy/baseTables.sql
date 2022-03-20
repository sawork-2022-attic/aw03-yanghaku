DROP DATABASE IF EXISTS `pos`;
CREATE DATABASE `pos`;
use pos;


-- 1. Table Product

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`
(
    `ID`    varchar(255) NOT NULL,
    `NAME`  varchar(255) NOT NULL,
    `PRICE` double       NOT NULL,
    `IMAGE` varchar(255) NOT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8MB4;

-- 2. Table Item

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`
(
    `PRODUCT`  varchar(255) NOT NULL,
    `QUANTITY` int          NOT NULL,
    PRIMARY KEY (`PRODUCT`),
    FOREIGN KEY (`PRODUCT`) REFERENCES product (`ID`) ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8MB4;
