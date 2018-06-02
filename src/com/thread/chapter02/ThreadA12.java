package com.thread.chapter02;

public class ThreadA12 extends Thread {

	private ObjectService12 service;

	public ThreadA12(ObjectService12 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.serviceMethod();
	}

}
