package com.thread.chapter04;

public class MyThreadA extends Thread {

    private MyService2 service;

    public MyThreadA(MyService2 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.methodA();
    }
}
