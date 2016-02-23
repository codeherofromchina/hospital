package com.hospital.service;

import java.util.List;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Order;
import com.hospital.pojo.request.OPAppArriveRequest;
import com.hospital.pojo.request.QueryOrderRequest;

/**
 * �����Һ���Ϣ��ѯ����ӿڹ淶
 * 
 * @author wxd
 *
 */
public interface OrderService {

	/**
	 * ��ѯ����ԤԼ�Һ���Ϣ
	 * 
	 * @param request
	 * @return
	 * @throws TradeErrorException
	 */
	public List<Order> queryOrder(QueryOrderRequest request) throws TradeErrorException;

	/**
	 * ����ȡ�ź�HIS��ԤԼ����������ȡ�ŵ���Ϣ������ԤԼ�������Լ���ϵͳ�д洢�Ű���Ϣ��ԤԼ��¼ʱʹ�ã�
	 * 
	 * @param request
	 * @return
	 * @throws TradeErrorException
	 */
	public Order opAppArrive(OPAppArriveRequest request) throws TradeErrorException;
}
