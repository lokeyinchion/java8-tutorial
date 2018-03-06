package com.winterbe.java8.samples.callback.listener;/**
 * Project: java8-tutorial
 * <p>
 * File Created at 2018/3/1
 * <p>
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

import java.util.Date;
import com.winterbe.java8.samples.callback.BottomService;
import com.winterbe.java8.samples.callback.UpperService;
import com.winterbe.java8.samples.callback.UpperServiceImpl;

/**
 * @Type Test.java
 * @Desc
 * @author Yingchuan Lu
 * @date 2018/3/1 11:17
 * @version
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("=============== callBottomService start ==================:" + new Date());
        DownLoadFiles downLoad = new DownLoadFiles();
        downLoad.setDownLoadListener(() -> System.out.println("download complete and call back now!!"+new Date()));
        downLoad.downLoad();
        System.out.println("=============== callBottomService end ==================:" + new Date());
    }
}
/**
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2018/3/1 Yingchuan Lu create
 */