/*
 * @(#)PrizeController.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinaapp.zhuyeqingtea.model.Prize;
import com.sinaapp.zhuyeqingtea.model.Reward;
import com.sinaapp.zhuyeqingtea.security.interceptor.WeiboAuthInterceptor;
import com.sinaapp.zhuyeqingtea.service.PrizeService;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.controller.PrizeController.java
 * @author cuizuoli
 * @date 2014年1月1日
 */
@Controller
@RequestMapping("/p")
public class PrizeController {

	private final static int MAX_NEXT_PRIZE = 5;

	@Resource
	private PrizeService prizeService;

	@RequestMapping("l")
	@ResponseBody
	public List<Prize> getPrizeList() {
		return prizeService.getPrizeList();
	}

	/**
	 * 恭喜你获得绿色植物盆载
	 * @param request
	 * @return
	 */
	@RequestMapping("p")
	@ResponseBody
	public Prize prize(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute(WeiboAuthInterceptor.USER_ID);
		Reward reward = prizeService.getRewardCount(userId);
		Prize prize = new Prize();
		if (reward.getPrizeCount() < MAX_NEXT_PRIZE) {
			prize = prizeService.nextPrize(userId);
		}
		return prize;
	}

	/**
	 * 您还剩x次抽奖机会
	 * @param request
	 * @return
	 */
	@RequestMapping("c")
	@ResponseBody
	public int chance(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute(WeiboAuthInterceptor.USER_ID);
		return prizeService.getPrizeChance(userId);
	}

}
