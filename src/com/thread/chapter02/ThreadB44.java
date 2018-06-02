package com.thread.chapter02;

public class ThreadB44 extends Thread {
	private Service44 service;

	public ThreadB44(Service44 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.printB();
	}
}
