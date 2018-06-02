package com.thread.chapter02;

public class ThreadB43 extends Thread {
	private Service43 service;

	public ThreadB43(Service43 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.stopMethod();
	}

}
