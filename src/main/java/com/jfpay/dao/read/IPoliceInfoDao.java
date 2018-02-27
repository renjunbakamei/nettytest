/**
 * 
 */
package com.jfpay.dao.read;

import java.util.List;

import com.jfpay.entity.DO.PoliceInfo;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月7日
 */
public interface IPoliceInfoDao {
	public List<PoliceInfo> findPoliceInfoListByCid(String pid);
}
