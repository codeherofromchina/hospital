package com.hospital.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
 * 
 * @author wxd
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
	@Resource(name = "defaultDepartmentServiceImpl")
	private DepartmentService departmentService;

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
	 * 异步获取在给定科室名称（标准科室名称中包含给定字符即可）中的医生
	 * @param request
	 * @param departmentCode
	 * @return
	 */
	@RequestMapping("asyncDoctorsByDeparmentName")
	@ResponseBody
	public String asyncDoctorsByDeparmentName(HttpServletRequest request,String deptName){
		Map<String, Object> _result = new HashMap<String, Object>();
		_result.put("success", true);
		try {
			List<Doctor> doctors = doctorService.queryAllDoctor();
			
			if(StringUtils.isNotEmpty(deptName)){
				List<Doctor> resultDoctors = new ArrayList<Doctor>();
				for(Doctor d:doctors){
					if(d.getDepartmentName().contains(deptName)){
						resultDoctors.add(d);
					}
				}
				
				_result.put("result", resultDoctors);
			}else{
				_result.put("result", doctors);
			}
		} catch (TradeErrorException e) {
			logger.error("获取所有医生列表出错[errmsg:"+e.getMessage()+"]");
			_result.put("success", false);
			_result.put("msg", e.getMessage());
		}
		return JSONObject.fromObject(_result).toString();
	}
	
	
	/**
	 * 跳转到科室医师列表页面
	 * @param request
	 * @param deptCode
	 * @return
	 */
	@RequestMapping("deptDoctorList")
	public ModelAndView deptDoctorList(HttpServletRequest request,String deptCode,String doctorName){
		ModelAndView mv = new ModelAndView_velocity(request, "deptDoctorList");
		
		// 获取所有科室
		try {
			List<Department> allDepartments = departmentService.queryAllDepartments();
			mv.addObject("allDepts", allDepartments);
		} catch (TradeErrorException e) {
			logger.error("获取所有科室组出错["+e.getMessage()+"]");
		}
		
		WebUtil.writeBackParams(request);
		

		return mv;
	}
	
	
	/**
	 * 用于科室医生页面使用
	 * @param deptCode  科室编号  如果为空，则查询所有科室
	 * @param pageNo   当前页码  默认1页 ，设置默认每页10个(不可编辑)医生，
	 * @return
	 */
	@RequestMapping("asyncDoctorDetailByDepartmentCode")
	@ResponseBody
	public String asyncDoctorDetailByDepartmentCode(String deptCode,String doctorName,String pageNo){
		Map<String, Object> _result = new HashMap<String,Object>();
		_result.put("success", true);
		List<Doctor> doctors = null;
		try {
			// 查询全部科室
			if(StringUtils.isEmpty(deptCode)){
				doctors = doctorService.queryAllDoctor();
			}else{
				// 查询指定科室
				doctors = doctorService.queryDoctor(deptCode);
			}
			
			// 如果医生姓名存在，则过滤医生姓名
			if(StringUtils.isNotEmpty(doctorName) &&doctors!=null && doctors.size() > 0){
				List<Doctor> dest = new ArrayList<Doctor>();
				for(Doctor d:doctors){
					if(d.getDoctorName().contains(doctorName)){
						dest.add(d);
					}
				}
				doctors = dest;
			}
			
		} catch (TradeErrorException e) {
			logger.error("查询全部医生错误[departmentCode:"+deptCode+",errMsg:"+e.getMessage()+"]");
			_result.put("success", false);
			_result.put("msg", e.getMessage());
		}
		
		int totalPage = 1;
		if ((Boolean) _result.get("success")) {
			if (doctors == null || doctors.size() == 0) {
				_result.put("success", false);
				_result.put("msg", "没有任何医生信息！");
			} else {
				
				// 获取当前页码和总记录条数
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
				
				_result.put("totalPage", totalPage);// 总页码
				int size = doctors.size();
				_result.put("totalLimit", size); // 总记录条数
				_result.put("pageNum", pageNum); // 当前页码
				int fromIndex = (pageNum - 1) * 10;
				int toIndex = fromIndex + 10;
				
				//  声明放置医生和医生排班信息的列表 {"doctor":医生实体信息,"schedules":排班列表信息}
				List<Map<String, Object>> doctorsInfo = new ArrayList<Map<String,Object>>();

				// 获取分页后的医生列表
				List<Doctor> subList = doctors.subList(fromIndex, toIndex>size?size:toIndex);
				
				// 查询今天至两天后的医生排班信息
				Date today = new Date();
				
				for(Doctor doctor:subList){
					Map<String, Object> tmpMap = new HashMap<String, Object>();
					
					List<Schedule> doctorSchedules = new ArrayList<Schedule>();
					try {
						// 最多获取2天外的排班信息,由于一次只能查询到一天的排班信息，所有分多次查询
						boolean setDoctorInfoFlag = true;
						for(int i=0;i<3;++i){
							Date searchDate = DateUtil.plusSomeDay(today, i);
							List<Schedule> searchSchedules = scheduleService.queryScheduleByDay(doctor.getDepartmentCode(), doctor.getDoctorCode(), searchDate);
							// 如果排班信息存在,则放入到医生排班键中
							if( searchSchedules!=null && searchSchedules.size() >0){
								if(setDoctorInfoFlag){ // 丰富医生实体信息内容
									// 从排班信息中获取医生比较更详细的信息(包括 医生级别、医生级别编码、出诊级别)
									Schedule schedule = searchSchedules.get(0);
									doctor.setDoctorTitleCode(schedule.getDoctorTitleCode());
									doctor.setDoctorTitle(schedule.getDoctorTitle());
									doctor.setDoctorSessType(schedule.getDoctorSessType());
									
									setDoctorInfoFlag = false;
									
								}
								
								// 放入到要返回的数据模型中
								doctorSchedules.addAll(searchSchedules);

								// 数据模型中只需要最少三条排班信息即可
								if(doctorSchedules.size() >= 2){
									doctorSchedules = doctorSchedules.subList(0, 2);
									break;
								}
							}
							
						}
					} catch (TradeErrorException e) {
						logger.error("查询医生排班信息错误["+e.getMessage()+"]");
					}
					tmpMap.put("schedules", doctorSchedules);
					
					
					tmpMap.put("doctor", doctor);
					doctorsInfo.add(tmpMap);
				}
				
				_result.put("doctors", doctorsInfo);
			}
		}
		
		return JSONObject.fromObject(_result).toString();
	}
	
}
