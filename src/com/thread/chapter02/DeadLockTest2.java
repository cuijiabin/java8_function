package com.thread.chapter02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockTest2 {

    public static Integer A = 1;
    public static Integer B = 1;

    // TODO 没有产生死锁
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            private Lock lock = new ReentrantLock();
            @Override
            public void run() {
                lock.lock();
                System.out.println(A);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(B);
                lock.unlock();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            private Lock lock = new ReentrantLock();
            @Override
            public void run() {
                lock.lock();
                System.out.println(B);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(A);
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
    }
}
