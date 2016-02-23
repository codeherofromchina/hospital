package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 查询排班记录 请求信息
 * 
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class QueryAdmScheduleRequest extends ParentRequest {
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
	private String serviceCode;
	// 医生代码
	@XStreamAlias("DoctorCode")
	private String doctorCode;
	// 出诊时段代码 S：上午 X：下午 Y：夜晚
	@XStreamAlias("RBASSessionCode")
	private String rbasSessionCode;
	// 查询排班的标记 N:正常的排班 S:停诊的排班
	@XStreamAlias("StopScheduleFlag")
	private String stopScheduleFlag;
	@XStreamAlias("PatientID")
	private String patientID;
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

}
