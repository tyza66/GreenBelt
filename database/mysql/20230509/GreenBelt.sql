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

 Date: 09/05/2023 15:29:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for g_b_area
-- ----------------------------
DROP TABLE IF EXISTS `g_b_area`;
CREATE TABLE `g_b_area`  (
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `min` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `max` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`address`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of g_b_area
-- ----------------------------
INSERT INTO `g_b_area` VALUES ('192.168.100.106:80', '15', '30');
INSERT INTO `g_b_area` VALUES ('das', 'asd', 'asd');

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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of g_b_bars
-- ----------------------------
INSERT INTO `g_b_bars` VALUES (1, '192.168.100.106:80', '测试一号', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `statu` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'tyza66', 'tyza66', 'tyza66', 'tyza66', 1);
INSERT INTO `user` VALUES (2, 'll', 'll', 'll', 'll', 1);
INSERT INTO `user` VALUES (3, 'xx', 'xx', 'giao', 'owdg5', 1);
INSERT INTO `user` VALUES (4, 'tyza77', 'tyza77', 'tyza77', 'skhe5', 1);
INSERT INTO `user` VALUES (5, '', '4', '人情味', '6og4g', 1);
INSERT INTO `user` VALUES (6, '防辐射', '人我确认', '惹我', '废弃物法人', NULL);
INSERT INTO `user` VALUES (7, 'fdsf', 'afaa', 'ad ', 'f6pdf', 1);
INSERT INTO `user` VALUES (8, '', '', '', '56spf', 1);
INSERT INTO `user` VALUES (9, 'giao', 'giao', '87784', 'edsfs', 1);
INSERT INTO `user` VALUES (12, 'giao', 'giao', 'sdsadf', '66pdf', 1);

SET FOREIGN_KEY_CHECKS = 1;
