package com.pay.biz.impl;

import com.pay.biz.IMerchantBiz;
import com.pay.dao.MerchantMapper;
import com.pay.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MerchantBiz implements IMerchantBiz {
	@Autowired
	MerchantMapper merchantMapper;
	public Merchant getMerchant(int mid) {
		return null;
	}
}
