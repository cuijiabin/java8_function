package com.thread.chapter02;

public class Sub8 extends Main8 {

	synchronized public void operateISubMethod() {
		try {
			while (i > 0) {
				i--;
				System.out.println("sub print i=" + i);
				Thread.sleep(100);
				this.operateIMainMethod();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
