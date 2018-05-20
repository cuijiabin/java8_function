package com.thread.chapter04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService1 {
    private Lock lock = new ReentrantLock();

    public void testMethod(){
        lock.lock();
        for (int i = 0; i <5; i++) {
            System.out.println("ThreadName="+Thread.currentThread().getName()+" " +(i+1));
        }
        lock.unlock();
    }
}
