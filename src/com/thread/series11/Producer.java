package com.thread.series11;

/**
 * @Author: cuijiabin
 * @Date: 2021/8/6 14:36
 */
public class Producer {
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    // 消费产品：新建一个线程向仓库中生产产品。
    public void produce(final int val) {
        new Thread(() -> depot.produce(val)).start();
    }
}
