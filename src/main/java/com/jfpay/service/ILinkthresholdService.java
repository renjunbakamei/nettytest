package com.jfpay.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.jfpay.dao.read.linkThresholdDO;

public interface ILinkthresholdService {
	public PageInfo<linkThresholdDO>  findLinkThresholds(Map<String,Object> map);
	public void updateByIdLinkThreshold(Map<String, Object> map) ;
	public PageInfo<linkThresholdDO> findListByObj(Map<String, Object> map);
	public linkThresholdDO findLinkThresholdByObj(Map<String, Object> map);

}
