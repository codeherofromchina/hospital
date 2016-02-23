package com.hospital.service.remoteImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Department;
import com.hospital.pojo.request.QueryDepartmentGroupRequest;
import com.hospital.pojo.request.QueryDepartmentRequest;
import com.hospital.pojo.stub.RegistrationServiceSoap;
import com.hospital.service.DepartmentService;
import com.hospital.tools.ObjectTransUtil;
import com.hospital.tools.ServiceHelper;

/**
 * 
 * @author wxd
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Resource(name = "registrationServiceSoap")
	private RegistrationServiceSoap registrationService;
	
	/**
	 * 获取一级科室信息列表
	 */
	public List<Department> queryDepartmentGroup(
			QueryDepartmentGroupRequest request) throws TradeErrorException {
		// 将对象转换为接口需要的xml字符串格式并请求数据
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		String departmentsXml = registrationService.opRegistration(requestXML);

		return ServiceHelper.parseXmlToDepartments(departmentsXml);
	}

	/**
	 * 获取二级科室信息列表
	 */
	public List<Department> queryDepartment(QueryDepartmentRequest request)
			throws TradeErrorException {
		// 将对象转换为接口需要的xml字符串格式并请求数据
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		String departmentsXml = registrationService.opRegistration(requestXML);

		return ServiceHelper.parseXmlToDepartments(departmentsXml);
	}

}
