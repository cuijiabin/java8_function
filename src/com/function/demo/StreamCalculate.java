package com.function.demo;

import org.junit.Test;

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

    // TODO 1.获取平均值 2.求和 3.
}
