package com.thread.chapter02;

public class MyThread8 extends Thread {
	@Override
	public void run() {
		Sub8 sub = new Sub8();
		sub.operateISubMethod();
	}

}
