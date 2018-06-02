package com.thread.chapter02;

public class Test3 {

    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        test9();
        test10();
    }

    public static void test1() {
//        Service21 service = new Service21();
//        MyObject21 object = new MyObject21();
//
//        ThreadA21 a = new ThreadA21(service, object);
//        a.setName("a");
//        a.start();
//
//        ThreadB21 b = new ThreadB21(service, object);
//        b.setName("b");
//        b.start();

        //==================================
        Service21 service = new Service21();
        MyObject21 object1 = new MyObject21();
        MyObject21 object2 = new MyObject21();

        ThreadA21 a = new ThreadA21(service, object1);
        a.setName("a");
        a.start();

        ThreadB21 b = new ThreadB21(service, object2);
        b.setName("b");
        b.start();
    }

    public static void test2() throws InterruptedException {
        Service22 service = new Service22();
        MyObject22 object = new MyObject22();

        ThreadA22 a = new ThreadA22(service, object);
        a.setName("a");
        a.start();

        Thread.sleep(100);

        ThreadB22 b = new ThreadB22(object);
        b.setName("b");
        b.start();
    }

    public static void test3() throws InterruptedException {
        Service23 service = new Service23();
        MyObject23 object = new MyObject23();

        ThreadA23 a = new ThreadA23(service, object);
        a.setName("a");
        a.start();

        Thread.sleep(100);

        ThreadB23 b = new ThreadB23(object);
        b.setName("b");
        b.start();
    }

    public static void test4() {
        ThreadA24 a = new ThreadA24();
        a.setName("A");
        a.start();

        ThreadB24 b = new ThreadB24();
        b.setName("B");
        b.start();
    }

    public static void test5() {
        Service25 service1 = new Service25();
        Service25 service2 = new Service25();

        ThreadA25 a = new ThreadA25(service1);
        a.setName("A");
        a.start();

        ThreadB25 b = new ThreadB25(service2);
        b.setName("B");
        b.start();
    }

    public static void test6() {
        Service26 service = new Service26();

        ThreadA26 a = new ThreadA26(service);
        a.setName("A");
        a.start();

        ThreadB26 b = new ThreadB26(service);
        b.setName("B");
        b.start();
    }

    public static void test7() {
        Service27 service = new Service27();

        ThreadA27 a = new ThreadA27(service);
        a.setName("A");
        a.start();

        ThreadB27 b = new ThreadB27(service);
        b.setName("B");
        b.start();
    }

    public static void test8() {
        Service28 service = new Service28();

        ThreadA28 athread = new ThreadA28(service);
        athread.start();

        ThreadB28 bthread = new ThreadB28(service);
        bthread.start();
    }

    public static void test9() {
        Service29 service = new Service29();

        ThreadA29 athread = new ThreadA29(service);
        athread.start();

        ThreadB29 bthread = new ThreadB29(service);
        bthread.start();
    }

    public static void test10() {
        try {
            DealThread30 t1 = new DealThread30();
            t1.setFlag("a");

            Thread thread1 = new Thread(t1);
            thread1.start();

            Thread.sleep(100);

            t1.setFlag("b");
            Thread thread2 = new Thread(t1);
            thread2.start();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
