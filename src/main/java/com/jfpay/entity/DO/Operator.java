package com.jfpay.entity.DO;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 操作员 entity
 * @author herion
 * 2015-1-5下午3:08:47
 */
@Document(collection="OPERATOR")
public class Operator {
	/**操作员名*/
	@JsonProperty("user_name")
	private String userName;
	/**操作员反洗钱平台ID*/
	@JsonProperty("login_id")
	private int loginId;
	/**操作员状态*/
	private String status;
	/**操作员是否可用 0：是，1：否*/
	@JsonProperty("id_delete")
	private int isDelete;
	
	private Date createDate;
	
	private Date updDate;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdDate() {
		return updDate;
	}
	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}
	
	
}
