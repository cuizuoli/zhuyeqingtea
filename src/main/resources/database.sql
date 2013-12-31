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
  `join_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '参与ID',
  `user_id` varchar(20) NOT NULL COMMENT '用户ID',
  `join_time` datetime DEFAULT NULL COMMENT '参与时间',
  PRIMARY KEY (`join_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参与表';
-- 商品表
DROP TABLE IF EXISTS `item_info`;
CREATE TABLE `item_info` (
  `item_id` int(3) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `item_level` int(1) NOT NULL COMMENT '0:特等, 1:1等奖, 2:2等奖, 3:3等奖, 4:爱心贡献奖',
  `item_name` varchar(20) DEFAULT NULL COMMENT '商品名称',
  `reward_rate` int(1) DEFAULT 0 COMMENT '中奖几率',
  `active_yn` boolean DEFAULT false COMMENT '是否启用',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';
-- 奖赏表
DROP TABLE IF EXISTS `reward_hist`;
CREATE TABLE `reward_hist` (
  `reward_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '奖赏ID',
  `user_id` varchar(20) NOT NULL COMMENT '用户ID',
  `item_id` int(3) DEFAULT NULL COMMENT '商品ID',
  `reward_time` datetime DEFAULT NULL COMMENT '奖赏时间',
  PRIMARY KEY (`reward_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖赏表';