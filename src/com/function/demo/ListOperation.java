package com.function.demo;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * 列表集合的相关操作
 */
public class ListOperation {

    private List<Person> pList = Arrays.asList(new Person(1L, "person1", 1),
            new Person(2L, "person2", 2),
            new Person(2L, "person2", 1),
            new Person(3L, "person3", 1),
            new Person(4L, "person4", 2),
            new Person(5L, "person5", 2),
            new Person(6L, "person6", 1));

    /**
     * 提取对象列表中的字段
     * 重点：先map然后收集
     */
    @Test
    public void extractField() {

        List<Long> list = pList.stream().map(p -> p.getId()).collect(Collectors.toList());
        list.forEach(System.out::println);
        list = pList.stream().map(Person::getId).collect(Collectors.toList());
        list.forEach(System.out::println);
    }


    /**
     * 根据字段对列表进行去重
     * 要点：Collectors.collectingAndThen(Collectors.toCollection(
     */
    @Test
    public void removeDuplicateList() {


        // 根据 性别去重
        List<Person> unique = pList.stream().collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparingLong(Person::getSex))), ArrayList::new));
        System.out.println("根据性别去重结果");
        unique.forEach(System.out::println);

        List<Person> personList = pList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getName() + ";" + o.getSex()))), ArrayList::new));
        System.out.println("根据姓名加性别去重结果");
        personList.forEach(System.out::println);

    }

    /**
     * 如何去重？
     */
    @Test
    public void duplicateList() {

        List<String> testList = Arrays.asList("123", "123", "123", "123", "456");

        List<String> list = testList.stream().distinct().collect(Collectors.toList());

        System.out.println("列表去重结果：");
        list.forEach(System.out::println);


        // 获取重复单号
        List<String> duplicateList = testList.stream()
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println("列表中的重复内容：");
        duplicateList.forEach(System.out::println);

    }

    @Test
    public void findList() {

        Integer s = null;
        try {
            s = Integer.valueOf("xdsfsd");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println(s);
        Optional<Person> op = pList.stream().filter(p -> p.getId() > 3).findAny();
        if (op.isPresent()) {
            System.out.println(op.get());
        }

    }

}
