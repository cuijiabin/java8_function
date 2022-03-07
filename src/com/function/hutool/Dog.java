package com.function.hutool;

import cn.hutool.core.clone.CloneSupport;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;

public class Dog extends CloneSupport<Dog> {
    private String name = "wangwang";
    private int age = 3;

    public static void main(String[] args) {
        Dog d = new Dog();
        Dog d2 = ObjectUtil.cloneByStream(d);

        System.out.println(d);
        System.out.println(d2);

        System.out.println(DateUtil.current());
    }
}
