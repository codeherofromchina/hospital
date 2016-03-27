package com.hospital.service.remoteImpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Department;
import com.hospital.pojo.request.QueryDepartmentGroupRequest;
import com.hospital.pojo.request.QueryDepartmentRequest;
import com.hospital.pojo.stub.RegistrationServiceSoap;
import com.hospital.service.DepartmentService;
import com.hospital.tools.DataCacheUtil;
import com.hospital.tools.ObjectTransUtil;
import com.hospital.tools.ServiceHelper;

/**
 * 
 * @author wxd
 *
 */
@Service("defaultDepartmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {
	private final Logger logger = Logger.getLogger(getClass());
	@Resource(name = "registrationServiceSoap")
	private RegistrationServiceSoap registrationService;
	
	/**
	 * 直接获取所有二级科室，此医院没有一级科室
	 */
	public List<Department> queryAllDepartments() throws TradeErrorException {
		// 先从缓存中获取缓存数据，如果不存在，则查询并放入缓存供下次使用
		List data = DataCacheUtil.getData(DataCacheUtil.CacheKey.ALL_DEPARTMENT_KEY, List.class);
		if(data!=null){
			return data;
		}
		// 远程查询
		List<Department> allDepts = queryDepartment(new QueryDepartmentRequest());
		// 将远程查询结果放入到缓存中
		DataCacheUtil.putData(DataCacheUtil.CacheKey.ALL_DEPARTMENT_KEY, allDepts);
		return allDepts;
	}
	
	/**
	 * 通过科室编号获取科室信息
	 */
	public Department queryByDeptCode(String deptCode) throws TradeErrorException{
		if(StringUtils.isNotEmpty(deptCode)){
			QueryDepartmentRequest deptRequest = new QueryDepartmentRequest();
			deptRequest.setDepartmentCode(deptCode);
			List<Department> depts = queryDepartment(deptRequest);
			if(depts!=null && depts.size() > 0){
				return depts.get(0);
			}
		}
		
		return null;
	}
	
	/**
	 * 获取一级科室信息列表
	 */
	@Deprecated
	public List<Department> queryDepartmentGroup(
			QueryDepartmentGroupRequest request) throws TradeErrorException {
		// 将对象转换为接口需要的xml字符串格式并请求数据
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		String departmentsXml = registrationService.opRegistration(requestXML);
		if(logger.isInfoEnabled()){
			logger.info("request msg is ["+requestXML+"] and response msg is ["+departmentsXml+"]");
		}

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
		if(logger.isInfoEnabled()){
			logger.info("request msg is ["+requestXML+"] and response msg is ["+departmentsXml+"]");
		}
		return ServiceHelper.parseXmlToDepartments(departmentsXml);
	}

}
