/**
 * 
 */
package com.jfpay.core.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dongyuqiang
 *
 * @date 2017年8月30日
 */
public class CoreConstants {
public static final String PSAM_ID_STR="PSAMID";
	
	public static final String AGENT_LEVEL_1="1";
	
	/**未查询到记录*/
	public static final String PC40="PC40";
	/**"图片上传失败*/
	public static final String FAILPERSONCODE = "PC91";
	/**图片上传成功*/
	public static final String SUCESSPESONCODE = "PC01";
	
	public static final String PAYCUSTOMER_FAIL="客户信息审核失败！";   //个人信息审核失败
	public static final String PAYCUSTOMER_TAG="请选择审核状态!";   //个人信息审核失败
	public static final String SUCESSCUSTOMERMESSAGE = "个人信息审核，成功!"; //不满足审核条件
	
	public static Map<String,Object> ETB_SYSATOMICTRADE=new HashMap<String,Object>();
	
	public static Map<String,Object> ETB_SYSCORESERVICE=new HashMap<String,Object>();
	
	/**
	 * 处理异常
	 */
	public static String CODE_ERROR="PC99";
	
	public static String ERROR_MESS="系统异常";
	
	
	public static String CODE_PCP1="PCP1";
	public static String MSG_PCP1="缺少必填参数";
	
	public static String ERROR_MESS_D="地推系统异常";
	
	
	
	/**审核次数已经达到20次"*/
	public static String CODE_CHECKMESS="PC42";

	/**
	 *返回给地推的费率审核失败码，代表被审核用户处于黑名单或者注销状态
	 */
	public static  String CODE_USER_MESS_BALCKORCANCEL = "PCPB";


	/**图片未上传完整，请重新上传*/
	public static String PC41="PC41";
	
	/**
	 * 处理成功
	 */
	public static String CODE_SUCCESS="0000";
	
	/**
	 * 处理成功
	 */
	public static String CODE_SUCCESS1="HE00";
	
	/**
	 * 处理成功 描述
	 */
	public static String MSG_SUCCESS="处理成功！！！";
	
	
	/**************payjnls start****************/
	/**本地交易日期*/
	public static final String LOCAL_DATE="localDate";
	/**本地交易时间*/
	public static final String LOCAL_TIME="localTime";
	/**本地交易流水*/
	public static final String LOCAL_LOG_NO="locallogno";
	/**************payjnls end****************/
	
	/********************job stauts start***************/
	/**未分配 0*/
	public static final String JOB_STATUS_0="0";
	/**已分配 1*/
	public static final String JOB_STATUS_1="1";
	/**处理中 2 */
	public static final String JOB_STATUS_2="2";
	/**已处理 99 */
	public static final String JOB_STATUS_99="99";
	/**linkFace处理完状态 3*/
	public static final String JOB_STATUS_3="3";
	/********************job stauts end***************/
	
	/********************操作员  stauts start***************/
	/** 空闲*/
	public static final String OPERATION_STATUS_0="0";
	/** 忙碌*/
	public static final String OPERATION_STATUS_1="1";
	/** 夜间模式*/
	public static final String OPERATION_STATUS_2="2";
	
	/********************操作员  stauts end***************/
	
	public static final String SYSTEM_NAME="PM-CORE";
	
	public static final String DATA="data";
	public static final String LIST="list";
	
	/********************实名认证信息 状态 start***************/
	/**实名认证信息 未审核*/
	public static final String AUDIT_FIAL_2="2";
	/**实名认证信息 未审核*/
	public static final String AUDIT_FIAL_D="D";
	
	/**加急*/
	public static final String AUDIT_FIAL_6="6";
	
	/********************实名认证信息 状态 end***************/
	
	/**小时*/
	public static final int HOUR=8;
	
	/**默认状态*/
	public static final String DEFAULT_STATUS="1";
	
	public static final int DEFAULT_IS_DEL=0;
	
	public static final String PM_CORE="PM_CORE";
	
	/**账户冻结*/
	public static final String ACCOUNT_STATUS1 = "1";
	/**待冻结*/
	public static final String ACCOUNT_STATUS2 = "2";
	/**已强扣*/
	public static final String ACCOUNT_STATUS3 = "3";
	/**已取消*/
	public static final String ACCOUNT_STATUS4 = "4";
	
	public static final String ACCOUNT_MSG = "参数不全";
	/**日志类型 冻结*/
	public static final String ACCOUNT_STATUS = "5";
	
	/**日志类型 拉黑*/
	public static final String ACCOUNT_BLACK = "2";
	public static final String ACCOUNT_LH = "冻结-拉黑";
	public static final String ACCOUNT_PC = "冻结-排除";
	public static final String ACCOUNT_CANCLE = "冻结-取消";
	/**拉黑状态*/
	public static final String ACCOUNT_BLACK_TATUS = "B";
	
	/**资金冻结失败，余额不足*/
	public static final String ZH08 = "ZH08"; 
	
	public static final String SKIP="skip";
	
	public static final String LIMIT="limit";
	
	
	
	public static final String AGENT_ID="AGENT_ID";
	public static final String AGENT_NAME="AGENT_NAME";
	public static final String AGENT_LEVEL="AGENT_LEVEL";
	
	public static final String DEL_AGENT_ID="DEL_AGENT_ID";
	public static final String DEL_END_PSAM_ID="DEL_END_PSAM_ID";
	public static final String DEL_START_PSAM_ID="DEL_START_PSAM_ID";
	public static final String SERVCODE="SERVCODE";
	public static final String TRADECODE="TRADECODE";
	public static final String BUSSTYPE="BUSSTYPE";
	public static final String BUSSTYPE_1="1";
	public static final String BUSSTYPE_2="2";
	
	/**缓存payjnls map*/
	public static Map<String,Object> CACHE_PAYJNLS_MAP=new HashMap<String,Object>();
	
	public static final String CURRENT_PAGE_NUM="currentPageNum";
	public static final String LIMIT_NO="limtNo";
	
	public static final String agentId="agentId";
	public static final String agentName="agentName";
	public static final String startPsamId="startPsamId";
	public static final String endPsamId="endPsamId";
	public static final String agentValId="agentValId";
	public static final String agentLevel="agentLevel";
	
	public static final String _id="_id";
	
	public static final String CUSTOMER_ID="customer.customerId";
	
	public static final String START_PSAM_ID="START_PSAM_ID";
	public static final String END_PSAM_ID="END_PSAM_ID";
	
	public static final String AUDIT_FLAG="body.auditflag";
	/**通过*/
	public static final String AUDIT_FLAG_3="3";

	/**黑名单*/
	public static final String CUSTOMER_FLAG_B="B";

	/**注销*/
	public static final String CUSTOMER_FLAG_Z="Z";
	/**驳回*/
	public static final String AUDIT_FLAG_4="4";
	/**持证不清*/
	public static final String AUDIT_FLAG_C="C";
	
	public static final String ERROR_504 = "PC54";
	
	public static final String ERRMESS_504 = "请求超时";
	
	public static final String USER_MESS = "未注册";
	
	public static final String USER_MESS1 = "未审核通过";


	public static final String USER_MESS_BALCKORCANCEL = "用户处于黑名单状态或者被注销";
	
	public static final String PC40_MESS = "数据不存在";
	
	/**分润流水查询标记*/
	public static boolean PROFIT_FLAG=false;
	
	
	//客户端应用类型，返回类型和返回说明
	public static final String PREP_CLIENT_01="PC001";
	public static final String PREP_CLIENT_01_MSG="数据格式不完整，请重新输入!";
	public static final String PREP_CLIENT_02 ="PC002";
	public static final String PREP_CLIENT_02_MSG="客户端，版本同步错误，请联系系统管理员！";
	public static final String PREP_CLIENT_03 ="PC003";
	public static final String PREP_CLIENT_03_MSG="数据已被修改，存在相同的版本信息，请确认后在重新录入!";
	
	
	public static final String FAIL_CODE="PC00";
	public static final String FAIL_MSG="数据录入失败，处理失败!";
	
	//呼叫中心接口返回类型和返回说明
	public static final String FOREIGN_FAIL_CODE="PC00";
	public static final String FOREIGN_FAIL_MSG="请求签名错误，请确认后在请求！";
	
	public static final String FOREIGN_FAIL_MSG_TOOMANYMSG="根据请求手机号得到查询结果过多,查询失败！";

	//用户名密码错误
	public static final String FOREIGN_FAIL_CODE_1="PC01";
	public static final String FOREIGN_FAIL_MSG_1="用户名或密码不正确，验证失败！";
	//用户不存在
	public static final String FOREIGN_FAIL_CODE_2="PC02";
	public static final String FOREIGN_FAIL_MSG_2="用户不存在请确认后在输入，验证失败！";
	
	public static final String ACCOUNT_PP = "跑批";
	
	public static final String ACCOUNT_FROZE_CODE = "PC53";
	public static final String ACCOUNT_FROZE_MESS = "该条数据已经录入，请重新录入！";
	
	//查询结果为空
	public static final String CUSTOMER_SELECT_NULL = "PC99";
	public static final String CUSTOMER_SELECT_NULL_MSG = "未查询到相关的用户信息";
	
	//必填项未填
	public static final String MUST_POST_VALUE_NULL = "PC55";
	public static final String MUST_POST_VALUE_NULL_data = "数据域为空";
	public static final String MUST_POST_VALUE_NULL_sign = "数字签名为空";
	public static final String MUST_POST_VALUE_NULL_channelId = "第三方标识为空";
	public static final String MUST_POST_VALUE_NULL_mobileNo = "手机号码为空";
	public static final String MUST_POST_VALUE_NULL_realName = "用户姓名为空";
	
	//参数不符合规定
	public static final String POST_PARAMETERS_ILLEGAL = "PC56";
	public static final String POST_PARAMETERS_ILL_VALUE = "手机号码异常";

	/**地推*/
	public static final String AUDITTYPE_2 = "2";
	/**地推个人进件审核*/
	public static final String TYPE_PERSON = "0";
	/**地推个人费率回调*/
	public static final String TYPE_FEE = "1";
	/**地推费率回调失败原因*/
	public static final String CALL_MESS = "此用户不存在！";
	/**地推*/
	public static final String TDTYPE = "1";
}
