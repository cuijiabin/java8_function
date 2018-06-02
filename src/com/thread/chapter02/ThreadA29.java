package com.thread.chapter02;

public class ThreadA29 extends Thread {

	private Service29 service;

	public ThreadA29(Service29 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodA();
	}

}
