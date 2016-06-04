package com.hospital.tools;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.hospital.pojo.Department;

import net.sourceforge.pinyin4j.PinyinHelper;

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
	
	
	/**
	 * 排序科室根据科室名称
	 * @param list
	 */
	public static void sortDeptByDeptName(List<Department> list){
		
		
	}
	
	/**
	 * 排序汉子
	 * @param list
	 */
	public static void sortChineseStrList(List<String> list){
		// 按照拼音排序
		Collections.sort(list, new Comparator<String>(){
			public int compare(String o1, String o2) {
				return compareChineseStr(o1,o2);
			}
		});
	}
	
	
	/**
	 * 比较汉子字符串，根据拼音按照字典排序
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static int compareChineseStr(String s1,String s2){
		if(s1 != null && s2!=null){
			int i = 0;
			while(s1.length() >i && s2.length() > i ){
				 int cp2 = compareChineseChar(s1.charAt(i),s2.charAt(i));
				 if(cp2!=0){
					 return cp2;
				 }else{
					 i++;
				 }
			}
			return  s2.length() - s1.length();
		}else if(s2!=null){
			return 1;
		}else if(s1 == null){
			return 0;
		}else{
			return -1;
		}
	}
	
	/**
	 * 比较具体的每个字节的排序
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static int compareChineseChar(char c1,char c2){
		// 将特殊的字符一、二、三、四、五排序顺序准备好
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		map.put('一', 1);
		map.put('二', 2);
		map.put('三', 3);
		map.put('四', 4);
		map.put('五', 5);
		
		// 如果两个字节相同则直接返回相同
		if(c1==c2){
			return 0;
		}
		
		// 然后比较特殊字符，如果存在特殊字符，则排序，否则特殊字符靠后排列
		if(map.containsKey(c1) && map.containsKey(c2)){
			return map.get(c1) - map.get(c2);
		}else if(map.containsKey(c1) ){
			return 1;
		}else if(map.containsKey(c2)){
			return -1;
		}
		
		// 按照正常拼音排序
		String[] pyArr01 = PinyinHelper.toHanyuPinyinStringArray(c1);
		String[] pyArr02 = PinyinHelper.toHanyuPinyinStringArray(c2);
		// 拼音转换都正常则按照拼音排序，如果转换不正常，说明不是中文，则往后放
		if(pyArr01 != null && pyArr02!=null){
			// 拼音转换都正常
			return pyArr01[0].compareToIgnoreCase(pyArr02[0]);
		}else if(pyArr02!=null){
			return 1;
		}else if(pyArr01 == null){
			return c1 > c2? -1:1;
		}else{
			return -1;
		}
	}
}
