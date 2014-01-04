/*
 * @(#)PrizePool.java $version 2014年1月2日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.enums;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.enums.PrizePool.java
 * @author cuizuoli
 * @date 2014年1月2日
 */
public enum PrizePool {
	FIRST(10000),
	SECOND(30000),
	THIRD(50000),
	FOURTH(100000),
	FIFTH(150000);
	private final int minJoinCount;

	private PrizePool(int minJoinCount) {
		this.minJoinCount = minJoinCount;
	}

	public int getMinJoinCount() {
		return minJoinCount;
	}
}
