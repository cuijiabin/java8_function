package com.thread.chapter01;

public class MyThread11 extends Thread{

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50000; i++) {
            System.out.println("i=" + (i+1));
        }
    }
}
