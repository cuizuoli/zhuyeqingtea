/*
 * @(#)WeiboService.java $version 2013年12月31日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinaapp.zhuyeqingtea.model.WeiboUser;
import com.sinaapp.zhuyeqingtea.repository.WeiboUserRepository;
import com.sinaapp.zhuyeqingtea.utils.AliasMethod;
import com.weibo.model.User;

/**
 * DaLian Software zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.service.WeiboService.java
 * @author cuizuoli
 * @date 2013年12月31日
 */
@Service
public class WeiboService {

	private final static String[] WEIBO_CONTENTS = new String[]{
		"我在#绿茶生活 远离雾霾 拒绝烟花#活动中为成都清除了4立方米雾霾，荣获“清除雾霾先进个人”称号，小伙伴们 ，来和我一起清除雾霾，刷新成都空气吧！点右马上参加：http://zhuyeqingtea.sinaapp.com/",
		"我在#绿茶生活 远离雾霾 拒绝烟花#活动中为成都清除了4立方米雾霾，被评为“除霾达人”。雾霾影响我们每个人，赶快来参加吧，还有机会获得“干净”好礼一份！猛戳这里：http://zhuyeqingtea.sinaapp.com/",
		"我在#绿茶生活 远离雾霾 拒绝烟花#活动中为成都清除了4立方米雾霾，赢得“雾霾终结者”称号。你还等什么？来和我一起，为成都送“干净”红包，抢“干净”好礼！点右进入：http://zhuyeqingtea.sinaapp.com/",
		"我在#绿茶生活 远离雾霾 拒绝烟花#活动中为成都清除了4立方米雾霾，赢得“成都空气卫士”称号。动鼠标，除雾霾，赢“干净”大礼！就等你的加入！点右加入我吧：http://zhuyeqingtea.sinaapp.com/",
		"我在#绿茶生活 远离雾霾 拒绝烟花#活动中“亲手”为成都清除了4立方米的雾霾，获得了“清除雾霾之星”称号，你也来试试吧！很神奇，动动鼠标就可以。点这里：http://zhuyeqingtea.sinaapp.com/"
	};

	private final static String[] WEIBO_PICS = new String[]{
		"wb_01.jpg",
		"wb_02.jpg",
		"wb_03.jpg",
		"wb_04.jpg",
		"wb_05.jpg"
	};

	@Resource
	private WeiboUserRepository weiboUserRepository;

	/**
	 * addUser
	 * @param user
	 */
	@Transactional
	public void addUser(User user) {
		WeiboUser weiboUser = new WeiboUser();
		weiboUser.setUserId(user.getId());
		weiboUser.setUserName(user.getName());
		weiboUser.setUserScreenName(user.getScreenName());
		weiboUser.setProfileImageUrl(user.getProfileImageUrl());
		weiboUser.setGender(user.getGender());
		weiboUser.setProvince(String.valueOf(user.getProvince()));
		weiboUser.setCity(String.valueOf(user.getCity()));
		weiboUser.setLocation(user.getLocation());
		int i = weiboUserRepository.update(weiboUser);
		if (i == 0) {
			weiboUserRepository.insert(weiboUser);
		}
	}

	/**
	 * getUser
	 * @param userId
	 * @return
	 */
	public WeiboUser getUser(String userId) {
		return weiboUserRepository.select(userId);
	}

	/**
	 * nextWeiboId
	 * @return
	 */
	public int nextWeiboId() {
		List<Double> probabilities = new ArrayList<Double>();
		probabilities.add(Double.valueOf("0.2"));
		probabilities.add(Double.valueOf("0.2"));
		probabilities.add(Double.valueOf("0.2"));
		probabilities.add(Double.valueOf("0.2"));
		probabilities.add(Double.valueOf("0.2"));
		AliasMethod aliasMethod = new AliasMethod(probabilities);
		return aliasMethod.next();
	}

	/**
	 * getWeiboContent
	 * @param i
	 * @return
	 */
	public String getWeiboContent(int i) {
		return WEIBO_CONTENTS[i];
	}

	/**
	 * getWeiboPic
	 * @param i
	 * @return
	 */
	public String getWeiboPic(int i) {
		return WEIBO_PICS[i];
	}

}
