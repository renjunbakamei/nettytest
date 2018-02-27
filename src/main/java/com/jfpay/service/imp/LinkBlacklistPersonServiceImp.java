package com.jfpay.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jfpay.dao.read.ILinkBlacklistPersonDao;
import com.jfpay.dao.write.ILinkBlacklistPersonWriteDao;
import com.jfpay.entity.DO.LinkBlacklistPerson;
import com.jfpay.service.ILinkBlacklistPersonService;
import com.jfpay.utils.MapConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LinkBlacklistPersonServiceImp implements ILinkBlacklistPersonService {
	
	@Resource
	private ILinkBlacklistPersonDao linkBlacklistPersonDao;

	@Resource
	private ILinkBlacklistPersonWriteDao iLinkBlacklistPersonWriteDao;
	/**
	 * 黑名单查询
	 * @author Shenly
	 */
	@Override
	public PageInfo<LinkBlacklistPerson> findLinkBlacklistPersons(Map<String,Object> map){
		LinkBlacklistPerson object = null;
		try {
			object = (LinkBlacklistPerson) MapConvertUtils.mapToObject(map, LinkBlacklistPerson.class);
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
		List<LinkBlacklistPerson> list = linkBlacklistPersonDao.selectLinkBlacklistPersons(map);
		PageInfo<LinkBlacklistPerson> info = new PageInfo<LinkBlacklistPerson>(list);
		return info;
	}
	/**
	 * 详情查看
	 * @author Shenly
	 */
	@Override
	public PageInfo<LinkBlacklistPerson> findLinkBlacklistPersonDetail(Map<String, Object> map) {
		LinkBlacklistPerson object = null;
		try {
			object = (LinkBlacklistPerson) MapConvertUtils.mapToObject(map, LinkBlacklistPerson.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageHelper.startPage(object.getPageNum(), object.getNumPerPage());
		//System.out.println("map="+map);
		List<LinkBlacklistPerson> list = linkBlacklistPersonDao.findLinkBlacklistPersonDetail(map);
		//System.out.println("list="+list);
		if(list.isEmpty())
		{
			list = linkBlacklistPersonDao.findLinkBlacklistPersonDetail2(map);
			//System.out.println("list2="+list);
			}
		
		PageInfo<LinkBlacklistPerson> info = new PageInfo<LinkBlacklistPerson>(list);
		return info;
	}
	/**
	 * 删除
	 * @author Shenly
	 */
	@Override
	public void deleteLinkBlacklistPerson(Map<String, Object> map) {
		//System.out.println("map="+map.toString());
		LinkBlacklistPerson object = null;
		try {
			object = (LinkBlacklistPerson) MapConvertUtils.mapToObject(map, LinkBlacklistPerson.class);
		} catch (Exception e) {                                           
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		object.setId(map.get("value").toString());
//		System.out.println("object="+object.getId());
		iLinkBlacklistPersonWriteDao.deleteLinkBlacklistPerson(object);
	}
	@Override
	public void updateByIdLinkBlacklistPerson(Map<String, Object> map) {
		LinkBlacklistPerson object = null;
		try {
			object = (LinkBlacklistPerson) MapConvertUtils.mapToObject(map, LinkBlacklistPerson.class);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		iLinkBlacklistPersonWriteDao.updateByIdLinkBlacklistPerson(object);
		
	}
	/**
	 * @author Shenly
	 */
	@Override
	public PageInfo<LinkBlacklistPerson> findBlackListByObj(Map<String, Object> map) {
		LinkBlacklistPerson object = null;
		try {
			object = (LinkBlacklistPerson) MapConvertUtils.mapToObject(map, LinkBlacklistPerson.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageHelper.startPage(object.getPageNum(), object.getNumPerPage());
		List<LinkBlacklistPerson> list = linkBlacklistPersonDao.findBlackListByObj(map);
		PageInfo<LinkBlacklistPerson> info = new PageInfo<LinkBlacklistPerson>(list);
		return info;
	}
	/**
	 * @author Shenly
	 */
	@Override
	public void addBlacklistPerson(Map<String, Object> map) {
		// TODO Auto-generated method stub		
				LinkBlacklistPerson object = null;
				try {
					object = (LinkBlacklistPerson) MapConvertUtils.mapToObject(map, LinkBlacklistPerson.class);
				} catch (Exception e) {                                           
					e.printStackTrace();
				}
//			
		iLinkBlacklistPersonWriteDao.addBlacklistPerson(object);
		
	}	
}
