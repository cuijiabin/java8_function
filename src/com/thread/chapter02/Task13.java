package com.thread.chapter02;

public class Task13 {

	private String getData1;
	private String getData2;

	public void doLongTimeTask() {
		try {
			System.out.println("begin task");
			Thread.sleep(3000);

			String privateGetData1 = "��ʱ�䴦��������Զ�̷��ص�ֵ1 threadName="
					+ Thread.currentThread().getName();
			String privateGetData2 = "��ʱ�䴦��������Զ�̷��ص�ֵ2 threadName="
					+ Thread.currentThread().getName();

			synchronized (this) {
				getData1 = privateGetData1;
				getData2 = privateGetData2;
			}
			
			System.out.println(getData1);
			System.out.println(getData2);
			System.out.println("end task");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
