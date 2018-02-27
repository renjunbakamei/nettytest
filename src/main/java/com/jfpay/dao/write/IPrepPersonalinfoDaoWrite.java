/**
 * 
 */
package com.jfpay.dao.write;

import com.jfpay.entity.DO.PrepPersonalinfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * @author dongyuqiang
 *
 * @date 2017年8月30日
 */
@Repository
public interface IPrepPersonalinfoDaoWrite extends Mapper<PrepPersonalinfo>{


	/**
	 *
	 * @param prep
	 * @return
	 */
	public int updateById_prepPersonalinfo(PrepPersonalinfo prep);

}
