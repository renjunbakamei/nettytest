package com.jfpay.service.impl;

import com.jfpay.dao.read.IRejectinfoDao;
import com.jfpay.entity.vo.RejectinfoVO;
import com.jfpay.service.IRejectInfoService;
import com.jfpay.utils.MapConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("rejectInfoService")
public class RejectInfoServiceImpl implements IRejectInfoService {

    @Autowired
    private IRejectinfoDao rejectinfoDao;

    @Override
    public List<RejectinfoVO> getRejectinfoListByObj(Map<String,Object> map) throws Exception{
        RejectinfoVO rejectinfo=(RejectinfoVO) MapConvertUtils.mapToObject(map,RejectinfoVO.class);
        return rejectinfoDao.findListByObj(rejectinfo);
    }
}
