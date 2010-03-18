-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.32-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema evidencija
--

CREATE DATABASE IF NOT EXISTS evidencija;
USE evidencija;

--
-- Definition of table `angazovan`
--

DROP TABLE IF EXISTS `angazovan`;
CREATE TABLE `angazovan` (
  `ida` int(11) NOT NULL AUTO_INCREMENT,
  `idz` int(11) NOT NULL,
  `idp` int(11) NOT NULL,
  PRIMARY KEY (`ida`),
  KEY `FK_angazovan_zaposleni` (`idz`),
  KEY `FK_angazovan_pripada` (`idp`),
  CONSTRAINT `FK_angazovan_zaposleni` FOREIGN KEY (`idz`) REFERENCES `zaposleni` (`idz`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_angazovan_pripada` FOREIGN KEY (`idp`) REFERENCES `pripada` (`idp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `angazovan`
--

/*!40000 ALTER TABLE `angazovan` DISABLE KEYS */;
/*!40000 ALTER TABLE `angazovan` ENABLE KEYS */;


--
-- Definition of table `pripada`
--

DROP TABLE IF EXISTS `pripada`;
CREATE TABLE `pripada` (
  `idp` int(11) NOT NULL AUTO_INCREMENT,
  `idt` int(11) NOT NULL,
  `idzan` int(11) NOT NULL,
  `brlj` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idp`),
  KEY `FK_pripada_tim` (`idt`),
  KEY `FK_pripada_zanimanje` (`idzan`),
  CONSTRAINT `FK_pripada_tim` FOREIGN KEY (`idt`) REFERENCES `tim` (`idt`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_pripada_zanimanje` FOREIGN KEY (`idzan`) REFERENCES `zanimanje` (`idzan`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pripada`
--

/*!40000 ALTER TABLE `pripada` DISABLE KEYS */;
/*!40000 ALTER TABLE `pripada` ENABLE KEYS */;


--
-- Definition of table `tim`
--

DROP TABLE IF EXISTS `tim`;
CREATE TABLE `tim` (
  `idt` int(11) NOT NULL AUTO_INCREMENT,
  `nazt` varchar(30) NOT NULL,
  PRIMARY KEY (`idt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tim`
--

/*!40000 ALTER TABLE `tim` DISABLE KEYS */;
/*!40000 ALTER TABLE `tim` ENABLE KEYS */;


--
-- Definition of table `zanimanje`
--

DROP TABLE IF EXISTS `zanimanje`;
CREATE TABLE `zanimanje` (
  `idzan` int(11) NOT NULL AUTO_INCREMENT,
  `nazzan` varchar(30) NOT NULL,
  PRIMARY KEY (`idzan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `zanimanje`
--

/*!40000 ALTER TABLE `zanimanje` DISABLE KEYS */;
/*!40000 ALTER TABLE `zanimanje` ENABLE KEYS */;


--
-- Definition of table `zaposleni`
--

DROP TABLE IF EXISTS `zaposleni`;
CREATE TABLE `zaposleni` (
  `idz` int(11) NOT NULL AUTO_INCREMENT,
  `jmbz` char(1) NOT NULL,
  `imez` varchar(20) NOT NULL,
  `przz` varchar(20) NOT NULL,
  `adrz` varchar(50) NOT NULL,
  `gradz` varchar(20) NOT NULL,
  `zipz` varchar(10) NOT NULL,
  `telz` varchar(15) NOT NULL,
  `mailz` varchar(50) NOT NULL,
  `idzan` int(11) DEFAULT NULL,
  PRIMARY KEY (`idz`),
  UNIQUE KEY `Unique` (`jmbz`),
  KEY `FK_zaposleni_zanimanje` (`idzan`),
  CONSTRAINT `FK_zaposleni_zanimanje` FOREIGN KEY (`idzan`) REFERENCES `zanimanje` (`idzan`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `zaposleni`
--

/*!40000 ALTER TABLE `zaposleni` DISABLE KEYS */;
/*!40000 ALTER TABLE `zaposleni` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
