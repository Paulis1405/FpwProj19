-- MySQL dump 10.13  Distrib 5.7.26, for Win64 (x86_64)
--
-- Host: localhost    Database: fpw19_DbPaulisAlessio
-- ------------------------------------------------------
-- Server version	5.7.26-log

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
-- Table structure for table `articoli`
--

DROP TABLE IF EXISTS `articoli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articoli` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `titolo` varchar(128) DEFAULT NULL,
  `data_articolo` date DEFAULT NULL,
  `testo` varchar(1024) DEFAULT NULL,
  `categorie` varchar(128) DEFAULT NULL,
  `stato` varchar(128) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articoli`
--

LOCK TABLES `articoli` WRITE;
/*!40000 ALTER TABLE `articoli` DISABLE KEYS */;
INSERT INTO `articoli` VALUES (1,'Server-Side programma','2019-07-02','                                                                                                                                                                                                                                Ci sono delle tecniche particolari per ...\r\n                        \r\n                        \r\n                        \r\n                        \r\n                        \r\n                        \r\n                        \r\n                        ',NULL,'Aperto'),(2,'Il linguaggio Java','2018-04-01','E\' un linguaggio di programmazione a oggetti ...',NULL,'Da Valutare'),(3,'Il Server Web','2018-04-03','Non è cosi fondamentale per lo sviluppo di applicazioni web ...',NULL,'Rifiutato'),(4,'MetaInfo','2018-04-30','Sarebbe utile lavorare sulla validazione delle pagine web ...',NULL,'Da Valutare'),(5,'l\'ABC','2019-06-01','testeeee',NULL,'Aperto'),(27,'Ciao','2019-07-04','                                                        Come va?\r\n                        \r\n                        ',NULL,'Aperto'),(28,'Titolo','2019-07-02','                            Vuoto\r\n                        ',NULL,'Aperto');
/*!40000 ALTER TABLE `articoli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autori`
--

DROP TABLE IF EXISTS `autori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autori` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(128) DEFAULT NULL,
  `cognome` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `foto` varchar(128) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autori`
--

LOCK TABLES `autori` WRITE;
/*!40000 ALTER TABLE `autori` DISABLE KEYS */;
INSERT INTO `autori` VALUES (1,'Giovanni','Muchacha','muchacha@gmail.com','muchacha',NULL),(2,'Giampiero','Beccarini','becca@gmail.com','pierino',NULL),(3,NULL,NULL,NULL,NULL,NULL),(5,'Daniele','Caraghin','caraghin@gmail.ROM','roN',NULL);
/*!40000 ALTER TABLE `autori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organizzatori`
--

DROP TABLE IF EXISTS `organizzatori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organizzatori` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(128) DEFAULT NULL,
  `cognome` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizzatori`
--

LOCK TABLES `organizzatori` WRITE;
/*!40000 ALTER TABLE `organizzatori` DISABLE KEYS */;
INSERT INTO `organizzatori` VALUES (1,'Ottavio','Spalletti','spalletti@gmail.com','neroazzurro'),(2,'Rolando','Monsignori','rolando@gmail.com','rolandinho');
/*!40000 ALTER TABLE `organizzatori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro`
--

DROP TABLE IF EXISTS `registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro` (
  `articolo_id` bigint(20) unsigned DEFAULT NULL,
  `autore_id` bigint(20) unsigned DEFAULT NULL,
  `valutatore_id` bigint(20) unsigned DEFAULT NULL,
  `valutazione_id` bigint(20) unsigned DEFAULT NULL,
  KEY `Articoli_fk` (`articolo_id`),
  KEY `Autori_fk` (`autore_id`),
  KEY `Organizzatori_fk` (`valutatore_id`),
  KEY `Valutazioni_fk` (`valutazione_id`),
  CONSTRAINT `registro_ibfk_1` FOREIGN KEY (`articolo_id`) REFERENCES `articoli` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `registro_ibfk_2` FOREIGN KEY (`autore_id`) REFERENCES `autori` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `registro_ibfk_3` FOREIGN KEY (`valutatore_id`) REFERENCES `organizzatori` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `registro_ibfk_4` FOREIGN KEY (`valutazione_id`) REFERENCES `valutazioni` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro`
--

LOCK TABLES `registro` WRITE;
/*!40000 ALTER TABLE `registro` DISABLE KEYS */;
INSERT INTO `registro` VALUES (1,1,2,1),(1,2,2,1),(2,1,2,NULL),(3,1,1,2),(3,2,1,2),(4,2,1,NULL),(27,1,2,NULL),(28,1,2,NULL),(5,5,1,NULL);
/*!40000 ALTER TABLE `registro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valutazioni`
--

DROP TABLE IF EXISTS `valutazioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `valutazioni` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `articolo_id` bigint(20) unsigned DEFAULT NULL,
  `valutatore_id` bigint(20) unsigned DEFAULT NULL,
  `voto` int(11) DEFAULT NULL,
  `comm_autori` varchar(1024) DEFAULT NULL,
  `comm_organizzatori` varchar(1024) DEFAULT NULL,
  UNIQUE KEY `id` (`id`),
  KEY `Articoli_fk` (`articolo_id`),
  KEY `Organizzatori_fk` (`valutatore_id`),
  CONSTRAINT `valutazioni_ibfk_1` FOREIGN KEY (`articolo_id`) REFERENCES `articoli` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `valutazioni_ibfk_2` FOREIGN KEY (`valutatore_id`) REFERENCES `organizzatori` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valutazioni`
--

LOCK TABLES `valutazioni` WRITE;
/*!40000 ALTER TABLE `valutazioni` DISABLE KEYS */;
INSERT INTO `valutazioni` VALUES (1,1,2,4,NULL,NULL),(2,3,1,3,NULL,NULL);
/*!40000 ALTER TABLE `valutazioni` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-12 13:56:45
