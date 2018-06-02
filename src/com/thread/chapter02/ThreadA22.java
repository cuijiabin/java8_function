package com.thread.chapter02;

public class ThreadA22 extends Thread {

	private Service22 service;
	private MyObject22 object;

	public ThreadA22(Service22 service, MyObject22 object) {
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
