package com.hospital.tools;

import com.hospital.pojo.stub.RegistrationServiceSoap;

/**
 * 外部测试工厂类
 * @author lenovo
 *
 */
public class TestRegistrationService {
	public RegistrationServiceSoap getRegistrationServiceSoap(){
		return new RegistrationServiceSoapImpl();
	}
	
	
	public static class RegistrationServiceSoapImpl implements RegistrationServiceSoap{

		public String opRegistration(String input) {
			return null;
		}
	}
}
