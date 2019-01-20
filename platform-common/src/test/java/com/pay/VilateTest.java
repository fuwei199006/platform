package com.pay;

public class VilateTest {
	private   int flag = 0;
	
	public static void main(String[] args) throws InterruptedException {
		VilateTest vilateTest = new VilateTest();
		vilateTest.test();
	
		
		vilateTest.flag = 10;
		System.out.println(vilateTest.flag);
		
	}
	
	private void test() {
		new Thread(() -> {
			
			flag = 20;
 
		}).start();
		
		
	 
		
	}
}
