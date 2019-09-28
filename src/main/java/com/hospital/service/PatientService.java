package com.hospital.service;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Patient;

/**
 * 病人服务接口规范
 * @author lenovo
 *
 */
public interface PatientService {
	
	/**
	 * 通过就诊卡号获取病人信息
	 * 
	 * @return
	 * @throws TradeErrorException
	 */
	Patient getPatInfoByCardNo(String cardNo)
			throws TradeErrorException;
}
