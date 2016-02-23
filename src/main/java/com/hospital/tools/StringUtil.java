package com.hospital.tools;

public class StringUtil {
	/**
	 * ���������ַ�����һ����ĸ����Ϊ��д
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
	 * ���������ַ�����һ����ĸ����ΪСд
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
