package com.hospital.service.remoteImpl;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Department;
import com.hospital.pojo.request.QueryDepartmentGroupRequest;
import com.hospital.pojo.request.QueryDepartmentRequest;
import com.hospital.pojo.stub.PUB0008Soap;
import com.hospital.service.DepartmentService;
import com.hospital.tools.DataCacheUtil;
import com.hospital.tools.GlobalConstant;
import com.hospital.tools.ObjectTransUtil;
import com.hospital.tools.ServiceHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author wxd
 */
@Service("defaultDepartmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {
    private final Logger logger = Logger.getLogger(getClass());
    @Resource(name = "pub0008Soap")
    private PUB0008Soap pub0008Soap;

    /**
     * 直接获取所有二级科室，此医院没有一级科室
     */
    public List<Department> queryAllDepartments() throws TradeErrorException {
        // 先从缓存中获取缓存数据，如果不存在，则查询并放入缓存供下次使用
        List<Department> allDepts = DataCacheUtil.getData(DataCacheUtil.CacheKey.ALL_DEPARTMENT_KEY, Department.class);
        if (allDepts != null) {
            return allDepts;
        }
        // 远程查询
        allDepts = queryDepartment(new QueryDepartmentRequest());
        // 排序
        if (allDepts != null) {
            Collections.sort(allDepts);
        }

        // 将远程查询结果放入到缓存中
        DataCacheUtil.putData(DataCacheUtil.CacheKey.ALL_DEPARTMENT_KEY, allDepts);
        return allDepts;
    }

    /**
     * 通过科室编号获取科室信息
     */
    public Department queryByDeptCode(String deptCode) throws TradeErrorException {
        Department department = null;
        if (StringUtils.isNotEmpty(deptCode)) {
            // 获取所有科室信息，并从所有中筛选正确的科室
            List<Department> allDepts = queryAllDepartments();
            if (allDepts != null && allDepts.size() > 0) {
                for (Department d : allDepts) {
                    if (d.getDepartmentCode().equals(deptCode)) {
                        department = d;
                        break;
                    }
                }
            }
        }

        return department;
    }

    /**
     * 获取一级科室信息列表
     */
    @Deprecated
    public List<Department> queryDepartmentGroup(
            QueryDepartmentGroupRequest request) throws TradeErrorException {
        // 将对象转换为接口需要的xml字符串格式并请求数据
        String requestXML = ObjectTransUtil.beanToXMLString(request);
        String departmentsXml = pub0008Soap.hipMessageServer(GlobalConstant.FIRST_PARAMS, requestXML);
        if (logger.isInfoEnabled()) {
            logger.info("request msg is [" + requestXML + "] and response msg is [" + departmentsXml + "]");
        }

        return ServiceHelper.parseXmlToDepartments(departmentsXml);
    }

    /**
     * 获取二级科室信息列表
     */
    public List<Department> queryDepartment(QueryDepartmentRequest request)
            throws TradeErrorException {
        // 将对象转换为接口需要的xml字符串格式并请求数据
        String requestXML = ObjectTransUtil.beanToXMLString(request);
        String departmentsXml = pub0008Soap.hipMessageServer(GlobalConstant.FIRST_PARAMS, requestXML);
        if (logger.isInfoEnabled()) {
            logger.info("request msg is [" + requestXML + "] and response msg is [" + departmentsXml + "]");
        }
        return ServiceHelper.parseXmlToDepartments(departmentsXml);
    }

}
