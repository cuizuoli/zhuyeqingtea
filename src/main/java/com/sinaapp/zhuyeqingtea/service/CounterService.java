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
			"#绿茶生活 远离雾霾 拒绝烟花#众人拾材火焰高，简单的贡献也能汇聚成强大的力量。送成都一个红包，低碳生活，从拒放烟花开始！http://t.cn/8kDDATh",
			"#绿茶生活 远离雾霾 拒绝烟花#漫天雾霾让人无处可逃，爆表的PM2.5侵害你我的健康，保护环境，从新年拒放烟花开始，赶快来加入我们吧，为成都环保送出一个红包！http://t.cn/8kDDATh",
			"#绿茶生活 远离雾霾 拒绝烟花#不要让晨练成为历史教材，让防毒面罩变成了户外必须。我们可以不放烟花，但不能不呼吸空气。送成都一个红包，环保从新年做起！http://t.cn/8kDDATh",
			"#绿茶生活 远离雾霾 拒绝烟花#烟花虽美，却只是昙花一现；红包虽小，代表的是公益之心。送成都一个红包，环保从我做起！http://t.cn/8kDDATh",
			"#绿茶生活 远离雾霾 拒绝烟花#红包诚可贵，空气价更高，不要爆表的pm2.5，我要蓝天白云！送成都一个红包，过一个低碳环保年！http://t.cn/8kDDATh"
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
		int prizePoolLevel = 0;
		double percent = 0;
		if (count > 0
			&& count <= PrizePool.FIRST.getMinJoinCount()) {
			hongBaoCount = PrizePool.FIRST.getMinJoinCount() - count;
			prizePoolLevel = 1;
			percent = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(PrizePool.FIRST.getMinJoinCount()), 2, RoundingMode.DOWN).doubleValue();
		} else if (count > PrizePool.FIFTH.getMinJoinCount()
			&& count < PrizePool.SECOND.getMinJoinCount()) {
			hongBaoCount = PrizePool.SECOND.getMinJoinCount() - count;
			prizePoolLevel = 2;
			percent = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(PrizePool.SECOND.getMinJoinCount()), 2, RoundingMode.DOWN).doubleValue();
		} else if (count > PrizePool.SECOND.getMinJoinCount()
			&& count < PrizePool.THIRD.getMinJoinCount()) {
			hongBaoCount = PrizePool.THIRD.getMinJoinCount() - count;
			prizePoolLevel = 3;
			percent = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(PrizePool.THIRD.getMinJoinCount()), 2, RoundingMode.DOWN).doubleValue();
		} else if (count > PrizePool.THIRD.getMinJoinCount()
			&& count < PrizePool.FOURTH.getMinJoinCount()) {
			hongBaoCount = PrizePool.FOURTH.getMinJoinCount() - count;
			prizePoolLevel = 4;
			percent = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(PrizePool.FOURTH.getMinJoinCount()), 2, RoundingMode.DOWN).doubleValue();
		} else if (count > PrizePool.FOURTH.getMinJoinCount()
			&& count < PrizePool.FIFTH.getMinJoinCount()) {
			hongBaoCount = PrizePool.FIFTH.getMinJoinCount() - count;
			prizePoolLevel = 5;
			percent = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(PrizePool.FIFTH.getMinJoinCount()), 2, RoundingMode.DOWN).doubleValue();
		}
		WeiboCount weiboCount = new WeiboCount();
		weiboCount.setCount(count);
		weiboCount.setHongBaoCount(hongBaoCount);
		weiboCount.setPrizePoolLevel(prizePoolLevel);
		weiboCount.setPercent(percent);
		weiboCount.setWeiboContent(nextWeiboCount());
		return weiboCount;
	}
}
