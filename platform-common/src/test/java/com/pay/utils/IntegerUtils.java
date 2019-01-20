package com.pay.utils;

public class IntegerUtils {
	public static void main(String[] args) {
		Integer a1 = 140;
		Integer a2 = 140;
		System.out.println(a1 == a2);
		
		Integer b1 = 120;
		Integer b2 = 120;
		System.out.println(b1 == b2);
		
		Integer c1 = new Integer(120);
		Integer c2 = new Integer(120);
		System.out.println(c1 == c2);
		
		
		Integer d1 = new Integer(120);
		Integer d2 =  120;
		System.out.println(d1 == d2);
		
		
		Integer e1 = new Integer(120);
		int e2 =  120;
		System.out.println(e1 == e2);
		
	
		
		Integer f1 = new Integer(140);
		int f2 =  140;
		System.out.println(f1 == f2);
		
		Integer g1 = 120;
		int g2 =  120;
		System.out.println(g1 == g2);
		
		
		Integer h1 = 140;
		int h2 =  140;
		System.out.println(h1 == h2);
		
		Integer i1 = 120;
		Integer i2 = i1;
		Integer i3=i1+1;
		Integer i4=i3-1;
		System.out.println(i2);
		System.out.println(i2 == i4);
	}
	
}
