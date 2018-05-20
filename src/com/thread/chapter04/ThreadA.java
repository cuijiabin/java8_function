package com.thread.chapter04;

public class ThreadA extends Thread {

    private MyService4 service;

    public ThreadA(MyService4 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
