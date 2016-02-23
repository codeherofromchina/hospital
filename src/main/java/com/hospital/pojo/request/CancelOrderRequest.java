package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ȡ��ԤԼ������Ϣ
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class CancelOrderRequest extends ParentRequest {
	//������ˮ��
	@XStreamAlias("TransactionId")
	private String transactionId;
	// ԤԼ����
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
