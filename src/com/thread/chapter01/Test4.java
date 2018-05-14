package com.thread.chapter01;

public class Test4 {
    public static void main(String[] args) {

//        testSleep();
        testSleep2();
    }

    public static void testSleep(){
        MyThread9 thread9 = new MyThread9();
        System.out.println("begin = "+System.currentTimeMillis());
        thread9.run();
        System.out.println("end = "+System.currentTimeMillis());
    }

    public static void testSleep2(){
        MyThread10 t = new MyThread10();
        System.out.println("begin = "+System.currentTimeMillis() + "id "+Thread.currentThread().getId());
        t.start();
        System.out.println("end = "+System.currentTimeMillis() + "id "+Thread.currentThread().getId());
    }
}
