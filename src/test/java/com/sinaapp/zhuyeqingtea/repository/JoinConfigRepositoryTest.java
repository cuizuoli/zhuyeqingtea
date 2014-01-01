/*
 * @(#)JoinConfigRepositoryTest.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.repository;

import javax.annotation.Resource;

import org.junit.Test;

import com.sinaapp.zhuyeqingtea.AbstractTest;
import com.sinaapp.zhuyeqingtea.model.JoinConfig;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.repository.JoinConfigRepositoryTest.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
public class JoinConfigRepositoryTest extends AbstractTest {

	@Resource
	private JoinConfigRepository joinConfigRepository;

	@Test
	public void selectCount() {
		joinConfigRepository.selectCount();
	}

	@Test
	public void select() {
		joinConfigRepository.select();
	}

	@Test
	public void update() {
		JoinConfig joinConfig = new JoinConfig();
		joinConfig.setWeiboRepostCount(10);
		joinConfig.setWeixinShareCount(10);
		joinConfig.setQqSignatureCount(10);
		joinConfig.setOtherJoinCount(10);
		joinConfigRepository.update(joinConfig);
	}

}
