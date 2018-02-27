package com.jfpay.service.impl;

import com.jfpay.base.mongo.dao.IMongoBaseDao;
import com.jfpay.core.Exception.BizException;
import com.jfpay.service.IDistributeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DistributeServiceImpl implements IDistributeService {

    @Value("${collectionName}")
    private String collection;

    @Value("${mongo-limit}")
    private String limit;

    private MongoTemplate mongoTemplate;

    @Override
    public void distribute(Map<String, Object> params) throws BizException {
        String operatorId=(String)params.get("operatorId");
        String operatorName=(String)params.get("operatorName");

    }

    int getCountOpt(String operatorId){
        Query query=new Query();
        return 0;
    }
}
