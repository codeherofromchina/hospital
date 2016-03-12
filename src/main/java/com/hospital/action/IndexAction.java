package com.hospital.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Department;
import com.hospital.service.DepartmentService;
/**
 * 网站首页面action
 * @author lenovo
 *
 */
@Controller
public class IndexAction {
	@Resource(name="defaultDepartmentServiceImpl")
	private DepartmentService departmentService;
	
	/**
	 * 页面首页
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView execute(HttpServletRequest request){
		ModelAndView mv = new ModelAndView_velocity(request, "index");
		
		try {
			// 获取所有一级科室并存储到model中供页面使用
			List<Department> departmentGroups = departmentService.queryDepartmentGroup();
			mv.addObject("departmentGroups", departmentGroups);
		} catch (TradeErrorException e) {
			e.printStackTrace();
		}
		
		return mv;
	}
}
