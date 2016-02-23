package com.hospital.service.remoteImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Doctor;
import com.hospital.pojo.request.QueryDoctorRequest;
import com.hospital.pojo.stub.RegistrationServiceSoap;
import com.hospital.service.DoctorService;
import com.hospital.tools.ObjectTransUtil;
import com.hospital.tools.ServiceHelper;

/**
 * ҽ���ӿڷ���ʵ����
 * 
 * @author wxd
 *
 */
@Service
public class DoctorServiceImpl implements DoctorService {
	@Resource(name = "registrationServiceSoap")
	private RegistrationServiceSoap registrationService;

	/**
	 * ����������Ϣ��ȡҽ����Ϣ
	 * @throws TradeErrorException 
	 */
	public List<Doctor> queryDoctor(QueryDoctorRequest request) throws TradeErrorException {
		// ������ת��Ϊ�ӿ���Ҫ��xml�ַ�����ʽ����������
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		String doctors = registrationService.opRegistration(requestXML);

		return ServiceHelper.parseXmlToDoctor(doctors);
	}

}
