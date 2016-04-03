package com.hospital.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Patient;
import com.hospital.service.PatientService;

/**
 * @author lenovo
 *
 */
@Controller
@RequestMapping("/search/patient")
public class PatientAction {
	private final Logger logger = Logger.getLogger(getClass());
	@Resource(name = "defaultPatientService")
	private PatientService patientService;

	/**
	 * 查询病人基本信息表单页面
	 * 
	 * @param request
	 * @param cardNo
	 *            患者就医卡的卡号
	 * @return
	 */
	@RequestMapping("searchPatInfo")
	public ModelAndView searchPatInfo(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView_velocity(request,"searchPatInfo");
		return mv;
	}

	/**
	 * 查询病人基本信息结果页面
	 * 
	 * @param request
	 * @param cardNo
	 *            患者就医卡的卡号
	 * @return
	 */
	@RequestMapping("patientInfo")
	public ModelAndView patientInfo(HttpServletRequest request, String cardNo) {
		ModelAndView mv = new ModelAndView_velocity("patientInfo");
		
		if(StringUtils.isNotEmpty(cardNo)){
			try {
				Patient patient = patientService.getPatInfoByCardNo(cardNo);
				mv.addObject("success", true);
				mv.addObject("patient", patient);
			} catch (TradeErrorException e) {
				mv.addObject("success", false);
				mv.addObject("msg", e.getMessage());
				logger.error("查询患者信息出错[errMsg:"+e.getMessage()+"]");
			}
		}else{
			mv.addObject("success", false);
			mv.addObject("msg", "就医卡号不能为空！");
		}
		logger.info("cardNo:" + cardNo);

		return mv;
	}
}
