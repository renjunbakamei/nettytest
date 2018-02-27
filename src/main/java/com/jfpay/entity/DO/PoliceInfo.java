/*
 * Copyright 2017 jfpal.com All right reserved. This software is the
 * confidential and proprietary information of jfpal.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with jfpal.com.
 
 Created by jun.ren on 2017/4/20.
 
 */
package com.jfpay.entity.DO;

public class PoliceInfo  {
    private Long id;

    private String mobile;

    private String customerName;

    private String customerPid;

    private String policeResult;

    private String updateTime;

    private String createTime;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPid() {
        return customerPid;
    }

    public void setCustomerPid(String customerPid) {
        this.customerPid = customerPid;
    }

    public String getPoliceResult() {
        return policeResult;
    }

    public void setPoliceResult(String policeResult) {
        this.policeResult = policeResult;
    }
}
