package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ��ѯ��������������Ϣ
 * 
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class QueryDepartmentRequest extends ParentRequest {
	// �ű�
	@XStreamAlias("SessType")
	private String sessType;
	// һ�����Ҵ���
	@XStreamAlias("DepartmentCode")
	private String departmentCode;

	public QueryDepartmentRequest() {
		// ��ʼ����ͬʱ���ý��״���Ϊͨ�����Ż�ȡ���߼�����Ϣ����
		this.tradeCode = TradeCode.QUERYDEPARTMENT.getCode();
	}

	public String getSessType() {
		return sessType;
	}

	public void setSessType(String sessType) {
		this.sessType = sessType;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	
	
	
}
