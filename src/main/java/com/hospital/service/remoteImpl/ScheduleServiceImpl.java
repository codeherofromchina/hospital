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
 * �Ű���Ϣ�ӿڲ�ѯ����ʵ����
 * 
 * @author wxd
 *
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Resource(name = "registrationServiceSoap")
	private RegistrationServiceSoap registrationService;

	/**
	 * ��ѯ�Ű��¼�б�
	 */
	public List<Schedule> queryAdmSchedule(QueryAdmScheduleRequest request) throws TradeErrorException {
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		String schedules = registrationService.opRegistration(requestXML);

		return ServiceHelper.parseXmlToSchedules(schedules);
	}

}
