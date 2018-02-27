package com.jfpay.base.mongo.dao;

import com.jfpay.base.mongo.entity.MongoPage;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;


/**
 * MongoDB 公用DAO接口
 * @author herion
 * @param <E>
 *
 */
public interface IMongoBaseDao<E,V> {
	/**
	 * 添加对象 根据集合
	 * @author herion
	 * 2014-12-8上午10:52:42
	 * @param entity
	 * @param collectionName
	 */
	public void insert(E entity, String collectionName);

	public <T> void insertEntity(T entity, String collectionName);

	/**
	 * 添加对象
	 * @author herion
	 * 2015-1-16下午1:52:58
	 * @param entity
	 */
	public void insert(E entity);
	/**
	 * 根据主键查询
	 * @author herion
	 * 2015-1-8上午11:28:14
	 * @param id
	 * @return
	 */
	public E findOne(String id, String collectionName, Class<E> entityClas);

	/**
	 * 查询所有
	 * @author herion
	 * 2015-1-8上午11:27:25
	 * @return List<entity>
	 */
	public List<E> findAll();

	/**
	 * 查询所有
	 * @author herion
	 * 2015-1-8上午11:33:11
	 * @return List<VO>
	 */
	public List<V> findAllResultVO();

	public <T> List<T> find(final Query query, Class<T> entityClass, String collectionName);

	/**
	 * 删除一个
	 * @author herion
	 * 2015-1-8上午11:27:40
	 * @param id
	 */
	public void removeOne(String id);
	/**
	 * 删除所有
	 * @author herion
	 * 2015-1-8上午11:27:58
	 */
	public void removeAll();
	/**
     * 按条件查询, 分页
     * <br>------------------------------<br>
	 * @param <T>
     * @param query
     * @param skip
     * @param limit
     * @return entity
     */
	public <T> MongoPage<T> page(Query query, int skip, int limit, String collectionName, Class<T> entityClas);

	public MongoPage<V> PageResultVO(Query query, int skip, int limit, String collectionName);

	/**
	 * 按条件查询, 分页
	 * @author herion
	 * 2015-1-8上午11:34:54
	 * @param criteriaRequestLog
	 * @param skip
	 * @param limit
	 * @return VO
	 */
	public List<V> findResultVO(E criteriaRequestLog, int skip, int limit);


	/**
	 * 根据集合，如果不存在添加对象，否则修改对象
	 * @author herion
	 * 2015-1-8上午11:28:51
	 * @param entity
	 * @param collectionName
	 */
	public void save(E entity, String collectionName);
	/**
	 * 如果不存在添加对象，否则修改
	 * @author herion
	 * 2015-1-8上午11:30:07
	 * @param entity
	 */
	public void save(E entity);

	/**
	 * 根据集合名称查询
	 * @author herion
	 * 2014-12-11下午9:50:22
	 * @param collectionName
	 * @return entity
	 */
	public List<E> findAll(String collectionName);

	/**
	 *  根据集合名称查询
	 * @author herion
	 * 2015-1-8上午11:37:16
	 * @param collectionName
	 * @return VO
	 */
	public List<V> findAllRusultVO(String collectionName);

	/**
	 * 根据条件 集合名称 查询
	 * @author herion
	 * 2015-1-5下午5:57:22
	 * @param query
	 * @param collectionName
	 * @return
	 */
	public List<E>find(Query query, String collectionName);

	/**
	 * 根据条件 集合名称 查询 返回VO
	 * @author herion
	 * 2015-1-8上午11:26:44
	 * @param query
	 * @param collectionName
	 * @return VO
	 */
	public List<V>findResultVO(Query query, String collectionName);
	/**
	 * 批量修改
	 * @author herion
	 * 2015-1-6上午10:02:31
	 * @param query
	 * @param update
	 * @param collectionName
	 */
	public void updateMulti(Query query, Update update, String collectionName);

	/**
	 * 修改第一个
	 * @author herion
	 * 2015-1-6上午10:04:10
	 * @param query
	 * @param update
	 * @param collectionName
	 */
	public void updateFirst(Query query, Update update, String collectionName);


	public void updateFirst(Query query, Update update);

	/**
	 * 更新修改
	 * @author herion
	 * 2015-1-6上午10:04:28
	 * @param query
	 * @param update
	 * @param collectionName
	 */
	public void upsert(Query query, Update update, String collectionName);

	/**
	 * 根据条件查询返回数量
	 * @author herion
	 * 2015-1-6上午10:07:12
	 * @param query
	 * @param collectionName
	 * @return
	 */
	public long count(Query query, String collectionName);

	/**
	 * 查询更新
	 * @author herion
	 * 2015-1-7上午11:44:09
	 * @param query
	 * @param update
	 * @param collectionName
	 */
	public E findAndModify(Query query, Update update, String collectionName);

	/**
	 * 批量插入
	 * @author herion
	 * 2015-1-14下午2:22:35
	 * @param batchToSave
	 * @param collectionName
	 */
	public void insert(List<?> batchToSave, String collectionName);

	/**
	 * 根据集合查询包含至少一个元素的结果
	 * @author herion
	 * 2015-1-16下午1:54:32
	 * @param query
	 * @param collectionName
	 * @return
	 */
	public boolean exists(Query query, String collectionName);

	/**
	 * 根据条件删除
	 * @author herion
	 * 2015-2-4下午9:30:39
	 * @param query
	 * @param collectionName
	 */
	public void remove(Query query, String collectionName);
}
