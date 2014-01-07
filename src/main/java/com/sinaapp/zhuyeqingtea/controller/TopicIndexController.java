/*
 * @(#)TopicIndexController.java $version 2013年12月28日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinaapp.zhuyeqingtea.security.enums.AuthStatus;
import com.sinaapp.zhuyeqingtea.security.interceptor.WeiboAuthInterceptor;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.controller.TopicIndexController.java
 * @author cuizuoli
 * @date 2013年12月28日
 */
@Controller
@RequestMapping("/t")
public class TopicIndexController {

	@RequestMapping("i")
	public ModelAndView index(HttpServletRequest request) {
		AuthStatus authStatus = (AuthStatus)request.getAttribute(WeiboAuthInterceptor.AUTH_STATUS);
		if (authStatus == AuthStatus.LOGIN) {
			return new ModelAndView("index");
		} else {
			return new ModelAndView("topic");
		}
	}

	@RequestMapping("")
	public ModelAndView topic(HttpServletRequest request) {
		return new ModelAndView("topic");
	}

}
