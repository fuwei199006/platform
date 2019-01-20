package com.pay.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



public class SingletonTest {
	@Test
	public void testSingleton() throws InterruptedException {
	 
			long start=System.currentTimeMillis();
			List<Thread> threadList = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				Thread thread = new Thread(() -> {
					Singleton.getInstance();
				 
				});
				threadList.add(thread);
				thread.start();
			}
			for (Thread t : threadList) {
				t.join();
			}
			long end=System.currentTimeMillis();
			System.out.println("运行耗时："+(end-start));
	 
		
	}
	
	
}