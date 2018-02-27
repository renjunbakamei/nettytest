package com.jfpay.service.impl;

import com.jfpay.biz.PersonalInfoSendMsgBiz;
import com.jfpay.constants.PersonStatus;
import com.jfpay.core.constant.CoreConstants;
import com.jfpay.dao.mongo.entity.PersonalInfoAuditJob;
import com.jfpay.entity.DO.PrepPersonalinfo;
import com.jfpay.generated.CertifacationService;
import com.jfpay.generated.CertificateBean;
import com.jfpay.generated.CertificateResp;
import com.jfpay.service.IPayCustomerInfoService;
import com.jfpay.utils.DituiUtils;
import com.mongodb.BasicDBObject;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class CertifacationServiceImpl implements CertifacationService.Iface {

    private final static Logger LOG= LoggerFactory.getLogger(CertifacationServiceImpl.class);

    @Autowired
    private DituiUtils dituiUtils;

    @Autowired
    private IPayCustomerInfoService payCustomerInfoService;

    @Autowired
    private PersonalInfoSendMsgBiz personalInfoSendMsgBiz;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Value("${collectionName}")
    private String collectionName;

    @Override
    public CertificateResp doCertifacate(CertificateBean param) throws TException {
        LOG.info("==========开始个人实名认证审核模块===========");
        LOG.info("用户手机号：{}",param.getNum_mobile());
        LOG.info("用户实名认证结果信息:{}",param);
        CertificateResp certificateResp;
        if (PersonStatus.CUSTOMER_TAG3.equals(param.getFlag_audit()) || PersonStatus.CUSTOMER_TAG4.equals(param.getFlag_audit()) || PersonStatus.CUSTOMER_TAGC.equals(param.getFlag_audit())
                || PersonStatus.CUSTOMER_TAGB.equals(param.getFlag_audit())|| PersonStatus.CUSTOMER_TAG4A.equals(param.getFlag_audit())
                || PersonStatus.CUSTOMER_TAG3A.equals(param.getFlag_audit())){
            int num=2;
            //将用户id和名称统一放在auditUser字段，使用-分割
            String[] userInfo=param.getUser_audit().split("-");
            PrepPersonalinfo prepPersonalinfo=transCertificateToPer(param,userInfo[1]);
            Criteria criteria=new Criteria();
            criteria.and("_id").is(new ObjectId(prepPersonalinfo.getTaskId()));
            PersonalInfoAuditJob job=mongoTemplate.findOne(new Query(criteria),PersonalInfoAuditJob.class,collectionName);
            BasicDBObject bb=job.getBody();
            if("1".equals(bb.getString("productType"))) {
                prepPersonalinfo.setProductType("1");
            }
            String result=dituiUtils.directDiTui(prepPersonalinfo, CoreConstants.TYPE_PERSON,num,"");
            if(StringUtils.isBlank(result))
            {
                return new CertificateResp(CoreConstants.CODE_ERROR,CoreConstants.ERROR_MESS_D);
            }
            //修改用户申明认证信息
            boolean send=false;
            try {
                payCustomerInfoService.savePayCustomerInfo(prepPersonalinfo,userInfo[0]);
                certificateResp=new CertificateResp(CoreConstants.CODE_SUCCESS,CoreConstants.SUCESSCUSTOMERMESSAGE);
                if(PersonStatus.CUSTOMER_TAG3.equals(param.getFlag_audit())){
                    send=true;
                }
            }catch (Exception e){
                LOG.info("{}实名认证审核异常:{}",param.getNum_mobile(),e);
                certificateResp=new CertificateResp(CoreConstants.CODE_ERROR,CoreConstants.ERROR_MESS);
                send=false;
            }
            if(send){
                personalInfoSendMsgBiz.sendMsg(param.getNum_mobile());
            }
        }else{
            certificateResp= new CertificateResp(CoreConstants.CODE_ERROR,CoreConstants.PAYCUSTOMER_TAG);
        }
        LOG.info("用户{}返回:{}-{}",new Object[]{param.getNum_mobile(),certificateResp.getCode_resp(),certificateResp.getMessage_resp()});
        LOG.info("==========结束个人实名认证审核模块===========");
        return certificateResp;
    }

    PrepPersonalinfo transCertificateToPer(CertificateBean param,String username){
        PrepPersonalinfo prepPersonalinfo=new PrepPersonalinfo();
        prepPersonalinfo.setCustomerid(param.getCustomer());
        prepPersonalinfo.setMobileno(param.getNum_mobile());
        prepPersonalinfo.setAuditflag(param.getFlag_audit());
        prepPersonalinfo.setRemark(param.getRemark());
        prepPersonalinfo.setTaskId(param.getId_task());
        prepPersonalinfo.setCheckDate(param.getDate_check());
        prepPersonalinfo.setExamdate(param.getDate_exam());
        prepPersonalinfo.setExamuser(username);
        prepPersonalinfo.setPidValidityDate(param.getDate_pidValidity());
        prepPersonalinfo.setRejectcode(param.getCode_reject());
        prepPersonalinfo.setRejectreason(param.getReason_reject());
        prepPersonalinfo.setViplevel(param.getViplevel());
        prepPersonalinfo.setAudittype(param.getAudittype());
        return prepPersonalinfo;
    }
}
