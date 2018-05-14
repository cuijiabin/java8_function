package com.function.demo;

/**

 * @ClassName: MapNew

 * @Description: TODO

 * @author: cuijiabin

 * @date: 2016年10月25日 下午5:04:22


 */
public class MapNew {
	
	public static void main(String[] args) {
		int a = 60;
		int b = -1;
		
		System.out.println("a:"+Integer.toBinaryString(a));
		
		System.out.println("b:"+Integer.toBinaryString(b));
		
		System.out.println(Integer.toBinaryString(b >>> 16));
		
		System.out.println(Integer.toBinaryString(a >>> 16));
		
		System.out.println((b^(b >>> 16))+"="+Integer.toBinaryString(b^(b >>> 16)));
		
		System.out.println(~b);
		System.out.println(Integer.toBinaryString(~b));
	}

}
