package com.thread.chapter02;

public class ThreadB22 extends Thread {
	private MyObject22 object;

	public ThreadB22(MyObject22 object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.speedPrintString();
	}
}
