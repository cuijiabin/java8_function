package com.thread.chapter02;

public class Service44 {

	synchronized public static void printA() {
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

	synchronized public static void printB() {
		System.out.println("�߳�����Ϊ��" + Thread.currentThread().getName() + "��"
				+ System.currentTimeMillis() + "����printB");
		System.out.println("�߳�����Ϊ��" + Thread.currentThread().getName() + "��"
				+ System.currentTimeMillis() + "�뿪printB");
	}

	synchronized public void printC() {
		System.out.println("�߳�����Ϊ��" + Thread.currentThread().getName() + "��"
				+ System.currentTimeMillis() + "����printC");
		System.out.println("�߳�����Ϊ��" + Thread.currentThread().getName() + "��"
				+ System.currentTimeMillis() + "�뿪printC");
	}

}
