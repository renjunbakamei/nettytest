package com.jfpay.base.mongo.service;

import java.util.List;


/**
 * mongo base service
 * @author herion
 * 2014-12-8上午11:06:22
 */
public interface IMongoBaseService<RequestLog> {
	/**
	 * 添加对象
	 * @author herion
	 * 2014-12-8上午10:52:42
	 * @param entity
	 * @param collectionName 集合名称
	 */
	public void insert(RequestLog entity, String collectionName);
	
	public void insert(RequestLog entity);
	
	public RequestLog findOne(String id);  
	public List<RequestLog> findAll();
	public void removeOne(String id);  
	public void removeAll();  
}
