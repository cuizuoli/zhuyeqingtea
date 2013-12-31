/*
 * @(#)WeiboService.java $version 2013年12月31日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinaapp.zhuyeqingtea.model.WeiboUser;
import com.sinaapp.zhuyeqingtea.repository.WeiboUserRepository;
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
	private WeiboUserRepository weiboUserRepository;

	/**
	 * addUser
	 * @param user
	 */
	public void addUser(User user) {
		WeiboUser weiboUser = new WeiboUser();
		weiboUser.setUserId(user.getId());
		weiboUser.setUserName(user.getName());
		weiboUser.setUserScreenName(user.getScreenName());
		weiboUser.setProfileImageUrl(user.getProfileImageUrl());
		weiboUser.setGender(user.getGender());
		weiboUser.setProvince(String.valueOf(user.getProvince()));
		weiboUser.setCity(String.valueOf(user.getCity()));
		weiboUser.setLocation(user.getLocation());
		int i = weiboUserRepository.update(weiboUser);
		if (i == 0) {
			weiboUserRepository.insert(weiboUser);
		}
	}

}
