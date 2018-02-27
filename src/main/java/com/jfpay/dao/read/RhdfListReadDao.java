package com.jfpay.dao.read;

import com.jfpay.entity.DO.RhdfListDO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface RhdfListReadDao extends Mapper<RhdfListDO> {

    public List<RhdfListDO> selectByCondition(Map<String, Object> map);
    
    
    Integer selectTotalCountByCondition(Map<String, Object> map);
    
    Long selectTotalAmountByCondition(Map<String, Object> map);
    
    List<String> selectAllIdByCondition(Map<String, Object> map);
}
