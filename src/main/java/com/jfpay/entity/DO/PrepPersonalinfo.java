/**
 * 
 */
package com.jfpay.entity.DO;

import com.jfpay.Annotation.OtherName;

/**
 * @author dongyuqiang
 *
 * @date 2017年8月30日
 */
public class PrepPersonalinfo {
	//修改时间
	private String timestamp;
	//客户ID
	@OtherName(targetClass = "CertificateBean", name = "customer")
	private String customerid;
	//手机号
	@OtherName(targetClass = "CertificateBean", name = "num_mobile")
	private String mobileno;
	//审核标志
	@OtherName(targetClass = "CertificateBean", name = "flag_audit")
	private String auditflag;
	//创建日期
	private String createdate;
	//创建时间
	private String createtime;
	//驳回原因
	@OtherName(targetClass = "CertificateBean", name = "remark")
	private String remark;
	//身份证正面图片
	private String pidimgpath;
	//身份证反面图片
	private String pidantiimgpath;
	//持证图片路径
	private String picpath;
	//头像(大头贴)
	private String mugshotpath;

	private String logo;
	@OtherName(targetClass = "CertificateBean", name = "customer")
	private String rejectcode;
	@OtherName(targetClass = "CertificateBean", name = "customer")
	private String rejectreason;
	@OtherName(targetClass = "CertificateBean",name="date_exam")
	private String examdate;
	@OtherName(targetClass = "CertificateBean",name="user_audit")
	private String examuser;
	@OtherName(targetClass = "CertificateBean",name="date_pidValidity")
	private String pidValidityDate;
	private String pidimg;
	private String pidantiimg;
	private String pic;
	private String mugshot;

	private String guarantorPic;
	private String username;
	private String imgType;  //照片存储类型，1、pm后台上传；2、pmout后台上传；空代表客户端上传

	private String customerName;  //客户名称
	private String customerPid;  //身份证号
	private String blank3;  //身份证到期时间

	@OtherName(targetClass = "CertificateBean",name="id_task")
	private String taskId;  //任务ID
	@OtherName(targetClass = "CertificateBean",name="date_check")
	private String checkDate;  //查看日期

	private String auditChannel;  //获取任务状态
	@OtherName(targetClass = "CertificateBean",name="viplevel")
	private String viplevel;//用户等级
	private String userIp;//用户IP

	@OtherName(targetClass = "CertificateBean",name="audittype")
	private String audittype;//递推类型
	private String groupimgpath;//业务员合照

	private String usernamehidden;//解密手机号

	private String customerpidhidden;//解密身份证号

	private String productType;// 1 daibiao xinjifubao

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public void setUsernamehidden(String usernamehidden) {
		this.usernamehidden = usernamehidden;
	}

	public String getCustomerpidhidden() {
		return customerpidhidden;
	}

	public void setCustomerpidhidden(String customerpidhidden) {
		this.customerpidhidden = customerpidhidden;
	}

	public String getUsernamehidden() {
		return usernamehidden;
	}


	public String getGroupimgpath() {
		return groupimgpath;
	}

	public void setGroupimgpath(String groupimgpath) {
		this.groupimgpath = groupimgpath;
	}

	public String getAudittype() {
		return audittype;
	}

	public void setAudittype(String audittype) {
		this.audittype = audittype;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getViplevel() {
		return viplevel;
	}

	public void setViplevel(String viplevel) {
		this.viplevel = viplevel;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getAuditflag() {
		return auditflag;
	}

	public void setAuditflag(String auditflag) {
		this.auditflag = auditflag;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPidimgpath() {
		return pidimgpath;
	}

	public void setPidimgpath(String pidimgpath) {
		this.pidimgpath = pidimgpath;
	}

	public String getPidantiimgpath() {
		return pidantiimgpath;
	}

	public void setPidantiimgpath(String pidantiimgpath) {
		this.pidantiimgpath = pidantiimgpath;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public String getMugshotpath() {
		return mugshotpath;
	}

	public void setMugshotpath(String mugshotpath) {
		this.mugshotpath = mugshotpath;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getRejectcode() {
		return rejectcode;
	}

	public void setRejectcode(String rejectcode) {
		this.rejectcode = rejectcode;
	}

	public String getRejectreason() {
		return rejectreason;
	}

	public void setRejectreason(String rejectreason) {
		this.rejectreason = rejectreason;
	}

	public String getExamdate() {
		return examdate;
	}

	public void setExamdate(String examdate) {
		this.examdate = examdate;
	}

	public String getExamuser() {
		return examuser;
	}

	public void setExamuser(String examuser) {
		this.examuser = examuser;
	}

	public String getPidValidityDate() {
		return pidValidityDate;
	}

	public void setPidValidityDate(String pidValidityDate) {
		this.pidValidityDate = pidValidityDate;
	}

	public String getGuarantorPic() {
		return guarantorPic;
	}

	public void setGuarantorPic(String guarantorPic) {
		this.guarantorPic = guarantorPic;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPidimg() {
		return pidimg;
	}

	public void setPidimg(String pidimg) {
		this.pidimg = pidimg;
	}

	public String getPidantiimg() {
		return pidantiimg;
	}

	public void setPidantiimg(String pidantiimg) {
		this.pidantiimg = pidantiimg;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getMugshot() {
		return mugshot;
	}

	public void setMugshot(String mugshot) {
		this.mugshot = mugshot;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
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

	public String getBlank3() {
		return blank3;
	}

	public void setBlank3(String blank3) {
		this.blank3 = blank3;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getAuditChannel() {
		return auditChannel;
	}

	public void setAuditChannel(String auditChannel) {
		this.auditChannel = auditChannel;
	}
}
