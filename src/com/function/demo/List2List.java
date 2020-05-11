package com.function.demo;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class List2List {

    private List<Person> pList = Arrays.asList(new Person(1L, "person1", 1),
            new Person(2L, "person2", 2),
            new Person(2L, "person2", 1),
            new Person(3L, "person3", 1),
            new Person(4L, "person4", 2),
            new Person(5L, "person5", 2),
            new Person(6L, "person6", 1));

    /**
     * 提取对象列表中的字段
     */
    @Test
    public void extractField() {

        List<Long> list = pList.stream().map(p -> p.getId()).collect(Collectors.toList());

        list.forEach(id -> System.out.println(id));
    }

    @Test
    public void extractList() {

        // 先转map 然后转list
        List<List<Person>> list = pList.stream().collect(Collectors.groupingBy(Person::getSex)).values().stream().collect(Collectors.toList());
        list.forEach(l -> System.out.println(l));

    }

    @Test
    public void listOfList2List() {

        // 先转map 然后转list
//        List<List<Person>> list = pList.stream().collect(Collectors.groupingBy(Person::getSex)).values().stream().collect(Collectors.toList());
//        list.forEach(l -> System.out.println(l));
//
//        List<Person> ps = list.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
//        ps.forEach(l -> System.out.println(l));
//
//        System.out.println("------------------");
//        // 根据 性别去重
        List<Person> unique = pList.stream().collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparingLong(Person::getSex))), ArrayList::new));
        unique.forEach(System.out::println);
        System.out.println("------------------");
        List<Person> personList = pList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getName() + ";" + o.getSex()))), ArrayList::new));
        personList.forEach(System.out::println);

//        groupBabyInfoList.sort(Comparator.comparing(GroupUserBabyInfo::getCreateTime).reversed());
    }

    /**
     * 如何去重？
     */
    @Test
    public void duplicateList() {

        List<String> testList = Arrays.asList("123", "123", "123", "123", "456");

        List<String> list = testList.stream().distinct().collect(Collectors.toList());

        list.forEach(id -> System.out.println(id));


        // 获取重复单号
        List<String> duplicateList = testList.stream()
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println("+++++++++++++++++++++++++++++");
        duplicateList.forEach(id -> System.out.println(id));

    }

    // 各种过滤操作

    /**
     * 排序操作
     */
    @Test
    public void sortList() {

        List<String> testList = Arrays.asList("123", "789", "永久", "123", "456");

        List<String> list = testList.stream().sorted().collect(Collectors.toList());

        list.forEach(id -> System.out.println(id));
        System.out.println(Integer.parseInt("01"));

    }

    @Test
    public void findList() {

        Optional<Person> op = pList.stream().filter(p -> p.getId() > 3).findAny();
        if (op.isPresent()) {
            System.out.println(op.get());
        }

    }

}
