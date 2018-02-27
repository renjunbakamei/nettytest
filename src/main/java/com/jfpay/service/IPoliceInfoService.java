/**
 * 
 */
package com.jfpay.service;

import java.util.List;
import java.util.Map;

import com.jfpay.entity.DO.PoliceInfo;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月7日
 */
public interface IPoliceInfoService {
	public List<PoliceInfo> findPoliceInfoListByCid(Map<String,Object> map);
}
