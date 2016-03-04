package com.hospital.pojo.enum_;

/**
 * 请求交易码枚举
 * @author wxd
 *
 */
public enum TradeCode {
	GETPATINFO("3300"), // 通过卡号获取患者基本信息交易码枚举
	QUWEYDEPARTMENTGROUP("1014"), // 查询一级科室列表交易码枚举
	QUERYDEPARTMENT("1012"), // 二级科室列表交易码枚举
	QUERYDOCTOR("1013"), // 医生列表交易码枚举
	QUERYADMSCHEDULE("1004"), // 查询排班记录交易码枚举
	BOOKSERVICE("1000"), //预约挂号交易码枚举
	QUERYORDER("1005"), // 查询患者预约记录交易码枚举
	OPAPPARRIVE("2001"), // 病人取号确认交易码枚举
	CANCELORDER("1001"); // 取消预约交易码枚举
	
	private String tc;
	TradeCode(String tradeCode){
		this.tc = tradeCode;
	}
	
	public String getCode(){
		return this.tc;
	}
	
}
