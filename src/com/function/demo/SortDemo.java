package com.function.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortDemo {

    @Test
    public void sortByField() {

        List<Person> personList = Arrays.asList(
                new Person(1L, "person1", 1),
                new Person(2L, "person2", 2),
                new Person(3L, "person3", 1),
                new Person(4L, "person4", 2),
                new Person(5L, "person5", 2),
                new Person(6L, "person6", 1)
        );
        System.out.println("正常输出");
        personList.forEach(System.out::println);

        // 逆序排列
        Collections.reverse(personList);
        System.out.println("逆序输出");
        personList.forEach(System.out::println);

        // 按字段升序排列
        Collections.sort(personList, Comparator.comparingInt(Person::getSex));
        System.out.println("Sex字段升序输出");
        personList.forEach(System.out::println);

        Collections.sort(personList, Comparator.comparingInt(Person::getSex).reversed());
        System.out.println("Sex字段倒序输出");
        personList.forEach(System.out::println);

    }
}
