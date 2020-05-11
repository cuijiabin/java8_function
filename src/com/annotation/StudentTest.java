package com.annotation;

public class StudentTest {

    /**
     * 自定义注解测试 1.什么是自定义注解 2.使用场景以及如何来使用？
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Student stu = new Student();
        stu.init();
        stu.show();
        stu.init("李四", 21, false);
        stu.show();
    }
}
