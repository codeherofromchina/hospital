package com.hospital.service;

import java.util.List;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Doctor;
import com.hospital.pojo.request.QueryDoctorRequest;

/**
 * ҽ���ӿڲ����淶
 * @author wxd
 *
 */
public interface DoctorService {
	
	/**
	 * ��ȡҽ���б���Ϣ
	 * @param request
	 * @return
	 */
	public List<Doctor> queryDoctor(QueryDoctorRequest request) throws TradeErrorException;
	
	
}
