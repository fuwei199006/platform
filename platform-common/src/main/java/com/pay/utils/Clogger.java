package com.pay.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Clogger {
	
	public Clogger(){
		System.setProperty("log4j.configurationFile","D:\\work\\platform\\platform-common\\src\\test\\resources\\log4j2.xml");
	}
	private static final Logger log = LogManager.getLogger(Clogger.class);
	public static void info(String title, String content) {
		
		log.info(title,content,"");
	 
	}
}
