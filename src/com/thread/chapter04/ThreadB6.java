package com.thread.chapter04;

public class ThreadB6 extends Thread {

    private MyService6 service;

    public ThreadB6(MyService6 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.get();
    }
}
