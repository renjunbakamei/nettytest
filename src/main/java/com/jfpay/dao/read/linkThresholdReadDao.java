
package com.jfpay.dao.read;

import java.util.List;
import java.util.Map;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月11日
 */
public interface linkThresholdReadDao {
	public List<linkThresholdDO> selectLinkThresholds(Map<String, Object> map);
	public void updateByIdLinkThreshold(linkThresholdDO linkThresholdDO);
	public linkThresholdDO findLinkThreshold(linkThresholdDO linkThresholdDO);
	public List<linkThresholdDO> findListByObj(Map<String, Object> map);
}
