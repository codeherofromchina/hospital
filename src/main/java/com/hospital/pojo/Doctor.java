package com.hospital.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * ҽ���򵥶���
 * 
 * @author wxd
 *
 */
public class Doctor {
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
