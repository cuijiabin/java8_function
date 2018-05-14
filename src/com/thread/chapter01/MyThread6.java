package com.thread.chapter01;

public class MyThread6 extends Thread {

    private int count = 5;

    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("由" + Thread.currentThread().getName() + "计算, count=" + count);
    }
}
