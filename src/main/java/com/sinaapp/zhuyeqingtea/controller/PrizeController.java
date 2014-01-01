/*
 * @(#)PrizeController.java $version 2014年1月1日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinaapp.zhuyeqingtea.model.Prize;
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

	@Resource
	private PrizeService prizeService;

	@RequestMapping("l")
	@ResponseBody
	public List<Prize> getPrizeList() {
		return prizeService.getPrizeList();
	}
}
