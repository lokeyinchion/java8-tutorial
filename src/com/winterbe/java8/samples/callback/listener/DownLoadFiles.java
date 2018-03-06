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

/**
 * @Type DownLoadFiles.java
 * @Desc
 * @author Yingchuan Lu
 * @date 2018/3/1 14:14
 * @version
 */
public class DownLoadFiles {
    //下载模块自己持有的监听对象
    DownLoadListener mListener;
    private boolean downLoadfinish = true;
    //该方法将其他人实现的DownLoadListener 对象设置给下载模块自己持有的对象
    void setDownLoadListener(DownLoadListener listener){
        mListener = listener;
    }

    void downLoad() {
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (downLoadfinish) {
                mListener.onDownLoadComplete();
            }
        }).start();
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