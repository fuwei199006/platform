package com.pay.biz;

import com.pay.biz.impl.MerchantBiz;
import com.pay.model.Merchant;
import org.springframework.stereotype.Service;

public interface IMerchantBiz {
	Merchant getMerchant(int mid);
}
