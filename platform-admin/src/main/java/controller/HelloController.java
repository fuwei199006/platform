package controller;

import com.pay.biz.IMerchantBiz;
import com.pay.model.Merchant;
import org.pay.dal.entity.MerchantInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
	@Autowired
	IMerchantBiz merchantBiz;
	
//	@RequestMapping("/Hello")
	public String Hello(){
		Merchant merchantInfo=merchantBiz.getMerchant(1);
		return "index1";
	}
}
