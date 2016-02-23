package com.hospital.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * ���˺��ζ���
 * 
 * @author wxd
 *
 */
public class Patient {
	// ����ID
	private String patientID;
	// ��������
	private String patientName;
	// �Ա����
	private String sexCode;
	// �Ա�
	private String sex;
	// ��������
	private String DOB;
	// ������
	private String documentID;
	// ��ͥסַ
	private String address;
	// ֤�����ͣ����룩
	private String IDTypeCode;
	// ֤�����ͣ�������
	private String IDTypeDesc;
	// ֤����
	private String IDNo;
	// ҽ����־��0����ҽ����1��ҽ����
	private String YBFlag;
	// ������������
	private String patType;

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getSexCode() {
		return sexCode;
	}

	public void setSexCode(String sexCode) {
		this.sexCode = sexCode;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getDocumentID() {
		return documentID;
	}

	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIDTypeCode() {
		return IDTypeCode;
	}

	public void setIDTypeCode(String iDTypeCode) {
		IDTypeCode = iDTypeCode;
	}

	public void setIDTypeDesc(String iDTypeDesc) {
		IDTypeDesc = iDTypeDesc;
	}

	public String getIDTypeDesc() {
		return IDTypeDesc;
	}

	public String getIDNo() {
		return IDNo;
	}

	public void setIDNo(String iDNo) {
		IDNo = iDNo;
	}

	public String getYBFlag() {
		return YBFlag;
	}

	public void setYBFlag(String yBFlag) {
		YBFlag = yBFlag;
	}

	public String getPatType() {
		return patType;
	}

	public void setPatType(String patType) {
		this.patType = patType;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
