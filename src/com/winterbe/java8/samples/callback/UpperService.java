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
 * @Type UpperService.java
 * @Desc
 * @author Yingchuan Lu
 * @date 2018/3/1 11:16
 * @version
 */
public interface UpperService {
    void upperTaskAfterCallBottomService(String upperParam);

//    String callBottomService(final String param);
    void callBottomService(final String param);
}
/**
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2018/3/1 Yingchuan Lu create
 */