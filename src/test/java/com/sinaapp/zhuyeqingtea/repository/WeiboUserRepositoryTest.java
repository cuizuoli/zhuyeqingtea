/*
 * @(#)WeiboUserRepositoryTest.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.repository;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.sinaapp.zhuyeqingtea.AbstractTest;
import com.sinaapp.zhuyeqingtea.model.WeiboUser;

import lombok.extern.slf4j.Slf4j;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.repository.WeiboUserRepositoryTest.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Slf4j
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
	public void selectPrizeChance() {
		weiboUserRepository.selectPrizeChance("test");
	}

	@Test
	public void plusPrizeChance() {
		weiboUserRepository.plusPrizeChance("test");
	}

	@Test
	public void minusPrizeChance() {
		weiboUserRepository.minusPrizeChance("test");
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
		List<WeiboUser> userList = weiboUserRepository.selectList();
		for (WeiboUser user : userList) {
			log.debug(user.toString());
		}
	}

}
