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

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Type SupplierConsumer.java
 * @Desc
 * @author Yingchuan Lu
 * @date 2017/9/22 17:36
 * @version
 */
public class SupplierConsumer<T> extends Thread {
    private Supplier<T> supplier;
    private Consumer<T> consumer;
    private boolean shouldRun = true;

    public SupplierConsumer(Supplier<T> supplier, Consumer<T> consumer) {
        this.supplier = supplier;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (shouldRun) {
            T item = supplier.get();
            consumer.accept(item);
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