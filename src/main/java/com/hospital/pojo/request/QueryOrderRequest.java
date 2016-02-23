package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 查询患者预约记录请求信息
 * 
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class QueryOrderRequest extends ParentRequest {
	// 卡号
	@XStreamAlias("CardNo")
	public String cardNo;
	// 卡类型
	@XStreamAlias("CardType")
	public String cardType;
	// 证件类型
	@XStreamAlias("CredTypeCode")
	public String credTypeCode;
	// 证件号码
	@XStreamAlias("IDCardNo")
	public String idCardNo;
	// 病人主索引号
	@XStreamAlias("PatientNo")
	public String patientNo;
	// 开始日期 (YYYY-MM-DD)
	@XStreamAlias("OrderApptStartDate")
	public String orderApptStartDate;
	// 结束日期 (YYYY-MM-DD)
	@XStreamAlias("OrderApptEndDate")
	public String orderApptEndDate;
	// 查询日期标记 AppDate:预约申请日期 AdmDate:预约就诊日期 “”:查询没有过期的预约记录，不需要开始日期和结束日期条件。
	@XStreamAlias("QueryDateFlag")
	public String queryDateFlag;
	// 查询用户类型： ORG：非HIS的机构(只查询本机构预约的记录) OWN：个人 HIS：可以查询预约了本HIS系统排班的预约记录
	@XStreamAlias("QueryUserType")
	public String queryUserType;
	// 预约单状态(normal 正常; cancel 退号)
	@XStreamAlias("OrderStatus")
	public String orderStatus;
	// 预约单号
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
