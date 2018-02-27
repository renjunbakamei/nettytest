/**
 * 
 */
package com.jfpay.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jfpal.security.JFSecurity;
import com.jfpay.base.mongo.entity.MongoPage;
import com.jfpay.utils.PageInfoUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.jfpay.core.constant.CoreConstants;
import com.jfpay.dao.mongo.dao.IPersonalInfoAuditJobDao;
import com.jfpay.dao.mongo.entity.PersonalInfoAuditJob;
import com.jfpay.dao.mongo.entity.vo.PersonalInfoAuditJobVO;
import com.jfpay.dao.read.IPrepPersonalinfoDao;
import com.jfpay.dao.read.IRejectinfoDao;
import com.jfpay.entity.DO.PrepPersonalinfo;
import com.jfpay.entity.vo.PrepPersonalinfoVO;
import com.jfpay.entity.vo.RejectinfoVO;
import com.jfpay.service.IPersonalInfoAuditJobService;
import com.jfpay.utils.DateUtil;
import com.jfpay.utils.MapConvertUtils;
import com.mongodb.BasicDBObject;

/**
 * 实名认证业务接口实现
 * 
 * @author dongyuqiang
 * @date 2017年8月30日
 */
@Service
public class PersonalInfoAuditJobServiceImpl implements IPersonalInfoAuditJobService {
	private final Logger log = LoggerFactory.getLogger(PersonalInfoAuditJobServiceImpl.class);

	@Autowired
	private IPersonalInfoAuditJobDao personalInfoAuditJobDao;
	@Autowired
	private IPrepPersonalinfoDao prepPersonalinfoDao;
	@Autowired
	private IRejectinfoDao rejectinfoDao;

	@Autowired

	@Value("${collectionName}")
	private String collectionName;

	@Value("${mogodb.job.limit}")
	private int limit;
	@Value("${mogodb.job.skip}")
	private int skip;

	/**
	 * 查询客户审核信息
	 */
	public List<PersonalInfoAuditJobVO> operatorListBymobileNo(Map<String, Object> map) {
		PersonalInfoAuditJob personalInfoAuditJob = new PersonalInfoAuditJob();
		try {
			personalInfoAuditJob = (PersonalInfoAuditJob) MapConvertUtils.mapToObject(map, PersonalInfoAuditJob.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Query query = new Query();
		// 查询用户处理和处理中的任务
		Criteria mobileno = Criteria.where("body.mobileno").is(personalInfoAuditJob.getMobileno());

		query.addCriteria(mobileno);
		query.with(new Sort(new Sort.Order(Direction.DESC,"body.createdate")).
				and(new Sort(new Sort.Order(Direction.DESC,"body.createtime"))));
		// 查询任务信息
		List<PersonalInfoAuditJob> listData = personalInfoAuditJobDao.find(query, collectionName);
		if (listData.size() == 0) {
			log.info("无该用户记录：" + personalInfoAuditJob.getMobileno());
			listData = queryOraPerson(query, personalInfoAuditJob.getMobileno());
		}

		List<PersonalInfoAuditJobVO> list = new ArrayList<PersonalInfoAuditJobVO>();

		boolean isJob = false;

		for (PersonalInfoAuditJob piaj : listData) {
			String status = piaj.getStatus();
			// 如果未分配，将任务分配给自己
			// 如果状态不是审核通过
			if (!status.equals(CoreConstants.JOB_STATUS_99)) {
				piaj = getAuditJob(piaj, personalInfoAuditJob);
				isJob = true;
			}
			PersonalInfoAuditJobVO piajVO = new PersonalInfoAuditJobVO();
			BeanUtils.copyProperties(piaj, piajVO);
			list.add(piajVO);
		}

		if (!isJob) {
			List<PersonalInfoAuditJob> listJob = queryOraPerson(query, personalInfoAuditJob.getMobileno());
			if (listJob.size() > 0) {
				list = new ArrayList<PersonalInfoAuditJobVO>();
				for (PersonalInfoAuditJob piaj : listJob) {
					String status = piaj.getStatus();
					// 如果未分配，将任务分配给自己
					// 如果状态不是审核通过
					if (!status.equals(CoreConstants.JOB_STATUS_99)) {
						piaj = getAuditJob(piaj, personalInfoAuditJob);
					}
					PersonalInfoAuditJobVO piajVO = new PersonalInfoAuditJobVO();
					BeanUtils.copyProperties(piaj, piajVO);
					list.add(piajVO);
				}
			}
		}
		return list;
	}

	/**
	 * 查询Oracle用户是否未审核
	 * 
	 * @param query
	 * @param mobileno
	 * @return
	 */
	public List<PersonalInfoAuditJob> queryOraPerson(Query query, String mobileno) {
		List<PersonalInfoAuditJob> jobList = new ArrayList<PersonalInfoAuditJob>();
		PrepPersonalinfo presonInfo = new PrepPersonalinfo();
		presonInfo.setMobileno(mobileno);
		List<PrepPersonalinfo> listSize = prepPersonalinfoDao.findPersonList(presonInfo);
		if (listSize.size() > 0) {
			PrepPersonalinfo person = listSize.get(0);
			if (person.getAuditflag().equals(CoreConstants.AUDIT_FIAL_2)
					|| person.getAuditflag().equals(CoreConstants.AUDIT_FIAL_D)) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("customerid", person.getCustomerid());
				map.put("mobileno", person.getMobileno());
				map.put("createdate", person.getCreatedate());
				map.put("createtime", person.getCreatetime());
				map.put("auditflag", person.getAuditflag());
				map.put("imgType", "pm-core");
				map.put("audittype", person.getAudittype());
				PersonalInfoAuditJob job = new PersonalInfoAuditJob();
				log.info("查询Oracle数据");
				job.setBody(new BasicDBObject(map));
				job.setReceiveDate(new Date());
				job.setStatus(CoreConstants.JOB_STATUS_0);
				personalInfoAuditJobDao.insert(job, collectionName);

				jobList = personalInfoAuditJobDao.find(query, collectionName);
			}
		}
		return jobList;
	}

	/**
	 * 获取审计信息
	 * 
	 * @param piaj
	 * @param personalInfoAuditJob
	 * @return
	 */
	public PersonalInfoAuditJob getAuditJob(PersonalInfoAuditJob piaj, PersonalInfoAuditJob personalInfoAuditJob) {
		PersonalInfoAuditJob paramPersonalInfo = new PersonalInfoAuditJob();
		// Id
		paramPersonalInfo.setId(piaj.getId());
		// 操作员ID
		paramPersonalInfo.setOperatorId(personalInfoAuditJob.getOperatorId());
		// 操作员名称
		paramPersonalInfo.setOperatorName(personalInfoAuditJob.getOperatorName());
		// 状态
		paramPersonalInfo.setStatus(CoreConstants.JOB_STATUS_2);
		// 分配时间
		paramPersonalInfo.setAllocationDate(new Date());
		// 推送时间
		paramPersonalInfo.setPushDate(new Date());
		this.jobUpdateFirst(paramPersonalInfo);
		// 返回VO
		piaj.setOperatorId(paramPersonalInfo.getOperatorId());
		piaj.setOperatorName(personalInfoAuditJob.getOperatorName());
		piaj.setAllocationDate(paramPersonalInfo.getAllocationDate());
		return piaj;
	}

	/**
	 * 修改第一个任务
	 */

	public void jobUpdateFirst(PersonalInfoAuditJob personalInfoAuditJob) {
		Query query = new Query();
		Criteria criteria = Criteria.where("id").is(personalInfoAuditJob.getId());
		query.addCriteria(criteria);

		personalInfoAuditJobDao.updateFirst(query, this.update(personalInfoAuditJob), collectionName);
	}

	/**
	 * L update 参数设置
	 */
	private Update update(PersonalInfoAuditJob personalInfoAuditJob) {
		Update update = new Update();
		// 操作员ID
		if (0 != personalInfoAuditJob.getOperatorId()) {
			update.set("operatorId", personalInfoAuditJob.getOperatorId());
		}

		// 状态
		if (null != personalInfoAuditJob.getStatus() && !"".equals(personalInfoAuditJob.getStatus())) {
			update.set("status", personalInfoAuditJob.getStatus());
		}

		// 操作员名称
		if (null != personalInfoAuditJob.getOperatorName() && !"".equals(personalInfoAuditJob.getOperatorName())) {
			update.set("operatorName", personalInfoAuditJob.getOperatorName());
		}

		// 分配时间
		if (null != personalInfoAuditJob.getAllocationDate() && !"".equals(personalInfoAuditJob.getAllocationDate())) {
			update.set("allocationDate", personalInfoAuditJob.getAllocationDate());
		}

		// 推送时间
		if (null != personalInfoAuditJob.getPushDate() && !"".equals(personalInfoAuditJob.getPushDate())) {
			update.set("pushDate", personalInfoAuditJob.getPushDate());
		}

		// 处理时间
		if (null != personalInfoAuditJob.getDisposeDate() && !"".equals(personalInfoAuditJob.getDisposeDate())) {
			update.set("disposeDate", personalInfoAuditJob.getDisposeDate());
		}

		// 查看时间
		if (null != personalInfoAuditJob.getCheckDate() && !"".equals(personalInfoAuditJob.getCheckDate())) {
			update.set("checkDate", personalInfoAuditJob.getCheckDate());
		}

		// 实名认证状态
		if (null != personalInfoAuditJob.getAuditFlag() && !"".equals(personalInfoAuditJob.getAuditFlag())) {
			update.set("body.auditflag", personalInfoAuditJob.getAuditFlag());
		}

		// 审核描述code
		if (null != personalInfoAuditJob.getRejectCode() && !"".equals(personalInfoAuditJob.getRejectCode())) {
			update.set("rejectCode", personalInfoAuditJob.getRejectCode());
		}

		return update;
	}

	/**
	 * 根据客户id查询信息
	 */
	@Override
	public PrepPersonalinfoVO findPersonalInfoDetail(Map<String, Object> map) {
		String customerId = (String) map.get("customerid");
		PrepPersonalinfoVO prepPersonalinfoVO = new PrepPersonalinfoVO();
		PrepPersonalinfo pInfo = new PrepPersonalinfo();
		/*
		 * try { prepPersonalinfoVO=(PrepPersonalinfoVO)
		 * MapConvertUtils.mapToObject(map,PrepPersonalinfoVO.class); } catch (Exception
		 * e) { e.printStackTrace(); }
		 */
		pInfo.setCustomerid(customerId);
		PrepPersonalinfo p = prepPersonalinfoDao.findPrepPersonalById(pInfo);
		p.setCheckDate(DateUtil.getDateTime(new Date())); // 详细页面查看时间
		BeanUtils.copyProperties(p, prepPersonalinfoVO);
		List<RejectinfoVO> rejectinfoList = rejectinfoDao.findRejectInfoAll();
		prepPersonalinfoVO.setRejectinfoList(rejectinfoList);
		return prepPersonalinfoVO;
	}

	/**
	 * 个人信息审核查询结果
	 */
	@Override
	public List<PersonalInfoAuditJobVO> findOperatorList(Map<String, Object> map) {
		PersonalInfoAuditJob personalInfoAuditJob = new PersonalInfoAuditJob();
		try {
			personalInfoAuditJob = (PersonalInfoAuditJob) MapConvertUtils.mapToObject(map, PersonalInfoAuditJob.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		personalInfoAuditJob.setStatus(CoreConstants.JOB_STATUS_1);
		Query q = new Query();
		// 查询用户处理和处理中的任务
		// Criteria status =
		// Criteria.where("status").in(CoreConstants.JOB_STATUS_3,CoreConstants.JOB_STATUS_2);
		Criteria status = Criteria.where("status").in(CoreConstants.JOB_STATUS_1, CoreConstants.JOB_STATUS_2);
		q.addCriteria(status);
		// 操作者
		Criteria operatorId = Criteria.where("operatorId").is(personalInfoAuditJob.getOperatorId());// 未分配任务
		q.addCriteria(operatorId);

		// 手机号
		if (null != personalInfoAuditJob.getMobileno() && !"".equals(personalInfoAuditJob.getMobileno())) {
			Criteria mobileno = Criteria.where("body.mobileno").is(personalInfoAuditJob.getMobileno());// 手机号
			q.addCriteria(mobileno);
		}
		System.out.println(skip);
		// 分页
		q.skip(skip);
		q.limit(limit);
		// 分配时间 排序
		// q.with(new Sort(Direction.ASC, "allocationDate"));
		q.with(new Sort(Direction.DESC, "body.audittype"));
		q.with(new Sort(Direction.DESC, "body.auditflag"));// 实名信息状态
		q.with(new Sort(Direction.ASC, "body.createdate"));
		q.with(new Sort(Direction.ASC, "body.createtime"));

		// 查询任务信息
		List<PersonalInfoAuditJobVO> listData = (List<PersonalInfoAuditJobVO>) personalInfoAuditJobDao.findResultVO(q,
				collectionName);

		// 如果没有数据
		if (listData.size() == 0) {
			return listData;
		}

		/** 修改任务信息 */
		// 查询条件
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < listData.size(); i++) {
			// 只有刚分配的任务才更新状态
			// if(listData.get(i).getStatus().equals(CoreConstants.JOB_STATUS_3)){
			// list.add(listData.get(i).getId());
			// }
			if (listData.get(i).getStatus().equals(CoreConstants.JOB_STATUS_1)) {
				list.add(listData.get(i).getId());
			}
		}

		Query query = new Query();
		// 查询状态未分配
		Criteria c = Criteria.where("id").in(list);
		query.addCriteria(c);

		// 状态为处理中
		personalInfoAuditJob.setStatus(CoreConstants.JOB_STATUS_2);
		// 推送时间
		personalInfoAuditJob.setPushDate(new Date());

		// 修改字段
		Update update = this.update(personalInfoAuditJob);
		personalInfoAuditJobDao.updateMulti(query, update, collectionName);

		return listData;
	}

	/**
	 * 实名认证统计
	 */
	@Override
	public Map<String, Object> personalInfoAuditJobTotal(Map<String, Object> map) {
		PersonalInfoAuditJob personalInfoAuditJob = new PersonalInfoAuditJob();
		try {
			personalInfoAuditJob = (PersonalInfoAuditJob) MapConvertUtils.mapToObject(map, PersonalInfoAuditJob.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 本人已审：100（通过：20，驳回：80），本人剩余：0，总已审：999（通过：199，驳回：800），总剩余任务：9999

		/** 当前驳回 */
		Query query = new Query();
		// 当天
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		Date todayStart = cal.getTime();
		Criteria disposeDate = Criteria.where("disposeDate").gte(todayStart);
		query.addCriteria(disposeDate);
		// 驳回
		Criteria auditflag = Criteria.where(CoreConstants.AUDIT_FLAG).in(CoreConstants.AUDIT_FLAG_4,
				CoreConstants.AUDIT_FLAG_C);
		query.addCriteria(auditflag);
		// 操作人
		Criteria operatorId = Criteria.where("operatorId").is(personalInfoAuditJob.getOperatorId());
		query.addCriteria(operatorId);
		long dayRejectTotal = personalInfoAuditJobDao.count(query, collectionName);

		/** 通过 */
		Query dayPassQuery = new Query();
		dayPassQuery.addCriteria(disposeDate);
		dayPassQuery.addCriteria(operatorId);
		dayPassQuery.addCriteria(Criteria.where(CoreConstants.AUDIT_FLAG).is(CoreConstants.AUDIT_FLAG_3));
		long dayPassTotal = personalInfoAuditJobDao.count(dayPassQuery, collectionName);

		/** 本人剩余 */
		Query q = new Query();
		q.addCriteria(operatorId);
		Criteria status = Criteria.where("status").ne(CoreConstants.JOB_STATUS_99);
		q.addCriteria(status);
		long operatorUndisposedTotal = personalInfoAuditJobDao.count(q, collectionName);

		/** 通过 */
		Query passQuery = new Query();
		passQuery.addCriteria(Criteria.where(CoreConstants.AUDIT_FLAG).is(CoreConstants.AUDIT_FLAG_3));
		passQuery.addCriteria(disposeDate);
		long passTotal = personalInfoAuditJobDao.count(passQuery, collectionName);

		/** 驳回 */
		Query rejectQuery = new Query();
		rejectQuery.addCriteria(auditflag);
		rejectQuery.addCriteria(disposeDate);
		long rejectTotal = personalInfoAuditJobDao.count(rejectQuery, collectionName);

		/** 剩余总数 */
		Query undisposedQuery = new Query();
		undisposedQuery.addCriteria(status);
		long undisposedTotal = personalInfoAuditJobDao.count(undisposedQuery, collectionName);

		map.clear();
		map.put("day_reject_total", dayRejectTotal);// 当前用户驳回
		map.put("day_pass_total", dayPassTotal);// 当前用户通过
		map.put("oper_undisposed_total", operatorUndisposedTotal);// 当前用户剩余未审核
		map.put("pass_total", passTotal);// 通过数据量
		map.put("reject_total", rejectTotal);// 驳回数量
		map.put("undisposed_total", undisposedTotal);// 剩余未审核

		return map;
	}

	public PageInfo<PersonalInfoAuditJobVO> personalInfoAuditJobLogList(Map<String,Object> map) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Query query=new Query();
		Criteria criteria=new Criteria();
		//跨越条数
		int limtNo=10;
		//起始条数
		int tempSkip=0;
		if(map.containsKey("numPerPage")&&(Integer)map.get("numPerPage")!=null&&(Integer)map.get("numPerPage")!=0)
		{
			limtNo=(Integer)map.get("numPerPage");
		}
		if(map.containsKey("pageNum")&&(Integer)map.get("pageNum")!=null&&(Integer)map.get("pageNum")!=0)
		{
			tempSkip=(Integer)map.get("pageNum")-1;
		}
		//操作员名称
		if((String)map.get("operatorName")!=null && !"".equals((String)map.get("operatorName"))){
			criteria.and("operatorName").is((String)map.get("operatorName"));
		}
		//任务状态
		if((String)map.get("auditFlag")!=null && !"".equals((String)map.get("auditFlag"))){
			criteria.and("body.auditflag").is((String)map.get("auditFlag"));
		}
		//任务code
		if(null!=(String)map.get("rejectCode")&& !"".equals((String)map.get("rejectCode"))){
			criteria.and("rejectCode").is((String)map.get("rejectCode"));
		}
		//审核开始时间
		if((String)map.get("startTime")!=null && !"".equals((String)map.get("startTime"))
				//审核结束时间
				&& (String)map.get("endTime")!=null && !"".equals((String)map.get("endTime"))){
			Date startDate=format.parse((String)map.get("startTime"));
			Date endDate=format.parse((String)map.get("endTime"));
			criteria.and("disposeDate").gte(startDate).lte(endDate);
		}

		if(null!=(String)map.get("audittype") && !"".equals((String)map.get("audittype"))){
			criteria.and("body.audittype").is((String)map.get("audittype"));
		}

		//已审核
		criteria.and("status").is(CoreConstants.JOB_STATUS_99);
		query.addCriteria(criteria);

		query.with(new Sort(Direction.DESC, "disposeDate"));
		MongoPage<PersonalInfoAuditJobVO> mongoPage=personalInfoAuditJobDao.PageResultVO(query, tempSkip, limtNo, collectionName);
		PageInfo<PersonalInfoAuditJobVO> pageInfo=new PageInfo<>(mongoPage.getList());
		pageInfo.setPageNum(tempSkip);
		pageInfo.setPageSize(limtNo);
		pageInfo.setTotal(mongoPage.getTotal());
		PageInfoUtils util=new PageInfoUtils();
		util.setPageProperty(pageInfo);
		return pageInfo;
	}

	/*
	 * 根据客户编码，查找该客户实名详细信息
	 */
	public PrepPersonalinfoVO findLogPersonalInfoDetail(Map<String,Object> map){
		PrepPersonalinfoVO prepPersonalinfo =new PrepPersonalinfoVO();
		try {
			PrepPersonalinfo p=new PrepPersonalinfo();
			p.setCustomerid((String)map.get("customerid"));
			p = prepPersonalinfoDao.findPrepPersonalById(p);  //根据客户编码，查找客户图片信息
			BeanUtils.copyProperties(p,prepPersonalinfo);
			prepPersonalinfo.setCheckDate(DateUtil.getDateTime(new Date())); //详细页面查看时间
			//查询驳回数据信息
			List<RejectinfoVO> rejectinfoList = rejectinfoDao.findRejectInfoAll(); //驳回数据信息
			prepPersonalinfo.setRejectinfoList(rejectinfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prepPersonalinfo;
	}

}
