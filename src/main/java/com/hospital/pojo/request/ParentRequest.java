package com.hospital.pojo.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * �������ݹ��в���
 * 
 * @author wxd
 *
 */
public abstract class ParentRequest {
	// ���״���
	@XStreamAlias("TradeCode")
	protected String tradeCode;

	// ԤԼ����
	@XStreamAlias("ExtOrgCode")
	protected String extOrgCode = "";
	// �ͻ�������
	@XStreamAlias("ClientType")
	protected String clientType = "";

	// ҽԺΨһ���
	@XStreamAlias("HospitalId")
	protected String hospitalId = "";
	// ����Ա����
	@XStreamAlias("ExtUserID")
	protected String extUserID = "";

	public String getTradeCode() {
		return tradeCode;
	}

	public String getExtOrgCode() {
		return extOrgCode;
	}

	public void setExtOrgCode(String extOrgCode) {
		this.extOrgCode = extOrgCode;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getExtUserID() {
		return extUserID;
	}

	public void setExtUserID(String extUserID) {
		this.extUserID = extUserID;
	}

}
