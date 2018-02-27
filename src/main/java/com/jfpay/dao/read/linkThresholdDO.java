package com.jfpay.dao.read;

import javax.persistence.*;

import com.jfpay.base.entity.BaseEntity;

@Table(name = "LINK_THRESHOLD")
public class linkThresholdDO  extends BaseEntity{
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "THRESHOLD_START")
    private int thresholdStart;

    @Column(name = "THRESHOLD_END")
    private int thresholdEnd;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getThresholdStart() {
		return thresholdStart;
	}

	public void setThresholdStart(int thresholdStart) {
		this.thresholdStart = thresholdStart;
	}

	public int getThresholdEnd() {
		return thresholdEnd;
	}

	public void setThresholdEnd(int thresholdEnd) {
		this.thresholdEnd = thresholdEnd;
	}

	public String getThresholdReamk() {
		return thresholdReamk;
	}

	public void setThresholdReamk(String thresholdReamk) {
		this.thresholdReamk = thresholdReamk;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getBackup1() {
		return backup1;
	}

	public void setBackup1(String backup1) {
		this.backup1 = backup1;
	}

	public String getBackup2() {
		return backup2;
	}

	public void setBackup2(String backup2) {
		this.backup2 = backup2;
	}

	public String getBackup3() {
		return backup3;
	}

	public void setBackup3(String backup3) {
		this.backup3 = backup3;
	}

	public String getIsExam() {
		return isExam;
	}

	public void setIsExam(String isExam) {
		this.isExam = isExam;
	}

	public String getThresholdNo() {
		return thresholdNo;
	}

	public void setThresholdNo(String thresholdNo) {
		this.thresholdNo = thresholdNo;
	}

	@Column(name = "THRESHOLD_REAMK")
    private String thresholdReamk;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATE_USER")
    private String createUser;

    @Column(name = "UPDATE_USER")
    private String updateUser;

    @Column(name = "CREATE_TIME")
    private String createTime;

    @Column(name = "UPDATE_TIME")
    private String updateTime;

    @Column(name = "BACKUP1")
    private String backup1;

    @Column(name = "BACKUP2")
    private String backup2;

    @Column(name = "BACKUP3")
    private String backup3;

    @Column(name = "IS_EXAM")
    private String isExam;

    @Column(name = "THRESHOLD_NO")
    private String thresholdNo;
    
    private String threshold;
    
    public String getThreshold() {
		return threshold;
	}

	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}

	private String confidence;

	public String getConfidence() {
		return confidence;
	}

	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}
}