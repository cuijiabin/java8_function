package com.thread.chapter02;

public class MyThread216 extends Thread {

	private Task16 task;

	public MyThread216(Task16 task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		task.otherMethod();
	}

}
