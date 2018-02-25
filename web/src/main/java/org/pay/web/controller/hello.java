package org.pay.web.controller;

import entity.MerchantInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
	
	@RequestMapping("hello")
	public String welcome() {
		return "hello";
	}
}
