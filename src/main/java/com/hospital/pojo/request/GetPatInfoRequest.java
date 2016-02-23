package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ͨ�����Ż�ȡ���߻�����Ϣ ������Ϣ
 * 
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class GetPatInfoRequest extends ParentRequest {

	// ������ˮ
	@XStreamAlias("TransactionId")
	protected String transactionId;
	// �ն˱���
	@XStreamAlias("TerminalID")
	protected String terminalID = "";
	// ����
	@XStreamAlias("PatientCard")
	protected String patientCard = "";
	// ������
	@XStreamAlias("CardType")
	protected String cardType = "";
	// ����ID
	@XStreamAlias("PatientID")
	protected String patientID;

	public GetPatInfoRequest() {
		// ��ʼ����ͬʱ���ý��״���Ϊͨ�����Ż�ȡ���߼�����Ϣ����
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
