package com.jfpay.dao.read;


import java.util.List;
import java.util.Map;

import com.jfpay.entity.DO.LinkBlacklistPerson;
import com.jfpay.entity.DO.LinkBlacklistPic;

public interface ILinkBlacklistPicDao {

	public void addBlacklistPic(LinkBlacklistPic linkBlacklistPic); 
	public void updateBlacklistPic(LinkBlacklistPic LinkBlacklistPic);
	public LinkBlacklistPic getBlacklistPicById(LinkBlacklistPic LinkBlacklistPic);
	public LinkBlacklistPic findByPKId(LinkBlacklistPic LinkBlacklistPic);
	
	
	public List<LinkBlacklistPic> selectLinkBlacklistPics(Map<String,Object> map );
	public List<LinkBlacklistPic> findLinkBlacklistPicDetail(Map<String, Object> map);
	public List<LinkBlacklistPic> getBlacklistPicByObj(Map<String, Object> map);
	public void deleteLinkBlacklistPic(LinkBlacklistPic linkBlacklistPic);
}
