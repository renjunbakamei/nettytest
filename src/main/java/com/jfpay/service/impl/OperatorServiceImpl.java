/**
 * 
 */
package com.jfpay.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.jfpay.core.constant.CoreConstants;
import com.jfpay.dao.mongo.dao.IOperatorDao;
import com.jfpay.entity.DO.Operator;
import com.jfpay.service.IOperatorService;
import com.jfpay.utils.MapConvertUtils;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月25日
 */
@Service
public class OperatorServiceImpl implements IOperatorService{
	private final Logger log = LoggerFactory.getLogger(OperatorServiceImpl.class);
	@Autowired
	private IOperatorDao iOperatorDao;
	
	@Value("${operatorCN}")
	private String collectionName;
	
	/**
	 * 修改用户状态
	 */
	@Override
	public void updateStatusById(Map<String, Object> map) {
		Operator operator=new Operator();
		try {
			operator = (Operator) MapConvertUtils.mapToObject(map, Operator.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Query query=new Query();
		//是否有效
		Criteria isDelete = Criteria.where("isDelete").is(CoreConstants.DEFAULT_IS_DEL);  
        query.addCriteria(isDelete);
        
        //用户登陆ID
        Criteria loginId = Criteria.where("loginId").is(operator.getLoginId());  
        query.addCriteria(loginId);
        
    	Update update=new Update();
		update.set("status",operator.getStatus());
		
		iOperatorDao.updateFirst(query, update, collectionName);
	}
	/**
	 * 根据用户id查询用户状态
	 */
	@Override
	public Operator findOperatorStatus(Map<String, Object> map) {
		
		Operator operator=new Operator();
		try {
			operator = (Operator) MapConvertUtils.mapToObject(map, Operator.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Query query=new Query();
		Criteria loginId = Criteria.where("loginId").is(operator.getLoginId());  
        query.addCriteria(loginId);
		List<Operator> operatorList = iOperatorDao.find(query, collectionName);
		
		//如果库中不存在该用户相关信息，则将其插入，再查询。
		if (operatorList.size()==0) {
			operator.setStatus(CoreConstants.DEFAULT_STATUS);
			operator.setIsDelete(CoreConstants.DEFAULT_IS_DEL);
			operator.setCreateDate(new Date());
			iOperatorDao.insert(operator);
			operatorList = iOperatorDao.find(query, collectionName);
		}
		operator=operatorList.get(0);
		return operator;
	}

}
