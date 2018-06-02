package com.thread.chapter02;

public class ThreadA25 extends Thread {
	private Service25 service;

	public ThreadA25(Service25 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.printA();
	}
}
