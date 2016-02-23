package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ����ȡ��ȷ�� �ӿ�������Ϣ
 * 
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class OPAppArriveRequest {

	// ���״���
	@XStreamAlias("TradeCode")
	public String tradeCode;
	// ҽԺΨһ���
	@XStreamAlias("HospitalId")
	public String hospitalId;
	// ԤԼʱ�Ľ�����ˮ��
	@XStreamAlias("TransactionId")
	public String transactionId;
	// ԤԼ����
	@XStreamAlias("OrderCode")
	public String orderCode;
	// ����Ա����
	@XStreamAlias("ExtUserID")
	public String extUserID;
	// ȡ������(YYYY-MM-DD)
	@XStreamAlias("PayDate")
	public String payDate;
	// ȡ��ʱ��(HH:MM)
	@XStreamAlias("PayTime")
	public String payTime;
	// ֧����ʽ����
	@XStreamAlias("PayModeCode")
	public String payModeCode;
	// ֧��������Ϣ����Ӧ�ð������д��롢֧�����š����н������ڡ����н�����ˮ�ţ�
	@XStreamAlias("PayTradeStr")
	public String payTradeStr;
	// ҽ���Һ������Ϣ
	@XStreamAlias("PayInsuFeeStr")
	public String payInsuFeeStr;

	public OPAppArriveRequest() {
		this.tradeCode = TradeCode.OPAPPARRIVE.getCode();
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getExtUserID() {
		return extUserID;
	}

	public void setExtUserID(String extUserID) {
		this.extUserID = extUserID;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getPayModeCode() {
		return payModeCode;
	}

	public void setPayModeCode(String payModeCode) {
		this.payModeCode = payModeCode;
	}

	public String getPayTradeStr() {
		return payTradeStr;
	}

	public void setPayTradeStr(String payTradeStr) {
		this.payTradeStr = payTradeStr;
	}

	public String getPayInsuFeeStr() {
		return payInsuFeeStr;
	}

	public void setPayInsuFeeStr(String payInsuFeeStr) {
		this.payInsuFeeStr = payInsuFeeStr;
	}

}
