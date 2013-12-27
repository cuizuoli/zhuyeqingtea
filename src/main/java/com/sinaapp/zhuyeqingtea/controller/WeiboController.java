/*
 * @(#)WeiboController.java $version 2013年12月26日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.weibo.api.OAuth2;
import com.weibo.model.ProfessionalTokenInfo;

/**
 * nhn zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.controller.WeiboController.java
 * @author st13902
 * @date 2013年12月26日
 */
@Controller
@RequestMapping("/weibo")
public class WeiboController {

	@Value("#{weiboProperties['weibo.appKey']}")
	private String appKey;

	@Value("#{weiboProperties['weibo.appSecret']}")
	private String appSecret;

	@Value("#{weiboProperties['weibo.redirectUri']}")
	private String redirectUri;

	@Resource
	private OAuth2 oAuth2;

	@RequestMapping("access_token")
	public ModelAndView accessToken(HttpServletRequest request, @RequestParam String cid, @RequestParam String viewer,
			@RequestParam String subAppkey, @RequestParam String tokenString) {
		ProfessionalTokenInfo tokenInfo = oAuth2.parseSignedRequest(tokenString, appSecret);
		return new ModelAndView("redirect:/main?access_token=" + tokenInfo.getOauthToken() + "&user_id="
			+ tokenInfo.getUserId());
	}

}
