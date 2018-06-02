package com.thread.chapter02;

public class ThreadB15 extends Thread {
	private ObjectService15 service;

	public ThreadB15(ObjectService15 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.serviceMethodB();
	}
}
