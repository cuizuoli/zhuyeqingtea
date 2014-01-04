/*
 * @(#)IndexController.java $version 2013年12月27日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinaapp.zhuyeqingtea.security.enums.AuthStatus;
import com.sinaapp.zhuyeqingtea.security.interceptor.WeiboAuthInterceptor;
import com.sinaapp.zhuyeqingtea.service.WeiboService;
import com.weibo.api.OAuth2;
import com.weibo.api.Users;
import com.weibo.model.ProfessionalTokenInfo;
import com.weibo.model.User;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.controller.IndexController.java
 * @author cuizuoli
 * @date 2013年12月27日
 */
@Controller
@RequestMapping("/")
public class IndexController {

	@Value("#{weiboProperties['pro.weibo.appKey']}")
	private String appKey;

	@Value("#{weiboProperties['pro.weibo.appSecret']}")
	private String appSecret;

	@Value("#{weiboProperties['pro.weibo.redirectUri']}")
	private String redirectUri;

	@Resource
	private WeiboService weiboService;

	@Resource
	private OAuth2 oAuth2;

	@Resource
	private Users users;

	@RequestMapping("")
	public ModelAndView index(HttpServletRequest request) {
		AuthStatus authStatus = (AuthStatus)request.getAttribute(WeiboAuthInterceptor.AUTH_STATUS);
		if (authStatus == AuthStatus.LOGOUT) {
			String subAppkey = request.getParameter("sub_appkey");
			String tokenString = request.getParameter("tokenString");
			if (StringUtils.isBlank(subAppkey)) {
				return new ModelAndView("redirect:" + redirectUri);
			} else if (tokenString == null) {
				return new ModelAndView("login")
					.addObject("appKey", subAppkey)
					.addObject("redirectUri", redirectUri);
			} else {
				ProfessionalTokenInfo tokenInfo = oAuth2.parseSignedRequest(tokenString, appSecret);
				if (tokenInfo != null) {
					String accessToken = tokenInfo.getOauthToken();
					String uid = tokenInfo.getUserId();
					HttpSession session = request.getSession();
					session.setAttribute(WeiboAuthInterceptor.USER_ID, uid);
					session.setAttribute(WeiboAuthInterceptor.ACCESS_TOKEN, accessToken);
					request.setAttribute(WeiboAuthInterceptor.USER_ID, uid);
					request.setAttribute(WeiboAuthInterceptor.ACCESS_TOKEN, accessToken);
					request.setAttribute(WeiboAuthInterceptor.AUTH_STATUS, AuthStatus.LOGIN);
					User user = users.show(uid, accessToken);
					weiboService.addUser(user);
				} else {
					return new ModelAndView("login")
						.addObject("appKey", subAppkey)
						.addObject("redirectUri", redirectUri);
				}
			}
		}
		return new ModelAndView("index");
	}
}
