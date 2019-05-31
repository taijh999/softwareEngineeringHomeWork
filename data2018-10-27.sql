-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.40


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema zuopin1013
--

CREATE DATABASE IF NOT EXISTS zuopin1013;
USE zuopin1013;

--
-- Definition of table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` varchar(11) NOT NULL COMMENT '课程编号',
  `course_name` varchar(255) DEFAULT NULL COMMENT '课程名',
  `coursekind_id` varchar(255) DEFAULT NULL COMMENT '课程分类编号',
  `course_score` varchar(255) DEFAULT NULL COMMENT '学分',
  `course_hour` varchar(255) DEFAULT NULL COMMENT '学时',
  `course_remark` varchar(255) DEFAULT NULL COMMENT '附加说明',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `course`
--

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`course_id`,`course_name`,`coursekind_id`,`course_score`,`course_hour`,`course_remark`) VALUES 
 ('1010','java1','10','5','90','课程介绍1'),
 ('1011','java2','10','3','60','课程介绍2'),
 ('1012','java3','11','5','90','课程介绍3'),
 ('1013','java4','12','5','40','课程介绍4'),
 ('1014','java5','10','5','70','课程介绍5'),
 ('1015','java6','10','5','90','课程介绍6'),
 ('1016','java7','10','5','90','课程介绍7'),
 ('1017','java8','11','5','90','课程介绍8'),
 ('1018','java9','12','5','90','课程介绍9'),
 ('1019','java10','10','5','90','课程介绍10'),
 ('1020','java11','12','5','90','课程介绍11');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


--
-- Definition of table `coursekind`
--

DROP TABLE IF EXISTS `coursekind`;
CREATE TABLE `coursekind` (
  `kind_id` varchar(10) NOT NULL COMMENT '分类编号',
  `kind_name` varchar(255) DEFAULT NULL COMMENT '分类名',
  `kind_remark` varchar(255) DEFAULT NULL COMMENT '附加说明',
  PRIMARY KEY (`kind_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `coursekind`
--

/*!40000 ALTER TABLE `coursekind` DISABLE KEYS */;
INSERT INTO `coursekind` (`kind_id`,`kind_name`,`kind_remark`) VALUES 
 ('10','通识必修课','分类说明'),
 ('11','通识选修课','分类说明'),
 ('12','实践课','分类说明');
/*!40000 ALTER TABLE `coursekind` ENABLE KEYS */;


--
-- Definition of table `loginfo`
--

DROP TABLE IF EXISTS `loginfo`;
CREATE TABLE `loginfo` (
  `logid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(20) DEFAULT NULL,
  `logintime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `loginfo`
--

/*!40000 ALTER TABLE `loginfo` DISABLE KEYS */;
INSERT INTO `loginfo` (`logid`,`userid`,`logintime`) VALUES 
 (1,'1','2015-11-18 18:11:06'),
 (37,'1','2017-10-14 11:39:27'),
 (38,'1','2017-10-14 14:30:54'),
 (39,'1','2017-10-14 15:00:07'),
 (40,'1','2018-10-27 09:32:58'),
 (41,'1','2018-10-27 09:59:23'),
 (42,'1','2018-10-27 10:15:16'),
 (43,'1','2018-10-27 10:17:27'),
 (44,'1','2018-10-27 10:21:08'),
 (45,'1','2018-10-27 10:27:48'),
 (46,'1','2018-10-27 10:31:05'),
 (47,'1','2018-10-27 10:40:43'),
 (48,'1','2018-10-27 11:03:23'),
 (49,'1','2018-10-27 11:13:17'),
 (50,'1','2018-10-27 11:33:43'),
 (51,'1','2018-10-27 11:48:54'),
 (52,'1','2018-10-27 14:43:03'),
 (53,'1','2018-10-27 15:03:30'),
 (54,'1','2018-10-27 15:08:55'),
 (55,'1','2018-10-27 15:12:31'),
 (56,'1','2018-10-27 15:21:31'),
 (57,'1','2018-10-27 15:22:44'),
 (58,'1','2018-10-27 15:26:06'),
 (59,'1','2018-10-27 15:32:30'),
 (60,'1','2018-10-27 15:36:44'),
 (61,'1','2018-10-27 15:52:02'),
 (62,'1','2018-10-27 16:06:50'),
 (63,'1','2018-10-27 16:09:22'),
 (64,'1','2018-10-27 16:09:31'),
 (65,'1','2018-10-27 16:12:58'),
 (66,'1','2018-10-27 16:19:36'),
 (67,'1','2018-10-27 16:24:19'),
 (68,'1','2018-10-27 16:30:12'),
 (69,'1','2018-10-27 16:30:27'),
 (70,'1','2018-10-27 16:39:00'),
 (71,'1','2018-10-27 16:39:09'),
 (72,'1','2018-10-27 16:44:47'),
 (73,'1','2018-10-27 16:47:34'),
 (74,'1','2018-10-27 18:53:53'),
 (75,'1','2018-10-27 18:54:12'),
 (76,'1','2018-10-27 19:01:15'),
 (77,'1','2018-10-27 19:05:21'),
 (78,'1','2018-10-27 19:06:17'),
 (79,'1','2018-10-27 19:12:36'),
 (80,'1','2018-10-27 19:19:13'),
 (81,'1','2018-10-27 19:20:26'),
 (82,'1','2018-10-27 19:21:49'),
 (83,'1','2018-10-27 19:25:19'),
 (84,'1','2018-10-27 19:32:32'),
 (85,'1','2018-10-27 19:35:12'),
 (86,'1','2018-10-27 19:42:36'),
 (87,'1','2018-10-27 19:44:48'),
 (88,'1','2018-10-27 19:57:46'),
 (89,'1','2018-10-27 20:33:33'),
 (90,'1','2018-10-27 20:34:14'),
 (91,'1','2018-10-27 20:39:23'),
 (92,'1','2018-10-27 20:40:07'),
 (93,'1','2018-10-27 20:40:17');
/*!40000 ALTER TABLE `loginfo` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `createTime` varchar(50) DEFAULT NULL,
  `roleId` int(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userId`,`userName`,`password`,`createTime`,`roleId`,`image`) VALUES 
 (1,'admin','1','2017-5-5 11:48:27',1,NULL),
 (5,'liulijie','1','2017-5-5 11:48:27',2,NULL),
 (6,'taijianhua','1','2017-5-5 11:51:31',2,NULL),
 (8,'20134071101','1','2017-5-5 12:14:02',3,NULL),
 (9,'20134071102','1','2017-5-5 12:14:39',3,NULL),
 (10,'20134071103','1','2017-5-5 12:14:54',3,NULL),
 (11,'20134071104','1','2017-5-5 12:15:12',3,NULL),
 (12,'20134071105','1','2017-5-5 12:15:31',3,NULL),
 (13,'20134071106','1','2017-5-5 12:15:46',3,NULL),
 (14,'20134071107','1','2017-5-5 12:16:38',3,NULL),
 (15,'20134071108','1','2017-5-5 12:16:57',3,NULL),
 (16,'20134071113','1','2017-5-5 12:17:39',3,NULL),
 (17,'20134071115','1','2017-5-5 12:18:14',3,NULL),
 (18,'20134071116','1','2017-5-5 12:18:41',3,NULL),
 (19,'20134071117','1','2017-5-5 12:19:21',3,NULL),
 (20,'20134071118','1','2017-5-5 12:19:36',3,NULL),
 (21,'zhujingfu','1','2017-5-8 16:51:29',2,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
