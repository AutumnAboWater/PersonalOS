/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : localhost:3306
 Source Schema         : PersonnelOS

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 28/12/2023 18:07:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for user
-- ----------------------------
drop database if exists PersonnelOS;
create database PersonnelOS;
use PersonnelOS;
drop table if exists user;
create table user
(
    userId       int auto_increment comment '登录用户编号' primary key,
    userName     varchar(256) not null comment '用户名',
    userPassword varchar(256) not null comment '密码'
);

DROP TABLE IF EXISTS `rs`;
CREATE TABLE `rs`  (
                       `id` varchar(5)   NOT NULL,
                       `name` varchar(10)  NOT NULL,
                       `age` varchar(2)  NOT NULL,
                       `sex` varchar(2)  NULL DEFAULT NULL,
                       `number` varchar(11)   NULL DEFAULT NULL,
                       `edept` varchar(255)  NOT NULL,
                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rs
-- ----------------------------
INSERT INTO `user` VALUES (1,'admin','admin');
INSERT INTO `rs` VALUES ('10001', '张三', '20', '男', '18888888888', '人事部');
INSERT INTO `rs` VALUES ('10002', '王琦', '19', '女', '18562545920', '人事部');
INSERT INTO `rs` VALUES ('10003', '阿达', '29', '男', '15858828659', '人事部');
INSERT INTO `rs` VALUES ('10004', '萨克斯', '35', '女', '15848623048', '人事部');
INSERT INTO `rs` VALUES ('10005', '李四', '23', '男', '15632597129', '人事部');
INSERT INTO `rs` VALUES ('20001', '李静', '20', '女', '15639562014', '设计部');
INSERT INTO `rs` VALUES ('20002', '王菲', '25', '女', '15489855925', '设计部');
INSERT INTO `rs` VALUES ('20003', '张宇 ', '21', '男', '14588289658', '设计部');
INSERT INTO `rs` VALUES ('20004', '张起', '26', '男', '18798628635', '设计部');
INSERT INTO `rs` VALUES ('20005', '付亚楠', '20', '女', '18963589672', '设计部');

SET FOREIGN_KEY_CHECKS = 1;
