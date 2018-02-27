package com.jfpay.core.setting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by renjun on 2017/8/27.
 */
public class MethodReflectInfo {

    private static Logger log= LoggerFactory.getLogger(MethodReflectInfo.class);
    /**
     * 对应的类名
     */
    private String className;

    /**
     * 对应的方法名称
     */
    private String methodName;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void printMethodInfo(){
        log.info("class name:{}",className);
        log.info("method name:{}",methodName);
    }
}
