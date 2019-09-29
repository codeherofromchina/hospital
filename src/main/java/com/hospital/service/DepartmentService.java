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
	 * 查询所有科室信息列表
	 * 
	 * @return
	 */
	List<Department> queryAllDepartments() throws TradeErrorException;

	/**
	 * 通过科室编号获取科室信息
	 * @param deptCode
	 * @return
	 */
	Department queryByDeptCode(String deptCode) throws TradeErrorException;
}
