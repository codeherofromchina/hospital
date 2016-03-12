package com.hospital.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Doctor;
import com.hospital.service.DoctorService;
/**
 * 
 * @author lenovo
 *
 */
@Controller
@RequestMapping("/search/doctor")
public class DoctorAction {
	private final Logger logger = Logger.getLogger(getClass());
	@Resource(name = "defaultDoctorServiceImpl")
	private DoctorService doctorService;

	/**
	 * 异步获取科室中医生列表
	 * @param request
	 * @param departmentCode
	 * @return
	 */
	@RequestMapping("asyncDepartmentDoctors")
	@ResponseBody
	public Map<String, Object> asyncDepartmentDoctors(HttpServletRequest request,String departmentCode){
		Map<String, Object> _result = new HashMap<String, Object>();
		if(StringUtils.isEmpty(departmentCode)){
			_result.put("success", false);
			_result.put("msg", "科室代码不能为空");
		}else{
			_result.put("success", true);
			try {
				List<Doctor> doctors = doctorService.queryDoctor(departmentCode);
				_result.put("result", doctors);
			} catch (TradeErrorException e) {
				logger.error("获取科室中的医生列表出错[errmsg:"+e.getMessage()+"]");
				_result.put("success", false);
				_result.put("msg", e.getMessage());
			}
		}
		
		return _result;
	}
	
	
	
	/**
	 * 异步获取所有医生
	 * @param request
	 * @param departmentCode
	 * @return
	 */
	@RequestMapping("asyncAllDoctors")
	@ResponseBody
	public Map<String, Object> asyncAllDoctors(HttpServletRequest request){
		Map<String, Object> _result = new HashMap<String, Object>();
		_result.put("success", true);
		try {
			List<Doctor> doctors = doctorService.queryAllDoctor();
			_result.put("result", doctors);
		} catch (TradeErrorException e) {
			logger.error("获取所有医生列表出错[errmsg:"+e.getMessage()+"]");
			_result.put("success", false);
			_result.put("msg", e.getMessage());
		}
		return _result;
	}

}
