/*
 * @(#)RewardRepository.java $version 2013年12月31日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.repository;

import org.springframework.stereotype.Repository;

import com.sinaapp.zhuyeqingtea.model.Reward;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.repository.RewardRepository.java
 * @author piaozaiguang
 * @date 2013年12月31日
 */
@Repository
public interface RewardRepository {
	/**
	 * insert
	 * @param reward
	 */
	void insert(Reward reward);

	/**
	 * select
	 * @param userId
	 * @return
	 */
	Reward select(String userId);
}
