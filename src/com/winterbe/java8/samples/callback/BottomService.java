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

/**
 * @Type BottomService.java
 * @Desc
 * @author Yingchuan Lu
 * @date 2018/3/1 11:15
 * @version
 */
public class BottomService {
    public String bottom(String param) {
        try { //  模拟底层处理耗时，上层服务需要等待
            Thread.sleep(3000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        return param +" BottomService.bottom() execute -->";
    }

    public void bottom(UpperService upperService, String param) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        upperService.upperTaskAfterCallBottomService( param +" bottom callback upperTaskAfterCallBottomService() execute -->");
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