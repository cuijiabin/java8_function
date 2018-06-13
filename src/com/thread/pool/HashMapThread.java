package com.thread.pool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://www.cnblogs.com/xrq730/p/5037299.html hashmap 多线程死循环 实验 没有复现！
 */
public class HashMapThread extends Thread {

    private static AtomicInteger ai = new AtomicInteger(0);
    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>(1);

    @Override
    public void run() {
        while (ai.get() < 100000) {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        HashMapThread[] arr = new HashMapThread[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = new HashMapThread();
        }

        for (int i = 0; i < 20; i++) {
            arr[i].start();
        }
    }
}
