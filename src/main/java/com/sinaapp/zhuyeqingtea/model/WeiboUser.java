/*
 * @(#)WeiboUser.java $version 2013年12月31日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.model;

import java.util.Date;

import lombok.Data;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.model.WeiboUser.java
 * @author cuizuoli
 * @date 2013年12月31日
 */
@Data
public class WeiboUser {
	private String userId;
	private String userName;
	private String userScreenName;
	private String profileImageUrl;
	private String gender;
	private String province;
	private String city;
	private String location;
	private Date createTime;
	private Date modifyTime;
}
