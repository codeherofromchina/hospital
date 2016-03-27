package com.hospital.action;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Doctor;
import com.hospital.pojo.Schedule;
import com.hospital.service.DoctorService;
import com.hospital.service.ScheduleService;
import com.hospital.tools.DateUtil;
/**
 * 
 * @author lenovo
 *
 */
@Controller
@RequestMapping("/search/doctor")
public class DoctorAction {
	private final Logger logger = Logger.getLogger(getClass());
	@Resource(name = "defaultDoctorServiceImpl")
	private DoctorService doctorService;
	@Resource(name="defaultScheduleService")
	private ScheduleService scheduleService;

	/**
	 * 异步获取科室中医生列表
	 * @param request
	 * @param departmentCode 科室代码
	 * @return
	 * {"result": [{"doctorCode": "106", "doctorName": "高记华-GJH", "doctorSpec": "", "doctorTitle": "", "doctorTitleCode": ""}],"success": true}
	 */
	@RequestMapping("asyncDepartmentDoctors")
	@ResponseBody
	public String asyncDepartmentDoctors(HttpServletRequest request,String departmentCode){
		Map<String, Object> _result = new HashMap<String, Object>();
		if(StringUtils.isEmpty(departmentCode)){
			_result.put("success", false);
			_result.put("msg", "科室代码不能为空");
		}else{
			_result.put("success", true);
			try {
				List<Doctor> doctors = doctorService.queryDoctor(departmentCode);
				_result.put("result", doctors);
			} catch (TradeErrorException e) {
				logger.error("获取科室中的医生列表出错[errmsg:"+e.getMessage()+"]");
				_result.put("success", false);
				_result.put("msg", e.getMessage());
			}
		}
		
		return JSONObject.fromObject(_result).toString();
	}
	
	
	
	/**
	 * 异步获取所有医生
	 * @param request
	 * @param departmentCode
	 * @return
	 */
	@RequestMapping("asyncAllDoctors")
	@ResponseBody
	public String asyncAllDoctors(HttpServletRequest request){
		Map<String, Object> _result = new HashMap<String, Object>();
		_result.put("success", true);
		try {
			List<Doctor> doctors = doctorService.queryAllDoctor();
			_result.put("result", doctors);
		} catch (TradeErrorException e) {
			logger.error("获取所有医生列表出错[errmsg:"+e.getMessage()+"]");
			_result.put("success", false);
			_result.put("msg", e.getMessage());
		}
		return JSONObject.fromObject(_result).toString();
	}
	
	/**
	 * 用于科室医生页面使用
	 * @param departmentCode  科室编号  如果为空，则查询所有科室
	 * @param pageNo   当前页码  默认1页 ，设置默认每页10个医生，不可编辑
	 * @return
	 */
	@RequestMapping("asyncDoctorDetailByDepartmentCode")
	@ResponseBody
	public Map<String, Object> asyncDoctorDetailByDepartmentCode(String departmentCode,String pageNo){
		Map<String, Object> _result = new HashMap<String,Object>();
		_result.put("success", true);
		List<Doctor> doctors = null;
		try {
			// 查询全部科室
			if(StringUtils.isEmpty(departmentCode)){
				doctors = doctorService.queryDoctor(departmentCode);
			}else{
				// 查询指定科室
				doctors = doctorService.queryDoctor(departmentCode);
			}
		} catch (TradeErrorException e) {
			logger.error("查询全部医生错误[departmentCode:"+departmentCode+",errMsg:"+e.getMessage()+"]");
			_result.put("success", false);
			_result.put("msg", e.getMessage());
		}
		
		int totalPage = 1;
		if ((Boolean) _result.get("success")) {
			if (doctors == null || doctors.size() == 0) {
				_result.put("success", false);
				_result.put("msg", "没有任何医生信息！");
			} else {
				int pageNum = 1;
				totalPage = doctors.size()/10 + (doctors.size()%10 >0?1:0);
				if (StringUtils.isNotEmpty(pageNo)) {
					try {
						pageNum = Integer.parseInt(pageNo);
					} catch (NumberFormatException ex) {
						logger.warn("查询医生详情分页错误[pageNo:" + pageNo + ",errMsg:"
								+ ex.getMessage() + "]");
					}
					if (pageNum < 1) {
						pageNum = 1;
					}else if(pageNum > totalPage){
						pageNum = totalPage;
					}
				}
				
				_result.put("totalPage", totalPage);
				_result.put("pageNum", pageNum);
				int fromIndex = (pageNum - 1) * 10;
				int toIndex = fromIndex + 10;

				List<Doctor> subList = doctors.subList(fromIndex, toIndex);

				
				Date startDate = new Date();
				Date endDate = DateUtil.plusSomeDay(startDate, 2);
				
				for(Doctor doctor:subList){
					try {
						Map<String,List<Schedule>> _tmp = new HashMap<String, List<Schedule>>();
						
						List<Schedule> queryScheduleByDay = scheduleService.queryScheduleByDay(departmentCode, doctor.getDoctorCode(), "S", startDate, endDate);
						
						if(queryScheduleByDay!=null && queryScheduleByDay.size() > 0){
							_tmp.put("S", queryScheduleByDay);
						}
						
						List<Schedule> queryScheduleByDay2 = scheduleService.queryScheduleByDay(departmentCode, doctor.getDoctorCode(), "X", startDate, endDate);
						if(queryScheduleByDay2!=null && queryScheduleByDay2.size() > 0){
							_tmp.put("X", queryScheduleByDay2);
						}
						List<Schedule> queryScheduleByDay3 = scheduleService.queryScheduleByDay(departmentCode, doctor.getDoctorCode(), "Y", startDate, endDate);
						if(queryScheduleByDay3!=null && queryScheduleByDay3.size() > 0){
							_tmp.put("Y", queryScheduleByDay3);
						}
						
						
						
						if(_tmp.size() > 0){
							Collection<List<Schedule>> values = _tmp.values();
							for(List<Schedule> l:values){
								Schedule schedule = l.get(0);
								
								doctor.setDoctorSpec(schedule.getDoctorSpec());
								doctor.setDoctorTitleCode(schedule.getDoctorTitleCode());
								doctor.setDoctorTitle(schedule.getDoctorTitle());
								
								break;
							}
							
							
							_result.put(doctor.getDoctorCode(), _tmp);
						}
						
					} catch (TradeErrorException e) {
						logger.error("查询医生排班信息错误["+e.getMessage()+"]");
					}
				}
				
				
				_result.put("doctors", subList);
			}
		}
		
		return _result;
	}

}
