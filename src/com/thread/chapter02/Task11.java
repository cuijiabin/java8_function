package com.thread.chapter02;

public class Task11 {

	private String getData1;
	private String getData2;

	public synchronized void doLongTimeTask() {
		try {
			System.out.println("begin task");
			Thread.sleep(3000);
			getData1 = "��ʱ�䴦��������Զ�̷��ص�ֵ1 threadName="
					+ Thread.currentThread().getName();
			getData2 = "��ʱ�䴦��������Զ�̷��ص�ֵ2 threadName="
					+ Thread.currentThread().getName();
			System.out.println(getData1);
			System.out.println(getData2);
			System.out.println("end task");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
