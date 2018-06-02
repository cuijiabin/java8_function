package com.thread.chapter02;

public class ThreadA36 extends Thread {

	private Service36 service;
	private Userinfo36 userinfo;

	public ThreadA36(Service36 service,
					 Userinfo36 userinfo) {
		super();
		this.service = service;
		this.userinfo = userinfo;
	}

	@Override
	public void run() {
		service.serviceMethodA(userinfo);
	}

}
