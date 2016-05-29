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
import com.hospital.pojo.Doctor;
import com.hospital.pojo.Schedule;
import com.hospital.service.DepartmentService;
import com.hospital.service.DoctorService;
import com.hospital.service.ScheduleService;
import com.hospital.tools.DateUtil;
import com.hospital.tools.WebUtil;
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
	@Resource(name = "defaultDoctorServiceImpl")
	private DoctorService doctorService;
	
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
	 * 获取医生更多排班信息
	 * @param request
	 * @param deptCode	医生所在科室编码
	 * @param doctorCode 医生编码
	 * @param week 在之前跳过几个7天，可以跳过最大3个7天最多，默认0标识不加7天，
	 * 							例如要查询今天过后第8-14天的排班，则此参数是1，第15-21天的排班则是2，第22-28天的排班就是3
	 * @return
	 */
	@RequestMapping("/moreDoctorSchedules")
	public ModelAndView moreDoctorSchedules(HttpServletRequest request,String deptCode,String doctorCode,String week){
		ModelAndView mv = new ModelAndView_velocity(request,"moreDoctorSchedules");
		
		try{
			if(StringUtils.isNotEmpty(deptCode) && StringUtils.isNotEmpty(doctorCode)){
				// 获取科室信息
				Department department = departmentService.queryByDeptCode(deptCode);
				if(department!=null){
					mv.addObject("department", department);
					
					// 获取医生信息
					Doctor doctor = doctorService.queryDoctorByCode(department.getDepartmentCode(),doctorCode);
					if(doctor!=null){
						mv.addObject("doctor", doctor);
						
						int iSkipSevenNumDay = 0;
						try{
							if(StringUtils.isNotEmpty(week)){
								iSkipSevenNumDay = Integer.parseInt(week);
								if(iSkipSevenNumDay<0){
									iSkipSevenNumDay = 0;
								}else if(iSkipSevenNumDay > 3){
									iSkipSevenNumDay = 3;
								}
							}
						}catch(NumberFormatException ex){}
						
						
						// 重点，获取医生排班信息
						Map<String, Object> scheduleData = new HashMap<String, Object>();
						Date today = new Date();
						// 不包含今天的挂号信息，所以从1开始，查询未来7天的挂号信息
						for(int i=1;i<8;++i){
							Date searchDay = DateUtil.plusSomeDay(today, iSkipSevenNumDay*7 +  i);
							
							List<Schedule> schedules = scheduleService.queryScheduleByDay(department.getDepartmentCode(), doctor.getDoctorCode(), searchDay);
							
							scheduleData.put(DateUtil.formatToShortString(searchDay), schedules);
						}
						
						mv.addObject("scheduleData", JSONObject.fromObject(scheduleData));
					}
				}
			}
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		
		// 参数回写
		WebUtil.writeBackParams(request);
		
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
	
}
