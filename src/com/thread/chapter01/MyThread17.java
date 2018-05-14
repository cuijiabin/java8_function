package com.thread.chapter01;

public class MyThread17 extends Thread {

    @Override
    public void run() {
        while (true){
            if(this.isInterrupted()){
                System.out.println("停止了");
                return;
            }

            System.out.println("timer="+System.currentTimeMillis());
        }
    }
}
