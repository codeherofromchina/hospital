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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Department;
import com.hospital.pojo.Schedule;
import com.hospital.service.DepartmentService;
import com.hospital.service.ScheduleService;
import com.hospital.tools.DateUtil;
/**
 * @author lenovo
 *
 */
@Controller
@RequestMapping("/search/schedule")
public class ScheduleAction {
	private final Logger logger = Logger.getLogger(getClass());
	@Resource(name="defaultScheduleService")
	private ScheduleService scheduleService;
	@Resource(name="defaultDepartmentServiceImpl")
	private DepartmentService departmentService;
	
	/**
	 * 科室排班页面
	 * @return
	 */
	@RequestMapping("/department")
	public ModelAndView getScheduleList(){
		ModelAndView mv = new ModelAndView_velocity("schedules_department");
		
		try {
			List<Department> queryDepartmentGroup = departmentService.queryDepartmentGroup();
			mv.addObject("departmentGroup", queryDepartmentGroup);
		} catch (TradeErrorException e) {
			logger.error("查询所有科室错误[errmsg:"+e.getMessage()+"]");
		}
		
		return mv;
	}
	
	
	/**
	 * 获取某科室排班列表信息
	 * @param request
	 * @param departmentCode
	 * @param timeSlot
	 * @param date
	 * @return
	 */
	@RequestMapping("asyncScheduleDoctors")
	@ResponseBody
	public Map<String, Object> asyncScheduleDoctors(HttpServletRequest request,String departmentCode,String timeSlot,String date) {
		Map<String, Object> _result = new HashMap<String, Object>();
		_result.put("success", true);
		// 检查参数完整性
		if(StringUtils.isEmpty(departmentCode) || StringUtils.isNotEmpty(timeSlot) || StringUtils.isNotEmpty(date)){
			_result.put("success", false);
			_result.put("msg", "参数不完整");
		}else{
			// 检查日期参数是否正确
			Date dDate = DateUtil.parseShortStrToDate(date);
			if(dDate == null){
				_result.put("success", false);
				_result.put("msg", "日期参数错误");
			}else{
				
				try {
					List<Schedule> schedules = scheduleService.queryScheduleByDay(departmentCode, timeSlot, dDate, dDate);
					_result.put("result", schedules);
				} catch (TradeErrorException e) {
					logger.error("查询某科室内排班医生异常["+e.getMessage()+"]");
					_result.put("success", false);
					_result.put("msg", e.getMessage());
				}
			}
		}
		
		return _result;
	}
	
	
	/**
	 * 查询科室
	 * @param request
	 * @param departmentCode
	 * @param timeSlot
	 * @param date
	 * @return
	 */
	@RequestMapping("asyncScheduleDoctors")
	@ResponseBody
	public Map<String, Object> asyncScheduleDepartmnetCode(HttpServletRequest request,String departmentCode,String date){
		Map<String, Object> _result = new HashMap<String, Object>();
		_result.put("success", true);
		
		// 检查参数完整性
		if(StringUtils.isEmpty(departmentCode) || StringUtils.isNotEmpty(date)){
			_result.put("success", false);
			_result.put("msg", "参数不完整");
		}else{
			// 检查日期参数是否正确
			Date dDate = DateUtil.parseShortStrToDate(date);
			if(dDate == null){
				_result.put("success", false);
				_result.put("msg", "日期参数错误");
			}else{
				try {
					// {S:{date1:n,date2:n,date3:n},X:{date1:n,date2:n,date3:n},Y:{date1:n,date2:n,date3:n}}
					Map<String, Map<String, Object>> mapObject = new HashMap<String, Map<String, Object>>();
					// 分别查询上午、下午、和晚上的排班并进行处理
					String[] sArr = {"S","X","Y"};
					for(String s:sArr){
						List<Schedule> schedules = scheduleService.queryScheduleByDay(departmentCode, s, dDate, DateUtil.plusSomeDay(dDate, 7));
						mapObject.put(s, handlerSchedule(schedules));
					}
					
					_result.put("result", mapObject);
				} catch (TradeErrorException e) {
					logger.error("查询某科室内排班医生异常["+e.getMessage()+"]");
					_result.put("success", false);
					_result.put("msg", e.getMessage());
				}
			}
		}
		
		return _result;
	}
	
	/*
	 * 获取排班日期某天的剩余数量
	 */
	private Map<String, Object> handlerSchedule(List<Schedule> schedules){
		Map<String, Object> _result = new HashMap<String, Object>();
		
		for(Schedule schedule:schedules){
			String serviceDate = schedule.getServiceDate();
			int availableNum = 0;
			try{
				availableNum = Integer.parseInt(schedule.getAvailableNum());
			}catch(NumberFormatException ex){
				logger.error("获取排班信息后剩余号数量转数字错误["+ex.getMessage()+"]");
			}
			
			if(_result.containsKey(serviceDate)){
				Integer num = (Integer)_result.get(serviceDate);
				_result.put(serviceDate, availableNum +num);
			}else{
				_result.put(serviceDate, availableNum);
			}
		}
		
		return _result;
	}
	
}
