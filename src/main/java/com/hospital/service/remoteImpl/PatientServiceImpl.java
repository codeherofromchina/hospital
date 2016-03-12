package com.hospital.service.remoteImpl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Patient;
import com.hospital.pojo.request.GetPatInfoRequest;
import com.hospital.pojo.stub.RegistrationServiceSoap;
import com.hospital.service.PatientService;
import com.hospital.tools.ObjectTransUtil;
import com.hospital.tools.ServiceHelper;
/**
 * 病人服务接口实现类
 * @author wxd
 *
 */
@Service("defaultPatientService")
public class PatientServiceImpl implements PatientService{
	private final Logger logger = Logger.getLogger(getClass());
	/**
	 * 此类是webService操作类
	 */
	@Resource(name="registrationServiceSoap")
	private RegistrationServiceSoap registrationService;

	public Patient getPatInfo(GetPatInfoRequest request) throws TradeErrorException{
		// 将对象转换为接口需要的xml字符串格式
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		
		String patInfoXml = registrationService.opRegistration(requestXML);
		if(logger.isInfoEnabled()){
			logger.info("request msg is ["+requestXML+"] and response msg is ["+patInfoXml+"]");
		}
		return ServiceHelper.parseXmlToPatient(patInfoXml);
	}
	
	
}
