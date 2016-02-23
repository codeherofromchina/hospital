package com.hospital.service;

import java.util.List;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Department;
import com.hospital.pojo.request.QueryDepartmentGroupRequest;
import com.hospital.pojo.request.QueryDepartmentRequest;

/**
 * ���Ҳ����ӿڹ淶
 * 
 * @author wxd
 *
 */
public interface DepartmentService {

	/**
	 * ��ѯһ��������Ϣ�б�
	 * 
	 * @param request
	 * @return
	 */
	public List<Department> queryDepartmentGroup(
			QueryDepartmentGroupRequest request) throws TradeErrorException;

	/**
	 * ��ѯ����������Ϣ�б�
	 * 
	 * @param request
	 * @return
	 */
	public List<Department> queryDepartment(QueryDepartmentRequest request)
			throws TradeErrorException;
}
