package com.winterbe.java8.samples.callback;/**
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

/**
 * @Type Test.java
 * @Desc
 * @author Yingchuan Lu
 * @date 2018/3/1 11:17
 * @version
 */
public class Test {
    public static void main(String[] args) {

        BottomService bottomService = new BottomService();

        UpperService upperService = new UpperServiceImpl(bottomService);

        System.out.println("=============== callBottomService start ==================:" + new Date());

//        String result = upperService.callBottomService("callBottomService start --> ");
        upperService.callBottomService("callBottomService start --> ");

        //upperTaskAfterCallBottomService执行必须等待callBottomService()调用BottomService.bottom()方法返回后才能够执行

//        upperService.upperTaskAfterCallBottomService(result);

        System.out.println("=============== callBottomService end ====================:" + new Date());

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