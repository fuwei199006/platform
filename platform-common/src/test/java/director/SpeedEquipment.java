package director;

public class SpeedEquipment extends BaseEquipment{
	private Element element;
	public SpeedEquipment(Element element){
		this.element=element;
	}
	@Override
	public String getEquipment() {
		return element.getEquipment()+"，增加速度";
	}
}
