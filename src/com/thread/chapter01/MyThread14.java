package com.thread.chapter01;

public class MyThread14 extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止！进入catch了！ "+this.isInterrupted());
            e.printStackTrace();
        }
    }
}
