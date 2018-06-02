package com.thread.chapter02;

public class MyThread113 extends Thread {

	private Task13 task;

	public MyThread113(Task13 task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		CommonUtils13.beginTime1 = System.currentTimeMillis();
		task.doLongTimeTask();
		CommonUtils13.endTime1 = System.currentTimeMillis();
	}

}
