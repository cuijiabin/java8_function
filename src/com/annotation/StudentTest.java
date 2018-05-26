package com.annotation;

public class StudentTest {

    public static void main(String[] args) throws Exception {
        Student stu = new Student();
        stu.init();
        stu.show();
        stu.init("李四", 21, false);
        stu.show();
    }
}
