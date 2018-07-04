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
        Person p2 = null;
        // = new Person(2L, "test", 2);

        System.out.println(getPersonName(p1));
        System.out.println(getPersonName(p2));

        String str = new String("www.runoob.com");

        System.out.println(str.length());
        System.out.print("返回值 :" );
        System.out.println(str.substring(4) );

        /**
         *      * @param      beginIndex   the beginning index, inclusive.
         *      * @param      endIndex     the ending index, exclusive.
         */
        System.out.print("返回值 :" );
        System.out.println(str.substring(4, 14) );
    }
}
