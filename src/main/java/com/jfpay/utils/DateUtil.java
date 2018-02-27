package com.jfpay.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

	private static String datePattern = "yyyy-MM-dd";
	
	public static String datePattern_YYYYMMdd = "yyyyMMdd";

	public static String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
	
	public static DateFormat FORMAT_DATA_TIME = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public static String FORMATSTR="yyyyMMddHHmmss";

	private static String timePattern = "HH:mm";
	
	private final static DateFormat FORMAT_YYYYMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public final static DateFormat FORMAT_HHMMSS = new SimpleDateFormat("HHmmss");
	
	public final static DateFormat FORMAT_HH = new SimpleDateFormat("HH");

	//增加threadlocal，SimpleDateFormat的线程安全
	private static final ThreadLocal<SimpleDateFormat> messageFormat=new ThreadLocal<SimpleDateFormat>();
	/**
	 * Return 缺省的日期格式 (yyyy/MM/dd)
	 *
	 * @return 在页面中显示的日期格式
	 */
	public static String getDatePattern() {
		return datePattern;
	}

	/**
	 * 根据日期格式，返回日期按datePattern格式转换后的字符串
	 *
	 * @param aDate
	 *            日期对象
	 * @return 格式化后的日期的页面显示字符串
	 */
	public static final String getDate(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(datePattern);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	private  static final SimpleDateFormat  getDateFormatByThreadLocal(){
		SimpleDateFormat format=messageFormat.get();
		if(format==null){
			format=new SimpleDateFormat(dateTimePattern);
			messageFormat.set(format);
		}
		return format;
	}

	public static Date getDateByThreadLocal(String dateString) throws Exception{
		SimpleDateFormat sdf=getDateFormatByThreadLocal();
		Date date;
		date=sdf.parse(dateString);
		return date;
	}

	/**
	 * 根据日期格式，返回日期按datePattern格式转换后的字符串
	 *
	 * @param aDate
	 *            日期对象
	 * @return 格式化后的日期的页面显示字符串
	 */
	public static final String getDateTime(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(dateTimePattern);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * 按照日期格式，将字符串解析为日期对象
	 *
	 * @param aMask
	 *            输入字符串的格式
	 * @param strDate
	 *            一个按aMask格式排列的日期的字符串描述
	 * @return Date 对象
	 * @see java.text.SimpleDateFormat
	 */
	public static final Date convertStringToDate(String aMask, String strDate){
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("converting '" + strDate + "' to date with mask '"
					+ aMask + "'");
		}

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			LOGGER.error("ParseException: " + pe);
			//throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * This method returns the current date time in the format: yyyy/MM/dd HH:MM
	 * a
	 *
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(timePattern, theTime);
	}

	/**
	 * This method returns the current date in the format: yyyy-MM-dd
	 *
	 * @return the current date
	 * @throws ParseException
	 */
	public static Calendar getToday() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(datePattern);

		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));

		return cal;
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 *
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 *
	 * @see java.text.SimpleDateFormat
	 */
	public static final String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			LOGGER.error("aDate is null!");
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * 根据日期格式，返回日期按datePattern格式转换后的字符串
	 *
	 * @param aDate
	 * @return
	 */
	public static final String convertDateToString(Date aDate) {
		return getDateTime(datePattern, aDate);
	}
	
	/**
	 * 根据日期格式，返回日期按dateTimePattern格式转换后的字符串
	 *
	 * @param aDate
	 * @return
	 */
	public static final String convertDateTimeToString(Date aDate) {
		return getDateTime(dateTimePattern, aDate);
	}

	/**
	 * 按照日期格式，将字符串解析为日期对象
	 *
	 * @param strDate
	 *            (格式 yyyyMMdd)
	 * @return
	 *
	 * @throws ParseException
	 */
	public static Date convertYYYYMMDDToDate(String strDate){
		Date aDate = null;
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("converting date with pattern: " + 	datePattern_YYYYMMdd);
		}
		aDate = convertStringToDate(	datePattern_YYYYMMdd, strDate);
		return aDate;
	}
	/**
	 * 按照日期格式，将字符串解析为日期对象
	 *
	 * @param strDate
	 *            (格式 yyyy-MM-dd)
	 * @return
	 *
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String strDate){
		Date aDate = null;

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("converting date with pattern: " + datePattern);
		}

		aDate = convertStringToDate(datePattern, strDate);

		return aDate;
	}

	/**
	 * 按照日期格式，将字符串解析为日期对象
	 *
	 * @param strDate
	 *            (格式 yyyy-MM-dd HH:mm:ss)
	 * @return
	 *
	 * @throws ParseException
	 */
	public static Date convertTimeStringToDate(String strDate){
		Date aDate = null;

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("converting date with pattern: " + dateTimePattern);
		}

		aDate = convertStringToDate(dateTimePattern, strDate);

		return aDate;
	}

	/**
	 * 时间相加
	 *
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date dateAdd(Date date, int day) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, day);
		return calendar.getTime();
	}

	/**
	 * 获取两个日期之间的天数
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long dateDiffer(Date date1, Date date2) {
		return (date1.getTime() - date2.getTime()) / (1000 * 3600 * 24);
	}
	/**
	 * 得到两个日期之间的天数差，包括开始和结束日期(如：beginCalender=2007-10-01，endCalendar=2007-10-20
	 * 结果为：20)
	 * 
	 * @param beginCalender
	 *            开始日期(小的)
	 * @param endCalendar
	 *            结束日期(大的)
	 * @return
	 */
	public static Long getDifferenceDays(Date beginDay, Date endDay) {
		Calendar beginCalender = Calendar.getInstance();
		beginCalender.setTime(beginDay);

		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDay);

		Long days = (endCalendar.getTimeInMillis() - beginCalender
				.getTimeInMillis())
				/ (24 * 60 * 60 * 1000);
		days = days + 1;
		return days;
	}
	public static Date getFirstDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
	
	public static Date getLastDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}
	/**
	 * 返回本月最后一天
	 * @param date
	 * @return
	 */
	public static String getLastDayStr(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH,0);
		DateFormat format = new SimpleDateFormat(datePattern_YYYYMMdd);
		return format.format(cal.getTime());
	}
	/**
	 * 返回日期String格式  yyyyMMdd
	 * @param date
	 * @return
	 */
	public static String getDateStr(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		DateFormat format = new SimpleDateFormat(datePattern_YYYYMMdd);
		return format.format(cal.getTime());
	}
	/**
	 * 返回本月第一天
	 * @param date  日期
	 * @param month  0 当月  1下月  -1  上月  以此类推 
	 * @return
	 */
	public static String getFirstDateStr(int month, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH,1);
		cal.set(Calendar.MONTH, month);
		DateFormat format = new SimpleDateFormat(datePattern_YYYYMMdd);
		return format.format(cal.getTime());
	}
	
	/**
	 * 得到当前时间,格式为yyyyMMddHHmmss
	 *
	 * @return
	 */
	public static String getyyyyMMddHHmmssCurDate() {
		return FORMAT_YYYYMMddHHmmss.format(new Date());
	}
	/**
	 * date转换成calendar，只精确到yyyyMMdd
	 * @throws ParseException 
	 */
	public static Calendar getyyyyMMDDCalendar(Date date) throws ParseException{
			SimpleDateFormat dataFormat = new SimpleDateFormat(datePattern_YYYYMMdd);
			dataFormat.parse(dataFormat.format(date));
			return dataFormat.getCalendar();
	}
	/**
	 * 获取日期毫秒数(精确到天)
	 * @throws ParseException 
	 */
	public static long getyyyyMMDDTimeInMillis(Date date) throws ParseException{
			return getyyyyMMDDCalendar(date).getTimeInMillis();
	}
	/**
	 * 获取日期的HHmmss
	 * @param date
	 * @return
	 */
	public static long getFormatHHmmss(Date date){
		return Long.valueOf(FORMAT_HHMMSS.format(date));
	}
	/**
	 * 获取日期的HH
	 * @param date
	 * @return
	 */
	public static long getFormatHH(Date date){
		return Long.valueOf(FORMAT_HH.format(date));
	}
	/**
	 * 时间是否在<code>days</code>内
	 * 
	 * @param old
	 * @param days
	 * @return
	 */
	public static boolean isDaysInterval(Date old, int days) {
		Calendar now = Calendar.getInstance();
		return (now.getTimeInMillis() - old.getTime()) <= (1000L * 3600 * 24 * days);
	}

	/**
	 * 得到当前日期后的N天的日期
	 * 
	 * @param days
	 *            天数
	 * @return
	 */
	public static Date getBackDaysOfNow(int days) {
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(now.getTimeInMillis() + 1000L * 3600 * 24 * days);
		return now.getTime();
	}
	public static void main(String[] args) {
		System.out.println(getLastDayStr(new Date()));
		System.out.println(getFirstDateStr(-1,new Date()));
		System.out.println(getDateStr(new Date()));
	}

	public static Date getBackDaysOfDay(Date date,int days) {
		Calendar day = Calendar.getInstance();
		day.setTime(date);
		day.setTimeInMillis(day.getTimeInMillis() + 1000L * 3600 * 24 * days);
		return day.getTime();
	}

	public static Date getBeginOfDay(Date day) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(day);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			return calendar.getTime();
	}
	
	/**
	 * 比较2个时间大小
	 * @author herion
	 * 2015-1-8下午1:02:38
	 * @param d1
	 * @param d2
	 */
	public static int compare(Date d1, Date d2) {
		String str1 = FORMAT.format(d1);
		String str2 = FORMAT.format(d2);

		int result = str1.compareTo(str2);
		if (result > 0) {
			System.out.println(str1 + " 晚于 " + str2);
		} else if (result == 0) {
			System.out.println(str1 + " 等于 " + str2);
		} else {
			System.out.println(str1 + " 早于 " + str2);
		}
		return result;
	}
	
	/**
	 * 根据时间和小时返回转换后的时间
	 * @author herion
	 * 2015-1-21下午2:25:58
	 * @param date 时间
	 * @param hour  小时
	 * @return
	 */
	public static Date addHour(Date date,int hour){
		Calendar ca=Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.HOUR_OF_DAY,hour);
		return ca.getTime();
	}
	
	
	/**
	 * string时间减法运算
	 * @author herion
	 * 2015-2-5下午7:04:08
	 * @param paramStr
	 * @return
	 */
	public static String convertStringToTimeSub(String paramStr,int minute){
		SimpleDateFormat sdf= new SimpleDateFormat("HHmmss");
		Date date = null;
		try {
			date = sdf.parse(paramStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - minute);
		return sdf.format(calendar.getTime());
	}
	
	
	/**
	 * 加法
	 * @author herion
	 * 2015-2-5下午7:05:49
	 * @param paramStr
	 * @param minute
	 * @return
	 */
	public static String convertStringToTimeAdd(String paramStr,int minute){
		SimpleDateFormat sdf= new SimpleDateFormat("HHmmss");
		Date date = null;
		try {
			date = sdf.parse(paramStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + minute);
		return sdf.format(calendar.getTime());
	}
	
	/**
     * 获得指定日期的前一天
     * 
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (Exception e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat("yyyyMMdd").format(c
                .getTime());
        return dayBefore;
    }
    
    /**
	 * 使用预设格式将字符串转为Date
	 */
	public static Date parse(String strDate) throws ParseException {
		return org.apache.commons.lang.StringUtils.isBlank(strDate) ? null : parse(strDate, getDatePattern());
	}
	/**
	 * 使用参数Format将字符串转为Date
	 */
	public static Date parse(String strDate, String pattern) throws ParseException {
		return org.apache.commons.lang.StringUtils.isBlank(strDate) ? null : new SimpleDateFormat(pattern).parse(strDate);
	}
	/**
	 * 使用预设Format格式化Date成字符串
	 */
	public static String format(Date date) {
		return date == null ? "" : format(date, getDatePattern());
	}
	/**
	 * 使用参数Format格式化Date成字符串
	 */
	public static String format(Date date, String pattern) {
		return date == null ? "" : new SimpleDateFormat(pattern).format(date);
	}
	
	/**
	 * 在日期上增加数天
	 * @param date
	 * @param n
	 * @return 
	 */
	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, n);
		return cal.getTime();
	}
	/**
	 * 获得月末日: flag=1:获得上月月末日 flag=0：获得本月月末日
	 */
	public static Date getLastDayOfMonth(Date date, int flag) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//日，设为一号
		cal.set(Calendar.DATE, 1);
		//月份加一，得到下个月的一号
		cal.add(Calendar.MONTH, flag);
		//下一个月减一为本月最后一天
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}
	
	/**
	 * 获得月末日
	 */
	public static Date getLastDayOfMonth(String year, String month, int flag) {

		Calendar cal = Calendar.getInstance();
		//年
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		//月，因为Calendar里的月是从0开始，所以要-1
		cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		//日，设为一号
		cal.set(Calendar.DATE, 1);
		//月份加一，得到下个月的一号
		cal.add(Calendar.MONTH, flag);
		//下一个月减一为本月最后一天
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}
	
	/**
	 * 获得两天之间相差天数 date-date1
	 * @param date    
	 * @param date1
	 * @return
	 */
	public static int getDiffDate(java.util.Date date, java.util.Date date1) {
		return (int) ((date.getTime() - date1.getTime()) / (24 * 3600 * 1000));
	}
	
	/***********************8
	 * 获取当前日期30天日期
	 * lihu 20151016
	 */
	public static String getBeforeDate(int day){
		Date dNow = new Date(); // 当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); // 得到日历
		calendar.setTime(dNow);// 把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, -(day)); // 设置相隔天数
		dBefore = calendar.getTime(); // 得到前一天的时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 设置时间格式
		String defaultStartDate = sdf.format(dBefore); // 格式化日期
		return defaultStartDate;
	}
	
	/**
	 * 求两个时间之间的天数
	 * @param smdate
	 * @param bdate
	 * @return
	 */
	public static int daysBetween(String smdate,String bdate) {  
		try{
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(sdf.parse(smdate));    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(sdf.parse(bdate));    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	            
	       return Integer.parseInt(String.valueOf(between_days));   
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
    }  
	
}
