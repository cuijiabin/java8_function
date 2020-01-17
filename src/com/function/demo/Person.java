package com.function.demo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.*;


public class Person {

    private Long id;

    private String name;

    private Integer sex;

    public Person() {
    }

    public Person(Long id, String name, Integer sex) {

        this.id = id;
        this.name = name;
        this.sex = sex;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;

    @Override
    public String toString() {

        return JSON.toJSONString(this);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {

        System.out.println(tableSizeFor(129));
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(Maps.newHashMap().isEmpty());
        System.out.println(Arrays.asList("qqq", "vvvv", "ccc"));

        Map<Integer,String> tMap = new TreeMap<>();
//        Map<Integer,String> tMap = new LinkedHashMap<>();
        tMap.put(1,"");
        tMap.put(2,"s");
        tMap.put(3,"3");
        tMap.put(4,"");
        tMap.put(8,"");
        tMap.put(7,"s");
        tMap.put(6,"3");
        tMap.put(5,"");

        for (Integer key : tMap.keySet()) {
            System.out.println(key);
        }
        for (Map.Entry<Integer, String> entry : tMap.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

}
