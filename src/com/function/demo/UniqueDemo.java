package com.function.demo;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 重复功能测试demo
 */
public class UniqueDemo {

    /**
     * 列表去重处理
     */
    @Test
    public void testListDistinct() {
        List<Integer> distinctList = Stream.of(1, 1, 2, 2, 3, 6, 6, 9).distinct().collect(toList());
        distinctList.forEach(System.out::println);
    }

    /**
     * 列表重复查询 先分组count 再过滤 如果是对象 则分组时计算唯一key
     */
    @Test
    public void testListDuplicate() {

        List<Integer> preList = Arrays.asList(1, 1, 2, 2, 3, 6, 6, 9);

        preList = preList.stream().collect(Collectors.groupingBy(t -> t, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .map(e -> e.getKey()).collect(Collectors.toList());
        preList.forEach(System.out::println);

    }

    @Test
    public void testEmptyErgodic(){

        Map<String,String> testMap = new HashMap<>();
        for (String key : testMap.keySet()) {
            System.out.println(key);
        }
        System.out.println("test node 2");

        // 此种情况下会抛出错误！
//        List<Integer> ll = null;
        List<Integer> ll = new ArrayList<>();
        for (Integer i : ll) {
            System.out.println(i);
        }

        List<Integer> ttt = new ArrayList<>();
        ttt.add(1);
        ttt.add(2);
        ttt.add(3);
        ttt.add(4);
        ttt.add(5);

        List<Integer> sub =  ttt.subList(2,5);
        sub.forEach(System.out::println);

        Map<Integer, String> shipPackClassMap = new HashMap<>();
        shipPackClassMap.put(1, "A");
        shipPackClassMap.put(2, "A");

        long num = shipPackClassMap.values().stream().distinct().count();
        System.out.println(shipPackClassMap.values().size());
        System.out.println(num);
        Set<String> shipPackClassSet = shipPackClassMap.values().stream().collect(Collectors.toSet());
        System.out.println(shipPackClassSet);

    }
}
