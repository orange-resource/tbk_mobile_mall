/*
SQLyog v10.2 
MySQL - 5.7.11 : Database - com.orange.tbkmobile.db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`com.orange.tbkmobile.db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;

USE `com.orange.tbkmobile.db`;

/*Table structure for table `t_aliyun_oss` */

DROP TABLE IF EXISTS `t_aliyun_oss`;

CREATE TABLE `t_aliyun_oss` (
  `id` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `del_flag` int(1) DEFAULT '0' COMMENT '删除判断',
  `remarks` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `domain_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '前缀域名',
  `endpoint` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `key_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `key_secret` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `bucket_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `catalogue` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `style` longtext COLLATE utf8mb4_bin COMMENT '图片后缀样式'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='阿里云oss存储对象配置';

/*Data for the table `t_aliyun_oss` */

/*Table structure for table `t_carousel` */

DROP TABLE IF EXISTS `t_carousel`;

CREATE TABLE `t_carousel` (
  `id` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `del_flag` int(1) DEFAULT '0' COMMENT '删除判断',
  `remarks` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `image` longtext COLLATE utf8mb4_bin COMMENT '轮播主图',
  `click_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '点击跳转地址',
  `sort` bigint(20) DEFAULT NULL COMMENT '排序'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='首页轮播模块';

/*Data for the table `t_carousel` */

/*Table structure for table `t_course` */

DROP TABLE IF EXISTS `t_course`;

CREATE TABLE `t_course` (
  `id` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `del_flag` int(1) DEFAULT '0' COMMENT '删除判断',
  `remarks` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '新手教程标题',
  `content` longtext COLLATE utf8mb4_bin COMMENT '教程内容',
  `author` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '作者',
  `image` longtext COLLATE utf8mb4_bin COMMENT '主图地址'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='新手教程模块';

/*Data for the table `t_course` */

/*Table structure for table `t_hdk_config` */

DROP TABLE IF EXISTS `t_hdk_config`;

CREATE TABLE `t_hdk_config` (
  `id` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `del_flag` int(1) DEFAULT '0' COMMENT '删除判断',
  `remarks` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `appkey` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `pid` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '推广位id',
  `tb_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '淘宝号名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='好单库apikey配置';

/*Data for the table `t_hdk_config` */

insert  into `t_hdk_config`(`id`,`create_date`,`del_flag`,`remarks`,`update_date`,`appkey`,`pid`,`tb_name`) values ('1105781898782797826',1552473923761,0,'',1552577006764,'xxxx','mm_xxx_xxx_xxx','xxx');

/*Table structure for table `t_system_config` */

DROP TABLE IF EXISTS `t_system_config`;

CREATE TABLE `t_system_config` (
  `id` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `del_flag` int(1) DEFAULT '0' COMMENT '删除判断',
  `remarks` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `contact` longtext COLLATE utf8mb4_bin COMMENT '联系方式',
  `about` longtext COLLATE utf8mb4_bin COMMENT '关于我们',
  `footer` longtext COLLATE utf8mb4_bin COMMENT '网站底部'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='系统各种信息模块';

/*Data for the table `t_system_config` */

/*Table structure for table `t_system_message` */

DROP TABLE IF EXISTS `t_system_message`;

CREATE TABLE `t_system_message` (
  `id` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `del_flag` int(1) DEFAULT '0' COMMENT '删除判断',
  `remarks` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '消息标题',
  `content` longtext COLLATE utf8mb4_bin COMMENT '消息内容',
  `author` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '作者',
  `image` longtext COLLATE utf8mb4_bin COMMENT '消息主图'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='系统消息模块';

/*Data for the table `t_system_message` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `del_flag` int(1) DEFAULT '0' COMMENT '删除判断',
  `remarks` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `username` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='管理员';

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`create_date`,`del_flag`,`remarks`,`update_date`,`username`,`password`) values ('1',NULL,0,NULL,NULL,'1','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
