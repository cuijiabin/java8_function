package com.thread.chapter02;

public class MyThread42 extends Thread {
	private MyService42 mySerivce;

	public MyThread42(MyService42 mySerivce) {
		super();
		this.mySerivce = mySerivce;
	}

	@Override
	public void run() {
		mySerivce.addNum();
	}

}
