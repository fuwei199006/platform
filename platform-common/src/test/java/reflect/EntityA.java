package reflect;

import java.util.List;

public class EntityA {
	
	private Integer key;
	private List<UniteA> uniteList;
	
	public Integer getKey() {
		return key;
	}
	
	public void setKey(Integer key) {
		this.key = key;
	}
	
	public List<UniteA> getUniteList() {
		return uniteList;
	}
	
	public void setUniteList(List<UniteA> uniteList) {
		this.uniteList = uniteList;
	}
}
