package com.thread.chapter02;

public class MyThread111 extends Thread {

	private Task11 task;

	public MyThread111(Task11 task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		CommonUtils11.beginTime1 = System.currentTimeMillis();
		task.doLongTimeTask();
		CommonUtils11.endTime1 = System.currentTimeMillis();
	}

}
