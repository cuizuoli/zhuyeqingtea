/*
 * @(#)WeiboUserRepositoryTest.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.repository;

import javax.annotation.Resource;

import org.junit.Test;

import com.sinaapp.zhuyeqingtea.AbstractTest;
import com.sinaapp.zhuyeqingtea.model.WeiboUser;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.repository.WeiboUserRepositoryTest.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
public class WeiboUserRepositoryTest extends AbstractTest {

	@Resource
	private WeiboUserRepository weiboUserRepository;

	@Test
	public void update() {
		WeiboUser weiboUser = new WeiboUser();
		weiboUser.setUserId("test");
		weiboUser.setUserName("test");
		weiboUser.setUserScreenName("test");
		weiboUser.setProfileImageUrl("test");
		weiboUser.setGender("m");
		weiboUser.setProvince("001");
		weiboUser.setCity("002");
		weiboUser.setLocation("test");
		weiboUserRepository.update(weiboUser);
	}

	@Test
	public void insert() {
		WeiboUser weiboUser = new WeiboUser();
		weiboUser.setUserId("test");
		weiboUser.setUserName("test");
		weiboUser.setUserScreenName("test");
		weiboUser.setProfileImageUrl("test");
		weiboUser.setGender("m");
		weiboUser.setProvince("001");
		weiboUser.setCity("002");
		weiboUser.setLocation("test");
		weiboUserRepository.insert(weiboUser);
	}

	@Test
	public void select() {
		weiboUserRepository.select("test");
	}

	@Test
	public void selectList() {
		weiboUserRepository.selectList();
	}

}
