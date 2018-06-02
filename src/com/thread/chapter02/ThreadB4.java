package com.thread.chapter02;

public class ThreadB4 extends Thread {

	private MyObject4 object;

	public ThreadB4(MyObject4 object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.methodA();
	}
}
