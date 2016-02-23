package com.hospital.tools;

public class StringUtil {
	/**
	 * 将给定的字符串第一个字母设置为大写
	 * 
	 * @param str
	 * @return
	 */
	public static String UpperFirstChar(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * 将给定的字符串第一个字母设置为小写
	 * 
	 * @param str
	 * @return
	 */
	public static String LowerFirstChar(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

}
