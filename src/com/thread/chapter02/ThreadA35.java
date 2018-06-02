package com.thread.chapter02;

public class ThreadA35 extends Thread {

	private MyService35 service;

	public ThreadA35(MyService35 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod();
	}
}
