/*
 * 版权声明 .
 * 此文档的版权归上海即富信息技术服务有限公司所有
 * Powered By [JFPAL]
 */

package com.jfpay.entity.DO;

import com.jfpay.base.entity.BaseEntity;

public class LinkPersonExam extends BaseEntity{
	
	private static final long serialVersionUID = -3965136709161091938L;
	//columns START
	/** 变量 id . */
	private String id;
	/** 变量 mobileNo . */
	private String mobileNo;
	/** 变量 置信度 . */
	private String confidence;
	/** 变量 thresholdId . */
	private String thresholdId;
	/** 变量 examStatus . */
	private String examStatus;
	/** 变量 examTime . */
	private String examTime;
	/** 变量 examUser . */
	private String examUser;
	/**阈值描述*/
	private String thresholdRemark;
	private String linkStatus;
	private String ocrResult;
	private String ocrReason;
	private String ocrStatus;
	private String blackStatus;
	private String isBlack;
	
	private String examStartDate;
	private String examEndDate;
	
	private String createDate;
	public String getExamStartDate() {
		return examStartDate;
	}

	public void setExamStartDate(String examStartDate) {
		this.examStartDate = examStartDate;
	}

	public String getExamEndDate() {
		return examEndDate;
	}

	public void setExamEndDate(String examEndDate) {
		this.examEndDate = examEndDate;
	}

	public String getOcrResult() {
		return ocrResult;
	}

	public void setOcrResult(String ocrResult) {
		this.ocrResult = ocrResult;
	}

	public String getOcrReason() {
		return ocrReason;
	}

	public void setOcrReason(String ocrReason) {
		this.ocrReason = ocrReason;
	}

	public String getOcrStatus() {
		return ocrStatus;
	}

	public void setOcrStatus(String ocrStatus) {
		this.ocrStatus = ocrStatus;
	}

	public String getBlackStatus() {
		return blackStatus;
	}

	public void setBlackStatus(String blackStatus) {
		this.blackStatus = blackStatus;
	}

	public String getIsBlack() {
		return isBlack;
	}

	public void setIsBlack(String isBlack) {
		this.isBlack = isBlack;
	}

	/**
	* LinkPersonExam 的构造函数
	*/
	public LinkPersonExam() {
	}

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
	

	public void setConfidence(String value) {
		this.confidence = value;
	}
	
	public String getConfidence() {
		return this.confidence;
	}
	

	public void setThresholdId(String value) {
		this.thresholdId = value;
	}
	
	public String getThresholdId() {
		return this.thresholdId;
	}
	

	public void setExamStatus(String value) {
		this.examStatus = value;
	}
	
	public String getExamStatus() {
		return this.examStatus;
	}
	

	public void setExamTime(String value) {
		this.examTime = value;
	}
	
	public String getExamTime() {
		return this.examTime;
	}
	

	public void setExamUser(String value) {
		this.examUser = value;
	}
	
	public String getExamUser() {
		return this.examUser;
	}

	public String getThresholdRemark() {
		return thresholdRemark;
	}

	public void setThresholdRemark(String thresholdRemark) {
		this.thresholdRemark = thresholdRemark;
	}

	public String getLinkStatus() {
		return linkStatus;
	}

	public void setLinkStatus(String linkStatus) {
		this.linkStatus = linkStatus;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	

}

