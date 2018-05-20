package com.thread.chapter04;

public class ThreadB5 extends Thread {

    private MyService5 service;

    public ThreadB5(MyService5 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}
