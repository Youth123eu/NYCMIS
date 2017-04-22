/*
SQLyog Ultimate v8.55 
MySQL - 5.6.14 : Database - nycmisdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nycmisdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `nycmisdb`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `sellingPrice` decimal(10,0) DEFAULT NULL,
  `addedDate` int(11) DEFAULT NULL,
  `stockInHand` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `reOrderLevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_book` (`typeId`),
  CONSTRAINT `FK_book` FOREIGN KEY (`typeId`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`title`,`isbn`,`sellingPrice`,`addedDate`,`stockInHand`,`typeId`,`reOrderLevel`) values (1,'Amma','978-955-21-2853-6','650',201703,13,1,5),(2,'Kaliyugaya','978-955-21-2853-7','400',201703,3,2,5),(3,'Rathu Rosa mala','978-955-21-2853-7','1000',201606,8,3,5),(4,'Guru Geethaya','978-955-21-2853-7','400',201702,9,4,5);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NewIndex1` (`categoryName`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`categoryName`) values (1,'Action'),(6,'Cartoons'),(5,'Commedy'),(3,'Kids'),(4,'Trgedy');

/*Table structure for table `center` */

DROP TABLE IF EXISTS `center`;

CREATE TABLE `center` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `centerId` varchar(10) NOT NULL,
  `centerName` varchar(255) NOT NULL,
  `regDate` date NOT NULL,
  PRIMARY KEY (`centerId`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `center` */

insert  into `center`(`id`,`centerId`,`centerName`,`regDate`) values (1,'kp001','hggtfdd','2017-02-08'),(4,'KP002','Kuliyapitiya','2015-11-02'),(5,'NT003','Naththandiya','2015-11-16');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `salary` int(11) NOT NULL,
  `totSalary` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`id`,`name`,`salary`,`totSalary`) values (1,'surangi',32000,34000),(2,'dulmini',35000,37000),(3,'nirosh',8000,8000),(4,'Darshi',25000,27000),(5,'shamathi',30000,32000);

/*Table structure for table `movie` */

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `movieId` int(11) NOT NULL AUTO_INCREMENT,
  `movieName` varchar(255) NOT NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY (`movieId`),
  KEY `FK_movie` (`categoryId`),
  CONSTRAINT `FK_movie` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `movie` */

insert  into `movie`(`movieId`,`movieName`,`categoryId`) values (1,'Singham',1),(2,'suhada koka',5),(3,'scooby doo',6),(4,'suriya arana',3),(5,'smanala thatu',3),(6,'sarigama',3),(7,'pravegaya',1),(8,'garfeeld',6),(9,'Parithiviran',4);

/*Table structure for table `nycmis_member` */

DROP TABLE IF EXISTS `nycmis_member`;

CREATE TABLE `nycmis_member` (
  `email` varchar(64) NOT NULL,
  `firstName` varchar(32) NOT NULL,
  `lastName` varchar(32) NOT NULL,
  `password` varchar(255) NOT NULL,
  `registeredDate` date NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `nycmis_member` */

insert  into `nycmis_member`(`email`,`firstName`,`lastName`,`password`,`registeredDate`) values ('amila@gmail.com','Amila','Ruvan','abc123','2017-01-22'),('surangi@gmail.com','Surangi','Kumari','abc123','2017-01-22');

/*Table structure for table `nycmis_role` */

DROP TABLE IF EXISTS `nycmis_role`;

CREATE TABLE `nycmis_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(64) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_nycmis_role` (`email`),
  CONSTRAINT `FK_nycmis_role` FOREIGN KEY (`email`) REFERENCES `nycmis_member` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `nycmis_role` */

insert  into `nycmis_role`(`id`,`email`,`roleId`) values (1,'surangi@gmail.com',2),(2,'amila@gmail.com',1);

/*Table structure for table `profit` */

DROP TABLE IF EXISTS `profit`;

CREATE TABLE `profit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `month` varchar(50) NOT NULL,
  `netProfit` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `profit` */

insert  into `profit`(`id`,`month`,`netProfit`) values (1,'January',12000),(2,'February',13000),(3,'March',15000),(4,'April',16000);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `regNumber` varchar(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`regNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `type` */

insert  into `type`(`id`,`typeName`) values (1,'Sinhala Novel'),(2,'Sinhala Short stories'),(3,'Translation Novel'),(4,'Translation Short stories');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
