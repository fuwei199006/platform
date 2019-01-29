package com.pay.utils;

public class SleepUtils {
	public static void Sleep(long seconds){
		try {
			Thread.sleep(seconds*1000);
		}
		catch (InterruptedException ex){
		
		}
	}
}
