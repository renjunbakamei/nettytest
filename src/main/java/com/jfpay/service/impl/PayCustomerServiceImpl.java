/**
 * 
 */
package com.jfpay.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfpay.dao.read.IPayCustomerDao;
import com.jfpay.entity.DO.PayCustomer;
import com.jfpay.service.IPayCustomerService;
import com.jfpay.utils.MapConvertUtils;

/**
 * @author dongyuqiang
 *
 * @date 2017年9月6日
 */
@Service
public class PayCustomerServiceImpl implements IPayCustomerService{
	@Autowired 
	private IPayCustomerDao iPayCustomerDao;
	@Override
	public Long findCountPserson(Map<String, Object> map) {
		String mobile = (String) map.get("mobile");
		Long countPserson = iPayCustomerDao.findCountPserson(mobile);
		return countPserson;
	}
	
	/**
	 * 根据交易日期，查询客户等级百分比
	 */
	@Override
	public List<PayCustomer> findCustomerLevel(Map<String, Object> map) {
		PayCustomer payCustomer=new PayCustomer();
		try {
			payCustomer = (PayCustomer) MapConvertUtils.mapToObject(map, PayCustomer.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<PayCustomer> customerList = iPayCustomerDao.findCustomerLevel(payCustomer);
		Long personCount = iPayCustomerDao.getCustomerCount(payCustomer);
		//重新封装数据
		List<PayCustomer> payCustomerList =new ArrayList<PayCustomer>();
		if(customerList.size()>0){
			//做百分比处理
			for(PayCustomer p : customerList){
				float size = (float)(Long.valueOf(p.getCustomerCount()))/personCount;
				DecimalFormat df = new DecimalFormat("0.000");//格式化小数，不足的补0
				String recent = String.valueOf(Math.round((Double.valueOf(df.format(size))*100)));
				p.setPrecent(recent);   //百分比
				p.setStartDate(payCustomer.getStartDate());  //注册开始时间
				p.setEndDate(payCustomer.getEndDate());  //注册结束时间
				payCustomerList.add(p);
			}
		}
		return payCustomerList;
	}

}
