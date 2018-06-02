package com.thread.chapter02;

public class OutClass33 {

	static class Inner {
		public void method1() {
			synchronized ("��������") {
				for (int i = 1; i <= 10; i++) {
					System.out.println(Thread.currentThread().getName() + " i="
							+ i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
		}

		public synchronized void method2() {
			for (int i = 11; i <= 20; i++) {
				System.out
						.println(Thread.currentThread().getName() + " i=" + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
		}
	}
}
