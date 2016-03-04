package com.hospital.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hospital.service.DoctorService;

@Controller
@RequestMapping("/search/doctor")
public class DoctorAction {
	@Resource(name = "defaultDoctorServiceImpl")
	private DoctorService doctorService;


	/**
	 * 获取科室医生列表和必要model信息并返回到医生列表页面
	 * 
	 * @return
	 */
	@RequestMapping("/department_doctors")
	public ModelAndView getDepartment(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView_velocity(request, "doctors");

		return mv;
	}

}
