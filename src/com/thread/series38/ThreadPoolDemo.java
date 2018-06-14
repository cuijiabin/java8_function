package com.thread.series38;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        MyThread[] arr = new MyThread[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = new MyThread();
        }

        // 将线程放入池中进行执行
        for (int i = 0; i < 20; i++) {
            pool.execute(arr[i]);
        }

        // 关闭线程池
        pool.shutdown();
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}