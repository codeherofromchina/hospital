package com.hospital.service.remoteImpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
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
@Service("defaultScheduleService")
public class ScheduleServiceImpl implements ScheduleService {
	private final Logger logger = Logger.getLogger(getClass());
	@Resource(name = "registrationServiceSoap")
	private RegistrationServiceSoap registrationService;

	/**
	 * 查询排班记录列表
	 */
	public List<Schedule> queryAdmSchedule(QueryAdmScheduleRequest request) throws TradeErrorException {
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		String schedules = registrationService.opRegistration(requestXML);
		if(logger.isInfoEnabled()){
			logger.info("request msg is ["+requestXML+"] and response msg is ["+schedules+"]");
		}
		return ServiceHelper.parseXmlToSchedules(schedules);
	}

}
