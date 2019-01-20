package com.pay;

public class ThreadNeverStop {
	
	private   int stopRequested=1;
	
	public static void main(String[] args) throws InterruptedException {
		ThreadNeverStop threadNeverStop = new ThreadNeverStop();
		Thread backgroundThread = new Thread(() -> {
			long start = System.currentTimeMillis();
			while (threadNeverStop.stopRequested!=0) {
				//whatever
			}
			long end = System.currentTimeMillis();
			System.out.println("it takes " + (end - start) + " miliseconds.");
		});
		
		backgroundThread.start();
		
		Thread.sleep(1000);
		
		threadNeverStop.stopRequested =0;
	}
}