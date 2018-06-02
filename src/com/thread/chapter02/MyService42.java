package com.thread.chapter02;

import java.util.concurrent.atomic.AtomicLong;

public class MyService42 {

	public static AtomicLong aiRef = new AtomicLong();

	synchronized public void addNum() {
		System.out.println(Thread.currentThread().getName() + "����100֮���ֵ��:"
				+ aiRef.addAndGet(100));
		aiRef.addAndGet(1);
	}

}
