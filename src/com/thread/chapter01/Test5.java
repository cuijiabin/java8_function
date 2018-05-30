package com.thread.chapter01;

/**
 * 停止线程
 */
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

class MyThread11 extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}

class MyThread12 extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (this.isInterrupted()) {
                System.out.println("已经是停止状态了！我要退出了！");
                break;
            }
            System.out.println("i=" + (i + 1));
        }

        System.out.println("我被输出，如果此代码是for又继续运行，线程并未停止！");
    }
}

class MyThread13 extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("已经是停止状态了！我要退出了！");

                    throw new InterruptedException("中断线程异常");
                }
                System.out.println("i=" + (i + 1));
            }

            System.out.println("我被输出，如果此代码是for又继续运行，线程并未停止！");
        } catch (InterruptedException e) {
            System.out.println("进MyThread.java类run方法中的catch了！");
            e.printStackTrace();
        }
    }
}

class MyThread14 extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止！进入catch了！ " + this.isInterrupted());
            e.printStackTrace();
        }
    }
}

class MyThread15 extends Thread {

    private int i = 0;

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止！进入catch了！ " + this.isInterrupted());
            e.printStackTrace();
        }
    }
}

class SynchronizedObject {
    private String username = "a";
    private String password = "aa";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    synchronized public void printString(String username, String password) {

        try {
            this.username = username;
            Thread.sleep(100000);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread16 extends Thread {

    private SynchronizedObject object;

    public MyThread16(SynchronizedObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        object.printString("b", "bb");
    }
}

class MyThread17 extends Thread {

    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("停止了");
                return;
            }

            System.out.println("timer=" + System.currentTimeMillis());
        }
    }
}
