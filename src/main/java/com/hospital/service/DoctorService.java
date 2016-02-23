package com.hospital.service;

import java.util.List;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Doctor;
import com.hospital.pojo.request.QueryDoctorRequest;

/**
 * 医生接口操作规范
 * @author wxd
 *
 */
public interface DoctorService {
	
	/**
	 * 获取医生列表信息
	 * @param request
	 * @return
	 */
	public List<Doctor> queryDoctor(QueryDoctorRequest request) throws TradeErrorException;
	
	
}
