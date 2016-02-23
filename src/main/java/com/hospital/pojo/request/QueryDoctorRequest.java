package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 查询医生列表 请求信息
 * 
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class QueryDoctorRequest extends ParentRequest {
	//@XStreamOmitField xstream忽略此字段生成xml的注解
	// 科室代码
	@XStreamAlias("DepartmentCode")
	private String departmentCode = "";
	
	public QueryDoctorRequest() {
		// 初始化的同时设置交易代码为通过卡号获取患者疾病信息编码
		this.tradeCode = TradeCode.QUERYDOCTOR.getCode();
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
}
