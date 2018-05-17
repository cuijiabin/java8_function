package com.thread.series18;

public class LockTest2 {

    public static void main(String[] args) {

        Depot2 mDepot = new Depot2(100);
        Producer2 mPro = new Producer2(mDepot);
        Customer2 mCus = new Customer2(mDepot);

        mPro.produce(60);
        mPro.produce(120);

        mCus.consume(90);
        mCus.consume(150);

        mPro.produce(110);
    }
}
