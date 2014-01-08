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
import org.springframework.transaction.annotation.Transactional;

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
	
	private static final int NOT_WIN_PRIZE_ID = 100;
	
	private static final int LIMIT_PRIZE_OF_DAY = 1;
	
	private static final int LIMIT_PRIZE_OF_EVENT = 2;

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
	@Transactional
	public void minusPrizeChance(String userId) {
		weiboUserRepository.minusPrizeChance(userId);
	}

	/**
	 * 根据机率随机抽奖
	 * @return
	 */
	@Transactional
	public synchronized Prize nextPrize(String userId) {
		
		// 每人每天仅可获得一个奖，如果已经达到限制，返回没中奖
		if (getRewardItemCountToday(userId) >= LIMIT_PRIZE_OF_DAY) {
			return saveNotWinReward(userId);
		}
		
		// 活动时间内累积最多获得两份奖品， 如果已经达到限制，返回没中奖
		if (getRewardItemCount(userId) >= LIMIT_PRIZE_OF_EVENT) {
			return saveNotWinReward(userId);
		}
		
		int count = counterService.getCount();
		List<Prize> prizeList = prizeRepository.selectList(count);
		List<Double> probabilities = new ArrayList<Double>();
		for (Prize prize : prizeList) {
			probabilities.add(prize.getProbability());
		}
		AliasMethod aliasMethod = new AliasMethod(probabilities);
		int i = aliasMethod.next();
		Prize prize = prizeList.get(i);
		// 插入获奖数据
		Reward reward = new Reward();
		reward.setUserId(userId);
		reward.setPrizeId(prize.getPrizeId());
		rewardRepository.insert(reward);
		prizeRepository.minusPrizeCount(prize.getPrizeId());
		// 减少抽奖机会
		weiboUserRepository.minusPrizeChance(userId);
		return prize;
	}

	/**
	 * 取得指定用户的奖品列表
	 * @param userId
	 * @return
	 */
	public List<Reward> getPrizeList(String userId) {
		return rewardRepository.selectPrizeList(userId);
	}

	/**
	 * getPrizeList
	 * @return
	 */
	public List<Prize> getPrizeList() {
		return prizeRepository.selectAllList();
	}
	
	/**
	 * 查询用户今天得到的奖品数量
	 * @param userId
	 * @return
	 */
	private int getRewardItemCountToday(String userId) {
		return rewardRepository.selectRewardItemCountToday(userId);
	}
	
	/**
	 * 查询用户得到的奖品总数量
	 * @param userId
	 * @return
	 */
	private int getRewardItemCount(String userId) {
		return rewardRepository.selectRewardItemCount(userId);
	}
	
	/**
	 * 获取奖品信息
	 * @param prizeId
	 * @return
	 */
	private Prize getPrize(int prizeId) {
		return prizeRepository.select(prizeId);
	}
	
	/**
	 * 保存没中奖信息
	 * @param userId
	 * @return
	 */
	private Prize saveNotWinReward(String userId) {
		Prize prize = getPrize(NOT_WIN_PRIZE_ID);
		Reward reward = new Reward();
		reward.setUserId(userId);
		reward.setPrizeId(prize.getPrizeId());
		rewardRepository.insert(reward);
		prizeRepository.minusPrizeCount(prize.getPrizeId());
		// 减少抽奖机会
		weiboUserRepository.minusPrizeChance(userId);
		return prize;
	}

}
