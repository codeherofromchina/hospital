package com.hospital.service;

import java.util.Date;
import java.util.List;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Schedule;

public interface ScheduleService {

	
	/**
	 * 查询科室的某天的某个时间段排班
	 * @param departmentCode  科室代码
	 * @param date  要查询的日期
	 * @return
	 * @throws TradeErrorException
	 */
	public List<Schedule> queryScheduleByDay(String departmentCode ,Date date) throws TradeErrorException;
	
	
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
	public List<Schedule> queryScheduleByDay(String departmentCode,String doctorCode,Date startDate,Date endDate) throws TradeErrorException;
}
