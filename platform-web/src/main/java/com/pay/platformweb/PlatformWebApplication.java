package com.pay.platformweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.pay.mapping")

public class PlatformWebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PlatformWebApplication.class, args);
	}
}
