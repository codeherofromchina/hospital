package com.hospital.tools;

import java.lang.reflect.Method;
import java.util.*;

import org.apache.log4j.Logger;

import com.hospital.exception.TradeErrorException;
import com.hospital.pojo.Department;
import com.hospital.pojo.Doctor;
import com.hospital.pojo.Order;
import com.hospital.pojo.Patient;
import com.hospital.pojo.Schedule;
import com.hospital.pojo.enum_.ResultCode;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 服务层帮助类，将服务类中接口调用返回的字符串转换为响应的对象
 *
 * @author wxd
 */
public class ServiceHelper {
    private static Logger logger = Logger.getLogger(ServiceHelper.class);

    /**
     * 将病人信息xml字符串转换为病人实体对象
     *
     * @param patInfoXml
     * @return
     * @throws TradeErrorException
     */
    public static Patient parseXmlToPatient(String patInfoXml) throws TradeErrorException {

        JSONObject mapObj = ObjectTransUtil.xmlStringToBean(patInfoXml);
        isTradeSuccess(mapObj);
        JSONObject patInfos = mapObj.getJSONObject("PatInfos");
        JSONObject patInfo = patInfos.getJSONObject("PatInfo");

        Patient patient = new Patient();
        Class<Patient> pClass = Patient.class;

        reflectSetStringValue(patient, patInfo, pClass);

        return patient;

        // 测试信息
       /* String xmlStr = "<Response><ResultCode>0</ResultCode><ResultContent></ResultContent><PatInfos><PatInfo><PatientID>0000000016</PatientID>" +
                "<PatientName>mic16</PatientName><Sex>女</Sex><SexCode>2</SexCode><DOB>1996-06-22</DOB><TelephoneNo>12345678901</TelephoneNo>" +
                "<Mobile/><DocumentID/><Address/><IDTypeCode>1</IDTypeCode><IDTypeDesc/><IDNo/><InsureCardNo/>" +
                "<AccInfo>-201^^^0^0^0^^16^0000000016^44120^P^PC^1^^-201^^^0^0^0^^16^0000000016^44120^P^PC^1^</AccInfo><AccInfoBalance/>" +
                "<AccInfoNo/><PatientCard>000000000016</PatientCard><YBFlag>0</YBFlag><PatType>自费</PatType><PatTypeCode>01</PatTypeCode>" +
                "</PatInfo></PatInfos></Response>";
        Patient patient = parseXmlToPatient(xmlStr);
        System.out.println(patient);*/
    }


    /**
     * 将给定字符串转换为科室信息列表
     *
     * @param departmentsXml
     * @return
     * @throws TradeErrorException
     */
    public static List<Department> parseXmlToDepartments(String departmentsXml) throws TradeErrorException {
        JSONObject tradeMap = ObjectTransUtil.xmlStringToBean(departmentsXml);
        isTradeSuccess(tradeMap);

        List<Department> _result = new ArrayList<Department>();
        int recordCount = tradeMap.getInt("RecordCount");
        if (recordCount > 0) {
            JSONObject departments = tradeMap.getJSONObject("Departments");
            JSONArray departmentList = null;
            if (recordCount == 1) {
                departmentList = new JSONArray();
                departmentList.add(departments.getJSONObject("Department"));
            } else {
                departmentList = departments.getJSONArray("Department");
            }

            for (int i = 0; i < departmentList.size(); ++i) {
                JSONObject jsonObject = departmentList.getJSONObject(i);

                Department department = new Department();
                // 科室代码
                String departmentCode = jsonObject.getString("DepartmentCode");
                department.setDepartmentCode(departmentCode);
                // 科室名称
                String departmentName = jsonObject.getString("DepartmentName");
                department.setDepartmentName(departmentName);
                //科室组标志
                if (jsonObject.containsKey("DepartmentGroup")) {
                    String departmentGroup = jsonObject.getString("DepartmentGroup");
                    department.setDepartmentGroup(departmentGroup);
                }
                // 科室简介
                if (jsonObject.containsKey("Description")) {
                    String description = jsonObject.getString("Description");
                    department.setDescription(description);
                }
                // 科室地理位置
                if (jsonObject.containsKey("DepartmentAddress")) {
                    String departmentAddress = jsonObject.getString("DepartmentAddress");
                    department.setDepartmentAddress(departmentAddress);
                }
                // 挂号年龄限制
                if (jsonObject.containsKey("DepartmentAgeLimit")) {
                    String departmentAgeLimit = jsonObject.getString("DepartmentAgeLimit");
                    department.setDepartmentAgeLimit(departmentAgeLimit);
                }

                _result.add(department);
            }
        }

        return _result;

        // 测试代码
        /*
         * String departmentsXml = "<Response>" + "<ResultCode>0</ResultCode>" +
         * "<ResultContent></ResultContent>" + "<RecordCount>2</RecordCount>" +
         * "<Departments>" + "<Department>" +
         * "<DepartmentCode>1</DepartmentCode>" +
         * "<DepartmentName>aaa</DepartmentName>" +
         * "<DepartmentGroup>Y</DepartmentGroup>" + "</Department>" +
         * "<Department>" + "<DepartmentCode>2</DepartmentCode>" +
         * "<DepartmentName>bbb</DepartmentName>" +
         * "<DepartmentGroup></DepartmentGroup>" + "</Department>" +
         * "</Departments>" + "</Response>"; List<Department> departments =
         * parseXmlToDepartments(departmentsXml); for(Department d:departments){
         * System.out.println(d); }
         */
    }


    /**
     * 将xml字符串转换为医生实体列表
     *
     * @param doctorsXml
     * @return
     */
    public static List<Doctor> parseXmlToDoctor(String doctorsXml) throws TradeErrorException {
        JSONObject doctorsJsonObject = ObjectTransUtil.xmlStringToBean(doctorsXml);
        isTradeSuccess(doctorsJsonObject);

        List<Doctor> _result = new ArrayList<Doctor>();
        int recordCount = doctorsJsonObject.getInt("RecordCount");
        if (recordCount > 0) {
            JSONObject doctors = doctorsJsonObject.getJSONObject("Doctors");
            JSONArray doctorList = null;
            if (recordCount == 1) {
                doctorList = new JSONArray();
                doctorList.add(doctors.getJSONObject("Doctor"));
            } else {
                doctorList = doctors.getJSONArray("Doctor");
            }

            for (int i = 0; i < doctorList.size(); ++i) {
                JSONObject jsonObject = doctorList.getJSONObject(i);

                Doctor doctor = new Doctor();

                String doctorCode = jsonObject.getString("DoctorCode");
                String doctorName = jsonObject.getString("DoctorName");
                String doctotLevelCode = jsonObject.getString("DoctotLevelCode");
                String doctorLevel = jsonObject.getString("DoctorLevel");
                String deptId = jsonObject.getString("DeptId");
                String deptName = jsonObject.getString("DeptName");
//                String description = jsonObject.getString("Description");
                doctor.setDoctorCode(doctorCode);
                doctor.setDoctorName(doctorName);
                doctor.setDoctorTitleCode(doctotLevelCode);
                doctor.setDoctorTitle(doctorLevel);
                doctor.setDepartmentCode(deptId);
                doctor.setDepartmentName(deptName);
//                doctor.setDescription(description);

                _result.add(doctor);
            }
        }

        return _result;

        // 測試代碼
		/*String xmlStr = "<Response>"
				+ "<ResultCode>0</ResultCode>"
				+ "<ResultContent></ResultContent>"
				+ "<RecordCount>2</RecordCount>"
				+ "<Doctors>"
				+ "<Doctor>"
				+ "<DoctorCode>001</DoctorCode>"
				+ "<DoctorName>wxd</DoctorName>"
				+ "</Doctor>"
				+ "<Doctor>"
				+ "<DoctorCode>002</DoctorCode>"
				+ "<DoctorName>bjn</DoctorName>"
				+ "</Doctor>"
				+ "</Doctors>"
				+ "</Response>";

		List<Doctor> doctors = parseXmlToDoctor(xmlStr);
		for (Doctor dt : doctors) {
			System.out.println(dt);
		}*/
    }


    /**
     * 将xml字符串转换为医生实体列表
     *
     * @param schedulesXml
     * @return
     */
    public static List<Schedule> parseXmlToSchedules(String schedulesXml) throws TradeErrorException {
        JSONObject schedulesJsonObject = ObjectTransUtil.xmlStringToBean(schedulesXml);
        isTradeSuccess(schedulesJsonObject);

        List<Schedule> _result = new ArrayList<Schedule>();
        int RecordCount = schedulesJsonObject.getInt("RecordCount");
        if (RecordCount > 0) {
            JSONObject schedules = schedulesJsonObject.getJSONObject("Schedules");
            JSONArray scheduleArr = null;
            if (RecordCount == 1) {
                scheduleArr = new JSONArray();
                scheduleArr.add(schedules.getJSONObject("Schedule"));
            } else {
                scheduleArr = schedules.getJSONArray("Schedule");
            }

            Class<Schedule> sClass = Schedule.class;
            for (int i = 0; i < scheduleArr.size(); ++i) {
                JSONObject jsonObject = scheduleArr.getJSONObject(i);

                Schedule schedule = new Schedule();

                reflectSetStringValue(schedule, jsonObject, sClass);

                _result.add(schedule);
            }
        }

        return _result;

        // 测试代码
		/*String xmlStr = "<Response>"
				+ "<ResultCode>0</ResultCode>"
				+ "<ResultContent></ResultContent>"
				+ "<RecordCount>2</RecordCount>"
				+ "<Schedules>"
				+ "<Schedule>"
				+ "<ScheduleItemCode>111</ScheduleItemCode>"
				+ "<ServiceDate>222</ServiceDate>"
				+ "<WeekDay>333</WeekDay>"
				+ "<SessionCode>S</SessionCode>"
				+ "<SessionName>上午</SessionName>"
				+ "<StartTime>444</StartTime>"
				+ "<EndTime>555</EndTime>"
				+ "<DepartmentCode>666</DepartmentCode>"
				+ "<DepartmentName>777</DepartmentName>"
				+ "<ClinicRoomCode>888</ClinicRoomCode>"
				+ "<ClinicRoomName>999</ClinicRoomName>"
				+ "<DoctorCode>000</DoctorCode>"
				+ "<DoctorName>aaa</DoctorName>"
				+ "<DoctorTitleCode>bbb</DoctorTitleCode>"
				+ "<DoctorTitle>ccc</DoctorTitle>"
				+ "<DoctorSpec>ddd</DoctorSpec>"
				+ "<DoctorSessTypeCode>eee</DoctorSessTypeCode>"
				+ "<DoctorSessType>fff</DoctorSessType>"
				+ "<ServiceCode>ggg</ServiceCode>"
				+ "<ServiceName>hhh</ServiceName>"
				+ "<Fee>iii</Fee>"
				+ "<RegFee>jjj</RegFee>"
				+ "<CheckupFee>kkk</CheckupFee>"
				+ "<ServiceFee>lll</ServiceFee>"
				+ "<OtherFee>mmm</OtherFee>"
				+ "<AvailableNum>nnn</AvailableNum>"
				+ "<AdmitAddress>ooo</AdmitAddress>"
				+ "<AdmitTimeRange>ppp </AdmitTimeRange>"
				+ "<Note>qqq</Note>"
				+ "</Schedule>"
				+ "<Schedule>"
				+ "<ScheduleItemCode>111</ScheduleItemCode>"
				+ "<ServiceDate>222</ServiceDate>"
				+ "<WeekDay>333</WeekDay>"
				+ "<SessionCode>S</SessionCode>"
				+ "<SessionName>上午</SessionName>"
				+ "<StartTime>444</StartTime>"
				+ "<EndTime>555</EndTime>"
				+ "<DepartmentCode>666</DepartmentCode>"
				+ "<DepartmentName>777</DepartmentName>"
				+ "<ClinicRoomCode>888</ClinicRoomCode>"
				+ "<ClinicRoomName>999</ClinicRoomName>"
				+ "<DoctorCode>000</DoctorCode>"
				+ "<DoctorName>aaa</DoctorName>"
				+ "<DoctorTitleCode>bbb</DoctorTitleCode>"
				+ "<DoctorTitle>ccc</DoctorTitle>"
				+ "<DoctorSpec>ddd</DoctorSpec>"
				+ "<DoctorSessTypeCode>eee</DoctorSessTypeCode>"
				+ "<DoctorSessType>fff</DoctorSessType>"
				+ "<ServiceCode>ggg</ServiceCode>"
				+ "<ServiceName>hhh</ServiceName>"
				+ "<Fee>iii</Fee>"
				+ "<RegFee>jjj</RegFee>"
				+ "<CheckupFee>kkk</CheckupFee>"
				+ "<ServiceFee>lll</ServiceFee>"
				+ "<OtherFee>mmm</OtherFee>"
				+ "<AvailableNum>nnn</AvailableNum>"
				+ "<AdmitAddress>ooo</AdmitAddress>"
				+ "<AdmitTimeRange>ppp </AdmitTimeRange>"
				+ "<Note>qqq</Note>"
				+ "</Schedule>"
				+ "</Schedules>"
				+ "</Response>";

		List<Schedule> doctors = parseXmlToSchedules(xmlStr);
		for (Schedule dt : doctors) {
			System.out.println(dt);
		}*/
    }


    /**
     * 将xml信息转换为订单实体列表信息
     *
     * @param orderListXml
     * @return
     */
    public static List<Order> parseXmlToOrders(String orderListXml) throws TradeErrorException {
        JSONObject ordersJsonObject = ObjectTransUtil.xmlStringToBean(orderListXml);
        isTradeSuccess(ordersJsonObject);

        List<Order> _result = new ArrayList<Order>();
        int recordCount = ordersJsonObject.getInt("RecordCount");
        if (recordCount > 0) {
            JSONObject orders = ordersJsonObject.getJSONObject("Orders");
            JSONArray ordersArr = null;
            if (recordCount == 1) {
                ordersArr = new JSONArray();
                ordersArr.add(orders.getJSONObject("Order"));
            } else {
                ordersArr = orders.getJSONArray("Order");
            }
            Set<String> orderCodeSet = new HashSet<String>();
            Class<Order> oClass = Order.class;
            for (int i = 0; i < ordersArr.size(); ++i) {
                JSONObject jsonObject = ordersArr.getJSONObject(i);

                Order order = new Order();

                reflectSetStringValue(order, jsonObject, oClass);
                String orderCode = order.getOrderCode();
                if (!orderCodeSet.contains(orderCode)) {
                    orderCodeSet.add(orderCode);
                    _result.add(order);
                }
            }
        }

        return _result;

        // 测试代码
		/*String xmlStr = "<Response>"
				+ "<ResultCode>0</ResultCode>"
				+ "<ResultContent></ResultContent>"
				+ "<RecordCount>2</RecordCount>"
				+ "<Orders>"
				+ "<Order>"
				+ "<OrderCode>11</OrderCode>"
				+ "<OrderApptDate>22</OrderApptDate>"
				+ "<OrderStatus>33</OrderStatus>"
				+ "<OrderApptUser>44</OrderApptUser>"
				+ "<PatientNo>55</PatientNo>"
				+ "<AdmitDate>66</AdmitDate>"
				+ "<Department>77</Department>"
				+ "<Doctor>88</Doctor>"
				+ "<DoctorTitle>99</DoctorTitle>"
				+ "<RegFee>09</RegFee>"
				+ "<SeqCode>aa</SeqCode>"
				+ "<AdmitAddress>bb</AdmitAddress>"
				+ "<SessionName>cc</SessionName>"
				+ "<OrderContent>dd</OrderContent>"
				+ "<AdmitRange>ee</AdmitRange>"
				+ "<TelePhoneNo>ff</TelePhoneNo>"
				+ "<MobileNo>gg</MobileNo>"
				+ "<AllowRefundFlag>ss</AllowRefundFlag>"
				+ "<PayFlag>ww</PayFlag>"
				+ "<HospitalName>qq</HospitalName>"
				+ "<ServiceName>rr</ServiceName>"
				+ "</Order>"
				+ "<Order>"
				+ "<OrderCode>qe</OrderCode>"
				+ "<OrderApptDate>er</OrderApptDate>"
				+ "<OrderStatus>2e</OrderStatus>"
				+ "<OrderApptUser>4e</OrderApptUser>"
				+ "<PatientNo>5r</PatientNo>"
				+ "<AdmitDate>1q</AdmitDate>"
				+ "<Department>6e</Department>"
				+ "<Doctor>er</Doctor>"
				+ "<DoctorTitle>zz</DoctorTitle>"
				+ "<RegFee>dd</RegFee>"
				+ "<SeqCode>tt</SeqCode>"
				+ "<AdmitAddress>yy</AdmitAddress>"
				+ "<SessionName>xx</SessionName>"
				+ "<OrderContent>cc</OrderContent>"
				+ "<AdmitRange>mm</AdmitRange>"
				+ "<TelePhoneNo>nn</TelePhoneNo>"
				+ "<MobileNo>ii</MobileNo>"
				+ "<AllowRefundFlag>uui</AllowRefundFlag>"
				+ "<PayFlag>oo</PayFlag>"
				+ "<HospitalName>pp</HospitalName>"
				+ "<ServiceName>ca</ServiceName>"
				+ "</Order>"
				+ "</Orders>"
				+ "</Response>";
		
		
		List<Order> orderList = parseXmlToOrders(xmlStr);
		for(Order o:orderList){
			System.out.println(o.toString());
		}*/
    }


    /**
     * 将xml信息转换为订单实体信息
     *
     * @param orderXml
     * @return
     */
    public static Order parseXmlToOrder(String orderXml) throws TradeErrorException {
        JSONObject orderJsonObject = ObjectTransUtil.xmlStringToBean(orderXml);
        isTradeSuccess(orderJsonObject);

        Order _result = new Order();
        reflectSetStringValue(_result, orderJsonObject, Order.class);
        return _result;

        // 测试代码
		/*String orderXml = "<Response>"
				+ "<ResultCode>0</ResultCode>"
				+ "<ResultContent></ResultContent>"
				+ "<SeqCode>111</SeqCode>"
				+ "<RegFee>222</RegFee>"
				+ "<AdmitRange>333</AdmitRange>"
				+ "<AdmitAddress>444</AdmitAddress>"
				+ "<TransactionId>555</TransactionId>"
				+ "</Response>";
		
		Order order = parseXmlToOrder(orderXml);
		System.out.println(order.toString());*/
    }

    /**
     * 判断返回的xml是否是成功的交易结果
     *
     * @param resultXml
     * @return
     * @throws TradeErrorException
     */
    public static boolean isSuccessTradeResult(String resultXml) throws TradeErrorException {
        JSONObject resultJsonObject = ObjectTransUtil.xmlStringToBean(resultXml);
        isTradeSuccess(resultJsonObject);

        return true;
    }

    /*
     * 判断此次请求是否产生正确的结果
     */
    private static void isTradeSuccess(Map<String, Object> tradeMap) throws TradeErrorException {
        if (tradeMap == null) {
            throw new TradeErrorException("需要正确格式的xml内容");
        }
        if (!ResultCode.getResultCode(String.valueOf(tradeMap.get("ResultCode"))).getResult()) {
            throw new TradeErrorException(String.valueOf(tradeMap.get("ResultContent")));
        }
    }


    /*
     * 利用反射设置对象的set值
     * @param obj	要设值的对象
     * @param jsonObject  json对象
     * @param clazz	设值的对象类型
     */
    public static void reflectSetStringValue(Object obj, JSONObject jsonObject, Class clazz) {
        Set keySet = jsonObject.keySet();
        Iterator keys = keySet.iterator();

        while (keys.hasNext()) {
            String next = (String) keys.next();
            String value = jsonObject.getString(next);
            if (value != null) {
                try {
                    Method method = clazz.getMethod("set" + next, String.class);
                    method.invoke(obj, value);
                } catch (Exception e) {
                    logger.warn(e.getMessage());
                }
            }

        }
    }

}
