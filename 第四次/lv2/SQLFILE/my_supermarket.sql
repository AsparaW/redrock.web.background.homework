/*
 Navicat Premium Data Transfer

 Source Server         : lhtest
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : my_supermarket

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 23/11/2018 20:44:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for depart_employee_relation
-- ----------------------------
DROP TABLE IF EXISTS `depart_employee_relation`;
CREATE TABLE `depart_employee_relation`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `department_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 400 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of depart_employee_relation
-- ----------------------------
INSERT INTO `depart_employee_relation` VALUES (393, 87, 201701);
INSERT INTO `depart_employee_relation` VALUES (394, 321, 201703);
INSERT INTO `depart_employee_relation` VALUES (395, 321, 201722);
INSERT INTO `depart_employee_relation` VALUES (396, 666, 201704);
INSERT INTO `depart_employee_relation` VALUES (397, 666, 201705);
INSERT INTO `depart_employee_relation` VALUES (398, 666, 201706);
INSERT INTO `depart_employee_relation` VALUES (399, 666, 201777);

-- ----------------------------
-- Table structure for depart_goods_relation
-- ----------------------------
DROP TABLE IF EXISTS `depart_goods_relation`;
CREATE TABLE `depart_goods_relation`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `department_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 457 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of depart_goods_relation
-- ----------------------------
INSERT INTO `depart_goods_relation` VALUES (449, 87, 222);
INSERT INTO `depart_goods_relation` VALUES (450, 87, 333);
INSERT INTO `depart_goods_relation` VALUES (451, 321, 333);
INSERT INTO `depart_goods_relation` VALUES (452, 321, 444);
INSERT INTO `depart_goods_relation` VALUES (453, 321, 555);
INSERT INTO `depart_goods_relation` VALUES (454, 666, 444);
INSERT INTO `depart_goods_relation` VALUES (455, 666, 555);
INSERT INTO `depart_goods_relation` VALUES (456, 666, 777);

-- ----------------------------
-- Table structure for depart_manager_relation
-- ----------------------------
DROP TABLE IF EXISTS `depart_manager_relation`;
CREATE TABLE `depart_manager_relation`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `department_id` int(11) DEFAULT NULL,
  `manager_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 172 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of depart_manager_relation
-- ----------------------------
INSERT INTO `depart_manager_relation` VALUES (169, 87, 200010);
INSERT INTO `depart_manager_relation` VALUES (170, 321, 200045);
INSERT INTO `depart_manager_relation` VALUES (171, 666, 200455);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cash` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (87, '部门A', 10000000);
INSERT INTO `department` VALUES (321, '部门B', 321123);
INSERT INTO `department` VALUES (666, '部门C', 666666);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `contact` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `job` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (201701, '张三', 22, '重庆市南岸区', '电话19322223333', '售货员');
INSERT INTO `employee` VALUES (201703, '李四', 21, '重庆市北碚区', '电话19324423333', '杂工');
INSERT INTO `employee` VALUES (201704, '小赵', 32, '重庆市江北区', '电话19326623333', '清洁工');
INSERT INTO `employee` VALUES (201705, '小钱', 42, '重庆市巴南区', '电话19327723333', '工头');
INSERT INTO `employee` VALUES (201706, '小孙', 26, '重庆市渝中区', '电话19328823333', '会计');
INSERT INTO `employee` VALUES (201722, '王五', 23, '重庆市渝北区', '电话19325523333', '搬运工');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `selling_price` decimal(10, 2) DEFAULT NULL,
  `purchasing_price` decimal(10, 2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (222, 'ABC洗衣液', 22.40, 10.00);
INSERT INTO `goods` VALUES (333, '苏打水', 4.00, 3.00);
INSERT INTO `goods` VALUES (444, 'ABC洗衣粉', 20.00, 10.50);
INSERT INTO `goods` VALUES (555, '水壶', 40.00, 30.00);
INSERT INTO `goods` VALUES (577, '灯泡', 30.00, 10.00);
INSERT INTO `goods` VALUES (777, 'U盘', 30.00, 20.00);

-- ----------------------------
-- Table structure for goods_storage_relation
-- ----------------------------
DROP TABLE IF EXISTS `goods_storage_relation`;
CREATE TABLE `goods_storage_relation`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL,
  `storage_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 343 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_storage_relation
-- ----------------------------
INSERT INTO `goods_storage_relation` VALUES (337, 222, 1);
INSERT INTO `goods_storage_relation` VALUES (338, 333, 1);
INSERT INTO `goods_storage_relation` VALUES (339, 444, 1);
INSERT INTO `goods_storage_relation` VALUES (340, 444, 2);
INSERT INTO `goods_storage_relation` VALUES (341, 555, 2);
INSERT INTO `goods_storage_relation` VALUES (342, 777, 2);

-- ----------------------------
-- Table structure for goods_supplier_relation
-- ----------------------------
DROP TABLE IF EXISTS `goods_supplier_relation`;
CREATE TABLE `goods_supplier_relation`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 400 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_supplier_relation
-- ----------------------------
INSERT INTO `goods_supplier_relation` VALUES (393, 222, 177);
INSERT INTO `goods_supplier_relation` VALUES (394, 333, 177);
INSERT INTO `goods_supplier_relation` VALUES (395, 777, 177);
INSERT INTO `goods_supplier_relation` VALUES (396, 222, 188);
INSERT INTO `goods_supplier_relation` VALUES (397, 444, 188);
INSERT INTO `goods_supplier_relation` VALUES (398, 555, 188);
INSERT INTO `goods_supplier_relation` VALUES (399, 777, 188);

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `contact` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (200010, '李老板', '北京', '电话68882222');
INSERT INTO `manager` VALUES (200045, '刘老板', '上海', '电话68552222');
INSERT INTO `manager` VALUES (200455, '钟老板', '重庆', '电话68662222');

-- ----------------------------
-- Table structure for storage
-- ----------------------------
DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage`  (
  `id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `contact` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of storage
-- ----------------------------
INSERT INTO `storage` VALUES (1, '王经理', '电话66662222');
INSERT INTO `storage` VALUES (2, '周经理', '电话66662233');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `contact` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (177, '百货市场177号', 'QQ12233', '电话63333333');
INSERT INTO `supplier` VALUES (188, '百货市场188号', 'QQ13333', '电话63333322');

SET FOREIGN_KEY_CHECKS = 1;
