/*
 * @(#)GameService.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.service;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
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
	}

	/**
	 * 分享到新浪微博
	 * @param text
	 * @param accessToken
	 */
	public String shareWeibo(String userId, String text, int weiboId, String accessToken) {
		String joinCount = joinHistRepository.selectTodayCount(userId);
		if (StringUtils.isNotEmpty(joinCount) && Integer.valueOf(joinCount) < 5) {
			weiboUserRepository.plusPrizeChance(userId);
			statuses.upload(text, getWeiboPicName(weiboId), accessToken);
			return "";
		} else {
			return "NOT_HAVE_SHARE_CHANCE";
		}
	}

	/**
	 * 取得微博图片
	 * @param weiboId
	 * @return
	 */
	private String getWeiboPicName(int weiboId) {
		String[] weiboPics = new String[]{
			"wb_01.jpg",
			"wb_02.jpg",
			"wb_03.jpg",
			"wb_04.jpg",
			"wb_05.jpg"
		};
		return weiboPics[weiboId];
	}

}
