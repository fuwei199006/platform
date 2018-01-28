package entity;

import java.sql.Timestamp;

public class MerchantInfo {
	private int id;
	private String paymentType;
	private String merchantName;
	private String merchantNo;
	private String merchantInfo;
	private String status;
	private String note;
	private Timestamp createTime;
	private Timestamp datachange_lasttime;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPaymentType() {
		return paymentType;
	}
	
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public String getMerchantName() {
		return merchantName;
	}
	
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
	public String getMerchantNo() {
		return merchantNo;
	}
	
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	
	public String getMerchantInfo() {
		return merchantInfo;
	}
	
	public void setMerchantInfo(String merchantInfo) {
		this.merchantInfo = merchantInfo;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public Timestamp getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	public Timestamp getDatachange_lasttime() {
		return datachange_lasttime;
	}
	
	public void setDatachange_lasttime(Timestamp datachange_lasttime) {
		this.datachange_lasttime = datachange_lasttime;
	}
}
