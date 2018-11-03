package com.pay.platformweb.Controller;

import com.pay.biz.IMerchantBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	private IMerchantBiz merchantBiz;
	@RequestMapping(value = "/welcome")
	public String welcome() {
		
		return "welcome";
	}
}
