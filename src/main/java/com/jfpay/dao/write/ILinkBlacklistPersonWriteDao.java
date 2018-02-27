package com.jfpay.dao.write;


import com.jfpay.entity.DO.LinkBlacklistPerson;

import java.util.List;
import java.util.Map;

public interface ILinkBlacklistPersonWriteDao {
	public List<LinkBlacklistPerson> selectLinkBlacklistPersons(Map<String, Object> map);
	public List<LinkBlacklistPerson> findLinkBlacklistPersonDetail(Map<String, Object> map);
	public List<LinkBlacklistPerson> findLinkBlacklistPersonDetail2(Map<String, Object> map);
	public void deleteLinkBlacklistPerson(LinkBlacklistPerson linkBlacklistPerson);
	public void updateByIdLinkBlacklistPerson(LinkBlacklistPerson linkBlacklistPerson);
	public List<LinkBlacklistPerson> findBlackListByObj(Map<String, Object> map);
	public void addBlacklistPerson(LinkBlacklistPerson linkBlacklistPerson);
	
	
}
