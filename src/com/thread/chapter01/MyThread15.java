package com.thread.chapter01;

public class MyThread15 extends Thread {

    private int i = 0;

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止！进入catch了！ " + this.isInterrupted());
            e.printStackTrace();
        }
    }
}
