package com.hospital.action.base;

import java.io.File;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({"serial","rawtypes"})
public class BaseActionSupport extends ActionSupport implements SessionAware{


	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map session;

	public BaseActionSupport() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
	}
	

	/**
	 * 输出普通文本到页面
	 * 
	 * @param content
	 *            输出内容
	 * @throws Exception
	 */
	protected void printWriterToPage(String content) throws Exception {
		this.printWriterToPage(content, null);
	}

	/**
	 * 输出json内容到页面
	 * 
	 * @param content
	 *            要输出的JSON串
	 * @throws Exception
	 */
	protected void printWriterJsonToPage(String content) throws Exception {
		this.printWriterToPage(content, "acontenttion/json");
	}

	/**
	 * 输出xml内容到页面
	 * 
	 * @param content
	 *            XML串
	 * @throws Exception
	 */
	protected void printWriterXMLToPage(String content) throws Exception {
		this.printWriterToPage(content, "text/xml");
	}

	/**
	 * 向页面输出内容
	 * 
	 * @param content
	 *            要输出的内容字符串
	 * @param contentType
	 *            输出格式
	 * @throws Exception
	 */
	protected void printWriterToPage(String content, String contentType)
			throws Exception {
		try {
			// "application/json"
			// ".txt"="text/plain"
			// "text/xml"
			if (contentType != null && !"".equals(contentType)) {
				response.setContentType(contentType);
			} else {
				response.setContentType("text/plain");
			}
			response.reset();
			response.setCharacterEncoding("UTF-8");
			response.setHeader("pragma", "no-cache");
			response.setHeader("cache-control", "no-cache");
			response.setDateHeader("expires", 0);
			PrintWriter pw = response.getWriter();
			pw.print(content);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
	}

	/**
	 * 获取IP地址
	 * 
	 * @return
	 */
	protected String getIpAddr() {
		String ip = ServletActionContext.getRequest().getHeader(
				"x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	protected String getActionPath(String actionName) {
		String actionPath = "";
		if (actionName != null && !"".equals(actionName)) {
			actionPath = actionName;
		}
		actionPath += "?temp=void";
		Map<String, String[]> valuesMap = request.getParameterMap();
		if (valuesMap != null) {
			Set<String> keySet = valuesMap.keySet();
			for (String key : keySet) {
				for (String value : valuesMap.get(key)) {
					try {
						actionPath += "&" + key + "="
								+ URLEncoder.encode(value, "utf-8");
					} catch (Exception e) {
					}
				}
			}
		}
		return actionPath;
	}

	protected String getActionParameter() {
		String parameter = "?temp=void";
		Map<String, String[]> valuesMap = request.getParameterMap();
		if (valuesMap != null) {
			Set<String> keySet = valuesMap.keySet();
			for (String key : keySet) {
				for (String value : valuesMap.get(key)) {
					try {
						parameter += "&" + key + "="
								+ URLEncoder.encode(value, "utf-8");
					} catch (Exception e) {
					}
				}
			}
		}
		return parameter;
	}

	protected void downloadFileByString(String fileFullName, String content)
			throws Exception {
		// 设置输出的格式
		response.reset();
		response.setContentType("application/x-msdownload");
		response.setContentType("text/html; charset=UTF-8");
		response.addHeader("Content-Disposition", "attachment; filename="
				+ new String(fileFullName.getBytes("gbk"), "iso-8859-1"));
		response.getOutputStream().write(content.getBytes());
		response.getOutputStream().flush();
	}

	protected void downloadFile(String fileFullName, File file)
			throws Exception {
		// 设置输出的格式
		response.reset();
		response.setContentType("application/x-msdownload");
		response.setContentType("text/html; charset=UTF-8");
		response.addHeader("Content-Disposition", "attachment; filename="
				+ new String(fileFullName.getBytes("gbk"), "iso-8859-1"));
		response.getOutputStream().write(FileUtils.readFileToByteArray(file));
		response.getOutputStream().flush();
	}

	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}



	public void setSession(Map map) {
		this.session= map;
	}
}
