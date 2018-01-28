import entity.MerchantInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import javax.activation.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class test {
	@Test
	public void test() {
		
		System.out.println(MerchantInfo.class);
	}
	
	
	@Test
	public void testDb() {
		
		dbHelper db = new dbHelper("SELECT * from merchant_info");
		try {
			ResultSet set = db.pst.executeQuery();
			set.next();
			System.out.println(set.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMybatis() {
		////		DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
		//		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		//		Environment environment = new Environment("selectMerchantInfo", transactionFactory, dataSource);
		//		Configuration configuration = new Configuration(environment);
		//		configuration.addMapper(MerchantInfo.class);
		//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
	}
	@Test
	public void testMybatisConfig() {
		try {
 
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			String str=inputStream.toString();
			System.out.println(str);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			try {
				List<MerchantInfo> merchantInfo =  session.selectList("selectMerchantInfo");
				System.out.println(merchantInfo);
			} catch (Exception ex){
				System.out.println(ex);
			}finally {
				session.close();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
}
