package com.thread.chapter02;

public class ThreadA28 extends Thread {

	private Service28 service;

	public ThreadA28(Service28 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodA();
	}

}
