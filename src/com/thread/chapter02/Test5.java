package com.thread.chapter02;

public class Test5 {

    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
//        test6();
//        test7();
//        test8();
//        test9();
//        test10();
    }

    public static void test1() {
    }

    public static void test2(){
        try {
            MyService42 service = new MyService42();

            MyThread42[] array = new MyThread42[5];
            for (int i = 0; i < array.length; i++) {
                array[i] = new MyThread42(service);
            }
            for (int i = 0; i < array.length; i++) {
                array[i].start();
            }
            Thread.sleep(1000);
            System.out.println(service.aiRef.get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void test3(){
        try {
            Service43 service = new Service43();

            ThreadA43 a = new ThreadA43(service);
            a.start();

            Thread.sleep(1000);

            ThreadB43 b = new ThreadB43(service);
            b.start();

            System.out.println("�Ѿ�����ֹͣ�������ˣ�");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void test4() {
        Service44 service = new Service44();

        ThreadA44 a = new ThreadA44(service);
        a.setName("A");
        a.start();

        ThreadB44 b = new ThreadB44(service);
        b.setName("B");
        b.start();

        ThreadC44 c = new ThreadC44(service);
        c.setName("C");
        c.start();
    }

    public static void test5(){
        Service45 service1 = new Service45();
        Service45 service2 = new Service45();

        ThreadA45 a = new ThreadA45(service1);
        a.setName("A");
        a.start();

        ThreadB45 b = new ThreadB45(service2);
        b.setName("B");
        b.start();
    }

    public static void test6(){
    }

    public static void test7() {
    }

    public static void test8() {
    }

    public static void test9() {
    }

    public static void test10(){

    }

}
