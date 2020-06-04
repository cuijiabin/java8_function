package com.function.demo;

import com.alibaba.fastjson.JSON;

import java.util.Date;

public class Person {

    private Long id;

    private String name;

    private Integer sex;

    private Date createAt;

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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
