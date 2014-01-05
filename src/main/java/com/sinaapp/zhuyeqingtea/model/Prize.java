/*
 * @(#)Prize.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.model;

import lombok.Data;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.model.Prize.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Data
public class Prize {
	private int prizeId;
	private String prizeName;
	private int totalCount;
	private int currentCount;
	private int minJoinCount;
	private double probability;
	private String activeYn;
	private String reason;
}
