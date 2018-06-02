package com.thread.chapter02;

public class ThreadB29 extends Thread {

	private Service29 service;

	public ThreadB29(Service29 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodB();
	}

}
