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

	/**
	 * joinGame
	 * 记录参与活动的用户
	 * @param userId
	 */
	public void joinGame(String userId) {
		joinHistRepository.insert(userId);
	}

}
