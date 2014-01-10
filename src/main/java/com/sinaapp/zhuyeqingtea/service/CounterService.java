/*
 * @(#)CounterService.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinaapp.zhuyeqingtea.enums.PrizePool;
import com.sinaapp.zhuyeqingtea.model.WeiboCount;
import com.sinaapp.zhuyeqingtea.repository.JoinConfigRepository;
import com.sinaapp.zhuyeqingtea.repository.JoinHistRepository;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.service.CounterService.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Service
public class CounterService {

	@Resource
	private JoinConfigRepository joinConfigRepository;

	@Resource
	private JoinHistRepository joinHistRepository;

	@Resource
	private WeiboService weiboService;

	/**
	 * getCount - 取得记数器数量
	 * @return
	 */
	public int getCount() {
		int configCount = joinConfigRepository.selectCount();
		int count = joinHistRepository.selectCount();
		return configCount + count;
	}

	/**
	 * getWeiboCount
	 * @return
	 */
	public WeiboCount getWeiboCount() {
		int count = getCount();
		int hongBaoCount = 0;
		int prizePoolLevel = 0;
		double percent = 0;
		if (count >= PrizePool.FIRST.getMinJoinCount()
			&& count <= PrizePool.SECOND.getMinJoinCount()) {
			hongBaoCount = PrizePool.SECOND.getMinJoinCount() - count;
			prizePoolLevel = 1;
			percent = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(PrizePool.SECOND.getMinJoinCount()), 2, RoundingMode.DOWN).doubleValue();
		} else if (count > PrizePool.SECOND.getMinJoinCount()
			&& count < PrizePool.THIRD.getMinJoinCount()) {
			hongBaoCount = PrizePool.THIRD.getMinJoinCount() - count;
			prizePoolLevel = 2;
			percent = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(PrizePool.THIRD.getMinJoinCount()), 2, RoundingMode.DOWN).doubleValue();
		} else if (count > PrizePool.THIRD.getMinJoinCount()
			&& count < PrizePool.FOURTH.getMinJoinCount()) {
			hongBaoCount = PrizePool.FOURTH.getMinJoinCount() - count;
			prizePoolLevel = 3;
			percent = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(PrizePool.FOURTH.getMinJoinCount()), 2, RoundingMode.DOWN).doubleValue();
		} else if (count > PrizePool.FOURTH.getMinJoinCount()
			&& count < PrizePool.FIFTH.getMinJoinCount()) {
			hongBaoCount = PrizePool.FIFTH.getMinJoinCount() - count;
			prizePoolLevel = 4;
			percent = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(PrizePool.FIFTH.getMinJoinCount()), 2, RoundingMode.DOWN).doubleValue();
		} else if (count > PrizePool.FIFTH.getMinJoinCount()
			&& count < PrizePool.MAX.getMinJoinCount()) {
			hongBaoCount = 0;
			prizePoolLevel = 5;
			percent = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(PrizePool.MAX.getMinJoinCount()), 2, RoundingMode.DOWN).doubleValue();
		} else {
			hongBaoCount = 0;
			prizePoolLevel = 5;
			percent = 1;
		}
		int i = weiboService.nextWeiboId();
		WeiboCount weiboCount = new WeiboCount();
		weiboCount.setCount(count);
		weiboCount.setHongBaoCount(hongBaoCount);
		weiboCount.setPrizePoolLevel(prizePoolLevel);
		weiboCount.setPercent(percent);
		weiboCount.setWeiboId(i);
		weiboCount.setWeiboContent(weiboService.getWeiboContent(i));
		return weiboCount;
	}

}
