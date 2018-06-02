package com.thread.chapter02;

public class MyThreadA19 extends Thread {

	private MyList19 list;

	public MyThreadA19(MyList19 list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			list.add("threadA" + (i + 1));
		}
	}

}
