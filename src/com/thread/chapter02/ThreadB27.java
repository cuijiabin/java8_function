package com.thread.chapter02;

public class ThreadB27 extends Thread {
	private Service27 service;

	public ThreadB27(Service27 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.print(new Object());
	}
}
