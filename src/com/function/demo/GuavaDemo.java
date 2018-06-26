package com.function.demo;

import com.google.common.base.Objects;

public class GuavaDemo {

    public static void main(String[] args) {

        System.out.println(Objects.equal("a", null));
        System.out.println(Objects.hashCode("1", "2", "3"));
    }
}
