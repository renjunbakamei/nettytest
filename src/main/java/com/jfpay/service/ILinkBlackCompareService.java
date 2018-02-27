/**
 * 
 */
package com.jfpay.service;

import java.util.List;
import java.util.Map;

import com.jfpay.entity.DO.LinkBlackCompare;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月7日
 */
public interface ILinkBlackCompareService {

	/**
	 * @param map
	 * @return
	 */
	List<LinkBlackCompare> findLinkBlackCompareListByObj(Map<String, Object> map);
}
