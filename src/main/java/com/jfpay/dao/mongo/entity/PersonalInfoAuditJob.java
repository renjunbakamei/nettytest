/**
 * 
 */
package com.jfpay.dao.mongo.entity;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.BasicDBObject;

/**
 * 实名认证 任务实体
 * @author dongyuqiang
 *
 * @date 2017年8月30日
 */
@SuppressWarnings("serial")
public class PersonalInfoAuditJob {
	private String id;
	/**body*/
	private BasicDBObject body;
	
	/**接收时间*/
	private Date receiveDate;
	
	/**分配时间*/
	private Date allocationDate;
	
	/**操作员ID*/
	
	private int operatorId;
	
	/**操作员名称*/
	private String operatorName;
	
	/**处理时间*/
	@JsonProperty("dispose_date")
	private Date disposeDate;
	
	/**查看时间*/
	@JsonProperty("check_date")
	private Date checkDate;
	
	/**推送时间*/
	private Date pushDate;
	
	/**状态*/
	private String status;
	
	/**任务状态 实名认证本身状态**/
	@JsonProperty("audit_flag")
	private String auditFlag;
	
	
	/**审核描述CODE*/
	@JsonProperty("reject_code")
	private String rejectCode;
	
	/**手机号*/
	@JsonProperty("mobile_no")
	private String mobileno;

	private String startTime;

	private String endTime;



	
	/**地推类型*/
	private String audittype;
	
	public String getAudittype() {
		return audittype;
	}

	public void setAudittype(String audittype) {
		this.audittype = audittype;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public BasicDBObject getBody() {
		return body;
	}

	public void setBody(BasicDBObject body) {
		this.body = body;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public Date getAllocationDate() {
		return allocationDate;
	}

	public void setAllocationDate(Date allocationDate) {
		this.allocationDate = allocationDate;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
	public Date getDisposeDate() {
		return disposeDate;
	}

	public void setDisposeDate(Date disposeDate) {
		this.disposeDate = disposeDate;
	}

	public Date getPushDate() {
		return pushDate;
	}

	public void setPushDate(Date pushDate) {
		this.pushDate = pushDate;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getAuditFlag() {
		return auditFlag;
	}

	public void setAuditFlag(String auditFlag) {
		this.auditFlag = auditFlag;
	}

	public String getRejectCode() {
		return rejectCode;
	}

	public void setRejectCode(String rejectCode) {
		this.rejectCode = rejectCode;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}


	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
