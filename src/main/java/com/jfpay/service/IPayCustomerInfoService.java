package com.jfpay.service;

import com.jfpay.entity.DO.PrepPersonalinfo;

public interface IPayCustomerInfoService {

    /**
     * 处理业务逻辑
     * 1、修改客户信息状态
     * 2、修改图片信息状态
     * 3、释放mongo任务
     * @param info
     * @return
     */
    public void savePayCustomerInfo(PrepPersonalinfo info,String userid) throws Exception;

}
