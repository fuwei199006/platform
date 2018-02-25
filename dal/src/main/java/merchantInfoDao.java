import entity.MerchantInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface merchantInfoDao {
	
	
	MerchantInfo findMerchantInfoById(@Param("id") String id);
	
}
