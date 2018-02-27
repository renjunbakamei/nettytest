/**
 * 
 */
package com.jfpay.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jfpay.dao.read.ILinkPersonExamDao;
import com.jfpay.entity.DO.LinkBlacklistPerson;
import com.jfpay.entity.DO.LinkPersonExam;
import com.jfpay.service.ILinkPersonExamService;
import com.jfpay.utils.MapConvertUtils;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月6日
 */
@Service
public class LinkPersonExamServiceImpl implements ILinkPersonExamService{
	@Autowired 
	private ILinkPersonExamDao iLinkPersonExamDao;
	@Override
	public List<LinkPersonExam> findLinkPersonExam(Map<String, Object> map) {
		String mobileNo = (String) map.get("mobile");
		List<LinkPersonExam> linkPersonExamList = iLinkPersonExamDao.findByMobileNo(mobileNo);
		return linkPersonExamList;
	}
	
	/**
	 * @author fuhw
	 * 查询
	 */
	@Override
	public PageInfo<LinkPersonExam> findLinkPersonExams(Map<String, Object> map) {
		LinkPersonExam object = null;
		try {
			object = (LinkPersonExam) MapConvertUtils.mapToObject(map, LinkPersonExam.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if((Integer)map.get("numPerPage")!=null||(Integer)map.get("numPerPage")!=0)
		{
			object.setNumPerPage((Integer)map.get("numPerPage"));
		}
		if((Integer)map.get("pageNum")!=null||(Integer)map.get("pageNum")!=0)
		{
			object.setPageNum((Integer)map.get("pageNum"));
		}
		PageHelper.startPage(object.getPageNum(), object.getNumPerPage());
		List<LinkPersonExam> list = iLinkPersonExamDao.selectLinkPersonExams(map);
		PageInfo<LinkPersonExam> info = new PageInfo<LinkPersonExam>(list);
		return info;
	}

	/**
	 * @author Shenly
	 */
	
	@Override
	public PageInfo<LinkPersonExam> findLinkPersonExamDetail(Map<String, Object> map) {
		LinkPersonExam object = null;
		try {
			object = (LinkPersonExam) MapConvertUtils.mapToObject(map, LinkPersonExam.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageHelper.startPage(object.getPageNum(), object.getNumPerPage());
		List<LinkPersonExam> list = iLinkPersonExamDao.findLinkPersonExamDetail(map);
		PageInfo<LinkPersonExam> info = new PageInfo<LinkPersonExam>(list);
		return info;
	}
/**
 * @author Shen
 */
	@Override
	public void addLinkPersonExam(Map<String, Object> map) {
		LinkPersonExam object = null;
		try {
			object = (LinkPersonExam) MapConvertUtils.mapToObject(map, LinkPersonExam.class);
		} catch (Exception e) {                                           
			e.printStackTrace();
		}
//	
		iLinkPersonExamDao.addLinkPersonExam(object);
		
	}

@Override
public void updateByIdLinkPersonExam(Map<String, Object> map) {
	LinkPersonExam object = null;
	try {
		object = (LinkPersonExam) MapConvertUtils.mapToObject(map, LinkPersonExam.class);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	iLinkPersonExamDao.updateByIdLinkPersonExam(object);
	
}

@Override
public PageInfo<LinkPersonExam> findLinkPersonExamByObj(Map<String, Object> map) {
	LinkPersonExam object = null;
	try {
		object = (LinkPersonExam) MapConvertUtils.mapToObject(map, LinkPersonExam.class);
	} catch (Exception e) {
		e.printStackTrace();
	}
	PageHelper.startPage(object.getPageNum(), object.getNumPerPage());
	List<LinkPersonExam> list = iLinkPersonExamDao.findLinkPersonExamByObj(map);
	PageInfo<LinkPersonExam> info = new PageInfo<LinkPersonExam>(list);
	return info;
}

}
