/**
 * 
 */
package com.jfpay.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfpay.dao.read.ILinkBlackCompareDao;
import com.jfpay.entity.DO.LinkBlackCompare;
import com.jfpay.service.ILinkBlackCompareService;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月7日
 */
@Service
public class LinkBlackCompareServiceImpl implements ILinkBlackCompareService {
	@Autowired 
	private ILinkBlackCompareDao linkBlackCompareDao;
	@Override
	public List<LinkBlackCompare> findLinkBlackCompareListByObj(Map<String, Object> map) {
		String examId = (String) map.get("examid");
		List<LinkBlackCompare> linkBlackCompares = linkBlackCompareDao.findListByObj(examId);
		return linkBlackCompares;
	}

	

}
