package com.thread.chapter02;

public class ThreadB3 extends Thread {

	private HasSelfPrivateNum3 numRef;

	public ThreadB3(HasSelfPrivateNum3 numRef) {
		super();
		this.numRef = numRef;
	}

	@Override
	public void run() {
		super.run();
		numRef.addI("b");
	}

}
