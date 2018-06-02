package com.thread.chapter02;

public class MyObject4 {

	synchronized public void methodA() {
		try {
			System.out.println("begin methodA threadName="
					+ Thread.currentThread().getName());
			Thread.sleep(5000);
			System.out.println("end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
