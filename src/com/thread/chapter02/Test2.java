package com.thread.chapter02;

public class Test2 {

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
        Task11 task = new Task11();

        MyThread111 thread1 = new MyThread111(task);
        thread1.start();

        MyThread211 thread2 = new MyThread211(task);
        thread2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long beginTime = CommonUtils11.beginTime1;
        if (CommonUtils11.beginTime2 < CommonUtils11.beginTime1) {
            beginTime = CommonUtils11.beginTime2;
        }

        long endTime = CommonUtils11.endTime1;
        if (CommonUtils11.endTime2 > CommonUtils11.endTime1) {
            endTime = CommonUtils11.endTime2;
        }

        System.out.println("��ʱ��" + ((endTime - beginTime) / 1000));
    }

    public static void test2() {
        ObjectService12 service = new ObjectService12();

        ThreadA12 a = new ThreadA12(service);
        a.setName("a");
        a.start();

        ThreadB12 b = new ThreadB12(service);
        b.setName("b");
        b.start();
    }

    public static void test3() {
        Task13 task = new Task13();

        MyThread113 thread1 = new MyThread113(task);
        thread1.start();

        MyThread213 thread2 = new MyThread213(task);
        thread2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long beginTime = CommonUtils13.beginTime1;
        if (CommonUtils13.beginTime2 < CommonUtils13.beginTime1) {
            beginTime = CommonUtils13.beginTime2;
        }

        long endTime = CommonUtils13.endTime1;
        if (CommonUtils13.endTime2 > CommonUtils13.endTime1) {
            endTime = CommonUtils13.endTime2;
        }

        System.out.println("��ʱ��" + ((endTime - beginTime) / 1000));
    }

    public static void test4() {
        Task14 task = new Task14();

        MyThread114 thread1 = new MyThread114(task);
        thread1.start();

        MyThread214 thread2 = new MyThread214(task);
        thread2.start();
    }

    public static void test5() {
        ObjectService15 service = new ObjectService15();

        ThreadA15 a = new ThreadA15(service);
        a.setName("a");
        a.start();

        ThreadB15 b = new ThreadB15(service);
        b.setName("b");
        b.start();
    }

    public static void test6() throws InterruptedException {
        Task16 task = new Task16();

        MyThread116 thread1 = new MyThread116(task);
        thread1.start();

        Thread.sleep(100);

        MyThread216 thread2 = new MyThread216(task);
        thread2.start();
    }

    public static void test7() {
        Service17 service = new Service17();

        ThreadA17 a = new ThreadA17(service);
        a.setName("A");
        a.start();

        ThreadB17 b = new ThreadB17(service);
        b.setName("B");
        b.start();
    }

    public static void test8() {
        Service18 service = new Service18();

        ThreadA18 a = new ThreadA18(service);
        a.setName("A");
        a.start();

        ThreadB18 b = new ThreadB18(service);
        b.setName("B");
        b.start();
    }

    public static void test9() {
        MyList19 mylist = new MyList19();

        MyThreadA19 a = new MyThreadA19(mylist);
        a.setName("A");
        a.start();

        MyThreadB19 b = new MyThreadB19(mylist);
        b.setName("B");
        b.start();
    }

    public static void test10() throws InterruptedException {
        MyOneList20 list = new MyOneList20();

        MyThread120 thread1 = new MyThread120(list);
        thread1.setName("A");
        thread1.start();

        MyThread220 thread2 = new MyThread220(list);
        thread2.setName("B");
        thread2.start();

        Thread.sleep(6000);

        System.out.println("listSize=" + list.getSize());

    }

}
