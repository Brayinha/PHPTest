/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 10.4.24-MariaDB : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `test`;

/*Table structure for table `atraso` */

DROP TABLE IF EXISTS `atraso`;

CREATE TABLE `atraso` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `entrada` time NOT NULL,
  `saida` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `atraso` */

/*Table structure for table `horaextra` */

DROP TABLE IF EXISTS `horaextra`;

CREATE TABLE `horaextra` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `entrada` time NOT NULL,
  `saida` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `horaextra` */

/*Table structure for table `horariotrabalho` */

DROP TABLE IF EXISTS `horariotrabalho`;

CREATE TABLE `horariotrabalho` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `entrada` time(4) NOT NULL,
  `saida` time(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `horariotrabalho` */

insert  into `horariotrabalho`(`id`,`entrada`,`saida`) values 
(1,'10:20:00.0000','14:20:00.0000'),
(2,'20:10:00.0000','14:10:00.0000'),
(3,'10:10:00.0000','20:10:00.0000');

/*Table structure for table `marcacoesfeitas` */

DROP TABLE IF EXISTS `marcacoesfeitas`;

CREATE TABLE `marcacoesfeitas` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `entrada` time NOT NULL,
  `saida` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `marcacoesfeitas` */

insert  into `marcacoesfeitas`(`id`,`entrada`,`saida`) values 
(2,'20:10:00','11:10:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
