package com.thread.chapter02;

public class Test {

    public static void main(String[] args) {
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
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        ThreadA a = new ThreadA(numRef);
        a.start();

        ThreadB b = new ThreadB(numRef);
        b.start();
    }

    public static void test2() {
        HasSelfPrivateNum2 numRef = new HasSelfPrivateNum2();

        ThreadA2 athread = new ThreadA2(numRef);
        athread.start();

        ThreadB2 bthread = new ThreadB2(numRef);
        bthread.start();
    }

    public static void test3() {
        HasSelfPrivateNum3 numRef1 = new HasSelfPrivateNum3();
        HasSelfPrivateNum3 numRef2 = new HasSelfPrivateNum3();

        ThreadA3 athread = new ThreadA3(numRef1);
        athread.start();

        ThreadB3 bthread = new ThreadB3(numRef2);
        bthread.start();
    }

    public static void test4() {
        MyObject4 object = new MyObject4();
        ThreadA4 a = new ThreadA4(object);
        a.setName("A");
        ThreadB4 b = new ThreadB4(object);
        b.setName("B");

        a.start();
        b.start();
    }

    public static void test5() {
        MyObject5 object = new MyObject5();
        ThreadA5 a = new ThreadA5(object);
        a.setName("A");
        ThreadB5 b = new ThreadB5(object);
        b.setName("B");

        a.start();
        b.start();
    }

    public static void test6() {
        try {
            PublicVar6 publicVarRef = new PublicVar6();
            ThreadA6 thread = new ThreadA6(publicVarRef);
            thread.start();

            Thread.sleep(200);// ��ӡ����ܴ�ֵ��СӰ��

            publicVarRef.getValue();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void test7() {
        MyThread7 t = new MyThread7();
        t.start();
    }

    public static void test8() {
        MyThread8 t = new MyThread8();
        t.start();
    }

    public static void test9() {
        try {
            Service9 service = new Service9();

            ThreadA9 a = new ThreadA9(service);
            a.setName("a");
            a.start();

            Thread.sleep(500);

            ThreadB9 b = new ThreadB9(service);
            b.setName("b");
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test10() {
        Sub10 subRef = new Sub10();

        MyThreadA10 a = new MyThreadA10(subRef);
        a.setName("A");
        a.start();

        MyThreadB10 b = new MyThreadB10(subRef);
        b.setName("B");
        b.start();
    }
}
