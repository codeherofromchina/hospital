package com.hospital.tools;

import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.thoughtworks.xstream.XStream;

public class ObjectTransUtil {
	private static Logger logger = Logger.getLogger(ObjectTransUtil.class);

	/**
	 * 将对象转换为XML字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String beanToXMLString(Object bean)
			throws NullPointerException {
		if (bean == null) {
			throw new NullPointerException("请求参数转换错误");
		}

		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);
		return xstream.toXML(bean);

		/*
		 * 测试代码 QueryDoctorRequest qdRequest = new QueryDoctorRequest();
		 * qdRequest.setExtOrgCode("extOrgCode");
		 * qdRequest.setExtUserID("extUserID");
		 * qdRequest.setClientType(ClientType.ATM.getCode());
		 * 
		 * qdRequest.setHospitalId("hospitalId");
		 * qdRequest.setDepartmentCode("13");
		 * 
		 * String xmlRequestStr = beanToXMLString(qdRequest);
		 * System.out.println(xmlRequestStr);
		 */
	}

	
	/**
	 * 将xml字符串转换为java对象
	 * 
	 * @param xmlString
	 * @return
	 */
	public static JSONObject xmlStringToBean(String xmlString) {
		// 声明返回结果
		JSONObject _result  = null;
		try {
			
			Document document = DocumentHelper.parseText(xmlString);
			Element root = document.getRootElement();
			_result = (JSONObject)parseElement(root);
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return _result;
	}
	
	/*
	 * 递归调用处理xml中节点元素
	 */
	private static JSON parseElement(Element ele){
		JSONObject jsonObject = new JSONObject();
		String parentName = ele.getName();
		List<Element> elements = ele.elements();
		
		if(elements.size() > 0 ){
			for(Element e:elements){
				String eName = e.getName();
				if(jsonObject.containsKey(eName)){
					JSONArray jsonArray ;
					Object object = jsonObject.get(eName);
					if(object instanceof JSONArray){
						jsonArray = (JSONArray)object;
					}else{
						jsonArray = new JSONArray();
						jsonArray.add(object);
					}
					JSON parseElement = parseElement(e);
					jsonArray.add(parseElement);
					jsonObject.put(eName, jsonArray);
				}else{
					JSON parseElement = parseElement(e);
					if(parseElement == null){
						jsonObject.put(eName, e.getTextTrim());
					}else{
						jsonObject.put(eName, parseElement);
					}
				}
			}
		}else{
			return null;
		}
		
		return jsonObject;
	}
	
	
	public static void main(String[] args) {
		
		
		String departmentsXml = "<Response>"
		+ "<ResultCode>0</ResultCode>"
		+ "<ResultContent></ResultContent>"
		+ "<RecordCount></RecordCount>"
		+ "<Departments>"
		+ "<Department>"
		+ "<DepartmentCode>1</DepartmentCode>"
		+ "<DepartmentName>aaa</DepartmentName>"
		+ "<DepartmentGroup>Y</DepartmentGroup>"
		+ "</Department>"
		+ "<Department>"
		+ "<DepartmentCode>2</DepartmentCode>"
		+ "<DepartmentName>bbb</DepartmentName>"
		+ "<DepartmentGroup></DepartmentGroup>"
		+ "</Department>"
		+ "</Departments>"
		+ "</Response>";
		JSONObject xmlStringToBean = xmlStringToBean(departmentsXml);
		System.out.println(xmlStringToBean);
		
	}

}
