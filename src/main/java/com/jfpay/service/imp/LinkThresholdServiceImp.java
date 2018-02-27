package com.jfpay.service.imp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jfpay.dao.read.linkThresholdDO;
import com.jfpay.dao.read.linkThresholdReadDao;
import com.jfpay.service.ILinkthresholdService;
import com.jfpay.utils.MapConvertUtils;

@Service
@Transactional
public class LinkThresholdServiceImp implements ILinkthresholdService {
	@Resource
	private linkThresholdReadDao linkThresholdReadDao;

	/**
	 * @author fuhw
	 * 查询
	 */
	@Override
	public PageInfo<linkThresholdDO> findLinkThresholds(Map<String, Object> map) {
		// TODO Auto-generated method stub
		linkThresholdDO object = null;
		try {
			object = (linkThresholdDO) MapConvertUtils.mapToObject(map, linkThresholdDO.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object object2 = map.get("threshold");
		map.put("threshold", Integer.parseInt(object2.toString()));
		PageHelper.startPage(object.getPageNum(), object.getNumPerPage());
		map.put("threshold",object.getThreshold()==null||"".equals(object.getThreshold())?0:Integer.parseInt(object.getThreshold()));
		List<linkThresholdDO> list = linkThresholdReadDao.selectLinkThresholds(map);
		PageInfo<linkThresholdDO> info = new PageInfo<linkThresholdDO>(list);
		return info;
	}

	/**
	 * 修改阈值
	 *  @author fuhw
	 * @param map
	 */
	public void updateByIdLinkThreshold(Map<String, Object> map) {
		linkThresholdDO object = null;
		try {
			object = (linkThresholdDO) MapConvertUtils.mapToObject(map, linkThresholdDO.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		linkThresholdReadDao.updateByIdLinkThreshold(object);
	}
	@Override
	public linkThresholdDO findLinkThresholdByObj(Map<String, Object> map) {
		linkThresholdDO object = null;
		try {
			object = (linkThresholdDO) MapConvertUtils.mapToObject(map, linkThresholdDO.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		object=linkThresholdReadDao.findLinkThreshold(object);
		return object;
	}
	
	
	/**
	 * @author fuhw
	 * 
	 * 初始化/编辑页
	 */
	public PageInfo<linkThresholdDO> findListByObj(Map<String, Object> map){
		 List<linkThresholdDO> list = linkThresholdReadDao.findListByObj(map);
		 PageInfo<linkThresholdDO> info = new PageInfo<linkThresholdDO>(list);
       return info;
		
	}

}
