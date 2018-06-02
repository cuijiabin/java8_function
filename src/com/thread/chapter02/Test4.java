package com.thread.chapter02;

import static java.lang.Thread.*;

public class Test4 {

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
        PublicClass31 publicClass = new PublicClass31();
        publicClass.setUsername("usernameValue");
        publicClass.setPassword("passwordValue");

        System.out.println(publicClass.getUsername() + " "
                + publicClass.getPassword());

        PublicClass31.PrivateClass privateClass = publicClass.new PrivateClass();
        privateClass.setAge("ageValue");
        privateClass.setAddress("addressValue");

        System.out.println(privateClass.getAge() + " "
                + privateClass.getAddress());
    }

    public static void test2(){
        PublicClass32 publicClass = new PublicClass32();
        publicClass.setUsername("usernameValue");
        publicClass.setPassword("passwordValue");

        System.out.println(publicClass.getUsername() + " "
                + publicClass.getPassword());

        PublicClass32.PrivateClass privateClass = new PublicClass32.PrivateClass();
        privateClass.setAge("ageValue");
        privateClass.setAddress("addressValue");

        System.out.println(privateClass.getAge() + " "
                + privateClass.getAddress());
    }

    public static void test3(){
        final OutClass33.Inner inner = new OutClass33.Inner();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                inner.method1();
            }
        }, "A");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                inner.method2();
            }
        }, "B");

        t1.start();
        t2.start();
    }

    public static void test4() {
        final OutClass34.InnerClass1 in1 = new OutClass34.InnerClass1();
        final OutClass34.InnerClass2 in2 = new OutClass34.InnerClass2();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                in1.method1(in2);
            }
        }, "T1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                in1.method2();
            }
        }, "T2");
        // //
        // //
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                in2.method1();
            }
        }, "T3");
        t1.start();
        t2.start();
        t3.start();
    }

    public static void test5() throws InterruptedException {

        MyService35 service = new MyService35();

        ThreadA35 a = new ThreadA35(service);
        a.setName("A");

        ThreadB35 b = new ThreadB35(service);
        b.setName("B");

        a.start();
        sleep(50);
        b.start();

//        MyService35 service = new MyService35();
//
//        ThreadA35 a = new ThreadA35(service);
//        a.setName("A");
//
//        ThreadB35 b = new ThreadB35(service);
//        b.setName("B");
//
//        a.start();
//        b.start();

    }

    public static void test6(){
        try {
            Service36 service = new Service36();
            Userinfo36 userinfo = new Userinfo36();

            ThreadA36 a = new ThreadA36(service, userinfo);
            a.setName("a");
            a.start();
            Thread.sleep(50);
            ThreadB36 b = new ThreadB36(service, userinfo);
            b.setName("b");
            b.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test7() {
        PrintString37 printStringService = new PrintString37();
        printStringService.printStringMethod();
        System.out.println("��Ҫֹͣ����stopThread="
                + Thread.currentThread().getName());
        printStringService.setContinuePrint(false);
    }

    public static void test8() {
        PrintString38 printStringService = new PrintString38();
        new Thread(printStringService).start();

        System.out.println("��Ҫֹͣ����stopThread="
                + Thread.currentThread().getName());
        printStringService.setContinuePrint(false);
    }

    public static void test9() {
        try {
            RunThread39 thread = new RunThread39();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
            System.out.println("�Ѿ���ֵΪfalse");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void test10(){
        MyThread40[] mythreadArray = new MyThread40[100];
        for (int i = 0; i < 100; i++) {
            mythreadArray[i] = new MyThread40();
        }

        for (int i = 0; i < 100; i++) {
            mythreadArray[i].start();
        }
    }

}
