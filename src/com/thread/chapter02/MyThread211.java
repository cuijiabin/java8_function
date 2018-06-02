package com.thread.chapter02;

public class MyThread211 extends Thread {

	private Task11 task;

	public MyThread211(Task11 task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		CommonUtils11.beginTime2 = System.currentTimeMillis();
		task.doLongTimeTask();
		CommonUtils11.endTime2 = System.currentTimeMillis();
	}

}
