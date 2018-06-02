package com.thread.chapter02;

public class ThreadB28 extends Thread {

	private Service28 service;

	public ThreadB28(Service28 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodB();
	}

}
