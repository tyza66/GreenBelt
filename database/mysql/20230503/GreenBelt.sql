/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : GreenBelt

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 03/05/2023 13:58:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for g_b_bars
-- ----------------------------
DROP TABLE IF EXISTS `g_b_bars`;
CREATE TABLE `g_b_bars`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `group` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of g_b_bars
-- ----------------------------
INSERT INTO `g_b_bars` VALUES (1, '192.168.100.106:80', '测试一号', 1);
INSERT INTO `g_b_bars` VALUES (2, '192.168.100.107:80', '测试二号', 0);
INSERT INTO `g_b_bars` VALUES (3, '192.168.100.1', '测试三号', 0);

SET FOREIGN_KEY_CHECKS = 1;
