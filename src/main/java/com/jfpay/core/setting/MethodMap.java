package com.jfpay.core.setting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by renjun on 2017/8/27.
 */
public class MethodMap {

    private static Logger log= LoggerFactory.getLogger(MethodMap.class);

    /**
     * 方法对应的map集合
     */
    private static Map<String,Object> methodMap;

    public static Map<String, Object> getMethodMap() {
        return methodMap;
    }

    public void setMethodMap(Map<String, Object> methodMap) {
        MethodMap.methodMap = methodMap;
    }

    public static void pringMethodMap(){
        log.info("************METHOD LIST**************");
        if(methodMap==null||methodMap.isEmpty()){
            log.info("there is no method in method list,please check your program");
        }else{
            int i=1;
            for(Map.Entry entry:methodMap.entrySet()){
                log.info("----------METHOD-{}:{}----------",i,entry.getKey());
                ((MethodReflectInfo)methodMap.get(entry.getKey())).printMethodInfo();
                log.info("----------METHOD-{}:{}----------",i,entry.getKey());
                i++;
            }
        }
        log.info("************METHOD LIST**************");

    }

}
