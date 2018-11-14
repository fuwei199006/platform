package com.pay;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private volatile int count = 0;
	private  int flag = 0;
	
	public static void main(String[] args) {
		long ts = System.currentTimeMillis();
		AppTest app = new AppTest();
		List<Thread> tList = new ArrayList<>(500);
		
		for (int i = 0; i < 10000; i++) {
			Thread thread = new Thread(() -> {
				for (int m = 0; m < 1000; m++) {
					app.count();
				}
			});
			tList.add(thread);
		}
		//启动线程
		for (Thread t : tList) {
			t.start();
		}
		//等待所有线程执行完
		for (Thread t : tList) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(app.count);
		long tend = System.currentTimeMillis();
		System.out.println(tend - ts);
	}
	
	private void count() {
		while (flag == 0) {
			flag = 1;
			count++;
			if (flag > 0) {
				break;
			}
		}
		flag = 0;
		
	}
}


