package com.thread.chapter02;

public class Test {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        ThreadA a = new ThreadA(numRef);
        a.start();

        ThreadB b = new ThreadB(numRef);
        b.start();
    }
}
