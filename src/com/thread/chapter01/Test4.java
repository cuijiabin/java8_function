package com.thread.chapter01;

/**
 * sleep() 方法
 * getId() 方法
 */
public class Test4 {

    public static void main(String[] args) {
        testSleep();
//        testSleep2();
    }

    public static void testSleep() {
        MyThread9 thread9 = new MyThread9();
        System.out.println("begin = " + System.currentTimeMillis());
        thread9.run();
        System.out.println("end = " + System.currentTimeMillis());
    }

    public static void testSleep2() {
        MyThread10 t = new MyThread10();
        System.out.println("begin = " + System.currentTimeMillis() + "id " + Thread.currentThread().getId());
        t.start();
        System.out.println("end = " + System.currentTimeMillis() + "id " + Thread.currentThread().getId());
    }
}

class MyThread9 extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("run theadName=" + Thread.currentThread().getName() + " begin");
            Thread.sleep(2000);
            System.out.println("run theadName=" + Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread10 extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("run theadName=" + Thread.currentThread().getName() + " begin " + this.getId());
            Thread.sleep(2000);
            System.out.println("run theadName=" + Thread.currentThread().getName() + " end " + this.getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
