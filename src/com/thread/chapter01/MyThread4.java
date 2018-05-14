package com.thread.chapter01;

public class MyThread4 extends Thread {

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
