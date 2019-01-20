package com.pay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	
	public static void main(String[] args) {
		final List<String> itemContainer = new ArrayList<>();
		final CountDownLatch countDownLanch = new CountDownLatch(1);
		Thread th1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println("th1添加元素");
					itemContainer.add(String.valueOf(i));
					if (itemContainer.size() == 5) {
						System.out.println("th1线程发出通知");
						countDownLanch.countDown();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		Thread th2 = new Thread(() -> {
			System.out.println("进入th2线程");
			if (itemContainer.size() != 5) {
				try {
					System.out.println("th2线程开始等待");
					countDownLanch.await();
					System.out.println("th2线程等待结束");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("th2线程结束");
			}
			
		});
		
		th2.start();
		
		th1.start();
	}
	
	
}
