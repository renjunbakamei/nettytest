/*
 * Copyright 2017 jfpal.com All right reserved. This software is the
 * confidential and proprietary information of jfpal.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with jfpal.com.
 
 Created by jun.ren on 2017/4/11.
 
 */
package com.jfpay.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;


@Component
public class RedisClientUtils {

    @Autowired
    private JedisPool jedisPool;

    @Value("${redis.prefix}")
    private String KEY_PREFIX;

    /**
     * redia存储String字符串
     * @param key
     * @param value
     * @throws Exception
     */
    public void set(String key, String value) throws Exception {
        Jedis jedis = null;
        key=getKeyWithPrefix(key);
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }

    /**
     * redia根据key获取
     * @param key
     * @return
     * @throws Exception
     */
    public String get(String key) throws Exception  {

        Jedis jedis = null;
        key=getKeyWithPrefix(key);
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }

    /**
     * redis根据key删除
     * @param key
     * @return
     * @throws Exception
     */
    public Long deleteByKey(String key) throws Exception  {

        Jedis jedis = null;
        key=getKeyWithPrefix(key);
        try {
            jedis = jedisPool.getResource();
            return jedis.del(key);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }

    /**
     * redia存储Object对象
     * @param key
     * @param value
     * @throws Exception
     */
    public void set(String key, Object value) throws Exception {
        Jedis jedis = null;
        key=getKeyWithPrefix(key);
        try {
            byte[] valuebytes=KryoUtils.writeToByteArray(value);
            byte[] keybytes=KryoUtils.writeObjectToByteArray(key);
            jedis = jedisPool.getResource();
            jedis.set(keybytes,valuebytes);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }

    /**
     *  redia获取Object对象
     * @param key
     * @return
     * @throws Exception
     */
    public Object getObject(String key) throws Exception  {

        Jedis jedis = null;
        key=getKeyWithPrefix(key);
        try {
            byte[] keybytes=KryoUtils.writeObjectToByteArray(key);
            jedis = jedisPool.getResource();
            byte[] values=jedis.get(keybytes);
            return KryoUtils.readFromByteArray(values);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
            finally{
            //返还到连接池
            jedis.close();
        }
    }

    /**
     *将值插入到列表头部,value可以重复，返回列表长度
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    public Long push(String key,String... value) throws Exception{
        Jedis jedis=null;
        Long length=0L;
        key=getKeyWithPrefix(key);
        try{
            jedis=jedisPool.getResource();
            length=jedis.lpush(key,value);
            return length;
        }finally {
            jedis.close();
        }
    }
    /**
     * 通过索引获取列表中的元素
     * @param key
     * @param index，索引，0表示最新的一个元素
     * @return String
     */
    public String index(String key,long index) throws Exception{
        Jedis jedis=null;
        key=getKeyWithPrefix(key);
        try{
            jedis=jedisPool.getResource();
            return jedis.lindex(key,index);
        }finally {
            jedis.close();
        }
    }

    /**
     * 获取List列表
     * @param key
     * @param start long，开始索引
     * @param end long， 结束索引
     * @return List<String>
     */
    public List<String> range(String key,long start,long end) throws Exception{
        Jedis jedis=null;
        key=getKeyWithPrefix(key);
        try{
            jedis=jedisPool.getResource();
            return jedis.lrange(key,start,end);
        }finally {
            jedis.close();
        }
    }
    /**
     * 获取列表长度，key为空时返回0
     * @param key
     * @return Long
     */
    public Long len(String key) throws Exception{
        Jedis jedis=null;
        key=getKeyWithPrefix(key);
        try{
            jedis=jedisPool.getResource();
            return jedis.llen(key);
        }finally {
            jedis.close();
        }
    }

    /**
     * 移除列表元素，返回移除的元素数量
     * @param key
     * @param count，标识，表示动作或者查找方向
     * <li>当count=0时，移除所有匹配的元素；</li>
     * <li>当count为负数时，移除方向是从尾到头；</li>
     * <li>当count为正数时，移除方向是从头到尾；</li>
     * @param value 匹配的元素
     * @return Long
     */
    public  Long rem(String key, long count, String value) throws Exception{
        Jedis jedis=null;
        key=getKeyWithPrefix(key);
        try{
            jedis=jedisPool.getResource();
            Long length = jedis.lrem(key, count, value);
            return length;

        }finally {
            jedis.close();
        }

    }

    /**
     * 移出并获取列表的第一个元素，当列表不存在或者为空时，返回Null
     * @param key
     * @return String
     */
    public String pop(String key)throws Exception{
        Jedis jedis=null;
        key=getKeyWithPrefix(key);
        try {
            jedis = jedisPool.getResource();
            String value = jedis.lpop(key);
            return value;
        }finally {
            jedis.close();
        }

    }

    /**
     *清空键值为key的列表的内容
     * @param key
     * @throws Exception
     */
    public void cleanList(String key) throws Exception{
        key=getKeyWithPrefix(key);
        long length=len(key);
        String value=null;
        if(length<=0){
            return;
        }
        do{
            value=pop(key);
        }while (value==null);
    }

    /**
     *得到全部列表
     * @param key
     * @return
     * @throws Exception
     */
    public List<String> getList(String key) throws Exception{
        key=getKeyWithPrefix(key);
        long length=len(key);
        if(length<=0){
            return null;
        }
        return range(key,0,len(key)-1);
    }

    /**
     * 在列表中的尾部添加一个个值，返回列表的长度
     * @param key
     * @param value
     * @return Long
     */
    public Long pushTail(String key, String value) throws Exception{
        key=getKeyWithPrefix(key);
        Jedis jedis=null;
        try {
            jedis = jedisPool.getResource();
            Long length = jedis.rpush(key, value);
            return length;
        }finally {
            jedis.close();
        }
    }

    /**
     * 将传入的key值加上综管台审件标识
     * @param key
     * @return
     */
    String getKeyWithPrefix(String key){
        key=KEY_PREFIX+"_"+key;
        return key;
    }

}
