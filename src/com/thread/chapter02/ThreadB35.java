package com.thread.chapter02;

public class ThreadB35 extends Thread {

	private MyService35 service;

	public ThreadB35(MyService35 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod();
	}
}
