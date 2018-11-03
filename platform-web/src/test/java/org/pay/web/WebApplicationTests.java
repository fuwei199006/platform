package org.pay.web;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pay.dal.entity.MerchantInfo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testMybatisConfigweb() {
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
		
	}
}
