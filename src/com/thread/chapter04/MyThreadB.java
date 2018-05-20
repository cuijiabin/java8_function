package com.thread.chapter04;

public class MyThreadB extends Thread {

    private MyService2 service;

    public MyThreadB(MyService2 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.methodB();
    }
}
