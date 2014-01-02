/*
 * @(#)WeiboCount.java $version 2014年1月2日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.model;

import lombok.Data;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.model.WeiboCount.java
 * @author cuizuoli
 * @date 2014年1月2日
 */
@Data
public class WeiboCount {
	private int count;
	private int hongBaoCount;
	private int prizePoolLevel;
	private String weiboContent;
}
