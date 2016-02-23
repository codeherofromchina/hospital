package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ��ѯ����ԤԼ��¼������Ϣ
 * 
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class QueryOrderRequest extends ParentRequest {
	// ����
	@XStreamAlias("CardNo")
	public String cardNo;
	// ������
	@XStreamAlias("CardType")
	public String cardType;
	// ֤������
	@XStreamAlias("CredTypeCode")
	public String credTypeCode;
	// ֤������
	@XStreamAlias("IDCardNo")
	public String idCardNo;
	// ������������
	@XStreamAlias("PatientNo")
	public String patientNo;
	// ��ʼ���� (YYYY-MM-DD)
	@XStreamAlias("OrderApptStartDate")
	public String orderApptStartDate;
	// �������� (YYYY-MM-DD)
	@XStreamAlias("OrderApptEndDate")
	public String orderApptEndDate;
	// ��ѯ���ڱ�� AppDate:ԤԼ�������� AdmDate:ԤԼ�������� ����:��ѯû�й��ڵ�ԤԼ��¼������Ҫ��ʼ���ںͽ�������������
	@XStreamAlias("QueryDateFlag")
	public String queryDateFlag;
	// ��ѯ�û����ͣ� ORG����HIS�Ļ���(ֻ��ѯ������ԤԼ�ļ�¼) OWN������ HIS�����Բ�ѯԤԼ�˱�HISϵͳ�Ű��ԤԼ��¼
	@XStreamAlias("QueryUserType")
	public String queryUserType;
	// ԤԼ��״̬(normal ����; cancel �˺�)
	@XStreamAlias("OrderStatus")
	public String orderStatus;
	// ԤԼ����
	@XStreamAlias("OrderCode")
	public String orderCode;

	public QueryOrderRequest() {
		this.tradeCode = TradeCode.QUERYORDER.getCode();
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCredTypeCode() {
		return credTypeCode;
	}

	public void setCredTypeCode(String credTypeCode) {
		this.credTypeCode = credTypeCode;
	}

	public String getIdCardNo() {
		return idCardNo;
	}
	
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getOrderApptStartDate() {
		return orderApptStartDate;
	}

	public void setOrderApptStartDate(String orderApptStartDate) {
		this.orderApptStartDate = orderApptStartDate;
	}

	public String getOrderApptEndDate() {
		return orderApptEndDate;
	}

	public void setOrderApptEndDate(String orderApptEndDate) {
		this.orderApptEndDate = orderApptEndDate;
	}

	public String getQueryDateFlag() {
		return queryDateFlag;
	}

	public void setQueryDateFlag(String queryDateFlag) {
		this.queryDateFlag = queryDateFlag;
	}

	public String getQueryUserType() {
		return queryUserType;
	}

	public void setQueryUserType(String queryUserType) {
		this.queryUserType = queryUserType;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

}
