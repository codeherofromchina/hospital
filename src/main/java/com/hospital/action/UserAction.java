package com.hospital.action;

import net.sf.json.JSONObject;

import com.hospital.action.base.BaseActionSupport;
import com.hospital.pojo.HaoYuan;
import com.hospital.pojo.User;
import com.hospital.service.HaoYuanService;
import com.hospital.service.UserAppointmentService;
import com.hospital.service.UserService;

public class UserAction extends BaseActionSupport{
	private UserService userService;
	private UserAppointmentService userAppointmentService;
	private HaoYuanService haoYuanService;
	private User user;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public HaoYuanService getHaoYuanService() {
		return haoYuanService;
	}
	public void setHaoYuanService(HaoYuanService haoYuanService) {
		this.haoYuanService = haoYuanService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserAppointmentService getUserAppointmentService() {
		return userAppointmentService;
	}
	public void setUserAppointmentService(
			UserAppointmentService userAppointmentService) {
		this.userAppointmentService = userAppointmentService;
	}
	
	
	/**
	 * 添加用户
	 */
	public void addUser() throws Exception{
		JSONObject result = new JSONObject();
		
		int addUser = userService.addUser(user);
		String yyid = request.getParameter("yyid");
		
		int hyid = 0;
		try{
			hyid = Integer.parseInt(yyid);
		}catch(Exception e){
			result.put("success", false);
			result.put("message", "预约失败，请刷新页面重新预约");
			printWriterJsonToPage(result.toString());
			return ;
		}
		
		if(addUser == 0){
			result.put("success", false);
			result.put("message", "预约失败，用户信息保存失败");
		}else{
			Integer id = user.getId();
			
			HaoYuan findHaoYuanById = haoYuanService.findHaoYuanById(hyid);
			if(findHaoYuanById == null){
				result.put("success", false);
				result.put("message", "预约失败，请尝试重新操作");
				printWriterJsonToPage(result.toString());
				return ;
			}
			
			
			int xn = userAppointmentService.yuyue(id, findHaoYuanById);
			if(xn == 1){
				result.put("success", true);
			}else if(xn == 2){
				result.put("success", false);
				result.put("message", "用户信息已经预约挂号");
			}else{
				result.put("success", false);
				result.put("message", "预约失败，请尝试重新操作");
			}
		}
		
		printWriterJsonToPage(result.toString());
	}
}
