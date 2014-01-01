-- 用户表
DROP TABLE IF EXISTS `weibo_user`;
CREATE TABLE `weibo_user` (
  `user_id` varchar(20) NOT NULL COMMENT '用户ID',
  `user_name` varchar(150) NOT NULL COMMENT '用户昵称',
  `user_screen_name` varchar(150) NOT NULL COMMENT '用户网名',
  `profile_image_url` varchar(500) DEFAULT NULL COMMENT '用户头像',
  `gender` char(1) DEFAULT NULL COMMENT '性别',
  `province` varchar(20) DEFAULT NULL COMMENT '省份',
  `city` varchar(20) DEFAULT NULL COMMENT '城市',
  `location` varchar(150) DEFAULT NULL COMMENT '地点',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
-- 参与表
DROP TABLE IF EXISTS `join_hist`;
CREATE TABLE `join_hist` (
  `join_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '参与ID',
  `user_id` varchar(20) NOT NULL COMMENT '用户ID',
  `join_time` datetime DEFAULT NULL COMMENT '参与时间',
  PRIMARY KEY (`join_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参与表';
-- 奖品表
DROP TABLE IF EXISTS `prize`;
CREATE TABLE `prize` (
  `prize_id` int(3) NOT NULL AUTO_INCREMENT COMMENT '商品ID, 100:竹叶青12月量的茶包, 101:空气净化器, 102:3M环保口罩, 103:竹叶青品饮小铁盒, 104:绿色植物盆栽',
  `prize_name` varchar(20) DEFAULT NULL COMMENT '商品名称',
  `total_count` int(3) NOT NULL COMMENT '奖品总数量',
  `current_count` int(3) NOT NULL COMMENT '奖品当前数量',
  `probability` double DEFAULT 0 COMMENT '中奖几率',
  `active_yn` char(1) DEFAULT 'N' COMMENT '是否启用',
  PRIMARY KEY (`prize_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖品表';
INSERT INTO `prize` (`prize_id`,`prize_name`,`total_count`,`current_count`,`probability`,`active_yn`) VALUES (1,'竹叶青12月量茶包',2,2,0.01,'N');
INSERT INTO `prize` (`prize_id`,`prize_name`,`total_count`,`current_count`,`probability`,`active_yn`) VALUES (2,'车载空气净化器',10,10,0.01,'N');
INSERT INTO `prize` (`prize_id`,`prize_name`,`total_count`,`current_count`,`probability`,`active_yn`) VALUES (3,'3M环保口罩',2000,2000,0.01,'N');
INSERT INTO `prize` (`prize_id`,`prize_name`,`total_count`,`current_count`,`probability`,`active_yn`) VALUES (4,'竹叶青品饮小铁盒',3000,3000,0.01,'N');
INSERT INTO `prize` (`prize_id`,`prize_name`,`total_count`,`current_count`,`probability`,`active_yn`) VALUES (5,'绿色植物盆栽',5000,5000,0.01,'N');
INSERT INTO `prize` (`prize_id`,`prize_name`,`total_count`,`current_count`,`probability`,`active_yn`) VALUES (100,'谢谢参与奖',10000,10000,0.5,'N');
-- 奖赏表
DROP TABLE IF EXISTS `reward`;
CREATE TABLE `reward` (
  `reward_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '奖赏ID',
  `user_id` varchar(20) NOT NULL COMMENT '用户ID',
  `prize_id` int(3) DEFAULT 0 COMMENT '奖品ID',
  `reward_time` datetime DEFAULT NULL COMMENT '奖赏时间',
  PRIMARY KEY (`reward_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖赏表';
