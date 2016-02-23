package com.hospital.service.remoteImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Patient;
import com.hospital.pojo.request.GetPatInfoRequest;
import com.hospital.pojo.stub.RegistrationServiceSoap;
import com.hospital.service.PatientService;
import com.hospital.tools.ObjectTransUtil;
import com.hospital.tools.ServiceHelper;
/**
 * ���˷���ӿ�ʵ����
 * @author wxd
 *
 */
@Service
public class PatientServiceImpl implements PatientService{
	
	/**
	 * ������webService������
	 */
	@Resource(name="registrationServiceSoap")
	private RegistrationServiceSoap registrationService;

	public Patient getPatInfo(GetPatInfoRequest request) throws TradeErrorException{
		// ������ת��Ϊ�ӿ���Ҫ��xml�ַ�����ʽ
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		
		String patInfoXml = registrationService.opRegistration(requestXML);
		
		return ServiceHelper.parseXmlToPatient(patInfoXml);
	}
	
	
}
