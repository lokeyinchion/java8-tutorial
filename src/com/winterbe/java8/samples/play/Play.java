package com.winterbe.java8.samples.play;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Play {


    public static void main(String[] args) {
        /**
         *@Desc 通过 Function 接口及其组合功能,可以创建小的代码块,再将其组合来满足你的需求
         *      这样可以可以更简单、更有意思地实现 DRY 原则
         *@return BiFunction |BinaryOperator
         */
        Function<Integer, Integer> times2 = e -> e * 2;
        Function<Integer, Integer> squared = e -> e * e;
        /**
         *@Desc 先执行参数,再执行调用者
         *@return 4*4*2=32
         */
        times2.compose(squared).apply(4);
        /**
         *@Desc 先执行调用者,再执行参数
         *@return (4*2)*(4*2)=64
         */
        times2.andThen(squared).apply(4);

        Predicate<String> nonNull = Objects::nonNull;
        Predicate<String> isNull = Objects::isNull;

        System.out.println(nonNull.test("asdfas"));


        Function<String,String> function = (x) -> {System.out.print(x+": ");return "Function";};
        System.out.println(function.apply("hello world"));
    }
}