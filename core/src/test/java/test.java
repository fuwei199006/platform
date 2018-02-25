import entity.DataA;
import entity.DataB;
import entity.DetailA;
import entity.DetailB;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class test {
	@Test
	public void test() throws NoSuchFieldException, IllegalAccessException {
		
		DataA dataA = new DataA();
		dataA.setCode("10000");
		dataA.setId(1);
		dataA.setName("测试");
		for (int i = 0; i < 10; i++) {
			DetailA detailA=new DetailA();
			detailA.setDatailCode("1000"+i);
			detailA.setDatailName("科目"+i);
			detailA.setIndex(String.valueOf(i));
			dataA.getCourses().add(detailA);
			dataA.setCourse(detailA);
		}
		Field f=dataA.getClass().getDeclaredField("id");
		f.setAccessible(true);
		System.out.println(f);
		System.out.println(f.get(dataA));
		
		DataB dataB = new DataB();
		Field fb=dataB.getClass().getDeclaredField("id");
		fb.setAccessible(true);
		fb.set(dataB,f.get(dataA));
		
		System.out.println(dataB.getClass());
		System.out.println(dataB.getId().getClass());
		System.out.println(dataB.getCourses().get(0).getClass());
		
//		List<DataA> aList=new ArrayList<>();
//		List<DataB> bList=new ArrayList<>();
	}
	
	@Test
	public void testBigDecimal(){
	
	}
}
