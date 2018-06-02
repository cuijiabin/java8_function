package com.thread.chapter02;

public class Main10 {

	synchronized public void serviceMethod() {
		try {
			System.out.println("int main ��һ��sleep begin threadName="
					+ Thread.currentThread().getName() + " time="
					+ System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int main ��һ��sleep   end threadName="
					+ Thread.currentThread().getName() + " time="
					+ System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
