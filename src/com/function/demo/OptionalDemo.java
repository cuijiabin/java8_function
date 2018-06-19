package com.function.demo;

import java.util.Optional;

public class OptionalDemo {

    public static String getPersonName(Person p) {

        return Optional.ofNullable(p)
                .map(Person::getName)
                .orElse("Unknown");
    }

    public static void main(String[] args) {
        Person p1 = new Person(2L, null, 2);
        Person p2 = new Person(2L, "test", 2);

        System.out.println(getPersonName(p1));
        System.out.println(getPersonName(p2));
    }
}
