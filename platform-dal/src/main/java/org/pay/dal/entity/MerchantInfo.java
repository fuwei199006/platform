package org.pay.dal.entity;

import java.util.Date;

public class MerchantInfo {
	private Integer id;
	
	private String paymenttype;
	
	private String merchantname;
	
	private String merchantno;
	
	private String merchantinfo;
	
	private Integer status;
	
	private String note;
	
	private Date createtime;
	
	private Date datachangeLasttime;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPaymenttype() {
		return paymenttype;
	}
	
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype == null ? null : paymenttype.trim();
	}
	
	public String getMerchantname() {
		return merchantname;
	}
	
	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname == null ? null : merchantname.trim();
	}
	
	public String getMerchantno() {
		return merchantno;
	}
	
	public void setMerchantno(String merchantno) {
		this.merchantno = merchantno == null ? null : merchantno.trim();
	}
	
	public String getMerchantinfo() {
		return merchantinfo;
	}
	
	public void setMerchantinfo(String merchantinfo) {
		this.merchantinfo = merchantinfo == null ? null : merchantinfo.trim();
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}
	
	public Date getCreatetime() {
		return createtime;
	}
	
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	public Date getDatachangeLasttime() {
		return datachangeLasttime;
	}
	
	public void setDatachangeLasttime(Date datachangeLasttime) {
		this.datachangeLasttime = datachangeLasttime;
	}
}