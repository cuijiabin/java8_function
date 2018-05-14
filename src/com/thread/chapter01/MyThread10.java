package com.thread.chapter01;

public class MyThread10 extends Thread{

    @Override
    public void run() {
        try {
            System.out.println("run theadName="+Thread.currentThread().getName()+" begin "+this.getId());
            Thread.sleep(2000);
            System.out.println("run theadName="+Thread.currentThread().getName()+" end "+this.getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
