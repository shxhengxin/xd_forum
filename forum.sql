/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.26 : Database - forum
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`forum` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `forum`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `category` */

insert  into `category`(`id`,`name`,`weight`,`create_time`) values 
(1,'后端',34235,'2020-11-01 15:02:50'),
(2,'前端',23,'2020-09-13 15:03:35'),
(3,'app',342,'2020-09-13 15:03:38'),
(4,'测试',44,'2020-09-13 15:03:40'),
(5,'大数据',4,'2020-09-13 15:03:42');

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL COMMENT '楼层编号，回复是不能删除的',
  `content` varchar(524) DEFAULT NULL COMMENT '回复内容',
  `user_id` int(11) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL COMMENT '回复人名称',
  `user_img` varchar(128) DEFAULT NULL COMMENT '回复人头像',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete` int(11) DEFAULT NULL COMMENT '0是正常，1是禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `reply` */

insert  into `reply`(`id`,`topic_id`,`floor`,`content`,`user_id`,`username`,`user_img`,`create_time`,`update_time`,`delete`) values 
(1,1,1,'哈哈',1,'jack','11111111111111','2020-09-13 17:44:48','2020-09-13 17:44:51',0),
(2,2,2,'66',1,'jack','2222222222222','2020-09-13 17:44:53','2020-09-13 17:44:55',0),
(3,1,2,'qq',1,'jack','33333333333','2020-09-13 17:44:57','2020-09-13 17:44:59',0),
(4,1,3,'666',1,'jack','4444444444444','2020-09-13 17:45:01','2020-09-13 17:45:03',0),
(5,1,4,'7777',1,'jack','55555555555555','2020-09-13 17:45:05','2020-09-13 17:45:07',0),
(6,1,5,'8888',1,'jack','6666666666666','2020-09-13 17:45:09','2020-09-13 17:45:11',0);

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `c_id` int(11) DEFAULT NULL COMMENT '分类',
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `content` varchar(1024) DEFAULT NULL COMMENT '内容',
  `pv` int(11) DEFAULT NULL COMMENT '浏览量',
  `user_id` int(11) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `user_img` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `hot` int(2) DEFAULT '0' COMMENT '是否热门 1是热门',
  `delete` int(11) DEFAULT '0' COMMENT '0是未删除，1是一件删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `topic` */

insert  into `topic`(`id`,`c_id`,`title`,`content`,`pv`,`user_id`,`username`,`user_img`,`create_time`,`update_time`,`hot`,`delete`) values 
(1,2,'javaweb教程','javaweb教程',12342143,1,'jack','dfffffffff','2020-09-13 15:50:55','2020-09-13 15:50:58',0,0),
(2,2,'html教程','html教程',87,1,'jack','dddddd','2020-09-13 15:51:37','2020-09-13 15:51:40',0,0),
(3,2,'mysql教程','mysql教程',33,1,'jack','ddd','2020-09-13 15:54:15','2020-09-13 15:54:22',0,0),
(4,2,'php教程','php教程',44,1,'jack','ggdgd','2020-09-13 15:54:18','2020-09-13 15:54:25',0,0),
(5,2,'前端教程','前端教程',55,1,'jack','ddgfdhgfh','2020-09-13 15:54:19','2020-09-13 15:54:28',0,0),
(6,4,'大数据教程','大数据教程',3,1,'jack','大数据教程','2020-09-13 15:55:28','2020-09-13 15:55:30',0,0);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(32) DEFAULT NULL,
  `pwd` varchar(128) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `img` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `role` int(11) DEFAULT NULL COMMENT '1是普通用户，2是管理员',
  `username` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
