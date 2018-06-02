package com.thread.chapter02;

public class ThreadA23 extends Thread {

	private Service23 service;
	private MyObject23 object;

	public ThreadA23(Service23 service, MyObject23 object) {
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
