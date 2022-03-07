package com.thread.series11;

/**
 * @Author: cuijiabin
 * @Date: 2021/8/6 14:37
 */
public class Customer {
    private Depot depot;

    public Customer(Depot depot) {
        this.depot = depot;
    }

    // 消费产品：新建一个线程从仓库中消费产品。
    public void consume(final int val) {
        new Thread(() -> depot.consume(val)).start();
    }
}
