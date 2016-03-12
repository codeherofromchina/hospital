package com.hospital.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hospital.service.PatientService;
/**
 * TODO
 * @author lenovo
 *
 */
@Controller
@RequestMapping("/search/patient")
public class PatientAction {
	@Resource(name="defaultPatientService")
	private PatientService patientService;
	
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
