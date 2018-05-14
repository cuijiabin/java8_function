package com.thread.chapter01;

public class Test1 {

    public synchronized void doSth() {
        System.out.println("Hello World");
    }

    public void doSth1() {
        synchronized (Test1.class) {
            System.out.println("Hello World");
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        myThread1.run();
        System.out.println("运行结束了");
    }
}
