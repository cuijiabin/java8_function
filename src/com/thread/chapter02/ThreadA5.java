package com.thread.chapter02;

public class ThreadA5 extends Thread {

	private MyObject5 object;

	public ThreadA5(MyObject5 object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.methodA();
	}

}
