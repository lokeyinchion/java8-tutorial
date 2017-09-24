package com.winterbe.java8.samples.play.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @Desc 性能上Stream里有个操作函数的集合,每次转换操作就是把转换函数放入这个集合中,
 * 在汇聚操作的时候循环Stream对应的集合,然后对每个元素执行所有的函数.
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
         * stream()从iterator---创建stream
         * 可通过静态方法Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
         * 也可通过Collection接口的默认方法stream()
         * parallelStream()多线程环境中可能有问题
         *
         * distinct()|filter()|sorted()|map()---转换stream
         * limit()|skip()
         *
         * count()|reduce()|sum()|max()|collect()---聚合操作
         */
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        // "aaa2", "aaa1"


        // sorting

        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        // "aaa1", "aaa2"


        // mapping

        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        // "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"


        // matching

        boolean anyStartsWithA = stringCollection
                .stream()
                .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA = stringCollection
                .stream()
                .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ = stringCollection
                .stream()
                .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true


        // counting

        long startsWithB = stringCollection
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();

        System.out.println(startsWithB);    // 3


        // reducing

        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
        // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"

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


    }

}
