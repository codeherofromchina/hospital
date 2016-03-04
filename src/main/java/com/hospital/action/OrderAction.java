package com.hospital.action;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/search/order")
public class OrderAction {
	
	/**
	 * 查询病人预约挂号信息
	 * @return
	 */
	@RequestMapping("pat_orders")
	public ModelAndView patientOrders(){
		ModelAndView mv = new ModelAndView_velocity( "patientOrders");

		return mv;
	}
	
	/**
	 * 病人取号确认
	 * @return
	 */
	@RequestMapping("confirm_order")
	public ModelAndView OPAppArrive(){
		ModelAndView mv = new ModelAndView_velocity("confirmOrder");

		return mv;
	}
	
	/**
	 * 取消预约的订单
	 * @return
	 */
	@ResponseBody
	@RequestMapping("cancel_order")
	public String cancelOrder(){
		Map<String, Object> _result = new HashMap<String, Object>();
		_result.put("success", true);
		_result.put("msg", "OK");
		
		
		return JSONObject.fromObject(_result).toString();
	}
	
}
