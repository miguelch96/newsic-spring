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
  `fechapublicacion` date NOT NULL,
  `rutaimgalbum` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`albumid`),
  KEY `fk_artista_album_idx` (`artistaid`),
  CONSTRAINT `fk_artista_album` FOREIGN KEY (`artistaid`) REFERENCES `artista` (`artistaid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (1,2,'ITALIAN RYEGRASS POLLEN','2017-02-08','../images/b2.jpg'),(2,6,'Aspir Low','2016-08-10','../images/b4.jpg'),(3,11,'Volunteer Training','2016-06-11','../images/b5.jpg'),(4,14,'Oracle VM','2016-07-31','../images/b2.jpg'),(5,2,'HTRI Software','2016-07-15','../images/b4.jpg'),(6,11,'Khalix','2016-12-10','../images/b2.jpg'),(7,8,'TPMS','2016-10-13','../images/b2.jpg'),(8,5,'Djbdns','2016-12-31','../images/b5.jpg'),(9,9,'Knowledge Discovery','2016-10-10','../images/b2.jpg'),(10,12,'iOS','2016-06-30','../images/b1.jpg'),(11,3,'Kinesiology','2017-04-15','../images/b5.jpg'),(12,14,'Jive SBS','2016-06-25','../images/b5.jpg'),(13,8,'Custom CMS Development','2016-12-23','../images/b5.jpg'),(14,4,'GTD','2016-11-11','../images/b1.jpg'),(15,14,'Alarm Systems','2016-12-01','../images/b5.jpg'),(16,8,'CGI programming','2016-06-09','../images/b5.jpg'),(17,4,'Pianist','2017-01-13','../images/b4.jpg'),(18,6,'MTOs','2016-07-17','../images/b2.jpg'),(19,9,'Scheduling','2016-11-19','../images/b5.jpg'),(20,5,'CDMA 1X','2016-12-12','../images/b2.jpg'),(21,8,'HDR Photography','2017-03-22','../images/b5.jpg'),(22,12,'Vi','2017-05-11','../images/b1.jpg'),(23,7,'MPLS-TP','2016-08-05','../images/b3.jpg'),(24,6,'Data Collection','2016-10-05','../images/b2.jpg'),(25,14,'UART','2016-08-19','../images/b2.jpg'),(26,14,'UF/DF','2016-08-14','../images/b2.jpg'),(27,11,'Start-up Consulting','2017-03-02','../images/b4.jpg'),(28,14,'Urdu','2017-03-09','../images/b1.jpg'),(29,5,'HGV','2017-03-17','../images/b3.jpg'),(30,12,'Pymol','2016-07-02','../images/b1.jpg'),(31,10,'RS/6000','2016-06-11','../images/b3.jpg'),(32,13,'GSA Schedule','2016-07-03','../images/b1.jpg'),(33,6,'Strategy','2016-10-19','../images/b2.jpg'),(34,7,'Tween','2017-03-09','../images/b5.jpg'),(35,5,'Cd','2016-11-20','../images/b1.jpg'),(36,2,'Customer Follow-up','2017-05-30','../images/b4.jpg'),(37,12,'Gourmet','2016-12-16','../images/b1.jpg'),(38,11,'EZNews','2017-04-06','../images/b5.jpg'),(39,6,'ATG CSC','2016-12-20','../images/b4.jpg'),(40,13,'Major Gift Development','2016-12-06','../images/b5.jpg'),(41,3,'Buyers','2017-03-31','../images/b3.jpg'),(42,3,'HCS 2000','2017-03-05','../images/b2.jpg'),(43,12,'Book Illustration','2016-11-05','../images/b2.jpg'),(44,12,'KRAs','2016-09-10','../images/b3.jpg'),(45,12,'Athletic Performance','2016-07-03','../images/b5.jpg'),(46,14,'Non-linear Editing','2016-09-24','../images/b2.jpg'),(47,11,'Alternative Investments','2016-08-30','../images/b1.jpg'),(48,4,'Weddings','2016-06-08','../images/b3.jpg'),(49,14,'XFP','2017-03-25','../images/b4.jpg'),(50,3,'Window Displays','2016-06-12','../images/b5.jpg'),(51,7,'Runway','2017-05-30','../images/b2.jpg'),(52,5,'Fraud','2017-04-07','../images/b1.jpg');
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
  `rutaimgperfil` varchar(50) DEFAULT '../images/imgperfildefault.png',
  `rutaimgportada` varchar(50) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `passwd` varchar(45) NOT NULL,
  PRIMARY KEY (`artistaid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artista`
--

LOCK TABLES `artista` WRITE;
/*!40000 ALTER TABLE `artista` DISABLE KEYS */;
INSERT INTO `artista` VALUES (2,'Thomas','Hammond','1993-12-27','facilisis,','../images/a6.jpg',NULL,'',''),(3,'Igor','Kramer','1993-06-12','pretium aliquet,','../images/a8.jpg',NULL,'',''),(4,'Nathaniel','Mccall','1998-08-10','Pellentesque tincidunt','../images/a8.jpg',NULL,'',''),(5,'Hayden','Nixon','1986-01-18','arcu','../images/a6.jpg',NULL,'',''),(6,'Phillip','Boyer','1991-04-05','Morbi neque','../images/a8.jpg',NULL,'',''),(7,'Gavin','Gilliam','1993-01-28','auctor, velit','../images/a7.jpg',NULL,'',''),(8,'Nasim','Schwartz','1994-04-12','eu','../images/a8.jpg',NULL,'',''),(9,'Oren','Tyler','1999-07-22','Etiam','../images/a6.jpg',NULL,'',''),(10,'Jarrod','Cline','1992-07-30','Donec non','../images/a6.jpg',NULL,'',''),(11,'Erasmus','Faulkner','1993-06-14','justo. Praesent','../images/a6.jpg',NULL,'',''),(12,'Bernard','Austin','1996-05-31','neque. Morbi','../images/a8.jpg',NULL,'',''),(13,'Tarik','Barry','1988-05-20','id magna','../images/a6.jpg',NULL,'',''),(14,'Robert','Patton','1992-03-06','nunc sed','../images/a7.jpg',NULL,'',''),(15,'pruebanombre','pruebaapelliod','1993-04-13','pruebanombre2','\'../images/imgperfildefault.png\'',NULL,'prueba1@prueba1','12345'),(16,'Nombre2','Apellido2','1980-11-17','Artistico2','../images/imgperfildefault.png',NULL,'prueba2@prueba2','12345'),(17,'nombre3','apellido3','1990-10-20','Artistico 3','../images/imgperfildefault.png',NULL,'prueba3@prueba3','12345'),(21,'4353545','qfqf','1990-03-05','adgadg','../images/imgperfildefault.png',NULL,'afasfgfdg','12345'),(22,'Adriana','Tenorio','1999-05-16','Adriana Music','../images/imgperfildefault.png',NULL,'adriana@tenorio','12345'),(23,'Jesus','Mendoza','1990-02-12','Jesus Music','../images/imgperfildefault.png',NULL,'jesus@mendoza','12345'),(24,'Manuel','Corrado','1990-02-12','Manuel Music','../images/imgperfildefault.png',NULL,'manuel@corrado','12345');
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
  `reproducciones` int(11) DEFAULT '0',
  `albumid` int(11) NOT NULL,
  `generoid` int(11) NOT NULL,
  `rutacancion` varchar(45) DEFAULT '../audio/audiodefault.mp3',
  PRIMARY KEY (`cancionid`),
  KEY `fk_album_cancion_idx` (`albumid`),
  KEY `fk_genero_cancion_idx` (`generoid`),
  CONSTRAINT `fk_album_cancion` FOREIGN KEY (`albumid`) REFERENCES `album` (`albumid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_genero_cancion` FOREIGN KEY (`generoid`) REFERENCES `genero` (`generoid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancion`
--

LOCK TABLES `cancion` WRITE;
/*!40000 ALTER TABLE `cancion` DISABLE KEYS */;
INSERT INTO `cancion` VALUES (5,'Toughjoyfax','01:47',3272,15,8,'../audio/audiodefault.mp3'),(6,'Lotstring','01:47',204,17,6,'../audio/audiodefault.mp3'),(7,'Konklux','01:47',176,38,8,'../audio/audiodefault.mp3'),(8,'Latlux','01:47',3804,8,5,'../audio/audiodefault.mp3'),(9,'Wrapsafe','01:47',4500,4,6,'../audio/audiodefault.mp3'),(10,'Job','01:47',1189,11,10,'../audio/audiodefault.mp3'),(11,'Trippledex','01:47',1217,38,1,'../audio/audiodefault.mp3'),(12,'Prodder','01:47',121,23,5,'../audio/audiodefault.mp3'),(13,'Cardguard','01:47',905,22,4,'../audio/audiodefault.mp3'),(14,'Vagram','01:47',4668,33,3,'../audio/audiodefault.mp3'),(15,'Domainer','01:47',1123,35,8,'../audio/audiodefault.mp3'),(16,'Lotstring','01:47',3037,15,1,'../audio/audiodefault.mp3'),(17,'Temp','01:47',4237,7,2,'../audio/audiodefault.mp3'),(18,'Treeflex','01:47',2952,10,4,'../audio/audiodefault.mp3'),(19,'Y-Solowarm','01:47',30,38,7,'../audio/audiodefault.mp3'),(20,'Latlux','01:47',1798,31,4,'../audio/audiodefault.mp3'),(21,'Domainer','01:47',4837,13,10,'../audio/audiodefault.mp3'),(22,'Alpha','01:47',4876,43,10,'../audio/audiodefault.mp3'),(23,'Otcom','01:47',2008,30,5,'../audio/audiodefault.mp3'),(24,'Bigtax','01:47',2122,41,5,'../audio/audiodefault.mp3'),(25,'Stim','01:47',105,47,2,'../audio/audiodefault.mp3'),(26,'Span','01:47',3110,26,6,'../audio/audiodefault.mp3'),(27,'Span','01:47',4859,1,3,'../audio/audiodefault.mp3'),(28,'Sonsing','01:47',4431,12,1,'../audio/audiodefault.mp3'),(29,'Tresom','01:47',586,19,5,'../audio/audiodefault.mp3'),(30,'Holdlamis','01:47',3625,10,7,'../audio/audiodefault.mp3'),(31,'Tres-Zap','01:47',4490,35,6,'../audio/audiodefault.mp3'),(32,'Bigtax','01:47',3143,38,9,'../audio/audiodefault.mp3'),(33,'Y-find','01:47',1571,28,7,'../audio/audiodefault.mp3'),(34,'Matsoft','01:47',315,38,6,'../audio/audiodefault.mp3'),(35,'Treeflex','01:47',1431,3,6,'../audio/audiodefault.mp3'),(36,'Rank','01:47',1449,33,3,'../audio/audiodefault.mp3'),(37,'Sonair','01:47',835,24,6,'../audio/audiodefault.mp3'),(38,'Sub-Ex','01:47',4829,5,5,'../audio/audiodefault.mp3'),(39,'Asoka','01:47',3967,1,6,'../audio/audiodefault.mp3'),(40,'Stim','01:47',4467,44,9,'../audio/audiodefault.mp3'),(41,'Veribet','01:47',3419,41,6,'../audio/audiodefault.mp3'),(42,'Stronghold','01:47',2241,17,9,'../audio/audiodefault.mp3'),(43,'Tresom','01:47',1309,15,7,'../audio/audiodefault.mp3'),(44,'Andalax','01:47',2449,47,10,'../audio/audiodefault.mp3'),(45,'Bytecard','01:47',3058,42,6,'../audio/audiodefault.mp3'),(46,'Stronghold','01:47',4812,44,1,'../audio/audiodefault.mp3'),(47,'Gembucket','01:47',957,5,4,'../audio/audiodefault.mp3'),(48,'Gembucket','01:47',3690,31,6,'../audio/audiodefault.mp3'),(49,'Temp','01:47',3305,52,4,'../audio/audiodefault.mp3'),(50,'Fixflex','01:47',233,15,2,'../audio/audiodefault.mp3'),(51,'Redhold','01:47',758,2,4,'../audio/audiodefault.mp3'),(52,'Holdlamis','01:47',4310,10,6,'../audio/audiodefault.mp3'),(53,'Pannier','01:47',4375,18,10,'../audio/audiodefault.mp3'),(54,'Greenlam','01:47',2561,39,1,'../audio/audiodefault.mp3'),(55,'Sonsing','01:47',916,8,4,'../audio/audiodefault.mp3'),(56,'Bitwolf','01:47',953,12,7,'../audio/audiodefault.mp3'),(57,'Toughjoyfax','01:47',4612,8,1,'../audio/audiodefault.mp3'),(58,'Domainer','01:47',1032,30,1,'../audio/audiodefault.mp3'),(59,'Voyatouch','01:47',2811,51,3,'../audio/audiodefault.mp3'),(60,'Voyatouch','01:47',1694,36,1,'../audio/audiodefault.mp3'),(61,'Hatity','01:47',2101,47,4,'../audio/audiodefault.mp3'),(62,'Redhold','01:47',3004,8,8,'../audio/audiodefault.mp3'),(63,'Tres-Zap','01:47',2119,20,5,'../audio/audiodefault.mp3'),(64,'Flexidy','01:47',2824,16,2,'../audio/audiodefault.mp3'),(65,'Pannier','01:47',4316,27,6,'../audio/audiodefault.mp3'),(66,'Home Ing','01:47',4295,30,3,'../audio/audiodefault.mp3'),(67,'Bitchip','01:47',3800,3,10,'../audio/audiodefault.mp3'),(68,'Stronghold','01:47',2286,22,5,'../audio/audiodefault.mp3'),(69,'Tresom','01:47',375,39,9,'../audio/audiodefault.mp3'),(70,'Voyatouch','01:47',2645,29,3,'../audio/audiodefault.mp3'),(71,'Tin','01:47',1267,40,3,'../audio/audiodefault.mp3'),(72,'Viva','01:47',1607,28,7,'../audio/audiodefault.mp3'),(73,'Matsoft','01:47',118,17,1,'../audio/audiodefault.mp3'),(74,'Quo Lux','01:47',3097,1,3,'../audio/audiodefault.mp3'),(75,'Mat Lam Tam','01:47',4718,38,4,'../audio/audiodefault.mp3'),(76,'Keylex','01:47',3140,41,1,'../audio/audiodefault.mp3'),(77,'Konklab','01:47',4539,4,3,'../audio/audiodefault.mp3'),(78,'Prodder','01:47',4440,3,8,'../audio/audiodefault.mp3'),(79,'Cardguard','01:47',557,28,6,'../audio/audiodefault.mp3'),(80,'Cookley','01:47',478,29,2,'../audio/audiodefault.mp3'),(81,'Quo Lux','01:47',4680,46,2,'../audio/audiodefault.mp3'),(82,'Toughjoyfax','01:47',2826,40,5,'../audio/audiodefault.mp3'),(83,'Kanlam','01:47',2963,28,1,'../audio/audiodefault.mp3'),(84,'Hatity','01:47',2631,33,10,'../audio/audiodefault.mp3'),(85,'Bitwolf','01:47',1216,16,6,'../audio/audiodefault.mp3'),(86,'Pannier','01:47',2740,48,1,'../audio/audiodefault.mp3'),(87,'Cookley','01:47',4824,22,3,'../audio/audiodefault.mp3'),(88,'Stim','01:47',3938,7,2,'../audio/audiodefault.mp3'),(89,'Voyatouch','01:47',623,5,10,'../audio/audiodefault.mp3'),(90,'Mat Lam Tam','01:47',146,36,4,'../audio/audiodefault.mp3'),(91,'Regrant','01:47',1009,14,6,'../audio/audiodefault.mp3'),(92,'Regrant','01:47',651,45,7,'../audio/audiodefault.mp3'),(93,'Bitchip','01:47',1583,51,7,'../audio/audiodefault.mp3'),(94,'Sonair','01:47',3027,41,9,'../audio/audiodefault.mp3'),(95,'Bamity','01:47',2378,34,2,'../audio/audiodefault.mp3'),(96,'Zamit','01:47',1965,37,7,'../audio/audiodefault.mp3'),(97,'Voltsillam','01:47',261,43,8,'../audio/audiodefault.mp3'),(98,'Tampflex','01:47',1393,2,3,'../audio/audiodefault.mp3'),(99,'Ronstring','01:47',480,13,1,'../audio/audiodefault.mp3'),(100,'Konklab','01:47',4026,42,9,'../audio/audiodefault.mp3'),(101,'Cardguard','01:47',301,24,10,'../audio/audiodefault.mp3'),(102,'Zamit','01:47',103,27,8,'../audio/audiodefault.mp3'),(103,'Sonsing','01:47',1602,6,7,'../audio/audiodefault.mp3'),(104,'Greenlam','01:47',4032,50,3,'../audio/audiodefault.mp3');
/*!40000 ALTER TABLE `cancion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentario` (
  `idcomentario` int(11) NOT NULL,
  `idartista` int(11) NOT NULL,
  `idcancion` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `texto` text NOT NULL,
  PRIMARY KEY (`idcomentario`),
  KEY `fk_artista_comentario_idx` (`idartista`),
  KEY `fk_cancion_comentario_idx` (`idcancion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
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
  PRIMARY KEY (`generoid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Rock'),(2,'Pop'),(3,'Blues'),(4,'Funk'),(5,'Metal'),(6,'Jazz'),(7,'Latino'),(8,'Salsa'),(9,'Cumbia'),(10,'Electronica'),(11,'Acústico'),(12,'Punk'),(13,'Reggae'),(14,'Soul');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero_album`
--

DROP TABLE IF EXISTS `genero_album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero_album` (
  `generoid` int(11) NOT NULL,
  `albumid` int(11) NOT NULL,
  PRIMARY KEY (`generoid`,`albumid`),
  KEY `fk_album_genero_idx` (`albumid`),
  CONSTRAINT `fk_album_genero` FOREIGN KEY (`albumid`) REFERENCES `album` (`albumid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_genero_album` FOREIGN KEY (`generoid`) REFERENCES `genero` (`generoid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero_album`
--

LOCK TABLES `genero_album` WRITE;
/*!40000 ALTER TABLE `genero_album` DISABLE KEYS */;
/*!40000 ALTER TABLE `genero_album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero_artista`
--

DROP TABLE IF EXISTS `genero_artista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero_artista` (
  `generoid` int(11) NOT NULL,
  `artistaid` int(11) NOT NULL,
  PRIMARY KEY (`generoid`,`artistaid`),
  KEY `fk_artista_idx` (`artistaid`),
  CONSTRAINT `fk_artista_genero` FOREIGN KEY (`artistaid`) REFERENCES `artista` (`artistaid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_genero_artista` FOREIGN KEY (`generoid`) REFERENCES `genero` (`generoid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero_artista`
--

LOCK TABLES `genero_artista` WRITE;
/*!40000 ALTER TABLE `genero_artista` DISABLE KEYS */;
/*!40000 ALTER TABLE `genero_artista` ENABLE KEYS */;
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
-- Table structure for table `seguidor`
--

DROP TABLE IF EXISTS `seguidor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seguidor` (
  `seguidorid` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fechanacimiento` varchar(45) NOT NULL,
  `rutaimgperfil` varchar(45) DEFAULT NULL,
  `usuarioid` int(11) DEFAULT NULL,
  PRIMARY KEY (`seguidorid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguidor`
--

LOCK TABLES `seguidor` WRITE;
/*!40000 ALTER TABLE `seguidor` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguidor` ENABLE KEYS */;
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
  PRIMARY KEY (`usuarioid`),
  KEY `fk_tipo_usuario_idx` (`tipousuarioid`),
  CONSTRAINT `fk_tipo_usuario` FOREIGN KEY (`tipousuarioid`) REFERENCES `tipo_usuario` (`tipousuarioid`) ON DELETE CASCADE ON UPDATE CASCADE
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-09 13:28:20
