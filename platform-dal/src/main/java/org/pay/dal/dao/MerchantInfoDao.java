package org.pay.dal.dao;
import org.apache.ibatis.annotations.Param;
import org.pay.dal.entity.MerchantInfo;

public interface MerchantInfoDao {
	
	int deleteByPrimaryKey(Integer id);
	
	int insert(MerchantInfo record);
	
	int insertSelective(MerchantInfo record);
	
	MerchantInfo selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKeySelective(MerchantInfo record);
	
	int updateByPrimaryKey(MerchantInfo record);
	
}
