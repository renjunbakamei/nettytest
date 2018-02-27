package com.jfpay.entity.DO;

import com.jfpay.base.entity.BaseEntity;

public class LinkBlacklistPerson extends BaseEntity{
	/** 变量 id . */
	private String id;
	/** 变量 mobileNo . */
	private String mobileNo;
	/** 变量 name . */
	private String name;
	/** 变量 cardNo . */
	private String cardNo;
	/** 变量 createUser . */
	private String createUser;
	/** 变量 createDate . */
	private String createDate;
	/** 变量 status . */
	private String status;
	/** 变量 backup . */
	private String backup;
	/** 变量 backup1 . */
	private String backup1;
	/** 变量 backup2 . */
	private String backup2;
	/** 变量 backup3 . */
	private String backup3;
	//columns END
	private String method;
	private String picPath;
	private String mobileNo2;

	public void setId(String value) {
		this.id = value;
	}
	
	public String getId() {
		return this.id;
	}
	
	

	public void setMobileNo(String value) {
		this.mobileNo = value;
	}
	
	public String getMobileNo() {
		return this.mobileNo;
	}
	

	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	

	public void setCardNo(String value) {
		this.cardNo = value;
	}
	
	public String getCardNo() {
		return this.cardNo;
	}
	

	public void setCreateUser(String value) {
		this.createUser = value;
	}
	
	public String getCreateUser() {
		return this.createUser;
	}
	

	public void setCreateDate(String value) {
		this.createDate = value;
	}
	
	public String getCreateDate() {
		return this.createDate;
	}
	

	public void setStatus(String value) {
		this.status = value;
	}
	
	public String getStatus() {
		return this.status;
	}
	

	public void setBackup(String value) {
		this.backup = value;
	}
	
	public String getBackup() {
		return this.backup;
	}
	

	public void setBackup1(String value) {
		this.backup1 = value;
	}
	
	public String getBackup1() {
		return this.backup1;
	}
	

	public void setBackup2(String value) {
		this.backup2 = value;
	}
	
	public String getBackup2() {
		return this.backup2;
	}
	

	public void setBackup3(String value) {
		this.backup3 = value;
	}
	
	public String getBackup3() {
		return this.backup3;
	}
	
	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	public void setPicPath(String value) {
		this.picPath = value;
	}
	
	public String getPicPath() {
		return this.picPath;
	}
	
	public void setMobileNo2(String value) {
		this.mobileNo2 = value;
	}
	
	public String getMobileNo2() {
		return this.mobileNo2;
	}
	
}
