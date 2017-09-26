package com.winterbe.java8.samples.play.supplierconsumer;/**
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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Type App.java
 * @Desc
 * @author Yingchuan Lu
 * @date 2017/9/22 17:37
 * @version
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<User> usersQueue = new LinkedBlockingQueue<>();

        Supplier<User> userSupplier = () -> {
            try {
                return usersQueue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        /**
         * BiConsumer<T,U>   (T,U)->void
         */
        Consumer<User> userConsumer = user -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Processing user " + user.getUserId());};

        new SupplierConsumer<>(userSupplier, userConsumer).start();

        for (int i = 0; i < 100; i++) {
            usersQueue.put(new User(i, "user" + i));
        }
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