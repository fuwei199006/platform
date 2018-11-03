package com.pay;

import java.math.BigDecimal;

public class Student {
	
	public Student(String stuName, int age, BigDecimal score, int clazz) {
		this.stuName = stuName;
		this.age = age;
		this.score = score;
		this.clazz = clazz;
	}
	
	private String stuName;
	private int age;
	private BigDecimal score;
	private int clazz;
	
	public String getStuName() {
		return stuName;
	}
	
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public BigDecimal getScore() {
		return score;
	}
	
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	
	public int getClazz() {
		return clazz;
	}
	
	public void setClazz(int clazz) {
		this.clazz = clazz;
	}
}
