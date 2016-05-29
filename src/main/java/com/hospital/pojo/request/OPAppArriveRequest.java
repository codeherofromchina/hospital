package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 病人取号确认 接口请求信息
 * 
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class OPAppArriveRequest {

	// 交易代码
	@XStreamAlias("TradeCode")
	public String tradeCode;
	// 医院唯一编号
	@XStreamAlias("HospitalId")
	public String hospitalId;
	// 预约时的交易流水号
	@XStreamAlias("TransactionId")
	public String transactionId;
	// 预约单号
	@XStreamAlias("OrderCode")
	public String orderCode;
	// 操作员工号
	@XStreamAlias("ExtUserID")
	public String extUserID = "wzyy01";
	// 取号日期(YYYY-MM-DD)
	@XStreamAlias("PayDate")
	public String payDate;
	// 取号时间(HH:MM)
	@XStreamAlias("PayTime")
	public String payTime;
	// 支付方式代码
	@XStreamAlias("PayModeCode")
	public String payModeCode;
	// 支付交易信息串（应该包括银行代码、支付卡号、银行交易日期、银行交易流水号）
	@XStreamAlias("PayTradeStr")
	public String payTradeStr;
	// 医保挂号相关信息
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
