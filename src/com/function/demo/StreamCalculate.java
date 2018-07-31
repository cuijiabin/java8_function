package com.function.demo;

import org.junit.Test;

import java.util.Comparator;
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
        double result = Stream.of(1, 2, 3, 4, 5).mapToInt(s->s).average().getAsDouble();
        System.out.println(result);
    }

    @Test
    public void sumCal() {
       int result = Stream.of(1, 2, 3, 4, 5).reduce(0, (x, y) -> x + y).intValue();
        System.out.println(result);
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
}
