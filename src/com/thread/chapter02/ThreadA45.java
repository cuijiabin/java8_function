package com.thread.chapter02;

public class ThreadA45 extends Thread {
	private Service45 service;

	public ThreadA45(Service45 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.printA();
	}
}
