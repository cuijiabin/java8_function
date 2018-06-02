package com.thread.chapter02;

public class ThreadB21 extends Thread {
	private Service21 service;
	private MyObject21 object;

	public ThreadB21(Service21 service, MyObject21 object) {
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
