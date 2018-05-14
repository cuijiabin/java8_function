package com.thread.chapter01;

public class Test7 {

    public static void main(String[] args) {
//        testYield1();
//        testPriority1();
        testPriority2();
    }

    public static void testYield1() {
        MyThread20 t = new MyThread20();
        t.start();
    }

    public static void testPriority1(){
        System.out.println("main thread begin priority=" + Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(6);

        System.out.println("main thread end priority=" + Thread.currentThread().getPriority());

        MyThread21 t = new MyThread21();
        t.start();
    }

    public static void testPriority2(){
        for (int i = 0; i < 5; i++) {
            MyThread24 t2 = new MyThread24();
            t2.setPriority(10);
            t2.start();

            MyThread23 t1 = new MyThread23();
            t1.setPriority(1);
            t1.start();
        }
    }

}
