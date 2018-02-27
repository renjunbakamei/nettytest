package com.jfpay.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jfpay.base.mongo.dao.IMongoBaseDao;
import com.jfpay.dao.read.RhdfListReadDao;
import com.jfpay.entity.DO.RhdfListDO;
import org.apache.commons.lang.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by renjun on 2017/8/27.
 */

@Service
public class TestService {

    @Value("${collectionName}")
    private String collenctionName;

    @Autowired
    private RhdfListReadDao rhdfListReadDao;

    @Autowired
    private IMongoBaseDao<Map<String,Object>, ?> mongoBaseDao;


    public Object mongoTest(Map<String, Object> map) {
        Query query=new Query();
        Criteria c=new Criteria();
        c.and("reqBean.mobileNo").is("15805031003");
        query.addCriteria(c);
        return mongoBaseDao.find(query,Map.class,"imp.audit.merchant");
    }

    public Object rhdfList(Map<String, Object> map) {

        int pageNum = 0;
        int numPerPage = 25;

        if (map.containsKey("pageNum") && StringUtils.isNotBlank(map.get("pageNum").toString())) {
            pageNum = Integer.parseInt(map.get("pageNum").toString());
        }

        if (map.containsKey("numPerPage") && StringUtils.isNotBlank(map.get("numPerPage").toString())) {
            numPerPage = Integer.parseInt(map.get("numPerPage").toString());
        }
//        RhdfListReadDao rhdfListReadDao= (RhdfListReadDao)ServerList.getCtx().getBean("rhdfListReadDao");
        PageHelper.startPage(pageNum, numPerPage);
        List<RhdfListDO> batchs = rhdfListReadDao.selectByCondition(map);
        PageInfo<RhdfListDO> info = new PageInfo<RhdfListDO>(batchs);
        return info;
    }


    public String testMethod(Map<String,Object> map){


        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        return "测试test方法";
    }

}
