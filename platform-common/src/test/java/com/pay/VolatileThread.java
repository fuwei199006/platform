package com.pay;

public class VolatileThread extends Thread {
	private volatile boolean isRuning=true;
	private void setRuning(boolean runing){
		this.isRuning=runing;
	}
	
	public void run(){
		System.out.println("进入Run方法");
		while (isRuning){
		
		}
		System.out.println("线程结束");
	}
	
	public static void main(String[] args) throws InterruptedException {
		VolatileThread volatileThread = new VolatileThread();
		volatileThread.start();
		Thread.sleep(3000);
		volatileThread.setRuning(false);
		System.out.println("runing设置成false,让线程停止");
		Thread.sleep(1000);
		System.out.println(volatileThread.isRuning);
	}
}
