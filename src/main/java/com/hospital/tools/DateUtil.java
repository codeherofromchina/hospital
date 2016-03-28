package com.hospital.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public final class DateUtil {
	private final static Logger logger = Logger.getLogger(DateUtil.class);
	private final static DateFormat shortDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	
	/**
	 * 将时间转换为  yyyy-mm-dd 的短字符串格式
	 * @param date
	 * @return
	 */
	public static String formatToShortString(Date date){
		return shortDateFormat.format(date);
	}
	
	/**
	 * 将给定字符串转换为date格式数据
	 * @param source   格式需要为  yyyy-mm-dd
	 * @return
	 */
	public static Date parseShortStrToDate(String source){
		try {
			return shortDateFormat.parse(source);
		} catch (ParseException e) {
			logger.error("字符串转时间错误["+e.getMessage()+"]");
		}
		return null;
	}
	
	
	/**
	 * 在给定日期的基础上增加n天
	 * @param date   基数日期
	 * @param plusDay    增加的天数
	 * @return
	 */
	public static Date plusSomeDay(Date date,int plusDay){
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, plusDay);
		
		return calendar.getTime();
	}
	
}
