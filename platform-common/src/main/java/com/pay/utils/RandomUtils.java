package com.pay.utils;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;

public class RandomUtils {
	
	public static String getNumber(int n){
		StringBuilder sb=new StringBuilder();
		Random random=new Random(System.currentTimeMillis());
		for (int i=0;i<n;i++){
		
			int i1 = random.nextInt(10);
			sb.append(i1);
		}
		return sb.toString();
	}
	
//	public static long getNumber(long min,long max){
//		long result=0L;
//
//			Random random=new Random(System.currentTimeMillis());
//			result+= random.nextInt(1)+min；
//
//
//		return sb.toString();
//	}
	
	public static double getDoubleNumber(){
		 return  new BigDecimal(new Random().nextDouble()*10000).setScale(2).doubleValue();

	}
}
