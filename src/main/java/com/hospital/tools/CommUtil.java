package com.hospital.tools;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class CommUtil {

	public static String getURL(HttpServletRequest request) {
		String contextPath = request.getContextPath().equals("/") ? ""
				: request.getContextPath();
		String url = "http://" + request.getServerName();
		if (null2Int(Integer.valueOf(request.getServerPort())) != 80) {
			url = url + ":"
					+ null2Int(Integer.valueOf(request.getServerPort()))
					+ contextPath;
		} else {
			url = url + contextPath;
		}
		return url;
	}

	public static int null2Int(Object s) {
		int v = 0;
		if (s != null) {
			try {
				v = Integer.parseInt(s.toString());
			} catch (Exception localException) {
			}
		}
		return v;
	}

	/**
	 * 随机生成n位随机字母和数字组合码
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random(System.currentTimeMillis());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	
	
	/*
	 * 根据盐值和密码本身生成md5
	 */
	public static String md5Password(String salt, String pwd) {
		return MD5Tools.MD5(salt + "_" + pwd);
	}
	
	public static void main(String[] args) {
		System.out.println(md5Password("wangxiaodan","123456"));
	}
}
