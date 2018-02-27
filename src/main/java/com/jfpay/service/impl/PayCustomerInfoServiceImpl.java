package com.jfpay.service.impl;

import com.jfpay.constants.PersonStatus;
import com.jfpay.core.constant.CoreConstants;
import com.jfpay.core.util.RedisClientUtils;
import com.jfpay.dao.mongo.entity.PersonalInfoAuditJob;
import com.jfpay.dao.write.IPayCustomerWriteDao;
import com.jfpay.dao.write.IPrepPersonalinfoDaoWrite;
import com.jfpay.entity.DO.PayCustomer;
import com.jfpay.entity.DO.PrepPersonalinfo;
import com.jfpay.service.IPayCustomerInfoService;
import com.jfpay.service.IPersonalInfoAuditJobService;
import com.jfpay.utils.DateUtil;
import com.jfpay.utils.DituiUtils;
import com.jfpay.utils.FormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PayCustomerInfoServiceImpl implements IPayCustomerInfoService {

    private static final Logger LOG = LoggerFactory.getLogger(PayCustomerInfoServiceImpl.class);

    @Autowired
    private IPrepPersonalinfoDaoWrite prepPersonalinfoDaoWrite;

    @Autowired
    private IPayCustomerWriteDao payCustomerWriteDao;

    @Autowired
    private RedisClientUtils redisClientUtils;

    @Autowired
    private IPersonalInfoAuditJobService personalInfoAuditJobService;

    @Autowired
    private DituiUtils dateUtil;

    /**
     * 处理业务逻辑
     * 1、修改客户信息状态
     * 2、修改图片信息状态
     * 3、释放mongo任务
     *
     * @param info
     * @return
     */
    @Override
    public void savePayCustomerInfo(PrepPersonalinfo info,String userid) throws Exception {
        String respMsgCode = "";
        //修改图片信息
        int returnPerson = prepPersonalinfoDaoWrite.updateById_prepPersonalinfo(info);
        //修改客户信息
        PayCustomer p = new PayCustomer();
        p.setCustomerid(info.getCustomerid());//客户id
        p.setCustomertag(info.getAuditflag());//客户状态
        p.setBlank3(info.getPidValidityDate());//身份证到期日期
        p.setChangeTime(FormatUtils.time());
        p.setViplevel(Long.parseLong(info.getViplevel()));
        int returnCustomer = payCustomerWriteDao.updateById_payCustomer(p);
        if (returnPerson == 1 && returnCustomer == 1) {
            if (PersonStatus.CUSTOMER_TAG3.equals(info.getAuditflag())) {
                //redis工具类会将key值上面自动加上imp_audit的prefix
                redisClientUtils.deleteByKey(info.getMobileno());
            } else {
                redisClientUtils.set(info.getMobileno(), info.getExamuser());
            }
            //更改成功以后，返回任务id，处理核心任务
            Date payDate = null;
            try {
                payDate = DateUtil.getDateByThreadLocal(info.getCheckDate());
                LOG.info("查看时间：{},客户手机号:{}", payDate, info.getMobileno());
            } catch (Exception e) {
                LOG.error("转换时间异常:{}",e);
                LOG.info("{}",e);
            }
            PersonalInfoAuditJob job = new PersonalInfoAuditJob();
            job.setCheckDate(payDate);
            job.setOperatorName(info.getExamuser());
            job.setOperatorId(Integer.valueOf(userid));
            job.setDisposeDate(new Date());
            job.setId(info.getTaskId());
            job.setAuditFlag(info.getAuditflag());
            job.setRejectCode(info.getRejectcode());
            job.setStatus(CoreConstants.JOB_STATUS_99);
            personalInfoAuditJobService.jobUpdateFirst(job);
        }
    }
}
