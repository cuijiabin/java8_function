package com.thread.series18;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 仓库的容量不可能为负数
 * 仓库的容量是有限制的
 * <p>
 * 这些条件是没有添加好的！
 */
public class Depot1 {

    /**
     * 仓库的实际数量
     */
    private int size;
    /**
     * 独占锁
     */
    private Lock lock;

    public Depot1() {
        this.size = 0;
        this.lock = new ReentrantLock();
    }

    public void produce(int val) {
        lock.lock();
        try {
            size += val;
            System.out.printf("%s produce(%d) --> size=%d\n", Thread.currentThread().getName(), val, size);
        } finally {
            lock.unlock();
        }
    }

    public void consume(int val) {
        lock.lock();
        try {
            size -= val;
            System.out.printf("%s consume(%d) <-- size=%d\n", Thread.currentThread().getName(), val, size);
        } finally {
            lock.unlock();
        }
    }
}
