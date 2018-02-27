/**
 * 
 */
package com.jfpay.dao.read;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.jfpay.entity.DO.LinkPersonExam;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月6日
 */
@Repository
public interface ILinkPersonExamDao{
	public List<LinkPersonExam> findByMobileNo(String mobileNo);
	/**
	 * @author Shenluyun查询
	 * @param map
	 * @return
	 */
	public List<LinkPersonExam> selectLinkPersonExams(Map<String,Object> map );

	public List<LinkPersonExam> findLinkPersonExamDetail(Map<String, Object> map);
	public void addLinkPersonExam(LinkPersonExam linkPersonExam);
	public List<LinkPersonExam> findLinkPersonExamByObj(Map<String, Object> map);
	public void updateByIdLinkPersonExam(LinkPersonExam linkPersonExam);
}
