package org.pay.biz;
import org.pay.dal.entity.MerchantInfo;


public interface IMerchantInfoService {
	MerchantInfo selectByPrimaryKey(Integer id);
}
