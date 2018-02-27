package com.jfpay.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.jfpay.entity.DO.LinkBlacklistPerson;


public interface ILinkBlacklistPersonService {
	public PageInfo<LinkBlacklistPerson>  findLinkBlacklistPersons(Map<String,Object> map);
	public PageInfo<LinkBlacklistPerson>  findLinkBlacklistPersonDetail(Map<String, Object> map);
	public void deleteLinkBlacklistPerson(Map<String, Object> map);
	public void updateByIdLinkBlacklistPerson(Map<String, Object> map) ;
	public PageInfo<LinkBlacklistPerson> findBlackListByObj(Map<String, Object> map);
	public void addBlacklistPerson(Map<String, Object> map);
}
