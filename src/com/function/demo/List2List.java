package com.function.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class List2List {

    @Test
    public void test1() {

        Person person1 = new Person(1L, "person1", 1);
        Person person2 = new Person(2L, "person2", 2);
        Person person3 = new Person(3L, "person3", 3);
        Person person4 = new Person(4L, "person4", 4);
        Person person5 = new Person(5L, "person5", 5);
        Person person6 = new Person(6L, "person6", 6);
        List<Person> pList = Arrays.asList(person1, person2, person3, person4, person5, person6);

        person6.setId(18L);
        List<Long> idList = pList.stream().map(p -> p.getId()).collect(Collectors.toList());

        idList.forEach(id -> System.out.println(id));
    }
}
