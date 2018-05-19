package com.thread.chapter03;

import org.junit.Test;

public class Run {

    public static ThreadLocal tl = new ThreadLocal();

    @Test
    public void test() {
        if (tl.get() == null) {
            System.out.println("从未放过值");
            tl.set("我的值");
        }
        System.out.println(tl.get());
        System.out.println(tl.get());
    }

    @Test
    public void test2() {
        try {
            ThreadA a = new ThreadA();
            a.start();
            Thread.sleep(1000);
            ThreadB b = new ThreadB();
            b.start();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("main " + Tools2.tl.get());
                Thread.sleep(500);
            }
            Thread.sleep(5000);
            ThreadA2 a = new ThreadA2();
            a.start();

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
