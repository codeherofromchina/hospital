package com.hospital.service.remoteImpl;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Patient;
import com.hospital.pojo.request.GetPatInfoRequest;
import com.hospital.pojo.stub.PUB0008Soap;
import com.hospital.service.PatientService;
import com.hospital.tools.GlobalConstant;
import com.hospital.tools.ObjectTransUtil;
import com.hospital.tools.ServiceHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 病人服务接口实现类
 *
 * @author wxd
 */
@Service("defaultPatientService")
public class PatientServiceImpl implements PatientService {
    private final Logger logger = Logger.getLogger(getClass());
    /**
     * 此类是webService操作类
     */
    @Resource(name = "pub0008Soap")
    private PUB0008Soap pub0008Soap;

    public Patient getPatInfo(GetPatInfoRequest request) throws TradeErrorException {
        // 将对象转换为接口需要的xml字符串格式
        String requestXML = ObjectTransUtil.beanToXMLString(request);

        String patInfoXml = pub0008Soap.hipMessageServer(GlobalConstant.FIRST_PARAMS, requestXML);
        if (logger.isInfoEnabled()) {
            logger.info("request msg is [" + requestXML + "] and response msg is [" + patInfoXml + "]");
        }
        return ServiceHelper.parseXmlToPatient(patInfoXml);
    }

    /**
     * 通过就诊卡号获取患者信息
     */
    @Override
    public Patient getPatInfoByCardNo(String cardNo) throws TradeErrorException {
        GetPatInfoRequest request = new GetPatInfoRequest();
        request.setPatientCard(cardNo);

        return getPatInfo(request);
    }

}
