package com.hospital.pojo.enum_;

/**
 * ��������ö��
 * @author wxd
 *
 */
public enum TradeCode {
	GETPATINFO("3300"), // ͨ�����Ż�ȡ���߻�����Ϣ������ö��
	QUWEYDEPARTMENTGROUP("1014"), // ��ѯһ�������б�����ö��
	QUERYDEPARTMENT("1012"), // ���������б�����ö��
	QUERYDOCTOR("1013"), // ҽ���б�����ö��
	QUERYADMSCHEDULE("1004"), // ��ѯ�Ű��¼������ö��
	BOOKSERVICE("1000"), //ԤԼ�ҺŽ�����ö��
	QUERYORDER("1005"), // ��ѯ����ԤԼ��¼������ö��
	OPAPPARRIVE("2001"), // ����ȡ��ȷ�Ͻ�����ö��
	CANCELORDER("1001"); // ȡ��ԤԼ������ö��
	
	private String tc;
	TradeCode(String tradeCode){
		this.tc = tradeCode;
	}
	
	public String getCode(){
		return this.tc;
	}
	
}
