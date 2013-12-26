/*
 * @(#)AbstractTest.java $version 2013年12月26日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sinaapp.zhuyeqingtea;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * nhn zhuyeqingtea
 * com.sinaapp.zhuyeqingtea.AbstractTest.java
 * @author st13902
 * @date 2013年12月26日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:context-service.xml"})
public abstract class AbstractTest {
}
