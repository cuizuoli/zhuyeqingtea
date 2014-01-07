/*
 * @(#)JoinHistRepository.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.repository.JoinHistRepository.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Repository
public interface JoinHistRepository {
	/**
	 * insert
	 * @param userId
	 */
	void insert(@Param("userId") String userId);

	/**
	 * selectCount
	 * @return
	 */
	int selectCount();

	/**
	 * selectTodayCount
	 * @param userId
	 * @return
	 */
	String selectTodayCount(@Param("userId") String userId);
}
