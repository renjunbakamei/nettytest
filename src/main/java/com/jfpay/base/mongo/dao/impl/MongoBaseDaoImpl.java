package com.jfpay.base.mongo.dao.impl;

import com.jfpay.base.mongo.dao.IMongoBaseDao;
import com.jfpay.base.mongo.entity.MongoPage;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


/**
 * mongoDB 公用DAO 实现类
 * 
 * @author herion
 * 
 * @param <E>
 */
@Repository("mongoBaseDao")
public class MongoBaseDaoImpl<E,V> implements IMongoBaseDao<E,V> {
	public Class<E> entityClass;
	
	public Class<V> vClass;
	
	public MongoTemplate mongoTemplate;
	
	@SuppressWarnings("unchecked")
	public MongoBaseDaoImpl() {
		entityClass = guessEntityClass(getClass(),0);
		vClass= guessEntityClass(getClass(),1);
	}
	
	@SuppressWarnings("rawtypes")
	public static Class guessEntityClass(Class clazz,int i) {
		Type type = clazz.getGenericSuperclass();
		Class retval = null;
		if (type instanceof ParameterizedType) {
			Type[] params = ((ParameterizedType) type).getActualTypeArguments();
			retval = (Class) params[i];
		}
		return retval;
	}
	
	/**
	 * 添加对象
	 * @author herion
	 * 2014-12-9下午3:40:17
	 * @param entity
	 */
	@Override
	public void insert(E entity) {
		mongoTemplate.insert(entity);
	}
	
	/**
	 * 添加对象
	 * @author herion
	 * 2014-12-8下午10:22:30
	 * @param entity
	 * @param collectionName 集合名称
	 */
	@Override
	public void insert(E entity,String collectionName) {
		mongoTemplate.insert(entity,collectionName);
	}

	/**
	 * 根据ID查找对象
	 * 
	 * @author herion 
	 * 2014-12-4上午10:01:25
	 * @param id
	 * @return
	 */
	@Override
	public E findOne(String id,String collectionName,Class<E> entityClas) {
		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),entityClas,collectionName);
	}
	

	/**
	 * 查询所有
	 * @author herion 
	 * 2014-12-4上午10:01:37
	 * @return
	 */
	@Override
	public List<E> findAll() {
		return mongoTemplate.find(new Query(), entityClass);
	}

	/**
	 * 删除指定的ID对象
	 * 
	 * @author herion 2014-12-4上午10:01:49
	 * @param id
	 */
	@Override
	public void removeOne(String id) {
		Criteria criteria = Criteria.where("id").in(id);
		if (criteria == null) {
			Query query = new Query(criteria);
			if (query != null
					&& mongoTemplate.findOne(query, entityClass) != null)
				mongoTemplate.remove(mongoTemplate.findOne(query, entityClass));
		}

	}

	/**
	 * 删除所有
	 * 
	 * @author herion 2014-12-4上午10:02:34
	 */
	@Override
	public void removeAll() {
		List<E> list = this.findAll();
		if (list != null) {
			for (E e : list) {
				mongoTemplate.remove(e);
			}
		}

	}
	
	/**
	 * 根据条件删除
	 * @author herion
	 * 2015-2-4下午9:31:32
	 * @param query
	 * @param collectionName
	 */
	public void remove(Query query,String collectionName){
		mongoTemplate.remove(query,collectionName);
	}
	
	/** 
     * 按条件查询, 分页 
     * <br>------------------------------<br> 
     * @param query
     * @param skip 
     * @param limit 
     * @return 
     */  
	public <T> MongoPage<T> page(Query query, int skip, int limit, String collectionName, Class<T> entityClas){
		query.skip(skip*limit);
        query.limit(limit);
        long totalCount = this.mongoTemplate.count(query,collectionName);
        List<T> list=mongoTemplate.find(query, entityClas,collectionName);
        MongoPage<T> page =new MongoPage<T>();
        page.setList(list);
        page.setTotal(totalCount);
        return page;  
    }
    
    
	public MongoPage<V> PageResultVO(Query query, int skip, int limit,String collectionName){
		query.skip(skip*limit);
        query.limit(limit);
        long totalCount = this.mongoTemplate.count(query,collectionName);
        List<V> list=mongoTemplate.find(query, vClass,collectionName);
        MongoPage<V> page =new MongoPage<V>();
        page.setList(list);
        page.setTotal(totalCount);
        return page;  
	}
    
    
    /**
     * 根据集合名称查询
     * @author herion
     * 2014-12-11下午9:50:57
     * @param collectionName
     * @return
     */
    public List<E> findAll(String collectionName) {
		return mongoTemplate.findAll(entityClass, collectionName);
	}
    
    @Override
	public void save(E entity, String collectionName) {
    	mongoTemplate.save(entity, collectionName);
	}

	@Override
	public void save(E entity) {
		mongoTemplate.save(entity);
	}
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	/**
	 * 根据集合名称 条件 查询
	 * @author herion
	 * 2015-1-5下午6:00:54
	 * @param query
	 * @param collectionName
	 * @return
	 */
	@Override
	public List<E> find(Query query,String collectionName) {
		return mongoTemplate.find(query, entityClass, collectionName);
	}
	
	public List<V> findResultVO(Query query,String collectionName) {
		return mongoTemplate.find(query, vClass, collectionName);
	}
	/**
	 * 批量修改
	 * @author herion
	 * 2015-1-6上午10:08:44
	 * @param query
	 * @param update
	 * @param collectionName
	 */
	@Override
	public void updateMulti(Query query, Update update, String collectionName) {
		mongoTemplate.updateMulti(query, update, entityClass, collectionName);
	}
	
	/**
	 * 修改第一个
	 * @author herion
	 * 2015-1-6上午10:08:53
	 * @param query
	 * @param update
	 * @param collectionName
	 */
	@Override
	public void updateFirst(Query query, Update update, String collectionName) {
		mongoTemplate.updateFirst(query, update, entityClass, collectionName);
	}
	
	@Override
	public void updateFirst(Query query, Update update) {
		mongoTemplate.updateFirst(query, update, entityClass);
	}
	
	/**
	 * 更新修改
	 * @author herion
	 * 2015-1-6上午10:09:04
	 * @param query
	 * @param update
	 * @param collectionName
	 */
	@Override
	public void upsert(Query query, Update update, String collectionName) {
		mongoTemplate.upsert(query, update, entityClass, collectionName);
	}
	
	/**
	 * 根据条件获得 数量
	 * @author herion
	 * 2015-1-6上午10:09:17
	 * @param query
	 * @param collectionName
	 * @return
	 */
	@Override
	public long count(Query query, String collectionName) {
		return mongoTemplate.count(query, collectionName);
	}
	
	/**
	 * 查询更新
	 * @author herion
	 * 2015-1-7上午11:46:17
	 * @param query
	 * @param update
	 * @param collectionName
	 */
	@Override
	public E findAndModify(Query query, Update update, String collectionName) {
		return mongoTemplate.findAndModify(query, update, entityClass, collectionName);
	}
	
	/**
	 * 查询所有
	 * @author herion
	 * 2015-1-8上午11:35:18
	 * @return
	 */
	@Override
	public List<V> findAllResultVO() {
		return mongoTemplate.find(new Query(), vClass);
	}
	
	/**
	 * 分页查询 
	 * @author herion
	 * 2015-1-8上午11:35:43
	 * @param criteriaRequestLog
	 * @param skip
	 * @param limit
	 * @return VO
	 */
	@Override
	public List<V> findResultVO(E criteriaRequestLog, int skip, int limit) {
		Query query=new Query();
        query.skip(skip);  
        query.limit(limit);  
        return mongoTemplate.find(query, vClass);  
	}
	
	/**
	 * 根据集合查询
	 * @author herion
	 * 2015-1-8上午11:38:28
	 * @param collectionName
	 * @return VO
	 */
	@Override
	public List<V> findAllRusultVO(String collectionName) {
		return mongoTemplate.findAll(vClass, collectionName);
	}
	
	/**
	 * 批量插入
	 * @author herion
	 * 2015-1-14下午2:23:08
	 * @param batchToSave
	 * @param collectionName
	 */
	@Override
	public void insert(List<?> batchToSave, String collectionName) {
		mongoTemplate.insert(batchToSave, collectionName);
	}
	
	/**
	 * 查询包含至少一个元素的结果。
	 * @author herion
	 * 2015-1-16下午1:55:03
	 * @param query
	 * @param collectionName
	 * @return
	 */
	@Override
	public boolean exists(Query query, String collectionName) {
		return mongoTemplate.exists(query, collectionName);
	}
	
	public <T> List<T> find(final Query query, Class<T> entityClass, String collectionName){
		return mongoTemplate.find(query, entityClass, collectionName);
	}

	@Override
	public <T> void insertEntity(T entity, String collectionName) {
		mongoTemplate.insert(entity,collectionName);
	}
}
