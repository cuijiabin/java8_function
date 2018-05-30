package com.thread.chapter01;

import org.junit.Test;

public class TestDemo {

    public synchronized void doSth() {
        System.out.println("Hello World");
    }

    public void doSth1() {
        synchronized (TestDemo.class) {
            System.out.println("Hello World");
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        myThread1.run();
        System.out.println("运行结束了");
    }

    /**
     * 测试线程的构造方法
     *
     * 单元测试与main方法是有区别的
     *
     * 最后查了好多文章资料还看了源代码，
     *
     * 得出结论Junit测试时也是用的main方法 main方法停止线程就会停止，所以多线程时慎用Junit测试
     *
     * 解决办法 join 等待子线程结束后执行
     */
    @Test
    public void testConstructor() {

        System.out.println(Thread.currentThread().getName());

        MyThread1 t = new MyThread1();

        t.start();
        t.run();
        System.out.println("运行结束了");
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSleep() {
        try {
            MyThread2 t = new MyThread2();
            t.setName("myThread");
            t.start();
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                // sleep 不会释放锁资源
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }

            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
