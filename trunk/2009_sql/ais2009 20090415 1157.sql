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
-- Create schema ais2009
--

CREATE DATABASE IF NOT EXISTS ais2009;
USE ais2009;

--
-- Definition of table `faktura`
--

DROP TABLE IF EXISTS `faktura`;
CREATE TABLE `faktura` (
  `idf` bigint(20) NOT NULL AUTO_INCREMENT,
  `Datum` date NOT NULL,
  `Iznos` decimal(12,2) DEFAULT NULL,
  `Napomena` varchar(200) DEFAULT NULL,
  `FK_K` bigint(20) NOT NULL,
  PRIMARY KEY (`idf`),
  KEY `FKBF5C03804409584C` (`FK_K`),
  CONSTRAINT `FKBF5C03804409584C` FOREIGN KEY (`FK_K`) REFERENCES `klijent` (`idk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faktura`
--

/*!40000 ALTER TABLE `faktura` DISABLE KEYS */;
INSERT INTO `faktura` (`idf`,`Datum`,`Iznos`,`Napomena`,`FK_K`) VALUES 
 (-3,'2009-04-07','444.00','ItFzRvVvXeKlNpXpCgItLnOpXsWvYgFiUhFjYxHsGtGoVyGsHjDrJqOlVyKzOaJuWaLfIsUmQfAzKhSiHtQgQlHhHtReOjYmOhIoHpHxPhKoVmQwWaQxZgEwKhLnQyYgWcHuUvAnVjJdYfQtYjEgOqJhIoQuUwYjBzKwMzCoCxGoIzLeSyKvAkLjYoXfTnRwIlYbMqMv',-3),
 (-2,'2009-04-07','333.00','PwQyMgIqArAeVsLcLxSzEmQtVhAgLmTsHfTnNoRdGxQjQuXjDfGzXuAqMyXdIoDiJsVyPbWbHgTqRiXqPjGzDnKaMbCwAyAbGrCsTfDzRqDwNfJhOxNgDyArKhUbOcMxDwVlYvSsTfJzHoXkFnWnDzUmVrAqZkCoEgJuUzZlAcUwHpGgBhAiVpJlEiFoTgUuZsMdDcKm',-2),
 (-1,'2009-04-07','222.00','IvKzGlBzCmWiJpRiJjFgMeJhNrFaIhTgGnFySxZsPsBbDcHvQuFyZwVxIoKuDnDiHoMvJqHzZsRyMwBuCdScEyGjXxUaEoAdWnXnDxClKwCvCyYqQzCgZhUoLsUhVsGoJyTyCkQaXoBdNmCeMpPwLpTsBmSdRlVbWeQrOpQrNvUiCtMvMvSpDvUpKdKiKbRuLdOaHyFj',-1);
/*!40000 ALTER TABLE `faktura` ENABLE KEYS */;


--
-- Definition of table `klijent`
--

DROP TABLE IF EXISTS `klijent`;
CREATE TABLE `klijent` (
  `idk` bigint(20) NOT NULL AUTO_INCREMENT,
  `Adresa` varchar(45) NOT NULL,
  `Mesto` varchar(25) NOT NULL,
  `Naziv` varchar(45) NOT NULL,
  `Telefon` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `klijent`
--

/*!40000 ALTER TABLE `klijent` DISABLE KEYS */;
INSERT INTO `klijent` (`idk`,`Adresa`,`Mesto`,`Naziv`,`Telefon`) VALUES 
 (-3,'WxKqYiDeMlJwAhEuCwNaBuSyDaNnWaZnZbMuXdTaKnSmE','RqVwEzOiYhTbTtUiSgZsSnRyF','ibm','XlWnKrQxIfEqQyU'),
 (-2,'CbZsSiYkNkFoHtBwUnZuOqKkMcOzLtJxBdZmHwIwQrMsX','UvAcTbIaClJtSiBeBeMbMiNoM','ftn','ZsCqVvNqUaFtNbG'),
 (-1,'HiXoJpBuXtAtUrDdCqBmObKjDxXdHqGhBvKgOrSbUoJxX','ShMxFaXbUbBbKjWyIqPeNyYnJ','empiry','ItTrXnDeZmMhSoE');
/*!40000 ALTER TABLE `klijent` ENABLE KEYS */;


--
-- Definition of table `roba`
--

DROP TABLE IF EXISTS `roba`;
CREATE TABLE `roba` (
  `idr` bigint(20) NOT NULL AUTO_INCREMENT,
  `JM` varchar(10) NOT NULL,
  `Kolicina` bigint(20) NOT NULL,
  `Napomena` varchar(100) DEFAULT NULL,
  `Naziv` varchar(50) NOT NULL,
  PRIMARY KEY (`idr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roba`
--

/*!40000 ALTER TABLE `roba` DISABLE KEYS */;
INSERT INTO `roba` (`idr`,`JM`,`Kolicina`,`Napomena`,`Naziv`) VALUES 
 (-3,'QlRmBnMmFx',4926245746331546624,'OjYmHdHhAjMqUlIoOtHbYlQeMmReUvAsWsCpHlRoHiXlVoVvEcNuIoWcKzVnRwJaPvVyCjDoNjApEfKhNgLsYmVqYwVlFrXpUtXy','IpYaTdWlNgIbUuYlQaLkFcDkMkFsRsGrMkOtAaGdFkBqCbKmYy'),
 (-2,'IdFiLeWyRb',6303494677240221696,'IkDiHkYfShYcSzZuIsRzBhBiIbGeAaLgXvUkMnLuOtCnSgRpNrYiMyMlZnEcZgVkZsJuFqUeXhVpHsBxDcVyVaSyHiZwRrYgHpJe','KlSlIxTuCnSyZbPsZvVfOjMbDjZoAlTvDpGmWrDhZaRaXvHeDe'),
 (-1,'JbRbZyGaNi',286454454773035008,'QwFdXqTrXdSfEpDjTjObYaHbFkDbIkLtAxVuNeSzIxKtBcRyHgZzAiChWfFlVpKtPuYlFfLtGqIxIgTlVkJaJcQbYwHlTnXaElAt','CxQzDrYbKcOrTtUgZaBtHsWiTiIbPbLdPkCwXlSoHnIvWuYuYn');
/*!40000 ALTER TABLE `roba` ENABLE KEYS */;


--
-- Definition of table `stavke`
--

DROP TABLE IF EXISTS `stavke`;
CREATE TABLE `stavke` (
  `ids` bigint(20) NOT NULL AUTO_INCREMENT,
  `Kolicina` decimal(12,2) NOT NULL,
  `Napomena` varchar(15) DEFAULT NULL,
  `FK_R` bigint(20) NOT NULL,
  `FK_F` bigint(20) NOT NULL,
  PRIMARY KEY (`ids`),
  KEY `FKCACDD630DADD6682` (`FK_R`),
  KEY `FKCACDD63028E5D85E` (`FK_F`),
  CONSTRAINT `FKCACDD63028E5D85E` FOREIGN KEY (`FK_F`) REFERENCES `faktura` (`idf`),
  CONSTRAINT `FKCACDD630DADD6682` FOREIGN KEY (`FK_R`) REFERENCES `roba` (`idr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stavke`
--

/*!40000 ALTER TABLE `stavke` DISABLE KEYS */;
INSERT INTO `stavke` (`ids`,`Kolicina`,`Napomena`,`FK_R`,`FK_F`) VALUES 
 (-3,'33.00','SxCsSoPgIrKoSuH',-3,-3),
 (-2,'22.00','NhLmPfZoGrJbPmH',-2,-2),
 (-1,'11.00','LmUbSqNcYmRyJvJ',-1,-1);
/*!40000 ALTER TABLE `stavke` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
