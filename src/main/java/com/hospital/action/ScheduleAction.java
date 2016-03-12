package com.hospital.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hospital.service.ScheduleService;
/**
 * TODO 
 * @author lenovo
 *
 */
@Controller
@RequestMapping("/search/schedule")
public class ScheduleAction {
	@Resource(name="defaultScheduleService")
	private ScheduleService scheduleService;
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
