package com.hospital.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hospital.tools.CommUtil;

/**
 * 医院科室简单对象信息
 * 
 * @author wxd
 *
 */
public class Department implements Comparable<Department>{
	// 科室代码
	private String departmentCode;
	// 科室名称
	private String departmentName;
	// 科室组标志 Y:科室组，具有二级科室
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

	public int compareTo(Department o) {
		if(o == null){
			return -1;
		}
		return CommUtil.compareChineseStr(this.getDepartmentName(), o.getDepartmentName());
	}
}
