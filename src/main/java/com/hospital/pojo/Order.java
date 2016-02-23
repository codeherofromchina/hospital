package com.hospital.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * ����ԤԼ������Ϣ�򵥶���
 * 
 * @author wxd
 *
 */
public class Order {
	// ԤԼ����
	public String orderCode;
	// ��������(YYYY-MM-DD)
	public String orderApptDate;
	// ԤԼ��״̬(normal ����; cancel �˺�)
	public String orderStatus;
	// ԤԼ�������ˣ�����������
	public String orderApptUser;
	// �����������ţ�����ID��
	public String patientNo;
	// ԤԼ��������(YYYY-MM-DD)
	public String admitDate;
	// �������
	public String department;
	// ҽ��
	public String doctor;
	// ҽ��ְ��
	public String doctorTitle;
	// �ܷ���
	public String regFee;
	// �������
	public String seqCode;
	// ����ص�
	public String admitAddress;
	// ����ʱ��
	public String sessionName;
	// ԤԼ������
	public String orderContent;
	// ����ʱ��
	public String admitRange;
	// ��ϵ�绰
	public String telePhoneNo;
	// �ֻ�
	public String mobileNo;
	// �����˺ű�־ Y�������˺�
	public String allowRefundFlag;
	// ֧��״̬ P:��֧�� TB��δ֧�� R�����˷�
	public String payFlag;
	// ҽԺ
	public String hospitalName;
	// רҵ
	public String serviceName;
	// ������ˮ��
	public String transactionId;
	// ԤԼ��
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
