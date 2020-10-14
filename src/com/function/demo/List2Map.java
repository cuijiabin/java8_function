package com.function.demo;

import org.apache.commons.lang3.BooleanUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * List 转 map
 */
public class List2Map {


    private List<Person> pList = Arrays.asList(
            new Person(1L, "person1", 1),
            new Person(2L, "person2", 2),
            new Person(3L, "person3", 1),
            new Person(4L, "person4", 2),
            new Person(5L, "person5", 2),
            new Person(6L, "person6", 1)
    );

    /**
     * list生成map k->v
     * 重点 Collectors.toMap(Person::getId, p -> p)
     */
    @Test
    public void genFieldMap() {

        Map<Long, Person> map = pList.stream().collect(Collectors.toMap(Person::getId, p -> p));
        System.out.println(map);

        List<Person> personList = Arrays.asList(
                new Person(1L, "person1", 1),
                new Person(2L, "person1", 2),
                new Person(3L, "person2", 1),
                new Person(4L, "person2", 2),
                new Person(5L, "person3", 2),
                new Person(6L, "person3", 1)
        );

        // 防止key重复导致出现问题
        Map<String, Person> nameMap = personList.stream().collect(Collectors.toMap(Person::getName, p -> p, (o, n) -> o));
        System.out.println(nameMap);
        nameMap = personList.stream().collect(Collectors.toMap(Person::getName, p -> p, (o, n) -> n));
        System.out.println(nameMap);

        // 会抛出异常 java.lang.IllegalStateException: Duplicate key {"id":1,"name":"person1","sex":1}
//        nameMap = personList.stream().collect(Collectors.toMap(Person::getName, p -> p));
//        System.out.println(nameMap);

        Map<Long, String> fieldMap = pList.stream().collect(Collectors.toMap(Person::getId, p -> p.getName()));
        System.out.println(fieldMap);
        fieldMap = pList.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println(fieldMap);

        Map<String, Integer> sexMap = personList.stream().collect(Collectors.toMap(Person::getName, Person::getSex, (o, n) -> o));
        System.out.println(sexMap);
    }

    /**
     * list生成map k->List<V>
     * 重点 Collectors.groupingBy(Person::getSex)
     */
    @Test
    public void genFieldMapList() {

        Map<Integer, List<Person>> map = pList.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println(map);

        // 统计数量
        Map<Integer, Long> numMap = pList.stream().collect(Collectors.groupingBy(i -> i.getSex(), Collectors.counting()));
        System.out.println(numMap);

        // 统计数量
        numMap = pList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.counting()));
        System.out.println(numMap);

        // 分组后抽取姓名列表
        Map<Integer, List<String>> nameGroupMap = pList.stream().collect(Collectors.groupingBy(Person::getSex))
                .entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().stream().map(Person::getName).collect(Collectors.toList())));

        System.out.println(nameGroupMap);

        // 分组后再抽取字段有无其他的优化方法？
        nameGroupMap = pList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println(nameGroupMap);
    }

    @Test
    public void testComputeIfAbsent() {

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("1", "a");
        resultMap.put("2", "a");
        resultMap.put("3", "a");

        System.out.println(new HashSet<>(resultMap.values()));

        String value = resultMap.computeIfAbsent("5", k -> "s");
        System.out.println(value);
        System.out.println(resultMap);

        Map<String, List<String>> resultListMap = new HashMap<>();
        List<String> stringList = resultListMap.computeIfAbsent("5", k -> new ArrayList<>());
        stringList.add("m");
        stringList.add("n");
        System.out.println(resultListMap);

        System.out.println(BooleanUtils.isTrue(null));
    }

    @Test
    public void testRemoveList() {

        List<Integer> ll = new ArrayList<>();
        ll.add(1);
        ll.add(2);
        ll.add(1);
        ll.add(1);

        Iterator<Integer> xx = ll.iterator();
        while (xx.hasNext()) {
            Integer x = xx.next();
            System.out.println(x);
            if(x == 2){
                continue;
            }
            xx.remove();
        }

        System.out.println(ll);
    }

}
