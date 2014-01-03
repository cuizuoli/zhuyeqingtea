/*
 * @(#)PrizeService.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinaapp.zhuyeqingtea.model.Prize;
import com.sinaapp.zhuyeqingtea.model.Reward;
import com.sinaapp.zhuyeqingtea.repository.JoinConfigRepository;
import com.sinaapp.zhuyeqingtea.repository.JoinHistRepository;
import com.sinaapp.zhuyeqingtea.repository.PrizeRepository;
import com.sinaapp.zhuyeqingtea.repository.RewardRepository;
import com.sinaapp.zhuyeqingtea.repository.WeiboUserRepository;
import com.sinaapp.zhuyeqingtea.utils.AliasMethod;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.service.PrizeService.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Service
public class PrizeService {

	@Resource
	private PrizeRepository prizeRepository;

	@Resource
	private RewardRepository rewardRepository;

	@Resource
	private JoinConfigRepository joinConfigRepository;

	@Resource
	private JoinHistRepository joinHistRepository;

	@Resource
	private WeiboUserRepository weiboUserRepository;

	@Resource
	private CounterService counterService;

	/**
	 * getRewardCount
	 * @param userId
	 * @return
	 */
	public Reward getRewardCount(String userId) {
		return rewardRepository.select(userId);
	}

	/**
	 * 查询抽奖机会
	 * @param userId
	 * @return
	 */
	public int getPrizeChance(String userId) {
		return weiboUserRepository.selectPrizeChance(userId);
	}

	/**
	 * 减少抽奖机会
	 * @param userId
	 */
	public void minusPrizeChance(String userId) {
		weiboUserRepository.minusPrizeChance(userId);
	}

	/**
	 * 根据机率随机抽奖
	 * @return
	 */
	public synchronized Prize nextPrize() {
		int count = counterService.getCount();
		List<Prize> prizeList = prizeRepository.selectList(count);
		List<Double> probabilities = new ArrayList<Double>();
		for (Prize prize : prizeList) {
			probabilities.add(prize.getProbability());
		}
		AliasMethod aliasMethod = new AliasMethod(probabilities);
		int i = aliasMethod.next();
		return prizeList.get(i);
	}

	/**
	 * getPrizeList
	 * @return
	 */
	public List<Prize> getPrizeList() {
		return prizeRepository.selectAllList();
	}

}
