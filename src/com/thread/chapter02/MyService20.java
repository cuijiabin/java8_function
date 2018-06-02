package com.thread.chapter02;

public class MyService20 {

	public MyOneList20 addServiceMethod(MyOneList20 list, String data) {
		try {
			synchronized (list) {
				if (list.getSize() < 1) {
					Thread.sleep(2000);
					list.add(data);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return list;
	}

}
