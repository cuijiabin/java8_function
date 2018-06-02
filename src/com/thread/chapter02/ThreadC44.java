package com.thread.chapter02;

public class ThreadC44 extends Thread {

	private Service44 service;

	public ThreadC44(Service44 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.printC();
	}
}
