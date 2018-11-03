package controller;

import org.pay.biz.IMerchantInfoService;
import org.pay.dal.entity.MerchantInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@Autowired
	IMerchantInfoService merchantInfoService;
	
	@RequestMapping("/Hello")
	public String Hello(){
		MerchantInfo merchantInfo=merchantInfoService.selectByPrimaryKey(1);
		return "index1";
	}
}
