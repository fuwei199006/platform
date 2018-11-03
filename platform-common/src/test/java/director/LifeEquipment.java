package director;

public class LifeEquipment extends BaseEquipment{
	private Element element;
	public LifeEquipment(Element element){
		this.element=element;
	}
	@Override
	public String getEquipment() {
		return element.getEquipment()+"，增加生命";
	}
}
