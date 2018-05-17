package com.thread.series18;

public class Producer1 {

    private Depot1 depot;

    public Producer1(Depot1 depot) {
        this.depot = depot;
    }

    /**
     * 消费产品：新建一个线程向仓库中生产产品
     *
     * @param val
     */
    public void produce(final int val) {
        new Thread() {
            public void run() {
                depot.produce(val);
            }
        }.start();
    }
}
