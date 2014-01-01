/*
 * @(#)PrizeRepository.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sinaapp.zhuyeqingtea.model.Prize;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.repository.PrizeRepository.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Repository
public interface PrizeRepository {
	/**
	 * select
	 * @param prizeId
	 * @return
	 */
	Prize select(int prizeId);

	/**
	 * selectAllList
	 * @return
	 */
	List<Prize> selectAllList();

	/**
	 * minJoinCount
	 * @param minJoinCount
	 * @return
	 */
	List<Prize> selectList(int minJoinCount);

	/**
	 * insert
	 * @param prize
	 */
	void insert(Prize prize);

	/**
	 * update
	 * @param prize
	 */
	void update(Prize prize);
}
