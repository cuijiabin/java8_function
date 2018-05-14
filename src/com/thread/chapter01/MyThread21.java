package com.thread.chapter01;

public class MyThread21 extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread21 run priority=" + this.getPriority());
        MyThread22 t2 = new MyThread22();
        t2.start();
    }
}
