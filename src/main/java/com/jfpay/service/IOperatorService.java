/**
 * 
 */
package com.jfpay.service;

import java.util.Map;

import com.jfpay.entity.DO.Operator;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月25日
 */
public interface IOperatorService {
	/**
	 * 修改用户状态
	 * Opertor 中loginId，stauts 必须要传
	 * @param opertor
	 * @return
	 */
	public void updateStatusById(Map<String, Object> map);
	
	
	/**
	 * 查询用户状态
	 */
	public Operator findOperatorStatus(Map<String, Object> map);
}
