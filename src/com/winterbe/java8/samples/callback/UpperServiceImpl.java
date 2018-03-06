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
 * @Type UpperServiceImpl.java
 * @Desc
 * @author Yingchuan Lu
 * @date 2018/3/1 11:16
 * @version
 */
public class UpperServiceImpl implements UpperService{
    private BottomService bottomService;

    @Override

    public void upperTaskAfterCallBottomService(String upperParam) {

        System.out.println(upperParam + " upperTaskAfterCallBottomService() execute.");

    }

    public UpperServiceImpl(BottomService bottomService) {
        this.bottomService = bottomService;

    }

//    @Override
//    public String callBottomService(final String param) {
//        return bottomService.bottom(param + " callBottomService.bottom() execute --> ");
//    }

    @Override

    public void callBottomService(final String param) {
        new Thread(() -> bottomService.bottom(UpperServiceImpl.this,    param  + " callBottomService.bottom() execute --> ")).start();
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