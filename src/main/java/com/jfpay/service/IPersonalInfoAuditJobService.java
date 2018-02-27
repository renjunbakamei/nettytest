/**
 * 
 */
package com.jfpay.service;

import java.util.List;
import java.util.Map;

import com.jfpay.dao.mongo.entity.PersonalInfoAuditJob;
import com.jfpay.dao.mongo.entity.vo.PersonalInfoAuditJobVO;
import com.jfpay.entity.DO.PrepPersonalinfo;
import com.jfpay.entity.vo.PrepPersonalinfoVO;

/**
 * 实名认证任务 业务接口
 * 
 * @author dongyuqiang
 *
 * @date 2017年8月30日
 */
public interface IPersonalInfoAuditJobService {
	/**
	 * 根据手机号获得实名认证信息
	 * 
	 * @param personalInfoAuditJob
	 * @return
	 */
	public List<PersonalInfoAuditJobVO> operatorListBymobileNo(Map<String, Object> map);

	/**
	 * 修改一个任务 注意任务ID 与任务状态参数传入
	 */
	public void jobUpdateFirst(PersonalInfoAuditJob personalInfoAuditJob);

	/**
	 * 根据客户编码，查找该客户实名详细信息
	 */
	public PrepPersonalinfoVO findPersonalInfoDetail(Map<String, Object> map);

	/**
	 * 获取操作员列表
	 * 
	 * @param map
	 * @return
	 */
	public List<PersonalInfoAuditJobVO> findOperatorList(Map<String, Object> map);

	/**
	 * 实名认证统计
	 * 
	 * @param map
	 * @return
	 */
	public Map<String, Object> personalInfoAuditJobTotal(Map<String, Object> map);

}
