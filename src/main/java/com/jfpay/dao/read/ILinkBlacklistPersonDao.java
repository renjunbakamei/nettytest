package com.jfpay.dao.read;


import java.util.List;
import java.util.Map;
import com.jfpay.entity.DO.LinkBlacklistPerson;

public interface ILinkBlacklistPersonDao {
	public List<LinkBlacklistPerson> selectLinkBlacklistPersons(Map<String,Object> map );
	public List<LinkBlacklistPerson> findLinkBlacklistPersonDetail(Map<String, Object> map);
	public List<LinkBlacklistPerson> findLinkBlacklistPersonDetail2(Map<String, Object> map);
	public void deleteLinkBlacklistPerson(LinkBlacklistPerson linkBlacklistPerson);
	public void updateByIdLinkBlacklistPerson(LinkBlacklistPerson linkBlacklistPerson);
	public List<LinkBlacklistPerson> findBlackListByObj(Map<String, Object> map);
	public void addBlacklistPerson(LinkBlacklistPerson linkBlacklistPerson);
	
	
}
