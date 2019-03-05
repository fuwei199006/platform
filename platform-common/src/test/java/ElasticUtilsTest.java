import com.alibaba.fastjson.JSONObject;
import com.pay.utils.ElasticTcpUtils;
//import com.pay.utils.ElasticUtils;
import com.pay.utils.ElasticUtils;
import com.pay.utils.RandomUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ElasticUtilsTest {
	
	@Test
	public void bulkInsertTest() throws Exception {
		for (int i = 0; i < 1000; i++) {
			List<JSONObject> jsonObjectList = new ArrayList<>();
			for (int j = 0; j < 100000; j++) {
				JSONObject json = new JSONObject();
				json.put("order_id", RandomUtils.getNumber(8).toString());
				json.put("short_time", "2019-02-22");
				json.put("channel", RandomUtils.getNumber(1).toString());
				json.put("amount", RandomUtils.getNumber(4));
				json.put("deal_type", "1");
				json.put("create_time", LocalDateTime.now().toString());
				json.put("datachange_lasttime", LocalDateTime.now().toString());
				jsonObjectList.add(json);
			}
			long start = System.currentTimeMillis();
			ElasticUtils.addListByPage("order", "_doc", jsonObjectList);
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		}
	}
	
	@Test
	public void getIndexTest() throws Exception {
		SearchResponse searchResponse = ElasticTcpUtils.searchByPage("order", "_doc", 1, 1000);
	}
}
