package com.hospital.action;

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
import com.hospital.service.DepartmentService;

/**
 * 
 * 科室部门action操作类
 * @author wxd
 *
 */
@Controller
@RequestMapping("/search/department")
public class DepartmentAction {
	private final Logger logger = Logger.getLogger(getClass());
	@Resource(name = "defaultDepartmentServiceImpl")
	private DepartmentService departmentService;
	
	/**
	 * 异步获取所有科室信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/asyncAllDepartments")
	@ResponseBody
	public String asyncAllDepartmentGroups(HttpServletRequest request){
		Map<String, Object> _result = new HashMap<String, Object>();
		_result.put("success", true);
		
		try {
			List<Department> AllDepartments = departmentService.queryAllDepartments();
			_result.put("result", AllDepartments);
		} catch (TradeErrorException e) {
			logger.error("获取所有科室组出错["+e.getMessage()+"]");
			_result.put("success", false);
			_result.put("msg", e.getMessage());
		}
		
		return JSONObject.fromObject(_result).toString();
	}
	
	
	/**
	 * 根据科室名称异步获取科室信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/asyncQueryDepartmentByName")
	@ResponseBody
	public String asyncQueryDepartmentByName(HttpServletRequest request,String deptName){
		Map<String, Object> _result = new HashMap<String, Object>();
		
		if(StringUtils.isNotEmpty(deptName)){
			_result.put("success", true);
			try {
				boolean findFlag = false;
				
				List<Department> AllDepartments = departmentService.queryAllDepartments();
				for(Department dept:AllDepartments){
					if(dept.getDepartmentName().equals(deptName)){
						_result.put("result", dept);
						findFlag = true;
						break;
					}
				}
				
				if(!findFlag){
					_result.put("success", false);
					_result.put("msg", "没有匹配的科室，请输入或选取完整科室名称。");
				}
			} catch (TradeErrorException e) {
				logger.error("获取所有科室组出错["+e.getMessage()+"]");
				_result.put("success", false);
				_result.put("msg", e.getMessage());
			}
		}else{
			_result.put("success", false);
			_result.put("msg", "必须需要科室名称");
		}
		return JSONObject.fromObject(_result).toString();
	}
	
	/**
	 * 查看所有科室列表
	 * 用于显示所有科室信息列表页面
	 * @return
	 */
	@RequestMapping("findAllDepartment")
	public ModelAndView findAllDepartment(HttpServletRequest request){
		ModelAndView mv = new ModelAndView_velocity(request,"allDepartment");
		try {
			List<Department> allDepartments = departmentService.queryAllDepartments();
			mv.addObject("allDepartments", allDepartments);
		} catch (TradeErrorException e) {
			logger.error("查询所有科室组出错["+e.getMessage()+"]");
			mv.addObject("errMsg", e.getMessage());
		}
		
		return mv;
	}
	
	
}
