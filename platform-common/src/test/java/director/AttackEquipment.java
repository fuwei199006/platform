package director;

public class AttackEquipment extends BaseEquipment {
	private Element element;
	public AttackEquipment(Element element){
		this.element=element;
	}
	@Override
	public String getEquipment() {
		return element.getEquipment()+"，增加攻击力";
	}
}
