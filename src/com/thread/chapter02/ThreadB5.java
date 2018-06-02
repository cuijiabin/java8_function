package com.thread.chapter02;

public class ThreadB5 extends Thread {

	private MyObject5 object;

	public ThreadB5(MyObject5 object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.methodB();
	}
}
