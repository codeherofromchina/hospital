package com.hospital.service.remoteImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Department;
import com.hospital.pojo.Doctor;
import com.hospital.pojo.request.QueryDoctorRequest;
import com.hospital.pojo.stub.RegistrationServiceSoap;
import com.hospital.service.DepartmentService;
import com.hospital.service.DoctorService;
import com.hospital.tools.ObjectTransUtil;
import com.hospital.tools.ServiceHelper;

/**
 * 医生接口服务实现类
 * 
 * @author wxd
 *
 */
@Service("defaultDoctorServiceImpl")
public class DoctorServiceImpl implements DoctorService {
	private final Logger logger = Logger.getLogger(getClass());
	@Resource(name = "registrationServiceSoap")
	private RegistrationServiceSoap registrationService;
	@Resource(name="defaultDepartmentServiceImpl")
	private DepartmentService departmentService;
	
	
	/**
	 * 获取科室的医师列表
	 * @throws TradeErrorException 
	 */
	public List<Doctor> queryDoctor(String deparmentCode) throws TradeErrorException {
		QueryDoctorRequest request = new QueryDoctorRequest(deparmentCode);
		
		return queryDoctor(request);
	}
	
	/**
	 * 查询所有科室中的医生列表，因此医院没有二级科室，所以就直接查询一级科室了
	 */
	public List<Doctor> queryAllDoctor() throws TradeErrorException {
		List<Doctor> _result = new ArrayList<Doctor>();
		
		// 获取所有科室
		List<Department> departmentGroups = departmentService.queryDepartmentGroup();
		for(Department dept:departmentGroups){
			List<Doctor> dDocutors = queryDoctor(dept.getDepartmentCode());
			_result.addAll(dDocutors);
		}
		
		return _result;
	}
	
	/**
	 * 根据请求信息获取医生信息
	 * @throws TradeErrorException 
	 */
	public List<Doctor> queryDoctor(QueryDoctorRequest request) throws TradeErrorException {
		// 将对象转换为接口需要的xml字符串格式并请求数据
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		String doctors = registrationService.opRegistration(requestXML);
		if(logger.isInfoEnabled()){
			logger.info("request msg is ["+requestXML+"] and response msg is ["+doctors+"]");
		}
		return ServiceHelper.parseXmlToDoctor(doctors);
	}

}
