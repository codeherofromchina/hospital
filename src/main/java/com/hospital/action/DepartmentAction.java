package com.hospital.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * 异步获取所有一级科室信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/asyncAllGroups")
	@ResponseBody
	public Map<String, Object> asyncAllDepartmentGroups(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> _result = new HashMap<String, Object>();
		_result.put("success", true);
		
		try {
			List<Department> allDepartmentGroups = departmentService.queryDepartmentGroup();
			_result.put("result", allDepartmentGroups);
		} catch (TradeErrorException e) {
			logger.error("获取所有科室组出错["+e.getMessage()+"]");
			_result.put("success", false);
			_result.put("msg", e.getMessage());
		}
		
		return _result;
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
			List<Department> allDepartmentGroups = departmentService.queryDepartmentGroup();
			mv.addObject("list", allDepartmentGroups);
		} catch (TradeErrorException e) {
			logger.error("查询所有科室组出错["+e.getMessage()+"]");
			mv.addObject("errMsg", e.getMessage());
		}
		
		return mv;
	}
	
	
}