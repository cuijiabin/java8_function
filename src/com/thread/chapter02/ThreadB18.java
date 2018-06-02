package com.thread.chapter02;

public class ThreadB18 extends Thread {

	private Service18 service;

	public ThreadB18(Service18 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.b();

	}

}
