package com.thread.chapter02;

public class ThreadA4 extends Thread {

	private MyObject4 object;

	public ThreadA4(MyObject4 object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.methodA();
	}

}
