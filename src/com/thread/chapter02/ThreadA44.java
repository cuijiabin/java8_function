package com.thread.chapter02;

public class ThreadA44 extends Thread {
	private Service44 service;

	public ThreadA44(Service44 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.printA();
	}

}
