/**
 * 
 */
package com.jfpay.dao.read;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jfpay.entity.vo.RejectinfoVO;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月5日
 */
@Repository
public interface IRejectinfoDao extends Mapper<RejectinfoVO>{
	/************
	 * 查询所有的数据
	 */
	public List<RejectinfoVO> findRejectInfoAll();

	/**
	 * 根据自定义的对象查询,返回满足条件集合
	 */
	public List<RejectinfoVO> findListByObj(RejectinfoVO rejectinfo);
	
}
