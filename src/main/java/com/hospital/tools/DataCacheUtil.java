package com.hospital.tools;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 缓存数据，用于减少接口查询次数
 * 1.包括所有医生列表信息
 * 2.包括所有科室信息列表信息
 * @author wxd
 *
 */
public class DataCacheUtil {
	// 缓存的数据
	private static Map<CacheKey, Object> cacheData = new HashMap<CacheKey, Object>();
	
	/**
	 * 获取缓存数据
	 * @param key
	 * @return
	 */
	public synchronized static Object getData(CacheKey key){
		return cacheData.get(key);
	}
	
	public synchronized static <T> List<T> getData(CacheKey key,Class<T> c){
		return (List<T>)cacheData.get(key);
	}
	
	/**
	 * 清除当前所有缓存数据
	 */
	public synchronized static void clearData(){
		cacheData.clear();
	}
	
	/**
	 * 放置要缓存的数据，如果存在则替换更新
	 * @param key
	 * @param value
	 */
	public synchronized static void putData(CacheKey key,Object value){
		cacheData.put(key, value);
	}
	
	/**
	 * 缓存中存放的数据的键
	 * ALL_DOCTORS_KEY -- 所有医生缓存的键
	 * ALL_DEPARTMENT_KEY -- 所有科室数据缓存的键
	 * @author wxd
	 *
	 */
	public static enum CacheKey{
		ALL_DOCTORS_KEY("all_doctor"),ALL_DEPARTMENT_KEY("all_department");
		
		private String key ;
		public String getKey() {
			return key;
		}
		private CacheKey(String key){
			this.key = key;
		}
	}
	
	
	/**
	 * 测试数据
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> data = new ArrayList<String>();
		data.add("myData");
		data.add("myGradle");
		DataCacheUtil.putData(DataCacheUtil.CacheKey.ALL_DOCTORS_KEY, data);
		
		List<String> cacheData= DataCacheUtil.getData(DataCacheUtil.CacheKey.ALL_DOCTORS_KEY, String.class);
		
		for(String str:cacheData){
			System.out.println(str);
		}
	}
}
