package com.jfpay.service;


import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.jfpay.entity.DO.LinkPersonExam;


public interface ILinkPersonExamService {

	public PageInfo<LinkPersonExam>  findLinkPersonExams(Map<String,Object> map);
	public PageInfo<LinkPersonExam>  findLinkPersonExamDetail(Map<String, Object> map);
	
	public List<LinkPersonExam> findLinkPersonExam(Map<String, Object> map);
	public void addLinkPersonExam(Map<String, Object> map);
	public void updateByIdLinkPersonExam(Map<String, Object> map) ;
	public PageInfo<LinkPersonExam> findLinkPersonExamByObj(Map<String, Object> map);
}
