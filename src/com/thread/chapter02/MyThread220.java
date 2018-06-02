package com.thread.chapter02;

public class MyThread220 extends Thread {

	private MyOneList20 list;

	public MyThread220(MyOneList20 list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		MyService20 msRef = new MyService20();
		msRef.addServiceMethod(list, "B");
	}

}