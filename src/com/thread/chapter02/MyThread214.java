package com.thread.chapter02;

public class MyThread214 extends Thread {

	private Task14 task;

	public MyThread214(Task14 task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		task.doLongTimeTask();
	}

}
