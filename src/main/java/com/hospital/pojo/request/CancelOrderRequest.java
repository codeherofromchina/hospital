package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 取消预约请求信息
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class CancelOrderRequest extends ParentRequest {
	//交易流水号
	@XStreamAlias("TransactionId")
	private String transactionId;
	// 预约单号
	@XStreamAlias("OrderCode")
	private String orderCode;
	
	public CancelOrderRequest(){
		this.tradeCode = TradeCode.CANCELORDER.getCode();
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
	
}
