package com.hospital.service.remoteImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Order;
import com.hospital.pojo.request.BookServiceRequest;
import com.hospital.pojo.request.CancelOrderRequest;
import com.hospital.pojo.request.OPAppArriveRequest;
import com.hospital.pojo.request.QueryOrderRequest;
import com.hospital.pojo.stub.RegistrationServiceSoap;
import com.hospital.service.OrderService;
import com.hospital.tools.DateUtil;
import com.hospital.tools.ObjectTransUtil;
import com.hospital.tools.ServiceHelper;

/**
 * 订单挂号信息服务实现类
 * @author wxd
 *
 */
@Service("defaultOrderService")
public class OrderServiceImpl implements OrderService{
	private final Logger logger = Logger.getLogger(getClass());
	@Resource(name = "registrationServiceSoap")
	private RegistrationServiceSoap registrationService;
	
	
	/**
	 * 根据就诊卡号查询病人预约挂号信息
	 * @param cardNo 就诊卡号
	 * @param startDate 记录开始时间
	 * @param endDate	记录结束时间
	 * @return
	 * @throws TradeErrorException
	 */
	@Override
	public List<Order> queryOrderByCardNo(String cardNo, Date startDate, Date endDate) throws TradeErrorException {
		QueryOrderRequest request = new QueryOrderRequest();
		
		request.setCardNo(cardNo);
		request.setCardType("02");
		request.setExtUserID("wzyy01");
		request.setOrderApptStartDate(DateUtil.formatToShortString(startDate));
		request.setOrderApptEndDate(DateUtil.formatToShortString(endDate));
		
		return queryOrder(request);
	}
	
	/**
	 * 取消已经预约挂的单号
	 * @param orderCode 已经预约的单号
	 */
	@Override
	public boolean cancelOrder(String orderCode) throws TradeErrorException {
		CancelOrderRequest request = new CancelOrderRequest();
		request.setOrderCode(orderCode);
		
		return cancelOrder(request);
		
	}
	
	
	/**
	 * 根据身份证号查询病人预约挂号信息
	 * @param idCard 身份证号
	 * @param startDate 记录开始时间
	 * @param endDate	记录结束时间
	 * @return
	 * @throws TradeErrorException
	 */
	@Override
	public List<Order> queryOrderByIdCard(String idCard, Date startDate, Date endDate) throws TradeErrorException {
		
		QueryOrderRequest request = new QueryOrderRequest();
		
		request.setIdCardNo(idCard);
		request.setExtUserID("wzyy01");
		request.setOrderApptStartDate(DateUtil.formatToShortString(startDate));
		request.setOrderApptEndDate(DateUtil.formatToShortString(endDate));
		request.setQueryDateFlag("ORG");
		
		return queryOrder(request);
	}
	
	/**
	 * 查询患者预约记录
	 */
	public List<Order> queryOrder(QueryOrderRequest request) throws TradeErrorException {
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		String orderListXml = registrationService.opRegistration(requestXML);
		if(logger.isInfoEnabled()){
			logger.info("request msg is ["+requestXML+"] and response msg is ["+orderListXml+"]");
		}
		return ServiceHelper.parseXmlToOrders(orderListXml);
	}

	/**
	 * 病人取号确认
	 */
	public Order opAppArrive(OPAppArriveRequest request) throws TradeErrorException {
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		String orderXml = registrationService.opRegistration(requestXML);
		if(logger.isInfoEnabled()){
			logger.info("request msg is ["+requestXML+"] and response msg is ["+orderXml+"]");
		}
		return ServiceHelper.parseXmlToOrder(orderXml);
	}
	
	/**
	 * 有卡预约实现
	 * 根据给定信息预约挂号，并返回结果
	 */
	@Override
	public Order bookService(String scheduleItemCode, String cardNo,
			String admitRange) throws TradeErrorException {
		BookServiceRequest request = new BookServiceRequest();
		request.setScheduleItemCode(scheduleItemCode);
		request.setCardNo(cardNo);
		if(StringUtils.isNotEmpty(admitRange)){
			request.setAdmitRange(admitRange);
		}
		
		return bookService(request);
	}
	
	/**
	 * 无卡预约实现
	 * 根据给定信息预约挂号，并返回结果
	 */
	@Override
	public Order bookService(String scheduleItemCode, String admitRange,
			String iDCardNo, String patientName, String mobileNo, String gender)
			throws TradeErrorException {
		BookServiceRequest request = new BookServiceRequest();
		request.setScheduleItemCode(scheduleItemCode);
		if(StringUtils.isNotEmpty(admitRange)){
			request.setAdmitRange(admitRange);
		}
		request.setiDCardNo(iDCardNo);
		request.setPatientName(patientName);
		request.setMobileNo(mobileNo);
		request.setGender(gender);
		request.setCardType("");
		
		return bookService(request);
	}
	
	
	/**
	 * 预约挂号
	 * @param request
	 * @return
	 * @throws TradeErrorException
	 */
	private Order bookService(BookServiceRequest request) throws TradeErrorException{
		String requestXML = BookServiceRequest.parseToXml(request);
		String orderXml = registrationService.opRegistration(requestXML);
		if(logger.isInfoEnabled()){
			logger.info("request msg is ["+requestXML+"] and response msg is ["+orderXml+"]");
		}
		return ServiceHelper.parseXmlToOrder(orderXml);
	}
	
	
	/**
	 * 取消预约订单请求
	 * @param request
	 * @return
	 * @throws TradeErrorException
	 */
	private boolean cancelOrder(CancelOrderRequest request) throws TradeErrorException{
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		String resultXml = registrationService.opRegistration(requestXML);
		if(logger.isInfoEnabled()){
			logger.info("request msg is ["+requestXML+"] and response msg is ["+resultXml+"]");
		}
		
		return ServiceHelper.isSuccessTradeResult(resultXml);
	}
}
