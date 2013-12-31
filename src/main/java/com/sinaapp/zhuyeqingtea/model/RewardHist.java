/*
 * @(#)RewardHist.java $version 2013年12月31日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sinaapp.zhuyeqingtea.model;

import java.util.Date;

import lombok.Data;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.model.RewardHist.java
 * @author piaozaiguang
 * @date 2013年12月31日
 */
@Data
public class RewardHist {
	private int rewardId;
	private String userId;
	private int itemId;
	private Date rewardTime;
}
