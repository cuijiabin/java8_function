package com.thread.chapter02;

public class Service36 {

	public void serviceMethodA(Userinfo36 userinfo) {
		synchronized (userinfo) {
			try {
				System.out.println(Thread.currentThread().getName());
				userinfo.setUsername("abcabcabc");
				Thread.sleep(3000);
				System.out.println("end! time=" + System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
