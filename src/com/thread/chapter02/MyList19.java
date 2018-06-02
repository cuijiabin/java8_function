package com.thread.chapter02;

import java.util.ArrayList;
import java.util.List;

public class MyList19 {

	private List list = new ArrayList();

	synchronized public void add(String username) {
		System.out.println("ThreadName=" + Thread.currentThread().getName()
				+ "ִ����add������");
		list.add(username);
		System.out.println("ThreadName=" + Thread.currentThread().getName()
				+ "�˳���add������");
	}

	synchronized public int getSize() {
		System.out.println("ThreadName=" + Thread.currentThread().getName()
				+ "ִ����getSize������");
		int sizeValue = list.size();
		System.out.println("ThreadName=" + Thread.currentThread().getName()
				+ "�˳���getSize������");
		return sizeValue;
	}

}
