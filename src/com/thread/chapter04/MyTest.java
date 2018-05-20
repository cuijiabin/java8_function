package com.thread.chapter04;

import org.junit.Test;

public class MyTest {

    /**
     * 4.1.1 使用ReentrantLock 实现同步：测试1
     */
    @Test
    public void test1() {
        MyService1 service = new MyService1();

        MyThread1 a1 = new MyThread1(service);
        MyThread1 a2 = new MyThread1(service);
        MyThread1 a3 = new MyThread1(service);
        MyThread1 a4 = new MyThread1(service);
        MyThread1 a5 = new MyThread1(service);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 4.1.2 使用ReentrantLock 实现同步：测试2
     */
    @Test
    public void test2() {
        MyService2 service = new MyService2();

        MyThreadA a = new MyThreadA(service);
        a.setName("A");
        a.start();

        MyThreadA aa = new MyThreadA(service);
        aa.setName("AA");
        aa.start();

        MyThreadB b = new MyThreadB(service);
        b.setName("B");
        b.start();

        MyThreadB bb = new MyThreadB(service);
        bb.setName("BB");
        bb.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 4.1.3 使用Condition 实现等待/通知：错误用法与解决
     * <p>
     * condition.await()方法调用之前 必须调用 lock.lock() 代码获得同步监视器
     */
    @Test
    public void test3() {
        MyService3 service = new MyService3();
        MyThreadA2 a2 = new MyThreadA2(service);
        a2.start();
    }

    /**
     * 4.1.4 正确使用Condition 实现等待/通知
     */
    @Test
    public void test4() {
        MyService4 service = new MyService4();
        ThreadA a = new ThreadA(service);
        a.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.signal();
    }

    /**
     * 4.1.6 使用多个Condition 实现通知部分线程
     */
    @Test
    public void test6() throws InterruptedException {
        MyService5 service = new MyService5();
        ThreadA5 a = new ThreadA5(service);
        a.setName("A");
        a.start();

        ThreadB5 b = new ThreadB5(service);
        b.setName("B");
        b.start();
        Thread.sleep(3000);
        service.signalAll_A();
    }

    /**
     * 4.1.7 实现生产消费者模式
     * 4.1.8 多对多交替打印
     */
    @Test
    public void test7() throws InterruptedException {

        MyService6 service = new MyService6();

        ThreadA6[] aa = new ThreadA6[10];
        ThreadB6[] bb = new ThreadB6[10];

        for (int i = 0; i < 10; i++) {
            aa[i] = new ThreadA6(service);
            bb[i] = new ThreadB6(service);

            aa[i].start();
            bb[i].start();
        }
    }
}
