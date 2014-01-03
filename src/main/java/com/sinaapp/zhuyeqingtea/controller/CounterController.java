/*
 * @(#)CounterController.java $version 2014年1月2日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sinaapp.zhuyeqingtea.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinaapp.zhuyeqingtea.service.CounterService;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.controller.CounterController.java
 * @author piaozaiguang
 * @date 2014年1月2日
 */
@Controller
@RequestMapping("/c")
public class CounterController {

	@Resource
	private CounterService counterService;

	@RequestMapping("")
	@ResponseBody
	public int index(HttpServletRequest request) {
		return counterService.getCount();
	}

}
