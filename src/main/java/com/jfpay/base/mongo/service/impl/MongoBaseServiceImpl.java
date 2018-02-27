package com.jfpay.base.mongo.service.impl;

import com.jfpay.base.mongo.dao.IMongoBaseDao;
import com.jfpay.base.mongo.service.IMongoBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * mongoDB base service impl
 * @author herion
 * 2014-12-8上午11:09:08
 */
@Service("mongoBaseService")
public class MongoBaseServiceImpl<RequestLog> implements IMongoBaseService<RequestLog> {
	@SuppressWarnings("rawtypes")
	@Autowired
	private IMongoBaseDao mongoBaseDao;
	
	
	/**
	 * 添加对象
	 * @author herion
	 * 2014-12-8上午11:09:29
	 * @param entity
	 * @param collectionName
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void insert(RequestLog entity, String collectionName) {
		mongoBaseDao.insert(entity, collectionName);
	}

	/**
	 * 根据ID查找对象
	 * 
	 * @author herion 
	 * 2014-12-4上午10:01:25
	 * @param id
	 * @return
	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public RequestLog findOne(String id) {
//		//return (RequestLog) mongoBaseDao.findOne(id);
//	}

	/**
	 * 查询所有
	 * @author herion 
	 * 2014-12-4上午10:01:37
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RequestLog> findAll() {
		return mongoBaseDao. findAll();
	}

	/**
	 * 删除指定的ID对象
	 * 
	 * @author herion 2014-12-4上午10:01:49
	 * @param id
	 */
	@Override
	public void removeOne(String id) {
		mongoBaseDao.removeOne(id);
	}

	/**
	 * 删除所有
	 * 
	 * @author herion 2014-12-4上午10:02:34
	 */
	@Override
	public void removeAll() {
		mongoBaseDao.removeAll();
	}
	
	/**
	 * 添加对象
	 * @author herion
	 * 2014-12-9下午3:41:17
	 * @param entity
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void insert(RequestLog entity) {
		mongoBaseDao.insert(entity);
	}

	@Override
	public RequestLog findOne(String id) {
		return null;
	}
}
