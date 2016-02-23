package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ��ѯһ�������б��������ݶ���
 * 
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class QueryDepartmentGroupRequest extends ParentRequest {
	public QueryDepartmentGroupRequest() {
		// ��ʼ����ͬʱ���ý��״���Ϊ��ѯһ�������б����
		this.tradeCode = TradeCode.QUWEYDEPARTMENTGROUP.getCode();
	}
}
