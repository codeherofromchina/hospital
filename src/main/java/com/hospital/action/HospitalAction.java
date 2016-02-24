package com.hospital.action;

import java.util.List;
import net.sf.json.JSONObject;
import com.hospital.action.base.BaseActionSupport;
import com.hospital.pojo.Doctor;
import com.hospital.pojo.Hospital;
import com.hospital.service.DoctorService;
import com.hospital.service.HospitalService;

public class HospitalAction extends BaseActionSupport{
	private HospitalService hospitalService;
	private DoctorService doctorService;
	public HospitalService getHospitalService() {
		return hospitalService;
	}
	public void setHospitalService(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}
	
	
	public DoctorService getDoctorService() {
		return doctorService;
	}
	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	@Override
	public String execute() throws Exception {
		request.setAttribute("abc", "都顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶大");
		
		List<Hospital> allHospital = hospitalService.getAllHospital();

		request.setAttribute("hospitals", allHospital);
		
		Doctor doc = doctorService.getDoc();
		
		request.setAttribute("doc", doc);
		
		
		return SUCCESS;
	}
	
	
	public void jsonString() throws Exception{
		JSONObject result = new JSONObject();
		
		result.put("key", "string");
		
		printWriterJsonToPage(result.toString());
	}
	
	
	
	public String hosIndex(){
		
		List<Hospital> allHospital = hospitalService.getAllHospital();
		
		request.setAttribute("hos", allHospital);
		return "index";
	}
	
}
