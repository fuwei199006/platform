package com.pay.utils;

public class CAS {
	
	public static void main(String[] args) {
		int i = 1;
		i = increate(i, 2);
	 
		System.out.println(i);
	}
	
	private static int increate(int i, int e) {
		i++;
		while (i != e) {
			i = e - 1;
		}
		return i;
	}
}
