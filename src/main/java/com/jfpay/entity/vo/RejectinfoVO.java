/*
 * 版权声明 .
 * 此文档的版权归上海即富信息技术服务有限公司所有
 * Powered By [JFPAL]
 */

package com.jfpay.entity.vo;




public class RejectinfoVO {
	
	//columns STARTo
	/** 变量 rejectCode . */
	private String rejectCode;
	/** 变量 rejectReason . */
	private String rejectReason;
	/** 变量 status . */
	private String status;
	/** 变量 reType . */
	private String reType;
	/** 变量 id . */
	private java.math.BigDecimal id;
	//columns END

	/**
	* Rejectinfo 的构造函数
	*/
	public RejectinfoVO() {
	}
	/**
	* Rejectinfo 的构造函数
	*/
	public RejectinfoVO(
		java.math.BigDecimal id
	) {
		this.id = id;
	}


	public void setRejectCode(String value) {
		this.rejectCode = value;
	}
	
	public String getRejectCode() {
		return this.rejectCode;
	}
	

	public void setRejectReason(String value) {
		this.rejectReason = value;
	}
	
	public String getRejectReason() {
		return this.rejectReason;
	}
	

	public void setStatus(String value) {
		this.status = value;
	}
	
	public String getStatus() {
		return this.status;
	}
	

	public void setReType(String value) {
		this.reType = value;
	}
	
	public String getReType() {
		return this.reType;
	}
	

	public void setId(java.math.BigDecimal value) {
		this.id = value;
	}
	
	public java.math.BigDecimal getId() {
		return this.id;
	}
	
	public java.math.BigDecimal getPk() {
		return this.id;
	}

}

