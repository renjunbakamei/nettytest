/**
 * 
 */
package com.jfpay.dao.mongo.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.BasicDBObject;

import java.util.Date;

/**
 * 实名认证任务 响应VO
 * @author dongyuqiang
 *
 * @date 2017年8月30日
 */
public class PersonalInfoAuditJobVO {
	private String id;
	/**body*/
	private BasicDBObject body;
	
	/**接收时间*/
	@JsonProperty("receive_date")
	private Date receiveDate;
	
	/**分配时间*/
	@JsonProperty("allocation_date")
	private Date allocationDate;
	
	/**操作员ID*/
	@JsonProperty("operator_id")
	private int operatorId;
	
	/**操作员名称*/
	@JsonProperty("operator_name")
	private String operatorName;
	
	/**处理时间*/
	@JsonProperty("dispose_date")
	private Date disposeDate;
	
	/**推送时间*/
	@JsonProperty("push_date")
	private Date pushDate;
	
	/**状态*/
	private String status;
	
	/**任务状态 实名认证本身状态**/
	@JsonProperty("audit_flag")
	private String auditFlag;
	
	/**手机号*/
	@JsonIgnore
	private String mobileno;

	public BasicDBObject getBody() {
		return body;
	}

	public void setBody(BasicDBObject body) {
		this.body = body;
	}

	public Date getReceiveDate() {
		return receiveDate;
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

	public String getAuditFlag() {
		return auditFlag;
	}

	public void setAuditFlag(String auditFlag) {
		this.auditFlag = auditFlag;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
}
