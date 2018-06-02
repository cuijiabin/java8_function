package com.thread.chapter02;

public class Service25 {

	public static void printA() {
		synchronized (Service25.class) {
			try {
				System.out.println("�߳�����Ϊ��" + Thread.currentThread().getName()
						+ "��" + System.currentTimeMillis() + "����printA");
				Thread.sleep(3000);
				System.out.println("�߳�����Ϊ��" + Thread.currentThread().getName()
						+ "��" + System.currentTimeMillis() + "�뿪printA");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void printB() {
		synchronized (Service25.class) {
			System.out.println("�߳�����Ϊ��" + Thread.currentThread().getName()
					+ "��" + System.currentTimeMillis() + "����printB");
			System.out.println("�߳�����Ϊ��" + Thread.currentThread().getName()
					+ "��" + System.currentTimeMillis() + "�뿪printB");
		}
	}
}
