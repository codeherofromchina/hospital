package com.hospital.service.remoteImpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Order;
import com.hospital.pojo.request.BookServiceRequest;
import com.hospital.pojo.request.OPAppArriveRequest;
import com.hospital.pojo.request.QueryOrderRequest;
import com.hospital.pojo.stub.RegistrationServiceSoap;
import com.hospital.service.OrderService;
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
	 * 根据给定信息预约挂号，并返回结果
	 */
	@Override
	public Order bookService(String scheduleItemCode, String cardNo,
			String admitRange) throws TradeErrorException {
		BookServiceRequest request = new BookServiceRequest();
		request.setScheduleItemCode(scheduleItemCode);
		request.setCardNo(cardNo);
		request.setAdmitRange(admitRange);
		
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
}
