/*
 * @(#)GameService.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinaapp.zhuyeqingtea.repository.JoinHistRepository;
import com.weibo.api.Statuses;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.service.GameService.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Service
public class GameService {

	private final static int MAX_DAILY_COUNT = 5;

	@Resource
	private JoinHistRepository joinHistRepository;

	@Resource
	private Statuses statuses;

	/**
	 * joinGame
	 * 记录参与活动的用户（每天最多可抽奖5次）
	 * @param userId
	 */
	public boolean joinGame(String userId) {
		int i = joinHistRepository.selectTodayCount(userId);
		if (i < MAX_DAILY_COUNT) {
			joinHistRepository.insert(userId);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 分享到新浪微博
	 * @param text
	 * @param accessToken
	 */
	public void shareWeibo(String text, String accessToken) {
		statuses.update(text, accessToken);
	}

}
