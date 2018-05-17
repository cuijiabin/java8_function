package com.thread.series18;

public class Customer1 {
    private Depot1 depot;

    public Customer1(Depot1 depot) {
        this.depot = depot;
    }

    /**
     * 消费产品：新建一个线程从仓库中消费产品。
     * @param val
     */
    public void consume(final int val) {
        new Thread() {
            public void run() {
                depot.consume(val);
            }
        }.start();
    }
}
