package com.annotation;

import java.lang.reflect.Method;

public class Student {
    private String name;
    private int age;
    private boolean sex;

    public void init(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @MyAnnotation(name = "张三", age = 20, sex = true)
    public void init() {
        try {
            Method method = Student.class.getMethod("init");
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation anno = method.getAnnotation(MyAnnotation.class);
                this.name = anno.name();
                this.age = anno.age();
                this.sex = anno.sex();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        System.out.print("{name=" + this.name);
        System.out.print(",age=" + this.age);
        System.out.println(",sex=" + (this.sex ? "男" : "女") + "}");
    }
}
