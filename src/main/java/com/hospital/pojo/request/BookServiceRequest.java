package com.hospital.pojo.request;

import com.hospital.pojo.enum_.TradeCode;
import com.hospital.tools.ObjectTransUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 预约挂号请求信息
 * @author wxd
 *
 */
@XStreamAlias("Request")
public class BookServiceRequest extends ParentRequest{
	
	//交易流水号
	@XStreamAlias("TransactionId")
	private String transactionId;
	
	// 门诊排班项代码
	@XStreamAlias("ScheduleItemCode")
	private String string ;
	// 锁定的队列号
	@XStreamAlias("LockQueueNo")
	private String lockQueueNo;
	// 卡号
	@XStreamAlias("CardNo")
	private String cardNo;
	// 卡类型
	@XStreamAlias("CardType")
	private String cardType;
	// 证件类型
	@XStreamAlias("CredTypeCode")
	private String credTypeCode;
	// 证件号
	@XStreamAlias("IDCardNo")
	private String iDCardNo;
	// 联系电话
	@XStreamAlias("TelePhoneNo")
	private String telePhoneNo;
	// 手机
	@XStreamAlias("MobileNo")
	private String mobileNo;
	// 姓名
	@XStreamAlias("PatientName")
	private String patientName;
	// 性别代码
	@XStreamAlias("Gender")
	private String gender;
	// 住址
	@XStreamAlias("Address")
	private String address;
	// HIS系统的预约ID
	@XStreamAlias("HISApptID")
	private String hISApptID;
	// 挂号序号
	@XStreamAlias("SeqCode")
	private String seqCode;
	// 就诊时间段
	@XStreamAlias("AdmitRange")
	private String admitRange;
	// 支付标记 （Y：已支付）
	@XStreamAlias("PayFlag")
	private String payFlag;
	// 支付方式代码
	@XStreamAlias("PayModeCode")
	private String payModeCode;
	// 银行代码
	@XStreamAlias("PayBankCode")
	private String payBankCode;
	// 银行代码
	@XStreamAlias("PayCardNo")
	private String payCardNo;
	// 个人支付费用
	@XStreamAlias("PayFee")
	private String payFee;
	// 医保支付费用
	@XStreamAlias("PayInsuFee")
	private String payInsuFee;
	// 医保分解返回串
	@XStreamAlias("PayInsuFeeStr")
	private String payInsuFeeStr;
	
	// 支付交易号
	@XStreamAlias("PayTradeNo")
	private String payTradeNo;
	
	/**
	 * 支付交易信息串（应该包括银行代码、支付卡号、银行交易日期、银行交易流水号）
	 */
	@XStreamAlias("PayTradeStr")
	private String payTradeStr = "PAY_TRADE_CONTEXT_STRING";
	
	
	public BookServiceRequest(){
		tradeCode = TradeCode.BOOKSERVICE.getCode();
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
