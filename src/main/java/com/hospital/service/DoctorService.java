package com.hospital.service;

import java.util.List;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Doctor;

/**
 * 医生接口操作规范
 * @author wxd
 *
 */
public interface DoctorService {
	
	/**
	 * 获取相关科室医生列表信息
	 * @param request
	 * @return
	 */
	public List<Doctor> queryDoctor(String departmentCode) throws TradeErrorException;

	/**
	 * 获取医院中的所有医生列表
	 * @return
	 */
	public List<Doctor> queryAllDoctor() throws TradeErrorException;
	
	
}
