package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 查询二级科室请求信息
 * 
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class QueryDepartmentRequest extends ParentRequest {
	// 号别
	@XStreamAlias("SessType")
	private String sessType;
	// 一级科室代码
	@XStreamAlias("DepartmentCode")
	private String departmentCode;

	public QueryDepartmentRequest() {
		// 初始化的同时设置交易代码为通过卡号获取患者疾病信息编码
		this.tradeCode = TradeCode.QUERYDEPARTMENT.getCode();
	}

	public String getSessType() {
		return sessType;
	}

	public void setSessType(String sessType) {
		this.sessType = sessType;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	
	
	
}
