package com.hospital.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Order;
import com.hospital.pojo.Schedule;
import com.hospital.service.OrderService;
import com.hospital.service.ScheduleService;
import com.hospital.tools.DateUtil;
/**
 * @author wxd
 *
 */
@Controller
@RequestMapping("/search/order")
public class OrderAction {
	private final Logger logger = Logger.getLogger(getClass());
	@Resource(name="defaultOrderService")
	private OrderService orderService;
	@Resource(name="defaultScheduleService")
	private ScheduleService scheduleService;
	
	/**
	 * 查询患者预约记录页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryOrder")
	public ModelAndView queryOrderPage(HttpServletRequest request){
		ModelAndView mv = new ModelAndView_velocity(request, "queryOrder");
		return mv;
	}
	

	/**
	 * 取消预约
	 * @param request
	 * @param orderCode	预约单号
	 * @return
	 */
	@RequestMapping("/cancelOrder")
	public ModelAndView cancelOrder(HttpServletRequest request,String orderCode){
		ModelAndView mv = new ModelAndView_velocity(request, "cancelOrder");
		
		if(StringUtils.isNotEmpty(orderCode)){
			try {
				boolean cancelOrderFlag = orderService.cancelOrder(orderCode);
				mv.addObject("success", cancelOrderFlag);
			} catch (TradeErrorException e) {
				logger.error("取消订单失败[errMsg:"+e.getMessage()+"]");
				mv.addObject("success", false);
				mv.addObject("msg", e.getMessage());
			}
		}else{
			mv.addObject("success", false);
			mv.addObject("msg", "预约单号获取失败！");
		}
		
		return mv;
	}
	
	/**
	 * 查询患者预约记录页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/historyOrder")
	public ModelAndView historyOrder(HttpServletRequest request,String cardNum,String cardFlag,String startDate,String endDate){
		ModelAndView mv = new ModelAndView_velocity(request, "historyOrder");
		Map<String,Object> modelMap = new HashMap<String,Object>();
		try{
			Date sDate = DateUtil.parseShortStrToDate(startDate);
			Date eDate = DateUtil.parseShortStrToDate(endDate);
			if(StringUtils.isNotEmpty(cardNum) && sDate!=null && eDate != null){
				List<Order> orderList = null;
				if("1".equals(cardFlag)){ // 身份证查询
					orderList = orderService.queryOrderByIdCard(cardNum, sDate, eDate);
				}else{ // 就诊卡号查询
					orderList = orderService.queryOrderByCardNo(cardNum, sDate, eDate);
				}
				
				modelMap.put("success", true);
				modelMap.put("historyOrder", orderList);
			}else{
				modelMap.put("success", false);
				modelMap.put("errMsg", "查询失败，参数不完整或日期格式错误。");
			}
		}catch(Exception ex){
			logger.error("查询预约记录错误。[errMsg:"+ex.getMessage()+"]");
			modelMap.put("success", false);
			modelMap.put("errMsg", ex.getMessage());
		}
		
		mv.addAllObjects(modelMap);
		return mv;
	}
	
	
	
	/**
	 * 预约医生页面 
	 * @param request
	 * @param deptCode	科室编号
	 * @param docCode	医生编号
	 * @param date	预约日期
	 * @param timeSole 预约时间（S：上午  X：下午、中午    Y：夜晚）,用单独字母表示
	 * @return
	 */
	@RequestMapping("/bookOrder")
	public ModelAndView bookOrder(HttpServletRequest request,String deptCode,String docCode,String date,String timeSole){
		ModelAndView mv = new ModelAndView_velocity(request, "bookOrder");
		mv.addObject("success", false);
		try{
			//参数判断
			if(StringUtils.isNotEmpty(deptCode) && StringUtils.isNotEmpty(docCode) && StringUtils.isNotEmpty(date) && StringUtils.isNotEmpty(timeSole)){
				Date dDate = DateUtil.parseShortStrToDate(date);
				if(timeSole.equals("S") || timeSole.equals("X") || timeSole.equals("Y")){
					List<Schedule> schedules = scheduleService.queryScheduleByDay(deptCode,docCode,dDate);
					if(schedules!=null && schedules.size() > 0){
						boolean breakFlag = false;
						for(Schedule sc:schedules){
							switch (timeSole.charAt(0)) {
								case 'S':
									if("上午".equals(sc.getSessionName())){
										breakFlag = true;
									}
									break;
								case 'X':
									if("下午".equals(sc.getSessionName()) || "中午".equals(sc.getSessionName())){
										breakFlag = true;
									}
									break;
								case 'Y':
									if("晚上".equals(sc.getSessionName())){
										breakFlag = true;
									}
									break;
							}
							if(breakFlag){
								mv.addObject("success", true);
								mv.addObject("schedule", sc);
								break;
							}
						}
						
					}
				}
			}
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		
		
		return mv;
	}
	
	
	/**
	 * 预约挂号
	 * @param request
	 * @param scheduleItemCode 门诊排班项代码
	 * @param cardNo	就诊卡号
	 * @param admitRange	就诊时间段
	 * @return
	 */
	@RequestMapping("/bookService")
	public ModelAndView bookService(HttpServletRequest request,String scheduleItemCode,String cardNo,String admitRange){
		ModelAndView mv = new ModelAndView_velocity(request, "bookOrderResult");
		
		if(logger.isInfoEnabled()){
			logger.info("有卡预约挂号[scheduleItemCode:"+scheduleItemCode+",cardNo:"+cardNo+",admitRange:"+admitRange+"]");
		}
		
		try {
			Order order = orderService.bookService(scheduleItemCode, cardNo, admitRange);
			mv.addObject("order", order);
		} catch (TradeErrorException e) {
			mv.addObject("errMsg", e.getErrorContent());
			logger.error("预约挂号异常错误[scheduleItemCode:"+scheduleItemCode+",cardNo:"+cardNo+",admitRange:"+admitRange+",errMsg:"+e.getErrorContent()+"]");
		}
		
		return mv;
	}
	
	
	/**
	 * 无卡预约挂号
	 * @param request
	 * @param scheduleItemCode
	 * @param admitRange
	 * @param iDCardNo
	 * @param patientName
	 * @param mobileNo
	 * @param gender
	 * @return
	 */
	@RequestMapping("/bookServiceNoCard")
	public ModelAndView bookServiceNoCard(HttpServletRequest request,
			String scheduleItemCode, String admitRange, String iDCardNo,
			String patientName, String mobileNo, String gender) {
		ModelAndView mv = new ModelAndView_velocity(request, "bookOrderResult");
		
		if(logger.isInfoEnabled()){
			logger.info("无卡预约挂号[scheduleItemCode:"+scheduleItemCode+",iDCardNo:"+iDCardNo+",admitRange:"+admitRange+",patientName:"+patientName+",mobileNo:"+mobileNo+",gender:"+gender+"]");
		}
		
		try {
			if (StringUtils.isNotEmpty(scheduleItemCode)
					&& StringUtils.isNotEmpty(iDCardNo)
					&& StringUtils.isNotEmpty(patientName)
					&& StringUtils.isNotEmpty(mobileNo)
					&& StringUtils.isNotEmpty(gender)) {
				Order order = orderService.bookService(scheduleItemCode, admitRange,iDCardNo,patientName,mobileNo,gender);
				mv.addObject("order", order);
			}else{
				mv.addObject("errMsg", "参数信息错误！");
			}
		} catch (TradeErrorException e) {
			mv.addObject("errMsg", e.getErrorContent());
			logger.error("预约挂号异常错误[scheduleItemCode:"+scheduleItemCode+",iDCardNo:"+iDCardNo+",admitRange:"+admitRange+",patientName:"+patientName+",mobileNo:"+mobileNo+",gender:"+gender+",errMsg:"+e.getErrorContent()+"]");
		}
		
		return mv;
	}
	
	
}
