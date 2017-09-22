package com.winterbe.java8.samples.play.SupplierConsumer;/**
 * Project: java8-tutorial
 * <p>
 * File Created at 2017/9/22
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
 * @Type User.java
 * @Desc
 * @author Yingchuan Lu
 * @date 2017/9/22 17:38
 * @version
 */
public class User {
    private String userId;

    public User(int i, String s) {
        this.userId = s;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
/**
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017/9/22 Yingchuan Lu create
 */