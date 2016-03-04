package com.hospital.service;

import java.util.List;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Schedule;
import com.hospital.pojo.request.QueryAdmScheduleRequest;

public interface ScheduleService {

	/**
	 * 查詢排班信息記錄
	 * 
	 * @param request
	 * @return
	 * @throws TradeErrorException
	 */
	public List<Schedule> queryAdmSchedule(QueryAdmScheduleRequest request) throws TradeErrorException;
}
