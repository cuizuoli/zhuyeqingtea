/*
 * @(#)PrizeServiceTest.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.sinaapp.zhuyeqingtea.AbstractTest;
import com.sinaapp.zhuyeqingtea.model.Prize;

import lombok.extern.slf4j.Slf4j;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.service.PrizeServiceTest.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Slf4j
public class PrizeServiceTest extends AbstractTest {

	@Resource
	private PrizeService prizeService;

	@Test
	public void nextPrize() {
		for (int i = 0; i < 50; i++) {
			Prize prize = prizeService.nextPrize();
			log.debug(prize.getPrizeName());
		}
	}

}
