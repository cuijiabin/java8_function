package com.thread.chapter04;

public class MyThreadA2 extends Thread {

    private MyService3 service;

    public MyThreadA2(MyService3 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
