package com.thread.chapter02;

public class ThreadA9 extends Thread {

	private Service9 service;

	public ThreadA9(Service9 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod();
	}

}
