-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.30-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema ais2009
--

CREATE DATABASE IF NOT EXISTS ais2009;
USE ais2009;

--
-- Definition of table `faktura`
--

DROP TABLE IF EXISTS `faktura`;
CREATE TABLE `faktura` (
  `IDF` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID fakture',
  `FK_K` int(10) unsigned NOT NULL COMMENT 'ID klijenta',
  `Datum` date NOT NULL COMMENT 'Datum fakture',
  `Iznos` decimal(12,2) DEFAULT NULL COMMENT 'Iznos fakture',
  `Napomena` varchar(200) DEFAULT NULL COMMENT 'Napomena o fakturi',
  PRIMARY KEY (`IDF`),
  KEY `FK_faktura_partner` (`FK_K`),
  CONSTRAINT `FK_faktura_partner` FOREIGN KEY (`FK_K`) REFERENCES `klijent` (`IDK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faktura`
--

/*!40000 ALTER TABLE `faktura` DISABLE KEYS */;
/*!40000 ALTER TABLE `faktura` ENABLE KEYS */;


--
-- Definition of table `klijent`
--

DROP TABLE IF EXISTS `klijent`;
CREATE TABLE `klijent` (
  `IDK` int(10) unsigned NOT NULL COMMENT 'ID klijenta',
  `Naziv` varchar(45) NOT NULL COMMENT 'Naziv ili ime klijenta',
  `Adresa` varchar(45) NOT NULL COMMENT 'Adresa klijenta',
  `Mesto` varchar(25) NOT NULL COMMENT 'Mesto klijenta',
  `Telefon` varchar(15) DEFAULT NULL COMMENT 'Telefon klijenta',
  PRIMARY KEY (`IDK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `klijent`
--

/*!40000 ALTER TABLE `klijent` DISABLE KEYS */;
/*!40000 ALTER TABLE `klijent` ENABLE KEYS */;


--
-- Definition of table `roba`
--

DROP TABLE IF EXISTS `roba`;
CREATE TABLE `roba` (
  `IDR` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `Naziv` varchar(50) NOT NULL COMMENT 'Naziv robe',
  `Kolicina` int(10) unsigned NOT NULL COMMENT 'Kolicina robe na skladistu',
  `JM` varchar(10) NOT NULL COMMENT 'Jedinica mere',
  `Napomena` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IDR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roba`
--

/*!40000 ALTER TABLE `roba` DISABLE KEYS */;
/*!40000 ALTER TABLE `roba` ENABLE KEYS */;


--
-- Definition of table `stavke`
--

DROP TABLE IF EXISTS `stavke`;
CREATE TABLE `stavke` (
  `IDS` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID Stavke',
  `FK_F` int(10) unsigned NOT NULL COMMENT 'ID fakture',
  `FK_R` int(10) unsigned NOT NULL COMMENT 'ID Robe',
  `Kolicina` decimal(12,2) NOT NULL COMMENT 'Kolicina robe na fakturi',
  `Napomena` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`IDS`),
  KEY `FK_stavke_faktura` (`FK_F`),
  KEY `FK_stavke_roba` (`FK_R`),
  CONSTRAINT `FK_stavke_faktura` FOREIGN KEY (`FK_F`) REFERENCES `faktura` (`IDF`),
  CONSTRAINT `FK_stavke_roba` FOREIGN KEY (`FK_R`) REFERENCES `roba` (`IDR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stavke`
--

/*!40000 ALTER TABLE `stavke` DISABLE KEYS */;
/*!40000 ALTER TABLE `stavke` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
