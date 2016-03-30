package com.hospital.pojo.request;

import com.hospital.pojo.enum_.ClientType;
import com.hospital.pojo.enum_.TradeCode;
import com.hospital.tools.ObjectTransUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 预约挂号请求信息
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class BookServiceRequest {
	
	// 交易代码
	@XStreamAlias("TradeCode")
	protected String tradeCode;

	/**
	 * 默认设置为自助终端(ATM)
	 */
	// 预约机构
	@XStreamAlias("ExtOrgCode")
	protected String extOrgCode = ClientType.ATM.getCode();
	// 客户端类型
	@XStreamAlias("ClientType")
	protected String clientType = "ATM";

	// 医院唯一编号
	@XStreamAlias("HospitalId")
	protected String hospitalId = "";
	// 操作员代码
	@XStreamAlias("ExtUserID")
	protected String extUserID = "zz01";
	
	//交易流水号
	@XStreamAlias("TransactionId")
	private String transactionId = "";
	
	// 门诊排班项代码
	@XStreamAlias("ScheduleItemCode")
	private String scheduleItemCode ;
	// 锁定的队列号
	@XStreamAlias("LockQueueNo")
	private String lockQueueNo = "";
	// 卡号
	@XStreamAlias("CardNo")
	private String cardNo;
	// 卡类型
	@XStreamAlias("CardType")
	private String cardType = "02";
	// 证件类型
	@XStreamAlias("CredTypeCode")
	private String credTypeCode = "";
	// 证件号
	@XStreamAlias("IDCardNo")
	private String iDCardNo="";
	// 联系电话
	@XStreamAlias("TelePhoneNo")
	private String telePhoneNo="";
	// 手机
	@XStreamAlias("MobileNo")
	private String mobileNo = "";
	// 姓名
	@XStreamAlias("PatientName")
	private String patientName ="";
	// 性别代码
	@XStreamAlias("Gender")
	private String gender = "";
	// 住址
	@XStreamAlias("Address")
	private String address = "";
	// HIS系统的预约ID
	@XStreamAlias("HISApptID")
	private String hISApptID = "";
	// 挂号序号
	@XStreamAlias("SeqCode")
	private String seqCode = "";
	// 就诊时间段
	@XStreamAlias("AdmitRange")
	private String admitRange="";
	// 支付标记 （Y：已支付）
	@XStreamAlias("PayFlag")
	private String payFlag="";
	// 支付方式代码
	@XStreamAlias("PayModeCode")
	private String payModeCode="";
	// 银行代码
	@XStreamAlias("PayBankCode")
	private String payBankCode="";
	// 银行代码
	@XStreamAlias("PayCardNo")
	private String payCardNo="";
	// 个人支付费用
	@XStreamAlias("PayFee")
	private String payFee="";
	// 医保支付费用
	@XStreamAlias("PayInsuFee")
	private String payInsuFee="";
	// 医保分解返回串
	@XStreamAlias("PayInsuFeeStr")
	private String payInsuFeeStr = "";
	
	// 支付交易号
	@XStreamAlias("PayTradeNo")
	private String payTradeNo="";
	
	/**
	 * 支付交易信息串（应该包括银行代码、支付卡号、银行交易日期、银行交易流水号）
	 */
	@XStreamAlias("PayTradeStr")
	private String payTradeStr = "PAY_TRADE_CONTEXT_STRING";
	
	
	public BookServiceRequest(){
		tradeCode = TradeCode.BOOKSERVICE.getCode();
	}
	
	
	
	
	public String getExtUserID() {
		return extUserID;
	}




	public void setExtUserID(String extUserID) {
		this.extUserID = extUserID;
	}




	public String getTransactionId() {
		return transactionId;
	}




	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}




	public String getScheduleItemCode() {
		return scheduleItemCode;
	}




	public void setScheduleItemCode(String scheduleItemCode) {
		this.scheduleItemCode = scheduleItemCode;
	}




	public String getLockQueueNo() {
		return lockQueueNo;
	}




	public void setLockQueueNo(String lockQueueNo) {
		this.lockQueueNo = lockQueueNo;
	}




	public String getCardNo() {
		return cardNo;
	}




	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}




	public String getCardType() {
		return cardType;
	}




	public void setCardType(String cardType) {
		this.cardType = cardType;
	}




	public String getCredTypeCode() {
		return credTypeCode;
	}




	public void setCredTypeCode(String credTypeCode) {
		this.credTypeCode = credTypeCode;
	}




	public String getiDCardNo() {
		return iDCardNo;
	}




	public void setiDCardNo(String iDCardNo) {
		this.iDCardNo = iDCardNo;
	}




	public String getTelePhoneNo() {
		return telePhoneNo;
	}




	public void setTelePhoneNo(String telePhoneNo) {
		this.telePhoneNo = telePhoneNo;
	}




	public String getMobileNo() {
		return mobileNo;
	}




	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}




	public String getPatientName() {
		return patientName;
	}




	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String gethISApptID() {
		return hISApptID;
	}




	public void sethISApptID(String hISApptID) {
		this.hISApptID = hISApptID;
	}




	public String getSeqCode() {
		return seqCode;
	}




	public void setSeqCode(String seqCode) {
		this.seqCode = seqCode;
	}




	public String getAdmitRange() {
		return admitRange;
	}




	public void setAdmitRange(String admitRange) {
		this.admitRange = admitRange;
	}




	public String getPayFlag() {
		return payFlag;
	}




	public void setPayFlag(String payFlag) {
		this.payFlag = payFlag;
	}




	public String getPayModeCode() {
		return payModeCode;
	}




	public void setPayModeCode(String payModeCode) {
		this.payModeCode = payModeCode;
	}




	public String getPayBankCode() {
		return payBankCode;
	}




	public void setPayBankCode(String payBankCode) {
		this.payBankCode = payBankCode;
	}




	public String getPayCardNo() {
		return payCardNo;
	}




	public void setPayCardNo(String payCardNo) {
		this.payCardNo = payCardNo;
	}




	public String getPayFee() {
		return payFee;
	}




	public void setPayFee(String payFee) {
		this.payFee = payFee;
	}




	public String getPayInsuFee() {
		return payInsuFee;
	}




	public void setPayInsuFee(String payInsuFee) {
		this.payInsuFee = payInsuFee;
	}




	public String getPayInsuFeeStr() {
		return payInsuFeeStr;
	}




	public void setPayInsuFeeStr(String payInsuFeeStr) {
		this.payInsuFeeStr = payInsuFeeStr;
	}




	public String getPayTradeNo() {
		return payTradeNo;
	}




	public void setPayTradeNo(String payTradeNo) {
		this.payTradeNo = payTradeNo;
	}




	public String getPayTradeStr() {
		return payTradeStr;
	}




	public void setPayTradeStr(String payTradeStr) {
		this.payTradeStr = payTradeStr;
	}


	public static void main(String[] args) {
		
		BookServiceRequest request = new BookServiceRequest();
		request.setScheduleItemCode("setScheduleItemCode");
		request.setCardNo("setCardNo");
		request.setAdmitRange("setAdmitRange");
		
		System.out.println(BookServiceRequest.parseToXml(request));
	}


	/**
	 * 自身带转换为xml格式字符串方法
	 * 此类需要使用自身方法，因为此请求中有CDATA属性数据
	 * @param request
	 * @return
	 */
	public static String parseToXml(BookServiceRequest request){
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		return requestXML.replace("PAY_TRADE_CONTEXT_STRING", PAY_TRADE_CONTEXT_STRING);
	}
	
	private final static String PAY_TRADE_CONTEXT_STRING =  "<![CDATA[<Response><TradeCode></TradeCode><BankCode></BankCode><BankDate></BankDate><BankTradeNo></BankTradeNo><ResultCode></ResultCode><ResultContent></ResultContent><PayCardNo></PayCardNo><BankAccDate></BankAccDate><RevTranFlag></RevTranFlag><PatientID></PatientID><PayAmt></PayAmt><OrgHISTradeNo></OrgHISTradeNo><OrgPaySeqNo></OrgPaySeqNo></Response>]]>";
}
