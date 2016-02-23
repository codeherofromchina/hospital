package com.hospital.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 病人簡單对象
 * 
 * @author wxd
 *
 */
public class Patient {
	// 病人ID
	private String patientID;
	// 病人姓名
	private String patientName;
	// 性别代码
	private String sexCode;
	// 性别
	private String sex;
	// 出生日期
	private String DOB;
	// 病案号
	private String documentID;
	// 家庭住址
	private String address;
	// 证件类型（代码）
	private String IDTypeCode;
	// 证件类型（描述）
	private String IDTypeDesc;
	// 证件号
	private String IDNo;
	// 医保标志（0：非医保，1：医保）
	private String YBFlag;
	// 病人类型描述
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
