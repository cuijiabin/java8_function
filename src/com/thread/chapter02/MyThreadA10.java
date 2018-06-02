package com.thread.chapter02;

public class MyThreadA10 extends Thread {

	private Sub10 sub;

	public MyThreadA10(Sub10 sub) {
		super();
		this.sub = sub;
	}

	@Override
	public void run() {
		sub.serviceMethod();
	}

}
