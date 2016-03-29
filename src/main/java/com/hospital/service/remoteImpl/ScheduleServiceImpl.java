package com.hospital.service.remoteImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Schedule;
import com.hospital.pojo.request.QueryAdmScheduleRequest;
import com.hospital.pojo.stub.RegistrationServiceSoap;
import com.hospital.service.ScheduleService;
import com.hospital.tools.DateUtil;
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
	public List<Schedule> queryAdmSchedule(QueryAdmScheduleRequest request)
			throws TradeErrorException {
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		String schedules = registrationService.opRegistration(requestXML);
		if (logger.isInfoEnabled()) {
			logger.info("request msg is [" + requestXML
					+ "] and response msg is [" + schedules + "]");
		}
		return ServiceHelper.parseXmlToSchedules(schedules);
	}

	/**
	 * 查询科室的某天的某个时间段排班
	 * 
	 * @param departmentCode
	 *            科室代码
	 * @param date
	 *            要查询的日期
	 * @return
	 * @throws TradeErrorException
	 */
	public List<Schedule> queryScheduleByDay(String departmentCode, Date date)
			throws TradeErrorException {
		QueryAdmScheduleRequest request = new QueryAdmScheduleRequest();

		request.setDepartmentCode(departmentCode);
		request.setStartDate(DateUtil.formatToShortString(date));
		request.setEndDate(DateUtil.formatToShortString(date));

		return queryAdmSchedule(request);
	}

	/**
	 * 
	 * TODO 需要测试
	 * 查询科室中医师的某天的某个时间段排班
	 * 
	 * @param departmentCode
	 *            科室代码
	 * @param doctorCode
	 *            医生代码
	 * @param startDate
	 *            要查询的开始日期
	 * @param endDate
	 *            要查询的结束日期
	 * @return
	 * @throws TradeErrorException
	 */
	public List<Schedule> queryScheduleByDay(String departmentCode,
			String doctorCode , Date startDate, Date endDate)
			throws TradeErrorException {
		QueryAdmScheduleRequest request = new QueryAdmScheduleRequest();

		request.setDepartmentCode(departmentCode);
		request.setDoctorCode(doctorCode);
		request.setStartDate(DateUtil.formatToShortString(startDate));
		request.setEndDate(DateUtil.formatToShortString(endDate));

		return queryAdmSchedule(request);
	}
	

}
