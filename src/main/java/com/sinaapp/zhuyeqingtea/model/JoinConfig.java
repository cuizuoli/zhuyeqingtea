/*
 * @(#)JoinConfig.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.model;

import lombok.Data;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.model.JoinConfig.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Data
public class JoinConfig {
	private int weiboRepostCount;
	private int weixinShareCount;
	private int qqSignatureCount;
	private int otherJoinCount;
}
