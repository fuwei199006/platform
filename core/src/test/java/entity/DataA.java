package entity;

import java.util.ArrayList;
import java.util.List;

public class DataA {
	public DataA(){
		courses=new ArrayList<>();
	}
	private int id;
	private String name;
	private String code;
	private List<DetailA> courses;
	private DetailA course;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public List<DetailA> getCourses() {
		return courses;
	}
	
	public void setCourses(List<DetailA> courses) {
		this.courses = courses;
	}
	
	public DetailA getCourse() {
		return course;
	}
	
	public void setCourse(DetailA course) {
		this.course = course;
	}
}
