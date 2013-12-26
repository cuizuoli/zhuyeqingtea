/*
 * @(#)WeiboAuthInterceptor.java $version 2013年12月26日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.security.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sinaapp.zhuyeqingtea.security.enums.AuthStatus;

/**
 * nhn zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.security.interceptor.WeiboAuthInterceptor.java
 * @author st13902
 * @date 2013年12月26日
 */
public class WeiboAuthInterceptor extends HandlerInterceptorAdapter {

	public final static String ACCESS_TOKEN = "access_token";
	public final static String USER_ID = "user_id";
	public final static String AUTH_STATUS = "auth_status";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		String accessToken = (String)session.getAttribute(ACCESS_TOKEN);
		if (StringUtils.isEmpty(accessToken)) {
			accessToken = request.getParameter(ACCESS_TOKEN);
		}
		String userId = (String)session.getAttribute(USER_ID);
		if (StringUtils.isEmpty(userId)) {
			userId = request.getParameter(USER_ID);
		}
		if (StringUtils.isNotBlank(accessToken) && StringUtils.isNotBlank(userId)) {
			request.setAttribute(AUTH_STATUS, AuthStatus.LOGIN);
			request.setAttribute(ACCESS_TOKEN, accessToken);
			request.setAttribute(USER_ID, userId);
			session.setAttribute(ACCESS_TOKEN, accessToken);
			session.setAttribute(USER_ID, userId);
		} else {
			request.setAttribute(AUTH_STATUS, AuthStatus.LOGOUT);
		}
		return super.preHandle(request, response, handler);
	}

}
