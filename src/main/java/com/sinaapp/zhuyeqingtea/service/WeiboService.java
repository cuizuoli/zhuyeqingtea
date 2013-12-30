/*
 * @(#)WeiboService.java $version 2013年12月31日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinaapp.zhuyeqingtea.repository.ShareRepository;
import com.sinaapp.zhuyeqingtea.repository.UserRepository;
import com.weibo.model.User;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.service.WeiboService.java
 * @author cuizuoli
 * @date 2013年12月31日
 */
@Service
public class WeiboService {

	@Resource
	private UserRepository userRepository;

	@Resource
	private ShareRepository shareRepository;

	/**
	 * addUser
	 * @param user
	 */
	public void addUser(User user) {
		// TODO update and insert user table.<br/>
	}

}
