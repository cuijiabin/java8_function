package com.thread.chapter02;

public class ThreadB17 extends Thread {

	private Service17 service;

	public ThreadB17(Service17 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.setUsernamePassword("b", "bb");

	}

}
