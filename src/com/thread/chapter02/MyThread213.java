package com.thread.chapter02;

public class MyThread213 extends Thread {

	private Task13 task;

	public MyThread213(Task13 task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		CommonUtils13.beginTime2 = System.currentTimeMillis();
		task.doLongTimeTask();
		CommonUtils13.endTime2 = System.currentTimeMillis();
	}

}
