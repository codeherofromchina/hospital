package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 通过卡号获取患者基本信息 请求信息
 * 
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class GetPatInfoRequest extends ParentRequest {

	// 交易流水
	@XStreamAlias("TransactionId")
	protected String transactionId;
	// 终端编码
	@XStreamAlias("TerminalID")
	protected String terminalID = "";
	// 卡号
	@XStreamAlias("PatientCard")
	protected String patientCard = "";
	// 卡类型
	@XStreamAlias("CardType")
	protected String cardType = "";
	// 病人ID
	@XStreamAlias("PatientID")
	protected String patientID;
	// 联系电话
	@XStreamAlias("Phone")
	protected String phone;
	// 证件类型
	@XStreamAlias("IDCardType")
	protected String idCardType;
	// 身份证号码
	@XStreamAlias("IDNo")
	protected String idNo;
	// 姓名
	@XStreamAlias("PatientName")
	protected String patientName;

	public GetPatInfoRequest() {
		// 初始化的同时设置交易代码为通过卡号获取患者疾病信息编码
		this.tradeCode = TradeCode.GETPATINFO.getCode();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTerminalID() {
		return terminalID;
	}

	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}

	public String getPatientCard() {
		return patientCard;
	}

	public void setPatientCard(String patientCard) {
		this.patientCard = patientCard;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
}
