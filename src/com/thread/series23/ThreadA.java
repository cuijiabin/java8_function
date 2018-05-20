package com.thread.series23;

public class ThreadA extends Thread {

    @Override
    public void run() {
        // 通过synchronized(this)获取“当前对象的同步锁”
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " wakup others");
            // 唤醒“当前对象上的等待线程”
            notify();
        }
    }
}
