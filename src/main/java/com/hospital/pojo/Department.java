package com.hospital.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hospital.tools.CommUtil;

/**
 * 医院科室简单对象信息
 *
 * @author wxd
 */
public class Department implements Comparable<Department> {
    // 科室代码
    private String departmentCode;
    // 科室名称
    private String departmentName;
    // 科室组标志 Y:科室组，具有二级科室
    private String departmentGroup;
    // 上级科室代码，没有填-1
    private String parentId;
    // 科室简介
    private String description;
    // 科室地理位置
    private String departmentAddress;
    // 挂号年龄限制
    private String departmentAgeLimit;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentAgeLimit() {
        return departmentAgeLimit;
    }

    public void setDepartmentAgeLimit(String departmentAgeLimit) {
        this.departmentAgeLimit = departmentAgeLimit;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public int compareTo(Department o) {
        if (o == null) {
            return -1;
        }
        return CommUtil.compareChineseStr(this.getDepartmentName(), o.getDepartmentName());
    }
}
