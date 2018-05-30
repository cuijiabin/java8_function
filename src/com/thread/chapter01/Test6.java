package com.thread.chapter01;

/**
 * 暂停线程
 */
public class Test6 {

    public static void main(String[] args) {
//        testPause1();
//        testPause2();
//        testPause3();
        testPause4();
    }

    public static void testPause1() {
        try {
            MyThread18 t = new MyThread18();
            t.start();
            Thread.sleep(5000);

            // A段
            t.suspend();
            System.out.println("A=" + System.currentTimeMillis() + "i = " + t.getI());
            Thread.sleep(5000);
            System.out.println("A=" + System.currentTimeMillis() + "i = " + t.getI());

            // B段
            t.resume();
            Thread.sleep(5000);

            // C段
            t.suspend();
            System.out.println("B=" + System.currentTimeMillis() + "i = " + t.getI());
            Thread.sleep(5000);
            System.out.println("B=" + System.currentTimeMillis() + "i = " + t.getI());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testPause2() {
        try {
            final SynchronizedObject2 object = new SynchronizedObject2();
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    object.printString();
                }
            };

            t1.setName("a");
            t1.start();
            Thread.sleep(1000);

            Thread t2 = new Thread() {
                @Override
                public void run() {
                    System.out.println("t2启动了，但是进入不了printString()方法");
                    System.out.println("因为printString()被a线程锁定 并且永远suspend了");
                    object.printString();
                }
            };
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void testPause3() {
        try {
            MyThread19 t = new MyThread19();
            t.start();
            Thread.sleep(1000);
            t.suspend();
            System.out.println("main end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testPause4() {
        try {
            final MyObject object = new MyObject();
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    object.setValue("a", "aa");
                }
            };

            t1.setName("a");
            t1.start();
            Thread.sleep(500);

            Thread t2 = new Thread() {
                @Override
                public void run() {
                    object.printValue();
                }
            };
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyObject {
    private String username = "1";
    private String password = "11";

    public void setValue(String username, String password) {
        this.username = username;
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("停止a线程");
            Thread.currentThread().suspend();
        }
        this.password = password;
    }

    public void printValue() {
        System.out.println(username + " -> " + password);
    }
}

class SynchronizedObject2 {

    synchronized public void printString() {
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a线程永远 suspend了！");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}

class MyThread18 extends Thread {

    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }
}

class MyThread19 extends Thread {

    private long i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println(i);
        }
    }
}
