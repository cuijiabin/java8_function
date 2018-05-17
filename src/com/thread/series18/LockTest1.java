package com.thread.series18;

public class LockTest1 {

    public static void main(String[] args) {
        Depot1 mDepot = new Depot1();
        Producer1 mPro = new Producer1(mDepot);
        Customer1 mCus = new Customer1(mDepot);

        mPro.produce(60);
        mPro.produce(120);

        mCus.consume(90);
        mCus.consume(150);

        mPro.produce(110);
    }
}
