package reflect;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BeanUtilTest {
	
	@Test
	public void testBeanUtils() {
		EntityA entityA = new EntityA();
		List<UniteA> uniteAList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			UniteA uniteA = new UniteA();
			uniteA.setAge(i);
			uniteA.setName("name" + i);
			uniteAList.add(uniteA);
		}
		entityA.setKey(10);
		entityA.setUniteList(uniteAList);
		
		
		EntityB entityB = new EntityB();
		BeanUtils.copyProperties(entityA, entityB);
		System.out.println(entityB.getUniteList().get(0).getClass());
	}
	
	@Test
	public void TestFanxing(){
		List<String> strList=new ArrayList<>();
		strList.add("1234");//正常的编译
		try {
			Method method=strList.getClass().getDeclaredMethod("add",Object.class);
			method.invoke(strList,1234);
			System.out.println(strList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void TestFanxing1(){
		List<String> strList=new ArrayList<>();
		List<Integer> intList=new ArrayList<>();
		System.out.println(strList.getClass().equals(intList.getClass()));
	}
}
