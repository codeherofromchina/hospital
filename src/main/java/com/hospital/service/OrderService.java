package com.hospital.service;

import java.util.Date;
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
	 * 根据就诊卡号查询病人预约挂号信息
	 * @param cardNo 就诊卡号
	 * @param startDate 记录开始时间
	 * @param endDate	记录结束时间
	 * @return
	 * @throws TradeErrorException
	 */
	public List<Order> queryOrderByCardNo(String cardNo,Date startDate,Date endDate) throws TradeErrorException;
	
	/**
	 * 根据身份证号查询病人预约挂号信息
	 * @param idCard 身份证号
	 * @param startDate 记录开始时间
	 * @param endDate	记录结束时间
	 * @return
	 * @throws TradeErrorException
	 */
	public List<Order> queryOrderByIdCard(String idCard,Date startDate,Date endDate) throws TradeErrorException;
	
	/**
	 * 取消已经预约的信息
	 * @param orderCode	预约单号
	 * @return
	 * @throws TradeErrorException
	 */
	public boolean cancelOrder(String orderCode) throws TradeErrorException;
	

	/**
	 * 病人取号后，HIS向预约机构发送已取号的消息。（当预约机构在自己的系统中存储排班信息和预约记录时使用）
	 * 
	 * @param request
	 * @return
	 * @throws TradeErrorException
	 */
	public Order opAppArrive(OPAppArriveRequest request) throws TradeErrorException;
	
	
	/**
	 * 有卡预约挂号
	 * @param scheduleItemCode	门诊排班项记录标识
	 * @param cardNo	病人就诊卡卡号
	 * @param admitRange	就诊时间段
	 * @return
	 * @throws TradeErrorException
	 */
	public Order bookService(String scheduleItemCode,String cardNo,String admitRange) throws TradeErrorException;
	
	/**
	 * 无卡预约挂号
	 * @param scheduleItemCode
	 * @param admitRange
	 * @param iDCardNo	身份证号
	 * @param patientName	病人名称
	 * @param mobileNo	电话号码
	 * @param gender	性别  1：男  2：女
	 * @return
	 * @throws TradeErrorException
	 */
	public Order bookService(String scheduleItemCode,String admitRange,String iDCardNo,String patientName,String mobileNo,String gender) throws TradeErrorException;
	
}
