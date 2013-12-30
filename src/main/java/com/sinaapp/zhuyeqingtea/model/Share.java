/*
 * @(#)Share.java $version 2013年12月31日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.model;

import java.util.Date;

import lombok.Data;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.model.Share.java
 * @author cuizuoli
 * @date 2013年12月31日
 */
@Data
public class Share {
	private String weiboId;
	private String userId;
	private String content;
	private String shareType;
	private int repostCount;
	private Date createTime;
	private Date modifyTime;
}
