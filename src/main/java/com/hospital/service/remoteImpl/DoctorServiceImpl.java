package com.hospital.service.remoteImpl;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Department;
import com.hospital.pojo.Doctor;
import com.hospital.pojo.request.QueryDoctorRequest;
import com.hospital.pojo.stub.PUB0008Soap;
import com.hospital.service.DepartmentService;
import com.hospital.service.DoctorService;
import com.hospital.tools.DataCacheUtil;
import com.hospital.tools.GlobalConstant;
import com.hospital.tools.ObjectTransUtil;
import com.hospital.tools.ServiceHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 医生接口服务实现类
 *
 * @author wxd
 */
@Service("defaultDoctorServiceImpl")
public class DoctorServiceImpl implements DoctorService {
    private final Logger logger = Logger.getLogger(getClass());
    @Resource(name = "pub0008Soap")
    private PUB0008Soap pub0008Soap;
    @Resource(name = "defaultDepartmentServiceImpl")
    private DepartmentService departmentService;


    /**
     * 获取科室的医师列表
     *
     * @throws TradeErrorException
     */
    public List<Doctor> queryDoctor(String departmentCode) throws TradeErrorException {

        // 先从缓存中查询，如果查询失败，再调用远程查询
        List<Doctor> data = DataCacheUtil.getData(DataCacheUtil.CacheKey.ALL_DOCTORS_KEY, Doctor.class);
        if (data != null && data.size() > 0) {
            List<Doctor> result = new ArrayList<Doctor>();
            for (Doctor doctor : data) {
                if (departmentCode.equals(doctor.getDepartmentCode())) {
                    result.add(doctor);
                }
            }
            return result;
        }


        // 缓存中查询医生信息失败，调用远程接口获取科室信息和该医生信息
        QueryDoctorRequest request = new QueryDoctorRequest(departmentCode);
        //获取科室中的所有医生，并设置医生实体中的科室信息，科室编号、科室姓名
        List<Doctor> doctors = queryDoctor(request);
        return doctors;
    }

    /**
     * 查询所有科室中的医生列表，因此医院没有二级科室，所以就直接查询一级科室了
     */
    public List<Doctor> queryAllDoctor() throws TradeErrorException {
        // 先从缓存中获取，如果获取不到，则从远程接口查询，并放置到缓存中
        List<Doctor> data = DataCacheUtil.getData(DataCacheUtil.CacheKey.ALL_DOCTORS_KEY, Doctor.class);
        if (data != null && data.size() > 0) {
            return data;
        }

        List<Doctor> _result = new ArrayList<Doctor>();

        // 获取所有科室
        List<Department> allDepartments = departmentService.queryAllDepartments();
        for (Department dept : allDepartments) {
            List<Doctor> doctors = queryDoctor(dept.getDepartmentCode());
            _result.addAll(doctors);
        }

        // 按照字典排序
        Collections.sort(_result);

        // 放入缓存
        DataCacheUtil.putData(DataCacheUtil.CacheKey.ALL_DOCTORS_KEY, _result);

        return _result;
    }


    /**
     * 通过医生编码获取唯一医生信息
     *
     * @param departmentCode 科室编码
     * @param doctorCode     医生编码
     * @return
     * @throws TradeErrorException
     */
    @Override
    public Doctor queryDoctorByCode(String departmentCode, String doctorCode) throws TradeErrorException {
        List<Doctor> deptDoctors = queryDoctor(departmentCode);
        if (deptDoctors != null && deptDoctors.size() > 0) {
            for (Doctor doctor : deptDoctors) {
                if (doctor.getDoctorCode().equals(doctorCode)) {
                    return doctor;
                }
            }
        }
        return null;
    }

    /**
     * 根据请求信息获取医生信息
     *
     * @throws TradeErrorException
     */
    public List<Doctor> queryDoctor(QueryDoctorRequest request) throws TradeErrorException {
        // 将对象转换为接口需要的xml字符串格式并请求数据
        String requestXML = ObjectTransUtil.beanToXMLString(request);
        String doctors = pub0008Soap.hipMessageServer(GlobalConstant.FIRST_PARAMS, requestXML);
        if (logger.isInfoEnabled()) {
            logger.info("request msg is [" + requestXML + "] and response msg is [" + doctors + "]");
        }
        return ServiceHelper.parseXmlToDoctor(doctors);
    }

}
