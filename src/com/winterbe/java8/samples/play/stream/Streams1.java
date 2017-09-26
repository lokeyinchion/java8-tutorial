package com.winterbe.java8.samples.play.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @Desc 性能上Stream里有个操作函数的集合,每次转换操作就是把转换函数放入这个集合中,
 * 在汇聚操作的时候循环Stream对应的集合,然后对每个元素执行所有的函数.
 * @Detination 帮助管理数据集合而设计
 * @author Benjamin Winterberg
 */
public class Streams1 {

    public static void main(String[] args) {

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");


        /**
         * stream()从iterator---创建stream,原有的集合类map,array,list等都可考虑使用新
         * 方式进行遍历
         * 1.可通过静态方法Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
         *
         * 2.也可通过Collection接口的默认方法stream()
         * parallelStream()多线程环境中可能有问题
         *
         * distinct()|filter()|sorted()|map()---转换stream
         * limit()|skip()
         * anyMatch()|allMatch()|noneMatch()
         *
         * count()|reduce()|sum()|max()|collect()---聚合操作
         */
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        // "aaa2", "aaa1"

        /**
         * Reduce方法接受一个函数,这个函数有两个参数.
         * 第一个参数是上次函数执行的返回值(也称为中间结果),第二个参数是stream中的元素
         * @return Optional
         */
        OptionalInt reduced1 =IntStream.range(0, 10).reduce((a, b) -> a + b);
        System.out.println(reduced1.getAsInt());

        /**
         * 它允许用户提供一个循环计算的初始值,如果Stream为空,就直接返回该值.
         * 而且这个方法不会返回Optional,因为其不会出现null值
         */
        int reduced2 =IntStream.range(0, 10).reduce(7, (a, b) -> a + b);
        System.out.println(reduced2);

        test5(stringCollection);
    }

    /**
     * @desc 可以预先定义,也可以临时定义filter/sorted等函数的实现
     * @param stringCollection
     */
    private static void test5(List<String> stringCollection) {
        stringCollection
                .stream()
                .filter(s -> {
                    System.out.println("filter:  " + s);
                    return s.toLowerCase().startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort:    %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map:     " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

    /**
     * @desc peek()-->生成一个包含原Stream的所有元素的新Stream,同时会提供一个消费函数(Consumer实例),
     * 新Stream每个元素被消费的时候都会执行给定的消费函数
     */
    static void test2() {
        IntStream.range(1, 4)
                .mapToObj(num -> new Foo("Foo" + num))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(num -> new Bar("Bar" + num + " <- " + f.name))
                        .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));
    }
    static class Foo {
        String name;
        List<Bar> bars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }

    static class Bar {
        String name;

        Bar(String name) {
            this.name = name;
        }
    }

}
