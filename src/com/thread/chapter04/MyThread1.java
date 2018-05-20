package com.thread.chapter04;

public class MyThread1 extends Thread {

    private MyService1 service;

    public MyThread1(MyService1 service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
