package com.hospital.pojo.request;

import com.hospital.pojo.enum_.ClientType;
import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 查询排班记录 请求信息
 * 
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class QueryAdmScheduleRequest {

	// 交易代码
	@XStreamAlias("TradeCode")
	protected String tradeCode;

	// 客户端类型
	@XStreamAlias("ClientType")
	protected String clientType = "";

	// 医院唯一编号
	@XStreamAlias("HospitalId")
	protected String hospitalId = "";

	// 预约机构
	@XStreamAlias("ExtOrgCode")
	protected String extOrgCode = "";
	// 操作员代码
	@XStreamAlias("ExtUserID")
	protected String extUserID = "wzyy01";
	// 开始日期 (YYYY-MM-DD)
	@XStreamAlias("StartDate")
	private String startDate;
	// 结束日期 (YYYY-MM-DD)
	@XStreamAlias("EndDate")
	private String endDate;

	// 科室代码
	@XStreamAlias("DepartmentCode")
	private String departmentCode;
	// 专业代码
	@XStreamAlias("ServiceCode")
	private String serviceCode = "";
	// 医生代码
	@XStreamAlias("DoctorCode")
	private String doctorCode = "";
	// 出诊时段代码 S：上午 X：下午 Y：夜晚
	@XStreamAlias("RBASSessionCode")
	private String rbasSessionCode = "";
	// 查询排班的标记 N:正常的排班 S:停诊的排班
	@XStreamAlias("StopScheduleFlag")
	private String stopScheduleFlag = "";
	@XStreamAlias("PatientID")
	private String patientID = "";
	@XStreamAlias("EssType")
	private String essType;

	public QueryAdmScheduleRequest() {
		// 初始化的同时设置交易代码为查询排班记录编码
		this.tradeCode = TradeCode.QUERYADMSCHEDULE.getCode();
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	public String getRbasSessionCode() {
		return rbasSessionCode;
	}

	public void setRbasSessionCode(String rbasSessionCode) {
		this.rbasSessionCode = rbasSessionCode;
	}

	public String getStopScheduleFlag() {
		return stopScheduleFlag;
	}

	public void setStopScheduleFlag(String stopScheduleFlag) {
		this.stopScheduleFlag = stopScheduleFlag;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getEssType() {
		return essType;
	}

	public void setEssType(String essType) {
		this.essType = essType;
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getExtOrgCode() {
		return extOrgCode;
	}

	public void setExtOrgCode(String extOrgCode) {
		this.extOrgCode = extOrgCode;
	}

	public String getExtUserID() {
		return extUserID;
	}

	public void setExtUserID(String extUserID) {
		this.extUserID = extUserID;
	}

}
