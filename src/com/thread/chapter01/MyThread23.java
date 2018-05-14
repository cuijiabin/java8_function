package com.thread.chapter01;

import java.util.Random;

public class MyThread23 extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();
                addResult = addResult +1;
            }

        }
        System.out.println("thread1 use time =" + (System.currentTimeMillis() - beginTime) + "毫秒");
    }
}
