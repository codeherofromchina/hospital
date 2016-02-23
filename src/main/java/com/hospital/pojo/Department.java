package com.hospital.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * ҽԺ���Ҽ򵥶�����Ϣ
 * 
 * @author wxd
 *
 */
public class Department {
	// ���Ҵ���
	private String departmentCode;
	// ��������
	private String departmentName;
	// �������־ Y:�����飬���ж�������
	private String departmentGroup;

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

	public String getDepartmentGroup() {
		return departmentGroup;
	}

	public void setDepartmentGroup(String departmentGroup) {
		this.departmentGroup = departmentGroup;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
