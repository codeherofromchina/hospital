package com.hospital.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 医生简单对象
 * 
 * @author wxd
 *
 */
public class Doctor implements Comparable<Doctor>{
	// 医生代码
	private String doctorCode;
	// 医生名称
	private String doctorName;
	// 所在科室代码
	private String departmentCode;
	// 所在科室名称
	private String departmentName;
	// 医生职称代码
	private String doctorTitleCode;
	// 医生职称
	private String doctorTitle;
	// 医生简介
	private String description;
	// 出诊级别
	private String doctorSessType;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDoctorSessType() {
		return doctorSessType;
	}

	public void setDoctorSessType(String doctorSessType) {
		this.doctorSessType = doctorSessType;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}


	@Override
	public int compareTo(Doctor o) {
		if(o==null){
			return -1;
		}
		return this.getDoctorCode().compareTo(o.getDoctorCode());
	}

}
