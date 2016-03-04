package com.hospital.service;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Patient;
import com.hospital.pojo.request.GetPatInfoRequest;

/**
 * 病人服务接口规范
 * @author lenovo
 *
 */
public interface PatientService {
	
	/**
	 * 通过请求信息获取病人信息
	 * 
	 * @return
	 * @throws TradeErrorException
	 */
	public Patient getPatInfo(GetPatInfoRequest request)
			throws TradeErrorException;
}
