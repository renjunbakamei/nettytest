/**
 * 
 */
package com.jfpay.service;

import java.util.List;
import java.util.Map;

import com.jfpay.entity.DO.PayCustomer;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月6日
 */
public interface IPayCustomerService {
	/**
	 * 查询审核次数
	 * @param mobile
	 * @return
	 */
	public Long findCountPserson(Map<String, Object> map);
	
	/**
	 * 百分比统计
	 */
	public List<PayCustomer> findCustomerLevel(Map<String, Object> map);
}
