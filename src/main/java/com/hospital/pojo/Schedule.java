package com.hospital.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * �Ű���Ϣ�򵥶���
 * 
 * @author wxd
 *
 */
public class Schedule {
	// �����Ű����¼��ʶ
	private String scheduleItemCode;
	// �����Ű����� (YYYY-MM-DD)
	private String serviceDate;
	// ������(1-7)
	private String weekDay;
	// �Ű�ʱ�δ���
	private String sessionCode;
	// �Ű�ʱ������
	private String sessionName;
	// ��ʼʱ�� (HH:MM)
	private String startTime;
	// ����ʱ�� (HH:MM)
	private String endTime;
	// ���Ҵ���
	private String departmentCode;
	// ��������
	private String departmentName;
	// ���Ҵ���
	private String clinicRoomCode;
	// ��������
	private String clinicRoomName;
	// ҽ������
	private String doctorCode;
	// ҽ������
	private String doctorName;
	// ҽ��ְ�ƴ���
	private String doctorTitleCode;
	// ҽ��ְ��
	private String doctorTitle;
	// ҽ��ר��
	private String doctorSpec;
	// ���Ｖ�����
	private String doctorSessTypeCode;
	// ���Ｖ��
	private String doctorSessType;
	// רҵ����
	private String serviceCode;
	// רҵ����
	private String serviceName;
	// ԤԼ�Һ��ܷ���
	private String fee;
	// �Һŷ�
	private String regFee;
	// ����
	private String checkupFee;
	// �����
	private String serviceFee;
	// ������
	private String otherFee;
	// ʣ�������
	private String availableNum;
	// �����ַ
	private String admitAddress;
	// ����ʱ�䷶Χ
	private String admitTimeRange;
	// ��ע
	private String note;
	public String getScheduleItemCode() {
		return scheduleItemCode;
	}
	public void setScheduleItemCode(String scheduleItemCode) {
		this.scheduleItemCode = scheduleItemCode;
	}
	public String getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}
	public String getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}
	public String getSessionCode() {
		return sessionCode;
	}
	public void setSessionCode(String sessionCode) {
		this.sessionCode = sessionCode;
	}
	public String getSessionName() {
		return sessionName;
	}
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getClinicRoomCode() {
		return clinicRoomCode;
	}
	public void setClinicRoomCode(String clinicRoomCode) {
		this.clinicRoomCode = clinicRoomCode;
	}
	public String getClinicRoomName() {
		return clinicRoomName;
	}
	public void setClinicRoomName(String clinicRoomName) {
		this.clinicRoomName = clinicRoomName;
	}
	public String getDoctorCode() {
		return doctorCode;
	}
	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorTitleCode() {
		return doctorTitleCode;
	}
	public void setDoctorTitleCode(String doctorTitleCode) {
		this.doctorTitleCode = doctorTitleCode;
	}
	public String getDoctorTitle() {
		return doctorTitle;
	}
	public void setDoctorTitle(String doctorTitle) {
		this.doctorTitle = doctorTitle;
	}
	public String getDoctorSpec() {
		return doctorSpec;
	}
	public void setDoctorSpec(String doctorSpec) {
		this.doctorSpec = doctorSpec;
	}
	public String getDoctorSessTypeCode() {
		return doctorSessTypeCode;
	}
	public void setDoctorSessTypeCode(String doctorSessTypeCode) {
		this.doctorSessTypeCode = doctorSessTypeCode;
	}
	public String getDoctorSessType() {
		return doctorSessType;
	}
	public void setDoctorSessType(String doctorSessType) {
		this.doctorSessType = doctorSessType;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getRegFee() {
		return regFee;
	}
	public void setRegFee(String regFee) {
		this.regFee = regFee;
	}
	public String getCheckupFee() {
		return checkupFee;
	}
	public void setCheckupFee(String checkupFee) {
		this.checkupFee = checkupFee;
	}
	public String getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}
	public String getOtherFee() {
		return otherFee;
	}
	public void setOtherFee(String otherFee) {
		this.otherFee = otherFee;
	}
	public String getAvailableNum() {
		return availableNum;
	}
	public void setAvailableNum(String availableNum) {
		this.availableNum = availableNum;
	}
	public String getAdmitAddress() {
		return admitAddress;
	}
	public void setAdmitAddress(String admitAddress) {
		this.admitAddress = admitAddress;
	}
	public String getAdmitTimeRange() {
		return admitTimeRange;
	}
	public void setAdmitTimeRange(String admitTimeRange) {
		this.admitTimeRange = admitTimeRange;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
