package entity;

import java.util.List;

public class DataB {
	private int  id;
	private String name;
	private String code;
	private List<DetailB> courses;
	private DetailB course;
	
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
	
	public List<DetailB> getCourses() {
		return courses;
	}
	
	public void setCourses(List<DetailB> courses) {
		this.courses = courses;
	}
	
	public DetailB getCourse() {
		return course;
	}
	
	public void setCourse(DetailB course) {
		this.course = course;
	}
}
