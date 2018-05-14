package com.thread.chapter01;

public class MyThread9 extends Thread{

    @Override
    public void run() {
        try {
            System.out.println("run theadName="+Thread.currentThread().getName()+" begin");
            Thread.sleep(2000);
            System.out.println("run theadName="+Thread.currentThread().getName()+" end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
