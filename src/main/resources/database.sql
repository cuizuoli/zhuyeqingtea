-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
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
-- 分享表
DROP TABLE IF EXISTS `share`;
CREATE TABLE `share` (
  `weibo_id` varchar(20) NOT NULL COMMENT '微博ID',
  `user_id` varchar(20) NOT NULL COMMENT '用户ID',
  `content` text NOT NULL COMMENT '微博内容',
  `share_type` char(1) NOT NULL COMMENT '分享类别',
  `repost_count` int(11) DEFAULT NULL COMMENT '转发数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`weibo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分享表';
-- 微信分享表
DROP TABLE IF EXISTS `weixin_share`;
CREATE TABLE `weixin_share` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` varchar(20) NOT NULL COMMENT '用户ID',
  `click_yn` char(1) DEFAULT 'N' COMMENT '是否点击微信分享',
  `click_time` datetime DEFAULT NULL COMMENT '点击时间',
  `share_yn` char(1) DEFAULT 'N' COMMENT '是否访问微信分享',
  `share_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信分享表';
