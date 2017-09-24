package com.winterbe.java8.samples.play.optional;

import java.util.function.Supplier;

/**
 * Examples how to avoid null checks with Optional:
 *
 * http://winterbe.com/posts/2015/03/15/avoid-null-checks-in-java/
 *
 * @author Benjamin Winterberg
 */
public class Optional {

    static class Outer {
        Nested nested = new Nested();

        public Nested getNested() {
            return nested;
        }
        public Object getNull() {
            return null;
        }
    }

    static class Nested {
        Inner inner = new Inner();

        public Inner getInner() {
            return inner;
        }
    }

    static class Inner {
        String foo = "boo";

        public String getFoo() {
            return foo;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    /**
     * @desc Optional的生成处理,得到一个后续可用的Optional
     * @param resolver
     * @param <T>
     * @return
     */
    public static <T> java.util.Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return java.util.Optional.ofNullable(result);
        }
        catch (NullPointerException e) {
            return java.util.Optional.empty();
        }
    }

    private static void test4() {
        Outer outer = new Outer();
        /**
         * orElseGet接受Supplier接口的实现
         */
        System.out.println(resolve(() -> outer.getNull()).orElse("asdfas"));
        System.out.println(resolve(() -> outer.getNull()).orElseGet(() -> "Default Value"));
    }

    private static void test3() {
        Outer outer = new Outer();
        /**
         * 函数式接口如Supplier等,只包含有且仅有一个抽象方法,则传入lambda表达式
         * 将于定义的抽象方法自动匹配
         */
        resolve(() -> outer.getNested().getInner().getFoo())
                .ifPresent(System.out::println);
    }

    private static void test2() {
        /**
         * map返回一个T对象,map可进行无限级联操作
         * ifPresent接受Consumer实现
         */
        java.util.Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::println);
    }

    private static void test1() {
        /**
         * flatMap必须返回一个Optional对象
         * ifPresent接受Consumer实现
         */
        java.util.Optional.of(new Outer())
                .flatMap(o -> java.util.Optional.ofNullable(o.nested))
                .flatMap(n -> java.util.Optional.ofNullable(n.inner))
                .flatMap(i -> java.util.Optional.ofNullable(i.foo))
                .ifPresent(System.out::println);
    }
}
