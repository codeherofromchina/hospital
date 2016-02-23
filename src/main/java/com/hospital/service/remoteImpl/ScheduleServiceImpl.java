package com.hospital.service.remoteImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Schedule;
import com.hospital.pojo.request.QueryAdmScheduleRequest;
import com.hospital.pojo.stub.RegistrationServiceSoap;
import com.hospital.service.ScheduleService;
import com.hospital.tools.ObjectTransUtil;
import com.hospital.tools.ServiceHelper;

/**
 * 排班信息接口查询服务实现类
 * 
 * @author wxd
 *
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Resource(name = "registrationServiceSoap")
	private RegistrationServiceSoap registrationService;

	/**
	 * 查询排班记录列表
	 */
	public List<Schedule> queryAdmSchedule(QueryAdmScheduleRequest request) throws TradeErrorException {
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		String schedules = registrationService.opRegistration(requestXML);

		return ServiceHelper.parseXmlToSchedules(schedules);
	}

}
