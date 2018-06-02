package com.thread.chapter02;

public class ThreadB25 extends Thread {
	private Service25 service;

	public ThreadB25(Service25 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.printB();
	}
}
