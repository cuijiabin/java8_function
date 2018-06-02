package com.thread.chapter02;

public class ThreadA43 extends Thread {
	private Service43 service;

	public ThreadA43(Service43 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.runMethod();
	}
}
