package com.hospital.service;

import java.util.List;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Schedule;
import com.hospital.pojo.request.QueryAdmScheduleRequest;

public interface ScheduleService {

	/**
	 * ≤È‘É≈≈∞‡–≈œ¢”õ‰õ
	 * 
	 * @param request
	 * @return
	 * @throws TradeErrorException
	 */
	public List<Schedule> queryAdmSchedule(QueryAdmScheduleRequest request) throws TradeErrorException;
}
