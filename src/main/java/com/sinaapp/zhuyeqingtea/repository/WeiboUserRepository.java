/*
 * @(#)WeiboUserRepository.java $version 2013年12月31日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sinaapp.zhuyeqingtea.model.WeiboUser;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.repository.WeiboUserRepository.java
 * @author cuizuoli
 * @date 2013年12月31日
 */
@Repository
public interface WeiboUserRepository {
	/**
	 * update
	 * @param weiboUser
	 * @return
	 */
	int update(WeiboUser weiboUser);

	/**
	 * 查询用户抽奖机会
	 * @param userId
	 * @return
	 */
	int selectPrizeChance(@Param("userId") String userId);

	/**
	 * 增加用户抽奖机会
	 * @param userId
	 * @return
	 */
	int plusPrizeChance(@Param("userId") String userId);

	/**
	 * 减少用户抽奖机会
	 * @param userId
	 * @return
	 */
	int minusPrizeChance(@Param("userId") String userId);

	/**
	 * insert
	 * @param weiboUser
	 */
	void insert(WeiboUser weiboUser);

	/**
	 * select
	 * @param userId
	 * @return
	 */
	WeiboUser select(@Param("userId") String userId);

	/**
	 * selectList
	 * @return
	 */
	List<WeiboUser> selectList();
}
