package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 查询二级科室请求信息
 *
 * @author wxd
 */
@XStreamAlias("Request")
public class QueryDepartmentRequest extends ParentRequest {
    // 科室类别
    @XStreamAlias("DepartmentType")
    private String departmentType;
    // 科室代码
    @XStreamAlias("DepartmentCode")
    private String departmentCode;
    // 一级科室代码
    @XStreamAlias("DepartmentGroupCode")
    private String departmentGroupCode;

    public QueryDepartmentRequest() {
        // 初始化的同时设置交易代码为通过卡号获取患者疾病信息编码
        this.tradeCode = TradeCode.QUERYDEPARTMENT.getCode();
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public String getDepartmentGroupCode() {
        return departmentGroupCode;
    }

    public void setDepartmentGroupCode(String departmentGroupCode) {
        this.departmentGroupCode = departmentGroupCode;
    }
}
