package com.pay.utils;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class CloggerTest {
	
	
	@Test
	public void info() {
		Clogger.info("title","asdfasdf");
		System.out.println("hello");
	}
}
