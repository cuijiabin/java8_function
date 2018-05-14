package com.thread.chapter01;

public class MyThread8 extends Thread{

    @Override
    public void run() {
        System.out.println("run = "+this.isAlive());
    }
}
