package com.thread.chapter02;

public class ThreadB23 extends Thread {
	private MyObject23 object;

	public ThreadB23(MyObject23 object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.speedPrintString();
	}
}
