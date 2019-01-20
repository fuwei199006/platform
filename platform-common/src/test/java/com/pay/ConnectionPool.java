package com.pay;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {
	private LinkedList<Integer> pool = new LinkedList<Integer>();
	
	public ConnectionPool(int initialSize) {
		if (initialSize > 0) {
			for (int i = 0; i < initialSize; i++) {
				pool.addLast(i);
			}
		}
	}
	
	public void releaseConnection(Integer connection) throws InterruptedException {
		if (connection != null) {
			synchronized (pool) {
				// 连接释放后需要进行通知，这样其他消费者能够感知到连接池中已经归还了一个连接
//				Thread.sleep(2000);
				pool.addLast(connection);
				pool.notify();
			}
		}
	}
	
	// 在mills内无法获取到连接，将会返回null
	public Integer fetchConnection(long mills) throws InterruptedException {
		synchronized (pool) {
			// 完全超时
			if (mills <= 0) {
				while (pool.isEmpty()) {
					pool.wait();
				}
				return pool.removeFirst();
			} else {
				long future = System.currentTimeMillis() + mills;
				long remaining = mills;
				while (pool.isEmpty() && remaining > 0) {
					pool.wait(remaining);
					
					remaining = future - System.currentTimeMillis();
					System.out.println(String.format("remain:%s", remaining));
				}
				Integer result = null;
				if (!pool.isEmpty()) {
					result = pool.removeFirst();
				}
				return result;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ConnectionPool connectionPool = new ConnectionPool(2);
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				
				try {
					Integer integer = connectionPool.fetchConnection(1);
					Thread.sleep(2000);
					connectionPool.releaseConnection(integer);
					System.out.println(integer);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			}).start();
			
		}
		
	}
}
