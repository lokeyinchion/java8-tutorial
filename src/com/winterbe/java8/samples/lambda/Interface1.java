package com.winterbe.java8.samples.lambda;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.sort;

/**
 * @author Benjamin Winterberg
 */
public class Interface1 {

    interface Formula {
        double calculate(int a);

        /**
         * @desd 默认方法提供一种拓展接口的方法，而不破坏现有代码
         * 如有必要,子类也可override默认方法
         * @param a
         * @return
         */
        default double sqrt(int a) {
            return Math.sqrt(positive(a));
        }

        static int positive(int a) {
            return a > 0 ? a : 0;
        }
    }

    public static void main(String[] args) {
        Formula formula1 = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        formula1.calculate(100);     // 100.0
        formula1.sqrt(-23);          // 0.0
        Formula.positive(-4);        // 0.0

        /**
         * @desc Collection 内建sort()lambda实现
         */
        List<String> values = Arrays.asList("AAA","bbb","CCC","ddd","EEE");

        //Case sensitive sort operation
        sort(values);
        // Case insensetive sort operation with Lambda
        sort(values,(o1, o2) -> o1.compareToIgnoreCase(o2));

        /**
         * @desc 使用lambda来使用线程
         *****************************************
         * Using lambda expression inner classes *
         *****************************************
         */
        Runnable thrd1 = () -> System.out.println("Hello Thread 1.");

        new Thread(thrd1).start();

        /**
         ******************************************
         * Using lambda exprssion anonymous class *
         ******************************************
         */
        new Thread(() -> System.out.println("Hello Thread 2.")).start();
    }

}