package com.thread.chapter01;

public class Test3 {

    public static void main(String[] args) {
//        MyThread3 runnable = new MyThread3();
//        new Thread(runnable).start();
//        System.out.println("运行结束了");

//        test4();

//        test5();
//        test6();
//        test7();
        testIsAlive();
    }

    public static void test4() {
        MyThread4 a = new MyThread4("A");
        MyThread4 b = new MyThread4("B");
        MyThread4 c = new MyThread4("C");
        a.start();
        b.start();
        c.start();
    }

    public static void test5() {

        Thread mythread = new MyThread6();
        Thread a = new Thread(mythread, "A");
        Thread b = new Thread(mythread, "B");
        Thread c = new Thread(mythread, "C");
        Thread d = new Thread(mythread, "D");
        Thread e = new Thread(mythread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    public static void test6() {
        ALogin a = new ALogin();
        a.start();

        BLogin b = new BLogin();
        b.start();
    }

    public static void test7() {
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);

        t1.setName("A");

        t1.start();
    }

    public static void testIsAlive() {
        MyThread8 c = new MyThread8();
        System.out.println("begin == "+c.isAlive());
        c.start();
        System.out.println("end == "+c.isAlive());
    }
}
