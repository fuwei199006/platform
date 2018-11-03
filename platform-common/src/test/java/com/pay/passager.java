package com.pay;
public class passager {
	
	public passager(String name,String passagerNo){
		this.name=name;
		this.passagerNo=passagerNo;
	}
	
	public String name;
	public String passagerNo;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassagerNo() {
		return passagerNo;
	}
	
	public void setPassagerNo(String passagerNo) {
		this.passagerNo = passagerNo;
	}
}
