package com.thread.chapter02;

public class MyThread120 extends Thread {

	private MyOneList20 list;

	public MyThread120(MyOneList20 list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		MyService20 msRef = new MyService20();
		msRef.addServiceMethod(list, "A");
	}

}
