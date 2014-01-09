/*
 * @(#)CounterService.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinaapp.zhuyeqingtea.enums.PrizePool;
import com.sinaapp.zhuyeqingtea.model.WeiboCount;
import com.sinaapp.zhuyeqingtea.repository.JoinConfigRepository;
import com.sinaapp.zhuyeqingtea.repository.JoinHistRepository;
import com.sinaapp.zhuyeqingtea.utils.AliasMethod;

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
	 * 随机取得微博内容
	 * @return
	 */
	private String nextWeiboCount() {
		String[] weiboContents = new String[]{
			"#绿茶生活 远离雾霾 拒绝烟花#为成都送红包啦！动动鼠标，马上减少4立方米雾霾，还有机会获得“干净”好礼一份！雾霾影响我们每个人，赶快来参加吧！猛戳这里：http://t.cn/8F7uLLS",
			"#绿茶生活 远离雾霾 拒绝烟花#动动鼠标就是一次公益之举，动动鼠标就能清除4立方米雾霾。你还等什么？和我一起为成都送“干净”红包，抢“干净”好礼！http://t.cn/8F7uLLS",
			"#绿茶生活 远离雾霾 拒绝烟花#动动鼠标，我已经为成都清除了4立方米雾霾！小伙伴们 ，来和我一起清除雾霾，刷新成都空气吧！点击马上参加：http://t.cn/8F7uLLS",
			"#绿茶生活 远离雾霾 拒绝烟花#我刚刚为成都清除了4立方米的雾霾，就等你加入进来。成都人，和我一起清除雾霾，共同呼吸“成都好空气”！动鼠标，除雾霾，点右立刻加入：http://t.cn/8F7uLLS",
			"#绿茶生活 远离雾霾 拒绝烟花#我刚刚“亲手”为成都清除了4立方米的雾霾，你也来试试吧！很神奇，动动鼠标就可以。点这里：http://t.cn/8F7uLLS"
		};
		List<Double> probabilities = new ArrayList<Double>();
		probabilities.add(Double.valueOf("0.2"));
		probabilities.add(Double.valueOf("0.2"));
		probabilities.add(Double.valueOf("0.2"));
		probabilities.add(Double.valueOf("0.2"));
		probabilities.add(Double.valueOf("0.2"));
		AliasMethod aliasMethod = new AliasMethod(probabilities);
		int i = aliasMethod.next();
		return weiboContents[i];
	}

	/**
	 * getWeiboCount
	 * @return
	 */
	public WeiboCount getWeiboCount() {
		int count = getCount();
		int hongBaoCount = 0;
		int nextHongBaoCount = 0;
		int prizePoolLevel = 0;
		double percent = 0;
		if (count >= 0
			&& count <= PrizePool.FIRST.getMinJoinCount()) {
			hongBaoCount = PrizePool.FIRST.getMinJoinCount() - count;
			nextHongBaoCount = PrizePool.SECOND.getMinJoinCount() - count;
			prizePoolLevel = 1;
			percent = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(PrizePool.FIRST.getMinJoinCount()), 2, RoundingMode.DOWN).doubleValue();
		} else if (count > PrizePool.FIRST.getMinJoinCount()
			&& count < PrizePool.SECOND.getMinJoinCount()) {
			hongBaoCount = PrizePool.SECOND.getMinJoinCount() - count;
			nextHongBaoCount = PrizePool.THIRD.getMinJoinCount() - count;
			prizePoolLevel = 2;
			percent = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(PrizePool.SECOND.getMinJoinCount()), 2, RoundingMode.DOWN).doubleValue();
		} else if (count > PrizePool.SECOND.getMinJoinCount()
			&& count < PrizePool.THIRD.getMinJoinCount()) {
			hongBaoCount = PrizePool.THIRD.getMinJoinCount() - count;
			nextHongBaoCount = PrizePool.FOURTH.getMinJoinCount() - count;
			prizePoolLevel = 3;
			percent = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(PrizePool.THIRD.getMinJoinCount()), 2, RoundingMode.DOWN).doubleValue();
		} else if (count > PrizePool.THIRD.getMinJoinCount()
			&& count < PrizePool.FOURTH.getMinJoinCount()) {
			hongBaoCount = PrizePool.FOURTH.getMinJoinCount() - count;
			nextHongBaoCount = PrizePool.FIFTH.getMinJoinCount() - count;
			prizePoolLevel = 4;
			percent = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(PrizePool.FOURTH.getMinJoinCount()), 2, RoundingMode.DOWN).doubleValue();
		} else if (count > PrizePool.FOURTH.getMinJoinCount()
			&& count < PrizePool.FIFTH.getMinJoinCount()) {
			hongBaoCount = PrizePool.FIFTH.getMinJoinCount() - count;
			prizePoolLevel = 5;
			percent = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(PrizePool.FIFTH.getMinJoinCount()), 2, RoundingMode.DOWN).doubleValue();
		} else {
			hongBaoCount = 0;
			prizePoolLevel = 5;
			percent = 0;
		}
		WeiboCount weiboCount = new WeiboCount();
		weiboCount.setCount(count);
		weiboCount.setHongBaoCount(hongBaoCount);
		weiboCount.setNextHongBaoCount(nextHongBaoCount);
		weiboCount.setPrizePoolLevel(prizePoolLevel);
		weiboCount.setPercent(percent);
		weiboCount.setWeiboContent(nextWeiboCount());
		return weiboCount;
	}
}
