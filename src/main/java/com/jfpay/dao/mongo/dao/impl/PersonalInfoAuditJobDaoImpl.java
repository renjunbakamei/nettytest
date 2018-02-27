/**
 * 
 */
package com.jfpay.dao.mongo.dao.impl;

import org.springframework.stereotype.Repository;

import com.jfpay.base.mongo.dao.impl.MongoBaseDaoImpl;
import com.jfpay.dao.mongo.dao.IPersonalInfoAuditJobDao;
import com.jfpay.dao.mongo.entity.PersonalInfoAuditJob;
import com.jfpay.dao.mongo.entity.vo.PersonalInfoAuditJobVO;

/**
 *  实名认证 任务 DAO实现
 * @author dongyuqiang
 * @date 2017年8月30日
 */
@Repository("personalInfoAuditJobDao")
public class PersonalInfoAuditJobDaoImpl extends MongoBaseDaoImpl<PersonalInfoAuditJob, PersonalInfoAuditJobVO> implements IPersonalInfoAuditJobDao{

}
