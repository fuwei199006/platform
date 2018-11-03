package org.pay.web.controller;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.pay.dal.entity.MerchantInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

@RestController
public class hello {
	
	@RequestMapping("hello")
	public String welcome() {
		try {
			
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			String str = inputStream.toString();
			System.out.println(str);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			try {
				List<MerchantInfo> merchantInfo = session.selectList("selectMerchantInfo");
				System.out.println(merchantInfo);
			} catch (Exception ex) {
				System.out.println(ex);
			} finally {
				session.close();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return "hello";
	}
}
