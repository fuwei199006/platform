package director;

import org.junit.Test;

public class TestHelper {
	
	@Test
	public void testDirector(){
		Element tank = new Tank();
		Element tank1 = new LifeEquipment(tank);
		
		tank = new AttackEquipment(tank);
		tank = new SpeedEquipment(tank);
		System.out.println(tank1.getEquipment());
		System.out.println(tank.getEquipment());
	}
}
