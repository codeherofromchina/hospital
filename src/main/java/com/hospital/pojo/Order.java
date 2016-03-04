package com.hospital.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 病人预约单号信息简单对象
 * 
 * @author wxd
 *
 */
public class Order {
	// 预约单号
	public String orderCode;
	// 申请日期(YYYY-MM-DD)
	public String orderApptDate;
	// 预约单状态(normal 正常; cancel 退号)
	public String orderStatus;
	// 预约单申请人（患者姓名）
	public String orderApptUser;
	// 病人主索引号（病人ID）
	public String patientNo;
	// 预约就诊日期(YYYY-MM-DD)
	public String admitDate;
	// 就诊科室
	public String department;
	// 医生
	public String doctor;
	// 医生职称
	public String doctorTitle;
	// 总费用
	public String regFee;
	// 就诊序号
	public String seqCode;
	// 候诊地点
	public String admitAddress;
	// 就诊时段
	public String sessionName;
	// 预约单内容
	public String orderContent;
	// 候诊时间
	public String admitRange;
	// 联系电话
	public String telePhoneNo;
	// 手机
	public String mobileNo;
	// 允许退号标志 Y：允许退号
	public String allowRefundFlag;
	// 支付状态 P:已支付 TB：未支付 R：已退费
	public String payFlag;
	// 医院
	public String hospitalName;
	// 专业
	public String serviceName;
	// 交易流水号
	public String transactionId;
	// 预约号
	public String appID;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderApptDate() {
		return orderApptDate;
	}

	public void setOrderApptDate(String orderApptDate) {
		this.orderApptDate = orderApptDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderApptUser() {
		return orderApptUser;
	}

	public void setOrderApptUser(String orderApptUser) {
		this.orderApptUser = orderApptUser;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getAdmitDate() {
		return admitDate;
	}

	public void setAdmitDate(String admitDate) {
		this.admitDate = admitDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getDoctorTitle() {
		return doctorTitle;
	}

	public void setDoctorTitle(String doctorTitle) {
		this.doctorTitle = doctorTitle;
	}

	public String getRegFee() {
		return regFee;
	}

	public void setRegFee(String regFee) {
		this.regFee = regFee;
	}

	public String getSeqCode() {
		return seqCode;
	}

	public void setSeqCode(String seqCode) {
		this.seqCode = seqCode;
	}

	public String getAdmitAddress() {
		return admitAddress;
	}

	public void setAdmitAddress(String admitAddress) {
		this.admitAddress = admitAddress;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public String getOrderContent() {
		return orderContent;
	}

	public void setOrderContent(String orderContent) {
		this.orderContent = orderContent;
	}

	public String getAdmitRange() {
		return admitRange;
	}

	public void setAdmitRange(String admitRange) {
		this.admitRange = admitRange;
	}

	public String getTelePhoneNo() {
		return telePhoneNo;
	}

	public void setTelePhoneNo(String telePhoneNo) {
		this.telePhoneNo = telePhoneNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAllowRefundFlag() {
		return allowRefundFlag;
	}

	public void setAllowRefundFlag(String allowRefundFlag) {
		this.allowRefundFlag = allowRefundFlag;
	}

	public String getPayFlag() {
		return payFlag;
	}

	public void setPayFlag(String payFlag) {
		this.payFlag = payFlag;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
