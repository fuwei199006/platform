package com.pay.utils;

public class CodeTestUtils {
	public static void main(String[] args) {
		boolean isPass = false;
		for (int i = 8; i < 100000000; i += 2) {
			for (long j = 2; j < i; j++) {
				if (isSuShu(j) && isSuShu(i - j)) {
					isPass=true;
					System.out.println(String.format("验证成功:%s=%s+%s", i, j, i - j));
//					break;
				}
				continue;
			}
		}
		if(!isPass){
			System.out.println("fail");
		}
	
	}
	
	
	public static boolean isSuShu(long n) {
		if (n == 1)
			return false;
		for (long i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
