import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
	@Test
	public void test(){
		
		System.out.println("1231");
	}
	
	
	@Test
	public void testDb(){
		
		dbHelper db=new dbHelper("SELECT * FROM outlet_deliveryticket ");
		try {
			ResultSet set=db.pst.executeQuery();
			set.next();
			System.out.println(set.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
