package com.jfpay.entity.DO;

import com.jfpay.base.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "RHDF_LIST")
public class RhdfListDO extends BaseEntity{
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="",sequenceName="RHDF_LIST_SEQ")
    private String id;

    @Column(name = "BANKNO")
    private String bankno;

    @Column(name = "BANKNAME")
    private String bankname;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "INCHANNEL")
    private String inchannel;

    @Column(name = "FUNDRESOURCES")
    private String fundresources;

    @Column(name = "REMARK1")
    private String remark1;

    @Column(name = "TRADEDELAY")
    private String tradedelay;

    @Column(name = "TRADECODE")
    private String tradecode;

    @Column(name = "ORIGDATE")
    private String origdate;

    @Column(name = "ORIGTIME")
    private String origtime;

    @Column(name = "ORIGLOGNO")
    private String origlogno;

    @Column(name = "INDATE")
    private String indate;

    @Column(name = "INTIME")
    private String intime;

    @Column(name = "OPER")
    private String oper;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CHECKDATE1")
    private String checkdate1;

    @Column(name = "CHECKTIME1")
    private String checktime1;

    @Column(name = "CHECKER1")
    private String checker1;

    @Column(name = "CHECKDATE2")
    private String checkdate2;

    @Column(name = "CHECKTIME2")
    private String checktime2;

    @Column(name = "CHECKER2")
    private String checker2;

    @Column(name = "BATCHNO")
    private String batchno;

    @Column(name = "BATCHSEQ")
    private String batchseq;

    @Column(name = "RETDATE")
    private String retdate;

    @Column(name = "RETTIME")
    private String rettime;

    @Column(name = "RETCODE")
    private String retcode;

    @Column(name = "RETMSG")
    private String retmsg;

    @Column(name = "OUTCHANNEL")
    private String outchannel;

    @Column(name = "MAC")
    private String mac;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return BANKNO
     */
    public String getBankno() {
        return bankno;
    }

    /**
     * @param bankno
     */
    public void setBankno(String bankno) {
        this.bankno = bankno == null ? null : bankno.trim();
    }

    /**
     * @return BANKNAME
     */
    public String getBankname() {
        return bankname;
    }

    /**
     * @param bankname
     */
    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    /**
     * @return ACCOUNT
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return ADDRESS
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return AMOUNT
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * @return REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return INCHANNEL
     */
    public String getInchannel() {
        return inchannel;
    }

    /**
     * @param inchannel
     */
    public void setInchannel(String inchannel) {
        this.inchannel = inchannel == null ? null : inchannel.trim();
    }

    /**
     * @return FUNDRESOURCES
     */
    public String getFundresources() {
        return fundresources;
    }

    /**
     * @param fundresources
     */
    public void setFundresources(String fundresources) {
        this.fundresources = fundresources == null ? null : fundresources.trim();
    }

    /**
     * @return REMARK1
     */
    public String getRemark1() {
        return remark1;
    }

    /**
     * @param remark1
     */
    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    /**
     * @return TRADEDELAY
     */
    public String getTradedelay() {
        return tradedelay;
    }

    /**
     * @param tradedelay
     */
    public void setTradedelay(String tradedelay) {
        this.tradedelay = tradedelay == null ? null : tradedelay.trim();
    }

    /**
     * @return TRADECODE
     */
    public String getTradecode() {
        return tradecode;
    }

    /**
     * @param tradecode
     */
    public void setTradecode(String tradecode) {
        this.tradecode = tradecode == null ? null : tradecode.trim();
    }

    /**
     * @return ORIGDATE
     */
    public String getOrigdate() {
        return origdate;
    }

    /**
     * @param origdate
     */
    public void setOrigdate(String origdate) {
        this.origdate = origdate == null ? null : origdate.trim();
    }

    /**
     * @return ORIGTIME
     */
    public String getOrigtime() {
        return origtime;
    }

    /**
     * @param origtime
     */
    public void setOrigtime(String origtime) {
        this.origtime = origtime == null ? null : origtime.trim();
    }

    /**
     * @return ORIGLOGNO
     */
    public String getOriglogno() {
        return origlogno;
    }

    /**
     * @param origlogno
     */
    public void setOriglogno(String origlogno) {
        this.origlogno = origlogno == null ? null : origlogno.trim();
    }

    /**
     * @return INDATE
     */
    public String getIndate() {
        return indate;
    }

    /**
     * @param indate
     */
    public void setIndate(String indate) {
        this.indate = indate == null ? null : indate.trim();
    }

    /**
     * @return INTIME
     */
    public String getIntime() {
        return intime;
    }

    /**
     * @param intime
     */
    public void setIntime(String intime) {
        this.intime = intime == null ? null : intime.trim();
    }

    /**
     * @return OPER
     */
    public String getOper() {
        return oper;
    }

    /**
     * @param oper
     */
    public void setOper(String oper) {
        this.oper = oper == null ? null : oper.trim();
    }

    /**
     * @return STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return CHECKDATE1
     */
    public String getCheckdate1() {
        return checkdate1;
    }

    /**
     * @param checkdate1
     */
    public void setCheckdate1(String checkdate1) {
        this.checkdate1 = checkdate1 == null ? null : checkdate1.trim();
    }

    /**
     * @return CHECKTIME1
     */
    public String getChecktime1() {
        return checktime1;
    }

    /**
     * @param checktime1
     */
    public void setChecktime1(String checktime1) {
        this.checktime1 = checktime1 == null ? null : checktime1.trim();
    }

    /**
     * @return CHECKER1
     */
    public String getChecker1() {
        return checker1;
    }

    /**
     * @param checker1
     */
    public void setChecker1(String checker1) {
        this.checker1 = checker1 == null ? null : checker1.trim();
    }

    /**
     * @return CHECKDATE2
     */
    public String getCheckdate2() {
        return checkdate2;
    }

    /**
     * @param checkdate2
     */
    public void setCheckdate2(String checkdate2) {
        this.checkdate2 = checkdate2 == null ? null : checkdate2.trim();
    }

    /**
     * @return CHECKTIME2
     */
    public String getChecktime2() {
        return checktime2;
    }

    /**
     * @param checktime2
     */
    public void setChecktime2(String checktime2) {
        this.checktime2 = checktime2 == null ? null : checktime2.trim();
    }

    /**
     * @return CHECKER2
     */
    public String getChecker2() {
        return checker2;
    }

    /**
     * @param checker2
     */
    public void setChecker2(String checker2) {
        this.checker2 = checker2 == null ? null : checker2.trim();
    }

    /**
     * @return BATCHNO
     */
    public String getBatchno() {
        return batchno;
    }

    /**
     * @param batchno
     */
    public void setBatchno(String batchno) {
        this.batchno = batchno == null ? null : batchno.trim();
    }

    /**
     * @return BATCHSEQ
     */
    public String getBatchseq() {
        return batchseq;
    }

    /**
     * @param batchseq
     */
    public void setBatchseq(String batchseq) {
        this.batchseq = batchseq == null ? null : batchseq.trim();
    }

    /**
     * @return RETDATE
     */
    public String getRetdate() {
        return retdate;
    }

    /**
     * @param retdate
     */
    public void setRetdate(String retdate) {
        this.retdate = retdate == null ? null : retdate.trim();
    }

    /**
     * @return RETTIME
     */
    public String getRettime() {
        return rettime;
    }

    /**
     * @param rettime
     */
    public void setRettime(String rettime) {
        this.rettime = rettime == null ? null : rettime.trim();
    }

    /**
     * @return RETCODE
     */
    public String getRetcode() {
        return retcode;
    }

    /**
     * @param retcode
     */
    public void setRetcode(String retcode) {
        this.retcode = retcode == null ? null : retcode.trim();
    }

    /**
     * @return RETMSG
     */
    public String getRetmsg() {
        return retmsg;
    }

    /**
     * @param retmsg
     */
    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg == null ? null : retmsg.trim();
    }

    /**
     * @return OUTCHANNEL
     */
    public String getOutchannel() {
        return outchannel;
    }

    /**
     * @param outchannel
     */
    public void setOutchannel(String outchannel) {
        this.outchannel = outchannel == null ? null : outchannel.trim();
    }

    /**
     * @return MAC
     */
    public String getMac() {
        return mac;
    }

    /**
     * @param mac
     */
    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }
}