package com.pay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Unit test for simple App.
 */
public class LockWait {
	
	static volatile List<String> itemContainer = new ArrayList<>();
	static Object obj = new Object();
	
	public static void main(String[] args) {
		Thread th1 = new Thread(() -> {
			synchronized (obj) {
				for (int i = 0; i < 10; i++) {
					System.out.println("th1添加元素");
					itemContainer.add(String.valueOf(i));
					if (itemContainer.size() == 5) {
						System.out.println("th1线程发出通知");
						obj.notify();
					}
				}
			}
		});
		
		Thread th2 = new Thread(() -> {
			synchronized (obj) {
				System.out.println("进入th2线程");
				if (itemContainer.size() != 5) {
					try {
						System.out.println("th2线程开始等待");
						obj.wait();
						System.out.println("th2线程等待结束");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("th2线程结束");
				}
			}
			
		});
		
		th2.start();
		th1.start();
		
	}
}


