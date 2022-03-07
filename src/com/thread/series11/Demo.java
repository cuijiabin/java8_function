package com.thread.series11;

/**
 * @Describe 生产消费者模型之 wait()/notify() 实现 缺点：生产的时候不能消费、消费的时候不能生产
 * @Author: cuijiabin
 * @Date: 2021/8/6 14:32
 */
public class Demo {

    public static void main(String[] args) {
        Depot depot = new Depot(100);
        Producer producer = new Producer(depot);
        Customer customer = new Customer(depot);

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                producer.produce(60);
                customer.consume(110);
            } else {
                producer.produce(110);
                customer.consume(60);
            }
        }
    }
}
