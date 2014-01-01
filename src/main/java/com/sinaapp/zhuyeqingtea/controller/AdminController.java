/*
 * @(#)AdminController.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinaapp.zhuyeqingtea.model.WeiboUser;
import com.sinaapp.zhuyeqingtea.security.interceptor.WeiboAuthInterceptor;
import com.sinaapp.zhuyeqingtea.service.WeiboService;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.controller.AdminController.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Controller
@RequestMapping("/a")
public class AdminController {

	@Resource
	private WeiboService weiboService;

	@RequestMapping("")
	public ModelAndView index(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute(WeiboAuthInterceptor.USER_ID);
		WeiboUser weiboUser = weiboService.getUser(userId);
		return new ModelAndView("admin")
			.addObject("weiboUser", weiboUser);
	}

}
