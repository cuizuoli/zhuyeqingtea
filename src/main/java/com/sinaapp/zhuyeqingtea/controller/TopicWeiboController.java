/*
 * @(#)TopicWeiboController.java $version 2013年12月28日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.weibo.api.OAuth2;
import com.weibo.enums.Display;
import com.weibo.enums.Scope;
import com.weibo.model.AccessToken;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.controller.TopicWeiboController.java
 * @author cuizuoli
 * @date 2013年12月28日
 */
@Controller
@RequestMapping("/t/weibo")
public class TopicWeiboController {

	private static final String DEFAULT_STATE = "zhuyeqingtea app";

	@Value("#{weiboProperties['weibo.appKey']}")
	private String appKey;

	@Value("#{weiboProperties['weibo.appSecret']}")
	private String appSecret;

	@Value("#{weiboProperties['weibo.redirectUri']}")
	private String redirectUri;

	@Resource
	private OAuth2 oAuth2;

	@RequestMapping("authorize")
	public ModelAndView authorize() {
		String authorizeUrl = oAuth2.authorize(Scope.ALL.getCode(), DEFAULT_STATE, Display.DEFAULT);
		return new ModelAndView("redirect:" + authorizeUrl);
	}

	@RequestMapping("access_token")
	public ModelAndView accessToken(HttpServletRequest request) {
		String state = request.getParameter("state");
		String code = request.getParameter("code");
		if (StringUtils.isNotBlank(state) && StringUtils.isNotBlank(code) && StringUtils.equals(DEFAULT_STATE, state)) {
			AccessToken accessToken = oAuth2.accessToken(code);
			return new ModelAndView("redirect:/t?access_token=" + accessToken.getAccessToken() + "&user_id="
				+ accessToken.getUid());
		} else {
			return new ModelAndView("redirect:/t/weibo/authorize");
		}
	}

}
