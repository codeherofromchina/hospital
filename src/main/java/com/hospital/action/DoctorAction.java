package com.hospital.action;

import java.util.List;

import javax.print.Doc;

import com.hospital.action.base.BaseActionSupport;
import com.hospital.pojo.Dept;
import com.hospital.pojo.Doctor;
import com.hospital.pojo.HaoYuan;
import com.hospital.pojo.Hospital;
import com.hospital.service.DeptService;
import com.hospital.service.DoctorService;
import com.hospital.service.HaoYuanService;

public class DoctorAction extends BaseActionSupport {

	private DoctorService docService;
	private HaoYuanService haoYuanService;
	public HaoYuanService getHaoYuanService() {
		return haoYuanService;
	}
	public void setHaoYuanService(HaoYuanService haoYuanService) {
		this.haoYuanService = haoYuanService;
	}
	public DoctorService getDoctorService() {
		return docService;
	}

	public void setDoctorService(DoctorService doctorService) {
		this.docService = doctorService;
	}
	
	public String docAction() {
		String id = request.getParameter("deptId");
		try{
			Integer docId = Integer.parseInt(id);
			List<Doctor> allDoc = docService.getDocByDeptId(docId);
			for(Doctor d:allDoc){
				List<HaoYuan> haoYuan = haoYuanService.getHaoYuan(d.getId());
				d.setHaoYuan(haoYuan);
			}
			
			request.setAttribute("doc", allDoc);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "doc";
	}
	
}
