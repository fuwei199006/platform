package com.pay;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private volatile int count = 0;
	private AtomicInteger  atomicInteger=new AtomicInteger();
	
	public static void main(String[] args) throws InterruptedException {
		
		AppTest app = new AppTest();
		
		for (int i = 0; i < 10000; i++) {
			Thread thread = new Thread(() -> {
				for (int m = 0; m < 1000; m++) {
					app.count();
				}
			});
			thread.start();
		}
		System.out.println(app.count);
		for (int i=0;i<10;i++){
			Thread.sleep(1000);
			System.out.println(app.count);
		}
	
		
	}
	
	private void count() {
		count++;
		atomicInteger.incrementAndGet();
	}
}


