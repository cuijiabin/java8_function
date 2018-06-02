package com.thread.chapter02;

public class Test {

    public static void main(String[] args) {
//        test1();
        test2();
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
}
