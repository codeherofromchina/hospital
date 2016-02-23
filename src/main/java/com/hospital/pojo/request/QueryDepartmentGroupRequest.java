package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 查询一级科室列表请求数据对象
 * 
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class QueryDepartmentGroupRequest extends ParentRequest {
	public QueryDepartmentGroupRequest() {
		// 初始化的同时设置交易代码为查询一级科室列表编码
		this.tradeCode = TradeCode.QUWEYDEPARTMENTGROUP.getCode();
	}
}
