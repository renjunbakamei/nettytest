/**
 * 
 */
package com.jfpay.dao.mongo.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.jfpay.base.mongo.dao.impl.MongoBaseDaoImpl;
import com.jfpay.base.mongo.entity.MongoPage;
import com.jfpay.dao.mongo.dao.IOperatorDao;
import com.jfpay.entity.DO.Operator;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月25日
 */
@Repository
public class OperatorDaoImpl extends MongoBaseDaoImpl<Operator,Operator> implements IOperatorDao {

}
