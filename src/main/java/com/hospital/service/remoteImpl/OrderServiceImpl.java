package com.hospital.service.remoteImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Order;
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
@Service
public class OrderServiceImpl implements OrderService{
	
	@Resource(name = "registrationServiceSoap")
	private RegistrationServiceSoap registrationService;
	
	/**
	 * 查询患者预约记录
	 */
	public List<Order> queryOrder(QueryOrderRequest request) throws TradeErrorException {
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		String orderListXml = registrationService.opRegistration(requestXML);

		return ServiceHelper.parseXmlToOrders(orderListXml);
	}

	/**
	 * 病人取号确认
	 */
	public Order opAppArrive(OPAppArriveRequest request) throws TradeErrorException {
		String requestXML = ObjectTransUtil.beanToXMLString(request);
		String orderXml = registrationService.opRegistration(requestXML);

		return ServiceHelper.parseXmlToOrder(orderXml);
	}

}
