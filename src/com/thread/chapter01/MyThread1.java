package com.thread.chapter01;

public class MyThread1 extends Thread {

    public MyThread1(){
        System.out.println("构造方法的打印："+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法的打印："+Thread.currentThread().getName());
    }
}
