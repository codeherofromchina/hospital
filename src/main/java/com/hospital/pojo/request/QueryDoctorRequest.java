package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ��ѯҽ���б� ������Ϣ
 * 
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class QueryDoctorRequest extends ParentRequest {
	//@XStreamOmitField xstream���Դ��ֶ�����xml��ע��
	// ���Ҵ���
	@XStreamAlias("DepartmentCode")
	private String departmentCode = "";
	
	public QueryDoctorRequest() {
		// ��ʼ����ͬʱ���ý��״���Ϊͨ�����Ż�ȡ���߼�����Ϣ����
		this.tradeCode = TradeCode.QUERYDOCTOR.getCode();
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
}
