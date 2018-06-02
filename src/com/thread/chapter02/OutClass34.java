package com.thread.chapter02;

public class OutClass34 {
	static class InnerClass1 {
		public void method1(InnerClass2 class2) {
			String threadName = Thread.currentThread().getName();
			synchronized (class2) {
				System.out.println(threadName + " ����InnerClass1���е�method1����");
				for (int i = 0; i < 10; i++) {
					System.out.println("i=" + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {

					}
				}
				System.out.println(threadName + " �뿪InnerClass1���е�method1����");
			}
		}

		public synchronized void method2() {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " ����InnerClass1���е�method2����");
			for (int j = 0; j < 10; j++) {
				System.out.println("j=" + j);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {

				}
			}
			System.out.println(threadName + " �뿪InnerClass1���е�method2����");
		}
	}

	static class InnerClass2 {
		public synchronized void method1() {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " ����InnerClass2���е�method1����");
			for (int k = 0; k < 10; k++) {
				System.out.println("k=" + k);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {

				}
			}
			System.out.println(threadName + " �뿪InnerClass2���е�method1����");
		}
	}
}
