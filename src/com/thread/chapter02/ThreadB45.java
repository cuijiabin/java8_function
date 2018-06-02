package com.thread.chapter02;

public class ThreadB45 extends Thread {
	private Service45 service;

	public ThreadB45(Service45 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.printB();
	}
}
