/**
 * 
 */
package com.jfpay.dao.write;

import com.jfpay.entity.DO.PayCustomer;
import org.springframework.stereotype.Repository;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月5日
 */
@Repository
public interface IPayCustomerWriteDao {

	/**
	 * 更新paycustomer用户状态
	 * @param customer
	 * @return
	 */
	public int updateById_payCustomer(PayCustomer customer);
}
