package com.hospital.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

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
 * @author wxd
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
	public ModelAndView getScheduleList(HttpServletRequest request,String deptCode){
		ModelAndView mv = new ModelAndView_velocity(request,"schedules_dept");
		
		try {
			List<Department> allDepts = departmentService.queryAllDepartments();
			mv.addObject("allDepts", allDepts);
		} catch (TradeErrorException e) {
			logger.error("查询所有科室错误[errmsg:"+e.getMessage()+"]");
		}
		
		// 设置传入的科室编号
		if(StringUtils.isNotEmpty(deptCode)){
			mv.addObject("deptCode", deptCode);
		}
		
		return mv;
	}
	
	
	/**
	 * 获取某科室排班列表信息
	 * 
	 * @param request
	 * @param departmentCode	科室编号
	 * @param date  固定某天的排班信息 格式 （yyyy-MM-dd）
	 * @return
	 */
	@RequestMapping("asyncScheduleDayDepartment")
	@ResponseBody
	public String asyncScheduleDayDepartment(HttpServletRequest request,String departmentCode,String date) {
		Map<String, Object> _result = new HashMap<String, Object>();
		_result.put("success", true);
		// 检查参数完整性
		if(StringUtils.isEmpty(departmentCode) || StringUtils.isEmpty(date)){
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
					List<Schedule> schedules = scheduleService.queryScheduleByDay(departmentCode, dDate);
					_result.put("result", schedules);
				} catch (TradeErrorException e) {
					logger.error("查询某科室内排班医生异常["+e.getMessage()+"]");
					_result.put("success", false);
					_result.put("msg", e.getMessage());
				}
			}
		}
		
		return JSONObject.fromObject(_result).toString();
	}
	
	
	/**
	 * 查询科室中给定时间到7天后时间段内医生排班列表
	 * @param request	
	 * @param departmentCode 科室编号
	 * @param sDate 开始日期 （包含）  -- yyyy-MM-dd
	 * @param n  往后的几天，如果负数或其他错误格式，将会自动修改为只查当天结果，即 n=0,最多只能连续查询8天
	 * @return
	 */
	@RequestMapping("asyncScheduleNDaysDapartment")
	@ResponseBody
	public String asyncScheduleSevenDaysDapartment(HttpServletRequest request,String departmentCode,String sDate,String n){
		Map<String, Object> _result = new HashMap<String, Object>();
		_result.put("success", true);
		
		// 检查参数完整性
		if(StringUtils.isEmpty(departmentCode) || StringUtils.isEmpty(sDate)){
			_result.put("success", false);
			_result.put("msg", "参数不完整");
		}else{
			// 检查日期参数是否正确
			int nDay = 0;
			if(StringUtils.isNotEmpty(n)){
				try{
					nDay = Integer.parseInt(n);
				}catch(NumberFormatException ex){}
			}
			// 最多只能连续查询8天
			if(nDay > 8){
				nDay = 8;
			}
			
			Date sdate = DateUtil.parseShortStrToDate(sDate);
			if(sdate == null){
				_result.put("success", false);
				_result.put("msg", "日期参数错误");
			}else{
				try {
					Map<String, List<Schedule>> mapObject = new HashMap<String, List<Schedule>>();
					
					for(int i=0;i<=nDay;++i){
						Date tempDate = DateUtil.plusSomeDay(sdate, i);
						List<Schedule> schedules = scheduleService.queryScheduleByDay(departmentCode, tempDate);
						if(schedules!=null && schedules.size() > 0){
							mapObject.put(DateUtil.formatToShortString(tempDate), schedules);
						}
					}
					
					_result.put("result", mapObject);
				} catch (TradeErrorException e) {
					logger.error("查询某科室内排班医生异常["+e.getMessage()+"]");
					_result.put("success", false);
					_result.put("msg", e.getMessage());
				}
			}
		}
		
		return JSONObject.fromObject(_result).toString();
	}
	
	/*
	 * TODO  
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
