/*
 * 版权声明 .
 * 此文档的版权归上海即富信息技术服务有限公司所有
 * Powered By [JFPAL]
 */

package com.jfpay.entity.DO;

public class PayCustomer {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8419530880501824453L;
	//columns START
	/** 变量 timestamp . */
	private String timestamp;
	/** 变量 customerid . */
	private String customerid;
	/** 变量 username . */
	private String username;
	/** 变量 customertype . */
	private String customertype;
	/** 变量 customername . */
	private String customername;
	/** 变量 customerpidtype . */
	private String customerpidtype;
	/** 变量 customerpid . */
	private String customerpid;
	/** 变量 customerregdate . */
	private String customerregdate;
	/** 变量 branchid . */
	private String branchid;
	/** 变量 attention . */
	private String attention;
	/** 变量 customertag . */
	private String customertag;
	/** 变量 viplevel . */
	private Long viplevel;
	/** 变量 lastchangedate . */
	private String lastchangedate;
	/** 变量 memo . */
	private String memo;
	/** 变量 email . */
	private String email;
	/** 变量 precustomertag . */
	private String precustomertag;
	/** 变量 blank1 . */
	private String blank1;
	/** 变量 blank2 . */
	private String blank2;
	/** 变量 blank3 . */
	private String blank3;
	//columns END
	private String changeTime;   //客户变更时间

	private String examdate;

	private String examenddate;

	private String examuser;

	private String sign;   //请求签名
	private String phoneNumber;  //请求手机号
	private String audittype;
	private String blank4;
	
	private String customerCount;
	private String startDate;
	private String endDate;
	private String precent; //百分比

	/**
	* PayCustomer 的构造函数
	*/
	public PayCustomer() {
	}
	/**
	* PayCustomer 的构造函数
	*/
	public PayCustomer(
		String customerid
	) {
		this.customerid = customerid;
	}

	public String getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

	public String getExamdate() {
		return examdate;
	}

	public void setExamdate(String examdate) {
		this.examdate = examdate;
	}

	public String getExamenddate() {
		return examenddate;
	}

	public void setExamenddate(String examenddate) {
		this.examenddate = examenddate;
	}

	public String getExamuser() {
		return examuser;
	}

	public void setExamuser(String examuser) {
		this.examuser = examuser;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAudittype() {
		return audittype;
	}

	public void setAudittype(String audittype) {
		this.audittype = audittype;
	}

	public String getBlank4() {
		return blank4;
	}

	public void setBlank4(String blank4) {
		this.blank4 = blank4;
	}

	public void setTimestamp(String value) {
		this.timestamp = value;
	}
	
	public String getTimestamp() {
		return this.timestamp;
	}
	

	public void setCustomerid(String value) {
		this.customerid = value;
	}
	
	public String getCustomerid() {
		return this.customerid;
	}
	
	public String getPk() {
		return this.customerid;
	}

	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return this.username;
	}
	

	public void setCustomertype(String value) {
		this.customertype = value;
	}
	
	public String getCustomertype() {
		return this.customertype;
	}
	

	public void setCustomername(String value) {
		this.customername = value;
	}
	
	public String getCustomername() {
		return this.customername;
	}
	

	public void setCustomerpidtype(String value) {
		this.customerpidtype = value;
	}
	
	public String getCustomerpidtype() {
		return this.customerpidtype;
	}
	

	public void setCustomerpid(String value) {
		this.customerpid = value;
	}
	
	public String getCustomerpid() {
		return this.customerpid;
	}
	

	public void setCustomerregdate(String value) {
		this.customerregdate = value;
	}
	
	public String getCustomerregdate() {
		return this.customerregdate;
	}
	

	public void setBranchid(String value) {
		this.branchid = value;
	}
	
	public String getBranchid() {
		return this.branchid;
	}
	

	public void setAttention(String value) {
		this.attention = value;
	}
	
	public String getAttention() {
		return this.attention;
	}
	

	public void setCustomertag(String value) {
		this.customertag = value;
	}
	
	public String getCustomertag() {
		return this.customertag;
	}
	

	public void setViplevel(Long value) {
		this.viplevel = value;
	}
	
	public Long getViplevel() {
		return this.viplevel;
	}
	

	public void setLastchangedate(String value) {
		this.lastchangedate = value;
	}
	
	public String getLastchangedate() {
		return this.lastchangedate;
	}
	

	public void setMemo(String value) {
		this.memo = value;
	}
	
	public String getMemo() {
		return this.memo;
	}
	

	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return this.email;
	}
	

	public void setPrecustomertag(String value) {
		this.precustomertag = value;
	}
	
	public String getPrecustomertag() {
		return this.precustomertag;
	}
	

	public void setBlank1(String value) {
		this.blank1 = value;
	}
	
	public String getBlank1() {
		return this.blank1;
	}
	

	public void setBlank2(String value) {
		this.blank2 = value;
	}
	
	public String getBlank2() {
		return this.blank2;
	}
	

	public void setBlank3(String value) {
		this.blank3 = value;
	}
	
	public String getBlank3() {
		return this.blank3;
	}
	public String getCustomerCount() {
		return customerCount;
	}
	public void setCustomerCount(String customerCount) {
		this.customerCount = customerCount;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPrecent() {
		return precent;
	}
	public void setPrecent(String precent) {
		this.precent = precent;
	}
}

