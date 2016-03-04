package com.hospital.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/search/schedule")
public class ScheduleAction {
	
	/**
	 * 获取排班信息
	 * @return
	 */
	@RequestMapping("/info")
	public ModelAndView getScheduleList(){
		ModelAndView mv = new ModelAndView_velocity("schedulesInfo");
		return mv;
	}
}
