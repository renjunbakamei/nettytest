/**
 * 
 */
package com.jfpay.dao.read;

import java.util.List;

import com.jfpay.entity.DO.LinkBlackCompare;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月7日
 */
public interface ILinkBlackCompareDao {
	/**
	 * 根据自定义的对象查询,返回满足条件集合
	 */
	public List<LinkBlackCompare> findListByObj(String examId);
}
