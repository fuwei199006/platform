package com.pay.utils;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.simple.SimpleLogger;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class ElasticUtils {
	public static void main(String[] args) {
		try {
			
			@SuppressWarnings({"resource", "unchecked"}) TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9200));
			System.out.println(transportClient);
			transportClient.close();
		} catch (Exception ex) {
		
		}
		
		
	}
	
	private static TransportClient getClient() {
		try{
			TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9200));
			return transportClient;
		}catch (UnknownHostException ex){
		return null;
		}
	
	}
	
}
