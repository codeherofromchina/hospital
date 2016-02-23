package com.hospital.service;

import java.util.List;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Department;
import com.hospital.pojo.request.QueryDepartmentGroupRequest;
import com.hospital.pojo.request.QueryDepartmentRequest;

/**
 * 科室操作接口规范
 * 
 * @author wxd
 *
 */
public interface DepartmentService {

	/**
	 * 查询一级科室信息列表
	 * 
	 * @param request
	 * @return
	 */
	public List<Department> queryDepartmentGroup(
			QueryDepartmentGroupRequest request) throws TradeErrorException;

	/**
	 * 查询二级科室信息列表
	 * 
	 * @param request
	 * @return
	 */
	public List<Department> queryDepartment(QueryDepartmentRequest request)
			throws TradeErrorException;
}
