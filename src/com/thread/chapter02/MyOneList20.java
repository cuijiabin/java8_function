package com.thread.chapter02;

import java.util.ArrayList;
import java.util.List;

public class MyOneList20 {

	private List list = new ArrayList();

	synchronized public void add(String data) {
		list.add(data);
	};

	synchronized public int getSize() {
		return list.size();
	};

}
