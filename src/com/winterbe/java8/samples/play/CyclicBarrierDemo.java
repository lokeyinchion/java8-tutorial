package com.winterbe.java8.samples.play;/**
 * Project: java8-tutorial
 * <p>
 * File Created at 2017/12/7
 * <p>
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Type CyclicBarrierDemo.java
 * @Desc
 * @author Yingchuan Lu
 * @date 2017/12/7 18:44
 * @version
 */
public class CyclicBarrierDemo {
    private final static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new MyBarrierAction());
    private final static AtomicInteger atcIx = new AtomicInteger(1);
    public static void main(String[] args) {
        for (int ix = 0; ix != 5; ix++){
            new Thread(()-> {

                    try{
                        System.out.println(Thread.currentThread().getName() + " start");
                        Thread.sleep(atcIx.getAndIncrement() * 10 );
                        cyclicBarrier.await();
                        System.out.println( Thread.currentThread().getName() + " stop" );
                    } catch ( Exception ex){
                    }

            }, "Thread-" + ix).start();
        }
    }

    private static class MyBarrierAction implements Runnable {
        @Override
        public void run() {
            System.out.println("MyBarrierAction is call.");
        }
    }
}
/**
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017/12/7 Yingchuan Lu create
 */