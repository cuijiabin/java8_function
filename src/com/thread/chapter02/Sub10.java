package com.thread.chapter02;

public class Sub10 extends Main10 {

	@Override
	synchronized public void serviceMethod() {
		try {
			System.out.println("int sub ��һ��sleep begin threadName="
					+ Thread.currentThread().getName() + " time="
					+ System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int sub ��һ��sleep   end threadName="
					+ Thread.currentThread().getName() + " time="
					+ System.currentTimeMillis());
			super.serviceMethod();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
