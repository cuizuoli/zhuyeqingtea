/*
 * @(#)GameController.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinaapp.zhuyeqingtea.security.interceptor.WeiboAuthInterceptor;
import com.sinaapp.zhuyeqingtea.service.GameService;

import lombok.extern.slf4j.Slf4j;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.controller.GameController.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Slf4j
@Controller
@RequestMapping("/g")
public class GameController {

	@Resource
	private GameService gameService;

	@RequestMapping("join")
	@ResponseBody
	public boolean join(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute(WeiboAuthInterceptor.USER_ID);
		if (StringUtils.isNotBlank(userId)) {
			return gameService.joinGame(userId);
		} else {
			log.error("User not found!");
			return false;
		}
	}

	@RequestMapping("share")
	@ResponseBody
	public void share(HttpServletRequest request, @RequestParam String text) {
		HttpSession session = request.getSession();
		String accessToken = (String)session.getAttribute(WeiboAuthInterceptor.ACCESS_TOKEN);
		gameService.shareWeibo(text, accessToken);
	}

}
