/*
 * @(#)JoinConfigRepository.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.repository;

import org.springframework.stereotype.Repository;

import com.sinaapp.zhuyeqingtea.model.JoinConfig;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.repository.JoinConfigRepository.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Repository
public interface JoinConfigRepository {
	/**
	 * selectCount
	 * @return
	 */
	int selectCount();

	/**
	 * select
	 * @return
	 */
	JoinConfig select();

	/**
	 * update
	 * @param joinConfig
	 */
	void update(JoinConfig joinConfig);
}
