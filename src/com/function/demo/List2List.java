package com.function.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class List2List {

    private List<Person> pList = Arrays.asList(new Person(1L, "person1", 1),
            new Person(2L, "person2", 2),
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
        List<List<Person>> list =  pList.stream().collect(Collectors.groupingBy(Person::getSex)).values().stream().collect(Collectors.toList());
        list.forEach(l -> System.out.println(l));

    }
}
