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
	FIRST(0),
	SECOND(10000),
	THIRD(30000),
	FOURTH(50000),
	FIFTH(80000),
	MAX(150000);
	private final int minJoinCount;

	private PrizePool(int minJoinCount) {
		this.minJoinCount = minJoinCount;
	}

	public int getMinJoinCount() {
		return minJoinCount;
	}
}
