/**
 * 
 */
package com.jfpay.dao.read;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jfpay.entity.DO.PayCustomer;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月5日
 */
@Repository
public interface IPayCustomerDao {
	/**
	 * 查询审核次数
	 * @param mobile
	 * @return
	 */
	public Long findCountPserson(String mobile);
	
	/**
	 * 百分比统计
	 */
	public  List<PayCustomer> findCustomerLevel(PayCustomer p);
	
	/**********
	 * 根据交易日期，查询客户审核总条数
	 * lihu 20150831
	 */
	public Long getCustomerCount(PayCustomer payCustomer);

}
