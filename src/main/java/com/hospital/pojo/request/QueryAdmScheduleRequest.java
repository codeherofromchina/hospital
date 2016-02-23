package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ��ѯ�Ű��¼ ������Ϣ
 * 
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class QueryAdmScheduleRequest extends ParentRequest {
	// ��ʼ���� (YYYY-MM-DD)
	@XStreamAlias("StartDate")
	private String startDate;
	// �������� (YYYY-MM-DD)
	@XStreamAlias("EndDate")
	private String endDate;

	// ���Ҵ���
	@XStreamAlias("DepartmentCode")
	private String departmentCode;
	// רҵ����
	@XStreamAlias("ServiceCode")
	private String serviceCode;
	// ҽ������
	@XStreamAlias("DoctorCode")
	private String doctorCode;
	// ����ʱ�δ��� S������ X������ Y��ҹ��
	@XStreamAlias("RBASSessionCode")
	private String rbasSessionCode;
	// ��ѯ�Ű�ı�� N:�������Ű� S:ͣ����Ű�
	@XStreamAlias("StopScheduleFlag")
	private String stopScheduleFlag;
	@XStreamAlias("PatientID")
	private String patientID;
	@XStreamAlias("EssType")
	private String essType;

	public QueryAdmScheduleRequest() {
		// ��ʼ����ͬʱ���ý��״���Ϊ��ѯ�Ű��¼����
		this.tradeCode = TradeCode.QUERYADMSCHEDULE.getCode();
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	public String getRbasSessionCode() {
		return rbasSessionCode;
	}
	
	public void setRbasSessionCode(String rbasSessionCode) {
		this.rbasSessionCode = rbasSessionCode;
	}

	public String getStopScheduleFlag() {
		return stopScheduleFlag;
	}

	public void setStopScheduleFlag(String stopScheduleFlag) {
		this.stopScheduleFlag = stopScheduleFlag;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getEssType() {
		return essType;
	}

	public void setEssType(String essType) {
		this.essType = essType;
	}

}
