/*
 * @(#)IndexController.java $version 2013年12月27日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinaapp.zhuyeqingtea.security.enums.AuthStatus;
import com.sinaapp.zhuyeqingtea.security.interceptor.WeiboAuthInterceptor;

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

	@RequestMapping("")
	public ModelAndView index(HttpServletRequest request) {
		AuthStatus authStatus = (AuthStatus)request.getAttribute(WeiboAuthInterceptor.AUTH_STATUS);
		if (authStatus == AuthStatus.LOGIN) {
			return new ModelAndView("redirect:/main");
		} else {
			return new ModelAndView("index")
				.addObject("appKey", appKey)
				.addObject("redirectUri", redirectUri);
		}
	}

	@RequestMapping("main")
	public ModelAndView main(HttpServletRequest request) {
		AuthStatus authStatus = (AuthStatus)request.getAttribute(WeiboAuthInterceptor.AUTH_STATUS);
		if (authStatus == AuthStatus.LOGIN) {
			return new ModelAndView("main");
		} else {
			return new ModelAndView("redirect:/");
		}
	}

}
