package com.pay.utils;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElasticUtils {
	public static void main(String[] args) {
		
		RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
		try {
			IndexRequest indexRequest = new IndexRequest("finance", "cuspayment");
			for (int i = 0; i < 100000; i++) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("orderId", RandomUtils.getNumber(8));
				jsonObject.put("shortTime", "2019-01-29");
				jsonObject.put("amount", RandomUtils.getDoubleNumber());
				indexRequest.source(jsonObject.toString(), XContentType.JSON);
				client.index(indexRequest);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static RestHighLevelClient getRestClient() {
		RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
		return client;
	}
	
	public static void add(String indexName, String type, JSONObject docment) {
		try {
			RestHighLevelClient restClient = getRestClient();
			IndexRequest indexRequest = new IndexRequest(indexName, type);
			indexRequest.source(docment.toString(), XContentType.JSON);
			restClient.index(indexRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addList(String indexName, String type, List<JSONObject> docments) {
		try {
			RestHighLevelClient restClient = getRestClient();
			BulkRequest request = new BulkRequest();
			for (JSONObject docment : docments) {
				request.add(new IndexRequest(indexName, type).source(XContentType.JSON, docment.toJSONString()));
			}
			restClient.bulk(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(String indexName, String type, List<JSONObject> docments) {
		try {
			RestHighLevelClient restClient = getRestClient();
			IndexRequest indexRequest = new IndexRequest(indexName, type);
			for (JSONObject docment : docments) {
				indexRequest.source(docment.toString(), XContentType.JSON);
				restClient.index(indexRequest);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SearchResponse searchByPage(String indexName, String type, JSONObject docment, int index, int size, int timeOut) {
		RestHighLevelClient client = getRestClient();
		
		try {
			SearchRequest searchRequest = new SearchRequest(indexName);
			searchRequest.types(type);
//			searchRequest.
			
			// 2、用SearchSourceBuilder来构造查询请求体 ,请仔细查看它的方法，构造各种查询的方法都在这。
			SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
			sourceBuilder.query(QueryBuilders.termQuery("age", 24));
			sourceBuilder.from((index - 1) * size);
			sourceBuilder.size(size);
			sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
			SearchResponse searchResponse = client.search(searchRequest);
			return searchResponse;
		} catch (Exception ex) {
			return null;
		}
		
		
	}
	
	public static DeleteResponse delete(String indexName, String type, JSONObject docment) {
		RestHighLevelClient client = getRestClient();
		
		try {
			DeleteRequest deleteRequest = new DeleteRequest(indexName);
			deleteRequest.type(type);

			DeleteResponse deleteResponse = client.delete(deleteRequest);
			return deleteResponse;
		} catch (Exception ex) {
			return null;
		}
	}
}


