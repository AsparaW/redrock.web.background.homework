/*
 Navicat Premium Data Transfer

 Source Server         : lhtest
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : my_course_table

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 25/11/2018 19:31:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `teacher` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `info` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('A04181A1100010071', '形势与政策', '必修', '正常', '理论', '叶高生', '星期4第9-10节5-8周2108');
INSERT INTO `course` VALUES ('A04181A1110140013', '概率论与数理统计', '必修', '正常', '理论', '张伟', '星期2第3-4节1-17周3405+星期4第5-6节3-15周单周3405');
INSERT INTO `course` VALUES ('A04181A1110320004', '大学物理B（下）', '必修', '正常', '理论', '罗小兵', '星期1第1-2节1-17周3407+星期4第5-6节2-14周双周3407');
INSERT INTO `course` VALUES ('A04181A2021070004', '数字电路与逻辑设计', '必修', '正常', '理论', '晏中华', '星期2第5-6节1-15周3205+星期4第1-2节2-14周3207');
INSERT INTO `course` VALUES ('A04181A2040470004', '数据结构', '必修', '正常', '理论', '张璞', '星期3第1-2节2-15周5300+星期5第5-6节2-15周5300');
INSERT INTO `course` VALUES ('A04181A2040580001', '信号处理基础', '必修', '正常', '理论', '毕秀丽', '星期5第1-2节2-17周5300');
INSERT INTO `course` VALUES ('A04181B1220060049', '大学生职业发展与就业指导1', '必修', '正常', '实验实践', '马小丽', '星期3第9-10节2-9周3209');
INSERT INTO `course` VALUES ('AS04181A2021060009', '数字电路与逻辑设计实验', '必修', '正常', '实验实践', '张希', '星期1第3-4节6-8周,10-13周,15周电子技术实验室（五）(综合实验楼B209/B210)+星期2第9-10节6-8周,10-13周,15周电子技术实验室（五）(综合实验楼B209/B210)');
INSERT INTO `course` VALUES ('S04181A1110341025', '大学物理实验B（下）', '必修', '正常', '实验实践', '李登峰', '星期3第3-4节9周物理虚拟仿真实验室(综合实验楼C314/C315/C316)+星期3第3-4节7周,13周物理实验室（四）(综合实验楼C209/C210)+星期3第3-4节5周物理实验室（二）(综合实验楼C203/C204)+星期3第3-4节3周,15-17周单周电学设计性实验室(综合实验楼C310/C311)+星期3第3-4节1周光学设计性实验室(综合实验楼C312/C313)');
INSERT INTO `course` VALUES ('SK04181A2040470007', '数据结构', '必修', '正常', '理论', '刘伯红', '星期3第7-8节9-16周数据科学与大数据技术实验室(综合实验楼B516/B517)');
INSERT INTO `course` VALUES ('T00181A1090030007', '体育（俱乐部）-乒乓球中级', '必修', '正常', '未知', '王樱桃', '星期5第3-4节1-15周单周待定');

-- ----------------------------
-- Table structure for ctable
-- ----------------------------
DROP TABLE IF EXISTS `ctable`;
CREATE TABLE `ctable`  (
  `id` int(11) DEFAULT NULL,
  `_time` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `w1` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `w2` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `w3` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `w4` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `w5` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `w6` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `w7` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ctable
-- ----------------------------
INSERT INTO `ctable` VALUES (1, '1-2', '大学物理B（下）', '', '数据结构', '数字电路与逻辑设计', '信号处理基础', '', '');
INSERT INTO `ctable` VALUES (2, '3-4', '数字电路与逻辑设计实验', '概率论与数理统计', '大学物理实验B（下）,大学物理实验B（下）,大学物理实验B（下）,大学物理实验B（下）,大学物理实验B（下）', '', '体育（俱乐部）-乒乓球中级', '', '');
INSERT INTO `ctable` VALUES (3, '5-6', '', '数字电路与逻辑设计', '', '概率论与数理统计,大学物理B（下）', '数据结构', '', '');
INSERT INTO `ctable` VALUES (4, '7-8', '', '', '数据结构', '', '', '', '');
INSERT INTO `ctable` VALUES (5, '9-10', '', '数字电路与逻辑设计实验', '大学生职业发展与就业指导1', '形势与政策', '', '', '');
INSERT INTO `ctable` VALUES (6, '11-12', '', '', '', '', '', '', '');

SET FOREIGN_KEY_CHECKS = 1;
