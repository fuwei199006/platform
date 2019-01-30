package com.pay.utils;


import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;


public class RandomUtilsTest {
 
	@Test
	public void getNumber() {
		while (true){
			System.out.println(RandomUtils.getNumber(8));
			SleepUtils.Sleep(1);
		}
	
	}
	
	@Test
	public void getNumber1() {
		while (true){
			System.out.println(RandomUtils.getNumber(1000,10000));
			SleepUtils.Sleep(1);
		}
	}
	
	@Test
	public void getDoubleNumber() {
		while (true){
			System.out.println(RandomUtils.getDoubleNumber(1000,2));
			SleepUtils.Sleep(1);
		}
		
//		System.out.println(Math.pow(10,3));
	}
}
