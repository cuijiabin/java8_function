package com.thread.chapter02;

public class ThreadA18 extends Thread {
	private Service18 service;

	public ThreadA18(Service18 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.a();

	}

}
