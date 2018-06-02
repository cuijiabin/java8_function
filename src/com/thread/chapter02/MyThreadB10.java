package com.thread.chapter02;

public class MyThreadB10 extends Thread {

	private Sub10 sub;

	public MyThreadB10(Sub10 sub) {
		super();
		this.sub = sub;
	}

	@Override
	public void run() {
		sub.serviceMethod();
	}
}
