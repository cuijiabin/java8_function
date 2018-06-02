package com.thread.chapter02;

public class ThreadA2 extends Thread {

    private HasSelfPrivateNum2 numRef;

    public ThreadA2(HasSelfPrivateNum2 numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }

}
