package com.thread.chapter02;

public class MyThread116 extends Thread {

	private Task16 task;

	public MyThread116(Task16 task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		task.doLongTimeTask();
	}

}
