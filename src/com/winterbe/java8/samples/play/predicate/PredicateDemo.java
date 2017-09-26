package com.winterbe.java8.samples.play.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        /**
         *@Desc Predicate接受一个参数 判断输入的对象是否符合某个条件,返回一个布尔值
         *      5个方法,and|negate|or|test|xor
         *@return BiPredicate | Predicate<T></>
         */
        Predicate<String> nonNull = Objects::nonNull;
        System.out.println(nonNull.test("asdfas"));

        List<User> people = new ArrayList<>();

        people.add(new User("Mohamed", 69));
        people.add(new User("Doaa", 25));
        people.add(new User("Malik", 6));

        Predicate<User> pred = (p) -> p.getAge() > 65;

        displayPeople(people, pred);
    }

    private static void displayPeople(List<User> people, Predicate<User> pred) {
        System.out.println("Selected:");
//        people.forEach(p -> {
//            if (pred.test(p)) {
//                System.out.println(p.getUserName());
//            }
//        });
        /**
         * @Desc filter(Predicate<? super T> predicate)接受一个Predicate参数
         */
        people.stream()
                .filter(pred)
                .forEach(p -> System.out.println(p.getUserName()));
    }

    static class User{
        private String userName;
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public User() {
            this.userName = "Just Test";
        }

        public User(String userName, int age) {
            this.userName = userName;
            this.age = age;
        }
    }
}