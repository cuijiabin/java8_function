package com.thread.chapter02;

/**
 * 测试死锁
 */
public class DeadLockTest {

    public static String A = "A";
    public static String B = "B";

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (B) {
                        System.out.println("执行任务1");
                    }
                }


            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("执行任务2");
                    }
                }

            }
        });

        t1.start();
        t2.start();
    }
}
