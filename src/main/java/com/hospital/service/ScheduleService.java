package com.hospital.service;

import java.util.Date;
import java.util.List;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Schedule;

public interface ScheduleService {

	
	/**
	 * 查询科室的某天的某个时间段排班
	 * @param departmentCode  科室代码
	 * @param timeSlot   S：上午 X：下午  Y：夜晚
	 * @param startDate  要查询的开始日期
	 * @param endDate  要查询的结束日期
	 * @return
	 * @throws TradeErrorException
	 */
	public List<Schedule> queryScheduleByDay(String departmentCode,String timeSlot,Date startDate,Date endDate) throws TradeErrorException;
	
	
	/**
	 * 查询科室中医师某天的某个时间段排班
	 * @param departmentCode
	 * @param doctorCode
	 * @param timeSlot
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws TradeErrorException
	 */
	public List<Schedule> queryScheduleByDay(String departmentCode,String doctorCode,String timeSlot,Date startDate,Date endDate) throws TradeErrorException;
}
