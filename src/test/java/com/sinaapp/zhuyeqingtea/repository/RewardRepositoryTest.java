/*
 * @(#)RewardRepositoryTest.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.repository;

import javax.annotation.Resource;

import org.junit.Test;

import com.sinaapp.zhuyeqingtea.AbstractTest;
import com.sinaapp.zhuyeqingtea.model.Reward;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.repository.RewardRepositoryTest.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
public class RewardRepositoryTest extends AbstractTest {

	@Resource
	private RewardRepository rewardRepository;

	@Test
	public void insert() {
		Reward reward = new Reward();
		reward.setUserId("test");
		reward.setPrizeId(1);
		rewardRepository.insert(reward);
	}

	@Test
	public void select() {
		rewardRepository.select("test");
	}

}
