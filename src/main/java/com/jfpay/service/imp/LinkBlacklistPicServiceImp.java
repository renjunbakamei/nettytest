package com.jfpay.service.imp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jfpay.dao.read.ILinkBlacklistPicDao;
import com.jfpay.dao.read.linkThresholdDO;
import com.jfpay.entity.DO.LinkBlacklistPerson;
import com.jfpay.entity.DO.LinkBlacklistPic;
import com.jfpay.service.ILinkBlacklistPicService;
import com.jfpay.utils.MapConvertUtils;



@Service
@Transactional
public class LinkBlacklistPicServiceImp implements ILinkBlacklistPicService{
	@Resource
	ILinkBlacklistPicDao linkBlacklistPicDao;

	@Override
	public void addBlacklistPic(Map<String, Object> map) {
		// TODO Auto-generated method stub		
		LinkBlacklistPic object = null;
		try {
			object = (LinkBlacklistPic) MapConvertUtils.mapToObject(map, LinkBlacklistPic.class);
		} catch (Exception e) {                                           
			e.printStackTrace();
		}
		linkBlacklistPicDao.addBlacklistPic(object);
		
	}

	@Override
	public void updateBlacklistPic(Map<String, Object> map) {
		LinkBlacklistPic object = null;
		try {
			object = (LinkBlacklistPic) MapConvertUtils.mapToObject(map, LinkBlacklistPic.class);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		linkBlacklistPicDao.updateBlacklistPic(object);
		
	}

	@Override
	public LinkBlacklistPic getBlacklistPicById(Map<String, Object> map) {
		LinkBlacklistPic object = null;
		try {
			object = (LinkBlacklistPic) MapConvertUtils.mapToObject(map, LinkBlacklistPic.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		object = linkBlacklistPicDao.getBlacklistPicById(object);
		return object;
	}

	@Override
	public LinkBlacklistPic findByPKId(Map<String, Object> map) {
		LinkBlacklistPic object = null;
		try {
			object = (LinkBlacklistPic) MapConvertUtils.mapToObject(map, LinkBlacklistPic.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		object = linkBlacklistPicDao.findByPKId(object);
		return object;
		
	}

	@Override
	public PageInfo<LinkBlacklistPic> findLinkBlacklistPics(Map<String, Object> map) {
		LinkBlacklistPic object = null;
		try {
			object = (LinkBlacklistPic) MapConvertUtils.mapToObject(map, LinkBlacklistPic.class);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		PageHelper.startPage(object.getPageNum(), object.getNumPerPage());
		List<LinkBlacklistPic> list = linkBlacklistPicDao.selectLinkBlacklistPics(map);
		PageInfo<LinkBlacklistPic> info = new PageInfo<LinkBlacklistPic>(list);
		return info;
	}

	@Override
	public PageInfo<LinkBlacklistPic> findLinkBlacklistPicDetail(Map<String, Object> map) {
		LinkBlacklistPic object = null;
		try {
			object = (LinkBlacklistPic) MapConvertUtils.mapToObject(map, LinkBlacklistPic.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageHelper.startPage(object.getPageNum(), object.getNumPerPage());
		List<LinkBlacklistPic> list = linkBlacklistPicDao.findLinkBlacklistPicDetail(map);
		PageInfo<LinkBlacklistPic> info = new PageInfo<LinkBlacklistPic>(list);
		return info;
	}

	@Override
	public void deleteLinkBlacklistPic(Map<String, Object> map) {
		String id = (String)map.get("id");
		map.put("id", Integer.parseInt(id));
		LinkBlacklistPic object = null;
		try {
			object = (LinkBlacklistPic) MapConvertUtils.mapToObject(map, LinkBlacklistPic.class);
		} catch (Exception e) {                                           
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		linkBlacklistPicDao.deleteLinkBlacklistPic(object);
		
	}

	@Override
	public PageInfo<LinkBlacklistPic> getBlacklistPicByObj(Map<String, Object> map) {
		LinkBlacklistPic object = null;
		try {
			object = (LinkBlacklistPic) MapConvertUtils.mapToObject(map, LinkBlacklistPic.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageHelper.startPage(object.getPageNum(), object.getNumPerPage());
		List<LinkBlacklistPic> list = linkBlacklistPicDao.getBlacklistPicByObj(map);
		PageInfo<LinkBlacklistPic> info = new PageInfo<LinkBlacklistPic>(list);
		return info;
	}
	


}
