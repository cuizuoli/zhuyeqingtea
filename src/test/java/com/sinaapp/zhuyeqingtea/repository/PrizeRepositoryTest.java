/*
 * @(#)PrizeRepositoryTest.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.repository;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.sinaapp.zhuyeqingtea.AbstractTest;
import com.sinaapp.zhuyeqingtea.model.Prize;

import lombok.extern.slf4j.Slf4j;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.repository.PrizeRepositoryTest.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Slf4j
public class PrizeRepositoryTest extends AbstractTest {

	@Resource
	private PrizeRepository prizeRepository;

	@Test
	public void select() {
		Prize prize = prizeRepository.select(1);
		log.debug(prize.toString());
	}

	@Test
	public void selectList() {
		List<Prize> prizeList = prizeRepository.selectList(0);
		log.debug(prizeList.get(0).toString());
	}

	@Test
	public void insert() {
		Prize prize = new Prize();
		prize.setPrizeName("test");
		prize.setTotalCount(10);
		prize.setCurrentCount(10);
		prize.setMinJoinCount(100);
		prize.setProbability(Double.valueOf("0.33"));
		prize.setActiveYn("N");
		prizeRepository.insert(prize);
	}

	@Test
	public void update() {
		Prize prize = new Prize();
		prize.setPrizeId(1);
		prize.setPrizeName("test");
		prize.setTotalCount(10);
		prize.setCurrentCount(10);
		prize.setMinJoinCount(100);
		prize.setProbability(Double.valueOf("0.33"));
		prize.setActiveYn("N");
		prizeRepository.update(prize);
	}

}
