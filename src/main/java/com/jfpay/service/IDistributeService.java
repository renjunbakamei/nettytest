package com.jfpay.service;

import com.jfpay.core.Exception.BizException;

import java.util.Map;

public interface IDistributeService {

    public void distribute(Map<String,Object> params) throws BizException;

}
