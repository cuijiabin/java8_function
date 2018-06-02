package com.thread.chapter02;

public class Service28 {
	synchronized public void methodA() {
		System.out.println("methodA begin");
		boolean isContinueRun = true;
		while (isContinueRun) {
		}
		System.out.println("methodA end");
	}

	synchronized public void methodB() {
		System.out.println("methodB begin");
		System.out.println("methodB end");
	}
}
