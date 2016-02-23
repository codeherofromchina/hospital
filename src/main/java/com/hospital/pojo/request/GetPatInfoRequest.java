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

	
	
}
