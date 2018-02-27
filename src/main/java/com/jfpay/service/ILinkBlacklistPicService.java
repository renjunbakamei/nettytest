package com.jfpay.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.jfpay.entity.DO.LinkBlacklistPerson;
import com.jfpay.entity.DO.LinkBlacklistPic;

public interface ILinkBlacklistPicService {
	public void addBlacklistPic(Map<String, Object> map);
	public void updateBlacklistPic(Map<String, Object> map) ;
	public LinkBlacklistPic getBlacklistPicById(Map<String, Object> map);
	public LinkBlacklistPic findByPKId(Map<String, Object> map);
	
	public PageInfo<LinkBlacklistPic>  findLinkBlacklistPics(Map<String,Object> map);
	public PageInfo<LinkBlacklistPic>  findLinkBlacklistPicDetail(Map<String, Object> map);
	public void deleteLinkBlacklistPic(Map<String, Object> map);
	public PageInfo<LinkBlacklistPic> getBlacklistPicByObj(Map<String, Object> map);
	
}
