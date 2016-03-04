package com.hospital.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/search/patient")
public class PatientAction {
	
	/**
	 * 查询病人基本信息
	 * @return
	 */
	@RequestMapping("patInfo")
	public ModelAndView searchPatInfo(){
		ModelAndView mv = new ModelAndView_velocity("patInfo");
		return mv;
	}
	
	
	
}
