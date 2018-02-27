/**
 * 
 */
package com.jfpay.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfpay.dao.read.IPoliceInfoDao;
import com.jfpay.entity.DO.PoliceInfo;
import com.jfpay.service.IPoliceInfoService;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月7日
 */
@Service
public class PoliceInfoServiceImpl implements IPoliceInfoService{
	@Autowired 
	private IPoliceInfoDao iPoliceInfoDao;
	@Override
	public List<PoliceInfo> findPoliceInfoListByCid(Map<String, Object> map) {
		String pid = (String) map.get("cid");
		List<PoliceInfo> findPoliceInfoListByCid = iPoliceInfoDao.findPoliceInfoListByCid(pid);
		return findPoliceInfoListByCid;
	}
	
	
}
