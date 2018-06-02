package com.thread.chapter02;

public class MyThread7 extends Thread {
	@Override
	public void run() {
		Service7 service = new Service7();
		service.service1();
	}

}
