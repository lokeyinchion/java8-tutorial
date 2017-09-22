package com.winterbe.java8.samples.play;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

        /**
         *@Desc Predicate接受一个参数 判断输入的对象是否符合某个条件,返回一个布尔值
         *      5个方法,and|negate|or|test|xor
         *@return BiPredicate | Predicate<T></>
         */
        Predicate<String> nonNull = Objects::nonNull;
        System.out.println(nonNull.test("asdfas"));


        Supplier<User> userSupplier = User::new;
        User user = userSupplier.get();
        Consumer<User> userConsumer = (u) -> System.out.println("Username: "
                + u.getUserName());
        userConsumer.accept(user);

        Function<String,String> function = (x) -> {System.out.print(x+": ");return "Function";};
        System.out.println(function.apply("hello world"));
    }

    static class User{
        private String userName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public User() {
            this.userName = "Just Test";
        }
    }
}