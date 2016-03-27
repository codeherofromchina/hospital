package com.hospital.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
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
	private final Logger logger = Logger.getLogger(getClass());
	@Resource(name="defaultPatientService")
	private PatientService patientService;
	
	/**
	 * 查询病人基本信息
	 * @param request
	 * @param cardNo  患者就医卡的卡号
	 * @return
	 */
	@RequestMapping("patInfo")
	public ModelAndView searchPatInfo(HttpServletRequest request,String cardNo){
		ModelAndView mv = new ModelAndView_velocity("patInfo");
		
		logger.info("cardNo:" + cardNo);
		
		
		return mv;
	}
	
	
	
}
