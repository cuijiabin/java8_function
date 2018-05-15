package com.thread.chapter01;

import java.util.Random;

public class MyThread27 extends Thread {

    private int i = 0;
    @Override
    public void run() {
        try {
            while (true){
                i ++;
                System.out.println("i = "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
