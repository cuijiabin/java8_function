package com.thread.chapter02;

public class Service17 {

	private String usernameParam;
	private String passwordParam;

	public void setUsernamePassword(String username, String password) {
		try {
			String anyString = new String();
			synchronized (anyString) {
				System.out.println("�߳�����Ϊ��" + Thread.currentThread().getName()
						+ "��" + System.currentTimeMillis() + "����ͬ����");
				usernameParam = username;
				Thread.sleep(3000);
				passwordParam = password;
				System.out.println("�߳�����Ϊ��" + Thread.currentThread().getName()
						+ "��" + System.currentTimeMillis() + "�뿪ͬ����");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
