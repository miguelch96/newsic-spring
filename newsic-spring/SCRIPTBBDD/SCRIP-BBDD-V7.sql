CREATE DATABASE  IF NOT EXISTS `newsic` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `newsic`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: newsic
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `albumid` int(11) NOT NULL AUTO_INCREMENT,
  `artistaid` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fechapublicacion` date DEFAULT NULL,
  `rutaimgalbum` varchar(200) DEFAULT NULL,
  `reproducciones` int(11) DEFAULT '0',
  `favoritos` int(11) DEFAULT '0',
  PRIMARY KEY (`albumid`),
  KEY `fk_artista_album_idx` (`artistaid`),
  CONSTRAINT `fk_artista_album` FOREIGN KEY (`artistaid`) REFERENCES `artista` (`artistaid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (1,2,'ITALIAN RYEGRASS POLLEN','2017-02-08','../images/b2.jpg',NULL,NULL),(2,6,'Aspir Low','2016-08-10','../images/b4.jpg',NULL,NULL),(3,11,'Volunteer Training','2016-06-11','../images/b5.jpg',NULL,NULL),(4,14,'Oracle VM','2016-07-31','../images/b2.jpg',NULL,NULL),(5,2,'HTRI Software','2016-07-15','../images/b4.jpg',NULL,NULL),(6,11,'Khalix','2016-12-10','../images/b2.jpg',NULL,NULL),(7,8,'TPMS','2016-10-13','../images/b2.jpg',NULL,NULL),(8,5,'Djbdns','2016-12-31','../images/b5.jpg',NULL,NULL),(9,9,'Knowledge Discovery','2016-10-10','../images/b2.jpg',NULL,NULL),(10,12,'iOS','2016-06-30','../images/b1.jpg',NULL,NULL),(11,3,'Kinesiology','2017-04-15','../images/b5.jpg',NULL,NULL),(12,14,'Jive SBS','2016-06-25','../images/b5.jpg',NULL,NULL),(13,8,'Custom CMS Development','2016-12-23','../images/b5.jpg',NULL,NULL),(14,4,'GTD','2016-11-11','../images/b1.jpg',NULL,NULL),(15,14,'Alarm Systems','2016-12-01','../images/b5.jpg',NULL,NULL),(16,8,'CGI programming','2016-06-09','../images/b5.jpg',NULL,NULL),(17,4,'Pianist','2017-01-13','../images/b4.jpg',NULL,NULL),(18,6,'MTOs','2016-07-17','../images/b2.jpg',NULL,NULL),(19,9,'Scheduling','2016-11-19','../images/b5.jpg',NULL,NULL),(20,5,'CDMA 1X','2016-12-12','../images/b2.jpg',NULL,NULL),(21,8,'HDR Photography','2017-03-22','../images/b5.jpg',NULL,NULL),(22,12,'Vi','2017-05-11','../images/b1.jpg',NULL,NULL),(23,7,'MPLS-TP','2016-08-05','../images/b3.jpg',NULL,NULL),(24,6,'Data Collection','2016-10-05','../images/b2.jpg',NULL,NULL),(25,14,'UART','2016-08-19','../images/b2.jpg',NULL,NULL),(26,14,'UF/DF','2016-08-14','../images/b2.jpg',NULL,NULL),(27,11,'Start-up Consulting','2017-03-02','../images/b4.jpg',NULL,NULL),(28,14,'Urdu','2017-03-09','../images/b1.jpg',NULL,NULL),(29,5,'HGV','2017-03-17','../images/b3.jpg',NULL,NULL),(30,12,'Pymol','2016-07-02','../images/b1.jpg',NULL,NULL),(31,10,'RS/6000','2016-06-11','../images/b3.jpg',NULL,NULL),(32,13,'GSA Schedule','2016-07-03','../images/b1.jpg',NULL,NULL),(33,6,'Strategy','2016-10-19','../images/b2.jpg',NULL,NULL),(34,7,'Tween','2017-03-09','../images/b5.jpg',NULL,NULL),(35,5,'Cd','2016-11-20','../images/b1.jpg',NULL,NULL),(36,2,'Customer Follow-up','2017-05-30','../images/b4.jpg',NULL,NULL),(37,12,'Gourmet','2016-12-16','../images/b1.jpg',NULL,NULL),(38,11,'EZNews','2017-04-06','../images/b5.jpg',NULL,NULL),(39,6,'ATG CSC','2016-12-20','../images/b4.jpg',NULL,NULL),(40,13,'Major Gift Development','2016-12-06','../images/b5.jpg',NULL,NULL),(41,3,'Buyers','2017-03-31','../images/b3.jpg',NULL,NULL),(42,3,'HCS 2000','2017-03-05','../images/b2.jpg',NULL,NULL),(43,12,'Book Illustration','2016-11-05','../images/b2.jpg',NULL,NULL),(44,12,'KRAs','2016-09-10','../images/b3.jpg',NULL,NULL),(45,12,'Athletic Performance','2016-07-03','../images/b5.jpg',NULL,NULL),(46,14,'Non-linear Editing','2016-09-24','../images/b2.jpg',NULL,NULL),(47,11,'Alternative Investments','2016-08-30','../images/b1.jpg',NULL,NULL),(48,4,'Weddings','2016-06-08','../images/b3.jpg',NULL,NULL),(49,14,'XFP','2017-03-25','../images/b4.jpg',NULL,NULL),(50,3,'Window Displays','2016-06-12','../images/b5.jpg',NULL,NULL),(51,7,'Runway','2017-05-30','../images/b2.jpg',NULL,NULL),(52,5,'Fraud','2017-04-07','../images/b1.jpg',NULL,NULL),(53,2,'New sensations','2016-12-22','../images/imgalbumes/newsensations.png',NULL,NULL),(54,25,'Bad Senses','2016-10-28','../images/imgalbumes/purosentimiento.jpg',NULL,NULL),(55,27,'Secretos','2016-02-02','../images/imgalbumes/secretos.jpg',NULL,NULL),(56,26,'Felicidad','2017-06-18','../images/imgalbumes/felicidad.jpg',NULL,NULL);
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artista`
--

DROP TABLE IF EXISTS `artista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artista` (
  `artistaid` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `fechanacimiento` date NOT NULL,
  `nombreartistico` varchar(50) NOT NULL,
  `rutaimgperfil` varchar(200) DEFAULT '../images/imgperfildefault.png',
  `email` varchar(45) NOT NULL,
  `passwd` varchar(45) NOT NULL,
  PRIMARY KEY (`artistaid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artista`
--

LOCK TABLES `artista` WRITE;
/*!40000 ALTER TABLE `artista` DISABLE KEYS */;
INSERT INTO `artista` VALUES (2,'Thomas','Hammond','1993-12-27','facilisis,','../images/a6.jpg','',''),(3,'Igor','Kramer','1993-06-12','pretium aliquet,','../images/a8.jpg','',''),(4,'Nathaniel','Mccall','1998-08-10','Pellentesque tincidunt','../images/a8.jpg','',''),(5,'Hayden','Nixon','1986-01-18','arcu','../images/a6.jpg','',''),(6,'Phillip','Boyer','1991-04-05','Morbi neque','../images/a8.jpg','',''),(7,'Gavin','Gilliam','1993-01-28','auctor, velit','../images/a7.jpg','',''),(8,'Nasim','Schwartz','1994-04-12','eu','../images/a8.jpg','',''),(9,'Oren','Tyler','1999-07-22','Etiam','../images/a6.jpg','',''),(10,'Jarrod','Cline','1992-07-30','Donec non','../images/a6.jpg','',''),(11,'Erasmus','Faulkner','1993-06-14','justo. Praesent','../images/a6.jpg','',''),(12,'Bernard','Austin','1996-05-31','neque. Morbi','../images/a8.jpg','',''),(13,'Tarik','Barry','1988-05-20','id magna','../images/a6.jpg','',''),(14,'Robert','Patton','1992-03-06','nunc sed','../images/a7.jpg','',''),(15,'pruebanombre','pruebaapelliod','1993-04-13','pruebanombre2','\'../images/imgperfildefault.png\'','prueba1@prueba1','12345'),(16,'Nombre2','Apellido2','1980-11-17','Artistico2','../images/imgperfildefault.png','prueba2@prueba2','12345'),(17,'nombre3','apellido3','1990-10-20','Artistico 3','../images/imgperfildefault.png','prueba3@prueba3','12345'),(21,'4353545','qfqf','1990-03-05','adgadg','../images/imgperfildefault.png','afasfgfdg','12345'),(22,'Adriana','Tenorio','1999-05-16','Adriana Music','../images/imgperfildefault.png','adriana@tenorio','12345'),(23,'Jesus','Mendoza','1990-02-12','Jesus Music','../images/imgperfildefault.png','jesus@mendoza','12345'),(24,'Manuel','Corrado','1990-02-12','Manuel Music','../images/imgperfildefault.png','manuel@corrado','12345'),(25,'Juan','Mendoza','1996-11-11','JuanJo','../images/imgartistas/juanmendoza.jpg','juan@mendoza','12345'),(26,'David','Molina','1990-07-11','David Music','../images/imgartistas/david.JPG','david@molina','12345'),(27,'Sergio','Luyo','1996-02-01','Sergio Luyo','../images/imgartistas/sergio.JPG','sergio@luyo','12345'),(28,'Pablito','Alimaña','1996-02-12','Colador','../images/imgartistas/20161016_105055.jpg','miguel@upc.edu.pe','qwe123');
/*!40000 ALTER TABLE `artista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cancion`
--

DROP TABLE IF EXISTS `cancion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cancion` (
  `cancionid` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `duracion` varchar(50) DEFAULT '01:47',
  `albumid` int(11) NOT NULL,
  `generoid` int(11) NOT NULL,
  `rutacancion` varchar(200) DEFAULT '../audio/audiodefault.mp3',
  `reproducciones` int(11) DEFAULT '0',
  `favoritos` int(11) DEFAULT '0',
  PRIMARY KEY (`cancionid`),
  KEY `fk_album_cancion_idx` (`albumid`),
  KEY `fk_genero_cancion_idx` (`generoid`),
  CONSTRAINT `fk_album_cancion` FOREIGN KEY (`albumid`) REFERENCES `album` (`albumid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_genero_cancion` FOREIGN KEY (`generoid`) REFERENCES `genero` (`generoid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancion`
--

LOCK TABLES `cancion` WRITE;
/*!40000 ALTER TABLE `cancion` DISABLE KEYS */;
INSERT INTO `cancion` VALUES (5,'Toughjoyfax','01:47',15,8,'../audio/audiodefault.mp3',3272,0),(6,'Lotstring','01:47',17,6,'../audio/audiodefault.mp3',204,0),(7,'Konklux','01:47',38,8,'../audio/audiodefault.mp3',176,0),(8,'Latlux','01:47',8,5,'../audio/audiodefault.mp3',3804,0),(9,'Wrapsafe','01:47',4,6,'../audio/audiodefault.mp3',4500,0),(10,'Job','01:47',11,10,'../audio/audiodefault.mp3',1189,0),(11,'Trippledex','01:47',38,1,'../audio/audiodefault.mp3',1217,0),(12,'Prodder','01:47',23,5,'../audio/audiodefault.mp3',121,0),(13,'Cardguard','01:47',22,4,'../audio/audiodefault.mp3',905,0),(14,'Vagram','01:47',33,3,'../audio/audiodefault.mp3',4668,0),(15,'Domainer','01:47',35,8,'../audio/audiodefault.mp3',1123,0),(16,'Lotstring','01:47',15,1,'../audio/audiodefault.mp3',3037,0),(17,'Temp','01:47',7,2,'../audio/audiodefault.mp3',4237,0),(18,'Treeflex','01:47',10,4,'../audio/audiodefault.mp3',2952,0),(19,'Y-Solowarm','01:47',38,7,'../audio/audiodefault.mp3',30,0),(20,'Latlux','01:47',31,4,'../audio/audiodefault.mp3',1798,0),(21,'Domainer','01:47',13,10,'../audio/audiodefault.mp3',4837,0),(22,'Alpha','01:47',43,10,'../audio/audiodefault.mp3',4876,0),(23,'Otcom','01:47',30,5,'../audio/audiodefault.mp3',2008,0),(24,'Bigtax','01:47',41,5,'../audio/audiodefault.mp3',2122,0),(25,'Stim','01:47',47,2,'../audio/audiodefault.mp3',105,0),(26,'Span','01:47',26,6,'../audio/audiodefault.mp3',3110,0),(27,'Span','01:47',1,3,'../audio/audiodefault.mp3',4859,0),(28,'Sonsing','01:47',12,1,'../audio/audiodefault.mp3',4431,0),(29,'Tresom','01:47',19,5,'../audio/audiodefault.mp3',586,0),(30,'Holdlamis','01:47',10,7,'../audio/audiodefault.mp3',3625,0),(31,'Tres-Zap','01:47',35,6,'../audio/audiodefault.mp3',4490,0),(32,'Bigtax','01:47',38,9,'../audio/audiodefault.mp3',3143,0),(33,'Y-find','01:47',28,7,'../audio/audiodefault.mp3',1571,0),(34,'Matsoft','01:47',38,6,'../audio/audiodefault.mp3',315,0),(35,'Treeflex','01:47',3,6,'../audio/audiodefault.mp3',1431,0),(36,'Rank','01:47',33,3,'../audio/audiodefault.mp3',1449,0),(37,'Sonair','01:47',24,6,'../audio/audiodefault.mp3',835,0),(38,'Sub-Ex','01:47',5,5,'../audio/audiodefault.mp3',4829,0),(39,'Asoka','01:47',1,6,'../audio/audiodefault.mp3',3967,0),(40,'Stim','01:47',44,9,'../audio/audiodefault.mp3',4467,0),(41,'Veribet','01:47',41,6,'../audio/audiodefault.mp3',3419,0),(42,'Stronghold','01:47',17,9,'../audio/audiodefault.mp3',2241,0),(43,'Tresom','01:47',15,7,'../audio/audiodefault.mp3',1309,0),(44,'Andalax','01:47',47,10,'../audio/audiodefault.mp3',2449,0),(45,'Bytecard','01:47',42,6,'../audio/audiodefault.mp3',3058,0),(46,'Stronghold','01:47',44,1,'../audio/audiodefault.mp3',4812,0),(47,'Gembucket','01:47',5,4,'../audio/audiodefault.mp3',957,0),(48,'Gembucket','01:47',31,6,'../audio/audiodefault.mp3',3690,0),(49,'Temp','01:47',52,4,'../audio/audiodefault.mp3',3305,0),(50,'Fixflex','01:47',15,2,'../audio/audiodefault.mp3',233,0),(51,'Redhold','01:47',2,4,'../audio/audiodefault.mp3',758,0),(52,'Holdlamis','01:47',10,6,'../audio/audiodefault.mp3',4310,0),(53,'Pannier','01:47',18,10,'../audio/audiodefault.mp3',4375,0),(54,'Greenlam','01:47',39,1,'../audio/audiodefault.mp3',2561,0),(55,'Sonsing','01:47',8,4,'../audio/audiodefault.mp3',916,0),(56,'Bitwolf','01:47',12,7,'../audio/audiodefault.mp3',953,0),(57,'Toughjoyfax','01:47',8,1,'../audio/audiodefault.mp3',4612,0),(58,'Domainer','01:47',30,1,'../audio/audiodefault.mp3',1032,0),(59,'Voyatouch','01:47',51,3,'../audio/audiodefault.mp3',2811,0),(60,'Voyatouch','01:47',36,1,'../audio/audiodefault.mp3',1694,0),(61,'Hatity','01:47',47,4,'../audio/audiodefault.mp3',2101,0),(62,'Redhold','01:47',8,8,'../audio/audiodefault.mp3',3004,0),(63,'Tres-Zap','01:47',20,5,'../audio/audiodefault.mp3',2119,0),(64,'Flexidy','01:47',16,2,'../audio/audiodefault.mp3',2824,0),(65,'Pannier','01:47',27,6,'../audio/audiodefault.mp3',4316,0),(66,'Home Ing','01:47',30,3,'../audio/audiodefault.mp3',4295,0),(67,'Bitchip','01:47',3,10,'../audio/audiodefault.mp3',3800,0),(68,'Stronghold','01:47',22,5,'../audio/audiodefault.mp3',2286,0),(69,'Tresom','01:47',39,9,'../audio/audiodefault.mp3',375,0),(70,'Voyatouch','01:47',29,3,'../audio/audiodefault.mp3',2645,0),(71,'Tin','01:47',40,3,'../audio/audiodefault.mp3',1267,0),(72,'Viva','01:47',28,7,'../audio/audiodefault.mp3',1607,0),(73,'Matsoft','01:47',17,1,'../audio/audiodefault.mp3',118,0),(74,'Quo Lux','01:47',1,3,'../audio/audiodefault.mp3',3097,0),(75,'Mat Lam Tam','01:47',38,4,'../audio/audiodefault.mp3',4718,0),(76,'Keylex','01:47',41,1,'../audio/audiodefault.mp3',3140,0),(77,'Konklab','01:47',4,3,'../audio/audiodefault.mp3',4539,0),(78,'Prodder','01:47',3,8,'../audio/audiodefault.mp3',4440,0),(79,'Cardguard','01:47',28,6,'../audio/audiodefault.mp3',557,0),(80,'Cookley','01:47',29,2,'../audio/audiodefault.mp3',478,0),(81,'Quo Lux','01:47',46,2,'../audio/audiodefault.mp3',4680,0),(82,'Toughjoyfax','01:47',40,5,'../audio/audiodefault.mp3',2826,0),(83,'Kanlam','01:47',28,1,'../audio/audiodefault.mp3',2963,0),(84,'Hatity','01:47',33,10,'../audio/audiodefault.mp3',2631,0),(85,'Bitwolf','01:47',16,6,'../audio/audiodefault.mp3',1216,0),(86,'Pannier','01:47',48,1,'../audio/audiodefault.mp3',2740,0),(87,'Cookley','01:47',22,3,'../audio/audiodefault.mp3',4824,0),(88,'Stim','01:47',7,2,'../audio/audiodefault.mp3',3938,0),(89,'Voyatouch','01:47',5,10,'../audio/audiodefault.mp3',623,0),(90,'Mat Lam Tam','01:47',36,4,'../audio/audiodefault.mp3',146,0),(91,'Regrant','01:47',14,6,'../audio/audiodefault.mp3',1009,0),(92,'Regrant','01:47',45,7,'../audio/audiodefault.mp3',651,0),(93,'Bitchip','01:47',51,7,'../audio/audiodefault.mp3',1583,0),(94,'Sonair','01:47',41,9,'../audio/audiodefault.mp3',3027,0),(95,'Bamity','01:47',34,2,'../audio/audiodefault.mp3',2378,0),(96,'Zamit','01:47',37,7,'../audio/audiodefault.mp3',1965,0),(97,'Voltsillam','01:47',43,8,'../audio/audiodefault.mp3',261,0),(98,'Tampflex','01:47',2,3,'../audio/audiodefault.mp3',1393,0),(99,'Ronstring','01:47',13,1,'../audio/audiodefault.mp3',480,0),(100,'Konklab','01:47',42,9,'../audio/audiodefault.mp3',4026,0),(101,'Cardguard','01:47',24,10,'../audio/audiodefault.mp3',301,0),(102,'Zamit','01:47',27,8,'../audio/audiodefault.mp3',103,0),(103,'Sonsing','01:47',6,7,'../audio/audiodefault.mp3',1602,0),(104,'Greenlam','01:47',50,3,'../audio/audiodefault.mp3',4032,0),(105,'Nostalgia pura','2:43',54,1,'../audio/canciones/nostalgiapura.mp3',0,0),(106,'Casketing','2:43',54,5,'../audio/canciones/nostalgiapura.mp3',0,0),(107,'Abcd','2:43',55,4,'../audio/canciones/ocasotriste.mp3',0,0);
/*!40000 ALTER TABLE `cancion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `generoid` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `rutaimggenero` varchar(45) NOT NULL,
  PRIMARY KEY (`generoid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Rock','../images/generos/Rock.jpg'),(2,'Pop','../images/generos/Pop.jpg'),(3,'Blues','../images/generos/Blues.jpg'),(4,'Funk','../images/generos/Funk.jpg'),(5,'Metal','../images/generos/Metal.jpg'),(6,'Jazz','../images/generos/Jazz.jpg'),(7,'Latino','../images/generos/Latino.jpg'),(8,'Salsa','../images/generos/Salsa.jpg'),(9,'Cumbia','../images/generos/Cumbia.jpg'),(10,'Electronica','../images/generos/Electronica.jpg'),(11,'Acústico','../images/generos/Acustico.jpg'),(12,'Punk','../images/generos/Punk.jpg'),(13,'Reggae','../images/generos/Reggae.jpg'),(14,'Soul','../images/generos/Soul.jpg');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playlist` (
  `playlistid` int(11) NOT NULL AUTO_INCREMENT,
  `usuarioid` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `fechacreacion` date NOT NULL,
  PRIMARY KEY (`playlistid`),
  KEY `fk_playliist_usuario_idx` (`usuarioid`),
  CONSTRAINT `fk_playliist_usuario` FOREIGN KEY (`usuarioid`) REFERENCES `usuario` (`usuarioid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist_cancion`
--

DROP TABLE IF EXISTS `playlist_cancion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playlist_cancion` (
  `idplaylist` int(11) NOT NULL,
  `idcancion` int(11) NOT NULL,
  `fechaadicion` varchar(45) NOT NULL,
  PRIMARY KEY (`idplaylist`,`idcancion`),
  KEY `fk_cancion_idx` (`idcancion`),
  CONSTRAINT `fk_cancion` FOREIGN KEY (`idcancion`) REFERENCES `cancion` (`cancionid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_playlist` FOREIGN KEY (`idplaylist`) REFERENCES `playlist` (`playlistid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist_cancion`
--

LOCK TABLES `playlist_cancion` WRITE;
/*!40000 ALTER TABLE `playlist_cancion` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlist_cancion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_usuario` (
  `tipousuarioid` tinyint(4) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`tipousuarioid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'Artista'),(2,'Seguidor');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `usuarioid` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `passwd` varchar(45) NOT NULL,
  `tipousuarioid` tinyint(4) NOT NULL,
  PRIMARY KEY (`usuarioid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'thomas@hammond','12345',1),(2,'igor@krammer','12345',1),(3,'nathaniel@mckal','12345',1),(4,'hayden@nixon','12345',1),(5,'phillip@boyer','12345',1),(6,'gavin@gilliam','12345',1),(7,'nasim@schawrtz','12345',1),(8,'oren@tailer','12345',1),(9,'jarrod@cline','12345',1),(10,'erasmus@foulkner','12345',1),(11,'bernard@austin','12345',1),(12,'tarik@barry','12345',1),(13,'robert@patton','12345',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'newsic'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_5mejoresalbumesdelartista` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_5mejoresalbumesdelartista`(
_artistaid int)
BEGIN
select b.albumid,b.artistaid
from Artista a join Album b on a.artistaid=b.artistaid
where a.artistaid=_artistaid
order by b.reproducciones
limit 5;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_5mejorescancionesdelartista` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_5mejorescancionesdelartista`(
_artistaid int)
BEGIN
select c.cancionid,c.albumid,c.generoid
from Artista a join Album b on a.artistaid=b.artistaid
join Cancion c on b.albumid=c.albumid
where a.artistaid=_artistaid
order by b.reproducciones
limit 5;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_albumesdelgenero` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_albumesdelgenero`(
_generoid int
)
BEGIN
SELECT DISTINCT b.albumid,b.artistaid,b.nombre,b.fechapublicacion,b.rutaimgalbum FROM Album b join Cancion c on b.albumid=c.albumid
join Genero g on c.generoid=g.generoid where g.generoid=_generoid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_artistasdelgenero` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_artistasdelgenero`(
_generoid int
)
BEGIN
SELECT DISTINCT a.artistaid FROM Artista a join Album b on a.artistaid=b.artistaid join Cancion c on b.albumid=c.albumid
 join Genero g on c.generoid=g.generoid where g.generoid=_generoid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_generosdelalbum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_generosdelalbum`(
_albumid int
)
BEGIN
SELECT DISTINCT g.generoid,g.nombre,g.rutaimggenero FROM Album b join Cancion c on b.albumid=c.albumid
 join Genero g on c.generoid=g.generoid where b.albumid=_albumid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_generosdelartista` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_generosdelartista`(
_artistaid int
)
BEGIN
SELECT DISTINCT g.generoid,g.nombre,g.rutaimggenero FROM Artista a join Album b on a.artistaid=b.artistaid join Cancion c on b.albumid=c.albumid
 join Genero g on c.generoid=g.generoid where a.artistaid=_artistaid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-19 12:28:53
