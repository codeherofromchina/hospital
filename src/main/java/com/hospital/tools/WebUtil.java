package com.hospital.tools;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public final class WebUtil {
	
	/**
	 * 参数回写并设置到reqeust.setAttribute中
	 * @param request
	 */
	public static void writeBackParams(HttpServletRequest request){
		Map<String, String> _attrP = new HashMap<String, String>();
		Enumeration<String> pNames = request.getParameterNames();
		while(pNames.hasMoreElements()){
			String name = pNames.nextElement();
			_attrP.put(name, request.getParameter(name));
		}
		request.setAttribute("_params", _attrP);
	}
}
