package com.thread.chapter01;

public class MyThread22 extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread22 run priority=" + this.getPriority());
    }
}
