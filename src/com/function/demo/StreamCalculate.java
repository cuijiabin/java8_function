package com.function.demo;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream 计算总结
 */
public class StreamCalculate {

    @Test
    public void joinString() {

        String result = Stream.of("function1", "function2", "function3", "function4", "function5").collect(Collectors.joining("|"));
        System.out.println(result);
    }

    @Test
    public void avgCal() {
        double result = Stream.of(1, 2, 3, 4, 5).mapToInt(s -> s).average().getAsDouble();
        System.out.println(result);
    }

    @Test
    public void sumCal() {
        int result = Stream.of(1, 2, 3, 4, 5).reduce(0, (x, y) -> x + y).intValue();
        System.out.println(result);

        Stream.of(1, 2, 3, 4, 5).mapToInt(s -> s.intValue()).sum();
    }

    @Test
    public void maxCal() {
        int result = Stream.of(1, 2, 3, 4, 5).max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(result);
    }

    @Test
    public void minCal() {
        int result = Stream.of(1, 2, 3, 4, 5).min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(result);
    }

    /**
     * list 交差并补运算
     */
    @Test
    public void setCal() {
        List<String> listA = new ArrayList();
        listA.add("1111");
        listA.add("2222");
        listA.add("3333");

        List<String> listB = new ArrayList();
        listB.add("3333");
        listB.add("4444");
        listB.add("5555");

        // 交集
        List<String> intersection = listA.stream().filter(item -> listB.contains(item)).collect(Collectors.toList());
        System.out.println("---得到交集 intersection---");
        intersection.parallelStream().forEach(System.out::println);

        // 差集 (list1 - list2)
        List<String> reduce1 = listA.stream().filter(item -> !listB.contains(item)).collect(Collectors.toList());
        System.out.println("---得到差集 reduce1 (list1 - list2)---");
        reduce1.parallelStream().forEach(System.out::println);

        // 差集 (list2 - list1)
        List<String> reduce2 = listB.stream().filter(item -> !listA.contains(item)).collect(Collectors.toList());
        System.out.println("---得到差集 reduce2 (list2 - list1)---");
        reduce2.parallelStream().forEach(System.out::println);

        // 并集
        List<String> listAll = listA.parallelStream().collect(Collectors.toList());
        List<String> listAll2 = listB.parallelStream().collect(Collectors.toList());
        listAll.addAll(listAll2);
        System.out.println("---得到并集 listAll---");
        listAll.parallelStream().forEach(System.out::println);

        // 去重并集
        List<String> listAllDistinct = listAll.stream().distinct().collect(Collectors.toList());
        System.out.println("---得到去重并集 listAllDistinct---");
        listAllDistinct.parallelStream().forEach(System.out::println);

        System.out.println("---原来的List1---");
        listA.parallelStream().forEach(System.out::println);
        System.out.println("---原来的List2---");
        listB.parallelStream().forEach(System.out::println);

        Integer m = 3 / 6;
        System.out.println(m);
        System.out.println(BigDecimal.ONE + "");
    }

    @Test
    public void testBigDecimal() {
        BigDecimal b1 = new BigDecimal(1.26598877);
        BigDecimal b2 = new BigDecimal(1.26598877);
        // 四舍五入测试
        System.out.println(Stream.of(b1, b2).reduce(BigDecimal::add).get().setScale(2, BigDecimal.ROUND_HALF_DOWN));
        b1.add(b2);
        System.out.println(b1);
        System.out.println(b1.add(b2));
    }

    @Test
    public void testRetainAll() {
        Set<Integer> aSet = new HashSet<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};

        Set<Integer> bSet = new HashSet<Integer>() {{
            add(4);
            add(5);
            add(6);
        }};

        Set<Integer> cSet = new HashSet<Integer>() {{
            add(2);
            add(3);
            add(4);
        }};

        System.out.println(bSet.retainAll(aSet));
        System.out.println(cSet.retainAll(aSet));
    }
}
