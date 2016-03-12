package com.hospital.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.hospital.tools.CommUtil;
import com.hospital.tools.HttpInclude;

/**
 * 
 * TODO
 * velocity 视图的模型页面简化类
 * @author lenovo
 *
 */
public class ModelAndView_velocity extends ModelAndView {
	
	
	public ModelAndView_velocity(HttpServletRequest request,
			HttpServletResponse response, String viewName) {
		this(request, viewName);
		this.addObject("httpInclude", new HttpInclude(request, response));
	}

	public ModelAndView_velocity(HttpServletRequest request, String viewName) {
		this(viewName);
		this.addObject("webPath", CommUtil.getURL(request));
	}

	public ModelAndView_velocity(String viewName) {
		super("/velocity/" + viewName);
	}
}
