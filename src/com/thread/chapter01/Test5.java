package com.thread.chapter01;

public class Test5 {

    public static void main(String[] args) {

//        testInterrupt();
//        testInterrupt2();
//        testInterrupt3();
//        testInterrupt4();
//        testInterrupt5();
//        testInterrupt6();
//        testInterrupt7();
//        testInterrupt8();
        testInterrupt9();
    }

    public static void testInterrupt() {
        try {
            MyThread11 t = new MyThread11();
            t.start();
            Thread.sleep(5000);
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testInterrupt2() {
        try {
            MyThread11 t = new MyThread11();
            t.start();
            Thread.sleep(1000);
            t.interrupt();
            System.out.println("是否停止1? = " + t.isInterrupted());
            System.out.println("是否停止2? = " + t.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

        System.out.println("end!");
    }

    public static void testInterrupt3() {
        Thread.currentThread().interrupt();
        System.out.println("是否停止1? = " + Thread.interrupted());
        System.out.println("是否停止2? = " + Thread.interrupted());
        System.out.println("end!");
    }

    public static void testInterrupt4() {
        try {
            MyThread12 t = new MyThread12();
            t.start();
            Thread.sleep(1000);
            t.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

        System.out.println("end!");
    }

    public static void testInterrupt5() {
        try {
            MyThread13 t = new MyThread13();
            t.start();
            Thread.sleep(1000);
            t.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

        System.out.println("end!");
    }

    public static void testInterrupt6() {
        try {
            MyThread14 t = new MyThread14();
            t.start();
            Thread.sleep(1000);
            t.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

        System.out.println("end!");
    }

    public static void testInterrupt7() {
        try {
            MyThread15 t = new MyThread15();
            t.start();
            Thread.sleep(4000);
            t.stop();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

        System.out.println("end!");
    }

    public static void testInterrupt8() {
        try {
            SynchronizedObject object = new SynchronizedObject();
            MyThread16 t = new MyThread16(object);
            t.start();
            Thread.sleep(500);
            t.stop();
            System.out.println(object.getUsername() + " " + object.getPassword());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

        System.out.println("end!");
    }


    public static void testInterrupt9() {
        try {
            MyThread17 t = new MyThread17();
            t.start();
            Thread.sleep(300);
            t.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

        System.out.println("end!");
    }
}
