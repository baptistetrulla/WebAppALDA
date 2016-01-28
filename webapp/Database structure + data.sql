CREATE DATABASE  IF NOT EXISTS `javaee` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `javaee`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: javaee
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `announce`
--

DROP TABLE IF EXISTS `announce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `announce` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` float NOT NULL,
  `type` varchar(250) NOT NULL,
  `surface` float NOT NULL,
  `address` varchar(250) NOT NULL,
  `city` varchar(250) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `expired` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `favorite_announce`
--

DROP TABLE IF EXISTS `favorite_announce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favorite_announce` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `announceID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `announceID_FK_idx` (`announceID`),
  KEY `personneID_FK_idx` (`userID`),
  CONSTRAINT `favorite_announce_announceID_FK` FOREIGN KEY (`announceID`) REFERENCES `announce` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `favorite_announce_personneID_FK` FOREIGN KEY (`userID`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(250) NOT NULL,
  `pass` varchar(250) NOT NULL,
  `firstname` varchar(250) DEFAULT NULL,
  `lastname` varchar(250) DEFAULT NULL,
  `username` varchar(250) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `city` varchar(250) DEFAULT NULL,
  `cellnumber` varchar(10) DEFAULT NULL,
  `admin` varchar(10) NOT NULL DEFAULT 'false',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dir` varchar(250) NOT NULL,
  `announceID` int(11) NOT NULL,
  `text` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `announceID_FK_idx` (`announceID`),
  CONSTRAINT `photo_announceID` FOREIGN KEY (`announceID`) REFERENCES `announce` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `saved_researche`
--

DROP TABLE IF EXISTS `saved_researche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saved_researche` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` float DEFAULT NULL,
  `type` varchar(250) DEFAULT NULL,
  `surface` float DEFAULT NULL,
  `city` varchar(250) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `saved_researche_userID_FK_idx` (`userID`),
  CONSTRAINT `saved_researche_userID_FK` FOREIGN KEY (`userID`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-28 13:53:25




-- DATA INSERTION


SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE javaee.favorite_announce;
TRUNCATE TABLE javaee.photo;
TRUNCATE TABLE javaee.announce;
TRUNCATE TABLE javaee.person;
TRUNCATE TABLE javaee.saved_researche;
SET FOREIGN_KEY_CHECKS = 1;
ALTER TABLE javaee.favorite_announce AUTO_INCREMENT = 1;
ALTER TABLE javaee.photo AUTO_INCREMENT = 1;
ALTER TABLE javaee.announce AUTO_INCREMENT = 1;
ALTER TABLE javaee.person AUTO_INCREMENT = 1;
ALTER TABLE javaee.saved_researche AUTO_INCREMENT = 1;

-- INSERTION ANNONCES
INSERT INTO javaee.announce(price, type, surface, address, city, description, expired) 
VALUES (35000, 'T1', 23, '362 avenue de Georges', 'Bordeaux', 'Studio idéal pour étudiant', false);
INSERT INTO javaee.announce(price, type, surface, address, city, description, expired) 
VALUES (112000, 'T4', 88, '1 rue de la libération', 'Bordeaux', 'Maginifique maison située proche des commerces', false);
INSERT INTO javaee.announce(price, type, surface, address, city, description, expired) 
VALUES (55000, 'T2', 38, '65 avenue couteau', 'Lille', 'Studio très bien décoré, voisinage calme', false);
INSERT INTO javaee.announce(price, type, surface, address, city, description, expired) 
VALUES (254000, 'T5', 120, '18 rue du général de Gaule', 'Lyon', 'Maginifique maison avec jardin et terrasse située proche du centre ville', false);



-- INSERTION PERSONNES
INSERT INTO javaee.person(email, pass, firstname, lastname, username, address, city, cellnumber, admin) 
VALUES ('bob@email.com', 'password', 'bob', 'kelso', 'bobby', '1 rue de la longue vue', 'Bordeaux', '0222222222', false);
INSERT INTO javaee.person(email, pass, firstname, lastname, username, address, city, cellnumber, admin) 
VALUES ('jean@email.com', 'password', 'jean', 'dugrenier', 'jeandu', '25 rue de la peur', 'Bordeaux', '0225222222', false);
INSERT INTO javaee.person(email, pass, firstname, lastname, username, address, city, cellnumber, admin) 
VALUES ('jenny@email.com', 'password', 'jenny', 'delabatte', 'jenny0123', '1 rue de la grande dame', 'Lyon', '0222222292', false);

-- INSERTION PHOTOS
INSERT INTO javaee.photo(dir, announceID, text) 
VALUES ('/assests/photo_announce1_1.jpg', 1, 'photo n°1 de l\' annonce 1');
INSERT INTO javaee.photo(dir, announceID, text) 
VALUES ('/assests/photo_announce1_2.jpg', 1, 'photo n°2 de l\' annonce 1');
INSERT INTO javaee.photo(dir, announceID, text) 
VALUES ('/assests/photo_announce1_3.jpg', 1, 'photo n°3 de l\' annonce 1');
INSERT INTO javaee.photo(dir, announceID, text) 
VALUES ('/assests/photo_announce2_1.jpg', 2, 'photo n°1 de l\' annonce 2');
INSERT INTO javaee.photo(dir, announceID, text) 
VALUES ('/assests/photo_announce2_2.jpg', 2, 'photo n°2 de l\' annonce 2');
INSERT INTO javaee.photo(dir, announceID, text) 
VALUES ('/assests/photo_announce2_3.jpg', 2, 'photo n°3 de l\' annonce 2');
INSERT INTO javaee.photo(dir, announceID, text) 
VALUES ('/assests/photo_announce2_4.jpg', 2, 'photo n°4 de l\' annonce 2');
INSERT INTO javaee.photo(dir, announceID, text) 
VALUES ('/assests/photo_announce2_5.jpg', 2, 'photo n°5 de l\' annonce 2');

-- INSERTION ANNONCE FAVORITE
INSERT INTO javaee.favorite_announce(userID, announceID)
VALUE (1, 1);
INSERT INTO javaee.favorite_announce(userID, announceID)
VALUE (1, 2);
INSERT INTO javaee.favorite_announce(userID, announceID)
VALUE (2, 1);



