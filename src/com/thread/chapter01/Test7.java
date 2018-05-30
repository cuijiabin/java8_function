package com.thread.chapter01;

import java.util.Random;

/**
 * yield方法
 * 线程优先级
 * 守护线程
 */
public class Test7 {

    public static void main(String[] args) {
//        testYield1();
//        testPriority1();
//        testPriority2();
//        testPriority3();
        testDeamon();
    }

    public static void testYield1() {
        MyThread20 t = new MyThread20();
        t.start();
    }

    public static void testPriority1() {
        System.out.println("main thread begin priority=" + Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(6);

        System.out.println("main thread end priority=" + Thread.currentThread().getPriority());

        MyThread21 t = new MyThread21();
        t.start();
    }

    public static void testPriority2() {
        for (int i = 0; i < 5; i++) {
            MyThread24 t2 = new MyThread24();
            t2.setPriority(10);
            t2.start();

            MyThread23 t1 = new MyThread23();
            t1.setPriority(1);
            t1.start();
        }
    }

    public static void testPriority3() {
        for (int i = 0; i < 5; i++) {
            MyThread25 t2 = new MyThread25();
            t2.setPriority(5);
            t2.start();

            MyThread26 t1 = new MyThread26();
            t1.setPriority(6);
            t1.start();
        }
    }

    public static void testDeamon() {
        try {
            MyThread27 t = new MyThread27();
            t.setDaemon(true);
            t.start();
            Thread.sleep(5000);
            System.out.println("我离开了thread对象就不打印了，就是停止了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class MyThread20 extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            Thread.yield();
            count = count + (i + 1);
        }
        System.out.println("用时：" + (System.currentTimeMillis() - beginTime) + "毫秒");
    }
}

class MyThread21 extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread21 run priority=" + this.getPriority());
        MyThread22 t2 = new MyThread22();
        t2.start();
    }
}

class MyThread22 extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread22 run priority=" + this.getPriority());
    }
}

class MyThread23 extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();
                addResult = addResult + 1;
            }

        }
        System.out.println("thread1 use time =" + (System.currentTimeMillis() - beginTime) + "毫秒");
    }
}

class MyThread24 extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();
                addResult = addResult + 1;
            }

        }
        System.out.println("thread2 use time =" + (System.currentTimeMillis() - beginTime) + "毫秒");
    }
}

class MyThread25 extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            random.nextInt();
        }

        System.out.println("thread25 use time =" + (System.currentTimeMillis() - beginTime) + "毫秒");
    }
}


class MyThread26 extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            random.nextInt();
        }

        System.out.println("thread26 use time =" + (System.currentTimeMillis() - beginTime) + "毫秒");
    }
}

class MyThread27 extends Thread {

    private int i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
