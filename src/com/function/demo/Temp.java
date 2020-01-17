package com.function.demo;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Temp {

    static class Person {

        private String name;
        private int age;
        private long salary;

        Person(String name, int age, long salary) {

            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("Person{name='%s', age=%d, salary=%d}", name, age, salary);
        }
    }

    public static void main(String[] args) {
//        Stream<Person> people = Stream.of(new Person("Paul", 24, 20000),
//                new Person("Mark", 30, 30000),
//                new Person("Will", 28, 28000),
//                new Person("William", 28, 28000));
//        Map<String, List<Person>> peopleByAge;
//        peopleByAge = people.collect(Collectors.groupingBy(p -> p.age + p.name, Collectors.mapping((Person p) -> p, toList())));
//        System.out.println(peopleByAge);
//
//        String uuid=UUID.randomUUID().toString().replaceAll("-", "");
//        System.out.println(uuid);
//        System.out.println(UUID.randomUUID().toString());
//
//        System.out.println(Objects.equal("a", "a"));
//
//        List<Person> rollbackLog = Lists.newArrayList();
//        for (Person person : rollbackLog) {
//            System.out.println(person);
//        }

//        String mmm = null;
//
//        try {
//            assert mmm != null;
//            System.out.println(mmm.contains("66"));
//            System.out.println( Objects.requireNonNull(mmm).contains("66"));
//            Objects.requireNonNull(mmm).contains("66");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(Integer.parseInt(null));
//        }

        System.out.println(BigDecimal.ONE.compareTo(BigDecimal.ZERO));
        System.out.println(BigDecimal.ZERO.compareTo(BigDecimal.ONE));
        System.out.println(BigDecimal.ZERO.compareTo(BigDecimal.ZERO));

        Integer max = 2147483647;
//        max = 2147483648;

        int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        System.out.println(hours);

    }
}
