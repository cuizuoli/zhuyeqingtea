/*
 * @(#)WeiboServiceTest.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.sinaapp.zhuyeqingtea.AbstractTest;
import com.weibo.model.User;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.service.WeiboServiceTest.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
public class WeiboServiceTest extends AbstractTest {

	@Resource
	private WeiboService weiboService;

	@Test
	public void addUser() {
		User user = new User();
		user.setId("test");
		user.setName("test");
		user.setScreenName("test");
		user.setProfileImageUrl("test");
		user.setGender("f");
		user.setProvince(11);
		user.setCity(11);
		user.setLocation("test");
		weiboService.addUser(user);
	}

}
