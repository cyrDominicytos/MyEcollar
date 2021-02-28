-- MySQL dump 10.13  Distrib 5.7.23, for Win64 (x86_64)
--
-- Host: localhost    Database: ecolarbdd
-- ------------------------------------------------------
-- Server version	5.7.23

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
-- Table structure for table `anneescolaire`
--

DROP TABLE IF EXISTS `anneescolaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `anneescolaire` (
  `ANNEESCOLAIRE` varchar(20) NOT NULL,
  `DATEDEBUT` date NOT NULL,
  `DATEFIN` date NOT NULL,
  PRIMARY KEY (`ANNEESCOLAIRE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anneescolaire`
--

LOCK TABLES `anneescolaire` WRITE;
/*!40000 ALTER TABLE `anneescolaire` DISABLE KEYS */;
INSERT INTO `anneescolaire` VALUES ('2019-2020','2019-11-01','2020-07-20');
/*!40000 ALTER TABLE `anneescolaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apprenant`
--

DROP TABLE IF EXISTS `apprenant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apprenant` (
  `MATRICULE` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) NOT NULL,
  `DATENAISSANCE` date DEFAULT NULL,
  `LIEUNAISSANCE` varchar(50) DEFAULT NULL,
  `CONTACT` varchar(20) DEFAULT NULL,
  `ADRESSE` varchar(50) DEFAULT NULL,
  `CODEOPHELIN` varchar(50) DEFAULT NULL,
  `SEXE` varchar(5) NOT NULL,
  `DATEINSCRIPTION` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`MATRICULE`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apprenant`
--

LOCK TABLES `apprenant` WRITE;
/*!40000 ALTER TABLE `apprenant` DISABLE KEYS */;
INSERT INTO `apprenant` VALUES (1,'ABDOULAYE','Anas',NULL,NULL,'','',NULL,'M','2019-11-01 18:50:05'),(2,'ABDOULAYE','Izdine',NULL,NULL,'','',NULL,'M','2019-11-01 18:51:29'),(3,'ALIDOU S.','Hanane',NULL,NULL,'','',NULL,'F','2019-11-01 18:52:23'),(4,'ADAMOU A.','Abdoul-Azize',NULL,NULL,'','','AJRS','M','2019-11-01 18:55:14'),(5,'ADAMOU S.','Aichatou',NULL,NULL,'','',NULL,'F','2019-11-01 18:55:47'),(6,'BANI MOUSSA','Zenab',NULL,NULL,'','',NULL,'F','2019-11-01 18:56:23'),(7,'BAPARAPE M.S.','AbdoulHairou',NULL,NULL,'','','AJRS','F','2019-11-01 18:58:10'),(8,'TOSSOU','Cyr',NULL,NULL,'','',NULL,'M','2019-11-02 16:02:25');
/*!40000 ALTER TABLE `apprenant` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `TR_REDUCTION_UPDATE_APPRENANT` AFTER UPDATE ON `apprenant` FOR EACH ROW BEGIN
    DECLARE nbrEleve INTEGER ;
 	DECLARE filsenseignant INTEGER ;
    DECLARE annee VARCHAR(20);
    DECLARE classes VARCHAR(20);
    
    SELECT MAX(ANNEESCOLAIRE) INTO annee FROM anneescolaire;
    SELECT CLASSE INTO classes FROM inscription I WHERE 		I.APPRENANT = OLD.MATRICULE AND I.ANNEESCOLAIRE = annee;
    
     SELECT COUNT(*) INTO filsenseignant FROM enseignant WHERE 				enseignant.TELEPHONE = NEW.CONTACT  	AND ESENSEIGNANT = "OUI";
     IF filsenseignant = 1 THEN
        UPDATE  
        REDUCTION SET MONTANT = ((SELECT MONTANT FROM SCOLARITE 		WHERE 			ANNEESCOLAIRE = annee
         AND CLASSE = classes)/2) WHERE APPRENANT = 	 			OLD.MATRICULE AND ANNEESCOLAIRE = annee;
     ELSE
    	-- Lire nombre d'enfant du tuteur
          SELECT CNE.NOMBRE INTO nbrEleve
		  FROM contact_nombre_eleve CNE WHERE CNE.CONTACT = 		  NEW.CONTACT AND  CNE.ANNEESCOLAIRE =annee 		   AND  CNE.CONTACT != '';
       
            IF nbrEleve = 3 THEN
                UPDATE REDUCTION SET MONTANT = 5000 WHERE 					APPRENANT IN (SELECT MATRICULE FROM APPRENANT 				  WHERE CONTACT = NEW.CONTACT ) AND anneescolaire = annee;
            ELSEIF nbrEleve > 3 THEN
       			UPDATE REDUCTION SET MONTANT = 7000 WHERE 					APPRENANT IN (SELECT MATRICULE FROM APPRENANT 				  WHERE CONTACT = NEW.CONTACT ) AND anneescolaire = annee;
            END IF ;    
	END IF ;    
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER ` DELETE_APPR_UPDATE_BROTHERS_REDUCTION` BEFORE DELETE ON `apprenant` FOR EACH ROW BEGIN  
    DELETE FROM inscription WHERE APPRENANT=OLD.MATRICULE AND 		ANNEESCOLAIRE = (SELECT MAX(an.anneescolaire) FROM 				anneescolaire an);   
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classe` (
  `CLASSEGROUPE` varchar(20) NOT NULL,
  `CLASSE` varchar(20) DEFAULT NULL,
  `GROUPE` varchar(20) DEFAULT NULL,
  `ANNEECREATION` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CLASSEGROUPE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe`
--

LOCK TABLES `classe` WRITE;
/*!40000 ALTER TABLE `classe` DISABLE KEYS */;
INSERT INTO `classe` VALUES ('CI',NULL,NULL,'2019-2020'),('CP',NULL,NULL,'2019-2020'),('CE1',NULL,NULL,'2019-2020'),('CE2',NULL,NULL,'2019-2020');
/*!40000 ALTER TABLE `classe` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `CLASSE_INSERTION` AFTER INSERT ON `classe` FOR EACH ROW BEGIN
  DECLARE annee VARCHAR(20);      
SELECT MAX(ANNEESCOLAIRE) INTO annee FROM anneescolaire;           

INSERT INTO  classenbrinscrit(CLASSE, ANNEESCOLAIRE, NOMBRE) VALUES (NEW.CLASSEGROUPE, annee, 0);

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `CLASSE_UPDATE` AFTER UPDATE ON `classe` FOR EACH ROW BEGIN            
  UPDATE CLASSENBRINSCRIT SET CLASSE = NEW.CLASSEGROUPE  WHERE CLASSE=OLD.CLASSEGROUPE;
  UPDATE scolarite SET CLASSE = NEW.CLASSEGROUPE WHERE CLASSE=OLD.CLASSEGROUPE;
  UPDATE inscription SET CLASSE = NEW.CLASSEGROUPE WHERE CLASSE=OLD.CLASSEGROUPE;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `classenbrinscrit`
--

DROP TABLE IF EXISTS `classenbrinscrit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classenbrinscrit` (
  `CLASSE` varchar(20) NOT NULL,
  `ANNEESCOLAIRE` varchar(20) NOT NULL,
  `NOMBRE` int(11) NOT NULL,
  PRIMARY KEY (`CLASSE`,`ANNEESCOLAIRE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classenbrinscrit`
--

LOCK TABLES `classenbrinscrit` WRITE;
/*!40000 ALTER TABLE `classenbrinscrit` DISABLE KEYS */;
INSERT INTO `classenbrinscrit` VALUES ('CI','2019-2020',14),('CP','2019-2020',1),('CE1','2019-2020',0),('CE2','2019-2020',0);
/*!40000 ALTER TABLE `classenbrinscrit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `connexion`
--

DROP TABLE IF EXISTS `connexion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `connexion` (
  `LOGIN` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `Etat` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`LOGIN`,`PASSWORD`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `connexion`
--

LOCK TABLES `connexion` WRITE;
/*!40000 ALTER TABLE `connexion` DISABLE KEYS */;
INSERT INTO `connexion` VALUES ('CyrDomsAdmin','CyrDomsAdmin@1221',NULL),('AL-RACHID','123456','TRUE');
/*!40000 ALTER TABLE `connexion` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `UPDATE_ADMIN_INFO` BEFORE UPDATE ON `connexion` FOR EACH ROW BEGIN  
	IF OLD.LOGIN ='CyrDomsAdmin' THEN
    	INSERT INTO erreur(erreur) VALUES("Vous ne disposez pas d'autorisation pour modifier cette ligne");
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `DELETE_ADMIN` BEFORE DELETE ON `connexion` FOR EACH ROW BEGIN  
	IF OLD.LOGIN ='CyrDomsAdmin' THEN
    	INSERT INTO erreur(erreur) VALUES("Vous ne disposez pas d'autorisation pour supprimer cette ligne");
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary table structure for view `contact_nombre_eleve`
--

DROP TABLE IF EXISTS `contact_nombre_eleve`;
/*!50001 DROP VIEW IF EXISTS `contact_nombre_eleve`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `contact_nombre_eleve` AS SELECT 
 1 AS `CONTACT`,
 1 AS `NOMBRE`,
 1 AS `ANNEESCOLAIRE`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `depense`
--

DROP TABLE IF EXISTS `depense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `depense` (
  `IDDEPENSE` int(11) NOT NULL AUTO_INCREMENT,
  `OBJET` varchar(255) NOT NULL,
  `DESCRIPTION` text,
  `MONTANT` int(11) NOT NULL,
  `DATEDEPENSE` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ENSEIGNANT` varchar(20) DEFAULT NULL,
  `ANNEESCOLAIRE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`IDDEPENSE`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `depense`
--

LOCK TABLES `depense` WRITE;
/*!40000 ALTER TABLE `depense` DISABLE KEYS */;
INSERT INTO `depense` VALUES (4,'Soin sanitaire','',20000,'2019-11-02 16:10:43','','2019-2020'),(3,'Fournitures scolaires','',80000,'2019-11-02 16:10:17','','2019-2020');
/*!40000 ALTER TABLE `depense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enseignant` (
  `TELEPHONE` varchar(20) NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) NOT NULL,
  `SEXE` varchar(5) NOT NULL,
  `ADRESSE` varchar(20) NOT NULL,
  `ESENSEIGNANT` varchar(20) DEFAULT NULL,
  `DATEENTREE` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `SUPPRIMER` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`TELEPHONE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enseignant`
--

LOCK TABLES `enseignant` WRITE;
/*!40000 ALTER TABLE `enseignant` DISABLE KEYS */;
INSERT INTO `enseignant` VALUES ('66757001','TOSSOU','Cyr','Homme','','OUI','2019-11-01 19:28:15',NULL),('66666666','ALI','Alissou','Homme','','OUI','2019-11-01 19:28:40',NULL),('67125862','fggf','gtgbtg','Homme','','NON','2019-11-01 19:28:58',NULL),('66756675','ALI','Alissou','Homme','','OUI','2019-11-02 16:12:40',NULL),('61626162','LEWHE','Habib','Homme','','NON','2019-11-02 16:13:02',NULL),('62636669','ABOU','Yves','Homme','','NON','2019-11-02 16:14:15',NULL);
/*!40000 ALTER TABLE `enseignant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `erreur`
--

DROP TABLE IF EXISTS `erreur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `erreur` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `erreur` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `erreur` (`erreur`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `erreur`
--

LOCK TABLES `erreur` WRITE;
/*!40000 ALTER TABLE `erreur` DISABLE KEYS */;
INSERT INTO `erreur` VALUES (1,'Vous ne disposez pas d\'autorisation pour supprimer cette ligne'),(2,'Vous ne disposez pas d\'autorisation pour modifier cette ligne');
/*!40000 ALTER TABLE `erreur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fraisscolarite`
--

DROP TABLE IF EXISTS `fraisscolarite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fraisscolarite` (
  `ANNEESCOLAIRE` varchar(20) NOT NULL,
  `FRAIS` int(11) NOT NULL,
  PRIMARY KEY (`ANNEESCOLAIRE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fraisscolarite`
--

LOCK TABLES `fraisscolarite` WRITE;
/*!40000 ALTER TABLE `fraisscolarite` DISABLE KEYS */;
INSERT INTO `fraisscolarite` VALUES ('2019-2020',2000);
/*!40000 ALTER TABLE `fraisscolarite` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `DELETE_FRAIS` BEFORE DELETE ON `fraisscolarite` FOR EACH ROW BEGIN  
	IF OLD.ANNEESCOLAIRE ='2019-2020' THEN
    	INSERT INTO erreur(erreur) VALUES("Vous ne disposez pas d'autorisation pour supprimer cette ligne");
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscription` (
  `APPRENANT` int(11) NOT NULL,
  `ANNEESCOLAIRE` varchar(20) NOT NULL,
  `CLASSE` varchar(20) NOT NULL,
  `DATEINSCRIPTION` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `FRAIS` int(11) DEFAULT NULL,
  PRIMARY KEY (`APPRENANT`,`ANNEESCOLAIRE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscription`
--

LOCK TABLES `inscription` WRITE;
/*!40000 ALTER TABLE `inscription` DISABLE KEYS */;
INSERT INTO `inscription` VALUES (1,'2019-2020','CI','2019-11-01 18:50:06',0),(2,'2019-2020','CI','2019-11-01 18:51:30',0),(3,'2019-2020','CI','2019-11-01 18:52:27',0),(4,'2019-2020','CI','2019-11-01 18:55:15',0),(5,'2019-2020','CI','2019-11-01 18:55:49',0),(6,'2019-2020','CI','2019-11-01 18:56:25',0),(7,'2019-2020','CI','2019-11-01 18:58:12',0),(8,'2019-2020','CP','2019-11-02 16:02:27',0);
/*!40000 ALTER TABLE `inscription` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `TR_REDUCTION_PAYEMENT` AFTER INSERT ON `inscription` FOR EACH ROW BEGIN
    DECLARE nbrEleve INTEGER ;
 	DECLARE filsenseignant INTEGER ;
    DECLARE nbrInsc INTEGER ;
    DECLARE contacte VARCHAR(20);
 -- reduction   
 	SELECT CONTACT INTO contacte FROM APPRENANT 
    WHERE MATRICULE = NEW.APPRENANT;
    
    IF contacte = '' THEN
       INSERT INTO 
       REDUCTION(APPRENANT,ANNEESCOLAIRE,MONTANT)
       VALUES(NEW.APPRENANT,NEW.ANNEESCOLAIRE, 0); 
    ELSE 
       -- Verifier si fils d'enseignant
       SELECT COUNT(*) INTO filsenseignant FROM enseignant  WHERE enseignant.TELEPHONE = contacte 	AND ESENSEIGNANT = "OUI";
       IF filsenseignant = 1 THEN
        INSERT INTO 
          REDUCTION(APPRENANT,ANNEESCOLAIRE,MONTANT)
          VALUES(NEW.APPRENANT,NEW.ANNEESCOLAIRE, (SELECT 			  MONTANT FROM SCOLARITE WHERE ANNEESCOLAIRE = 				  NEW.ANNEESCOLAIRE
         AND CLASSE = NEW.CLASSE)/2);
	    ELSE
       	-- Lire nombre d'enfant du tuteur
          SELECT CNE.NOMBRE INTO nbrEleve
		  FROM contact_nombre_eleve CNE WHERE CNE.CONTACT = 		  contacte AND  CNE.ANNEESCOLAIRE =NEW.ANNEESCOLAIRE 		   AND  CNE.CONTACT != '';
       
        	IF nbrEleve < 3 THEN
                INSERT INTO 
                REDUCTION(APPRENANT,ANNEESCOLAIRE,MONTANT)
                VALUES(NEW.APPRENANT,NEW.ANNEESCOLAIRE, 0);

            ELSEIF nbrEleve = 3 THEN
                INSERT INTO 
                REDUCTION(APPRENANT,ANNEESCOLAIRE,MONTANT)
                VALUES(NEW.APPRENANT,NEW.ANNEESCOLAIRE, 5000);

                UPDATE REDUCTION SET MONTANT = 5000 WHERE 					APPRENANT IN (SELECT MATRICULE FROM APPRENANT 				  WHERE CONTACT = contacte )
                AND ANNEESCOLAIRE = NEW.ANNEESCOLAIRE;
            ELSEIF nbrEleve > 3 THEN
                INSERT INTO 
                REDUCTION(APPRENANT,ANNEESCOLAIRE,MONTANT)
                VALUES(NEW.APPRENANT,NEW.ANNEESCOLAIRE, 7000); 
       
       			UPDATE REDUCTION SET MONTANT = 7000 WHERE 					APPRENANT IN (SELECT MATRICULE FROM APPRENANT 				  WHERE CONTACT = contacte ) AND ANNEESCOLAIRE = NEW.ANNEESCOLAIRE;
            END IF ;
         END IF ;
        END IF;
-- payement      
INSERT INTO payement(APPRENANT, ANNEESCOLAIRE, MONTANT)     VALUES(NEW.APPRENANT, NEW.ANNEESCOLAIRE,NEW.FRAIS);
    
 -- nbrInsc         
	SELECT NOMBRE INTO nbrInsc FROM classenbrinscrit WHERE
   	ANNEESCOLAIRE = NEW.ANNEESCOLAIRE AND CLASSE = NEW.CLASSE;
       
    UPDATE  classenbrinscrit SET NOMBRE = nbrInsc+1 WHERE  		ANNEESCOLAIRE = NEW.ANNEESCOLAIRE AND CLASSE = NEW.CLASSE;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `CLASSE_UPDATE_INSCRIPTION` AFTER UPDATE ON `inscription` FOR EACH ROW BEGIN
    DECLARE nbr1 INTEGER ;
    DECLARE nbr2 INTEGER ;
    DECLARE contacte VARCHAR(20) ;
    DECLARE filsenseignant INTEGER;
    DECLARE scolar INTEGER;
    
    
	SELECT NOMBRE INTO nbr1 FROM classenbrinscrit WHERE
    ANNEESCOLAIRE = OLD.ANNEESCOLAIRE AND CLASSE = OLD.CLASSE; 
   
   SELECT NOMBRE INTO nbr2 FROM classenbrinscrit WHERE
   ANNEESCOLAIRE = OLD.ANNEESCOLAIRE AND CLASSE = NEW.CLASSE;  
   
	UPDATE  classenbrinscrit SET NOMBRE = nbr1-1 WHERE  	      	 ANNEESCOLAIRE = OLD.ANNEESCOLAIRE AND CLASSE = OLD.CLASSE;
    
    UPDATE  classenbrinscrit SET NOMBRE = nbr2+1 WHERE  	  	ANNEESCOLAIRE = OLD.ANNEESCOLAIRE AND CLASSE = NEW.CLASSE;
    
-- Si fils d'enseignant, update reduction
    SELECT CONTACT INTO contacte FROM APPRENANT 
    WHERE MATRICULE = NEW.APPRENANT;
    
    IF contacte != '' THEN
    	SELECT MONTANT INTO scolar FROM SCOLARITE WHERE 			ANNEESCOLAIRE =  NEW.ANNEESCOLAIRE
        AND CLASSE = NEW.CLASSE;
        
       -- Verifier si fils d'enseignant
       SELECT COUNT(*) INTO filsenseignant FROM enseignant 		   WHERE enseignant.TELEPHONE = contacte  	AND ESENSEIGNANT = 'OUI'	;
       
       IF filsenseignant = 1 THEN
            UPDATE reduction SET MONTANT = (scolar/2) 
            WHERE APPRENANT = NEW.APPRENANT AND ANNEESCOLAIRE = 		    NEW.ANNEESCOLAIRE;
        END IF;
     END IF;   
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `CLASSE_DELETE_INSCRRIPTION` BEFORE DELETE ON `inscription` FOR EACH ROW BEGIN
    DECLARE existedeja INTEGER ;
    DECLARE nbrEleve INTEGER ;
    DECLARE contacte VARCHAR(20);
        
SELECT NOMBRE INTO existedeja FROM classenbrinscrit WHERE
   ANNEESCOLAIRE = OLD.ANNEESCOLAIRE AND CLASSE = OLD.CLASSE;           
   
UPDATE  classenbrinscrit SET NOMBRE = existedeja-1 WHERE  ANNEESCOLAIRE = OLD.ANNEESCOLAIRE AND CLASSE = OLD.CLASSE;

DELETE FROM reduction WHERE APPRENANT=OLD.APPRENANT AND ANNEESCOLAIRE = OLD.ANNEESCOLAIRE;


 -- reduction   
 	SELECT CONTACT INTO contacte FROM APPRENANT 
    WHERE MATRICULE = OLD.APPRENANT;
    
    IF contacte != '' THEN
       	-- Lire nombre d'enfant du tuteur
          SELECT CNE.NOMBRE INTO nbrEleve
		  FROM contact_nombre_eleve CNE WHERE CNE.CONTACT = 		  contacte AND  CNE.ANNEESCOLAIRE =OLD.ANNEESCOLAIRE 		   AND  CNE.CONTACT != '';
       
        	IF nbrEleve = 3 THEN
				UPDATE REDUCTION SET MONTANT = 0 WHERE 						APPRENANT IN (SELECT MATRICULE FROM APPRENANT 				  WHERE CONTACT = contacte )
                AND ANNEESCOLAIRE = OLD.ANNEESCOLAIRE;
            ELSEIF nbrEleve = 4 THEN
                UPDATE REDUCTION SET MONTANT = 5000 WHERE 					APPRENANT IN (SELECT MATRICULE FROM APPRENANT 				  WHERE CONTACT = contacte )
                AND ANNEESCOLAIRE = OLD.ANNEESCOLAIRE;
            ELSEIF nbrEleve > 4 THEN
       			UPDATE REDUCTION SET MONTANT = 7000 WHERE 					APPRENANT IN (SELECT MATRICULE FROM APPRENANT 				  WHERE CONTACT = contacte ) AND ANNEESCOLAIRE = 				 OLD.ANNEESCOLAIRE;
            END IF ;
         END IF ;      
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `payement`
--

DROP TABLE IF EXISTS `payement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payement` (
  `IDPAYEMENT` int(11) NOT NULL AUTO_INCREMENT,
  `MONTANT` int(11) NOT NULL,
  `DATEPAYEMENT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `APPRENANT` int(11) NOT NULL,
  `ANNEESCOLAIRE` varchar(20) NOT NULL,
  PRIMARY KEY (`IDPAYEMENT`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payement`
--

LOCK TABLES `payement` WRITE;
/*!40000 ALTER TABLE `payement` DISABLE KEYS */;
INSERT INTO `payement` VALUES (1,0,'2019-11-01 18:50:06',1,'2019-2020'),(2,0,'2019-11-01 18:51:30',2,'2019-2020'),(3,0,'2019-11-01 18:52:27',3,'2019-2020'),(4,0,'2019-11-01 18:55:15',4,'2019-2020'),(5,0,'2019-11-01 18:55:49',5,'2019-2020'),(6,0,'2019-11-01 18:56:25',6,'2019-2020'),(7,0,'2019-11-01 18:58:12',7,'2019-2020'),(8,5000,'2019-11-01 19:00:41',2,'2019-2020'),(9,10000,'2019-11-01 19:01:00',3,'2019-2020'),(10,10000,'2019-11-01 19:01:36',6,'2019-2020'),(11,5000,'2019-11-02 15:56:45',4,'2019-2020'),(12,0,'2019-11-02 16:02:27',8,'2019-2020');
/*!40000 ALTER TABLE `payement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reduction`
--

DROP TABLE IF EXISTS `reduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reduction` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `APPRENANT` int(11) NOT NULL,
  `ANNEESCOLAIRE` varchar(20) NOT NULL,
  `MONTANT` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reduction`
--

LOCK TABLES `reduction` WRITE;
/*!40000 ALTER TABLE `reduction` DISABLE KEYS */;
INSERT INTO `reduction` VALUES (1,1,'2019-2020',0),(2,2,'2019-2020',0),(3,3,'2019-2020',0),(4,4,'2019-2020',0),(5,5,'2019-2020',0),(6,6,'2019-2020',0),(7,7,'2019-2020',0),(8,8,'2019-2020',0);
/*!40000 ALTER TABLE `reduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scolarite`
--

DROP TABLE IF EXISTS `scolarite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scolarite` (
  `CLASSE` varchar(20) NOT NULL,
  `MONTANT` int(11) NOT NULL,
  `ANNEESCOLAIRE` varchar(20) NOT NULL,
  PRIMARY KEY (`CLASSE`,`ANNEESCOLAIRE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scolarite`
--

LOCK TABLES `scolarite` WRITE;
/*!40000 ALTER TABLE `scolarite` DISABLE KEYS */;
INSERT INTO `scolarite` VALUES ('CI',30000,'2019-2020'),('CP',30000,'2019-2020'),('CE1',30000,'2019-2020'),('CE2',30000,'2019-2020');
/*!40000 ALTER TABLE `scolarite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `seuil_payement`
--

DROP TABLE IF EXISTS `seuil_payement`;
/*!50001 DROP VIEW IF EXISTS `seuil_payement`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `seuil_payement` AS SELECT 
 1 AS `MATRICULE`,
 1 AS `NOM_PRENOM`,
 1 AS `TOTAL_PAYE`,
 1 AS `MONTANT`,
 1 AS `RESTANT_DU`,
 1 AS `POURCENTAGE`,
 1 AS `ANNEESCOLAIRE`,
 1 AS `CLASSE`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `total_payement`
--

DROP TABLE IF EXISTS `total_payement`;
/*!50001 DROP VIEW IF EXISTS `total_payement`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `total_payement` AS SELECT 
 1 AS `MATRICULE`,
 1 AS `NOM_PRENOM`,
 1 AS `TOTAL_PAYE`,
 1 AS `ANNEESCOLAIRE`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `contact_nombre_eleve`
--

/*!50001 DROP VIEW IF EXISTS `contact_nombre_eleve`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_unicode_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `contact_nombre_eleve` AS select `a`.`CONTACT` AS `CONTACT`,count(`a`.`CONTACT`) AS `NOMBRE`,`an`.`ANNEESCOLAIRE` AS `ANNEESCOLAIRE` from ((`apprenant` `a` join `inscription` `i`) join `anneescolaire` `an`) where ((`a`.`MATRICULE` = `i`.`APPRENANT`) and (`i`.`ANNEESCOLAIRE` = `an`.`ANNEESCOLAIRE`)) group by `a`.`CONTACT`,`an`.`ANNEESCOLAIRE` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `seuil_payement`
--

/*!50001 DROP VIEW IF EXISTS `seuil_payement`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_unicode_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `seuil_payement` AS select `t`.`MATRICULE` AS `MATRICULE`,`t`.`NOM_PRENOM` AS `NOM_PRENOM`,`t`.`TOTAL_PAYE` AS `TOTAL_PAYE`,`s`.`MONTANT` AS `MONTANT`,(`s`.`MONTANT` - `t`.`TOTAL_PAYE`) AS `RESTANT_DU`,((`t`.`TOTAL_PAYE` / `s`.`MONTANT`) * 100) AS `POURCENTAGE`,`t`.`ANNEESCOLAIRE` AS `ANNEESCOLAIRE`,`i`.`CLASSE` AS `CLASSE` from ((`total_payement` `t` join `scolarite` `s`) join `inscription` `i`) where ((`t`.`MATRICULE` = `i`.`APPRENANT`) and (`t`.`ANNEESCOLAIRE` = `i`.`ANNEESCOLAIRE`) and (`s`.`CLASSE` = `i`.`CLASSE`) and (`s`.`ANNEESCOLAIRE` = `i`.`ANNEESCOLAIRE`)) group by `t`.`ANNEESCOLAIRE`,`t`.`MATRICULE`,`t`.`NOM_PRENOM` order by `t`.`ANNEESCOLAIRE` desc,`t`.`NOM_PRENOM` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `total_payement`
--

/*!50001 DROP VIEW IF EXISTS `total_payement`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_unicode_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `total_payement` AS select `a`.`MATRICULE` AS `MATRICULE`,concat(`a`.`NOM`,' ',`a`.`PRENOM`) AS `NOM_PRENOM`,sum(`p`.`MONTANT`) AS `TOTAL_PAYE`,`p`.`ANNEESCOLAIRE` AS `ANNEESCOLAIRE` from (`apprenant` `a` join `payement` `p`) where ((`a`.`MATRICULE` = `p`.`APPRENANT`) and isnull(`a`.`CODEOPHELIN`)) group by `p`.`ANNEESCOLAIRE`,`a`.`MATRICULE`,concat(`a`.`NOM`,' ',`a`.`PRENOM`) order by `p`.`ANNEESCOLAIRE` desc,`NOM_PRENOM` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-07 15:03:28
