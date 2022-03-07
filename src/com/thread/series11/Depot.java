package com.thread.series11;

/**
 * @Author: cuijiabin
 * @Date: 2021/8/6 14:36
 */
public class Depot {

    // 仓库的容量
    private int capacity;

    // 仓库的实际数量
    private int qty;

    public Depot(int capacity) {
        this.capacity = capacity;
        this.qty = 0;
    }

    public synchronized void produce(int val) {
        try {
            // left 表示“想要生产的数量”(有可能生产量太多，需多次生产)
            int left = val;
            while (left > 0) {
                // 库存已满时，等待“消费者”消费产品。
                while (qty >= capacity) {
                    wait();
                }
                // 获取“实际生产的数量”(即库存中新增的数量)
                // 如果“库存”+“想要生产的数量”>“总的容量”，则“实际增量”=“总的容量”-“当前容量”。(此时填满仓库)
                // 否则“实际增量”=“想要生产的数量”
                int inc = (qty + left) > capacity ? (capacity - qty) : left;
                qty += inc;
                left -= inc;
                System.out.printf("线程 %s 生产任务(%3d) 本次生产(%3d) --> 未完成生产=%3d, 实际生产=%3d, 生产后库存=%3d\n",
                        Thread.currentThread().getName(), val, left + inc, left, inc, qty);
                // 通知“消费者”可以消费了。
                notifyAll();
            }

            System.out.println("线程 " + Thread.currentThread().getName() + " 生产结束");
        } catch (InterruptedException e) {

        }
    }

    public synchronized void consume(int val) {
        try {
            // left 表示“客户要消费数量”(有可能消费量太大，库存不够，需多次消费)
            int left = val;
            while (left > 0) {
                // 库存为0时，等待“生产者”生产产品。
                while (qty <= 0) {
                    wait();
                }
                // 获取“实际消费的数量”(即库存中实际减少的数量)
                // 如果“库存”<“客户要消费的数量”，则“实际消费量”=“库存”；
                // 否则，“实际消费量”=“客户要消费的数量”。
                int dec = (qty < left) ? qty : left;
                qty -= dec;
                left -= dec;
                System.out.printf("线程 %s 消费任务(%3d) 本次消费(%3d) <-- 未完成消费=%3d, 实际消费=%3d, 消费后库存=%3d\n",
                        Thread.currentThread().getName(), val, left + dec, left, dec, qty);
                notifyAll();
            }

            System.out.println("线程 " + Thread.currentThread().getName() + " 消费结束");
        } catch (InterruptedException e) {
        }
    }

    public String toString() {
        return "容量:" + capacity + ", 实际库存:" + qty;
    }
}
