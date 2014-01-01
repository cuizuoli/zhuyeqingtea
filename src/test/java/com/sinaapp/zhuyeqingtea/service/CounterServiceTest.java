/*
 * @(#)CounterServiceTest.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.sinaapp.zhuyeqingtea.AbstractTest;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.service.CounterServiceTest.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
public class CounterServiceTest extends AbstractTest {

	@Resource
	private CounterService counterService;

	@Test
	public void getCount() {
		counterService.getCount();
	}

}
