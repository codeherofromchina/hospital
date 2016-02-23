package com.hospital.service;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Patient;
import com.hospital.pojo.request.GetPatInfoRequest;

/**
 * ���˷���ӿڹ淶
 * @author lenovo
 *
 */
public interface PatientService {
	
	/**
	 * ͨ��������Ϣ��ȡ������Ϣ
	 * 
	 * @return
	 * @throws TradeErrorException
	 */
	public Patient getPatInfo(GetPatInfoRequest request)
			throws TradeErrorException;
}
