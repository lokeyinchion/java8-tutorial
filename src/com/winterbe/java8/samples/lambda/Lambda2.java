package com.winterbe.java8.samples.lambda;

/**
 * @author Benjamin Winterberg
 */
public class Lambda2 {
    /**
     * @desc FunctionalInterface函数式接口注解
     *****************************************
     * 1.有且仅有一个抽象方法
     * 2.静态static,默认方法default,或继承覆盖Object的方法,都不是抽象方法
     *****************************************
     * @param <F>
     * @param <T>
     */
    @FunctionalInterface
    public interface Converter<F, T> {
        T convert(F from);
    }

    static class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    public static void main(String[] args) {
        Converter<String, Integer> integerConverter1 = (from) -> Integer.valueOf(from);
        Integer converted1 = integerConverter1.convert("123");
        System.out.println(converted1);   // result: 123


        // method reference

        Converter<String, Integer> integerConverter2 = Integer::valueOf;
        Integer converted2 = integerConverter2.convert("123");
        System.out.println(converted2);   // result: 123


        Something something = new Something();

        Converter<String, String> stringConverter = something::startsWith;
        String converted3 = stringConverter.convert("Java");
        System.out.println(converted3);    // result J

        // constructor reference

        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
    }
}
