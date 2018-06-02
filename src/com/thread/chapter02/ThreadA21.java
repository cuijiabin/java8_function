package com.thread.chapter02;

public class ThreadA21 extends Thread {

	private Service21 service;
	private MyObject21 object;

	public ThreadA21(Service21 service, MyObject21 object) {
		super();
		this.service = service;
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		service.testMethod1(object);
	}

}
