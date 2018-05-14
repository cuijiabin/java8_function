package com.thread.chapter01;

public class MyThread20 extends Thread {

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
