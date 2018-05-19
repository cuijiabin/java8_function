package com.thread.chapter03;

public class ThreadA2 extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在ThreadA线程中取值 " + Tools2.tl.get());
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
