package com.hospital.service;

import java.util.List;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Order;
import com.hospital.pojo.request.OPAppArriveRequest;
import com.hospital.pojo.request.QueryOrderRequest;

/**
 * 订单挂号信息查询服务接口规范
 * 
 * @author wxd
 *
 */
public interface OrderService {

	/**
	 * 查询病人预约挂号信息
	 * 
	 * @param request
	 * @return
	 * @throws TradeErrorException
	 */
	public List<Order> queryOrder(QueryOrderRequest request) throws TradeErrorException;

	/**
	 * 病人取号后，HIS向预约机构发送已取号的消息。（当预约机构在自己的系统中存储排班信息和预约记录时使用）
	 * 
	 * @param request
	 * @return
	 * @throws TradeErrorException
	 */
	public Order opAppArrive(OPAppArriveRequest request) throws TradeErrorException;
}
