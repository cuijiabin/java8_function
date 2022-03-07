package com.function.demo;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class SortDemo {

    private static final Map<Long, Integer> sortMap = new HashMap<Long, Integer>() {
        {
            put(2L, -5);
            put(1L, -4);
            put(6L, -3);
            put(5L, -2);
            put(4L, -1);
        }
    };

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

//        Map<Long, Integer> sortMap = new HashMap<>();
//        sortMap.put(3L,-6);
//        sortMap.put(2L, -5);
//        sortMap.put(1L, -4);
//        sortMap.put(6L, -3);
//        sortMap.put(5L, -2);
//        sortMap.put(4L, -1);


        Collections.sort(personList, Comparator.comparingInt(v -> sortMap.get(v.getId()) == null ? v.getId().intValue() : sortMap.get(v.getId())));
        System.out.println("自定义id输出");
        personList.forEach(System.out::println);

    }

    /**
     * 排序操作
     */
    @Test
    public void sortList() {

        List<String> testList = Arrays.asList("123", "789", "永久", "123", "456");

        List<String> list = testList.stream().sorted().collect(Collectors.toList());

        list.forEach(System.out::println);

        System.out.println(1 / 4);
        System.out.println(3 / 4);
        System.out.println(4 / 4);

        System.out.println(1 % 4);
        System.out.println(3 % 4);
        System.out.println(4 % 4);
        System.out.println(4 - 4 * 4);

    }
}
