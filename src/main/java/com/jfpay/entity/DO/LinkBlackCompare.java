/*
 * 版权声明 .
 * 此文档的版权归上海即富信息技术服务有限公司所有
 * Powered By [JFPAL]
 */

package com.jfpay.entity.DO;

public class LinkBlackCompare {
	
	private static final long serialVersionUID = 1561741113516176178L;
	//columns START
	/** 变量 nid . */
	private Integer nid;
	/** 变量 status . */
	private String status;
	/** 变量 respImageId . */
	private String respImageId;
	/** 变量 respScore . */
	private String respScore;
	/** 变量 respPersonUuid . */
	private String respPersonUuid;
	/** 变量 examId . */
	private String examId;
	private String picPath;
	//columns END

	/**
	* LinkBlackCompare 的构造函数
	*/
	public LinkBlackCompare() {
	}
	/**
	* LinkBlackCompare 的构造函数
	*/
	public LinkBlackCompare(
		Integer nid
	) {
		this.nid = nid;
	}


	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public void setNid(Integer value) {
		this.nid = value;
	}
	
	public Integer getNid() {
		return this.nid;
	}
	
	public Integer getPk() {
		return this.nid;
	}

	public void setStatus(String value) {
		this.status = value;
	}
	
	public String getStatus() {
		return this.status;
	}
	

	public void setRespImageId(String value) {
		this.respImageId = value;
	}
	
	public String getRespImageId() {
		return this.respImageId;
	}
	

	public void setRespScore(String value) {
		this.respScore = value;
	}
	
	public String getRespScore() {
		return this.respScore;
	}
	

	public void setRespPersonUuid(String value) {
		this.respPersonUuid = value;
	}
	
	public String getRespPersonUuid() {
		return this.respPersonUuid;
	}
	

	public void setExamId(String value) {
		this.examId = value;
	}
	
	public String getExamId() {
		return this.examId;
	}
	

}

