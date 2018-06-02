package com.thread.chapter02;

public class ThreadA17 extends Thread {
	private Service17 service;

	public ThreadA17(Service17 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.setUsernamePassword("a", "aa");

	}

}
