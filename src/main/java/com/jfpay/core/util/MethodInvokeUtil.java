package com.jfpay.core.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jfpay.core.Exception.BizException;
import com.jfpay.core.constant.ImpRespCode;
import com.jfpay.core.domain.to.ReceiveDataTO;
import com.jfpay.core.setting.MethodMap;
import com.jfpay.core.setting.MethodReflectInfo;
import com.jfpay.core.setting.ServerList;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

/**
 * Created by renjun on 2017/8/27.
 */
@Component
public class MethodInvokeUtil {

    public String invoke(String json) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException,BizException {

        ReceiveDataTO receiveDataTO = JsonUtil.parse(json, new TypeReference<ReceiveDataTO>() {
        });
        String reqType = receiveDataTO.getHead();
        try {
            MethodReflectInfo methodInfo = (MethodReflectInfo) MethodMap.getMethodMap().get(reqType);
            Class<?> clz = ServerList.getCtx().getBean(methodInfo.getClassName()).getClass();
            Method m = clz.getDeclaredMethod(methodInfo.getMethodName(), Map.class);
            Object result = m.invoke(ServerList.getCtx().getBean(methodInfo.getClassName()), receiveDataTO.getParams());
            return JsonUtil.toJson(result);
        } catch (NullPointerException e) {
            throw new BizException(ImpRespCode.METHOD_NOT_BLANK.getResultCode(), ImpRespCode.METHOD_NOT_BLANK.getResultMsg() + ":" + reqType);
        }
    }
}
