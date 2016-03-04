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
 * 医生接口服务实现类
 * 
 * @author wxd
 *
 */
@Service
public class DoctorServiceImpl implements DoctorService {
	@Resource(name = "registrationServiceSoap")
	private RegistrationServiceSoap registrationService;

	/**
	 * 根据请求信息获取医生信息
	 * @throws TradeErrorException 
	 */
	public List<Doctor> queryDoctor(QueryDoctorRequest request) throws TradeErrorException {
		// 将对象转换为接口需要的xml字符串格式并请求数据
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		String doctors = registrationService.opRegistration(requestXML);

		return ServiceHelper.parseXmlToDoctor(doctors);
	}

}
