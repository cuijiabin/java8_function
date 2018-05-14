package com.thread.chapter01;

public class MyThread16 extends Thread {

    private SynchronizedObject object;

    public MyThread16(SynchronizedObject object){
        super();
        this.object = object;
    }
    @Override
    public void run() {
        object.printString("b","bb");
    }
}
