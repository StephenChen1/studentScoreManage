/*
Navicat MySQL Data Transfer

Source Server         : 66
Source Server Version : 50722
Source Host           : 193.112.7.197:3306
Source Database       : scoreManage

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-06-30 00:06:30
*/


--数据初始化脚本

--创建数据库
CREATE DATABASE scoreManage;
--使用数据库
use scoreManage ;




SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '课程id',
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('20001', '数据库原理');
INSERT INTO `course` VALUES ('20002', '计算机网络');
INSERT INTO `course` VALUES ('20003', '编译原理');

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` varchar(12) NOT NULL COMMENT '学号和工号作为id',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('00001', 'jiao', '00001');
INSERT INTO `login` VALUES ('10001', 'lixv', '10001');
INSERT INTO `login` VALUES ('10002', null, '10002');
INSERT INTO `login` VALUES ('10003', null, '10003');
INSERT INTO `login` VALUES ('201525010507', 'stephen', '201525010507');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_id` varchar(12) CHARACTER SET utf8 NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('00001', '伍子钊');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` varchar(12) NOT NULL,
  `name` varchar(255) NOT NULL,
  `class` varchar(20) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201525010507', '陈祝林', 'cs5', '13427547817');
INSERT INTO `student` VALUES ('201525010525', '张浩晖', 'CS5', '13427547548');

-- ----------------------------
-- Table structure for `student_score`
-- ----------------------------
DROP TABLE IF EXISTS `student_score`;
CREATE TABLE `student_score` (
  `student_id` varchar(12) NOT NULL,
  `course_id` varchar(20) NOT NULL,
  `teacher_id` varchar(12) NOT NULL,
  `score` double(5,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '学生、教师、课程三者id得到一个成绩',
  PRIMARY KEY (`student_id`,`teacher_id`,`course_id`),
  KEY `t_id` (`teacher_id`),
  KEY `c_id` (`course_id`),
  CONSTRAINT `student_score_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `student_score_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `student_score_ibfk_3` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_score
-- ----------------------------
INSERT INTO `student_score` VALUES ('201525010507', '20001', '10001', '100.00');

-- ----------------------------
-- Table structure for `teach`
-- ----------------------------
DROP TABLE IF EXISTS `teach`;
CREATE TABLE `teach` (
  `teacher_id` varchar(12) NOT NULL,
  `course_id` varchar(20) NOT NULL,
  PRIMARY KEY (`teacher_id`,`course_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teach
-- ----------------------------
INSERT INTO `teach` VALUES ('10001', '20001');
INSERT INTO `teach` VALUES ('10003', '20001');
INSERT INTO `teach` VALUES ('10002', '20002');
INSERT INTO `teach` VALUES ('10003', '20003');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` varchar(12) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('10001', '李旭', '13427547817');
INSERT INTO `teacher` VALUES ('10002', '李三', '15627521030');
INSERT INTO `teacher` VALUES ('10003', '张浩晖', null);
