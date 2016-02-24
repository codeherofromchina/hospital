package com.hospital.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.hospital.action.base.BaseActionSupport;
import com.hospital.pojo.Dept;
import com.hospital.pojo.HaoYuan;
import com.hospital.service.HaoYuanService;

public class HaoYuanAction extends BaseActionSupport{
	private HaoYuanService haoYuanService;
	
	public HaoYuanService getHaoYuanService() {
		return haoYuanService;
	}

	public void setHaoYuanService(HaoYuanService haoYuanService) {
		this.haoYuanService = haoYuanService;
	}

}
