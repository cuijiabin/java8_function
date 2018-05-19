package com.thread.chapter03;

import java.util.Date;

public class ThreadA extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                if (Tools.tl.get() == null) {
                    Tools.tl.set(new Date());
                }
                System.out.println("A " + Tools.tl.get().getTime());
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
