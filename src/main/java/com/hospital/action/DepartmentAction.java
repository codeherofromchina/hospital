package com.hospital.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hospital.service.DepartmentService;

@Controller
@RequestMapping("/search/department")
public class DepartmentAction {
	@Resource(name = "defaultDepartmentServiceImpl")
	private DepartmentService departmentService;

	/**
	 * 获取一级科室信息和必要model信息并返回到一级科室页面
	 * 
	 * @return
	 */
	@RequestMapping("/department_group")
	public ModelAndView getDepartmentGroup(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView_velocity(request, "department_group");

		return mv;
	}

	/**
	 * 获取二级科室信息和必要model信息并返回到二级科室页面
	 * 
	 * @return
	 */
	@RequestMapping("/department")
	public ModelAndView getDepartment(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView_velocity(request, "department");

		return mv;
	}

}
