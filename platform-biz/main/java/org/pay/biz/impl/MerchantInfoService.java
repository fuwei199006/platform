package org.pay.biz.impl;

import org.pay.biz.IMerchantInfoService;
import org.pay.dal.dao.MerchantInfoDao;
import org.pay.dal.entity.MerchantInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MerchantInfoService implements IMerchantInfoService {
	@Autowired
	MerchantInfoDao merchantInfoDao;
	
	public MerchantInfo selectByPrimaryKey(Integer id){
		return merchantInfoDao.selectByPrimaryKey(id);
	}
	
}
