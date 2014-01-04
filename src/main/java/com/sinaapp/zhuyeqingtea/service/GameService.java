/*
 * @(#)GameService.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinaapp.zhuyeqingtea.repository.JoinHistRepository;
import com.sinaapp.zhuyeqingtea.repository.WeiboUserRepository;
import com.weibo.api.Statuses;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.service.GameService.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Service
public class GameService {

	@Resource
	private JoinHistRepository joinHistRepository;

	@Resource
	private WeiboUserRepository weiboUserRepository;

	@Resource
	private Statuses statuses;

	/**
	 * joinGame
	 * 记录参与活动的用户
	 * @param userId
	 */
	@Transactional
	public void joinGame(String userId) {
		joinHistRepository.insert(userId);
		weiboUserRepository.plusPrizeChance(userId);
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
