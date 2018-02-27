package com.jfpay.service;

import com.jfpay.entity.vo.RejectinfoVO;

import java.util.List;
import java.util.Map;

public interface IRejectInfoService {

    /**
     * 根据对象获取信息列表
     * @return List<Rejectinfo>
     */
    public List<RejectinfoVO> getRejectinfoListByObj(Map<String,Object> map) throws Exception;

}
