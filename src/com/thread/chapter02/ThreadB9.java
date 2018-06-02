package com.thread.chapter02;

public class ThreadB9 extends Thread {
	private Service9 service;

	public ThreadB9(Service9 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod();
	}

}
