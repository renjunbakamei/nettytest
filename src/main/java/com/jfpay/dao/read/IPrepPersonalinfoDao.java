/**
 * 
 */
package com.jfpay.dao.read;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jfpay.entity.DO.PrepPersonalinfo;

import tk.mybatis.mapper.common.Mapper;



/**
 * @author dongyuqiang
 *
 * @date 2017年8月30日
 */
@Repository
public interface IPrepPersonalinfoDao extends Mapper<PrepPersonalinfo>{
	/*********
	 * 查询用户状态
	 * @param presonInfo
	 * @return
	 */
	public List<PrepPersonalinfo> findPersonList(PrepPersonalinfo prepPersonalinfo);
	/************
	 *根据客户ID，查找出客户详细信息
	 */
	public PrepPersonalinfo findPrepPersonalById(PrepPersonalinfo prepPersonalinfo);

}
