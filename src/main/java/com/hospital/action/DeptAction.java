package com.hospital.action;

import java.util.List;

import com.hospital.action.base.BaseActionSupport;
import com.hospital.pojo.Dept;
import com.hospital.pojo.Hospital;
import com.hospital.service.DeptService;
import com.hospital.service.DoctorService;
import com.hospital.service.HospitalService;

public class DeptAction extends BaseActionSupport {
	private DeptService deptService;

	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public String deptAction() {
		String id = request.getParameter("hosId");
		try{
			Integer hosId = Integer.parseInt(id);
			List<Dept> allDept = deptService.getDeptByHosId(hosId);
			request.setAttribute("dept", allDept);
		}catch(Exception e){
			e.printStackTrace();
			//allDept = deptService.getAllDept();
		}
		return "dept";
	}

}
