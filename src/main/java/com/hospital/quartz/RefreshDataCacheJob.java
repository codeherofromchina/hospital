package com.hospital.quartz;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.hospital.exception.TradeErrorException;
import com.hospital.service.DoctorService;
import com.hospital.tools.DataCacheUtil;

/**
 * 定时任务，执行将所有医生信息和所有科室信息间隔一段时间就刷新缓存DataCacheUtil
 * @author wxd
 *
 */
@Component("refreshDataCacheJob")
public class RefreshDataCacheJob {
	private final static Logger logger = Logger.getLogger(RefreshDataCacheJob.class);
	
	/// 注入医生服务类和科室服务类
	@Resource(name="defaultDoctorServiceImpl")
	private DoctorService doctorService;
	
	public void execute() {
		logger.info("定时缓存所有医生信息开始。");
		try {
			//先清除所有缓存，然后再查询所有信息，查询的同时会自动添加到缓存中去
			DataCacheUtil.clearData();
			
			doctorService.queryAllDoctor();
			logger.info("定时缓存所有医生信息正常结束。");
		} catch (TradeErrorException e) {
			logger.error("定时缓存所有医生信息异常结束。[errMsg:"+e.getMessage()+"]");
		}
	}
}
