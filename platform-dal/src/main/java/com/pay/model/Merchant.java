package com.pay.model;

import java.util.Date;

public class Merchant {
    private Integer id;

    private String paymenttype;

    private String paymentchannel;

    private String merchantno;

    private Integer payinterval;

    private String merchantinfo;

    private Integer status;

    private String note;

    private Date createtime;

    private String payresultnoticeurl;

    private String refundresultnoticeurl;

    private String signnotifyurl;

    private String unsignnofiyurl;

    private String appid;

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

    public String getPaymentchannel() {
        return paymentchannel;
    }

    public void setPaymentchannel(String paymentchannel) {
        this.paymentchannel = paymentchannel == null ? null : paymentchannel.trim();
    }

    public String getMerchantno() {
        return merchantno;
    }

    public void setMerchantno(String merchantno) {
        this.merchantno = merchantno == null ? null : merchantno.trim();
    }

    public Integer getPayinterval() {
        return payinterval;
    }

    public void setPayinterval(Integer payinterval) {
        this.payinterval = payinterval;
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

    public String getPayresultnoticeurl() {
        return payresultnoticeurl;
    }

    public void setPayresultnoticeurl(String payresultnoticeurl) {
        this.payresultnoticeurl = payresultnoticeurl == null ? null : payresultnoticeurl.trim();
    }

    public String getRefundresultnoticeurl() {
        return refundresultnoticeurl;
    }

    public void setRefundresultnoticeurl(String refundresultnoticeurl) {
        this.refundresultnoticeurl = refundresultnoticeurl == null ? null : refundresultnoticeurl.trim();
    }

    public String getSignnotifyurl() {
        return signnotifyurl;
    }

    public void setSignnotifyurl(String signnotifyurl) {
        this.signnotifyurl = signnotifyurl == null ? null : signnotifyurl.trim();
    }

    public String getUnsignnofiyurl() {
        return unsignnofiyurl;
    }

    public void setUnsignnofiyurl(String unsignnofiyurl) {
        this.unsignnofiyurl = unsignnofiyurl == null ? null : unsignnofiyurl.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public Date getDatachangeLasttime() {
        return datachangeLasttime;
    }

    public void setDatachangeLasttime(Date datachangeLasttime) {
        this.datachangeLasttime = datachangeLasttime;
    }
}