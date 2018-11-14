package com.pay.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.jaxrs.FastJsonProvider;
import com.aliyun.api.internal.parser.json.JsonConverter;
import com.pay.utils.beans.Results;
import com.pay.utils.beans.Tbk_coupon;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgItemCouponGetRequest;
import com.taobao.api.response.TbkDgItemCouponGetResponse;

import java.util.Map;

public class TbkUtils {
	public static void getItem() throws ApiException {
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "25101344", "1475ecef955a8660ece2f0dc3173d60d");
		TbkDgItemCouponGetRequest req = new TbkDgItemCouponGetRequest();
		req.setAdzoneId(42892350275L);
		
		req.setPageSize(10L);
		req.setQ("鞋子");
		req.setPageNo(1L);
		TbkDgItemCouponGetResponse rsp = client.execute(req);
		String  resultStr = JSON.parseObject(rsp.getBody(), Map .class).get("tbk_dg_item_coupon_get_response").toString();
    	String  mapStr = JSON.parseObject(resultStr, Map .class).get("results").toString();
		Results results = JSON.parseObject(mapStr, Results.class);
		for (Tbk_coupon t : results.getTbk_coupon()) {
			System.out.println(String.format("%s-%s:%s",t.getTitle(),t.getCoupon_info(),t.getCoupon_click_url()));
		}
	}
}
