/*
 * @(#)Reward.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.model;

import java.util.Date;

import lombok.Data;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.model.Reward.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Data
public class Reward {
	private int rewardId;
	private String userId;
	private String userName;
	private int prizeChance;
	private int prizeId;
	private String prizeName;
	private int prizeCount;
	private Date rewardTime;
}
