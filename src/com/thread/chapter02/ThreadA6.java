package com.thread.chapter02;

public class ThreadA6 extends Thread {

	private PublicVar6 publicVar;

	public ThreadA6(PublicVar6 publicVar) {
		super();
		this.publicVar = publicVar;
	}

	@Override
	public void run() {
		super.run();
		publicVar.setValue("B", "BB");
	}
}
