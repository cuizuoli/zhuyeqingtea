/*
 * @(#)CounterService.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.service;

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

	private final static String WEIBO_CONTENT_FORMAT = "我参与了@竹叶青茶 #绿茶生活 远离雾霾 拒绝烟花#活动，已为成都送出一个红包，还差%s个红包，茶弈基金第%s级奖池将被打开，快来和我一起给成都送一个红包，为清除成都雾霾尽一份力吧！";

	@Resource
	private JoinConfigRepository joinConfigRepository;

	@Resource
	private JoinHistRepository joinHistRepository;

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
		if (count > 0
			&& count <= PrizePool.FIRST.getMinJoinCount()) {
			hongBaoCount = PrizePool.FIRST.getMinJoinCount() - count;
			prizePoolLevel = 1;
		} else if (count > PrizePool.FIFTH.getMinJoinCount()
			&& count < PrizePool.SECOND.getMinJoinCount()) {
			hongBaoCount = PrizePool.SECOND.getMinJoinCount() - count;
			prizePoolLevel = 2;
		} else if (count > PrizePool.SECOND.getMinJoinCount()
			&& count < PrizePool.THIRD.getMinJoinCount()) {
			hongBaoCount = PrizePool.THIRD.getMinJoinCount() - count;
			prizePoolLevel = 3;
		} else if (count > PrizePool.THIRD.getMinJoinCount()
			&& count < PrizePool.FOURTH.getMinJoinCount()) {
			hongBaoCount = PrizePool.FOURTH.getMinJoinCount() - count;
			prizePoolLevel = 4;
		} else if (count > PrizePool.FOURTH.getMinJoinCount()
			&& count < PrizePool.FIFTH.getMinJoinCount()) {
			hongBaoCount = PrizePool.FIFTH.getMinJoinCount() - count;
			prizePoolLevel = 5;
		}
		String weiboContent = String.format(WEIBO_CONTENT_FORMAT, hongBaoCount, prizePoolLevel);
		WeiboCount weiboCount = new WeiboCount();
		weiboCount.setCount(count);
		weiboCount.setHongBaoCount(hongBaoCount);
		weiboCount.setPrizePoolLevel(prizePoolLevel);
		weiboCount.setWeiboContent(weiboContent);
		return weiboCount;
	}
}
