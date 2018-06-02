package com.thread.chapter02;

public class ThreadA3 extends Thread {

	private HasSelfPrivateNum3 numRef;

	public ThreadA3(HasSelfPrivateNum3 numRef) {
		super();
		this.numRef = numRef;
	}

	@Override
	public void run() {
		super.run();
		numRef.addI("a");
	}

}
