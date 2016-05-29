package com.hospital.pojo.request;

import com.hospital.pojo.enum_.ClientType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 请求数据共有参数
 * 
 * @author wxd
 *
 */
public abstract class ParentRequest {
	// 交易代码
	@XStreamAlias("TradeCode")
	protected String tradeCode;

	/**
	 * 默认设置为自助终端(ATM)
	 */
	// 预约机构
	@XStreamAlias("ExtOrgCode")
	protected String extOrgCode = ClientType.ATM.getCode();
	// 客户端类型
	@XStreamAlias("ClientType")
	protected String clientType = "";

	// 医院唯一编号
	@XStreamAlias("HospitalId")
	protected String hospitalId = "";
	// 操作员代码
	@XStreamAlias("ExtUserID")
	protected String extUserID = "wzyy01";

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
