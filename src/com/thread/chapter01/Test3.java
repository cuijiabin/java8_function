package com.thread.chapter01;

public class Test3 {

    public static void main(String[] args) {

        int m = 4;
        switch (m) {
            case 3:
                test3();
                break;
            case 4:
                test4();
                break;
            case 5:
                test5();
                break;
            case 6:
                test6();
                break;
            case 7:
                test7();
                break;
            case 8:
                testIsAlive();
                break;
        }

    }

    /**
     * TODO 补充文档
     */
    public static void test3() {
        MyThread3 runnable = new MyThread3();
        new Thread(runnable).start();
        System.out.println("运行结束了");
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
        System.out.println("begin == " + c.isAlive());
        c.start();
        System.out.println("end == " + c.isAlive());
    }
}

class MyThread3 implements Runnable {

    @Override
    public void run() {
        System.out.println("运行中");
    }
}

class MyThread4 extends Thread {

    private int count = 5;

    public MyThread4(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由" + Thread.currentThread().getName() + "计算, count=" + count);
        }
    }
}

class MyThread5 extends Thread {

    private int count = 5;

    @Override
    public void run() {
        super.run();
        count--;
        System.out.println("由" + Thread.currentThread().getName() + "计算, count=" + count);
    }
}

class MyThread6 extends Thread {

    private int count = 5;

    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("由" + Thread.currentThread().getName() + "计算, count=" + count);
    }
}

class MyThread8 extends Thread {

    @Override
    public void run() {
        System.out.println("run = " + this.isAlive());
    }
}
