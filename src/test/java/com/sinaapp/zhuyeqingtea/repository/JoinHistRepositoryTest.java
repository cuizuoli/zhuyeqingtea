/*
 * @(#)JoinHistRepositoryTest.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.repository;

import javax.annotation.Resource;

import org.junit.Test;

import com.sinaapp.zhuyeqingtea.AbstractTest;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.repository.JoinHistRepositoryTest.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
public class JoinHistRepositoryTest extends AbstractTest {

	@Resource
	private JoinHistRepository joinHistRepository;

	@Test
	public void insert() {
		joinHistRepository.insert("test");
	}

	@Test
	public void selectCount() {
		joinHistRepository.selectCount();
	}

}
